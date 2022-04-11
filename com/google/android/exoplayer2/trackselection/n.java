package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.util.o0;

public final class n
{
  public final int a;
  public final e2[] b;
  public final g[] c;
  @Nullable
  public final Object d;
  
  public n(e2[] paramArrayOfe2, g[] paramArrayOfg, @Nullable Object paramObject)
  {
    this.b = paramArrayOfe2;
    this.c = ((g[])paramArrayOfg.clone());
    this.d = paramObject;
    this.a = paramArrayOfe2.length;
  }
  
  public boolean a(@Nullable n paramn)
  {
    if ((paramn != null) && (paramn.c.length == this.c.length))
    {
      for (int i = 0; i < this.c.length; i++) {
        if (!b(paramn, i)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean b(@Nullable n paramn, int paramInt)
  {
    boolean bool1 = false;
    if (paramn == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (o0.b(this.b[paramInt], paramn.b[paramInt]))
    {
      bool2 = bool1;
      if (o0.b(this.c[paramInt], paramn.c[paramInt])) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean c(int paramInt)
  {
    boolean bool;
    if (this.b[paramInt] != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */