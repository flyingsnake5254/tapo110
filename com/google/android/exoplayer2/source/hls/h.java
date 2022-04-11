package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class h
{
  private final LinkedHashMap<Uri, byte[]> a;
  
  public h(final int paramInt)
  {
    this.a = new a(paramInt + 1, 1.0F, false, paramInt);
  }
  
  @Nullable
  public byte[] a(@Nullable Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    return (byte[])this.a.get(paramUri);
  }
  
  @Nullable
  public byte[] b(Uri paramUri, byte[] paramArrayOfByte)
  {
    return (byte[])this.a.put((Uri)g.e(paramUri), (byte[])g.e(paramArrayOfByte));
  }
  
  @Nullable
  public byte[] c(Uri paramUri)
  {
    return (byte[])this.a.remove(g.e(paramUri));
  }
  
  class a
    extends LinkedHashMap<Uri, byte[]>
  {
    a(int paramInt1, float paramFloat, boolean paramBoolean, int paramInt2)
    {
      super(paramFloat, paramBoolean);
    }
    
    protected boolean removeEldestEntry(Map.Entry<Uri, byte[]> paramEntry)
    {
      boolean bool;
      if (size() > paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */