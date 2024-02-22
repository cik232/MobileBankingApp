package uz.gita.masterclassmb2024.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.masterclassmb2024.data.model.SignUpRequest
import uz.gita.masterclassmb2024.data.model.TokenResponse

interface AuthApi {
    @POST("auth/sign-up")
    suspend fun register(@Body data: SignUpRequest) : Response<TokenResponse>
}