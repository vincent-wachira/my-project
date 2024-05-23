package com.example.stager2
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.stager2.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class MainActivity2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.signup.setOnClickListener {

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            if (checkAlldetails()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val jay = Intent(this, Manager::class.java)
                        startActivity(jay)
                        Toast.makeText(this,"logged in", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.e("error", it.exception.toString())
                    }
                }
            }

        }
    }

    private fun checkAlldetails(): Boolean {
        val email = binding.email.text.toString()
        if (binding.email.text.toString() == "") {
            binding.email.error = "Please input your email"
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.error = "Please input your email"
            return false
        }


        if (binding.password.text.toString() == "") {
            binding.password.error = "Please input your password"
            return false
        }
        if (binding.confirmpassword.text.toString() != binding.confirmpassword.text.toString()) {
            binding.confirmpassword.error = "Please confirm your password"
            return false
        }

        return true

    }}