package binar.greta.challengechapter6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import binar.greta.challengechapter6.R
import binar.greta.challengechapter6.viewmodel.ViewModelUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var userManager: UserManager
    lateinit var usernameLogin : String
    lateinit var passwordLogin : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userManager = UserManager(this)

        btn_login.setOnClickListener {
            if(edt_username.text.isNotEmpty() && edt_password.text.isNotEmpty()){
                datalogin()
            }else{
                Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_LONG).show()
            }
        }


        userManager.userNama.asLiveData().observe(this,{
            usernameLogin = it.toString()
        })

        userManager.userPass.asLiveData().observe(this,{
            passwordLogin = it.toString()
        })

        txt_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun datalogin(){
        val usernameLog = edt_username.text.toString()
        val passwordLog = edt_password.text.toString()
        val viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.getLiveLogin().observe(this,{
            if (usernameLog == usernameLogin && passwordLog == passwordLogin){
                Toast.makeText(this, "Sukses login", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeLogin(passwordLog, usernameLog)

    }
}