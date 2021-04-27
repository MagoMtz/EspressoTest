package com.mago.espressotest.ui.login.presenter

/**
 * @author by jmartinez
 * @since 12/02/2021.
 */
interface ILoginPresenter {

    fun login(username: String, password: String)

    fun onLoginSuccess()
    fun onLoginError()
}
