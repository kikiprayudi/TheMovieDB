package kiki.prayudi.themoviedb.data.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiResponse

class GenreList : ApiResponse() {

    @SerializedName("genres")
    @Expose
    var genres: List<Genre>? = null
}
