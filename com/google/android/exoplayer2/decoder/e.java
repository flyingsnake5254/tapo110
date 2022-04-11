package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.g;

public final class e
{
  public final String a;
  public final Format b;
  public final Format c;
  public final int d;
  public final int e;
  
  public e(String paramString, Format paramFormat1, Format paramFormat2, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    g.a(bool);
    this.a = g.d(paramString);
    this.b = ((Format)g.e(paramFormat1));
    this.c = ((Format)g.e(paramFormat2));
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (e.class == paramObject.getClass()))
    {
      paramObject = (e)paramObject;
      if ((this.d != ((e)paramObject).d) || (this.e != ((e)paramObject).e) || (!this.a.equals(((e)paramObject).a)) || (!this.b.equals(((e)paramObject).b)) || (!this.c.equals(((e)paramObject).c))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((((527 + this.d) * 31 + this.e) * 31 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\decoder\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */