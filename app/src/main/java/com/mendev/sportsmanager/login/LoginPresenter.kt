package com.mendev.sportsmanager.login

import com.mendev.sportsmanager.shared.BasePresenter

class LoginPresenter : BasePresenter<LoginPresenter.View>() {

    fun login(userName: String, password: String) {
        view?.showProgress()
    }

    interface View {
        fun showProgress()
        fun dismissProgress()
    }
}