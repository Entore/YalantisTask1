package com.example.evgeniy.yalantistask1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Evgeniy on 23.03.2016.
 */
public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mUrl;

    // constructor
    public ImageRecyclerAdapter(Context context, List<String> url) {
        mContext = context;
        mUrl = url;
    }

    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }

    // Create new views
    @Override
    public ImageRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_items, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(ImageRecyclerAdapter.ViewHolder holder, int position) {
        String url = mUrl.get(position);
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.ic_file_download_24dp)
                .error(R.drawable.ic_close_black_24dp)
                .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                .into(holder.mImageView);
    }

    // Return the size of dataset
    @Override
    public int getItemCount() {
        return mUrl.size();
    }

}