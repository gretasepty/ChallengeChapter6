package binar.greta.challengechapter6.view

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context: Context) {
    private val dataUser : DataStore<Preferences> = context.createDataStore(name = "user_prefs")

    companion object{
        val ID = preferencesKey<String>("USER_ID")
        val USERNAME = preferencesKey<String>("USER_USERNAME")
        val PASSWORD = preferencesKey<String>("USER_PASSWORD")
        val NAMA = preferencesKey<String>("USER_NAMA")
        val TTL = preferencesKey<String>("USER_TTL")
        val ALAMAT = preferencesKey<String>("USER_ALAMAT")
    }

    suspend fun saveData(id : String, username : String,  password : String,
                         nama : String, ttl : String, alamat : String ){
        dataUser.edit {
            it[ID] = id
            it[USERNAME] = username
            it[PASSWORD] = password
            it[NAMA] = nama
            it[TTL] = ttl
            it[ALAMAT] = alamat

        }
    }

    val userId : Flow<String> = dataUser.data.map {
        it[ID]?: ""
    }

    val userNama : Flow<String> = dataUser.data.map {
        it[USERNAME]?: ""
    }

    val userPass : Flow<String> = dataUser.data.map {
        it[PASSWORD]?: ""
    }

    val userNamaL : Flow<String> = dataUser.data.map {
        it[NAMA]?: ""
    }

    val userTtl : Flow<String> = dataUser.data.map {
        it[TTL]?: ""
    }
    val userAlamat : Flow<String> = dataUser.data.map {
        it[ALAMAT]?: ""
    }



    suspend fun hapusData(){
        dataUser.edit {
            it.clear()
        }
    }
}