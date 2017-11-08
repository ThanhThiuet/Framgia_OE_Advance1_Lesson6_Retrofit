package framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thanhthi on 08/11/2017.
 */

public class WeatherModel {

    @SerializedName("latitude")
    private double mLatitude;

    @SerializedName("longitude")
    private double mLongitude;

    @SerializedName("timezone")
    private String mTimeZone;

    @SerializedName("current")
    private Current mCurrent;


    public WeatherModel(double latitude, double longitude, String timeZone, Current current) {
        mLatitude = latitude;
        mLongitude = longitude;
        mTimeZone = timeZone;
        mCurrent = current;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }

    public class Current {

        @SerializedName("temparature")
        private double mTemparature;

        @SerializedName("humidity")
        private double mHumidity;

        @SerializedName("windspeed")
        private double mWindSpeed;


        public Current(double temparature, double humidity, double windSpeed) {
            mTemparature = temparature;
            mHumidity = humidity;
            mWindSpeed = windSpeed;
        }

        public double getTemparature() {
            return mTemparature;
        }

        public void setTemparature(double temparature) {
            mTemparature = temparature;
        }

        public double getHumidity() {
            return mHumidity;
        }

        public void setHumidity(double humidity) {
            mHumidity = humidity;
        }

        public double getWindSpeed() {
            return mWindSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            mWindSpeed = windSpeed;
        }
    }
}
