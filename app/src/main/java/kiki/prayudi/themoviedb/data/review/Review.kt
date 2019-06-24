package kiki.prayudi.themoviedb.data.review

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiResponse

open class Review : ApiResponse() {

    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("content")
    @Expose
    var content: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
}