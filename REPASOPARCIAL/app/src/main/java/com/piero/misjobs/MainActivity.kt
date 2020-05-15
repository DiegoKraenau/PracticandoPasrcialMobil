package com.piero.misjobs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var jobs: List<Job>
    lateinit var jobAdapter: JobAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBuscar.setOnClickListener(){
            searchJob()
        }

    }

    private fun searchJob() {

        //Toast.makeText(applicationContext, "Aeaaaa", Toast.LENGTH_SHORT).show()
        val description = tvJob.text.toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobs.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(JobService::class.java)

        val request = service.getJobs(description)

        request.enqueue(object : Callback<List<Job>> {
            override fun onFailure(call: Call<List<Job>>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }

            override fun onResponse(call: Call<List<Job>>, response: Response<List<Job>>) {
                if (response.isSuccessful){
                    jobs = response.body()!!
                    jobAdapter = JobAdapter(jobs)
                    recyclerView.adapter = jobAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                }
                //Toast.makeText(applicationContext, "Maaaaal", Toast.LENGTH_SHORT).show()

            }


        } )



    }


}
