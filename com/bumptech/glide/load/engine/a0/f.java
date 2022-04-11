package com.bumptech.glide.load.engine.a0;

import android.content.Context;
import java.io.File;

public final class f
  extends d
{
  public f(Context paramContext)
  {
    this(paramContext, "image_manager_disk_cache", 262144000L);
  }
  
  public f(Context paramContext, final String paramString, long paramLong)
  {
    super(new a(paramContext, paramString), paramLong);
  }
  
  class a
    implements d.a
  {
    a(String paramString) {}
    
    public File a()
    {
      File localFile = f.this.getCacheDir();
      if (localFile == null) {
        return null;
      }
      if (paramString != null) {
        return new File(localFile, paramString);
      }
      return localFile;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */