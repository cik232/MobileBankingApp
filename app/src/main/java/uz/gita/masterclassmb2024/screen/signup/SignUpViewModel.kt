package uz.gita.masterclassmb2024.screen.signup

import kotlinx.coroutines.flow.StateFlow

interface SignUpViewModel {
    val progressState: StateFlow<Boolean>

    var message: ((String) -> Unit)?
    var navigateSignUpVerify: ((String) -> Unit)?

    fun signUp(firstName: String, lastName: String)
}