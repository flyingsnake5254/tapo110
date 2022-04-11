package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class l
  implements i0.c
{
  private final int a;
  private final List<Format> b;
  
  public l(int paramInt)
  {
    this(paramInt, ImmutableList.of());
  }
  
  public l(int paramInt, List<Format> paramList)
  {
    this.a = paramInt;
    this.b = paramList;
  }
  
  private e0 c(i0.b paramb)
  {
    return new e0(e(paramb));
  }
  
  private k0 d(i0.b paramb)
  {
    return new k0(e(paramb));
  }
  
  private List<Format> e(i0.b paramb)
  {
    if (f(32)) {
      return this.b;
    }
    com.google.android.exoplayer2.util.d0 locald0 = new com.google.android.exoplayer2.util.d0(paramb.d);
    paramb = this.b;
    while (locald0.a() > 0)
    {
      int i = locald0.D();
      int j = locald0.D();
      int k = locald0.e();
      if (i == 134)
      {
        ArrayList localArrayList = new ArrayList();
        int m = locald0.D();
        for (i = 0;; i++)
        {
          paramb = localArrayList;
          if (i >= (m & 0x1F)) {
            break;
          }
          String str = locald0.A(3);
          int n = locald0.D();
          boolean bool = true;
          int i1;
          if ((n & 0x80) != 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0)
          {
            n &= 0x3F;
            paramb = "application/cea-708";
          }
          else
          {
            paramb = "application/cea-608";
            n = 1;
          }
          int i2 = (byte)locald0.D();
          locald0.Q(1);
          List localList = null;
          if (i1 != 0)
          {
            if ((i2 & 0x40) == 0) {
              bool = false;
            }
            localList = com.google.android.exoplayer2.util.i.b(bool);
          }
          localArrayList.add(new Format.b().e0(paramb).V(str).F(n).T(localList).E());
        }
      }
      locald0.P(k + j);
    }
    return paramb;
  }
  
  private boolean f(int paramInt)
  {
    boolean bool;
    if ((paramInt & this.a) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public SparseArray<i0> a()
  {
    return new SparseArray();
  }
  
  @Nullable
  public i0 b(int paramInt, i0.b paramb)
  {
    if (paramInt != 2)
    {
      if ((paramInt != 3) && (paramInt != 4))
      {
        if (paramInt != 21)
        {
          Object localObject1 = null;
          Object localObject2 = null;
          Object localObject3 = null;
          Object localObject4 = null;
          if (paramInt != 27)
          {
            if (paramInt != 36)
            {
              if (paramInt != 89)
              {
                if (paramInt != 138) {
                  if (paramInt != 172)
                  {
                    if (paramInt != 257)
                    {
                      if (paramInt != 129) {
                        if (paramInt != 130)
                        {
                          if (paramInt != 134)
                          {
                            if (paramInt != 135)
                            {
                              switch (paramInt)
                              {
                              default: 
                                return null;
                              case 17: 
                                if (f(2)) {
                                  paramb = (i0.b)localObject4;
                                } else {
                                  paramb = new y(new u(paramb.b));
                                }
                                return paramb;
                              case 16: 
                                return new y(new q(d(paramb)));
                              }
                              if (f(2)) {
                                paramb = (i0.b)localObject1;
                              } else {
                                paramb = new y(new k(false, paramb.b));
                              }
                              return paramb;
                            }
                          }
                          else
                          {
                            if (f(16)) {
                              paramb = (i0.b)localObject2;
                            } else {
                              paramb = new d0(new x("application/x-scte35"));
                            }
                            return paramb;
                          }
                        }
                        else
                        {
                          if (f(64)) {
                            break label320;
                          }
                          return null;
                        }
                      }
                      return new y(new g(paramb.b));
                    }
                    else
                    {
                      return new d0(new x("application/vnd.dvb.ait"));
                    }
                  }
                  else {
                    return new y(new i(paramb.b));
                  }
                }
                label320:
                return new y(new m(paramb.b));
              }
              return new y(new n(paramb.c));
            }
            return new y(new s(c(paramb)));
          }
          if (f(4)) {
            paramb = (i0.b)localObject3;
          } else {
            paramb = new y(new r(c(paramb), f(1), f(8)));
          }
          return paramb;
        }
        return new y(new t());
      }
      return new y(new v(paramb.b));
    }
    return new y(new p(d(paramb)));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */