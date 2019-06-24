package kiki.prayudi.themoviedb.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import kiki.prayudi.themoviedb.api.ApiResponse

abstract class BaseFragment : Fragment(), BaseViewModel.BaseListener {

    val VIEW_LOADING = 0
    val VIEW_ERROR = 1
    val VIEW_SUCCESS = 2

    override fun onLoading(isLoading: Boolean) {

    }

    override fun onFailure(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(error: ApiResponse) {
        Toast.makeText(activity, error.statusMessage, Toast.LENGTH_SHORT).show()
    }

}
