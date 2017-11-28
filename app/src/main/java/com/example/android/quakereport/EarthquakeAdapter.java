package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Seeyon on 2017-11-24.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    static private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
    static private SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("K:mm a");

    public EarthquakeAdapter(@NonNull Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Earthquake earthquake = getItem(position);

        // 刚开始渲染的时候没有可重用的view，需要自己创建
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.earthquake, parent, false);
        }

        TextView magTextView = (TextView) convertView.findViewById(R.id.mag);
        TextView distTextView = (TextView) convertView.findViewById(R.id.dist);
        TextView cityTextView = (TextView) convertView.findViewById(R.id.city);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.date);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);

        // set mag text
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        magTextView.setText(decimalFormat.format(earthquake.getMag()));

        // set mag background
        GradientDrawable gradientDrawable = (GradientDrawable) magTextView.getBackground();
        gradientDrawable.setColor(ContextCompat.getColor(getContext(),
                getMagnitudeColor(earthquake.getMag())));

        distTextView.setText(getDist(earthquake.getLocation()));
        cityTextView.setText(getCity(earthquake.getLocation()));
        dateTextView.setText(getDate(earthquake.getTime()));
        timeTextView.setText(getTime(earthquake.getTime()));

        return convertView;
    }

    private String getDate(long time) {
        return simpleDateFormat.format(new Date(time));
    }

    private String getTime(long time) {
        return simpleTimeFormat.format(new Date(time));
    }

    private String getDist(String location) {
        int ofIndex = location.indexOf("of");

        if (ofIndex != -1) {
            return location.substring(0, ofIndex - 1);
        } else {
            return "Near the";
        }
    }

    private String getCity(String location) {
        int ofIndex = location.indexOf("of");

        if (ofIndex != -1) {
            return location.substring(ofIndex + 3);
        } else {
            return location;
        }
    }

    public int getMagnitudeColor(double mag) {
        int iMag = new Double(mag).intValue();

        switch (iMag) {
            case 0:
            case 1:
                return R.color.magnitude1;
            case 2:
                return R.color.magnitude2;
            case 3:
                return R.color.magnitude3;
            case 4:
                return R.color.magnitude4;
            case 5:
                return R.color.magnitude5;
            case 6:
                return R.color.magnitude6;
            case 7:
                return R.color.magnitude7;
            case 8:
                return R.color.magnitude8;
            case 9:
                return R.color.magnitude9;
            case 10:
                return R.color.magnitude10plus;
            default:
                return R.color.magnitude1;
        }
    }
}
