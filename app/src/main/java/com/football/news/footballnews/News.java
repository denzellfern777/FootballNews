package com.football.news.footballnews;

class News {

    private final String title;
    private final String section_name;
    private final String author;
    private final String published_date;
    private final String website_url;

    public News(String title, String section_name, String author, String published_date, String website_url) {
        this.title = title;
        this.section_name = section_name;
        this.author = author;
        this.published_date = published_date;
        this.website_url = website_url;
    }


    public String getTitle() {
        return title;
    }

    public String getSection_name() {
        return section_name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getWebsite_url() {
        return website_url;
    }
}
