package br.com.stv.appos.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.AdapterView
import br.com.stv.appos.R
import br.com.stv.appos.model.Task
import kotlinx.android.synthetic.main.item_detail_task.view.*

class TaskAdapter(private val tasks: List<Task>, private val delegate: (longClickListener : Int) -> Unit) :
        RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_detail_task, parent, false)


        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        with(holder) {
            title.text = task.title
            description.text = task.description
            address.text = task.address
            //km.text = task.km.toString()

            itemView.setOnLongClickListener {
                delegate(layoutPosition)
                false
            }
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
            //, View.OnCreateContextMenuListener
    {
        val title = itemView.tv_title
        val description = itemView.tv_description
        val address = itemView.tv_address
        //val km = itemView.tv_km

//        init {
//
//
//            itemView.setOnCreateContextMenuListener(this)
//        }
//
//        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
//            val Edit = menu?.add(Menu.NONE, 1, 1, "Edit")
//            val Delete = menu?.add(Menu.NONE, 2, 2, "Delete")
//            Edit?.setOnMenuItemClickListener({
//
//
//
////                val adapterMenuInfo = it.menuInfo as AdapterView.AdapterContextMenuInfo
////                val posicaoTransacao = adapterMenuInfo.position
//                delegate(it.itemId)
//                true
//            })
//            //Delete?.setOnMenuItemClickListener(onEditMenu);
//        }
//



    }
}
