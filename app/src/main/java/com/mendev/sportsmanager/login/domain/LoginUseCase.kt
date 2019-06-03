package com.mendev.sportsmanager.login.domain

import io.reactivex.Completable

interface LoginUseCase {

    fun login(userName: String, password: String) : Completable

}