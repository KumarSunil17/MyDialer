package com.kumarsunil17.mydialer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PeopleHolder extends RecyclerView.ViewHolder {
    TextView number, date;
    View v;

    public PeopleHolder(View itemView) {
        super(itemView);
        this.v = itemView;
        this.number = v.findViewById(R.id.call_row_phNum);
        this.date = v.findViewById(R.id.call_row_date);
    }
}
