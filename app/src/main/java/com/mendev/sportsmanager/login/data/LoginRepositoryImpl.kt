package com.mendev.sportsmanager.login.data

import com.mendev.sportsmanager.login.data.datasource.LoginCloudDataSource
import com.mendev.sportsmanager.login.data.entity.UserEntity
import io.reactivex.Single

class LoginRepositoryImpl(private val cloudDataSource: LoginCloudDataSource) : LoginRepository {

    override fun login(userName: String, password: String): Single<UserEntity> {
        return cloudDataSource.login(userName, password)
    }
}