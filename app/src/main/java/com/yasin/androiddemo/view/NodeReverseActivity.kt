package com.yasin.androiddemo.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.yasin.androiddemo.R
import com.yasin.androiddemo.entity.Node
import kotlinx.android.synthetic.main.activity_node_reverse.*;

class NodeReverseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_node_reverse)
        var node: Node? = Node(value = 0)
    }
}
