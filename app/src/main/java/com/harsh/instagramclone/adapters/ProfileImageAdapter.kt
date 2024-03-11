package com.harsh.instagramclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harsh.instagramclone.dataclasses.ProfileImageData
import com.harsh.instagramclone.databinding.ItemProfileImageBinding

class ProfileImageAdapter(private val profileImages: List<ProfileImageData>) :
    RecyclerView.Adapter<ProfileImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProfileImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profileImage = profileImages[position]
        holder.bind(profileImage)
    }

    override fun getItemCount(): Int = profileImages.size

    inner class ViewHolder(private val binding: ItemProfileImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(profileImage: ProfileImageData) {
            // Load profile image into ImageView using binding.profileImage
            binding.profileImage.setImageResource(profileImage.imageResId)
        }
    }
}
