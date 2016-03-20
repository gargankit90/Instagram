package com.ankitgarg.instagram.ui.popular;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ankitgarg.instagram.R;
import com.ankitgarg.instagram.model.Media;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.lang.Math.min;

/**
 * Created by ankitgarg on 3/18/16.
 */
public class PopularAdapter extends RecyclerView.Adapter<PopularViewHolder>{
    private List<Media> mediaList;
    private Context mContext;
    public PopularAdapter(Context context, List<Media> mediaList) {
        this.mediaList = mediaList;
        this.mContext = context;
    }

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View mediaView = inflater.inflate(R.layout.item_media, parent, false);
        // Return a new holder instance
        PopularViewHolder viewHolder = new PopularViewHolder(mediaView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PopularViewHolder viewHolder, int position) {
        Media media = mediaList.get(position);
        viewHolder.tvUsername.setText(media.getUser().getFull_name());
        viewHolder.tvRelativeTime.setText(media.getUpdatedTime());
        viewHolder.tvLikeCount.setText(media.getUpdatedLikes());

        Picasso.with(mContext).load(media.getImages().getStandardResolution().getUrl())
                .placeholder(R.drawable.ic_placeholder)
                .into(viewHolder.ivPrimaryImage);

        Picasso.with(mContext).load(media.getUser().getProfilePicture()).transform(new RoundedTransformation())
                .into(viewHolder.ivProfilePicture);

        // Caption Stuff
        Spanned captionTxt = media.getUpdatedCaption();
        if(captionTxt != null){
            viewHolder.tvCaption.setVisibility(View.VISIBLE);
            viewHolder.tvCaption.setText(captionTxt);
        }else{
            viewHolder.tvCaption.setVisibility(View.INVISIBLE);
        }
        // Comment count
        viewHolder.tvNumberOfComments.setText(media.getUpdatedNumberOfComments());

        // First comment
        if(media.getComments().getCount() >= 1){
            viewHolder.tvComment1.setText(media.getComments().getFirstComment());
        }
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        mediaList.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Media> list) {
        mediaList.addAll(list);
        notifyDataSetChanged();
    }

}
