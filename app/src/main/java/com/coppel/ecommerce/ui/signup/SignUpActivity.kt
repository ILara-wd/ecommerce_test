package com.coppel.ecommerce.ui.signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.coppel.ecommerce.R
import com.coppel.ecommerce.databinding.ActivitySignUpBinding
import com.coppel.ecommerce.ktx.*
import com.coppel.ecommerce.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by viewModels()
    private val binding: ActivitySignUpBinding by viewBinding(ActivitySignUpBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setUpView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.isSignUpButtonEnabled.observe(this, ::setupEnableSignUpButton)
        viewModel.state.observe(this, ::handle)
    }

    private fun setupEnableSignUpButton(isEnabled: Boolean) =
        binding.registerButton.apply {
            this.isEnabled = isEnabled
            this.setBackgroundResource(if (isEnabled) R.drawable.blue_rounded else R.drawable.grey_rounded)
        }

    private fun setUpView() {
        with(binding) {
            nameTextInputEditText.addTextChangedListener {
                viewModel.name = it.toString().trim()
                viewModel.validateRegister()
            }
            lastNameTextInputEditText.addTextChangedListener {
                viewModel.lastname = it.toString().trim()
                viewModel.validateRegister()
            }
            emailTextInputEditText.addTextChangedListener {
                viewModel.email = it.toString().trim()
                viewModel.validateRegister()
            }
            passwordTextInputEditText.addTextChangedListener {
                viewModel.password = it.toString().trim()
                viewModel.validateRegister()
            }
            tvLogin.setOnClickListener {
                finish()
            }
            registerButton.setOnClickListener {
                viewModel.doRegister()
            }
        }
    }

    private fun handle(state: SignUpViewModel.State?) {
        when (state) {
            is SignUpViewModel.State.ShowError -> showError(state.message)
            SignUpViewModel.State.Loading -> showProgress()
            is SignUpViewModel.State.Success -> {
                showToast(state.response)
                hideProgress()
                finish()
            }
            else -> Unit
        }.exhaustive
    }

    private fun showError(message: String) {
        hideProgress()
        showToast(message)
    }

    private fun showToast(message: String) {
        Toast.makeText(
            this@SignUpActivity,
            message,
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

    companion object {
        fun launch(from: Context) = from.startActivity(Intent(from, SignUpActivity::class.java))
    }

}
