package com.korbkenny.kennylab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by KorbBookProReturns on 10/28/16.
 */

public class RVAdapter extends RecyclerView.Adapter<RVHolder>{
    private List<String> mList;
    public RVAdapter(List<String> list){
        mList = list;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new RVHolder(inflater.inflate(R.layout.rv_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.mTextThatShowsUp.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
