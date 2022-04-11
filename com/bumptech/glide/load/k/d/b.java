package com.bumptech.glide.load.k.d;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;

public class b
  implements u<byte[]>
{
  private final byte[] c;
  
  public b(byte[] paramArrayOfByte)
  {
    this.c = ((byte[])i.d(paramArrayOfByte));
  }
  
  public int a()
  {
    return this.c.length;
  }
  
  @NonNull
  public byte[] b()
  {
    return this.c;
  }
  
  public void c() {}
  
  @NonNull
  public Class<byte[]> e()
  {
    return byte[].class;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */