package com.piero.misjobs

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JobService {

    @GET("positions.json")
    fun getJobs(@Query("description") description: String): Call<List<Job>>

}