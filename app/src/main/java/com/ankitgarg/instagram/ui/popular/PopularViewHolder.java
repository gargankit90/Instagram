package com.ankitgarg.instagram.ui.popular;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ankitgarg.instagram.R;

/**
 * Created by ankitgarg on 3/18/16.
 */
public class PopularViewHolder extends RecyclerView.ViewHolder {
    TextView tvUsername;
    TextView tvCaption;
    TextView tvLikeCount;
    TextView tvRelativeTime;
    ImageView ivPrimaryImage;
    ImageView ivProfilePicture;
    TextView tvNumberOfComments;
    TextView tvComment1;

    public PopularViewHolder(View itemView) {
        super(itemView);
        tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
        tvLikeCount = (TextView) itemView.findViewById(R.id.tvLikeCount);
        tvRelativeTime = (TextView) itemView.findViewById(R.id.tvRelativeTime);
        ivPrimaryImage = (ImageView) itemView.findViewById(R.id.ivPrimaryImage);
        ivProfilePicture = (ImageView) itemView.findViewById(R.id.ivProfilePicture);
        tvCaption = (TextView) itemView.findViewById(R.id.tvCaption);
        tvNumberOfComments = (TextView) itemView.findViewById(R.id.tvNumnerOfComments);
        tvComment1 = (TextView) itemView.findViewById(R.id.tvComment1);
    }
}
