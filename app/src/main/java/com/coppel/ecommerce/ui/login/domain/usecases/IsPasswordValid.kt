package com.coppel.ecommerce.ui.login.domain.usecases

import dagger.Reusable
import javax.inject.Inject

@Reusable
class IsPasswordValid @Inject constructor() {
    operator fun invoke(password: String): Boolean = password.length >= 7
}
