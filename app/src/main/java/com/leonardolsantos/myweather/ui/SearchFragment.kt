package com.leonardolsantos.myweather.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.leonardolsantos.myweather.R
import com.leonardolsantos.myweather.manager.OpenWeatherManager
import com.leonardolsantos.myweather.model.City
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val searchContainer = inflater.inflate(R.layout.fragment_search, container, false)
//        val button = searchContainer.findViewById<Button>(R.id.btn_search)
//        se utilizar o sintetic tem que colocar no onviewCreate

        return searchContainer
    }

    override fun onClick(view: View?) {
        when(view?.context?.let { isConNecvityAvailable(it) }){
            true -> {
                Toast.makeText(context, "connected", Toast.LENGTH_LONG).show()
                val city = et_search.text.toString()
                Log.d("LLSS", "Searching city: $city")
                val service = OpenWeatherManager().getOpenWeatherService();
                val call = service.getCityWeather(city, "9a1774a535605ebadf5c6d2bc2425f40")
                call.enqueue(object: Callback<City>{
                    override fun onResponse(call: Call<City>, response: Response<City>) {
                        when(response.isSuccessful){
                            true->{
                                val city = response.body()
                                Log.d("LLSS", "Returned City: $city")
                            }
                            false->{
                                Log.e("LLSS", "Response is not success")
                            }

                        }
                    }

                    override fun onFailure(call: Call<City>, t: Throwable) {
                        Log.e("LLSS", "There is an error: ${t.message}")
                    }


                })
            }
            false -> Toast.makeText(context, "not connected", Toast.LENGTH_LONG).show()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById <EditText>(R.id.et_search)
        editText.requestFocus()
        btn_search.setOnClickListener( this )
    }

    @SuppressLint("WrongConstant")
    fun isConNecvityAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var result = false

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                result = when {
                    hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) -> true
                    hasCapability(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasCapability(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            }
        }else{
            cm.activeNetworkInfo?.run {
//                when{
//                    type==ConnectivityManager.TYPE_WIFI -> result = true
//                    type==ConnectivityManager.TYPE_MOBILE -> result = true
//                    else -> result = false
//                }
//                when (type) {
//                    ConnectivityManager.TYPE_WIFI -> result = true
//                    ConnectivityManager.TYPE_MOBILE -> result = true
//                    else -> result = false
//                }
                result = when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    else -> false
                }
            }
        }
        return result

    }


}