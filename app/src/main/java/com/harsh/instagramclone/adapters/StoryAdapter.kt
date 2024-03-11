package com.harsh.instagramclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.harsh.instagramclone.R
import com.harsh.instagramclone.dataclasses.StoryData

class StoryAdapter(val story : List<StoryData>) : RecyclerView.Adapter<StoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.story_item,parent,false)
        return StoryViewHolder(view)
    }

    override fun getItemCount(): Int {
       return story.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.user_name.text = story[position].username
        holder.user_image.setImageResource(story[position].imageView)

    }
}

class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val user_name = itemView.findViewById<TextView>(R.id.tv_story_username)
val user_image = itemView.findViewById<ImageView>(R.id.iv_story_image)
}