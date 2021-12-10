package com.example.breakingbadapp.activities.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var api =
        Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.breakingbadapi.com/api/")
                .build()