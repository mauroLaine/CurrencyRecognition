package com.laine.mauro.currencyrecognition

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Button
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

const val SETTINGS_FILENAME = "settings"
const val LANGUAGE_KEY = "language_key"
const val DEFAULT_LANGUAGE = "en"
const val FLASHLIGHT_KEY = "flashlight_key"
const val WALLET_KEY = "wallet_key"


fun View.setAccessibleButton() {
    ViewCompat.setAccessibilityDelegate(this, object : AccessibilityDelegateCompat() {
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfoCompat?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            info?.className = Button::class.java.name
        }
    })
}

fun saveSelectedLanguage(activityContext: Activity, languageKey: String) {

    val sharedPref =
        activityContext.getSharedPreferences(SETTINGS_FILENAME, Context.MODE_PRIVATE) ?: return

    with(sharedPref.edit()) {
        putString(LANGUAGE_KEY, languageKey)
        apply()
    }
}

fun readSelectedLanguage(activityContext: Activity): String? {
    val sharedPref = activityContext.getSharedPreferences(SETTINGS_FILENAME, Context.MODE_PRIVATE)
    return sharedPref.getString(LANGUAGE_KEY, DEFAULT_LANGUAGE)
}

fun saveBooleanConfiguration(
    activityContext: Activity,
    configurationKey: String,
    isConfigurationEnabled: Boolean
) {
    val sharedPref =
        activityContext.getSharedPreferences(SETTINGS_FILENAME, Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putBoolean(configurationKey, isConfigurationEnabled)
        apply()
    }
}

fun readBooleanConfiguration(activityContext: Activity, configurationKey: String): Boolean {
    val sharedPref = activityContext.getSharedPreferences(SETTINGS_FILENAME, Context.MODE_PRIVATE)
    return sharedPref.getBoolean(configurationKey, false)
}

fun getStringResourceByName(activityContext: Activity, stringName: String): String? {
    val resId =
        activityContext.resources.getIdentifier(stringName, "string", activityContext.packageName)
    return activityContext.getString(resId)
}

fun getCurrencyValue(configurationKey: String): Float {
    if (currencyValuesMap.get(configurationKey) != null) {
        return currencyValuesMap.get(configurationKey)!!
    }
    return 0.0f
}

val currencyValuesMap = hashMapOf(
    "one_cent_us" to 0.01f,
    "five_cent_us" to 0.05f,
    "ten_cent_us" to 0.10f,
    "twenty_five_cent_us" to 0.25f,
    "fifty_cent_us" to 0.50f,
    "one_dollar_us" to 1.00f,
    "two_dollar_us" to 2.00f,
    "five_dollar_us" to 5.00f,
    "ten_dollar_us" to 10.00f,
    "twenty_dollar_us" to 20.00f,
    "fifty_dollar_us" to 50.00f,
    "one_hundred_us" to 100.00f,
    "one_pound_egypt" to 1.00f,
    "ten_euro" to 10.00f
)