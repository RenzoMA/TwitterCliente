package com.android.renzo.twitterclient.images.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.renzo.twitterclient.R;
import com.android.renzo.twitterclient.entities.Image;
import com.android.renzo.twitterclient.lib.base.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HOME on 19/06/2016.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private List<Image> dataset;
    private ImageLoader imageLoader;
    private OnItemClickListener clickListener;

    public ImagesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener) {
        this.dataset = dataset;
        this.imageLoader = imageLoader;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.content_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image imageTweet = dataset.get(position);
        holder.setOnClickListener(imageTweet, clickListener);
        holder.txtTweet.setText(imageTweet.getTweetText());
        holder.txtFavs.setText(String.valueOf(imageTweet.getFavoriteCount()));
        imageLoader.load(holder.imgMedia, imageTweet.getImageURL());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public void setItems(List<Image> newItems){
        dataset.addAll(newItems);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.txtTweet)
        TextView txtTweet;

        @Bind(R.id.imgMedia)
        ImageView imgMedia;

        @Bind(R.id.txtFavs)
        TextView txtFavs;


        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.view = itemView;
        }
        public void setOnClickListener(final Image image, final OnItemClickListener listener){

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(image);
                }
            });

        }
    }
}
