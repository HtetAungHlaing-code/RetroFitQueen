package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.API.VotingApiInterface
import com.example.retrofit.Adapter.VotingAdapter
import com.example.retrofit.Model.Voting
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),VotingAdapter.ClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getQueen()
    }
    fun loadUserList(queenList: List<Voting>){
        retrofitRecycler.apply {
            layoutManager=LinearLayoutManager(context)
            val Votingadapter= VotingAdapter(queenList as ArrayList<Voting>)
            Votingadapter.setClickListener(this@MainActivity)
            adapter=Votingadapter
        }
    }

    fun getQueen(){
        var BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(VotingApiInterface::class.java)
        var apiCall = retrofitService.getQueen()
        apiCall.enqueue(object : Callback<List<Voting>>{
            override fun onFailure(call: Call<List<Voting>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Voting>>, response: Response<List<Voting>>) {
                var queenlist = response.body()
                Log.d("Response>>>>>", queenlist.toString())
                loadUserList(queenlist as ArrayList)
            }

        })
    }

    override fun onClick(voting: Voting) {
        var a=Intent(this@MainActivity,Main2Activity::class.java)
        a.putExtra("a",voting.name)
        a.putExtra("IMAGE",voting.img_url)
        startActivity(a)
        Toast.makeText(this,"${voting.name}",Toast.LENGTH_LONG).show()
    }
}

