package binar.greta.challengechapter6.presenter

import binar.greta.challengechapter6.model.GetAllFilmItem
import binar.greta.challengechapter6.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmPresenter(val viewfilm : FilmView) {
    fun getDataFilm(){
        ApiClient.instance.getAllFilm()
                .enqueue(object : Callback<List<GetAllFilmItem>>{
                    override fun onResponse(
                            call: Call<List<GetAllFilmItem>>,
                            response: Response<List<GetAllFilmItem>>
                    ) {
                        if(response.isSuccessful){
                            viewfilm.onSuccess(response.message(), response.body()!!)
                        }else{
                            viewfilm.onError(response.message())
                        }
                    }

                    override fun onFailure(call: Call<List<GetAllFilmItem>>, t: Throwable) {
                        viewfilm.onError(t.message!!)
                    }
                })
    }
}