package com.guyi.class25b_and_3

import android.content.Context


object MSPV1 {

    const val SP_FILE_NAME = "MySpFile"

    fun putString(context: Context, key: String, value: String) {
        val sharedPreferences = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE) ?: return
        with(sharedPreferences.edit()) {
            putString(key, value)
            commit()
        }
    }

    fun getString(context: Context, key: String, defaultValue: String): String {
        val sharedPreferences = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE) ?: return defaultValue
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun putInt(context: Context, key: String, value: Int) {
        val sharedPreferences = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE) ?: return
        with(sharedPreferences.edit()) {
            putInt(key, value)
            commit()
        }
    }

    fun getInt(context: Context, key: String, defaultValue: Int): Int {
        val sharedPreferences = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE) ?: return defaultValue
        return sharedPreferences.getInt(key, defaultValue)
    }
}