package br.com.stv.appos.ui.activity.Task

import android.content.Context
import br.com.stv.appos.api.call.tarefa.TarefaServer
import br.com.stv.appos.api.vo.TarefaListVO
import br.com.stv.appos.api.vo.TarefaVO
import br.com.stv.appos.dao.TaskDao
import br.com.stv.appos.model.Task
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class TaskPresenter (private val context: Context,
                     private val taskView : TaskContract.View) : TaskContract.Presenter {

    private val bus = EventBus.getDefault()

    private val tasks : MutableList<Task> = mutableListOf()
    private val taskList :List<Task> = tasks

    private val tarefaServer: TarefaServer by lazy {
        TarefaServer()
    }

    private val taskDao by lazy {
        TaskDao()
    }
    init {
        bus.register(this)
    }


    @Subscribe
    fun response(tarefaListVO: TarefaListVO) {
        taskDao.insertList(tarefaListVO.tarefas)
        for (item in tarefaListVO.tarefas) {
            tasks.add(Task(item.id,
                    item.title,
                    item.description,
                    item.address,
                    5))
        }

        notifyReceivedTasks()
    }

    private fun notifyReceivedTasks() {
       taskView.notifyReceivedTasks()
    }

    override fun dispose() {
        bus.unregister(this)
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadTask() {
        tasks.addAll(TaskDao().get()!!)
        taskView.showTasks(taskList)
    }

    override fun syncTask() {
        tarefaServer.getSyncTask()
    }

}
