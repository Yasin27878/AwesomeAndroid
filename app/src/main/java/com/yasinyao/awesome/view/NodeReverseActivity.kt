package com.yasinyao.awesome.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yasinyao.awesome.entity.Node
import com.yasinyao.awesome.R

class NodeReverseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_node_reverse)
        var node: Node? = Node(value = 0)
    }
}
