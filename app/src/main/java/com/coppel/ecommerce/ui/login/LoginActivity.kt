package com.coppel.ecommerce.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.coppel.ecommerce.R
import com.coppel.ecommerce.databinding.ActivityLoginBinding
import com.coppel.ecommerce.ktx.viewBinding
import com.coppel.ecommerce.ktx.exhaustive
import com.coppel.ecommerce.ktx.visible
import com.coppel.ecommerce.ktx.gone
import com.coppel.ecommerce.ktx.observe
import com.coppel.ecommerce.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    private val binding: ActivityLoginBinding by viewBinding(ActivityLoginBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setUpView()
        setupObservers()
    }

    private fun setUpView() {
        with(binding) {
            emailTextInputEditText.addTextChangedListener {
                viewModel.email = it.toString().trim()
                viewModel.validateCredentials()
            }
            passwordTextInputEditText.addTextChangedListener {
                viewModel.password = it.toString().trim()
                viewModel.validateCredentials()
            }
            loginButton.setOnClickListener {
                viewModel.doLogin()
            }
        }
    }

    private fun setupObservers() {
        viewModel.isSignInButtonEnabled.observe(this, ::setupEnableSignInButton)
        viewModel.state.observe(this, ::handle)
    }

    private fun setupEnableSignInButton(isEnabled: Boolean) =
        binding.loginButton.apply {
            this.isEnabled = isEnabled
            this.setBackgroundResource(if (isEnabled) R.drawable.blue_rounded else R.drawable.grey_rounded)
        }

    private fun handle(state: LoginViewModel.State?) {
        when (state) {
            LoginViewModel.State.ShowError -> showError()
            LoginViewModel.State.Loading -> showProgress()
            LoginViewModel.State.Success -> {
                hideProgress()
                MainActivity.launch(this)
                finish()
            }
            else -> Unit
        }.exhaustive
    }

    private fun showError() {
        hideProgress()
        Toast.makeText(
            this@LoginActivity,
            getString(R.string.text_error_credentials),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showProgress() {
        with(binding) {
            progressBar.visible()
        }
    }

    private fun hideProgress() {
        with(binding) {
            progressBar.gone()
        }
    }

}