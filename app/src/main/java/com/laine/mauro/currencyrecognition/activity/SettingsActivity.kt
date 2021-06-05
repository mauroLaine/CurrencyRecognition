package com.laine.mauro.currencyrecognition.activity

import android.content.Intent
import android.os.Bundle
import com.laine.mauro.currencyrecognition.R
import kotlinx.android.synthetic.main.rv_language_row.*

class SettingsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        textViewLanguage.setOnClickListener {
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }
    }
}