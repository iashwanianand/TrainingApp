package com.chetu.trainingapp.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.chetu.trainingapp.base.BaseActivity
import com.chetu.trainingapp.databinding.ActivityLoginBinding
import com.chetu.trainingapp.logger.Logger_New

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            when {
                binding.email.text.isNullOrEmpty() ->
                    Toast.makeText(applicationContext, "Enter your Email Id", Toast.LENGTH_SHORT).show()
//                    Toast(this).showCustomToast("Enter your Email Id", this)

                !Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches() ->
                    Toast.makeText(applicationContext, "Enter a valid Email Id", Toast.LENGTH_SHORT).show()

                binding.password.text.isNullOrEmpty() ->
                    Toast.makeText(applicationContext,"Enter your Password",Toast.LENGTH_SHORT).show()

                binding.password.text.toString().length < 8 ->
                    Toast.makeText(applicationContext,"Password must be of 8 character",Toast.LENGTH_SHORT).show()

                else -> {
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                    intent = Intent(this, DashboardActivity::class.java)
                    val email = binding.email.text.toString()
                    val password = binding.password.text.toString()
                    intent.putExtra("email", email)
                    intent.putExtra("password", password)
                    startActivity(intent)
                    Logger_New.writeToLogFile(context, "setOnClickListener", "setOnClickListener", "setOnClickListener() invoked")
                }
            }
        }
    }
}