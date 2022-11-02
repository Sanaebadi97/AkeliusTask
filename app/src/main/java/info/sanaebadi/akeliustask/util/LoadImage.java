package info.sanaebadi.akeliustask.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import info.sanaebadi.uikit.R;


public class LoadImage {
    public static void loadImage(ImageView imageView, String url, CircularProgressDrawable progressDrawable) {
        RequestOptions options = new RequestOptions()
                .placeholder(progressDrawable)
                .error(R.drawable.no_image_available);
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(imageView);
    }

    public static void loadImage(ImageView imageView, int drawable, CircularProgressDrawable progressDrawable) {
        RequestOptions options = new RequestOptions()
                .fitCenter()
                .override(Target.SIZE_ORIGINAL)
                .format(DecodeFormat.PREFER_ARGB_8888)
                .placeholder(progressDrawable)
                .error(R.drawable.no_image_available);
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(options)
                .load(drawable)
                .into(imageView);
    }

    public static CircularProgressDrawable getProgressDrawable(Context context) {
        CircularProgressDrawable cpd = new CircularProgressDrawable(context);
        cpd.setStrokeWidth(10f);
        cpd.setCenterRadius(50f);
        cpd.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context, R.color.blue),
                PorterDuff.Mode.MULTIPLY));
        cpd.start();
        return cpd;
    }
}