package com.leonardolsantos.myweather

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leonardolsantos.myweather.model.Element
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import kotlinx.android.synthetic.main.recyclerview_item.view.tv_favorite_city_id
import kotlinx.android.synthetic.main.recyclerview_item.view.tv_favorite_city_name


class MyAdapter(val list: MutableList<Element>?)
    :RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when(holder){
            is MyAdapter.MyViewHolder ->{
                if(position < list!!.size){
                    val element = list?.get(position)
                    if(element != null){
                        holder.bindView(element)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    fun addItems(newElements: MutableList<Element>?){
        list?.clear()
        newElements?.forEach { list?.add(it) }
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvCityname = itemView.tv_favorite_city_name
        val tvCityNumber = itemView.tv_favorite_city_id
        val ivWeather : ImageView = itemView.im_weather

        fun bindView(element: Element): Unit = with(itemView ){
            tvCityname.text = element.name
            tvCityNumber.text = element.id.toString()
            Glide.with(context)
                .load("http://openweathermap.org/img/wn/${element.weather[0].icon}@4x.png")
                .placeholder(R.drawable.ic_weather_placeholder)
                .error(R.drawable.ic_weather_placeholder)
                .circleCrop()
                .into(ivWeather)
        }
    }

    class MyItemDecoration(val size: Int) : RecyclerView.ItemDecoration(){
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


