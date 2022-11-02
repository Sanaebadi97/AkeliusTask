package info.sanaebadi.akeliustask.util

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.target.Target
import info.sanaebadi.uikit.R

object LoadImage {
    fun loadImage(imageView: ImageView, url: String?, progressDrawable: CircularProgressDrawable?) {
        val options = RequestOptions()
            .placeholder(progressDrawable)
            .error(R.drawable.no_image_available)
        Glide.with(imageView.context)
            .setDefaultRequestOptions(options)
            .load(url)
            .into(imageView)
    }

    fun loadImage(
        imageView: ImageView,
        drawable: Int,
        progressDrawable: CircularProgressDrawable?
    ) {
        val options = RequestOptions()
            .fitCenter()
            .override(Target.SIZE_ORIGINAL)
            .format(DecodeFormat.PREFER_ARGB_8888)
            .placeholder(progressDrawable)
            .error(R.drawable.no_image_available)
        Glide.with(imageView.context)
            .setDefaultRequestOptions(options)
            .load(drawable)
            .into(imageView)
    }

    fun getProgressDrawable(context: Context?): CircularProgressDrawable {
        val cpd = CircularProgressDrawable(context!!)
        cpd.strokeWidth = 10f
        cpd.centerRadius = 50f
        cpd.colorFilter = PorterDuffColorFilter(
            ContextCompat.getColor(
                context, R.color.blue
            ),
            PorterDuff.Mode.MULTIPLY
        )
        cpd.start()
        return cpd
    }
}