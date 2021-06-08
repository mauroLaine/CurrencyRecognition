package com.laine.mauro.currencyrecognition.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.accessibility.AccessibilityManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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
        setHasOptionsMenu(true)
        return view
    }

    override fun onResume() {
        super.onResume()
        setViews()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
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