package com.flores.repo_corto01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import com.flores.repo_corto01.fragments.RoomateFragment

class MainActivity : AppCompatActivity() {

    private var stringStudentBox = ""
    private var stringParejas = ""

    companion object{
        const val ACTUAL_STRING_PAREJAS="ACTUAL_STRING_PAREJAS"
        const val ACTUAL_STRING_BOX="ACTUAL_STRING_BOX"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let{
            stringParejas = it.getString(ACTUAL_STRING_PAREJAS, "")
            stringStudentBox = it.getString(ACTUAL_STRING_BOX, "")
        }


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