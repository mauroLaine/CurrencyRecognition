package com.laine.mauro.currencyrecognition.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

/**
 *
 */
open class BaseActivity : AppCompatActivity() {
    fun Context.getStringResourceByName(stringName: String): String? {
        val resId = resources.getIdentifier(stringName, "string", packageName)
        return getString(resId)
    }
}