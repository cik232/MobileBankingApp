package uz.gita.masterclassmb2024.util

import com.google.gson.Gson

val gson = Gson()

inline fun <reified T> String.parse(): T {
    return gson.fromJson(this, T::class.java)
}