package com.example.wfiappkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import com.example.wfiappkotlin.data.DataProvider
import com.example.wfiappkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (DataProvider.institutes.isEmpty())
            DataProvider.getInstituteData(this)
    }
}