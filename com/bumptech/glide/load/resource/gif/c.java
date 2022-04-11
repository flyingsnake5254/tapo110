package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.util.a;
import java.io.File;
import java.io.IOException;

public class c
  implements h<GifDrawable>
{
  @NonNull
  public EncodeStrategy b(@NonNull f paramf)
  {
    return EncodeStrategy.SOURCE;
  }
  
  public boolean c(@NonNull u<GifDrawable> paramu, @NonNull File paramFile, @NonNull f paramf)
  {
    paramu = (GifDrawable)paramu.get();
    boolean bool;
    try
    {
      a.e(paramu.c(), paramFile);
      bool = true;
    }
    catch (IOException paramu)
    {
      if (Log.isLoggable("GifEncoder", 5)) {
        Log.w("GifEncoder", "Failed to encode GIF drawable data", paramu);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */