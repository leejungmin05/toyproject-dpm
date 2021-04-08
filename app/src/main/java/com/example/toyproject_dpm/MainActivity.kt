package com.example.toyproject_dpm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().add(R.id.mainLinearLayout, PhoneBook()).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.page_phoneBook -> {
                supportFragmentManager.beginTransaction().replace(R.id.mainLinearLayout, PhoneBook()).commitAllowingStateLoss()
                return true
            }
            R.id.page_gallery -> {
                supportFragmentManager.beginTransaction().replace(R.id.mainLinearLayout, Gallery()).commitAllowingStateLoss()
                return true
            }
        }

        return false

    }
}