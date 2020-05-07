package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.model.Member
import com.example.myapplication10onclicklister.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initView() {
        recyclerView.layoutManager = GridLayoutManager(this, 1)

    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(this, members)
        recyclerView.adapter = adapter
    }


    fun openItemDetails(member: Member) {
        Log.d("test", "test" + member.firstname)
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..29) {

                members.add(Member("Makhmudov" + i, "Abdulloh" + i))

        }
        return members
    }

}
