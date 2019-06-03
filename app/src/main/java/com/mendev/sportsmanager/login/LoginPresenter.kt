package com.mendev.sportsmanager.login

import com.mendev.sportsmanager.login.domain.LoginUseCase
import com.mendev.sportsmanager.shared.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter(private val useCase: LoginUseCase) : BasePresenter<LoginPresenter.View>() {

    var compositeDisposable = CompositeDisposable()

    fun login(userName: String, password: String) {
        view?.showProgress()
        compositeDisposable.add(
            useCase.login(userName, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view?.dismissProgress() }
                .subscribe({
                    view?.showToast("Logado!")
                }, {error -> error.message?.let { view?.showToast(it) } })
        )
    }

    fun clear() {
        compositeDisposable.clear()
    }

    interface View {
        fun showProgress()
        fun dismissProgress()
        fun showToast(message: String)
    }
}