package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class r
{
  private final d a;
  private final boolean b;
  private final c c;
  private final int d;
  
  private r(c paramc)
  {
    this(paramc, false, d.g(), Integer.MAX_VALUE);
  }
  
  private r(c paramc, boolean paramBoolean, d paramd, int paramInt)
  {
    this.c = paramc;
    this.b = paramBoolean;
    this.a = paramd;
    this.d = paramInt;
  }
  
  public static r d(char paramChar)
  {
    return e(d.e(paramChar));
  }
  
  public static r e(d paramd)
  {
    n.o(paramd);
    return new r(new a(paramd));
  }
  
  private Iterator<String> g(CharSequence paramCharSequence)
  {
    return this.c.a(this, paramCharSequence);
  }
  
  public List<String> f(CharSequence paramCharSequence)
  {
    n.o(paramCharSequence);
    Iterator localIterator = g(paramCharSequence);
    paramCharSequence = new ArrayList();
    while (localIterator.hasNext()) {
      paramCharSequence.add(localIterator.next());
    }
    return Collections.unmodifiableList(paramCharSequence);
  }
  
  static final class a
    implements r.c
  {
    a(d paramd) {}
    
    public r.b b(r paramr, CharSequence paramCharSequence)
    {
      return new a(paramr, paramCharSequence);
    }
    
    class a
      extends r.b
    {
      a(r paramr, CharSequence paramCharSequence)
      {
        super(paramCharSequence);
      }
      
      int e(int paramInt)
      {
        return paramInt + 1;
      }
      
      int f(int paramInt)
      {
        return r.a.this.a.d(this.f, paramInt);
      }
    }
  }
  
  private static abstract class b
    extends b<String>
  {
    final CharSequence f;
    final d q;
    final boolean x;
    int y = 0;
    int z;
    
    protected b(r paramr, CharSequence paramCharSequence)
    {
      this.q = r.a(paramr);
      this.x = r.b(paramr);
      this.z = r.c(paramr);
      this.f = paramCharSequence;
    }
    
    protected String d()
    {
      int i = this.y;
      int m;
      for (;;)
      {
        j = this.y;
        if (j == -1) {
          break label278;
        }
        j = f(j);
        if (j == -1)
        {
          j = this.f.length();
          this.y = -1;
        }
        else
        {
          this.y = e(j);
        }
        int k = this.y;
        m = i;
        if (k == i)
        {
          j = k + 1;
          this.y = j;
          if (j > this.f.length()) {
            this.y = -1;
          }
        }
        else
        {
          for (;;)
          {
            i = j;
            if (m >= j) {
              break;
            }
            i = j;
            if (!this.q.f(this.f.charAt(m))) {
              break;
            }
            m++;
          }
          while ((i > m) && (this.q.f(this.f.charAt(i - 1)))) {
            i--;
          }
          if ((!this.x) || (m != i)) {
            break;
          }
          i = this.y;
        }
      }
      int j = this.z;
      if (j == 1)
      {
        i = this.f.length();
        this.y = -1;
        for (;;)
        {
          j = i;
          if (i <= m) {
            break;
          }
          j = i;
          if (!this.q.f(this.f.charAt(i - 1))) {
            break;
          }
          i--;
        }
      }
      this.z = (j - 1);
      j = i;
      return this.f.subSequence(m, j).toString();
      label278:
      return (String)b();
    }
    
    abstract int e(int paramInt);
    
    abstract int f(int paramInt);
  }
  
  private static abstract interface c
  {
    public abstract Iterator<String> a(r paramr, CharSequence paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */