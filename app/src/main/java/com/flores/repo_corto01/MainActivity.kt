package com.flores.repo_corto01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import com.flores.repo_corto01.fragments.RoomateFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //implementando roomate_fragment:
        val fragmentM = supportFragmentManager
        val switchFragment = RoomateFragment.newInstance()

        fragmentM
            .beginTransaction()
            .replace(R.id.frame_main, switchFragment)
            .addToBackStack(null)
            .commit()
    }

}