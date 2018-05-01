package br.com.stv.appos.api.call.tarefa

import br.com.stv.appos.api.vo.TarefaListVO
import br.com.stv.appos.api.vo.TarefaVO
import io.reactivex.Observable
import retrofit2.http.GET

interface TarefaApi {
    @GET("tarefas/")
    fun  getTarefas() : Observable<TarefaListVO>
}