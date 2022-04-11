package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;

public class c0
{
  public final Object a;
  public final int b;
  public final int c;
  public final long d;
  public final int e;
  
  protected c0(c0 paramc0)
  {
    this.a = paramc0.a;
    this.b = paramc0.b;
    this.c = paramc0.c;
    this.d = paramc0.d;
    this.e = paramc0.e;
  }
  
  public c0(Object paramObject)
  {
    this(paramObject, -1L);
  }
  
  public c0(Object paramObject, int paramInt1, int paramInt2, long paramLong)
  {
    this(paramObject, paramInt1, paramInt2, paramLong, -1);
  }
  
  private c0(Object paramObject, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.a = paramObject;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
    this.e = paramInt3;
  }
  
  public c0(Object paramObject, long paramLong)
  {
    this(paramObject, -1, -1, paramLong, -1);
  }
  
  public c0(Object paramObject, long paramLong, int paramInt)
  {
    this(paramObject, -1, -1, paramLong, paramInt);
  }
  
  public c0 a(Object paramObject)
  {
    if (this.a.equals(paramObject)) {
      paramObject = this;
    } else {
      paramObject = new c0(paramObject, this.b, this.c, this.d, this.e);
    }
    return (c0)paramObject;
  }
  
  public boolean b()
  {
    boolean bool;
    if (this.b != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c0)) {
      return false;
    }
    paramObject = (c0)paramObject;
    if ((!this.a.equals(((c0)paramObject).a)) || (this.b != ((c0)paramObject).b) || (this.c != ((c0)paramObject).c) || (this.d != ((c0)paramObject).d) || (this.e != ((c0)paramObject).e)) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return ((((527 + this.a.hashCode()) * 31 + this.b) * 31 + this.c) * 31 + (int)this.d) * 31 + this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */