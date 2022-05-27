package binar.greta.challengechapter6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.greta.challengechapter6.R
import binar.greta.challengechapter6.model.GetAllFilmItem
import binar.greta.challengechapter6.room.Favorite
import binar.greta.challengechapter6.room.FavoriteDB
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    var fav: Favorite? = null
    var favDB: FavoriteDB? = null

    lateinit var favorite: String
    lateinit var id: String
    lateinit var image: String
    lateinit var title: String
    lateinit var date: String
    lateinit var director: String
    lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        favDB = FavoriteDB.getInstance(this)

        val detailfilm = intent.getParcelableExtra<GetAllFilmItem>("DETAIL_FILM")
        val getfav = intent.getParcelableExtra<Favorite>("DETAIL_FAVORITE")
//        favDB = FavoriteDB.getInstance(this)

        if (detailfilm != null) {
            Glide.with(this).load(detailfilm?.image).into(img_detail)
            txt_judulDetail.text = detailfilm?.name
            txt_tanggalDetail.text = detailfilm?.date
            txt_sutradaraDetail.text = detailfilm?.director
            txt_deskDetail.text = detailfilm?.description

            id = detailfilm.id.toString()
            title = detailfilm.name.toString()
            date = detailfilm.date.toString()
            director = detailfilm.director.toString()
            description = detailfilm.description.toString()
            image = detailfilm.image.toString()
        }

        if (getfav != null) {
            Glide.with(this).load(getfav?.image).into(img_detail)
            txt_judulDetail.text = getfav?.name
            txt_tanggalDetail.text = getfav?.date
            txt_sutradaraDetail.text = getfav?.director
            txt_deskDetail.text = getfav?.description

            id = getfav.id.toString()
            title = getfav.name.toString()
            date = getfav.date.toString()
            director = getfav.director.toString()
            description = getfav.description.toString()
            image = getfav.image.toString()
        }

//        favorite = "false"
//        GlobalScope.launch {
//            fav = favDB?.daoFavorite()?.getIDFavorite(id.toInt())
//
//            if (fav?.status == "true"){
//                fab_favorite.setImageResource(R.drawable.ic_favorite)
//                favorite = "true"
//            }
//
//            if (fav?.status == "false"){
//                fab_favorite.setImageResource(R.drawable.ic_favorite)
//                favorite = "false"
//            }
//        }

        fab_favorite.setOnClickListener {
            addfavorite()
//            for (data in favorite) {
//                if (favorite == "true") {
//                    fab_favorite.setImageResource(R.drawable.ic_favorite)
//                    favorite = "false"

//                    break
        }

//                if (favorite == "false") {
//                    fab_favorite.setImageResource(R.drawable.ic_favorite)
//                    favorite = "true"

//                    break
    }

    fun addfavorite() {
        GlobalScope.async {
            val a = favDB?.daoFavorite()?.tambahFavorite(
                Favorite(
                    date,
                    description,
                    director,
                    id.toInt(),
                    image,
                    title,
                    "true")
            )
            runOnUiThread {
                if (a != 0.toLong()) {
                    Toast.makeText(this@DetailActivity, "Item added to Favorites", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(this@DetailActivity, "Gagal", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}
