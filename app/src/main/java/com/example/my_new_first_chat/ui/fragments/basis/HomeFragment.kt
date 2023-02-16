package com.example.my_new_first_chat.ui.fragments.basis

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentBallBinding
import com.example.my_new_first_chat.databinding.FragmentHomeBinding
import com.example.my_new_first_chat.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val navArgs by navArgs<HomeFragmentArgs>()
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        auth = FirebaseAuth.getInstance()
        tabLayout()
    }

    private fun tabLayout() {
        binding.viewPager2.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Ball"
                    binding.sC.visibility = View.VISIBLE
                    binding.sC.text = navArgs.id.toString()
                }
                1 -> {
                    tab.text = "Chat"
                }
                2 -> {
                    tab.text = "Profile"
                }
            }
        }.attach()
    }
}