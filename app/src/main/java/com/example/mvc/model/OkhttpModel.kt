package com.example.mvc.model

import com.example.mvc.bean.DataBean
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread

/**
 * @项目名 MVC
 * @文件名 OkhttpModel.java
 * @作者 geely
 * @创建时间 2021年06月21日 17:34:00
 * @描述 Model 层
 */
class OkhttpModel {

    private val url = "https://gank.io/api/v2/data/category/Girl/type/Girl/page/2/count/10"
    private lateinit var listener : OnOkhttpListener

    fun getData(mListener: OnOkhttpListener) {
        listener = mListener
        thread {
            val okHttpClient = OkHttpClient()
            val request = Request.Builder().get().url(url).build()
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    listener.onFail(e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body?.string()
                    responseData?.let {
                        val dataBean = Gson().fromJson(responseData, DataBean::class.java)
                        listener.onSuccess(dataBean)
                    }

                }

            })
        }

    }

    interface OnOkhttpListener {
        fun onSuccess(bean: DataBean)
        fun onFail(msg: String)
    }
}