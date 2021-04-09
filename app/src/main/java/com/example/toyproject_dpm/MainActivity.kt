package com.example.toyproject_dpm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.toyproject_dpm.databinding.ActivityMainBinding
import com.example.toyproject_dpm.gallery.GalleryFragment
import com.example.toyproject_dpm.phonebook.PhoneBookFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_phone_book_fragment.*

private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var mBinding: ActivityMainBinding

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val newFragment = when (item.itemId) {
            R.id.page_phoneBook -> PhoneBookFragment()
            R.id.page_gallery -> GalleryFragment()
            else -> null
        } ?: run {
            return false
        }
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, newFragment).commit()
        return true
    }

    fun addContact(view: View) {
        Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, PhoneBookFragment())
            .commit()

    }

}