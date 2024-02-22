package uz.gita.masterclassmb2024.util

import retrofit2.Response
import uz.gita.masterclassmb2024.data.model.ErrorResponse
import uz.gita.masterclassmb2024.data.model.exceptions.ErrorMessageException
import uz.gita.masterclassmb2024.data.model.exceptions.ServerErrorException

fun <T, R> Response<T>.toResult(block: (T) -> R): Result<R> {
    val result = when (code()) {
        in 200 until 300 -> {
            val temp = block(body()!!)
            Result.success(temp)
        }

        in 400 until 500 -> {
            val messageResponse = errorBody()?.string()!!.parse<ErrorResponse>()
            Result.failure(ErrorMessageException(messageResponse.message))
        }

        in 500 until 600 -> {
            Result.failure(ServerErrorException())
        }

        else -> Result.failure(ServerErrorException())
    }
    return result
}