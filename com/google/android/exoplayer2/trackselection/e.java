package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.u0.d;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import java.util.List;

public abstract class e
  implements g
{
  protected final TrackGroup a;
  protected final int b;
  protected final int[] c;
  private final int d;
  private final Format[] e;
  private final long[] f;
  private int g;
  
  public e(TrackGroup paramTrackGroup, int... paramVarArgs)
  {
    this(paramTrackGroup, paramVarArgs, 0);
  }
  
  public e(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    int j = 0;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    this.d = paramInt;
    this.a = ((TrackGroup)com.google.android.exoplayer2.util.g.e(paramTrackGroup));
    paramInt = paramArrayOfInt.length;
    this.b = paramInt;
    this.e = new Format[paramInt];
    for (paramInt = 0; paramInt < paramArrayOfInt.length; paramInt++) {
      this.e[paramInt] = paramTrackGroup.a(paramArrayOfInt[paramInt]);
    }
    Arrays.sort(this.e, a.c);
    this.c = new int[this.b];
    for (paramInt = j;; paramInt++)
    {
      j = this.b;
      if (paramInt >= j) {
        break;
      }
      this.c[paramInt] = paramTrackGroup.b(this.e[paramInt]);
    }
    this.f = new long[j];
  }
  
  public final Format a(int paramInt)
  {
    return this.e[paramInt];
  }
  
  public void b() {}
  
  public void c() {}
  
  public boolean e(int paramInt, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    boolean bool = f(paramInt, l);
    for (int i = 0; (i < this.b) && (!bool); i++) {
      if ((i != paramInt) && (!f(i, l))) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (!bool) {
      return false;
    }
    long[] arrayOfLong = this.f;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], o0.a(l, paramLong, Long.MAX_VALUE));
    return true;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (e)paramObject;
      if ((this.a != ((e)paramObject).a) || (!Arrays.equals(this.c, ((e)paramObject).c))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public boolean f(int paramInt, long paramLong)
  {
    boolean bool;
    if (this.f[paramInt] > paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final int h(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public int hashCode()
  {
    if (this.g == 0) {
      this.g = (System.identityHashCode(this.a) * 31 + Arrays.hashCode(this.c));
    }
    return this.g;
  }
  
  public void i(float paramFloat) {}
  
  public final int l(int paramInt)
  {
    for (int i = 0; i < this.b; i++) {
      if (this.c[i] == paramInt) {
        return i;
      }
    }
    return -1;
  }
  
  public final int length()
  {
    return this.c.length;
  }
  
  public final TrackGroup m()
  {
    return this.a;
  }
  
  public int o(long paramLong, List<? extends d> paramList)
  {
    return paramList.size();
  }
  
  public final int p(Format paramFormat)
  {
    for (int i = 0; i < this.b; i++) {
      if (this.e[i] == paramFormat) {
        return i;
      }
    }
    return -1;
  }
  
  public final int r()
  {
    return this.c[d()];
  }
  
  public final Format s()
  {
    return this.e[d()];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */