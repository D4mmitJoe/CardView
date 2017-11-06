package com.example.joem.cardview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JoeM on 10/21/2017.
 */

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {
    ArrayList<Email> mData;

    //constructor; needs context if you're going to inflate things (don't need to pass context in this example?)
    public EmailAdapter(ArrayList<Email> mData) {
        this.mData = mData;
    }

    //method for when new viewHolder is created
    //return viewHolder that you create, which is what we need to associate data (with viewHolder?)
    //inflate view here
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflater
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);

        //pass view to viewHolder via the following
        //constructor that needs a view, so we need to inflate something (done above)
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    //method that uses viewHolder and associating it with data (that data comes in through 'EmailAdapter')
    //this method is called when it needs a holder, otherwise it provides you with holder from holder pool
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Email email = mData.get(position);
        holder.textViewSubject.setText(email.subject);
        holder.textViewEmail.setText(email.sender);
        holder.textViewSummary.setText(email.summary);

        //passing reference of data to be used in ViewHolder below
        holder.email = email;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //parameters
        TextView textViewSubject, textViewSummary, textViewEmail;

        //can pass viewHolder references to objects with below code and code in 'onBind' above
        Email email;
        public ViewHolder(View itemView) {
            super(itemView);
            this.email = email;

            //viewHolder that holds references to the following items
            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            textViewSummary = itemView.findViewById(R.id.textViewSummary);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);

            //can edit layout to have a button
            itemView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("demo", "clicked the button " + email.sender);
                }
            });

            //bc you have access to the view you can do whatever you want, such as
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("demo", "clicked " + email.sender);
                }
            });
        }
    }
}
