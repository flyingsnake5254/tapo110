package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.k.e.b;

public class d
  extends b<GifDrawable>
  implements q
{
  public d(GifDrawable paramGifDrawable)
  {
    super(paramGifDrawable);
  }
  
  public int a()
  {
    return ((GifDrawable)this.c).i();
  }
  
  public void b()
  {
    ((GifDrawable)this.c).e().prepareToDraw();
  }
  
  public void c()
  {
    ((GifDrawable)this.c).stop();
    ((GifDrawable)this.c).k();
  }
  
  @NonNull
  public Class<GifDrawable> e()
  {
    return GifDrawable.class;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */