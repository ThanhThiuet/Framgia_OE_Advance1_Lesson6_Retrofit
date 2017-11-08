package framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by thanhthi on 08/11/2017.
 */

public class WeatherServiceGenerator {

    private final static String BASE_URL = "https://api.darksky.net";

    private static Retrofit sRetrofit = null;

    private static Retrofit.Builder sBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static HttpLoggingInterceptor sHttpLoggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder sOkHttpClientBuilder = new OkHttpClient.Builder()
            .addInterceptor(sHttpLoggingInterceptor);

    private static OkHttpClient sOkHttpClient = sOkHttpClientBuilder.build();


    public static <T> T createService(Class<T> serviceClass) {
        sRetrofit = sBuilder.client(sOkHttpClient).build();
        return sRetrofit.create(serviceClass);
    }

}
