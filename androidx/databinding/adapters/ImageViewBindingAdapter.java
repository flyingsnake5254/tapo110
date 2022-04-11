package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:tint", method="setImageTintList", type=ImageView.class), @androidx.databinding.BindingMethod(attribute="android:tintMode", method="setImageTintMode", type=ImageView.class)})
public class ImageViewBindingAdapter
{
  @BindingAdapter({"android:src"})
  public static void setImageDrawable(ImageView paramImageView, Drawable paramDrawable)
  {
    paramImageView.setImageDrawable(paramDrawable);
  }
  
  @BindingAdapter({"android:src"})
  public static void setImageUri(ImageView paramImageView, Uri paramUri)
  {
    paramImageView.setImageURI(paramUri);
  }
  
  @BindingAdapter({"android:src"})
  public static void setImageUri(ImageView paramImageView, String paramString)
  {
    if (paramString == null) {
      paramImageView.setImageURI(null);
    } else {
      paramImageView.setImageURI(Uri.parse(paramString));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\ImageViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */