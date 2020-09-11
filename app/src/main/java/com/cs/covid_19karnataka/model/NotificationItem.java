package com.cs.covid_19karnataka.model;

public class NotificationItem {
    private  String noti_title, noti_link;

    public NotificationItem(String noti_title, String noti_link) {
        this.noti_title = noti_title;
        this.noti_link = noti_link;
    }

    public String getNoti_title() {
        return noti_title;
    }

    public void setNoti_title(String noti_title) {
        this.noti_title = noti_title;
    }

    public String getNoti_link() {
        return noti_link;
    }

    public void setNoti_link(String noti_link) {
        this.noti_link = noti_link;
    }
}
