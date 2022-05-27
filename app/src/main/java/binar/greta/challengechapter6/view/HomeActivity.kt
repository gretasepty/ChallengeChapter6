package binar.greta.challengechapter6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.challengechapter6.R
import binar.greta.challengechapter6.model.GetAllFilmItem
import binar.greta.challengechapter6.presenter.FilmPresenter
import binar.greta.challengechapter6.presenter.FilmView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), FilmView {

    lateinit var userManager: UserManager
    private lateinit var presenterfilm : FilmPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenterfilm = FilmPresenter(this)
        presenterfilm.getDataFilm()

        userManager = UserManager(this)
        userManager.userNama.asLiveData().observe(this, {
            txt_welcome.text = it.toString()
        })

//        Intent ke halaman profile
        img_profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
//        Intent ke Halaman favorite film
        img_favorite.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }
    }

    override fun onSuccess(pesan: String, film: List<GetAllFilmItem>) {
//        KETIKA CARDVIEW DI KLIK PINDAH KE HALAMAN DETAIL SESUAI DENGAN POSITIONNYA
        val adapt = AdapterFilm(film!!){
            val pindah = Intent(this, DetailActivity::class.java)
            pindah.putExtra("DETAIL_FILM", it)
            startActivity(pindah)
        }
        rv_film.layoutManager = LinearLayoutManager(this)
        rv_film.adapter = adapt
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }


    
}