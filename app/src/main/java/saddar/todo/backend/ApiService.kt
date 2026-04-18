package saddar.todo.backend

import retrofit2.http.GET
import retrofit2.http.Header
import saddar.todo.models.generalModels.BuyListModel
import saddar.todo.models.generalModels.CallListModel

interface ApiService {

    @GET("imkhan334/demo-1/call")
    suspend fun callLst(): CallListModel

    @GET("imkhan334/demo-1/buy")
    suspend fun buyList(): BuyListModel
}