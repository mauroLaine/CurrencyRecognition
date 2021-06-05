package com.laine.mauro.currencyrecognition.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laine.mauro.currencyrecognition.*
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.rv_language_row.textViewLanguage

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        textViewLanguage.setOnClickListener {
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }

        val isFlashlightEnabled = readBooleanConfiguration(this, FLASHLIGHT_KEY)
        switchFlashlight.isChecked = isFlashlightEnabled
        switchFlashlight.setOnCheckedChangeListener { _, isChecked ->
            saveBooleanConfiguration(this, FLASHLIGHT_KEY, isChecked)
        }

        val isWalletEnabled = readBooleanConfiguration(this, WALLET_KEY)
        switchWallet.isChecked = isWalletEnabled
        switchWallet.setOnCheckedChangeListener { _, isChecked ->
            saveBooleanConfiguration(this, WALLET_KEY, isChecked)
        }
    }
}