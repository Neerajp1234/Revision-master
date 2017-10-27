package com.example.android.revision.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.android.revision.Bean;
import com.example.android.revision.DBSetting;
import com.example.android.revision.R;

/**
 * Created by Android on 10/26/2017.
 */

public class FragmentOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1_layout,container,false);
        final LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.layout);
       final EditText username=(EditText)view.findViewById(R.id.username);
       final EditText password=(EditText)view.findViewById(R.id.password);
        Button submit=(Button)view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bean bean=new Bean();
                bean.setUsername(username.getText().toString());
                bean.setPassword(password.getText().toString());
                DBSetting dbSetting=new DBSetting(getActivity());
               int i= dbSetting.insertData(bean);
                if(i>0)
                {
                    Snackbar.make(linearLayout,"value Successfully submit",Snackbar.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
