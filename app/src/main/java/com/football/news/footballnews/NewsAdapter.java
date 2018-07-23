package com.football.news.footballnews;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class NewsAdapter extends ArrayAdapter<News> {

    NewsAdapter(Activity context, ArrayList<News> News) {
        super(context, 0, News);
    }

    @NonNull
    @Override
    public View getView(int position, View listItemView, @NonNull ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.sheet_list_item, parent, false);

            final News currentNews = getItem(position);

            TextView article_title_tv = listItemView.findViewById(R.id.article_title_tv);
            TextView article_section_name_tv = listItemView.findViewById(R.id.article_section_name_tv);
            TextView article_author_name_tv = listItemView.findViewById(R.id.article_author_name_tv);
            TextView article_published_date_tv = listItemView.findViewById(R.id.article_published_date_tv);
            TextView article_published_time_tv = listItemView.findViewById(R.id.article_published_time_tv);
            ConstraintLayout list_item = listItemView.findViewById(R.id.news_list_item);

            assert currentNews != null;
            article_title_tv.setText(currentNews.getTitle());
            article_section_name_tv.setText(currentNews.getSection_name());
            article_author_name_tv.setText(currentNews.getAuthor());
            article_published_date_tv.setText(formatDate(currentNews.getPublished_date()));
            article_published_time_tv.setText(formatTime(currentNews.getPublished_date()));
            list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(currentNews.getWebsite_url()));
                    if (i.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(i);
                    }
                }
            });
        }
        return listItemView;
    }

    private String formatDate(String dateParam) {

        if (TextUtils.isEmpty(dateParam)) {
            return "(Blank)";
        } else {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM, yyyy");
            Date date = null;
            try {
                date = inputFormat.parse(dateParam);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            return outputFormat.format(date);
        }
    }

    private String formatTime(String dateParam) {

        if (TextUtils.isEmpty(dateParam)) {
            return "(Blank)";
        } else {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date time = null;
            try {
                time = inputFormat.parse(dateParam);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);

            return outputFormat.format(time);
        }
    }

}
