package com.tplink.libtpimagedownloadmedia.loader;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.load.engine.j;
import com.tplink.libmediaapi.R.drawable;
import java.io.InputStream;

public class CustomGlideModule
  extends com.bumptech.glide.m.a
{
  public void a(@NonNull Context paramContext, @NonNull c paramc, @NonNull Registry paramRegistry)
  {
    paramRegistry.r(g.class, InputStream.class, new h.a());
  }
  
  public void b(@NonNull Context paramContext, @NonNull d paramd)
  {
    paramd.c((com.bumptech.glide.request.g)((com.bumptech.glide.request.g)((com.bumptech.glide.request.g)new com.bumptech.glide.request.g().k()).V(R.drawable.glide_default)).f(j.a));
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpimagedownloadmedia\loader\CustomGlideModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */