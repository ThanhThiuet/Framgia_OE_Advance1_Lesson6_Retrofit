package framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.interfaces;

import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.models.WeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by thanhthi on 08/11/2017.
 */

public interface WeatherService {

    @GET("forecast/{key}/{longitude},{latitude}")
    Call<WeatherModel> getWeather(@Path("key") String key,
                                  @Path("longitude") double longitude,
                                  @Path("latitude") double latitude);

}
