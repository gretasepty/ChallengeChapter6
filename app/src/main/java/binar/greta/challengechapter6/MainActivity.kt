package binar.greta.challengechapter6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.challengechapter6.model.GetAllFilmItem
import binar.greta.challengechapter6.presenter.FilmPresenter
import binar.greta.challengechapter6.presenter.FilmView
import binar.greta.challengechapter6.view.AdapterFilm
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}