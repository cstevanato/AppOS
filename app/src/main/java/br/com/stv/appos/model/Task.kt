package br.com.stv.appos.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Task() : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var title: String? = null
    var description: String? = null
    var address: String? = null
    var status: Int = 0

    constructor(id: Long,
                title: String,
                description: String,
                address: String,
                status: Int) : this() {
        this.id = id
        this.title = title
        this.description = description
        this.address = address
        this.status = status
    }

}