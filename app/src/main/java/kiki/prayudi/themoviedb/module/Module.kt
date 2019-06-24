package kiki.prayudi.themoviedb.module

import kiki.prayudi.themoviedb.ui.base.BaseViewModel
import kiki.prayudi.themoviedb.ui.genrelist.GenreListViewModel
import kiki.prayudi.themoviedb.ui.moviedetail.MovieDetailViewModel
import kiki.prayudi.themoviedb.ui.movielist.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Module {

    val injectionModule = module {

        viewModel { BaseViewModel() }
        viewModel { GenreListViewModel() }
        viewModel { MovieListViewModel() }
        viewModel { MovieDetailViewModel() }
    }

}
