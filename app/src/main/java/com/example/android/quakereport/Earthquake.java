package com.example.android.quakereport;

/**
 * Created by Seeyon on 2017-11-24.
 */

public class Earthquake {
    private double mag;
    private String location;
    private long time;
    private String website;

    public Earthquake(double mag, String location, long time, String website) {
        this.mag = mag;
        this.location = location;
        this.time = time;
        this.website = website;
    }

    public double getMag() {
        return mag;
    }

    public String getLocation() {
        return location;
    }

    public long getTime() {
        return time;
    }

    public String getWebsite() {
        return website;
    }
}
