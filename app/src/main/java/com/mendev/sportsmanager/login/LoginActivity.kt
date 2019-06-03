package com.mendev.sportsmanager.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mendev.sportsmanager.R
import com.mendev.sportsmanager.login.data.LoginRepositoryImpl
import com.mendev.sportsmanager.login.data.datasource.LoginCloudDataSource
import com.mendev.sportsmanager.login.domain.LoginUseCaseImpl
import com.mendev.sportsmanager.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginPresenter.View {

    private val presenter: LoginPresenter
        by lazy { LoginPresenter(LoginUseCaseImpl(LoginRepositoryImpl(LoginCloudDataSource()))) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)
        loadListeners()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
        presenter.clear()
    }

    private fun loadListeners() {
        btLogin.setOnClickListener {
            presenter.login(edUsername.text.toString(), edPassword.text.toString())
        }
    }

    override fun showProgress() {
        loading.visibility = View.VISIBLE
    }

    override fun dismissProgress() {
        loading.visibility = View.GONE
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
