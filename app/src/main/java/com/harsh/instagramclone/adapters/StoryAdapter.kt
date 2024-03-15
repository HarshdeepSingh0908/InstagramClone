package com.harsh.instagramclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.harsh.instagramclone.R
import com.harsh.instagramclone.dataclasses.StoryData


class StoryAdapter(private val stories: List<StoryData>, private val navController: NavController) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.story_item, parent, false)
        return StoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = stories[position]
        holder.bind(story)
        holder.itemView.setOnClickListener {
            val bundle = bundleOf("imageResId" to story.imageView)
            navController.navigate(R.id.action_homeFragment_to_storyDetailsFragment, bundle)
        }
    }

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val user_name: TextView = itemView.findViewById(R.id.tv_story_username)
        private val user_image: ImageView = itemView.findViewById(R.id.iv_story_image)

        fun bind(story: StoryData) {
            user_name.text = story.username
            user_image.setImageResource(story.imageView)
        }
    }
}
