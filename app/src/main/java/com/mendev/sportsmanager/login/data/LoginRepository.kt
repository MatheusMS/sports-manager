package com.mendev.sportsmanager.login.data

import com.mendev.sportsmanager.login.data.entity.UserEntity
import io.reactivex.Single

interface LoginRepository {

    fun login(userName: String, password: String): Single<UserEntity>

}