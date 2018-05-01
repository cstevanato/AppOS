package br.com.stv.appos.api.vo

import com.google.gson.annotations.SerializedName

data class TarefaVO(
                    @SerializedName("id")
                    val id: Long,
                    @SerializedName("title")
                    val title: String,
                    @SerializedName("description")
                    val description: String,
                    @SerializedName("address")
                    val address: String)