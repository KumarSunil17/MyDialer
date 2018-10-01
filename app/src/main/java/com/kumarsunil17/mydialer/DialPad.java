package com.kumarsunil17.mydialer;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DialPad extends Fragment {
    private LinearLayout num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,bkspce,numStar,numHash;
    private FloatingActionButton fab;
    private EditText num;
    String number;

    public DialPad() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dial_pad, container, false);
        num0 = v.findViewById(R.id.num0);
        num1 = v.findViewById(R.id.num1);
        num2 = v.findViewById(R.id.num2);
        num3 = v.findViewById(R.id.num3);
        num4 = v.findViewById(R.id.num4);
        num5 = v.findViewById(R.id.num5);
        num6 = v.findViewById(R.id.num6);
        num7 = v.findViewById(R.id.num7);
        num8 = v.findViewById(R.id.num8);
        num9 = v.findViewById(R.id.num9);
        numStar = v.findViewById(R.id.numStar);
        numHash = v.findViewById(R.id.numHash);
        bkspce = v.findViewById(R.id.backspace);
        fab  = v.findViewById(R.id.callBtn);
        num = v.findViewById(R.id.numberText);
        number = "";

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "0";
                num.setText(number);
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "0";
                num.setText(number);
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "1";
                num.setText(number);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "2";
                num.setText(number);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "3";
                num.setText(number);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "4";
                num.setText(number);
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "5";
                num.setText(number);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "6";
                num.setText(number);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "7";
                num.setText(number);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "8";
                num.setText(number);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "9";
                num.setText(number);
            }
        });
        num0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                number += "+";
                num.setText(number);
                return true;
            }
        });
        numStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "*";
                num.setText(number);
            }
        });
        numHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "#";
                num.setText(number);
            }
        });

        bkspce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = num.getText().toString();
                if(number.length()>0){
                    number = number.substring(0,number.length()-1);
                    num.setText(number);
                }
            }
        });

        bkspce.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                num.setText("");
                number="";
                return true;
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(num.getText())) {
                    Toast.makeText(getContext(), "Number empty", Toast.LENGTH_SHORT).show();
                } else {
                    String phno = num.getText().toString();
                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + phno));
                    //startActivity(i);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    DBHelper db = new DBHelper(getContext());
                    db.insert(phno, dateFormat.format(date));
                }
            }
        });
        num.setText("");
        number = "";
        return v;
    }
}
