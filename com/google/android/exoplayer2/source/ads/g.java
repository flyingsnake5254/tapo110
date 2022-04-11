package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.v0;
import java.util.Arrays;

public final class g
{
  public static final g a = new g(null, new a[0], 0L, -9223372036854775807L, 0);
  private static final a b = new a(0L).g(0);
  public static final v0<g> c = b.a;
  @Nullable
  public final Object d;
  public final int e;
  public final long f;
  public final long g;
  public final int h;
  private final a[] i;
  
  private g(@Nullable Object paramObject, a[] paramArrayOfa, long paramLong1, long paramLong2, int paramInt)
  {
    this.d = paramObject;
    this.f = paramLong1;
    this.g = paramLong2;
    this.e = (paramArrayOfa.length + paramInt);
    this.i = paramArrayOfa;
    this.h = paramInt;
  }
  
  private boolean d(long paramLong1, long paramLong2, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramLong1 == Long.MIN_VALUE) {
      return false;
    }
    long l = a(paramInt).b;
    if (l == Long.MIN_VALUE)
    {
      if ((paramLong2 == -9223372036854775807L) || (paramLong1 < paramLong2)) {
        bool2 = true;
      }
      return bool2;
    }
    bool2 = bool1;
    if (paramLong1 < l) {
      bool2 = true;
    }
    return bool2;
  }
  
  public a a(int paramInt)
  {
    int j = this.h;
    a locala;
    if (paramInt < j) {
      locala = b;
    } else {
      locala = this.i[(paramInt - j)];
    }
    return locala;
  }
  
  public int b(long paramLong1, long paramLong2)
  {
    int j = -1;
    int k = j;
    if (paramLong1 != Long.MIN_VALUE) {
      if ((paramLong2 != -9223372036854775807L) && (paramLong1 >= paramLong2))
      {
        k = j;
      }
      else
      {
        for (int m = this.h; (m < this.e) && (((a(m).b != Long.MIN_VALUE) && (a(m).b <= paramLong1)) || (!a(m).f())); m++) {}
        k = j;
        if (m < this.e) {
          k = m;
        }
      }
    }
    return k;
  }
  
  public int c(long paramLong1, long paramLong2)
  {
    for (int j = this.e - 1; (j >= 0) && (d(paramLong1, paramLong2, j)); j--) {}
    if ((j < 0) || (!a(j).e())) {
      j = -1;
    }
    return j;
  }
  
  @CheckResult
  public g e(long[][] paramArrayOfLong)
  {
    int j = this.h;
    int k = 0;
    boolean bool;
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    a[] arrayOfa = this.i;
    arrayOfa = (a[])o0.w0(arrayOfa, arrayOfa.length);
    while (k < this.e)
    {
      arrayOfa[k] = arrayOfa[k].h(paramArrayOfLong[k]);
      k++;
    }
    return new g(this.d, arrayOfa, this.f, this.g, this.h);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (g.class == paramObject.getClass()))
    {
      paramObject = (g)paramObject;
      if ((!o0.b(this.d, ((g)paramObject).d)) || (this.e != ((g)paramObject).e) || (this.f != ((g)paramObject).f) || (this.g != ((g)paramObject).g) || (this.h != ((g)paramObject).h) || (!Arrays.equals(this.i, ((g)paramObject).i))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.e;
    Object localObject = this.d;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = localObject.hashCode();
    }
    return ((((j * 31 + k) * 31 + (int)this.f) * 31 + (int)this.g) * 31 + this.h) * 31 + Arrays.hashCode(this.i);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AdPlaybackState(adsId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", adResumePositionUs=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", adGroups=[");
    for (int j = 0; j < this.i.length; j++)
    {
      localStringBuilder.append("adGroup(timeUs=");
      localStringBuilder.append(this.i[j].b);
      localStringBuilder.append(", ads=[");
      for (int k = 0; k < this.i[j].e.length; k++)
      {
        localStringBuilder.append("ad(state=");
        int m = this.i[j].e[k];
        if (m != 0)
        {
          if (m != 1)
          {
            if (m != 2)
            {
              if (m != 3)
              {
                if (m != 4) {
                  localStringBuilder.append('?');
                } else {
                  localStringBuilder.append('!');
                }
              }
              else {
                localStringBuilder.append('P');
              }
            }
            else {
              localStringBuilder.append('S');
            }
          }
          else {
            localStringBuilder.append('R');
          }
        }
        else {
          localStringBuilder.append('_');
        }
        localStringBuilder.append(", durationUs=");
        localStringBuilder.append(this.i[j].f[k]);
        localStringBuilder.append(')');
        if (k < this.i[j].e.length - 1) {
          localStringBuilder.append(", ");
        }
      }
      localStringBuilder.append("])");
      if (j < this.i.length - 1) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("])");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public static final v0<a> a = a.a;
    public final long b;
    public final int c;
    public final Uri[] d;
    public final int[] e;
    public final long[] f;
    public final long g;
    public final boolean h;
    
    public a(long paramLong)
    {
      this(paramLong, -1, new int[0], new Uri[0], new long[0], 0L, false);
    }
    
    private a(long paramLong1, int paramInt, int[] paramArrayOfInt, Uri[] paramArrayOfUri, long[] paramArrayOfLong, long paramLong2, boolean paramBoolean)
    {
      boolean bool;
      if (paramArrayOfInt.length == paramArrayOfUri.length) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.util.g.a(bool);
      this.b = paramLong1;
      this.c = paramInt;
      this.e = paramArrayOfInt;
      this.d = paramArrayOfUri;
      this.f = paramArrayOfLong;
      this.g = paramLong2;
      this.h = paramBoolean;
    }
    
    @CheckResult
    private static long[] a(long[] paramArrayOfLong, int paramInt)
    {
      int i = paramArrayOfLong.length;
      paramInt = Math.max(paramInt, i);
      paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramInt);
      Arrays.fill(paramArrayOfLong, i, paramInt, -9223372036854775807L);
      return paramArrayOfLong;
    }
    
    @CheckResult
    private static int[] b(int[] paramArrayOfInt, int paramInt)
    {
      int i = paramArrayOfInt.length;
      paramInt = Math.max(paramInt, i);
      paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt);
      Arrays.fill(paramArrayOfInt, i, paramInt, 0);
      return paramArrayOfInt;
    }
    
    public int c()
    {
      return d(-1);
    }
    
    public int d(int paramInt)
    {
      
      for (;;)
      {
        int[] arrayOfInt = this.e;
        if ((paramInt >= arrayOfInt.length) || (this.h) || (arrayOfInt[paramInt] == 0) || (arrayOfInt[paramInt] == 1)) {
          break;
        }
        paramInt++;
      }
      return paramInt;
    }
    
    public boolean e()
    {
      if (this.c == -1) {
        return true;
      }
      int i = 0;
      while (i < this.c)
      {
        int[] arrayOfInt = this.e;
        if ((arrayOfInt[i] != 0) && (arrayOfInt[i] != 1)) {
          i++;
        } else {
          return true;
        }
      }
      return false;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (a.class == paramObject.getClass()))
      {
        paramObject = (a)paramObject;
        if ((this.b != ((a)paramObject).b) || (this.c != ((a)paramObject).c) || (!Arrays.equals(this.d, ((a)paramObject).d)) || (!Arrays.equals(this.e, ((a)paramObject).e)) || (!Arrays.equals(this.f, ((a)paramObject).f)) || (this.g != ((a)paramObject).g) || (this.h != ((a)paramObject).h)) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public boolean f()
    {
      boolean bool;
      if ((this.c != -1) && (c() >= this.c)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    @CheckResult
    public a g(int paramInt)
    {
      int[] arrayOfInt = b(this.e, paramInt);
      long[] arrayOfLong = a(this.f, paramInt);
      Uri[] arrayOfUri = (Uri[])Arrays.copyOf(this.d, paramInt);
      return new a(this.b, paramInt, arrayOfInt, arrayOfUri, arrayOfLong, this.g, this.h);
    }
    
    @CheckResult
    public a h(long[] paramArrayOfLong)
    {
      int i = paramArrayOfLong.length;
      Uri[] arrayOfUri = this.d;
      long[] arrayOfLong;
      if (i < arrayOfUri.length)
      {
        arrayOfLong = a(paramArrayOfLong, arrayOfUri.length);
      }
      else
      {
        arrayOfLong = paramArrayOfLong;
        if (this.c != -1)
        {
          arrayOfLong = paramArrayOfLong;
          if (paramArrayOfLong.length > arrayOfUri.length) {
            arrayOfLong = Arrays.copyOf(paramArrayOfLong, arrayOfUri.length);
          }
        }
      }
      return new a(this.b, this.c, this.e, this.d, arrayOfLong, this.g, this.h);
    }
    
    public int hashCode()
    {
      int i = this.c;
      long l = this.b;
      int j = (int)(l ^ l >>> 32);
      int k = Arrays.hashCode(this.d);
      int m = Arrays.hashCode(this.e);
      int n = Arrays.hashCode(this.f);
      l = this.g;
      return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + (int)(l ^ l >>> 32)) * 31 + this.h;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\ads\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */