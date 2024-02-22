package uz.gita.masterclassmb2024.data.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.masterclassmb2024.data.api.AuthApi
import uz.gita.masterclassmb2024.data.model.SignUpRequest
import uz.gita.masterclassmb2024.data.repository.AuthRepository
import uz.gita.masterclassmb2024.util.toResult
import java.lang.Exception
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override fun singUp(request: SignUpRequest): Flow<Result<String>> = flow {
        val response = authApi.register(request).toResult { it.token }
        /**
         * val result = when(response.code()){
            in 200 until 300 -> {
                val token = response.body()!!.token
                Result.success(token)
            }
            in 400 until 500 -> {
                val messageResponse = response.errorBody()?.string()!!.parse<ErrorResponse>()
                Result.failure(ErrorMessageException(messageResponse.message))
            }
            in 500 until 600 -> {
                Result.failure(ServerErrorException())
            }
            else -> Result.failure(ServerErrorException())
        }*/
        emit(response)
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)
}


/*

sealed interface ResultData {
    data class IntValue(val value: Int) : ResultData
    data class StringValue(val value: String) : ResultData
}

fun example(): ResultData {
    if (true) {
        return ResultData.IntValue(23)
    } else {
        return ResultData.StringValue("Salom")
    }
}

fun example2(){
    val r = example()
    when(r){
        is ResultData.StringValue -> { r.value }
        is ResultData.IntValue -> {r.value}
    }
}*/
