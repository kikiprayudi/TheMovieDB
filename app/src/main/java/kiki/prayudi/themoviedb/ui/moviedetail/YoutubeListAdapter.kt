package kiki.prayudi.themoviedb.ui.moviedetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kiki.prayudi.themoviedb.Constant
import kiki.prayudi.themoviedb.R
import kiki.prayudi.themoviedb.data.trailer.Youtube
import kotlinx.android.synthetic.main.item_genre_list.view.tvName
import kotlinx.android.synthetic.main.item_youtube_list.view.*

class YoutubeListAdapter(data: MutableList<Youtube>, listener: YoutubeListAdapter.Listener) :
    RecyclerView.Adapter<YoutubeListAdapter.ViewHolder>() {

    var data = mutableListOf<Youtube>()
    var listener: Listener

    init {
        this.data = data
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_youtube_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemView = holder.itemView
        val itemData = data[position]

        itemView.tvName.text = itemData.name
        itemView.ivImage.setImageURI(Constant.YOUTUBR_IMAGE_URL + itemData.source + Constant.YOUTUBR_IMAGE_TYPE)

        itemView.container.setOnClickListener {
            listener.onItemClick(itemData)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface Listener {
        fun onItemClick(itemData: Youtube)
    }
}
