package com.nabeel.auxilio;

/**
 * Created by Sailee on 29-03-2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.LinearLayoutManager;
import com.squareup.picasso.Picasso;

public class RecycleList extends RecyclerView.Adapter<RecycleList.ViewHolder> {

    private Colleges college;

    public RecycleList(Colleges college) {
        this.college = college;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(college).inflate(R.layout.list_row1, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int resourceId = college.getResources().getIdentifier("p" + (i + 1), "drawable",
                college.getPackageName());
        Picasso.with(college).load(resourceId).fit().into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void setLayoutManager(LinearLayoutManager linearLayoutManager) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
