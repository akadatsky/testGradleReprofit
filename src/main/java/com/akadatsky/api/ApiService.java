package com.akadatsky.api;

import com.akadatsky.model.Post;
import com.akadatsky.model.SendPostResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import java.util.List;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<SendPostResult> sendPost(@Body Post post);

    @PUT("posts/20")
    Call<SendPostResult> replacePost(@Body Post post);

}
