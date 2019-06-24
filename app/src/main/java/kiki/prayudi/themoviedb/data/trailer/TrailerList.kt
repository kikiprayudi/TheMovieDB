package kiki.prayudi.themoviedb.data.trailer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiResponse

class TrailerList : ApiResponse() {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("quicktime")
    @Expose
    var quicktime: List<Any>? = null
    @SerializedName("youtube")
    @Expose
    var youtube: List<Youtube>? = null
}