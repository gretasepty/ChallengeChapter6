package binar.greta.challengechapter6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.challengechapter6.R
import binar.greta.challengechapter6.room.FavoriteDB
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {

    var favDB : FavoriteDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        favDB = FavoriteDB.getInstance(this)
    }

//    fun getFavFilm(){
//        rv_favorite.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//
//        GlobalScope.launch {
//            val listFav = favDB?.daoFavorite()?.getAllFavorite()
//            runOnUiThread {
//                listFav.let {
//                    val
//
//                }
//            }
//        }
//    }
}