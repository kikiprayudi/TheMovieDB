package kiki.prayudi.themoviedb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kiki.prayudi.themoviedb.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.navHostFragment)
    }

    override fun onBackPressed() {
        val id = navController.currentDestination?.id
        when (id) {
            R.id.movieListFragment,
            R.id.movieDetailFragment -> {
                navController.popBackStack()
//                navController.navigate(R.id.genreListFragment)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }
}
