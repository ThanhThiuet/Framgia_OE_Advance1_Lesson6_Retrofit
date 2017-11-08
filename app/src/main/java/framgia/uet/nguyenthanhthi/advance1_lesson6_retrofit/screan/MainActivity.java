package framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.screan;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.R;
import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.GithubServiceGenerator;
import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.interfaces.GithubService;
import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.models.GithubModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonGetData;
    private TextView mTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Retrofit Demo 1");

        initView();
    }

    private void initView() {
        mButtonGetData = (Button) findViewById(R.id.button_get_data);
        mTextResult = (TextView) findViewById(R.id.text_result);

        mButtonGetData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        GithubService service = GithubServiceGenerator.createService(GithubService.class);
        service.getGithub("desc")
                .enqueue(new Callback<GithubModel>() {
                    @Override
                    public void onResponse(Call<GithubModel> call, Response<GithubModel> response) {
                        if (response != null) {
                            GithubModel model = response.body();
                            mTextResult.setText(model.getUrl());
                        }
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<GithubModel> call, Throwable t) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
