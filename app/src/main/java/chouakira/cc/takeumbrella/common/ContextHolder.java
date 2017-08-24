package chouakira.cc.takeumbrella.common;

import android.content.Context;

/**
 * Created by qiao on 2017/8/19.
 */

public class ContextHolder {

    static Context ApplicationContext;

    public static void initial(Context context) {
        ApplicationContext = context;
    }

    public static Context getContext() {
        return ApplicationContext;
    }
}
