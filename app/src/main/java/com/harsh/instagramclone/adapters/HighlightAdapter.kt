package com.harsh.instagramclone.adapters
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.harsh.instagramclone.R
import com.harsh.instagramclone.dataclasses.HighLightData
import com.harsh.instagramclone.databinding.HighlightItemBinding

class HighlightAdapter(
    private val highLights: List<HighLightData>,
    private val navController: NavController
) :
    RecyclerView.Adapter<HighlightAdapter.HighlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightViewHolder {
        val binding = HighlightItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HighlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HighlightViewHolder, position: Int) {
        val highlight = highLights[position]
        holder.bind(highlight)
    }

    override fun getItemCount(): Int = highLights.size

    inner class HighlightViewHolder(private val binding: HighlightItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val highlight = highLights[position]
                    val bundle = bundleOf(
                        "highlightText" to highlight.highLight,
                        "imageResId" to highlight.image
                    )
                    navController.navigate(R.id.action_profileFragment_to_highlightDetailsFragment, bundle)
                }
            }
        }

        fun bind(highlight: HighLightData) {
            binding.tvHighlighText.text = highlight.highLight
            binding.ivHighlightImage.setImageResource(highlight.image)
        }
    }
}
