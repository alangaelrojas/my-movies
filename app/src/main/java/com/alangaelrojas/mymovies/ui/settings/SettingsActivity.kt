package com.alangaelrojas.mymovies.ui.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.alangaelrojas.mymovies.R
import com.alangaelrojas.mymovies.databinding.ActivitySettingsBinding
import com.alangaelrojas.mymovies.sys.Constants

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.spnCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val country = binding.spnCountries.selectedItem.toString()
                saveIntoSharedPreferences("country", country)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.spnLanguages.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val language = binding.spnLanguages.selectedItem.toString()
                saveIntoSharedPreferences("language", language)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

    private fun saveIntoSharedPreferences(key: String, value: String) {
        val sharedPreferences =
            getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}