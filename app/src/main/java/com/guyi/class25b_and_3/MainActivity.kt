package com.guyi.class25b_and_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guyi.class25b_and_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val SP_NAME = "SP_NAME"
    private val SP_SCORE = "SP_SCORE"

    private lateinit var mspv2: MSPV2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWrite.setOnClickListener { writeToSp() }
        binding.btnRead.setOnClickListener { readFromSp() }
        binding.btnUpdate.setOnClickListener { updateFromSp() }

        mspv2 = MSPV2(this)
    }

    private fun writeToSp() {
//        MSPV1.putString(this, SP_NAME, "Avi")
//        MSPV1.putInt(this, SP_SCORE, 200)

//        mspv2.putString(SP_NAME, "Avi")
//        mspv2.putInt(SP_SCORE, 200)

        MSPV3.getInstance().putString(SP_NAME, "Avi")
        MSPV3.getInstance().putInt(SP_SCORE, 1200)
    }

    private fun readFromSp() {
//        val name = MSPV1.getString(this, SP_NAME, "Unknown")
//        val score = MSPV1.getInt(this, SP_SCORE, -1)

//        val name = mspv2.getString(SP_NAME, "Unknown")
//        val score = mspv2.getInt(SP_SCORE, -1)

        val name = MSPV3.getInstance().getString(SP_NAME, "Unknown")
        val score = MSPV3.getInstance().getInt(SP_SCORE, -1)


        binding.lblInfo.text = "name: $name, score: $score"
    }

    private fun updateFromSp() {
        MySignal.getInstance().vibrate(800)
    }
}