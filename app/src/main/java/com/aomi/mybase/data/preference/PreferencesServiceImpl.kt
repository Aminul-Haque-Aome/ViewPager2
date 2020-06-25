package com.aomi.mybase.data.preference

import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

class PreferencesServiceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesService {

    private var editor = sharedPreferences.edit()

    override fun saveString(key: String, value: String) {
        editor.putString(key, value).apply()
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

    override fun saveBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).apply()
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    override fun saveInt(key: String, value: Int) {
        editor.putInt(key, value).apply()
    }

    override fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, -1)
    }

    override fun saveFloat(key: String, value: Float) {
        editor.putFloat(key, value).apply()
    }

    override fun getFloat(key: String): Float {
        return sharedPreferences.getFloat(key, -1F)
    }

    override fun saveLong(key: String, value: Long) {
        editor.putLong(key, value).apply()
    }

    override fun getLong(key: String): Long {
        return sharedPreferences.getLong(key, -1L)
    }

    override fun saveObject(key: String, value: Any) {
        val valueString = Gson().toJson(value)
        saveString(key, valueString)
    }

    override fun <T> getObject(key: String, clazz: Class<T>): T {
        return Gson().fromJson(sharedPreferences.getString(key, "{}"), clazz)
    }

    override fun deleteValue(key: String) {
        if (sharedPreferences.contains(key)) {
            editor.remove(key).apply()
        }
    }
}