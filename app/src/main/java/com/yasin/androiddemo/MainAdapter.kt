package com.yasin.androiddemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yasin.androiddemo.entity.MainEntity

class MainAdapter(val mContext: Context, val mList: List<MainEntity>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


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
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView

        init {
            textView = itemView.findViewById(R.id.text)
        }


    }

}