package binar.greta.challengechapter6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.greta.challengechapter6.model.GetAllUserItem
import binar.greta.challengechapter6.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {

    lateinit var liveDataLogin : MutableLiveData<GetAllUserItem>
    lateinit var liveDataRegister : MutableLiveData<GetAllUserItem>
    lateinit var liveDataUpdate : MutableLiveData<GetAllUserItem>

    init {
        liveDataLogin = MutableLiveData()
        liveDataRegister = MutableLiveData()
        liveDataUpdate = MutableLiveData()
    }

    fun getLiveLogin() : MutableLiveData<GetAllUserItem>{
        return liveDataLogin
    }

    fun getLiveRegister() : MutableLiveData<GetAllUserItem>{
        return liveDataRegister
    }

    fun getLiveUpdate() : MutableLiveData<GetAllUserItem>{
        return liveDataUpdate
    }

//    Register
    fun makeRegister(password : String, username : String){
        ApiClient.instance.registerUser(password, username)
                .enqueue(object : Callback<GetAllUserItem>{
                    override fun onResponse(call: Call<GetAllUserItem>, response: Response<GetAllUserItem>) {
                        if (response.isSuccessful){
                            liveDataRegister.postValue(response.body())
                        }else{
                            liveDataRegister.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<GetAllUserItem>, t: Throwable) {
                        liveDataRegister.postValue(null)
                    }
                })
    }

//  Login
    fun makeLogin(password : String, username : String){
        ApiClient.instance.loginUser(password, username)
                .enqueue(object : Callback<GetAllUserItem>{
                    override fun onResponse(call: Call<GetAllUserItem>, response: Response<GetAllUserItem>) {
                        if (response.isSuccessful){
                            liveDataLogin.postValue(response.body())
                        }else{
                            liveDataLogin.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<GetAllUserItem>, t: Throwable) {
                        liveDataLogin.postValue(null)
                    }
                })
    }

//    UpdateProfile
    fun makeUpdate(id : Int, address : String, name : String, password: String, umur : String, username : String, ){
        ApiClient.instance.updateUser(id.toString(), address, name, password, umur, username)
                .enqueue(object : Callback<GetAllUserItem>{
                    override fun onResponse(call: Call<GetAllUserItem>, response: Response<GetAllUserItem>) {
                        if(response.isSuccessful){
                            liveDataUpdate.postValue(response.body())
                        }else{
                            liveDataUpdate.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<GetAllUserItem>, t: Throwable) {
                        liveDataUpdate.postValue(null)
                    }

                })
    }



}