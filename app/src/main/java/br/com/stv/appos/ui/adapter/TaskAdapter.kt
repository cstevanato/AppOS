package br.com.stv.appos.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.stv.appos.R
import br.com.stv.appos.model.Task
import kotlinx.android.synthetic.main.item_detail_task.view.*

class TaskAdapter(private val tasks : List<Task>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_detail_task, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.valor2.text = tasks[position].valor1
        holder.valor3.text = tasks[position].valor2
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val valor2 = itemView.textView2
        val valor3 = itemView.textView3

    }
}