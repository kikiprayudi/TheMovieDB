package kiki.prayudi.themoviedb.data.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiResponse

class ProductionCountry : ApiResponse() {

    @SerializedName("iso_3166_1")
    @Expose
    var iso31661: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
}