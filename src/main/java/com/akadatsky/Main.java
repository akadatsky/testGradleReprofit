package com.akadatsky;

import com.akadatsky.api.ApiManager;
import com.akadatsky.api.MyCallback;
import com.akadatsky.model.Post;
import com.akadatsky.model.SendPostResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // testRequest1();
        // testRequest2();
        // testRequest3();
        testPost();
    }

    private static void testPost() {

        Post post = new Post(1, 123, "My title", "My body");

        ApiManager.getApiService().sendPost(post)
                .enqueue((MyCallback<SendPostResult>) (call, response) -> System.out.println("Post done"));

    }


    private static void testRequest1() {
        ApiManager.getApiService().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response != null) {
                    System.out.println(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                System.out.println("Error:" + t);
            }
        });
    }

    private static void testRequest2() {

        try {
            Post post = ApiManager.getApiService().getPosts().execute().body().get(0);
            System.out.println(post);
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }

    }

    private static void testRequest3() {
        ApiManager.getApiService().getPosts().enqueue((MyCallback<List<Post>>) (call, response) -> {
            if (response != null) {
                System.out.println(response.body().get(0));
            }
        });
    }

}
