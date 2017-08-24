package chouakira.cc.takeumbrella.common;

import android.app.Application;

/**
 * Created by qiao on 2017/8/19.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        ContextHolder.initial(this);
        super.onCreate();
    }
}


