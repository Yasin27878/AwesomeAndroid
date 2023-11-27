package com.yasinyao.awesome

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yasinyao.awesome.entity.MainEntity

class MainAdapter(val mContext: Context, val mList: MutableList<MainEntity>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    /*    companion object{
              var ARG_PARAM1 = "param1"
            private val ARG_PARAM2 = "param2"

        }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = mList[position]
        holder.textView.text = entity.name;
        startAnimater(holder.icon, position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView
        val icon: ImageView

        init {
            textView = itemView.findViewById(R.id.text)
            icon = itemView.findViewById(R.id.icon)
        }


    }

    fun addList(list: List<MainEntity>) {
        for ((index, entity) in list.withIndex()) {
            mList.add(entity)
            notifyItemInserted(index)
        }
    }

    fun startAnimater(view: View, position: Int) {
        ObjectAnimator.ofFloat(view, "translationX", -((position + 1) * 50f), 0f)
            .setDuration(500)
            .start()
    }

}