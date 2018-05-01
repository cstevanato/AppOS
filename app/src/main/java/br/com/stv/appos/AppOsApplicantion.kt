package br.com.stv.appos

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class AppOsApplicantion: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val config = RealmConfiguration.Builder()
                .name("task.realm")
                .schemaVersion(2)
                .build()
        Realm.setDefaultConfiguration(config)
    }
}