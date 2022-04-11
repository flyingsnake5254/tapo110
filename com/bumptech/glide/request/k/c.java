package com.bumptech.glide.request.k;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.d;

public abstract class c<T>
  implements j<T>
{
  private final int c;
  private final int d;
  @Nullable
  private d f;
  
  public c()
  {
    this(Integer.MIN_VALUE, Integer.MIN_VALUE);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    if (com.bumptech.glide.util.j.u(paramInt1, paramInt2))
    {
      this.c = paramInt1;
      this.d = paramInt2;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" and height: ");
    localStringBuilder.append(paramInt2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final void a(@NonNull i parami) {}
  
  public void b(@Nullable Drawable paramDrawable) {}
  
  @Nullable
  public final d c()
  {
    return this.f;
  }
  
  public final void f(@Nullable d paramd)
  {
    this.f = paramd;
  }
  
  public void h(@Nullable Drawable paramDrawable) {}
  
  public final void j(@NonNull i parami)
  {
    parami.d(this.c, this.d);
  }
  
  public void onDestroy() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\k\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */