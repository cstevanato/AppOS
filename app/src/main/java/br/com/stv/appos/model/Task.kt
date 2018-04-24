package br.com.stv.appos.model

class Task(val id: Long,
           val title : String,
           val description : String,
           val address : String,
           var km : Int) {
}