package com.example.android.revision;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Android on 10/26/2017.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyHolder>{
    List<Bean> list;
    LayoutInflater layoutInflater;
    public MyAdapter(List<Bean> list)
    {
        this.list=list;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view=layoutInflater.inflate(R.layout.activity_display,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Bean bean=list.get(position);
       holder.username.setText(bean.getUsername());
        holder.password.setText(bean.getPassword());
    }


    @Override
    public int getItemCount() {
        return 0;
    }
    public class MyHolder extends RecyclerView.ViewHolder
    {
        TextView username,password;

        public MyHolder(View itemView) {
            super(itemView);
            username=(TextView)itemView.findViewById(R.id.username);
            password=(TextView)itemView.findViewById(R.id.password);
        }
    }
}
