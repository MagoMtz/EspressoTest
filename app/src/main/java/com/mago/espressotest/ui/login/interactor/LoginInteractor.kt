package com.mago.espressotest.ui.login.interactor

import com.mago.espressotest.ui.login.presenter.ILoginPresenter

/**
 * @author by jmartinez
 * @since 12/02/2021.
 */
class LoginInteractor(private val presenter: ILoginPresenter): ILoginInteractor {

    override fun loginInServer(username: String, password: String) {
        if (username == "Admin@mail.com" && password == "123456")
            presenter.onLoginSuccess()
        else
            presenter.onLoginError()
    }
}