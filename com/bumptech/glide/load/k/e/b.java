package com.bumptech.glide.load.k.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.i;

public abstract class b<T extends Drawable>
  implements u<T>, q
{
  protected final T c;
  
  public b(T paramT)
  {
    this.c = ((Drawable)i.d(paramT));
  }
  
  public void b()
  {
    Drawable localDrawable = this.c;
    if ((localDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)localDrawable).getBitmap().prepareToDraw();
    } else if ((localDrawable instanceof GifDrawable)) {
      ((GifDrawable)localDrawable).e().prepareToDraw();
    }
  }
  
  @NonNull
  public final T d()
  {
    Drawable.ConstantState localConstantState = this.c.getConstantState();
    if (localConstantState == null) {
      return this.c;
    }
    return localConstantState.newDrawable();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */