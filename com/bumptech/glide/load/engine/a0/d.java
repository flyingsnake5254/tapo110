package com.bumptech.glide.load.engine.a0;

import java.io.File;

public class d
  implements a.a
{
  private final long a;
  private final a b;
  
  public d(a parama, long paramLong)
  {
    this.a = paramLong;
    this.b = parama;
  }
  
  public a build()
  {
    File localFile = this.b.a();
    if (localFile == null) {
      return null;
    }
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {
      return null;
    }
    return e.c(localFile, this.a);
  }
  
  public static abstract interface a
  {
    public abstract File a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */