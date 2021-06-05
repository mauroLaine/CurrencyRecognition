package com.laine.mauro.currencyrecognition.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laine.mauro.currencyrecognition.manager.LanguageManager

/**
 * Base Activity designed to wrap general behaviors
 */
open class BaseActivity : AppCompatActivity() {

    fun Context.getStringResourceByName(stringName: String): String? {
        val resId = resources.getIdentifier(stringName, "string", packageName)
        return getString(resId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LanguageManager.setLocale(this, LanguageManager.CODE_US)
    }
}