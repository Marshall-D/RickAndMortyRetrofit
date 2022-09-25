package com.example.rickandmortyretrofit.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient {
    //the retrofit builder will need a base url
    private val BASE_URL = "https://rickandmortyapi.com/api/"

    // next we create a variable for the moshi builder, adding a converter to it.
    private val  moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    //create an instance of retrofit by lazy so it can be initialised only when needed.
    //pass the base url and ghe moshi variables created

    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}

// here, we create an interface to define
// how Retrofit communicates with the service using the get method

interface ApiService{
    //then we create a fetcharacters method
    // annotate with @Get, passing the character path
    // just like in our api link above to tell the server to send us those characters
    @GET("character")
    fun fetchCharacters(@Query("page") page:String): Call<CharacterResponse>
}