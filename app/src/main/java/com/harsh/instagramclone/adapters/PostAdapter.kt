package com.harsh.instagramclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.harsh.instagramclone.R
import com.harsh.instagramclone.dataclasses.PostData

class PostAdapter(var postList: List<PostData>) : RecyclerView.Adapter<PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)

    }

    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.isLiked = false
        holder.isBookmarked = false
     holder.postPic.setImageResource(postList[position].post)
        holder.profilePic.setImageResource(postList[position].profilePicture)
        holder.userName.text = postList[position].userName

        holder.likeImage.setOnClickListener {
            holder.isLiked = !holder.isLiked
            holder.likeImage.setImageResource(
                if (holder.isLiked) R.drawable.heart else R.drawable.like
            )
        }

        // Handle bookmark button click
        holder.bookmarkImage.setOnClickListener {
            holder.isBookmarked = !holder.isBookmarked
            holder.bookmarkImage.setImageResource(
                if (holder.isBookmarked) R.drawable.bookmarked else R.drawable.bookmark
            )
        }
        holder.commentPic.setOnClickListener(){
            Toast.makeText(holder.itemView.context, "Comment Added", Toast.LENGTH_SHORT).show()
        }
        holder.sharePic.setOnClickListener(){
            Toast.makeText(holder.itemView.context, "Sent", Toast.LENGTH_SHORT).show()
        }


    }
}

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val profilePic = itemView.findViewById<ImageView>(R.id.iv_profile_picture)
    val postPic = itemView.findViewById<ImageView>(R.id.iv_post)
    val userName = itemView.findViewById<TextView>(R.id.tv_post_username)
    val likeImage = itemView.findViewById<ImageView>(R.id.like_img)
    val bookmarkImage = itemView.findViewById<ImageView>(R.id.bookmark_img)
    var isLiked: Boolean = false
    var isBookmarked: Boolean = false
    val commentPic = itemView.findViewById<ImageView>(R.id.comment_img)
    val sharePic = itemView.findViewById<ImageView>(R.id.share_img)


}
