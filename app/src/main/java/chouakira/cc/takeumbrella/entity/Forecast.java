package chouakira.cc.takeumbrella.entity;

import chouakira.cc.takeumbrella.enumcode.WeatherCode;

/**
 * Created by qiao on 2017/8/27.
 */

public class Forecast {
    public WeatherCode getWeather() {
        return weather;
    }

    public void setWeather(WeatherCode weather) {
        this.weather = weather;
    }

    WeatherCode weather;

    //307.53K - 273.15 = 34.38°C
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    float temperature;

    @Override
    public String toString() {
        return String.format("Temperature is %s°C; Weather is %s", getTemperature(), getWeather().toString());
    }
}
