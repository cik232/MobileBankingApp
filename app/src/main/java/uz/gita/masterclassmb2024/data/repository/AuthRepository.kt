package uz.gita.masterclassmb2024.data.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.masterclassmb2024.data.model.SignUpRequest

interface AuthRepository {
    fun singUp(request: SignUpRequest): Flow<Result<String>>
}