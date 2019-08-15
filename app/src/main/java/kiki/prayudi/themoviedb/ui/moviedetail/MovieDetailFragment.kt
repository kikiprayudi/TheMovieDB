package kiki.prayudi.themoviedb.ui.moviedetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kiki.prayudi.themoviedb.Constant
import kiki.prayudi.themoviedb.R
import kiki.prayudi.themoviedb.api.ApiResponse
import kiki.prayudi.themoviedb.data.movie.MovieDetail
import kiki.prayudi.themoviedb.data.review.ReviewList
import kiki.prayudi.themoviedb.data.trailer.TrailerList
import kiki.prayudi.themoviedb.data.trailer.Youtube
import kiki.prayudi.themoviedb.ui.base.BaseFragment
import kiki.prayudi.themoviedb.util.Utils.setImageURI
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.android.synthetic.main.layout_error.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : BaseFragment(), MovieDetailViewModel.MovieDetailListener {

    private var adapter: YoutubeListAdapter? = null
    private val viewModel: MovieDetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.attachViewModel(this, this)

        if (viewModel.id.value == null) {
            viewModel.id.value = arguments?.getInt("id")
        }

        adapter = YoutubeListAdapter(mutableListOf(), object : YoutubeListAdapter.Listener {
            override fun onItemClick(itemData: Youtube) {
                activity?.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(Constant.YOUTUBR_URL + itemData.source)
                    )
                )
            }
        })
        recyclerView.adapter = adapter

        viewModel.id.value?.let {
            viewModel.getMovieById(it)
            viewModel.getTrailerListMovieById(it)
        }

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.id.value?.let {
                viewModel.getMovieById(it)
                viewModel.getTrailerListMovieById(it)
            }
        }
    }

    override fun onFailure(message: String) {
        viewAnimator.displayedChild = VIEW_ERROR
        swipeRefreshLayout.isRefreshing = false
        tvError.text = message
    }

    override fun onError(error: ApiResponse) {
        viewAnimator.displayedChild = VIEW_ERROR
        swipeRefreshLayout.isRefreshing = false
        tvError.text = error.statusMessage
    }

    override fun onSuccessGetMovieById(data: MovieDetail) {
        viewAnimator.displayedChild = VIEW_SUCCESS
        swipeRefreshLayout.isRefreshing = false
        ivImage.setImageURI(Constant.MEDIA_URL + data.posterPath)
        tvName.text = data.title
        tvRelease.text = data.releaseDate
        tvVote.text = data.voteAverage.toString()
        tvOverview.text = data.overview
    }

    override fun onSuccessGetReviewListMovieById(data: ReviewList) {

    }


    override fun onSuccessGetTrailerListMovieById(data: TrailerList) {
        viewAnimator.displayedChild = VIEW_SUCCESS
        swipeRefreshLayout.isRefreshing = false
        data.youtube?.toMutableList()?.let {
            adapter?.data = it
            adapter?.notifyDataSetChanged()
        }
    }
}
