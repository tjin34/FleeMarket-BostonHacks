package com.shinji.fleemarket.UI.Market.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shinji.fleemarket.R;

/**
 * Created by KimuraShin on 17/10/28.
 */

public class PostRecycleAdapter extends RecyclerView.Adapter<PostRecycleAdapter.ViewHolder>{

    public PostRecycleAdapter(Context context) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvUsername;
        TextView tvCategory;
        TextView tvDateline;
        TextView tvPrice1;
        TextView tvPrice2;
        ImageView ivPicture;
        public ViewHolder(View convertView, int type) {
            super(convertView);
            switch (type) {
                case 0:
                    tvUsername = (TextView) convertView.findViewById(R.id.tvSeller);
                    ivPicture = (ImageView) convertView.findViewById(R.id.ivPicture);
                    break;
                case 1:
                    tvUsername = (TextView) convertView.findViewById(R.id.tvRequester);
                    ivPicture = (ImageView) convertView.findViewById(R.id.ivAvatar);
                    break;
            }
            tvName = (TextView) convertView.findViewById(R.id.tvName);
            tvCategory = (TextView) convertView.findViewById(R.id.tvCategory);
            tvDateline = (TextView) convertView.findViewById(R.id.tvDateline);
            tvPrice1 = (TextView) convertView.findViewById(R.id.tvPrice1);
            tvPrice2 = (TextView) convertView.findViewById(R.id.tvPrice2);
        }
    }
}
