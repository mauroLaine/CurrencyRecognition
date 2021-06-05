package com.laine.mauro.currencyrecognition

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Button
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

const val LANGUAGE_KEY = "language_key"
const val DEFAULT_LANGUAGE = "en"

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
    val sharedPref = activityContext.getPreferences(Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putString(LANGUAGE_KEY, languageKey)
        apply()
    }
}

fun readSelectedLanguage(activityContext: Activity): String? {
    val sharedPref = activityContext.getPreferences(Context.MODE_PRIVATE)
    return sharedPref.getString(LANGUAGE_KEY, DEFAULT_LANGUAGE)
}

fun getStringResourceByName(activityContext: Activity, stringName: String): String? {
    val resId =
        activityContext.resources.getIdentifier(stringName, "string", activityContext.packageName)
    return activityContext.getString(resId)
}