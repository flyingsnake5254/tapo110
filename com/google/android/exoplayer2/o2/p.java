package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

public final class p
{
  private static boolean a(d0 paramd0, s params, int paramInt)
  {
    paramInt = j(paramd0, paramInt);
    boolean bool;
    if ((paramInt != -1) && (paramInt <= params.b)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean b(d0 paramd0, int paramInt)
  {
    int i = paramd0.D();
    int j = paramd0.e();
    paramd0 = paramd0.d();
    boolean bool = true;
    if (i != o0.t(paramd0, paramInt, j - 1, 0)) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean c(d0 paramd0, s params, boolean paramBoolean, a parama)
  {
    try
    {
      long l = paramd0.K();
      if (!paramBoolean) {
        l *= params.b;
      }
      parama.a = l;
      return true;
    }
    catch (NumberFormatException paramd0) {}
    return false;
  }
  
  public static boolean d(d0 paramd0, s params, int paramInt, a parama)
  {
    int i = paramd0.e();
    long l1 = paramd0.F();
    long l2 = l1 >>> 16;
    long l3 = paramInt;
    boolean bool1 = false;
    if (l2 != l3) {
      return false;
    }
    boolean bool2;
    if ((l2 & 1L) == 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int j = (int)(l1 >> 12 & 0xF);
    int k = (int)(l1 >> 8 & 0xF);
    int m = (int)(0xF & l1 >> 4);
    int n = (int)(l1 >> 1 & 0x7);
    if ((l1 & 1L) == 1L) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    boolean bool3 = bool1;
    if (g(m, params))
    {
      bool3 = bool1;
      if (f(n, params))
      {
        bool3 = bool1;
        if (paramInt == 0)
        {
          bool3 = bool1;
          if (c(paramd0, params, bool2, parama))
          {
            bool3 = bool1;
            if (a(paramd0, params, j))
            {
              bool3 = bool1;
              if (e(paramd0, params, k))
              {
                bool3 = bool1;
                if (b(paramd0, i)) {
                  bool3 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool3;
  }
  
  private static boolean e(d0 paramd0, s params, int paramInt)
  {
    int i = params.e;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramInt == 0) {
      return true;
    }
    if (paramInt <= 11)
    {
      if (paramInt != params.f) {
        bool3 = false;
      }
      return bool3;
    }
    if (paramInt == 12)
    {
      if (paramd0.D() * 1000 == i) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    if (paramInt <= 14)
    {
      int j = paramd0.J();
      int k = j;
      if (paramInt == 14) {
        k = j * 10;
      }
      if (k == i) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    return false;
  }
  
  private static boolean f(int paramInt, s params)
  {
    boolean bool = true;
    if (paramInt == 0) {
      return true;
    }
    if (paramInt != params.i) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean g(int paramInt, s params)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramInt <= 7)
    {
      if (paramInt == params.g - 1) {
        bool2 = true;
      }
      return bool2;
    }
    bool2 = bool1;
    if (paramInt <= 10)
    {
      bool2 = bool1;
      if (params.g == 2) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static boolean h(k paramk, s params, int paramInt, a parama)
    throws IOException
  {
    long l = paramk.g();
    byte[] arrayOfByte = new byte[2];
    paramk.n(arrayOfByte, 0, 2);
    if (((arrayOfByte[0] & 0xFF) << 8 | arrayOfByte[1] & 0xFF) != paramInt)
    {
      paramk.e();
      paramk.h((int)(l - paramk.getPosition()));
      return false;
    }
    d0 locald0 = new d0(16);
    System.arraycopy(arrayOfByte, 0, locald0.d(), 0, 2);
    locald0.O(m.c(paramk, locald0.d(), 2, 14));
    paramk.e();
    paramk.h((int)(l - paramk.getPosition()));
    return d(locald0, params, paramInt, parama);
  }
  
  public static long i(k paramk, s params)
    throws IOException
  {
    paramk.e();
    boolean bool = true;
    paramk.h(1);
    Object localObject = new byte[1];
    paramk.n((byte[])localObject, 0, 1);
    if ((localObject[0] & 0x1) != 1) {
      bool = false;
    }
    paramk.h(2);
    int i;
    if (bool) {
      i = 7;
    } else {
      i = 6;
    }
    localObject = new d0(i);
    ((d0)localObject).O(m.c(paramk, ((d0)localObject).d(), 0, i));
    paramk.e();
    paramk = new a();
    if (c((d0)localObject, params, bool, paramk)) {
      return paramk.a;
    }
    throw ParserException.createForMalformedContainer(null, null);
  }
  
  public static int j(d0 paramd0, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      return 256 << paramInt - 8;
    case 7: 
      return paramd0.J() + 1;
    case 6: 
      return paramd0.D() + 1;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      return 576 << paramInt - 2;
    }
    return 192;
  }
  
  public static final class a
  {
    public long a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */