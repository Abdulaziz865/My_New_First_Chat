package com.example.my_new_first_chat.ui.fragments.auth

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.my_new_first_chat.R
import com.example.my_new_first_chat.databinding.FragmentSignUpBinding
import com.example.my_new_first_chat.extensions.showToast
import com.example.my_new_first_chat.utils.SharedPreferenceUtil
import com.google.firebase.auth.FirebaseAuth

const val ID: String = "1"

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val binding by viewBinding(FragmentSignUpBinding::bind)
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        onSaveCash()
    }

    private fun initialize() {
        firebaseAuth = FirebaseAuth.getInstance()
        SharedPreferenceUtil.units(requireContext())
    }

    private fun setupListener() {
        binding.signBtn.setOnClickListener {
            val email = binding.signEmailPerson.text.toString()
            val password = binding.signPasswordPerson.text.toString()
            val id = binding.signId.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful && id.isEmpty()) {
                        findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
                        SharedPreferenceUtil.isProver = false
                    } else if (it.isSuccessful && id == "1") {
                        showToast("T")
                        findNavController().navigate(R.id.homeFragment)
                        SharedPreferenceUtil.isProver = true
                        SharedPreferenceUtil.dataAdmin = ID
                    } else {
                        showToast(it.exception.toString())
                    }
                }
            } else {
                showToast("Пусто")
            }
        }

        binding.signForgotPassword.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            val view = layoutInflater.inflate(R.layout.dialog_forgot_password, null)
            val userEmail = view.findViewById<EditText>(R.id.forgot_edit_text)

            builder.setView(view)
            val dialog = builder.create()
            view.findViewById<Button>(R.id.btn_reset).setOnClickListener {
                compareEmail(userEmail)
                dialog.dismiss()
            }
            view.findViewById<Button>(R.id.btn_cansel).setOnClickListener {
                dialog.dismiss()
            }
            if (dialog.window != null) {
                dialog.window?.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }

        binding.signBtnNavigationLogin.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }

    private fun compareEmail(email: EditText) {
        if (email.text.toString().isEmpty()) {
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            return
        }
        firebaseAuth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showToast("Проверьте электронную почту")
            }
        }
    }

    private fun onSaveCash() {
        SharedPreferenceUtil.isPreference = false
    }
}