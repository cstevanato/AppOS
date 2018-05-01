package br.com.stv.appos.dao

import br.com.stv.appos.api.vo.TarefaVO
import br.com.stv.appos.model.Task
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults

class TaskDao {

    fun insert(  id: Long ,
                 title: String,
                 description : String,
                 address : String) {

        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        val task = realm.createObject(Task::class.java, id)
        task.title = title
        task.description = description
        task.address = address
        realm.commitTransaction()

    }

    fun get(): RealmResults<Task>? {
        val realm = Realm.getDefaultInstance()

        val allTask = realm.where(Task::class.java).findAll()

        return allTask
    }

    fun insertList(tarefas: List<TarefaVO>) {
        val realm = Realm.getDefaultInstance()

        for(item in tarefas ) {
            realm.executeTransaction(
                    {
                        val task = it.createObject(Task::class.java, item.id)
                        task.address= item.address
                        task.description = item.description
                        task.status = 5
                        task.title = item.title
                    }
            )
        }

    }
}