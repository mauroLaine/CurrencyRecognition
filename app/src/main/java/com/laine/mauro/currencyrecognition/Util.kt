package com.laine.mauro.currencyrecognition

import android.view.View
import android.widget.Button
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

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