package com.dmytromarchuk.photogallery;

import com.orm.SugarRecord;

public class PicturesData extends SugarRecord {
    String name;
    String url;

    public PicturesData() {
    }

    public PicturesData(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
