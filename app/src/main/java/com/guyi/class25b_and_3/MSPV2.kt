package com.guyi.class25b_and_3

import android.content.Context
import android.content.SharedPreferences


class MSPV2 {

    private val SP_FILE_NAME = "MySpFile"

    private lateinit var sharedPreferences: SharedPreferences

    constructor(context: Context) {
        sharedPreferences = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE) ?: return
    }



    fun putString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            commit()
        }
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun putInt(key: String, value: Int) {
        with(sharedPreferences.edit()) {
            putInt(key, value)
            commit()
        }
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }
}