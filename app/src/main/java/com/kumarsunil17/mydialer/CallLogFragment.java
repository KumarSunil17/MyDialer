package com.kumarsunil17.mydialer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallLogFragment extends Fragment {
    RecyclerView rv;
    PeopleAdapter a;

    public CallLogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_call_log, container, false);
       DBHelper db=new DBHelper(getActivity());
       List<People> list=db.getData();

       a = new PeopleAdapter(list,getContext());
       rv = v.findViewById(R.id.container_data);
       rv.setAdapter(a);
       rv.setLayoutManager(new LinearLayoutManager(getContext()));
       rv.setHasFixedSize(true);
       return v;
    }
}
