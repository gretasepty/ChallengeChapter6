package binar.greta.challengechapter6.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.greta.challengechapter6.R
import binar.greta.challengechapter6.room.Favorite
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_favorite.view.*
import kotlinx.android.synthetic.main.item_film.view.*

class AdapterFavorite(private var onclick : (Favorite) -> Unit) :
        RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {

    var datafavorite : List<Favorite>?= null

    fun setFav(favorite : List<Favorite>){
        this.datafavorite = favorite
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_favorite, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_judulFav.text = datafavorite!![position].name
        holder.itemView.txt_tanggalFav.text = datafavorite!![position].date
        holder.itemView.txt_sutradaraFav.text = datafavorite!![position].director

        Glide.with(holder.itemView.context).load(datafavorite!![position].image)
                .into(holder.itemView.img_filmFav)

        holder.itemView.cardFavorite.setOnClickListener {
            onclick(datafavorite!![position])
        }
    }

    override fun getItemCount(): Int {
        return datafavorite!!.size
    }
}