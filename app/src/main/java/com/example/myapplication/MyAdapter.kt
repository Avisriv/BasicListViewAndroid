package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class MyAdapter(
    private val context: Context,
    private val dataSource: ArrayList<Model>
) : BaseAdapter(), View.OnClickListener {

    private var mOnItemClickListener: OnItemClickListener? = null
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private lateinit var mButton1: Button;
    private lateinit var mButton2: Button;
    private lateinit var mTextView: TextView;

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.row, parent, false)

        mButton1 = rowView.findViewById(R.id.button1)
        mButton2 = rowView.findViewById(R.id.button2)
        mTextView = rowView.findViewById(R.id.textView)
        mTextView.text = dataSource[position].textDescription
        mButton1.text = dataSource[position].button1Text
        mButton2.text = dataSource[position].button2Text


        mButton1.setOnClickListener(View.OnClickListener {
            // below will send to MainActivity
            this.mOnItemClickListener?.setOnItemClickListener(
                it,
                position
            )
        })
        mButton2.setOnClickListener(this) // this means it will send to onClick of this file
        return rowView
    }

    override fun onClick(view: View?) {
        Log.i("Avirag", "onClick")

    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun setOnItemClickListener(view: View?, position: Int)
    }
}