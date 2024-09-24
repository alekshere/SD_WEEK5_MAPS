package com.example.yelpapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username=findViewById(R.id.usernameText)
        password=findViewById(R.id.editTextTextPassword)
        loginBtn=findViewById(R.id.loginButton)



        loginBtn.setOnClickListener {
            //val intent: Intent = Intent(this@MainActivity, CountryList::class.java)
            val intent: Intent = Intent(this@MainActivity, MapsActivity::class.java)
            startActivity(intent)
        }
        username.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)





    }
    private val textWatcher: TextWatcher=object:TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val inputtedUsername:String=username.text.toString()
            val inputtedPassword:String=password.text.toString()

            val enableButton: Boolean=inputtedUsername.isNotBlank()&& inputtedPassword.isNotBlank()
            loginBtn.setEnabled(enableButton)
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }
}