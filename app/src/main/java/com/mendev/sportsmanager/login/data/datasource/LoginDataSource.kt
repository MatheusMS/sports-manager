package com.mendev.sportsmanager.login.data.datasource

import com.mendev.sportsmanager.login.data.entity.UserEntity
import io.reactivex.Single

interface LoginDataSource {
    fun login(userName: String, password: String):Single<UserEntity>
}