package com.laine.mauro.currencyrecognition.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.laine.mauro.currencyrecognition.activity.adapter.LanguageAdapter
import com.laine.mauro.currencyrecognition.R
import kotlinx.android.synthetic.main.activity_language.*

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        recyclerViewLanguages.layoutManager = LinearLayoutManager(this)
        recyclerViewLanguages.adapter = LanguageAdapter(this)
        recyclerViewLanguages.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}