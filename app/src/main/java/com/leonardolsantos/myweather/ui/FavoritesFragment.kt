package com.leonardolsantos.myweather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.leonardolsantos.myweather.FavoriteAdapter
import com.leonardolsantos.myweather.R
import com.leonardolsantos.myweather.database.MyWeatherAppDatabase

import kotlinx.android.synthetic.main.fragment_favorites.*



class FavoritesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val favoritesContainer  = inflater.inflate(R.layout.fragment_favorites, container, false)

                return  favoritesContainer
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = context?.let { MyWeatherAppDatabase.getInstance(it) }

        val list = db?.cityDatabaseDao()?.getAllCityDatabase()
        favoriteRecyclerView.adapter = FavoriteAdapter(list)
        favoriteRecyclerView.layoutManager = LinearLayoutManager(context)
        favoriteRecyclerView.addItemDecoration(FavoriteAdapter.FavoriteItemDecoration(25))

    }
}