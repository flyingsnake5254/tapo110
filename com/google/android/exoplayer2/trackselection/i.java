package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.d2;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import java.util.Arrays;

public abstract class i
  extends m
{
  @Nullable
  private a c;
  
  private static int f(d2[] paramArrayOfd2, TrackGroup paramTrackGroup, int[] paramArrayOfInt, boolean paramBoolean)
    throws ExoPlaybackException
  {
    int i = paramArrayOfd2.length;
    int j = 0;
    int k = 0;
    int i4;
    for (int m = 1; j < paramArrayOfd2.length; m = i4)
    {
      d2 locald2 = paramArrayOfd2[j];
      int n = 0;
      int i1 = 0;
      while (n < paramTrackGroup.c)
      {
        i1 = Math.max(i1, c2.d(locald2.a(paramTrackGroup.a(n))));
        n++;
      }
      if (paramArrayOfInt[j] == 0) {
        n = 1;
      } else {
        n = 0;
      }
      int i2;
      int i3;
      if (i1 <= k)
      {
        i2 = i;
        i3 = k;
        i4 = m;
        if (i1 == k)
        {
          i2 = i;
          i3 = k;
          i4 = m;
          if (paramBoolean)
          {
            i2 = i;
            i3 = k;
            i4 = m;
            if (m == 0)
            {
              i2 = i;
              i3 = k;
              i4 = m;
              if (n == 0) {}
            }
          }
        }
      }
      else
      {
        i2 = j;
        i4 = n;
        i3 = i1;
      }
      j++;
      i = i2;
      k = i3;
    }
    return i;
  }
  
  private static int[] h(d2 paramd2, TrackGroup paramTrackGroup)
    throws ExoPlaybackException
  {
    int[] arrayOfInt = new int[paramTrackGroup.c];
    for (int i = 0; i < paramTrackGroup.c; i++) {
      arrayOfInt[i] = paramd2.a(paramTrackGroup.a(i));
    }
    return arrayOfInt;
  }
  
  private static int[] i(d2[] paramArrayOfd2)
    throws ExoPlaybackException
  {
    int i = paramArrayOfd2.length;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = paramArrayOfd2[j].s();
    }
    return arrayOfInt;
  }
  
  public final void d(@Nullable Object paramObject)
  {
    this.c = ((a)paramObject);
  }
  
  public final n e(d2[] paramArrayOfd2, TrackGroupArray paramTrackGroupArray, e0.a parama, j2 paramj2)
    throws ExoPlaybackException
  {
    int[] arrayOfInt1 = new int[paramArrayOfd2.length + 1];
    int i = paramArrayOfd2.length + 1;
    TrackGroup[][] arrayOfTrackGroup = new TrackGroup[i][];
    int[][][] arrayOfInt = new int[paramArrayOfd2.length + 1][][];
    int j = 0;
    int m;
    for (int k = 0; k < i; k++)
    {
      m = paramTrackGroupArray.d;
      arrayOfTrackGroup[k] = new TrackGroup[m];
      arrayOfInt[k] = new int[m][];
    }
    int[] arrayOfInt2 = i(paramArrayOfd2);
    for (k = 0; k < paramTrackGroupArray.d; k++)
    {
      localObject1 = paramTrackGroupArray.a(k);
      boolean bool;
      if (y.k(((TrackGroup)localObject1).a(0).H3) == 5) {
        bool = true;
      } else {
        bool = false;
      }
      m = f(paramArrayOfd2, (TrackGroup)localObject1, arrayOfInt1, bool);
      if (m == paramArrayOfd2.length) {
        localObject2 = new int[((TrackGroup)localObject1).c];
      } else {
        localObject2 = h(paramArrayOfd2[m], (TrackGroup)localObject1);
      }
      i = arrayOfInt1[m];
      arrayOfTrackGroup[m][i] = localObject1;
      arrayOfInt[m][i] = localObject2;
      arrayOfInt1[m] += 1;
    }
    Object localObject2 = new TrackGroupArray[paramArrayOfd2.length];
    Object localObject1 = new String[paramArrayOfd2.length];
    paramTrackGroupArray = new int[paramArrayOfd2.length];
    for (k = j; k < paramArrayOfd2.length; k++)
    {
      j = arrayOfInt1[k];
      localObject2[k] = new TrackGroupArray((TrackGroup[])o0.w0(arrayOfTrackGroup[k], j));
      arrayOfInt[k] = ((int[][])o0.w0(arrayOfInt[k], j));
      localObject1[k] = paramArrayOfd2[k].getName();
      paramTrackGroupArray[k] = paramArrayOfd2[k].f();
    }
    k = arrayOfInt1[paramArrayOfd2.length];
    paramArrayOfd2 = new a((String[])localObject1, paramTrackGroupArray, (TrackGroupArray[])localObject2, arrayOfInt2, arrayOfInt, new TrackGroupArray((TrackGroup[])o0.w0(arrayOfTrackGroup[paramArrayOfd2.length], k)));
    paramTrackGroupArray = j(paramArrayOfd2, arrayOfInt, arrayOfInt2, parama, paramj2);
    return new n((e2[])paramTrackGroupArray.first, (g[])paramTrackGroupArray.second, paramArrayOfd2);
  }
  
  @Nullable
  public final a g()
  {
    return this.c;
  }
  
  protected abstract Pair<e2[], g[]> j(a parama, int[][][] paramArrayOfInt, int[] paramArrayOfInt1, e0.a parama1, j2 paramj2)
    throws ExoPlaybackException;
  
  public static final class a
  {
    private final int a;
    private final String[] b;
    private final int[] c;
    private final TrackGroupArray[] d;
    private final int[] e;
    private final int[][][] f;
    private final TrackGroupArray g;
    
    a(String[] paramArrayOfString, int[] paramArrayOfInt1, TrackGroupArray[] paramArrayOfTrackGroupArray, int[] paramArrayOfInt2, int[][][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray)
    {
      this.b = paramArrayOfString;
      this.c = paramArrayOfInt1;
      this.d = paramArrayOfTrackGroupArray;
      this.f = paramArrayOfInt;
      this.e = paramArrayOfInt2;
      this.g = paramTrackGroupArray;
      this.a = paramArrayOfInt1.length;
    }
    
    public int a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = this.d[paramInt1].a(paramInt2).c;
      int[] arrayOfInt = new int[i];
      int j = 0;
      int n;
      for (int k = 0; j < i; k = n)
      {
        int m = f(paramInt1, paramInt2, j);
        if (m != 4)
        {
          n = k;
          if (paramBoolean)
          {
            n = k;
            if (m != 3) {}
          }
        }
        else
        {
          arrayOfInt[k] = j;
          n = k + 1;
        }
        j++;
      }
      return b(paramInt1, paramInt2, Arrays.copyOf(arrayOfInt, k));
    }
    
    public int b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      int i = 0;
      Object localObject = null;
      boolean bool = false;
      int j = 0;
      int k = 16;
      while (i < paramArrayOfInt.length)
      {
        int m = paramArrayOfInt[i];
        String str = this.d[paramInt1].a(paramInt2).a(m).H3;
        if (j == 0) {
          localObject = str;
        } else {
          bool |= o0.b(localObject, str) ^ true;
        }
        k = Math.min(k, c2.c(this.f[paramInt1][paramInt2][i]));
        i++;
        j++;
      }
      paramInt2 = k;
      if (bool) {
        paramInt2 = Math.min(k, this.e[paramInt1]);
      }
      return paramInt2;
    }
    
    public int c()
    {
      return this.a;
    }
    
    public int d(int paramInt)
    {
      return this.c[paramInt];
    }
    
    public TrackGroupArray e(int paramInt)
    {
      return this.d[paramInt];
    }
    
    public int f(int paramInt1, int paramInt2, int paramInt3)
    {
      return c2.d(this.f[paramInt1][paramInt2][paramInt3]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */