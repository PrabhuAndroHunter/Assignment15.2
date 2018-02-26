package com.assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by prabhu on 26/2/18.
 */

public class AndoirdNamesAdapter extends RecyclerView.Adapter <AndoirdNamesAdapter.ViewHolder> {
    private final String TAG = AndoirdNamesAdapter.class.toString();
    private Context context;
    public String[] mAndroidNames;

    public AndoirdNamesAdapter(Context context, String[] androidNames) {
        this.context = context;
        mAndroidNames = androidNames;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_android_name, null);
        ViewHolder viewHolder = new ViewHolder(view);    // create ViewHolder object
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AndoirdNamesAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.mAndroidNameTv.setText(mAndroidNames[position].toString());
        // set on listitem click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                // when this event happen show toast
                Toast.makeText(context, mAndroidNames[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + mAndroidNames.length);
        return mAndroidNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mAndroidNameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mAndroidNameTv = (TextView) itemView.findViewById(R.id.text_view_android_name);
        }
    }
}
