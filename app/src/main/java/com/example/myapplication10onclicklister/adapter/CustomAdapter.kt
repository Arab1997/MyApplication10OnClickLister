package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEventSource
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.activity.MainActivity

import com.example.myapplication.model.Member
import com.example.myapplication10onclicklister.R


class CustomAdapter(val activity: MainActivity, val members: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() { //Paging  add method val listener: OnBottomReachedListener

    override fun getItemCount(): Int {
        return members.size
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
             val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout, parent, false)
             return CustomViewHolder(view)
     }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)

        if (holder is CustomViewHolder) {
         holder.first_name.setText(member.firstname)
         holder.last_name.setText(member.lastName)

         holder.lay_member.setOnClickListener {
             (activity.openItemDetails(member))
         }
        }

    }


    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val lay_member = view.findViewById<TextView>(R.id.lay_member)
        val first_name = view.findViewById<TextView>(R.id.first_name)
        val last_name = view.findViewById<TextView>(R.id.last_name)


    }


}





