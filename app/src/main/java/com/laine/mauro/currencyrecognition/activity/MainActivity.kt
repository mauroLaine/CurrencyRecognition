package com.laine.mauro.currencyrecognition.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityManager
import androidx.appcompat.app.AppCompatActivity
import com.laine.mauro.currencyrecognition.R
import com.laine.mauro.currencyrecognition.manager.LanguageManager
import com.laine.mauro.currencyrecognition.setAccessibleButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleImage.contentDescription = this.getString(R.string.start)
        titleImage.setAccessibleButton()
        LanguageManager.setLocale(this, LanguageManager.CODE_SPANISH)
    }

    override fun onResume() {
        super.onResume()
        setViews()
    }

    private fun setViews() {
        val selectedView: View?
        if (isTalkbackEnabled()) {
            selectedView = titleImage
            startButton.visibility = View.GONE
        } else {
            selectedView = startButton
        }
        selectedView?.setOnClickListener {
            val intent = Intent(this, RecognitionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isTalkbackEnabled(): Boolean {
        val am = getSystemService(ACCESSIBILITY_SERVICE) as AccessibilityManager
        return am.isEnabled && am.isTouchExplorationEnabled
    }
}