package framgia.uet.nguyenthanhthi.advance1_lesson6_retrofit.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thanhthi on 03/11/2017.
 */

public class GithubModel {

    @SerializedName("Login")
    private String mLogin;

    @SerializedName("id")
    private int mId;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("url")
    private String mUrl;


    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setmUrl(String url) {
        mUrl = url;
    }
}
