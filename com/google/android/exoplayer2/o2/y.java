package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;

public abstract interface y
{
  public abstract a a(long paramLong);
  
  public abstract boolean g();
  
  public abstract long i();
  
  public static final class a
  {
    public final z a;
    public final z b;
    
    public a(z paramz)
    {
      this(paramz, paramz);
    }
    
    public a(z paramz1, z paramz2)
    {
      this.a = ((z)g.e(paramz1));
      this.b = ((z)g.e(paramz2));
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
        if ((!this.a.equals(((a)paramObject).a)) || (!this.b.equals(((a)paramObject).b))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    public String toString()
    {
      String str1 = String.valueOf(this.a);
      String str2;
      if (this.a.equals(this.b))
      {
        str2 = "";
      }
      else
      {
        str2 = String.valueOf(this.b);
        localStringBuilder = new StringBuilder(str2.length() + 2);
        localStringBuilder.append(", ");
        localStringBuilder.append(str2);
        str2 = localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder(str1.length() + 2 + String.valueOf(str2).length());
      localStringBuilder.append("[");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static class b
    implements y
  {
    private final long a;
    private final y.a b;
    
    public b(long paramLong)
    {
      this(paramLong, 0L);
    }
    
    public b(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      z localz;
      if (paramLong2 == 0L) {
        localz = z.a;
      } else {
        localz = new z(0L, paramLong2);
      }
      this.b = new y.a(localz);
    }
    
    public y.a a(long paramLong)
    {
      return this.b;
    }
    
    public boolean g()
    {
      return false;
    }
    
    public long i()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */