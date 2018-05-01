package br.com.stv.appos.api.vo

import com.google.gson.annotations.SerializedName

data class TarefaListVO (
        @SerializedName("entities")
        val  tarefas : List<TarefaVO>)