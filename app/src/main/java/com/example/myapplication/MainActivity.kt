package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {

    private var arrayOfModel = arrayListOf<Model>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrayOfModel.add(Model("text11", "button11.1", "button11.1"))
        arrayOfModel.add(Model("text12", "button12.1", "button12.2"))
        val adapter = MyAdapter(this, arrayOfModel)
        val listView = findViewById<ListView>(R.id.listView)

        adapter.setOnItemClickListener(this)
        listView.adapter = adapter
    }

    override fun setOnItemClickListener(view: View?, position: Int) {
        Log.i("Avirag", "view:" + view)
        Log.i("Avirag", "position:" + position)
    }
}