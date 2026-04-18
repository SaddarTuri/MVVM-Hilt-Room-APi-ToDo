package saddar.todo.backend

import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import saddar.todo.utils.safeApiCall
import javax.inject.Inject

class ServerRepository @Inject constructor(
    private val apiServices: ApiService
) {
    private val dispatcher = Dispatchers.IO

    //Call List
    suspend fun callList() = withContext(dispatcher) {
        safeApiCall {
            Result.success(apiServices.callLst())
        }
    }

    //Buy List
    suspend fun buyList() = withContext(dispatcher) {
        safeApiCall {
            Result.success(apiServices.buyList())
        }
    }

}