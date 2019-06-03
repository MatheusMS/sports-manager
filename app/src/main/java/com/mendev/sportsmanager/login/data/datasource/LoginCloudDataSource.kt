package com.mendev.sportsmanager.login.data.datasource

import com.google.gson.Gson
import com.mendev.sportsmanager.login.data.entity.UserEntity
import io.reactivex.Single

class LoginCloudDataSource : LoginDataSource {

    override fun login(userName: String, password: String): Single<UserEntity> {
        return Single.create { emitter ->
            Thread.sleep(2000)

            val responseMock = "{\n" +
                    "  \"id\": 1,\n" +
                    "  \"name\": \"Matheus\",\n" +
                    "  \"email\": \"matheusmendess90@gmail.com\"\n" +
                    "}"

            val gson = Gson()
            val userEntity = gson.fromJson(responseMock, UserEntity::class.java)

            emitter.onSuccess(userEntity)
        }
    }
}