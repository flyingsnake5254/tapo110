package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import java.util.Collections;
import java.util.List;

public final class n
  implements o
{
  private final List<i0.a> a;
  private final b0[] b;
  private boolean c;
  private int d;
  private int e;
  private long f;
  
  public n(List<i0.a> paramList)
  {
    this.a = paramList;
    this.b = new b0[paramList.size()];
  }
  
  private boolean a(d0 paramd0, int paramInt)
  {
    if (paramd0.a() == 0) {
      return false;
    }
    if (paramd0.D() != paramInt) {
      this.c = false;
    }
    this.d -= 1;
    return this.c;
  }
  
  public void b(d0 paramd0)
  {
    if (this.c)
    {
      if ((this.d == 2) && (!a(paramd0, 32))) {
        return;
      }
      int i = this.d;
      int j = 0;
      if ((i == 1) && (!a(paramd0, 0))) {
        return;
      }
      int k = paramd0.e();
      i = paramd0.a();
      b0[] arrayOfb0 = this.b;
      int m = arrayOfb0.length;
      while (j < m)
      {
        b0 localb0 = arrayOfb0[j];
        paramd0.P(k);
        localb0.c(paramd0, i);
        j++;
      }
      this.e += i;
    }
  }
  
  public void c()
  {
    this.c = false;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    for (int i = 0; i < this.b.length; i++)
    {
      i0.a locala = (i0.a)this.a.get(i);
      paramd.a();
      b0 localb0 = paraml.t(paramd.c(), 3);
      localb0.d(new Format.b().S(paramd.b()).e0("application/dvbsubs").T(Collections.singletonList(locala.c)).V(locala.a).E());
      this.b[i] = localb0;
    }
  }
  
  public void e()
  {
    if (this.c)
    {
      b0[] arrayOfb0 = this.b;
      int i = arrayOfb0.length;
      for (int j = 0; j < i; j++) {
        arrayOfb0[j].e(this.f, 1, this.e, 0, null);
      }
      this.c = false;
    }
  }
  
  public void f(long paramLong, int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      return;
    }
    this.c = true;
    this.f = paramLong;
    this.e = 0;
    this.d = 2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */