package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class y1
  extends q0
{
  private final int f;
  private final int g;
  private final int[] h;
  private final int[] i;
  private final j2[] j;
  private final Object[] k;
  private final HashMap<Object, Integer> l;
  
  public y1(Collection<? extends q1> paramCollection, p0 paramp0)
  {
    super(false, paramp0);
    int n = paramCollection.size();
    this.h = new int[n];
    this.i = new int[n];
    this.j = new j2[n];
    this.k = new Object[n];
    this.l = new HashMap();
    paramp0 = paramCollection.iterator();
    n = 0;
    for (int i1 = 0; paramp0.hasNext(); i1++)
    {
      paramCollection = (q1)paramp0.next();
      this.j[i1] = paramCollection.a();
      this.i[i1] = m;
      this.h[i1] = n;
      m += this.j[i1].p();
      n += this.j[i1].i();
      this.k[i1] = paramCollection.getUid();
      this.l.put(this.k[i1], Integer.valueOf(i1));
    }
    this.f = m;
    this.g = n;
  }
  
  protected int A(int paramInt)
  {
    return this.i[paramInt];
  }
  
  protected j2 D(int paramInt)
  {
    return this.j[paramInt];
  }
  
  List<j2> E()
  {
    return Arrays.asList(this.j);
  }
  
  public int i()
  {
    return this.g;
  }
  
  public int p()
  {
    return this.f;
  }
  
  protected int s(Object paramObject)
  {
    paramObject = (Integer)this.l.get(paramObject);
    int m;
    if (paramObject == null) {
      m = -1;
    } else {
      m = ((Integer)paramObject).intValue();
    }
    return m;
  }
  
  protected int t(int paramInt)
  {
    return o0.g(this.h, paramInt + 1, false, false);
  }
  
  protected int u(int paramInt)
  {
    return o0.g(this.i, paramInt + 1, false, false);
  }
  
  protected Object x(int paramInt)
  {
    return this.k[paramInt];
  }
  
  protected int z(int paramInt)
  {
    return this.h[paramInt];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\y1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */