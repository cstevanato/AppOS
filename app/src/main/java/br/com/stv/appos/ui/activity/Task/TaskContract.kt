package br.com.stv.appos.ui.activity.Task

import br.com.stv.appos.model.Task
import br.com.stv.appos.ui.BasePresenter
import br.com.stv.appos.ui.BaseView

interface TaskContract {

    interface Presenter : BasePresenter {
        fun loadTask()
        fun syncTask()

    }

    interface View: BaseView<Presenter> {
        fun showTasks(taskView: List<Task>)
        fun notifyReceivedTasks()
    }


}