package com.harsh.instagramclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.harsh.instagramclone.R
import com.harsh.instagramclone.adapters.HighlightAdapter
import com.harsh.instagramclone.adapters.ProfileImageAdapter
import com.harsh.instagramclone.databinding.FragmentProfileBinding
import com.harsh.instagramclone.dataclasses.HighLightData
import com.harsh.instagramclone.dataclasses.ProfileImageData

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: MutableList<HighLightData> = mutableListOf()
        list.add(HighLightData("home", R.drawable.user1))
        list.add(HighLightData("friends", R.drawable.user1))
        list.add(HighLightData("travel", R.drawable.user1))
        list.add(HighLightData("cooking", R.drawable.user1))
        list.add(HighLightData("work", R.drawable.user1))
        binding.rvHighlights.adapter = HighlightAdapter(list)
        val layoutManager1 = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvHighlights.layoutManager = layoutManager1
        val profileImages = listOf(
            ProfileImageData(R.drawable.user1),
            ProfileImageData(R.drawable.user2),
            ProfileImageData(R.drawable.user3),
            ProfileImageData(R.drawable.user1),
            ProfileImageData(R.drawable.user2),
            ProfileImageData(R.drawable.user3),
            ProfileImageData (R.drawable.user1),
            ProfileImageData(R.drawable.user2),
            ProfileImageData(R.drawable.user3),
            ProfileImageData(R.drawable.user1),
            ProfileImageData(R.drawable.user2),
            ProfileImageData(R.drawable.user3)
        )

        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvProfileImages.layoutManager = layoutManager

        // Set up adapter for RecyclerView
        val adapter = ProfileImageAdapter(profileImages)
        binding.rvProfileImages.adapter = adapter

    }

    companion object {

    }
}