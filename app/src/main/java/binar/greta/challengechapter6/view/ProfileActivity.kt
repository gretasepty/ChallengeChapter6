package binar.greta.challengechapter6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import binar.greta.challengechapter6.R
import binar.greta.challengechapter6.viewmodel.ViewModelUser
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {
    lateinit var userManager: UserManager
    lateinit var idProf : String
    lateinit var usernameProf : String
    lateinit var passwordProf : String
    lateinit var namaProf : String
    lateinit var ttlProf : String
    lateinit var alamatProf : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        userManager = UserManager(this)

        btn_logout.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        userManager.userNama.asLiveData().observe(this){
            edt_usernameProf.setText(it)
        }
        userManager.userPass.asLiveData().observe(this){
            edt_passwordProf.setText(it)
        }
        userManager.userNamaL.asLiveData().observe(this){
            edt_namaProf.setText(it)
        }
        userManager.userTtl.asLiveData().observe(this){
            edt_ttlProf.setText(it)
        }
        userManager.userAlamat.asLiveData().observe(this){
            edt_alamatProf.setText(it)
        }

        btn_update.setOnClickListener{
            userManager.userId.asLiveData().observe(this){
                idProf = it
            }
            usernameProf = edt_usernameProf.text.toString()
            passwordProf = edt_usernameProf.text.toString()
            namaProf = edt_namaProf.text.toString()
            ttlProf = edt_ttlProf.text.toString()
            alamatProf = edt_alamatProf.text.toString()

            GlobalScope.launch {
                userManager.saveData(idProf, usernameProf, passwordProf, namaProf, ttlProf, alamatProf)
            }
            updateProfile(idProf.toInt(), alamatProf, namaProf, passwordProf, alamatProf, usernameProf)
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    fun updateProfile(id : Int, address : String, name : String, password : String,
                        umur : String, username : String){
        val viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.getLiveUpdate().observe(this, {
            if (it != null){
                Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.makeUpdate(id, address, name, password, umur, username)

    }

}