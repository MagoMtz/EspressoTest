package com.mago.espressotest.ui.login.presenter

import android.os.Handler
import com.mago.espressotest.ui.login.interactor.ILoginInteractor
import com.mago.espressotest.ui.login.interactor.LoginInteractor
import com.mago.espressotest.ui.login.view.ILoginView
import kotlinx.coroutines.android.HandlerDispatcher

/**
 * @author by jmartinez
 * @since 12/02/2021.
 */
class LoginPresenter(private val view: ILoginView): ILoginPresenter {
    private val interactor: ILoginInteractor = LoginInteractor(this)

    override fun login(username: String, password: String) {
        view.showProgressBar()
        Handler().postDelayed({
            if (username.isEmpty() || !isUserNameValid(username)) {
                view.incorrectData()
                view.hideProgressBar()
            } else {
                interactor.loginInServer(username, password)
            }
        }, 1000)

    }

    override fun onLoginSuccess() {
        view.onLoginSuccess()
        view.hideProgressBar()
    }

    override fun onLoginError() {
        view.onLoginError()
        view.hideProgressBar()
    }

    private fun isUserNameValid(username: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()
    }
}