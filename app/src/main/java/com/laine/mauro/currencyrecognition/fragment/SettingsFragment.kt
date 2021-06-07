package com.laine.mauro.currencyrecognition.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laine.mauro.currencyrecognition.*
import com.laine.mauro.currencyrecognition.activity.LanguageActivity
import kotlinx.android.synthetic.main.fragment_settings.view.*

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        view.textViewLanguage.setOnClickListener {
            val intent = Intent(activity, LanguageActivity::class.java)
            startActivity(intent)
        }

        activity?.let {
            val isFlashlightEnabled = readBooleanConfiguration(it, FLASHLIGHT_KEY)
            view.switchFlashlight.isChecked = isFlashlightEnabled
            view.switchFlashlight.setOnCheckedChangeListener { _, isChecked ->
                saveBooleanConfiguration(it, FLASHLIGHT_KEY, isChecked)
            }

            val isWalletEnabled = readBooleanConfiguration(it, WALLET_KEY)
            view.switchWallet.isChecked = isWalletEnabled
            view.switchWallet.setOnCheckedChangeListener { _, isChecked ->
                saveBooleanConfiguration(it, WALLET_KEY, isChecked)
            }
        }
        return view
    }
}