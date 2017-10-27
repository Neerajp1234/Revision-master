package com.example.android.revision.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.revision.Bean;
import com.example.android.revision.DBSetting;
import com.example.android.revision.DisplayActivity;
import com.example.android.revision.MyAdapter;
import com.example.android.revision.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 10/26/2017.
 */

public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2_layout,container,false);
        Intent intent=new Intent(getActivity(), DisplayActivity.class);
        getActivity().startActivity(intent);
        return view;
    }
}
