package chouakira.cc.takeumbrella.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import chouakira.cc.takeumbrella.enumcode.WeatherCode;

/**
 * Created by qiao on 2017/8/16.
 */

public class Tool {

    public static void ShowArrayMap(Map<Date, WeatherCode> map) {
        int i = 0;
        for(Map.Entry<Date, WeatherCode> set : map.entrySet()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Log.e(Const.TAG, String.format("*%d : %s -- %s", i++, sdf.format(set.getKey()), set.getValue()));
        }
    }

    public static void ShowFileContent(File file) {
        if(file == null || !file.exists() || file.length() > 1024 * 1024 * 5) {
            return;
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                Log.i(Const.TAG, line);
            }
        } catch(Exception ex) {

        }

    }
}
