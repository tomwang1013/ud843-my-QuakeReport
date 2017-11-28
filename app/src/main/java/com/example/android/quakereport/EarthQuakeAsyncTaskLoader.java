package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Seeyon on 2017-11-28.
 */

class EarthQuakeAsyncTaskLoader extends AsyncTaskLoader<List<Earthquake>> {
    String mRequestUrl;

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    public EarthQuakeAsyncTaskLoader(Context context, String requestUrl) {
        super(context);
        mRequestUrl = requestUrl;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        return QueryUtils.fetchEarthquakes(mRequestUrl);
    }
}
