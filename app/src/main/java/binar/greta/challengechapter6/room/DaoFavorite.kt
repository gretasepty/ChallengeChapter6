package binar.greta.challengechapter6.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoFavorite {
    @Insert
    fun tambahFavorite(favorite: Favorite) : Long

//    @Query("SELECT * FROM Favorite WHERE Favorite.id = id")
//    fun getIDFavorite(id:Int) : Favorite
    @Query("SELECT * FROM Favorite")
    fun getAllFavorite() : List<Favorite>

    @Delete
    fun hapusFavorite(favorite: Favorite) : Int
}