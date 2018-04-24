package br.com.stv.appos.ui.activity.Task

import android.content.Context
import br.com.stv.appos.model.Task

class TaskPresenter (private val context: Context,
                     private val taskView : TaskContract.View) : TaskContract.Presenter {

    private val tasks : MutableList<Task> = mutableListOf()
    private val taskList :List<Task> = tasks

    init {
        tasks.add(Task(1,"AAAAA", "BBBBB", "Rua: Regiente Feijo 1364 ap 32, Centro, Campinas", 100 ))
        tasks.add(Task(2,"CCCCCC", "CCCCCC", "Rua: Regiente Feijo 1364 ap 32, Centro, Campinas", 100 ))
        tasks.add(Task(3,"DDDDDD", "DDDDDD", "Rua: Regiente Feijo 1364 ap 32, Centro, Campinas", 100 ))

    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadTask() {
        taskView.showTasks(taskList)
    }

}
