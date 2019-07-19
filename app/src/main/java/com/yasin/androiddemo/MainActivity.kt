package com.yasin.androiddemo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yasin.androiddemo.entity.MainEntity
import com.yasin.androiddemo.widget.RecyclerViewItemTouchListener

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // add activity url to list
        var list = ArrayList<MainEntity>()
        for (i: Int in 0..10) {
            list.add(MainEntity("测试" + i, ""))
        }

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MainAdapter(this, list);
        rv.addOnItemTouchListener(RecyclerViewItemTouchListener(object : RecyclerViewItemTouchListener.OnItemListener {
            override fun onItemClick(position: Int, view: View?) {
                Toast.makeText(this@MainActivity, "onItemClick" + position, Toast.LENGTH_SHORT).show()
                if (TextUtils.isEmpty(list[position].scheme)) {
                    return
                }

                var intent = Intent()
                intent.setClassName(this@MainActivity, list[position].scheme)
                startActivity(intent)


            }

            override fun onItemLongClick(position: Int, view: View?) {
                Toast.makeText(this@MainActivity, "onItemLongClick" + position, Toast.LENGTH_SHORT).show()

            }
        }));

    }

}
