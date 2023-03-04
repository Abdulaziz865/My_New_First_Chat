package com.example.my_new_first_chat.ui.fragments.basis

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentProfileBinding
import com.example.my_new_first_chat.utils.BaseFragment

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
}