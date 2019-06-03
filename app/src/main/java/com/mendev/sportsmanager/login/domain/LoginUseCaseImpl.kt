package com.mendev.sportsmanager.login.domain

import com.mendev.sportsmanager.login.data.LoginRepository
import io.reactivex.Completable

class LoginUseCaseImpl(private val repository: LoginRepository) : LoginUseCase {

    override fun login(userName: String, password: String): Completable {
        return repository.login(userName, password).toCompletable()
    }

}