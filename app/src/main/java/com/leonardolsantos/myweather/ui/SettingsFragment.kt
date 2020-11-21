package com.leonardolsantos.myweather.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.forEachIndexed
import com.leonardolsantos.myweather.R


class SettingsFragment : Fragment() {
    private lateinit var prefs: SharedPreferences
    private lateinit var rgTemperature: RadioGroup
    private lateinit var rgLanguague: RadioGroup

    private lateinit var rbCelcius : RadioButton
    private lateinit var rbF: RadioButton

    private lateinit var rbEnglish : RadioButton
    private lateinit var rbPortuguese: RadioButton

    private lateinit var btnSave: Button

    private var temperatureUnit = ""
    private var language = ""

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSave = view.findViewById(R.id.btn_save)
        btnSave.setOnClickListener {
            onSaveClicked(it)
        }

        prefs = view.context.getSharedPreferences("my_weather_prefs", Context.MODE_PRIVATE)

        language= prefs?.getString("language", "EN").toString()
        temperatureUnit= prefs?.getString("temperature_unit", "C").toString()

        rbCelcius = view.findViewById(R.id.rb_c)
        rbF = view.findViewById(R.id.rb_f)
        rbEnglish = view.findViewById(R.id.rb_english)
        rbPortuguese = view.findViewById(R.id.rb_portuguese)

        when(temperatureUnit){
            "C"-> rbCelcius.isChecked = true
            "F"-> rbF.isChecked = true
        }
        when(language){
            "EN"-> rbEnglish.isChecked = true
            "PT"-> rbPortuguese.isChecked = true
        }

        rgTemperature = view.findViewById(R.id.rg_temperature_unit)
        rgLanguague = view.findViewById(R.id.rg_language)

        rgTemperature.setOnCheckedChangeListener{view, id->
            val radioButton = view.findViewById<RadioButton>(id)
            if(radioButton.isChecked){
                when (radioButton.id){
                    R.id.rb_c -> temperatureUnit = "C"
                    R.id.rb_f -> temperatureUnit = "F"
                }
            }
        }
        rgLanguague.setOnCheckedChangeListener{view, id->
            val radioButton = view.findViewById<RadioButton>(id)
            if(radioButton.isChecked){
                when (radioButton.id){
                    R.id.rb_english -> language = "EN"
                    R.id.rb_portuguese -> language = "PT"
                }
            }
        }

    }

     fun onSaveClicked(view: View){
        val editor = prefs?.edit()
        editor?.apply(){
            putString("temperature_unit", temperatureUnit)
            putString("language", language)
            apply()
        }

    }

}