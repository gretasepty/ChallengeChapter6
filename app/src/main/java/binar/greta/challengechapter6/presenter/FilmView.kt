package binar.greta.challengechapter6.presenter

import binar.greta.challengechapter6.model.GetAllFilmItem

interface FilmView {

    fun onSuccess(pesan : String, film : List<GetAllFilmItem>)
    fun onError(pesan : String)
}