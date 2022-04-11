package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class e
{
  public final int a;
  
  public e(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static String a(int paramInt)
  {
    char c1 = (char)(paramInt >> 24 & 0xFF);
    char c2 = (char)(paramInt >> 16 & 0xFF);
    char c3 = (char)(paramInt >> 8 & 0xFF);
    char c4 = (char)(paramInt & 0xFF);
    StringBuilder localStringBuilder = new StringBuilder(4);
    localStringBuilder.append(c1);
    localStringBuilder.append(c2);
    localStringBuilder.append(c3);
    localStringBuilder.append(c4);
    return localStringBuilder.toString();
  }
  
  public static int b(int paramInt)
  {
    return paramInt & 0xFFFFFF;
  }
  
  public static int c(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public String toString()
  {
    return a(this.a);
  }
  
  static final class a
    extends e
  {
    public final long b;
    public final List<e.b> c;
    public final List<a> d;
    
    public a(int paramInt, long paramLong)
    {
      super();
      this.b = paramLong;
      this.c = new ArrayList();
      this.d = new ArrayList();
    }
    
    public void d(a parama)
    {
      this.d.add(parama);
    }
    
    public void e(e.b paramb)
    {
      this.c.add(paramb);
    }
    
    @Nullable
    public a f(int paramInt)
    {
      int i = this.d.size();
      for (int j = 0; j < i; j++)
      {
        a locala = (a)this.d.get(j);
        if (locala.a == paramInt) {
          return locala;
        }
      }
      return null;
    }
    
    @Nullable
    public e.b g(int paramInt)
    {
      int i = this.c.size();
      for (int j = 0; j < i; j++)
      {
        e.b localb = (e.b)this.c.get(j);
        if (localb.a == paramInt) {
          return localb;
        }
      }
      return null;
    }
    
    public String toString()
    {
      String str1 = e.a(this.a);
      String str2 = Arrays.toString(this.c.toArray());
      String str3 = Arrays.toString(this.d.toArray());
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
      localStringBuilder.append(str1);
      localStringBuilder.append(" leaves: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" containers: ");
      localStringBuilder.append(str3);
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends e
  {
    public final d0 b;
    
    public b(int paramInt, d0 paramd0)
    {
      super();
      this.b = paramd0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */