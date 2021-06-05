package com.laine.mauro.currencyrecognition.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laine.mauro.currencyrecognition.manager.LanguageManager
import com.laine.mauro.currencyrecognition.readSelectedLanguage

/**
 * Base Activity designed to wrap general behaviors
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val languageCode = readSelectedLanguage(this)
        LanguageManager.setLocale(this, languageCode)
    }
}