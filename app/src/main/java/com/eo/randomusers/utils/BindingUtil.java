package com.eo.randomusers.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.databinding.BindingAdapter;

import com.eo.randomusers.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class BindingUtil {
    @BindingAdapter("imageURLRound")
    public static void loadImageRound(ImageView imageView, String image_url) {
        Picasso
                .with(imageView.getContext())
                .load(image_url)
                .placeholder(R.mipmap.account_placeholder)
//                .into(imageView);
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap imageBitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                        RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(Resources.getSystem(), imageBitmap);
                        imageDrawable.setCircular(true);
                        imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                        imageView.setImageDrawable(imageDrawable);
                    }

                    @Override
                    public void onError() {
                        imageView.setImageResource(R.mipmap.account_placeholder);
                    }
                });
    }

    @BindingAdapter("imageURL")
    public static void loadImage(ImageView imageView, String image_url) {
        Picasso
                .with(imageView.getContext())
                .load(image_url)
                .placeholder(R.mipmap.account_placeholder)
                .into(imageView);
    }

}
