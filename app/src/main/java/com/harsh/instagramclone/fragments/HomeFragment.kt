package com.harsh.instagramclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.harsh.instagramclone.R
import com.harsh.instagramclone.adapters.PostAdapter
import com.harsh.instagramclone.adapters.StoryAdapter
import com.harsh.instagramclone.databinding.FragmentHomeBinding
import com.harsh.instagramclone.dataclasses.PostData
import com.harsh.instagramclone.dataclasses.StoryData


class HomeFragment : Fragment() {
lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storyList : MutableList<StoryData> = mutableListOf()
        storyList.add(StoryData("user1",R.drawable.user1))
        storyList.add(StoryData("user2",R.drawable.user2))
        storyList.add(StoryData("user3",R.drawable.user3))
        storyList.add(StoryData("user4",R.drawable.user4))
        storyList.add(StoryData("user5",R.drawable.user5))
        storyList.add(StoryData("user6",R.drawable.user6))
        storyList.add(StoryData("user7",R.drawable.user7))
        storyList.add(StoryData("user8",R.drawable.user8))
        storyList.add(StoryData("user9",R.drawable.user9))
        storyList.add(StoryData("user10",R.drawable.user10))
        binding.rvStory.adapter = StoryAdapter(storyList)
        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvStory.layoutManager = layoutManager


        val postList : MutableList<PostData> = mutableListOf()
        postList.add(PostData("user1",R.drawable.user1,R.drawable.user1))
        postList.add(PostData("user2",R.drawable.user2,R.drawable.user2))
        postList.add(PostData("user3",R.drawable.user3,R.drawable.user3))
        postList.add(PostData("user4",R.drawable.user4,R.drawable.user4))
        postList.add(PostData("user5",R.drawable.user5,R.drawable.user5))
        postList.add(PostData("user6",R.drawable.user6,R.drawable.user6))
        postList.add(PostData("user7",R.drawable.user7,R.drawable.user7))
        postList.add(PostData("user8",R.drawable.user8,R.drawable.user8))
        postList.add(PostData("user9",R.drawable.user9,R.drawable.user9))
        postList.add(PostData("user10",R.drawable.user10,R.drawable.user10))
        binding.rvHomePosts.adapter = PostAdapter(postList)
        val layoutManager2 = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rvHomePosts.layoutManager = layoutManager2
    }

    companion object {

    }
}