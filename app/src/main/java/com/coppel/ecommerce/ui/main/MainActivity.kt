package com.coppel.ecommerce.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.coppel.ecommerce.R
import com.coppel.ecommerce.databinding.ActivityMainBinding
import com.coppel.ecommerce.ktx.viewBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.doReadProduct()
    }

    companion object {
        fun launch(from: Context) = from.startActivity(Intent(from, MainActivity::class.java))
    }

}