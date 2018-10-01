package com.kumarsunil17.mydialer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleHolder> {
    List<People> peopleList;
    Context context;

    public PeopleAdapter(List<People> l, Context context) {
        this.peopleList = l;
        this.context = context;
    }

    @NonNull
    @Override
    public PeopleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.logs_list,parent,false);
        return new PeopleHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleHolder holder, int position) {
        People people = peopleList.get(position);
        holder.number.setText(people.getNumber());
        holder.date.setText(people.getDate());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }
}
