package com.ankitgarg.instagram.model;

import android.text.Html;
import android.text.Spanned;

import java.util.List;

public class Comments {
    private Long count;
    private List<Comment> data;

    public Long getCount() {
        return count;
    }

    public List<Comment> getCommentList() {
        return data;
    }

    public Spanned getFirstComment(){
        Spanned fullComment = null;
        String commentTxt = "";
        Comment comment;
        if(count >= 1){
            comment = data.get(0);
            commentTxt = comment.getText();
            fullComment = Html.fromHtml(
                    "<b><font color=\"#366084\">" + comment.getFrom().getFull_name() + " </font></b> " + commentTxt);
        }
        return fullComment;
    }
}
