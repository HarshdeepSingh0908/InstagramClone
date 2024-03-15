package com.harsh.instagramclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.harsh.instagramclone.R
import com.harsh.instagramclone.dataclasses.ProfileImageData
import com.harsh.instagramclone.databinding.ItemProfileImageBinding

class ProfileImageAdapter(private val profileImages: List<ProfileImageData>,private val navController: NavController) :
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
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val imageResId = profileImages[position].imageResId
                    val bundle = bundleOf("imageResId" to imageResId)
                    navController.navigate(R.id.action_profileFragment_to_postDetailsFragment, bundle)
                }
            }
        }

        fun bind(profileImage: ProfileImageData) {
            binding.profileImage.setImageResource(profileImage.imageResId)
        }
    }
    }
