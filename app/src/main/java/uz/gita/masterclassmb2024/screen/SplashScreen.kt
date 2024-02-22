package uz.gita.masterclassmb2024.screen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.masterclassmb2024.R
import uz.gita.masterclassmb2024.databinding.ScreenSplashBinding

class SplashScreen : Fragment(R.layout.screen_splash) {
    private var _viewBinding: ScreenSplashBinding? = null
    private val viewBinding: ScreenSplashBinding get() = _viewBinding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _viewBinding = ScreenSplashBinding.bind(view)

 Handler(Looper.myLooper()!!).postDelayed({
     findNavController().navigate(R.id.action_splashScreen_to_signUpScreen)

 },3000)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}