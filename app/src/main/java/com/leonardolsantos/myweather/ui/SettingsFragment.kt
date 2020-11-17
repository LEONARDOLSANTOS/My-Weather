package com.leonardolsantos.myweather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.leonardolsantos.myweather.R


class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val settingsContainer =  inflater.inflate(R.layout.fragment_settings, container, false)
        val textView = settingsContainer.findViewById<TextView>(R.id.text_settings)
        textView.text = getString(R.string.title_settings)
        return  settingsContainer
    }

}