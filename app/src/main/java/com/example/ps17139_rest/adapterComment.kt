package com.example.ps17139_rest
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterComment(val comments:List<comment>):
    RecyclerView.Adapter<adapterComment.ViewHolder>() {
    class ViewHolder (itemview:View):RecyclerView.ViewHolder(itemview){
        var userid: TextView = itemView.findViewById(R.id.userid)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)

        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userid.text=comments[position].body.toString()
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}