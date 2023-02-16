package com.example.my_new_first_chat.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.my_new_first_chat.ui.fragments.basis.BallFragment
import com.example.my_new_first_chat.ui.fragments.basis.ProfileFragment
import com.example.my_new_first_chat.ui.fragments.basis.chat.ChatFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BallFragment()
            }
            1 -> {
                ChatFragment()
            }
            else -> {
                ProfileFragment()
            }
        }
    }
}