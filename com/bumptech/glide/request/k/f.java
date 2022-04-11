package com.bumptech.glide.request.k;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.l.b;
import com.bumptech.glide.request.l.b.a;

public abstract class f<Z>
  extends k<ImageView, Z>
  implements b.a
{
  @Nullable
  private Animatable p1;
  
  public f(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  private void m(@Nullable Z paramZ)
  {
    if ((paramZ instanceof Animatable))
    {
      paramZ = (Animatable)paramZ;
      this.p1 = paramZ;
      paramZ.start();
    }
    else
    {
      this.p1 = null;
    }
  }
  
  private void p(@Nullable Z paramZ)
  {
    o(paramZ);
    m(paramZ);
  }
  
  public void b(@Nullable Drawable paramDrawable)
  {
    super.b(paramDrawable);
    p(null);
    n(paramDrawable);
  }
  
  public void d(@Nullable Drawable paramDrawable)
  {
    super.d(paramDrawable);
    Animatable localAnimatable = this.p1;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
    p(null);
    n(paramDrawable);
  }
  
  public void e(@NonNull Z paramZ, @Nullable b<? super Z> paramb)
  {
    if ((paramb != null) && (paramb.a(paramZ, this))) {
      m(paramZ);
    } else {
      p(paramZ);
    }
  }
  
  public void h(@Nullable Drawable paramDrawable)
  {
    super.h(paramDrawable);
    p(null);
    n(paramDrawable);
  }
  
  public void n(Drawable paramDrawable)
  {
    ((ImageView)this.q).setImageDrawable(paramDrawable);
  }
  
  protected abstract void o(@Nullable Z paramZ);
  
  public void onStart()
  {
    Animatable localAnimatable = this.p1;
    if (localAnimatable != null) {
      localAnimatable.start();
    }
  }
  
  public void onStop()
  {
    Animatable localAnimatable = this.p1;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\k\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */