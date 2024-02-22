package uz.gita.masterclassmb2024.screen.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.masterclassmb2024.R
import uz.gita.masterclassmb2024.databinding.ScreenSignUpBinding

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.screen_sign_up) {
    private var _viewBinding: ScreenSignUpBinding? = null
    private val viewBinding: ScreenSignUpBinding get() = _viewBinding!!
    private val viewModel: SignUpViewModel by viewModels<SignUpViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _viewBinding = ScreenSignUpBinding.bind(view)
        registerEvents()
        registerNavigation()
        registerStates()
    }

    private fun registerStates() {
        viewModel.progressState
            .onEach { viewBinding.progressLayout.isVisible = it }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun registerEvents() {
        viewBinding.btnSignUp.setOnClickListener {
            val firstName = "Alijonov"
            val lastName = "Azamjon"
            viewModel.signUp(firstName, lastName)
        }
    }

    private fun registerNavigation() {
        viewModel.navigateSignUpVerify = { token ->
            val direction = SignUpScreenDirections.actionSignUpScreenToSignUpVerifyScreen(token)
            findNavController().navigate(direction)
        }
        viewModel.message = {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}