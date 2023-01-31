package com.example.android52.Retrofit

import android.app.TaskStackBuilder.create
import com.google.android.material.tooltip.TooltipDrawable.create
import com.google.gson.Gson
import retrofit2.Retrofit
import java.net.URI.create

object RetroFitClient {

    private val retroFit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/").addConverterFactory(GsonConventerFactory.create()).build()

    val api: RickAndMortyApi
    get ()= retroFit.create(RickAndMortyApi::class.java)

}