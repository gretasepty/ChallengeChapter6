package binar.greta.challengechapter6.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Favorite")
@Parcelize
data class Favorite(
        @ColumnInfo(name = "date")
        val date: String,
        @ColumnInfo(name = "description")
        val description: String,
        @ColumnInfo(name = "director")
        val director: String,
        @PrimaryKey()
        val id: Int,
        @ColumnInfo(name = "image")
        val image: String,
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "status")
        val status : String

) : Parcelable
