package uz.gita.masterclassmb2024.screen.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.masterclassmb2024.data.model.SignUpRequest
import uz.gita.masterclassmb2024.data.model.exceptions.ErrorMessageException
import uz.gita.masterclassmb2024.data.model.exceptions.ServerErrorException
import uz.gita.masterclassmb2024.data.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository
) : SignUpViewModel, ViewModel() {

    override val progressState = MutableStateFlow(false)

    override var message: ((String) -> Unit)? = null
    override var navigateSignUpVerify: ((String) -> Unit)? = null

    override fun signUp(firstName: String, lastName: String) {
        val request = SignUpRequest(
            phone = "+998936949666",
            password = "1234567",
            firstName = firstName,
            lastName = lastName,
            bornDate = 1,
            gender = 0
        )
        progressState.tryEmit(true)
        authRepository.singUp(request)
            .onEach {
                progressState.emit(false)
                it.onSuccess {
                    Log.d("TTT", "Success")
                    navigateSignUpVerify?.invoke(it)
                }.onFailure {
                    Log.d("TTT", "onFailure=$it")
                    val text = when (it) {
                        is ServerErrorException -> "Serverda xatolik sodir bo'ldi!"
                        is ErrorMessageException -> it.message.toString()
                        else -> "Internet bilan bog'lanishda muamo bor!"
                    }
                    message?.invoke(text)
                }
            }
            .launchIn(viewModelScope)

    }
}