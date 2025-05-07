package com.guyi.class25b_and_3

import android.content.Context
import android.content.SharedPreferences
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Toast


class MySignal {

    private val SP_FILE_NAME = "MySpFile"

    private lateinit var context: Context
    private var ringtone: Ringtone? = null

    private constructor(context: Context) {
        this.context = context
    }

    companion object{
        @Volatile
        private var instance: MySignal? = null

        fun init(context: Context): MySignal{
            return instance ?: synchronized(this){
                instance?: MySignal(context).also {  instance = it }
            }
        }

        fun getInstance(): MySignal{
            return instance ?: throw IllegalStateException(
                "MySignal must be initialized by calling init(context) before use."
            )
        }
    }

    fun sound() {
        val notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        ringtone?.stop()
        ringtone = RingtoneManager.getRingtone(context, notificationUri)
        ringtone?.play()
    }

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun vibrate(durationMillis: Long = 500) {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                // API 31 and above: VibratorManager
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                val vibrator = vibratorManager.defaultVibrator
                vibrator.vibrate(VibrationEffect.createOneShot(durationMillis, VibrationEffect.DEFAULT_AMPLITUDE))
            }

            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                // API 26 to 30: Vibrator with VibrationEffect
                val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(VibrationEffect.createOneShot(durationMillis, VibrationEffect.DEFAULT_AMPLITUDE))
            }

            else -> {
                // Below API 26: Deprecated vibrate method without VibrationEffect
                val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                @Suppress("DEPRECATION")
                vibrator.vibrate(durationMillis)
            }
        }
    }

}