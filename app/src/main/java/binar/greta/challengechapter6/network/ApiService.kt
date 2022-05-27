package binar.greta.challengechapter6.network

import binar.greta.challengechapter6.model.GetAllFilmItem
import binar.greta.challengechapter6.model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("film")
    fun getAllFilm(): Call<List<GetAllFilmItem>>

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserItem>>

    @POST("user")
    @FormUrlEncoded
    fun loginUser(
            @Field("password") password : String,
            @Field("username") username : String
    ) : Call<GetAllUserItem>

    @POST("user")
    @FormUrlEncoded
    fun registerUser(
            @Field("password") password : String,
            @Field("username") username : String
    ) : Call<GetAllUserItem>

    @POST("user")
    @FormUrlEncoded
    fun updateUser(
            @Field("id")id : String,
            @Field("address") address : String,
            @Field("name") name : String,
            @Field("password") password : String,
            @Field("umur") umur : String,
            @Field("username") username : String
    ) : Call<GetAllUserItem>
}