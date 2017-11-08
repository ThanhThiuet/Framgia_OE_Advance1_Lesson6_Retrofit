package framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.interfaces;

import framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.models.GithubModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by thanhthi on 03/11/2017.
 */

public interface GithubService {

    @GET("users/list")
    Call<GithubModel> getGithub(@Query("sort") String sortValue);

}
