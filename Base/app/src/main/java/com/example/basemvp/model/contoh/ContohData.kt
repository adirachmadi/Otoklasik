package com.example.basemvp.model.contoh

import com.google.gson.annotations.SerializedName

data class ContohData(
    @SerializedName("user_id")
    val user_id : String,
    @SerializedName("tanggal_lembur")
    val tanggal_lembur : String,
    @SerializedName("lama_lembur")
    val lama_lembur : String,
    @SerializedName("nama_user")
    val nama_user : String,
    @SerializedName("foto_user")
    val foto_user : String
){
    constructor(): this(
        "",
        "",
        "",
        "",
        "")
}