package br.com.stv.appos.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Task(): RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var title: String? = null
    var description : String? = null
    var address : String? = null
}