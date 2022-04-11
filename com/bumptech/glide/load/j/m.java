package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.j;
import java.util.Queue;

public class m<A, B>
{
  private final f<b<A>, B> a;
  
  public m(long paramLong)
  {
    this.a = new a(paramLong);
  }
  
  @Nullable
  public B a(A paramA, int paramInt1, int paramInt2)
  {
    b localb = b.a(paramA, paramInt1, paramInt2);
    paramA = this.a.g(localb);
    localb.c();
    return paramA;
  }
  
  public void b(A paramA, int paramInt1, int paramInt2, B paramB)
  {
    paramA = b.a(paramA, paramInt1, paramInt2);
    this.a.k(paramA, paramB);
  }
  
  class a
    extends f<m.b<A>, B>
  {
    a(long paramLong)
    {
      super();
    }
    
    protected void n(@NonNull m.b<A> paramb, @Nullable B paramB)
    {
      paramb.c();
    }
  }
  
  @VisibleForTesting
  static final class b<A>
  {
    private static final Queue<b<?>> a = j.f(0);
    private int b;
    private int c;
    private A d;
    
    static <A> b<A> a(A paramA, int paramInt1, int paramInt2)
    {
      synchronized (a)
      {
        b localb = (b)((Queue)???).poll();
        ??? = localb;
        if (localb == null) {
          ??? = new b();
        }
        ((b)???).b(paramA, paramInt1, paramInt2);
        return (b<A>)???;
      }
    }
    
    private void b(A paramA, int paramInt1, int paramInt2)
    {
      this.d = paramA;
      this.c = paramInt1;
      this.b = paramInt2;
    }
    
    public void c()
    {
      synchronized (a)
      {
        ???.offer(this);
        return;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof b;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (b)paramObject;
        bool3 = bool2;
        if (this.c == ((b)paramObject).c)
        {
          bool3 = bool2;
          if (this.b == ((b)paramObject).b)
          {
            bool3 = bool2;
            if (this.d.equals(((b)paramObject).d)) {
              bool3 = true;
            }
          }
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      return (this.b * 31 + this.c) * 31 + this.d.hashCode();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */