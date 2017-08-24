package chouakira.cc.takeumbrella.util;

import android.util.ArrayMap;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import chouakira.cc.takeumbrella.R;
import chouakira.cc.takeumbrella.common.ContextHolder;
import chouakira.cc.takeumbrella.enumcode.WeatherCode;
import chouakira.cc.takeumbrella.net.SimpleHttp;

/**
 * Created by qiao on 2017/8/14.
 */

public class OpenWeatherMapGetter implements GetWeather {

    @Override
    public WeatherCode getWeather() {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/forecast?" +
                        "q=%s&mode=%s&appid=%s"
                , "Shanghai,CN", "xml", ContextHolder.getContext().getResources().getString(R.string.openweathermap));
        //openweathermap be changed
        //http://api.openweathermap.org/data/2.5/forecast?q=Shanghai,CN&mode=xml&appid=2131165222

        try {
            InputStream is = SimpleHttp.getStreamXMLData(url);
            ArrayMap<Date, WeatherCode> map =
                    (ArrayMap<Date, WeatherCode>) XMLParser.getWeatherForecast(
                            new FileInputStream(new File(ContextHolder.getContext().getCacheDir(), "a.xml")));

            if(map != null && map.size() > 0) {
                //log
                Tool.ShowArrayMap(map);
                //log
                return map.valueAt(6);
            } else {
                Log.e(Const.TAG, " get nothing from " + url);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return WeatherCode.NotRain;
    }
}
