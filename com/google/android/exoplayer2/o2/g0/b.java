package com.google.android.exoplayer2.o2.g0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

final class b
{
  public final long a;
  public final List<a> b;
  
  public b(long paramLong, List<a> paramList)
  {
    this.a = paramLong;
    this.b = paramList;
  }
  
  @Nullable
  public MotionPhotoMetadata a(long paramLong)
  {
    if (this.b.size() < 2) {
      return null;
    }
    int i = this.b.size() - 1;
    long l1 = paramLong;
    long l2 = -1L;
    paramLong = l2;
    long l3 = paramLong;
    long l4 = l3;
    boolean bool = false;
    long l5 = l3;
    long l6 = paramLong;
    paramLong = l1;
    while (i >= 0)
    {
      a locala = (a)this.b.get(i);
      bool = "video/mp4".equals(locala.a) | bool;
      if (i == 0)
      {
        l3 = paramLong - locala.d;
        paramLong = 0L;
      }
      else
      {
        l1 = paramLong - locala.c;
        l3 = paramLong;
        paramLong = l1;
      }
      if ((bool) && (paramLong != l3))
      {
        l4 = l3 - paramLong;
        l5 = paramLong;
        bool = false;
      }
      if (i == 0)
      {
        l2 = paramLong;
        l6 = l3;
      }
      i--;
    }
    if ((l5 != -1L) && (l4 != -1L) && (l2 != -1L) && (l6 != -1L)) {
      return new MotionPhotoMetadata(l2, l6, this.a, l5, l4);
    }
    return null;
  }
  
  public static final class a
  {
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    
    public a(String paramString1, String paramString2, long paramLong1, long paramLong2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramLong1;
      this.d = paramLong2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\g0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */