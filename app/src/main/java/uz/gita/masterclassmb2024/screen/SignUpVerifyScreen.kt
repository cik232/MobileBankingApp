package uz.gita.masterclassmb2024.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import uz.gita.masterclassmb2024.R
import uz.gita.masterclassmb2024.databinding.ScreenSignUpVerifyBinding

class SignUpVerifyScreen : Fragment(R.layout.screen_sign_up_verify) {
    private var _viewBinding: ScreenSignUpVerifyBinding? = null
    private val viewBinding: ScreenSignUpVerifyBinding get() = _viewBinding!!

    private val args: SignUpVerifyScreenArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _viewBinding = ScreenSignUpVerifyBinding.bind(view)
        viewBinding.textToken.text = args.token
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}