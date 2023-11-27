package com.yasinyao.awesome

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.yasinyao.awesome.entity.MainEntity
import com.yasinyao.awesome.widget.RecyclerViewItemTouchListener
import com.yasinyao.awesome.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        /**
         * add activity url to list
         * for example  :
         *  list.add(MainEntity("视频浏览", "com.a.b.VideoActivity"))
         */
        var list = ArrayList<MainEntity>()
        for (i: Int in 0..20) {
            list.add(MainEntity("测试" + i, ""))
        }
        val adapter = MainAdapter(this@MainActivity, mutableListOf())
        binding.content.apply {
            rv.setHasFixedSize(true)
            rv.layoutManager = LinearLayoutManager(this@MainActivity)
            // rv.itemAnimator = FlyInItemAnimator()
            rv.itemAnimator = DefaultItemAnimator().apply {
                addDuration = 2000
            }
            rv.adapter = adapter
            rv.addOnItemTouchListener(RecyclerViewItemTouchListener(object :
                RecyclerViewItemTouchListener.OnItemListener {
                override fun onItemClick(position: Int, view: View?) {
                    Toast.makeText(this@MainActivity, "onItemClick" + position, Toast.LENGTH_SHORT)
                        .show()
                    if (TextUtils.isEmpty(list[position].scheme)) {
                        return
                    }

                    var intent = Intent()
                    intent.setClassName(this@MainActivity, list[position].scheme)
                    startActivity(intent)


                }

                override fun onItemLongClick(position: Int, view: View?) {
                    Toast.makeText(
                        this@MainActivity,
                        "onItemLongClick" + position,
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }))
            adapter.addList(list)
        }

    }

}
