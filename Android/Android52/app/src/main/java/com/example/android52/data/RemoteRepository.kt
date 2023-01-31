package com.example.android52.data

import com.example.android52.data.model.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReomteRepository {

    fun getCharacters(returnSuccess: (Characters) -> Unit, returnOnFailure: (String) -> Unit) {
        RetroFitClient.api.getCharacters(2).enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.isSuccessful)
                    returnSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                returnOnFailure(t.message ?: "unknown error")
            }

        })
    }
}


//fun getCharacters(returnOnSuccess: (Characters) -> Unit, returnOnFailure: (String) -> Unit) {
//    RetrofitClient.api.getCharacters(2).enqueue(object : Callback<Characters> {
//        override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
//            if (response.isSuccessful) returnOnSuccess(response.body()!!)
//        }
//
//        override fun onFailure(call: Call<Characters>, t: Throwable) {
//            returnOnFailure(t.message ?: "Unknown Error")
//        }
//    })
//}