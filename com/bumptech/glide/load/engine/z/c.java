package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.j;

class c
  implements l
{
  private final b a = new b();
  private final h<a, Bitmap> b = new h();
  
  static String f(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], ");
    localStringBuilder.append(paramConfig);
    return localStringBuilder.toString();
  }
  
  private static String g(Bitmap paramBitmap)
  {
    return f(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
  }
  
  public String a(Bitmap paramBitmap)
  {
    return g(paramBitmap);
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return f(paramInt1, paramInt2, paramConfig);
  }
  
  public void c(Bitmap paramBitmap)
  {
    a locala = this.a.e(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    this.b.d(locala, paramBitmap);
  }
  
  public Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    paramConfig = this.a.e(paramInt1, paramInt2, paramConfig);
    return (Bitmap)this.b.a(paramConfig);
  }
  
  public int e(Bitmap paramBitmap)
  {
    return j.h(paramBitmap);
  }
  
  public Bitmap removeLast()
  {
    return (Bitmap)this.b.f();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AttributeStrategy:\n  ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  @VisibleForTesting
  static class a
    implements m
  {
    private final c.b a;
    private int b;
    private int c;
    private Bitmap.Config d;
    
    public a(c.b paramb)
    {
      this.a = paramb;
    }
    
    public void a()
    {
      this.a.c(this);
    }
    
    public void b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramConfig;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (a)paramObject;
        bool3 = bool2;
        if (this.b == ((a)paramObject).b)
        {
          bool3 = bool2;
          if (this.c == ((a)paramObject).c)
          {
            bool3 = bool2;
            if (this.d == ((a)paramObject).d) {
              bool3 = true;
            }
          }
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      int i = this.b;
      int j = this.c;
      Bitmap.Config localConfig = this.d;
      int k;
      if (localConfig != null) {
        k = localConfig.hashCode();
      } else {
        k = 0;
      }
      return (i * 31 + j) * 31 + k;
    }
    
    public String toString()
    {
      return c.f(this.b, this.c, this.d);
    }
  }
  
  @VisibleForTesting
  static class b
    extends d<c.a>
  {
    protected c.a d()
    {
      return new c.a(this);
    }
    
    c.a e(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      c.a locala = (c.a)b();
      locala.b(paramInt1, paramInt2, paramConfig);
      return locala;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\z\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */