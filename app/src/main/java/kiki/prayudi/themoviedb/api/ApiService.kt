package kiki.prayudi.themoviedb.api

import kiki.prayudi.themoviedb.data.genre.GenreList
import kiki.prayudi.themoviedb.data.movie.MovieDetail
import kiki.prayudi.themoviedb.data.movie.MovieList
import kiki.prayudi.themoviedb.data.review.ReviewList
import kiki.prayudi.themoviedb.data.trailer.TrailerList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("genre/movie/list")
    suspend fun getGenreList(): Response<GenreList>

    @GET("discover/movie")
    suspend fun getMovieListByGenre(
        @Query("with_genres") with_genres: Int
    ): Response<MovieList>

    @GET("movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: Int
    ): Response<MovieDetail>

    @GET("movie/{id}/reviews")
    suspend fun getReviewListMovieById(
        @Path("id") id: Int
    ): Response<ReviewList>

    @GET("movie/{id}/trailers")
    suspend fun getTrailerListMovieById(
        @Path("id") id: Int
    ): Response<TrailerList>
}