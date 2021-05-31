package javafiles;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
public interface RetrofitClient {
    @GET("users")
    @Headers("Content-Type: application/json")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    @Headers("Content-Type: application/json")
    Call<User> getUser(@Path("id") int id);

    @GET("users/{id}/posts")
    @Headers("Content-Type: application/json")
    Call<List<User>> getUserPosts(@Path("id") int id);

    @GET("posts/{id}/comments")
    @Headers("Content-Type: application/json")
    Call<List<User>> getPostComments(@Path("id") int id);

    @GET("users/{username}")
    @Headers("Content-Type: application/json")
    Call<List<User>> getUserFromUsername(@Query("username") String username);

    @GET("posts/10/comments")
    @Headers("Content-Type: application/json")
    Call<List<String>> getPosts();

    @GET("users/{id}/todos?completed=false")
    @Headers("Content-Type: application/json")
    Call<List<User>> getTodos(@Path("id") int id);

    @POST("users")
    @Headers("Content-Type: application/json")
    Call<User> newUser();

    @PUT ("posts/1")
    @Headers("Content-Type: application/json")
    Call<User> updateUser(@Query("id") int id, @Body User user);

    @DELETE ("posts/1")
    @Headers("Content-Type: application/json")
    Call<User> deleteUser(@Query("id") int id);

}
