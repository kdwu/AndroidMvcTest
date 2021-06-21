package com.example.mvc.bean

/**
 * @项目名 MVP
 * @文件名 DataBean.kt
 * @作者 geely
 * @创建时间 2021年06月21日 11:44:00
 * @描述 json数据转化而来的实体类
 */
data class DataBean(
        val data: List<Data>,
        val page: Int,
        val page_count: Int,
        val status: Int,
        val total_counts: Int
)

data class Data(
        val _id: String,
        val author: String,
        val category: String,
        val createdAt: String,
        val desc: String,
        val images: List<String>,
        val likeCounts: Int,
        val publishedAt: String,
        val stars: Int,
        val title: String,
        val type: String,
        val url: String,
        val views: Int
)