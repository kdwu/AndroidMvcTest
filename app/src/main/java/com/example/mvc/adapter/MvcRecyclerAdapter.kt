package com.example.mvc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvc.R
import com.example.mvc.bean.Data

/**
 * @项目名 MVP
 * @文件名 MvpRecyclerAdapter.java
 * @作者 geely
 * @创建时间 2021年06月21日 13:36:00
 * @描述 RecyclerView 适配器
 */
class MvcRecyclerAdapter(private val dataList: List<Data>, private val context: Context) : RecyclerView.Adapter<MvcRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImg: ImageView = view.findViewById(R.id.iv_img)
        val tvDesc: TextView = view.findViewById(R.id.tv_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bean = dataList[position]
        Glide.with(context).load(bean.images[0]).into(holder.ivImg)
        holder.tvDesc.text = bean.desc
    }

    override fun getItemCount() = dataList.size
}