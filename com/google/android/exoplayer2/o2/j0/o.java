package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

public final class o
{
  public final int a;
  public final int b;
  public final long c;
  public final long d;
  public final long e;
  public final Format f;
  public final int g;
  @Nullable
  public final long[] h;
  @Nullable
  public final long[] i;
  public final int j;
  @Nullable
  private final p[] k;
  
  public o(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, @Nullable p[] paramArrayOfp, int paramInt4, @Nullable long[] paramArrayOfLong1, @Nullable long[] paramArrayOfLong2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramFormat;
    this.g = paramInt3;
    this.k = paramArrayOfp;
    this.j = paramInt4;
    this.h = paramArrayOfLong1;
    this.i = paramArrayOfLong2;
  }
  
  @Nullable
  public p a(int paramInt)
  {
    Object localObject = this.k;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = localObject[paramInt];
    }
    return (p)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */