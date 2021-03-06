package com.example.punky.utils

import android.util.Log

inline val <reified T> T.TAG: String
    get() = T::class.java.simpleName

inline fun <reified T> T.logd(message: String) = Log.d(TAG, message)

inline fun <reified T> T.loge(message: String) = Log.e(TAG, message)

inline fun <reified T> T.logi(message: String) = Log.i(TAG, message)

inline fun <reified T> T.logv(message: String) = Log.v(TAG, message)

inline fun <reified T> T.logw(message: String) = Log.w(TAG, message)

inline fun <reified T> T.logwtf(message: String) = Log.wtf(TAG, message)