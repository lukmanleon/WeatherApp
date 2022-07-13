package com.example.weatherapp;

public class WeatherReportModel {

    private int temperature;
    private int wind_speed;
    private String wind_dir;
    private int pressure;
    private int precip;
    private int humidity;

    public WeatherReportModel(int temperature, int wind_speed, String wind_dir, int pressure, int precip, int humidity) {
        this.temperature = temperature;
        this.wind_speed = wind_speed;
        this.wind_dir = wind_dir;
        this.pressure = pressure;
        this.precip = precip;
        this.humidity = humidity;
    }

    public WeatherReportModel() {
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getPrecip() {
        return precip;
    }

    public void setPrecip(int precip) {
        this.precip = precip;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherReportModel{" +
                "temperature=" + temperature +
                ", wind_speed=" + wind_speed +
                ", wind_dir='" + wind_dir + '\'' +
                ", pressure=" + pressure +
                ", precip=" + precip +
                ", humidity=" + humidity +
                '}';
    }
}
