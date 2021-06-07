package com.laine.mauro.currencyrecognition.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager
import androidx.appcompat.app.AppCompatActivity
import com.laine.mauro.currencyrecognition.R
import com.laine.mauro.currencyrecognition.activity.RecognitionActivity
import com.laine.mauro.currencyrecognition.setAccessibleButton
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.titleImage.contentDescription = this.getString(R.string.start)
        view.titleImage.setAccessibleButton()
        return view
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
            val intent = Intent(activity, RecognitionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isTalkbackEnabled(): Boolean {
        val am =
            activity?.getSystemService(AppCompatActivity.ACCESSIBILITY_SERVICE) as AccessibilityManager
        return am.isEnabled && am.isTouchExplorationEnabled
    }
}