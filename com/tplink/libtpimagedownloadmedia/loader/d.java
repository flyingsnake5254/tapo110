package com.tplink.libtpimagedownloadmedia.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.i;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.request.g;
import java.io.File;

public class d
  extends i
{
  public d(@NonNull com.bumptech.glide.c paramc, @NonNull l paraml, @NonNull q paramq, @NonNull Context paramContext)
  {
    super(paramc, paraml, paramq, paramContext);
  }
  
  @NonNull
  public d C(@NonNull g paramg)
  {
    try
    {
      paramg = (d)super.g(paramg);
      return paramg;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  @CheckResult
  @NonNull
  public <ResourceType> c<ResourceType> D(@NonNull Class<ResourceType> paramClass)
  {
    return new c(this.q, this, paramClass, this.x);
  }
  
  @CheckResult
  @NonNull
  public c<Bitmap> E()
  {
    return (c)super.k();
  }
  
  @CheckResult
  @NonNull
  public c<Drawable> F()
  {
    return (c)super.l();
  }
  
  @CheckResult
  @NonNull
  public c<Drawable> G(@Nullable File paramFile)
  {
    return (c)super.q(paramFile);
  }
  
  @CheckResult
  @NonNull
  public c<Drawable> H(@Nullable Object paramObject)
  {
    return (c)super.r(paramObject);
  }
  
  @CheckResult
  @NonNull
  public c<Drawable> I(@Nullable String paramString)
  {
    return (c)super.s(paramString);
  }
  
  protected void x(@NonNull g paramg)
  {
    if ((paramg instanceof b)) {
      super.x(paramg);
    } else {
      super.x(new b().o0(paramg));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpimagedownloadmedia\loader\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */