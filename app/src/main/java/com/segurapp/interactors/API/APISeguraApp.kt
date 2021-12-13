package com.segurapp.interactors.API


import com.segurapp.interfaces.baseAPI.ConstantsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APISeguraApp {
    companion object{
        private var retrofit: Retrofit? = null
        val client: Retrofit get() {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ConstantsAPI.BASE_URL)
                    .build()
            }
            return retrofit!!
        }
    }
}