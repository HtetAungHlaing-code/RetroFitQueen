package com.example.retrofit.Model

data class Voting(
    val classRoom: String,
    val id: String,
    val img_url: String,
    val name: String,
    val vote_count: Int,
    val vote_time_status: Int
)