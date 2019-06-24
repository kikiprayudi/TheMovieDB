package kiki.prayudi.themoviedb.data.review

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kiki.prayudi.themoviedb.api.ApiPagingResponse

class ReviewList : ApiPagingResponse() {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("results")
    @Expose
    var results: List<Review>? = null
}
