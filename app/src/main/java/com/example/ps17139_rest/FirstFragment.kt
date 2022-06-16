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


class FirstFragment : Fragment() {

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
        val call=API.posts
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        call?.enqueue(object: Callback<List<post?>?> {
            override fun onResponse(
                call: Call<List<post?>?>,
                response: Response<List<post?>?>
            ) {
                val postslist: List<post>?= response.body() as List<post>?
                val post= arrayOfNulls<String>(postslist!!.size)

                var AdapterMain = AdapterMain(postslist)

                binding.recyclerview.adapter =AdapterMain
            }

            override fun onFailure(call: Call<List<post?>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }

        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}