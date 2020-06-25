package com.aomi.mybase.data.preference

interface PreferencesService {

    fun saveString(key: String, value: String)
    fun getString(key: String) : String

    fun saveBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean

    fun saveInt(key: String, value: Int)
    fun getInt(key: String) : Int

    fun saveFloat(key: String, value: Float)
    fun getFloat(key: String) : Float

    fun saveLong(key: String, value: Long)
    fun getLong(key: String) : Long

    fun saveObject(key: String, value: Any)
    fun <T> getObject(key: String, clazz: Class<T>) : T

    fun deleteValue(key: String)

}