package com.bumptech.glide.request.k;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class e
  extends f<Drawable>
{
  public e(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  protected void q(@Nullable Drawable paramDrawable)
  {
    ((ImageView)this.q).setImageDrawable(paramDrawable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\k\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */