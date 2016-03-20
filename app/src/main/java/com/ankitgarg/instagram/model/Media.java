package com.ankitgarg.instagram.model;

import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.format.DateUtils;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

import com.ankitgarg.instagram.R;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Media implements Serializable {

    private String id;
    private User user;
    private Caption caption;
    private Images images;
    private Likes likes;
    private Long created_time;
    private Comments comments;

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Caption getCaption() {
        return caption;
    }

    public Images getImages() {
        return images;
    }

    public Likes getLikes() {
        return likes;
    }

    public long getCreatedTime() {
        return created_time;
    }

    public Comments getComments() {
        return comments;
    }

    public String getUpdatedTime(){
        Date now = new Date();
        Date then = new Date(getCreatedTime() * 1000);
        String relativeTime = DateUtils.getRelativeTimeSpanString(
                then.getTime(), now.getTime(), DateUtils.MINUTE_IN_MILLIS).toString();
        return relativeTime.replaceAll("(\\d+)\\s(.).+", "$1$2");
    }

    public String getUpdatedLikes(){
        Likes likes = getLikes();
        if(likes != null){
            return formatNumber(getLikes().getCount()) + " likes";
        }else{
            return "0 likes";
        }

    }

    public String getUpdatedNumberOfComments(){
        Comments comments = getComments();
        if(comments != null){
            return formatNumber(getComments().getCount())+" comments";
        }else{
            return "0 comments";
        }
    }

    public Spanned getUpdatedCaption(){
        String captionTxt="";
        String userName="";
        Spanned fullCaption= null;
        if(getCaption() != null){
            captionTxt = getCaption().getText();
            userName = getUser().getFull_name();
            fullCaption = Html.fromHtml(
                "<b><font color=\"#366084\">" + userName + " </font></b> " +captionTxt);
        }
        return fullCaption;
    }

    private String formatNumber(long input) {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(input);
    }

//    private Spannable formatHashtagsAndNames(String username, String text) {
//        String htmlCommentText = text.replaceAll("([#@][A-Za-z0-9_\\.]+)", "<a href=\"#\">$1</a>");
//
//        // Prevent underlining of links
//        Spannable s = (Spannable) Html.fromHtml(
//                "<b><font color=\""+ mContext.getResources().getColor(R.color.primaryBlue) + "\">" + username +"</font></b> " + htmlCommentText);
//        for (URLSpan u: s.getSpans(0, s.length(), URLSpan.class)) {
//            s.setSpan(new UnderlineSpan() {
//                public void updateDrawState(TextPaint tp) {
//                    tp.setUnderlineText(false);
//                }
//            }, s.getSpanStart(u), s.getSpanEnd(u), 0);
//        }
//        return s;
//    }
}
