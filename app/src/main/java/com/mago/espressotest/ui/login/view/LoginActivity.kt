package com.mago.espressotest.ui.login.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.mago.espressotest.R
import com.mago.espressotest.ui.login.presenter.ILoginPresenter
import com.mago.espressotest.ui.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ILoginView {
    private val presenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val text = s.toString()

                btn_login.isEnabled = text.isNotEmpty()
            }
        })

        btn_login.setOnClickListener {
            if (!et_username.text.isNullOrEmpty() && !et_password.text.isNullOrEmpty())
                login()
            if (!et_username.text.isNullOrEmpty() && et_password.text.isEmpty())
                register()
        }
    }

    override fun showProgressBar() {
        et_username.isEnabled = false
        et_password.isEnabled = false
        btn_login.isEnabled = false

        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        if (currentFocus != null) {
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        et_username.isEnabled = true
        et_password.isEnabled = true
        btn_login.isEnabled = true

        progressBar.visibility = View.GONE
    }

    override fun incorrectData() {
        tv_session_status.text = getString(R.string.incorrect_data)
    }

    override fun onLoginSuccess() {
        tv_session_status.text = getString(R.string.login_success)
    }

    override fun onLoginError() {
        tv_session_status.text = getString(R.string.login_error)
    }

    private fun login() {
        presenter.login(
            et_username.text.toString(),
            et_password.text.toString()
        )
    }

    private fun register() {
        Toast.makeText(applicationContext, "Registrar", Toast.LENGTH_LONG).show()
    }

    private fun updateUiWithUser(name: String) {
        val welcome = getString(R.string.welcome)
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            "$welcome $name",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}