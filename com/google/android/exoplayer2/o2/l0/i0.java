package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import java.util.Collections;
import java.util.List;

public abstract interface i0
{
  public abstract void a(l0 paraml0, l paraml, d paramd);
  
  public abstract void b(d0 paramd0, int paramInt)
    throws ParserException;
  
  public abstract void c();
  
  public static final class a
  {
    public final String a;
    public final int b;
    public final byte[] c;
    
    public a(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramString;
      this.b = paramInt;
      this.c = paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public final int a;
    @Nullable
    public final String b;
    public final List<i0.a> c;
    public final byte[] d;
    
    public b(int paramInt, @Nullable String paramString, @Nullable List<i0.a> paramList, byte[] paramArrayOfByte)
    {
      this.a = paramInt;
      this.b = paramString;
      if (paramList == null) {
        paramString = Collections.emptyList();
      } else {
        paramString = Collections.unmodifiableList(paramList);
      }
      this.c = paramString;
      this.d = paramArrayOfByte;
    }
  }
  
  public static abstract interface c
  {
    public abstract SparseArray<i0> a();
    
    @Nullable
    public abstract i0 b(int paramInt, i0.b paramb);
  }
  
  public static final class d
  {
    private final String a;
    private final int b;
    private final int c;
    private int d;
    private String e;
    
    public d(int paramInt1, int paramInt2)
    {
      this(Integer.MIN_VALUE, paramInt1, paramInt2);
    }
    
    public d(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if (paramInt1 != Integer.MIN_VALUE)
      {
        localObject = new StringBuilder(12);
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("/");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      this.a = ((String)localObject);
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = Integer.MIN_VALUE;
      this.e = "";
    }
    
    private void d()
    {
      if (this.d != Integer.MIN_VALUE) {
        return;
      }
      throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }
    
    public void a()
    {
      int i = this.d;
      if (i == Integer.MIN_VALUE) {
        i = this.b;
      } else {
        i += this.c;
      }
      this.d = i;
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 11);
      localStringBuilder.append(str);
      localStringBuilder.append(i);
      this.e = localStringBuilder.toString();
    }
    
    public String b()
    {
      d();
      return this.e;
    }
    
    public int c()
    {
      d();
      return this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */