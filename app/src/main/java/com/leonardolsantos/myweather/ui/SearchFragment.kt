package com.leonardolsantos.myweather.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.leonardolsantos.myweather.R
import kotlinx.android.synthetic.main.fragment_search.*


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
            true -> Toast.makeText(context, "ta ligado", Toast.LENGTH_LONG).show()
            false -> Toast.makeText(context, "nao ta ligado", Toast.LENGTH_LONG).show()
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