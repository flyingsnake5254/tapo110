package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;

public class m
  implements i<Drawable>
{
  private final i<Bitmap> b;
  private final boolean c;
  
  public m(i<Bitmap> parami, boolean paramBoolean)
  {
    this.b = parami;
    this.c = paramBoolean;
  }
  
  private u<Drawable> d(Context paramContext, u<Bitmap> paramu)
  {
    return s.f(paramContext.getResources(), paramu);
  }
  
  @NonNull
  public u<Drawable> a(@NonNull Context paramContext, @NonNull u<Drawable> paramu, int paramInt1, int paramInt2)
  {
    Object localObject1 = com.bumptech.glide.c.c(paramContext).f();
    Object localObject2 = (Drawable)paramu.get();
    localObject1 = l.a((e)localObject1, (Drawable)localObject2, paramInt1, paramInt2);
    if (localObject1 == null)
    {
      if (!this.c) {
        return paramu;
      }
      paramContext = new StringBuilder();
      paramContext.append("Unable to convert ");
      paramContext.append(localObject2);
      paramContext.append(" to a Bitmap");
      throw new IllegalArgumentException(paramContext.toString());
    }
    localObject2 = this.b.a(paramContext, (u)localObject1, paramInt1, paramInt2);
    if (localObject2.equals(localObject1))
    {
      ((u)localObject2).c();
      return paramu;
    }
    return d(paramContext, (u)localObject2);
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    this.b.b(paramMessageDigest);
  }
  
  public i<BitmapDrawable> c()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof m))
    {
      paramObject = (m)paramObject;
      return this.b.equals(((m)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */