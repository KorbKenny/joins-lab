package com.korbkenny.kennylab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by KorbBookProReturns on 10/28/16.
 */

public class RVHolder extends RecyclerView.ViewHolder {
    public TextView mTextThatShowsUp;

    public RVHolder(View itemView) {
        super(itemView);
        mTextThatShowsUp = (TextView)itemView.findViewById(R.id.whateverText);
    }
}
