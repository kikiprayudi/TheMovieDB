package kiki.prayudi.themoviedb.data.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiResponse

class SpokenLanguage : ApiResponse() {

    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
}