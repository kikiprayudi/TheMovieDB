package kiki.prayudi.themoviedb.data.trailer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiResponse

class Youtube : ApiResponse() {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("size")
    @Expose
    var size: String? = null
    @SerializedName("source")
    @Expose
    var source: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
}