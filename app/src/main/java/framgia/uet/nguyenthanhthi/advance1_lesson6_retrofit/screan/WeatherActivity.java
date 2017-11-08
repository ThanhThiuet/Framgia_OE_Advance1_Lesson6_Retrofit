package framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.screan;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.R;
import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.WeatherServiceGenerator;
import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.interfaces.WeatherService;
import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.models.WeatherModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {

    private final String USER_KEY = "6e0e5798288b83cc170bed9ac5265093";
    private final double LATITUDE = 37.8267;
    private final double LONGITUDE = -122.4233;
    private Button mButtonGetWeatherData;
    private TextView mTextLatitude, mTextLongitude, mTextTemparature, mTextHumidity, mTextWindSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getSupportActionBar().setTitle("Retrofit Demo 2");

        initView();
    }

    private void initView() {
        mButtonGetWeatherData = (Button) findViewById(R.id.button_get_weather_data);
        mTextLatitude = (TextView) findViewById(R.id.text_latitude);
        mTextLongitude = (TextView) findViewById(R.id.text_longitude);
        mTextTemparature = (TextView) findViewById(R.id.text_temperature);
        mTextHumidity = (TextView) findViewById(R.id.text_humidity);
        mTextWindSpeed = (TextView) findViewById(R.id.text_wind_speed);

        mButtonGetWeatherData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();

        WeatherService service = WeatherServiceGenerator.createService(WeatherService.class);
        service.getWeather(USER_KEY, LATITUDE, LONGITUDE)
                .enqueue(new Callback<WeatherModel>() {
                    @Override
                    public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                        if (response == null) {
                            dialog.dismiss();
                            return;
                        }
                        WeatherModel model = response.body();
                        mTextLatitude.setText(String.valueOf(model.getLatitude()));
                        mTextLongitude.setText(String.valueOf(model.getLongitude()));
                        mTextTemparature.setText(String.valueOf(model.getCurrent().getTemparature()));
                        mTextHumidity.setText(String.valueOf(model.getCurrent().getHumidity()));
                        mTextHumidity.setText(String.valueOf(model.getCurrent().getWindSpeed()));
                    }

                    @Override
                    public void onFailure(Call<WeatherModel> call, Throwable t) {
                        dialog.dismiss();
                        Toast.makeText(WeatherActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
