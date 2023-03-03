package com.example.my_new_first_chat.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.ActivityMainBinding
import com.example.my_new_first_chat.utils.SharedPreferenceUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var controllerNav: NavController
    private lateinit var auth: FirebaseAuth
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        controllerNav = navHostFragment.navController

        when (SharedPreferenceUtil.isPreference) {
            true -> {
                controllerNav.navigate(R.id.homeFragment)
            }
            else -> {
                controllerNav.navigate(R.id.signUpFragment)
            }
        }
    }
}