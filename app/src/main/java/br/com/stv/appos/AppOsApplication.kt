package br.com.stv.appos

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class AppOsApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        configDataBaseRealm()

    }

    private fun configDataBaseRealm() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("task.realm")
                .schemaVersion(1)
                .build()
        Realm.setDefaultConfiguration(config)
    }
}