package com.example.my_new_first_chat.ui.fragments.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentLoginBinding
import com.example.my_new_first_chat.extensions.showToast
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var auth: FirebaseAuth
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }
    private fun initialize() {
        auth = FirebaseAuth.getInstance()
    }

    private fun setupListener() = with(binding) {
       loginBtn.setOnClickListener {
           val email = loginEmailPerson.text.toString()
           val password = loginPasswordPerson.text.toString()
           val username = loginUserName.text.toString()
           val id = loginIdPerson.text.toString()

           if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty() && id.isNotEmpty()){
               auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(){
                   if (it.isSuccessful){
                       findNavController().navigate(R.id.homeFragment)
                   }else{
                      binding.loginEmailPerson.error = it.exception.toString()
                   }
               }
           }else{
               showToast("Пусто")
           }
       }
    }
}