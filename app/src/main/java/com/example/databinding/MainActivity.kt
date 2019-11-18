package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Ching Chong", "123")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonSetName.setOnClickListener{
            //it = object (button) associated to an event
            setName(it)
        }
        binding.myName = myName
    }

    private fun setName(it: View?) {
        //apply = execute multiple setters
        binding.apply {
            myName?.name = editTextName.text.toString()
            myName?.contactNo = editTextContactNo.text.toString()
            editTextName.visibility = View.VISIBLE
            this.invalidateAll()
        }
    }


}
