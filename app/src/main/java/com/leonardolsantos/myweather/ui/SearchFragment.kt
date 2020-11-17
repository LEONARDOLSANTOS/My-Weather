package com.leonardolsantos.myweather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.leonardolsantos.myweather.R


class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        val searchContainer =  inflater.inflate(R.layout.fragment_search, container, false)
        val textView = searchContainer.findViewById<TextView>(R.id.text_search)
        textView.text = getString(R.string.title_search)
        return searchContainer
    }

}