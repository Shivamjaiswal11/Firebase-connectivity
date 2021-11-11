package com.example.tablayoutfragment

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Spinner
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

lateinit var tabLayout: TabLayout;
lateinit var viewPager: ViewPager;
 lateinit var spinner: Spinner;
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

      val Adapterfragment= FragementAdapter(supportFragmentManager)
        viewPager.adapter= Adapterfragment;
        tabLayout.setupWithViewPager(viewPager)
        Firebase.messaging.subscribeToTopic("weather")
            .addOnCompleteListener { task ->
                var msg ="Done"
                if (!task.isSuccessful) {
                    msg = "Failed"
                }

            }


    }
}