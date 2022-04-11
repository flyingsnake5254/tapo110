package com.google.android.exoplayer2.n2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.v0;

public final class b
{
  public static final b a = new b(0, 0, 0);
  public static final v0<b> b = a.a;
  public final int c;
  public final int d;
  public final int e;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.c != ((b)paramObject).c) || (this.d != ((b)paramObject).d) || (this.e != ((b)paramObject).e)) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return ((527 + this.c) * 31 + this.d) * 31 + this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\n2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */