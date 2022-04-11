package com.bumptech.glide.request.k;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class g
{
  @NonNull
  public <Z> k<ImageView, Z> a(@NonNull ImageView paramImageView, @NonNull Class<Z> paramClass)
  {
    if (Bitmap.class.equals(paramClass)) {
      return new b(paramImageView);
    }
    if (Drawable.class.isAssignableFrom(paramClass)) {
      return new e(paramImageView);
    }
    paramImageView = new StringBuilder();
    paramImageView.append("Unhandled class: ");
    paramImageView.append(paramClass);
    paramImageView.append(", try .as*(Class).transcode(ResourceTranscoder)");
    throw new IllegalArgumentException(paramImageView.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\k\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */