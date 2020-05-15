package com.example.bidder.model.user

import com.google.gson.annotations.SerializedName

data class DataUser(

    @SerializedName("email")
    val email: String,
    @SerializedName("foto")
    val foto: String,
    @SerializedName("nama")
    val nama: String
)