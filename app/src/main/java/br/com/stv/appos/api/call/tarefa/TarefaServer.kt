package br.com.stv.appos.api.call.tarefa

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class TarefaServer {

    private val bus = EventBus.getDefault()
    private val BASE_URL = "http://192.168.0.106:3000/"

    private val retorfit: Retrofit by  lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getSyncTask() {
        retorfit.create(TarefaApi::class.java)
                .getTarefas()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    bus.post(it)
                }, {
                    it.printStackTrace()
                })
    }

}