package com.example.mvc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvc.adapter.MvcRecyclerAdapter
import com.example.mvc.bean.Data
import com.example.mvc.bean.DataBean
import com.example.mvc.model.OkhttpModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MvcRecyclerAdapter
    private var mList = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = MvcRecyclerAdapter(mList, this)
        recyclerView.adapter = adapter

        loadData()
    }

    private fun loadData() {
        val model = OkhttpModel()

        model.getData(object : OkhttpModel.OnOkhttpListener {
            override fun onSuccess(bean: DataBean) {
                bean.data.forEach {
                    mList.add(it)
                }
                runOnUiThread {
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFail(msg: String) {
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
        })
    }


}