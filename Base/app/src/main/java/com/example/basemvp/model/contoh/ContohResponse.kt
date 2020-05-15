package com.example.basemvp.model.contoh

import com.example.basemvp.model.contoh.ContohData
import com.google.gson.annotations.SerializedName

data class ContohResponse(
    @SerializedName("status")
    val status : Boolean,
    @SerializedName("message")
    val message : String,
    @SerializedName("total")
    val total : Int,
    @SerializedName("data")
    val data : List<ContohData>
)