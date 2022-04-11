package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tplink.libtpimagedownloadmedia.loader.CustomGlideModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl
  extends GeneratedAppGlideModule
{
  private final CustomGlideModule a = new CustomGlideModule();
  
  public GeneratedAppGlideModuleImpl(Context paramContext)
  {
    if (Log.isLoggable("Glide", 3)) {
      Log.d("Glide", "Discovered AppGlideModule from annotation: com.tplink.libtpimagedownloadmedia.loader.CustomGlideModule");
    }
  }
  
  public void a(@NonNull Context paramContext, @NonNull c paramc, @NonNull Registry paramRegistry)
  {
    this.a.a(paramContext, paramc, paramRegistry);
  }
  
  public void b(@NonNull Context paramContext, @NonNull d paramd)
  {
    this.a.b(paramContext, paramd);
  }
  
  public boolean c()
  {
    return this.a.c();
  }
  
  @NonNull
  public Set<Class<?>> d()
  {
    return Collections.emptySet();
  }
  
  @NonNull
  a f()
  {
    return new a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\GeneratedAppGlideModuleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */