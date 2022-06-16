package com.example.ps17139_rest


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ps17139_rest.databinding.FragmentFirstBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Thirdfragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retro= Retrofit.Builder()
            .baseUrl(APIinterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val API=retro.create(APIinterface::class.java)
        val call=API.comments
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        call?.enqueue(object: Callback<List<comment?>?> {
            override fun onResponse(
                call: Call<List<comment?>?>,
                response: Response<List<comment?>?>
            ) {
                val postlist: List<comment>?= response.body() as List<comment>?
                val posts= arrayOfNulls<String>(postlist!!.size)

                var Adaptermain = adapterComment(postlist)
                 binding.recyclerview.adapter = Adaptermain
            }

            override fun onFailure(call: Call<List<comment?>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }

        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}