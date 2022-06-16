package com.example.ps17139_rest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.ps17139_rest.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

     private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textviewSecond: TextView =view.findViewById(R.id.textview_second)
        val textviewSecond1: TextView =view.findViewById(R.id.textview_second1)
        var inputData:String?=null
        var inputData1:String?=null
        inputData= arguments?.getString("data").toString()
        inputData1=arguments?.getString("data1").toString()
        val activity=context as AppCompatActivity
        Toast.makeText(activity,"$inputData", Toast.LENGTH_SHORT).show()
        textviewSecond.text = inputData
        textviewSecond1.text= inputData1
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}