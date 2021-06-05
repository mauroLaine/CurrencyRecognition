package com.laine.mauro.currencyrecognition.manager

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*


/**
 * Class to switch languages in the app
 */
class LanguageManager {

    companion object {
        const val CODE_SPANISH = "es"
        const val CODE_PORTUGUESE = "pt"
        const val CODE_FRANCE = "fr"
        const val CODE_US = "en"

        fun setLocale(activity: Activity, languageCode: String?) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val resources: Resources = activity.resources
            val config: Configuration = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }
}