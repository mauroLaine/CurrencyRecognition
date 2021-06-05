package com.laine.mauro.currencyrecognition.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.laine.mauro.currencyrecognition.R
import com.laine.mauro.currencyrecognition.getStringResourceByName
import com.laine.mauro.currencyrecognition.saveSelectedLanguage


class LanguageAdapter(val context: Context) :
    RecyclerView.Adapter<LanguageAdapter.SimpleViewHolder>() {

    val languages = listOf(
        "English", "Spanish", "Portuguese", "French"
    )

    var languageKeys: HashMap<String, String> = HashMap()

    init {
        languageKeys["English"] = "en"
        languageKeys["Spanish"] = "es"
        languageKeys["Portuguese"] = "pt"
        languageKeys["French"] = "fr"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_language_row, parent, false)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bindData(languages.get(position), position)
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    inner class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewLanguage: TextView = itemView.findViewById(R.id.textViewLanguage)

        fun bindData(language: String, position: Int) {
            textViewLanguage.text = language
            textViewLanguage.setOnClickListener {
                val language: String? = languageKeys.get(languages.get(position))
                language?.let { key ->
                    saveSelectedLanguage(context as Activity, key)
                    val message = getStringResourceByName(context, "language_changed")
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}