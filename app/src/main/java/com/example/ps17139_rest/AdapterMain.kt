package com.example.ps17139_rest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView


class AdapterMain( val User:List<post>):
    RecyclerView.Adapter<AdapterMain.ViewHolder>() {
    class ViewHolder (itemview:View):RecyclerView.ViewHolder(itemview){
        var userid: TextView = itemView.findViewById(R.id.userid)
        lateinit var title1: TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)

        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.userid.text=User[position].title.toString()
        holder.itemView.setOnClickListener(object:View.OnClickListener{
           override fun onClick(p0: View) {
               val item = User[holder.absoluteAdapterPosition]
                val bundle=Bundle()
                bundle.putString("data", item.title)
                bundle.putString("data1",item.body)
                val activity=p0.context as AppCompatActivity
                val transcation=activity.supportFragmentManager.beginTransaction()
                val secondfragment=SecondFragment()
                secondfragment.arguments=bundle
                transcation.replace(R.id.recyclerview,secondfragment).commit()
               Navigation.findNavController(p0).navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })
    }

    override fun getItemCount(): Int {
        return User.size
    }

}