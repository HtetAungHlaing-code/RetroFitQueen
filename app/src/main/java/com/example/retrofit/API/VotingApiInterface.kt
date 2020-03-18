package com.example.retrofit.API

import com.example.retrofit.Model.Voting
import retrofit2.Call
import retrofit2.http.GET

interface VotingApiInterface {
    @GET("queen")
    fun getQueen():Call<List<Voting>>
}