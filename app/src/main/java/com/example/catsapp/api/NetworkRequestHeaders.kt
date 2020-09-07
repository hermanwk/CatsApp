package com.example.catsapp.api

import com.example.catsapp.BuildConfig
import kotlin.collections.HashMap

class NetworkRequestHeaders() {
    fun getDefaultHeaders(): HashMap<String, String> {
        val headers = HashMap<String, String>()
        headers["x-api-key"] = BuildConfig.CAT_API_KEY

        return headers
    }
}