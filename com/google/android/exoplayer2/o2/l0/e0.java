package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.d;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.util.List;

public final class e0
{
  private final List<Format> a;
  private final b0[] b;
  
  public e0(List<Format> paramList)
  {
    this.a = paramList;
    this.b = new b0[paramList.size()];
  }
  
  public void a(long paramLong, d0 paramd0)
  {
    d.a(paramLong, paramd0, this.b);
  }
  
  public void b(l paraml, i0.d paramd)
  {
    for (int i = 0; i < this.b.length; i++)
    {
      paramd.a();
      b0 localb0 = paraml.t(paramd.c(), 3);
      Format localFormat = (Format)this.a.get(i);
      String str1 = localFormat.H3;
      boolean bool;
      if ((!"application/cea-608".equals(str1)) && (!"application/cea-708".equals(str1))) {
        bool = false;
      } else {
        bool = true;
      }
      String str2 = String.valueOf(str1);
      if (str2.length() != 0) {
        str2 = "Invalid closed caption mime type provided: ".concat(str2);
      } else {
        str2 = new String("Invalid closed caption mime type provided: ");
      }
      g.b(bool, str2);
      str2 = localFormat.c;
      if (str2 == null) {
        str2 = paramd.b();
      }
      localb0.d(new Format.b().S(str2).e0(str1).g0(localFormat.q).V(localFormat.f).F(localFormat.Z3).T(localFormat.J3).E());
      this.b[i] = localb0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */