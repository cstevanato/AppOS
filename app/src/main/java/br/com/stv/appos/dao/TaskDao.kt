package br.com.stv.appos.dao

import br.com.stv.appos.model.Task
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults

class TaskDao {

    fun insert(  id: Long ,
                 title: String,
                 description : String,
                 address : String) {
        val config = RealmConfiguration.Builder()
                .name("task.realm").build()
        val realm = Realm.getInstance(config)

        realm.beginTransaction()
        val task = realm.createObject(Task::class.java, id)
        task.title = title
        task.description = description
        task.address = address
        realm.commitTransaction()

    }

    fun get(): RealmResults<Task>? {
        val config = RealmConfiguration.Builder()
                .name("task.realm").build()
        val realm = Realm.getInstance(config)

        val allTask = realm.where(Task::class.java).findAll()

        return allTask
    }
}