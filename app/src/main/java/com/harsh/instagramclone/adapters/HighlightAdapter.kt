package com.harsh.instagramclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.harsh.instagramclone.R
import com.harsh.instagramclone.dataclasses.HighLightData

class HighlightAdapter(val highLight: List<HighLightData>) :
    RecyclerView.Adapter<HighLightViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighLightViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.highlight_item, parent, false)
        return HighLightViewHolder(view)
    }

    override fun onBindViewHolder(holder: HighLightViewHolder, position: Int) {
        holder.user_name.text = highLight[position].highLight
        holder.user_image.setImageResource(highLight[position].image)
    }

    override fun getItemCount(): Int {
        return highLight.size
    }

}

class HighLightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val user_name = itemView.findViewById<TextView>(R.id.tv_highligh_text)
    val user_image = itemView.findViewById<ImageView>(R.id.iv_highlight_image)
}