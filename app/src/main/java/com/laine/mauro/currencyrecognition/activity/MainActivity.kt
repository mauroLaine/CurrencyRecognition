package com.laine.mauro.currencyrecognition.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.accessibility.AccessibilityManager
import com.laine.mauro.currencyrecognition.R
import com.laine.mauro.currencyrecognition.setAccessibleButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleImage.contentDescription = this.getString(R.string.start)
        titleImage.setAccessibleButton()
    }

    override fun onResume() {
        super.onResume()
        setViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.AboutActivity -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.SettingsActivity -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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