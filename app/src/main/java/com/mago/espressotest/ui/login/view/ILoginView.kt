package com.mago.espressotest.ui.login.view

interface ILoginView {
    fun showProgressBar()
    fun hideProgressBar()
    fun incorrectData()
    fun onLoginSuccess()
    fun onLoginError()
}
