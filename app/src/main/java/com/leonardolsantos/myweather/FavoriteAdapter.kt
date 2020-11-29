package com.leonardolsantos.myweather

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leonardolsantos.myweather.model.CityDatabase
import kotlinx.android.synthetic.main.favorites_item.view.*
import kotlinx.android.synthetic.main.favorites_item.view.tv_favorite_city_id
import kotlinx.android.synthetic.main.favorites_item.view.tv_favorite_city_name


class FavoriteAdapter(val list: List<CityDatabase>?)
    : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {

        return FavoriteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.favorites_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        when(holder){
            is FavoriteAdapter.FavoriteViewHolder ->{
                if(position < list!!.size){
                    val element = list?.get(position)
                    if(element != null){
                        holder.bindView(element)
                    }
                }
            }

        }
//        when(holder){
//            else -> if (position < list.size ?: 0) {
//                val element = list.get(position)
//                holder.bindView(element)
//            }
//        }

    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class FavoriteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvCityname = itemView.tv_favorite_city_name
        val tvCityNumber = itemView.tv_favorite_city_id

        fun bindView(cityDatabase: CityDatabase){
            tvCityname.text = cityDatabase.cityName
            tvCityNumber.text = cityDatabase.id.toString()
        }

    }

    class FavoriteItemDecoration(val size: Int) : RecyclerView.ItemDecoration(){
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
                with(outRect){
                    if(parent.getChildAdapterPosition(view)==0){
                        top = size
                    }
                    left=size
                    right=size
                    bottom=size


                }
        }

    }

}