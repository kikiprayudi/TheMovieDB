package kiki.prayudi.themoviedb.data.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiPagingResponse

class MovieList : ApiPagingResponse() {

    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null
}
