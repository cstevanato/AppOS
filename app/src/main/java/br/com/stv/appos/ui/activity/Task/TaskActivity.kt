package br.com.stv.appos.ui.activity.Task

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import br.com.stv.appos.R
import br.com.stv.appos.model.Task
import br.com.stv.appos.ui.adapter.TaskAdapter
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.app_bar_task.*
import kotlinx.android.synthetic.main.content_task.*
import br.com.stv.appos.SeparatorDecoration
import io.realm.Realm


class TaskActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, TaskContract.View {
    private val taskPresenter : TaskContract.Presenter by lazy {
        TaskPresenter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        taskPresenter.loadTask()
    }
    private var longClickSelect = -1
    override fun showTasks(taskView: List<Task>) {
        rv_tasks.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val decoration = SeparatorDecoration(this)
        rv_tasks.addItemDecoration(decoration)

        rv_tasks.adapter = TaskAdapter(taskView) {longClickSelect ->
             this.longClickSelect = longClickSelect
        }

        rv_tasks.setOnCreateContextMenuListener { menu: ContextMenu , v : View?, menuInfo: ContextMenu.ContextMenuInfo? ->
            menu.add(Menu.NONE, 1, Menu.NONE, "Executar")
        }
    }



    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.task, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val itemMenu = item?.itemId

        if(itemMenu == 1){
            Toast.makeText(this,"Teste: " + longClickSelect.toString(), Toast.LENGTH_LONG)
        }

        return super.onContextItemSelected(item)
    }
}
