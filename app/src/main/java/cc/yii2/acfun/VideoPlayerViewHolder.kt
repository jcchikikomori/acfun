package cc.yii2.acfun

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import cc.yii2.acfun.models.MediaObject
import com.bumptech.glide.RequestManager


class VideoPlayerViewHolder(itemView: View) : ViewHolder(itemView) {
    var title: TextView = itemView.findViewById(R.id.title)
    var thumbnail: ImageView = itemView.findViewById(R.id.thumbnail)
    var progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
    var parent: View = itemView
    lateinit var requestManager: RequestManager

    @SuppressLint("SetTextI18n")
    fun onBind(mediaObject: MediaObject, requestManager: RequestManager) {
        this.requestManager = requestManager
        parent.tag = this
        title.text =
            "${mediaObject.title} | ${mediaObject.duration} | ${mediaObject.video_added} | " +
                    "${mediaObject.video_views} | ${mediaObject.video_rating}"
        this.requestManager
            .load(mediaObject.thumbnail)
            .override(800, 600)
            .into(thumbnail)
    }
}
