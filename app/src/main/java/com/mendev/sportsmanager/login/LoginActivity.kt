package com.mendev.sportsmanager.login

import android.os.Bundle
import android.view.View
import com.mendev.sportsmanager.R
import com.mendev.sportsmanager.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginPresenter.View {

    private val presenter: LoginPresenter
        by lazy { LoginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)
        loadListeners()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
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
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
//fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
//    this.addTextChangedListener(object : TextWatcher {
//        override fun afterTextChanged(editable: Editable?) {
//            afterTextChanged.invoke(editable.toString())
//        }
//
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//    })
//}
