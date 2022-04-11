package com.google.android.exoplayer2.text.n;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final byte[] a = { 0, 7, 8, 15 };
  private static final byte[] b = { 0, 119, -120, -1 };
  private static final byte[] c = { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
  private final Paint d;
  private final Paint e;
  private final Canvas f;
  private final b g;
  private final a h;
  private final h i;
  private Bitmap j;
  
  public b(int paramInt1, int paramInt2)
  {
    Paint localPaint = new Paint();
    this.d = localPaint;
    localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    localPaint.setPathEffect(null);
    localPaint = new Paint();
    this.e = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    localPaint.setPathEffect(null);
    this.f = new Canvas();
    this.g = new b(719, 575, 0, 719, 0, 575);
    this.h = new a(0, c(), d(), e());
    this.i = new h(paramInt1, paramInt2);
  }
  
  private static byte[] a(int paramInt1, int paramInt2, c0 paramc0)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    for (int k = 0; k < paramInt1; k++) {
      arrayOfByte[k] = ((byte)(byte)paramc0.h(paramInt2));
    }
    return arrayOfByte;
  }
  
  private static int[] c()
  {
    return new int[] { 0, -1, -16777216, -8421505 };
  }
  
  private static int[] d()
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 0;
    for (int k = 1; k < 16; k++)
    {
      int m;
      int n;
      int i1;
      if (k < 8)
      {
        if ((k & 0x1) != 0) {
          m = 255;
        } else {
          m = 0;
        }
        if ((k & 0x2) != 0) {
          n = 255;
        } else {
          n = 0;
        }
        if ((k & 0x4) != 0) {
          i1 = 255;
        } else {
          i1 = 0;
        }
        arrayOfInt[k] = f(255, m, n, i1);
      }
      else
      {
        i1 = 127;
        if ((k & 0x1) != 0) {
          m = 127;
        } else {
          m = 0;
        }
        if ((k & 0x2) != 0) {
          n = 127;
        } else {
          n = 0;
        }
        if ((k & 0x4) == 0) {
          i1 = 0;
        }
        arrayOfInt[k] = f(255, m, n, i1);
      }
    }
    return arrayOfInt;
  }
  
  private static int[] e()
  {
    int[] arrayOfInt = new int['Ā'];
    arrayOfInt[0] = 0;
    for (int k = 0; k < 256; k++)
    {
      int m = 255;
      int n;
      int i1;
      if (k < 8)
      {
        if ((k & 0x1) != 0) {
          n = 255;
        } else {
          n = 0;
        }
        if ((k & 0x2) != 0) {
          i1 = 255;
        } else {
          i1 = 0;
        }
        if ((k & 0x4) == 0) {
          m = 0;
        }
        arrayOfInt[k] = f(63, n, i1, m);
      }
      else
      {
        m = k & 0x88;
        i1 = 170;
        n = 85;
        int i2;
        int i3;
        int i4;
        if (m != 0)
        {
          if (m != 8)
          {
            i1 = 43;
            if (m != 128)
            {
              if (m == 136)
              {
                if ((k & 0x1) != 0) {
                  m = 43;
                } else {
                  m = 0;
                }
                if ((k & 0x10) != 0) {
                  i2 = 85;
                } else {
                  i2 = 0;
                }
                if ((k & 0x2) != 0) {
                  i3 = 43;
                } else {
                  i3 = 0;
                }
                if ((k & 0x20) != 0) {
                  i4 = 85;
                } else {
                  i4 = 0;
                }
                if ((k & 0x4) == 0) {
                  i1 = 0;
                }
                if ((k & 0x40) == 0) {
                  n = 0;
                }
                arrayOfInt[k] = f(255, m + i2, i3 + i4, i1 + n);
              }
            }
            else
            {
              if ((k & 0x1) != 0) {
                m = 43;
              } else {
                m = 0;
              }
              if ((k & 0x10) != 0) {
                i2 = 85;
              } else {
                i2 = 0;
              }
              if ((k & 0x2) != 0) {
                i3 = 43;
              } else {
                i3 = 0;
              }
              if ((k & 0x20) != 0) {
                i4 = 85;
              } else {
                i4 = 0;
              }
              if ((k & 0x4) == 0) {
                i1 = 0;
              }
              if ((k & 0x40) == 0) {
                n = 0;
              }
              arrayOfInt[k] = f(255, m + 127 + i2, i3 + 127 + i4, i1 + 127 + n);
            }
          }
          else
          {
            if ((k & 0x1) != 0) {
              m = 85;
            } else {
              m = 0;
            }
            if ((k & 0x10) != 0) {
              i2 = 170;
            } else {
              i2 = 0;
            }
            if ((k & 0x2) != 0) {
              i3 = 85;
            } else {
              i3 = 0;
            }
            if ((k & 0x20) != 0) {
              i4 = 170;
            } else {
              i4 = 0;
            }
            if ((k & 0x4) == 0) {
              n = 0;
            }
            if ((k & 0x40) == 0) {
              i1 = 0;
            }
            arrayOfInt[k] = f(127, m + i2, i3 + i4, n + i1);
          }
        }
        else
        {
          if ((k & 0x1) != 0) {
            m = 85;
          } else {
            m = 0;
          }
          if ((k & 0x10) != 0) {
            i2 = 170;
          } else {
            i2 = 0;
          }
          if ((k & 0x2) != 0) {
            i3 = 85;
          } else {
            i3 = 0;
          }
          if ((k & 0x20) != 0) {
            i4 = 170;
          } else {
            i4 = 0;
          }
          if ((k & 0x4) == 0) {
            n = 0;
          }
          if ((k & 0x40) == 0) {
            i1 = 0;
          }
          arrayOfInt[k] = f(255, m + i2, i3 + i4, n + i1);
        }
      }
    }
    return arrayOfInt;
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int g(c0 paramc0, int[] paramArrayOfInt, @Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2, @Nullable Paint paramPaint, Canvas paramCanvas)
  {
    int k = 0;
    int m = paramInt1;
    for (paramInt1 = k;; paramInt1 = k)
    {
      k = paramc0.h(2);
      if (k != 0) {}
      int n;
      int i1;
      for (;;)
      {
        n = paramInt1;
        i1 = 1;
        paramInt1 = k;
        k = n;
        n = i1;
        break label189;
        if (paramc0.g())
        {
          n = paramc0.h(3) + 3;
          k = paramc0.h(2);
          i1 = paramInt1;
          paramInt1 = k;
          k = i1;
          break label189;
        }
        if (!paramc0.g()) {
          break;
        }
        k = 0;
      }
      k = paramc0.h(2);
      if (k != 0) {
        if (k != 1) {
          if (k != 2) {
            if (k == 3) {}
          }
        }
      }
      for (k = paramInt1;; k = 1)
      {
        paramInt1 = 0;
        n = 0;
        break label189;
        n = paramc0.h(8) + 29;
        k = paramc0.h(2);
        break;
        n = paramc0.h(4) + 12;
        k = paramc0.h(2);
        break;
        k = paramInt1;
        paramInt1 = 0;
        n = 2;
        break label189;
      }
      label189:
      if ((n != 0) && (paramPaint != null))
      {
        i1 = paramInt1;
        if (paramArrayOfByte != null) {
          i1 = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[i1]);
        paramCanvas.drawRect(m, paramInt2, m + n, paramInt2 + 1, paramPaint);
      }
      m += n;
      if (k != 0) {
        return m;
      }
    }
  }
  
  private static int h(c0 paramc0, int[] paramArrayOfInt, @Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2, @Nullable Paint paramPaint, Canvas paramCanvas)
  {
    int k = 0;
    int m = paramInt1;
    for (paramInt1 = k;; paramInt1 = k)
    {
      k = paramc0.h(4);
      if (k != 0) {}
      int n;
      int i1;
      for (;;)
      {
        n = paramInt1;
        i1 = 1;
        paramInt1 = k;
        k = n;
        n = i1;
        break;
        if (!paramc0.g())
        {
          n = paramc0.h(3);
          if (n != 0)
          {
            k = paramInt1;
            n += 2;
            paramInt1 = 0;
            break;
          }
          k = 1;
        }
        else if (!paramc0.g())
        {
          n = paramc0.h(2) + 4;
          k = paramc0.h(4);
        }
        for (;;)
        {
          i1 = paramInt1;
          paramInt1 = k;
          k = i1;
          break label212;
          k = paramc0.h(2);
          if (k == 0) {
            break label206;
          }
          if (k == 1) {
            break;
          }
          if (k != 2)
          {
            if (k != 3)
            {
              k = paramInt1;
              paramInt1 = 0;
              n = 0;
              break label212;
            }
            n = paramc0.h(8) + 25;
            k = paramc0.h(4);
          }
          else
          {
            n = paramc0.h(4) + 9;
            k = paramc0.h(4);
          }
        }
        k = paramInt1;
        paramInt1 = 0;
        n = 2;
        break;
        label206:
        k = 0;
      }
      label212:
      if ((n != 0) && (paramPaint != null))
      {
        i1 = paramInt1;
        if (paramArrayOfByte != null) {
          i1 = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[i1]);
        paramCanvas.drawRect(m, paramInt2, m + n, paramInt2 + 1, paramPaint);
      }
      m += n;
      if (k != 0) {
        return m;
      }
    }
  }
  
  private static int i(c0 paramc0, int[] paramArrayOfInt, @Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2, @Nullable Paint paramPaint, Canvas paramCanvas)
  {
    int k = 0;
    int m = paramInt1;
    for (paramInt1 = k;; paramInt1 = k)
    {
      int n = paramc0.h(8);
      int i1;
      if (n != 0)
      {
        k = paramInt1;
        i1 = 1;
        paramInt1 = n;
      }
      else if (!paramc0.g())
      {
        i1 = paramc0.h(7);
        if (i1 != 0)
        {
          k = paramInt1;
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = 0;
          k = 1;
          i1 = 0;
        }
      }
      else
      {
        i1 = paramc0.h(7);
        n = paramc0.h(8);
        k = paramInt1;
        paramInt1 = n;
      }
      if ((i1 != 0) && (paramPaint != null))
      {
        n = paramInt1;
        if (paramArrayOfByte != null) {
          n = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[n]);
        paramCanvas.drawRect(m, paramInt2, m + i1, paramInt2 + 1, paramPaint);
      }
      m += i1;
      if (k != 0) {
        return m;
      }
    }
  }
  
  private static void j(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, @Nullable Paint paramPaint, Canvas paramCanvas)
  {
    c0 localc0 = new c0(paramArrayOfByte);
    int k = paramInt2;
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = arrayOfByte1;
    byte[] arrayOfByte3 = arrayOfByte2;
    int m = paramInt3;
    paramInt3 = k;
    while (localc0.b() != 0)
    {
      k = localc0.h(8);
      if (k != 240)
      {
        switch (k)
        {
        default: 
          switch (k)
          {
          default: 
            break;
          case 34: 
            arrayOfByte2 = a(16, 8, localc0);
            break;
          case 33: 
            arrayOfByte1 = a(4, 8, localc0);
            break;
          case 32: 
            arrayOfByte3 = a(4, 4, localc0);
          }
          break;
        case 18: 
          paramInt3 = i(localc0, paramArrayOfInt, null, paramInt3, m, paramPaint, paramCanvas);
          break;
        case 17: 
          if (paramInt1 == 3)
          {
            if (arrayOfByte2 == null) {
              paramArrayOfByte = c;
            } else {
              paramArrayOfByte = arrayOfByte2;
            }
          }
          else {
            paramArrayOfByte = null;
          }
          paramInt3 = h(localc0, paramArrayOfInt, paramArrayOfByte, paramInt3, m, paramPaint, paramCanvas);
          localc0.c();
          break;
        case 16: 
          if (paramInt1 == 3) {
            if (arrayOfByte1 == null) {
              paramArrayOfByte = b;
            } else {
              paramArrayOfByte = arrayOfByte1;
            }
          }
          for (;;)
          {
            break;
            if (paramInt1 == 2)
            {
              if (arrayOfByte3 == null) {
                paramArrayOfByte = a;
              } else {
                paramArrayOfByte = arrayOfByte3;
              }
            }
            else {
              paramArrayOfByte = null;
            }
          }
          paramInt3 = g(localc0, paramArrayOfInt, paramArrayOfByte, paramInt3, m, paramPaint, paramCanvas);
          localc0.c();
          break;
        }
      }
      else
      {
        m += 2;
        paramInt3 = paramInt2;
      }
    }
  }
  
  private static void k(c paramc, a parama, int paramInt1, int paramInt2, int paramInt3, @Nullable Paint paramPaint, Canvas paramCanvas)
  {
    if (paramInt1 == 3) {
      parama = parama.d;
    } else if (paramInt1 == 2) {
      parama = parama.c;
    } else {
      parama = parama.b;
    }
    j(paramc.c, parama, paramInt1, paramInt2, paramInt3, paramPaint, paramCanvas);
    j(paramc.d, parama, paramInt1, paramInt2, paramInt3 + 1, paramPaint, paramCanvas);
  }
  
  private static a l(c0 paramc0, int paramInt)
  {
    int k = paramc0.h(8);
    paramc0.r(8);
    paramInt -= 2;
    int[] arrayOfInt1 = c();
    int[] arrayOfInt2 = d();
    int[] arrayOfInt3 = e();
    while (paramInt > 0)
    {
      int m = paramc0.h(8);
      int n = paramc0.h(8);
      paramInt -= 2;
      int[] arrayOfInt4;
      if ((n & 0x80) != 0) {
        arrayOfInt4 = arrayOfInt1;
      } else if ((n & 0x40) != 0) {
        arrayOfInt4 = arrayOfInt2;
      } else {
        arrayOfInt4 = arrayOfInt3;
      }
      if ((n & 0x1) != 0)
      {
        i1 = paramc0.h(8);
        i2 = paramc0.h(8);
        i3 = paramc0.h(8);
        n = paramc0.h(8);
        paramInt -= 4;
      }
      else
      {
        i1 = paramc0.h(6);
        i2 = paramc0.h(4);
        i3 = paramc0.h(4) << 4;
        n = paramc0.h(2);
        paramInt -= 2;
        n <<= 6;
        i1 <<= 2;
        i2 <<= 4;
      }
      if (i1 == 0)
      {
        i2 = 0;
        i3 = 0;
        n = 255;
      }
      n = (byte)(255 - (n & 0xFF));
      double d1 = i1;
      double d2 = i2 - 128;
      int i2 = (int)(d1 + 1.402D * d2);
      double d3 = i3 - 128;
      int i3 = (int)(d1 - 0.34414D * d3 - d2 * 0.71414D);
      int i1 = (int)(d1 + d3 * 1.772D);
      arrayOfInt4[m] = f(n, o0.p(i2, 0, 255), o0.p(i3, 0, 255), o0.p(i1, 0, 255));
    }
    return new a(k, arrayOfInt1, arrayOfInt2, arrayOfInt3);
  }
  
  private static b m(c0 paramc0)
  {
    paramc0.r(4);
    boolean bool = paramc0.g();
    paramc0.r(3);
    int k = paramc0.h(16);
    int m = paramc0.h(16);
    int n;
    int i1;
    int i2;
    int i4;
    if (bool)
    {
      n = paramc0.h(16);
      i1 = paramc0.h(16);
      i2 = paramc0.h(16);
      int i3 = paramc0.h(16);
      i4 = i1;
      i1 = i3;
    }
    else
    {
      i4 = k;
      i1 = m;
      n = 0;
      i2 = 0;
    }
    return new b(k, m, n, i4, i2, i1);
  }
  
  private static c n(c0 paramc0)
  {
    int k = paramc0.h(16);
    paramc0.r(4);
    int m = paramc0.h(2);
    boolean bool = paramc0.g();
    paramc0.r(1);
    byte[] arrayOfByte1 = o0.f;
    byte[] arrayOfByte2;
    if (m == 1)
    {
      paramc0.r(paramc0.h(8) * 16);
      arrayOfByte2 = arrayOfByte1;
    }
    else
    {
      arrayOfByte2 = arrayOfByte1;
      if (m == 0)
      {
        m = paramc0.h(16);
        int n = paramc0.h(16);
        if (m > 0)
        {
          arrayOfByte1 = new byte[m];
          paramc0.k(arrayOfByte1, 0, m);
        }
        arrayOfByte2 = arrayOfByte1;
        if (n > 0)
        {
          arrayOfByte2 = new byte[n];
          paramc0.k(arrayOfByte2, 0, n);
          paramc0 = arrayOfByte2;
          arrayOfByte2 = arrayOfByte1;
          break label135;
        }
      }
    }
    paramc0 = arrayOfByte2;
    label135:
    return new c(k, bool, arrayOfByte2, paramc0);
  }
  
  private static d o(c0 paramc0, int paramInt)
  {
    int k = paramc0.h(8);
    int m = paramc0.h(4);
    int n = paramc0.h(2);
    paramc0.r(2);
    paramInt -= 2;
    SparseArray localSparseArray = new SparseArray();
    while (paramInt > 0)
    {
      int i1 = paramc0.h(8);
      paramc0.r(8);
      int i2 = paramc0.h(16);
      int i3 = paramc0.h(16);
      paramInt -= 6;
      localSparseArray.put(i1, new e(i2, i3));
    }
    return new d(k, m, n, localSparseArray);
  }
  
  private static f p(c0 paramc0, int paramInt)
  {
    int k = paramc0.h(8);
    paramc0.r(4);
    boolean bool = paramc0.g();
    paramc0.r(3);
    int m = paramc0.h(16);
    int n = paramc0.h(16);
    int i1 = paramc0.h(3);
    int i2 = paramc0.h(3);
    paramc0.r(2);
    int i3 = paramc0.h(8);
    int i4 = paramc0.h(8);
    int i5 = paramc0.h(4);
    int i6 = paramc0.h(2);
    paramc0.r(2);
    paramInt -= 10;
    SparseArray localSparseArray = new SparseArray();
    while (paramInt > 0)
    {
      int i7 = paramc0.h(16);
      int i8 = paramc0.h(2);
      int i9 = paramc0.h(2);
      int i10 = paramc0.h(12);
      paramc0.r(4);
      int i11 = paramc0.h(12);
      paramInt -= 6;
      int i12;
      int i13;
      if ((i8 != 1) && (i8 != 2))
      {
        i12 = 0;
        i13 = 0;
      }
      else
      {
        i12 = paramc0.h(8);
        i13 = paramc0.h(8);
        int i14 = paramInt - 2;
        paramInt = i12;
        i12 = paramInt;
        paramInt = i14;
      }
      localSparseArray.put(i7, new g(i8, i9, i10, i11, i12, i13));
    }
    return new f(k, bool, m, n, i1, i2, i3, i4, i5, i6, localSparseArray);
  }
  
  private static void q(c0 paramc0, h paramh)
  {
    int k = paramc0.h(8);
    int m = paramc0.h(16);
    int n = paramc0.h(16);
    int i1 = paramc0.d();
    if (n * 8 > paramc0.b())
    {
      u.h("DvbParser", "Data field length exceeds limit");
      paramc0.r(paramc0.b());
      return;
    }
    Object localObject1;
    Object localObject2;
    switch (k)
    {
    default: 
      break;
    case 20: 
      if (m == paramh.a) {
        paramh.h = m(paramc0);
      }
      break;
    case 19: 
      if (m == paramh.a)
      {
        localObject1 = n(paramc0);
        paramh.e.put(((c)localObject1).a, localObject1);
      }
      else if (m == paramh.b)
      {
        localObject1 = n(paramc0);
        paramh.g.put(((c)localObject1).a, localObject1);
      }
      break;
    case 18: 
      if (m == paramh.a)
      {
        localObject1 = l(paramc0, n);
        paramh.d.put(((a)localObject1).a, localObject1);
      }
      else if (m == paramh.b)
      {
        localObject1 = l(paramc0, n);
        paramh.f.put(((a)localObject1).a, localObject1);
      }
      break;
    case 17: 
      localObject2 = paramh.i;
      if ((m == paramh.a) && (localObject2 != null))
      {
        localObject1 = p(paramc0, n);
        if (((d)localObject2).c == 0)
        {
          localObject2 = (f)paramh.c.get(((f)localObject1).a);
          if (localObject2 != null) {
            ((f)localObject1).a((f)localObject2);
          }
        }
        paramh.c.put(((f)localObject1).a, localObject1);
      }
      break;
    case 16: 
      if (m == paramh.a)
      {
        localObject2 = paramh.i;
        localObject1 = o(paramc0, n);
        if (((d)localObject1).c != 0)
        {
          paramh.i = ((d)localObject1);
          paramh.c.clear();
          paramh.d.clear();
          paramh.e.clear();
        }
        else if ((localObject2 != null) && (((d)localObject2).b != ((d)localObject1).b))
        {
          paramh.i = ((d)localObject1);
        }
      }
      break;
    }
    paramc0.s(i1 + n - paramc0.d());
  }
  
  public List<c> b(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new c0(paramArrayOfByte, paramInt);
    while ((paramArrayOfByte.b() >= 48) && (paramArrayOfByte.h(8) == 15)) {
      q(paramArrayOfByte, this.i);
    }
    Object localObject1 = this.i;
    paramArrayOfByte = ((h)localObject1).i;
    if (paramArrayOfByte == null) {
      return Collections.emptyList();
    }
    localObject1 = ((h)localObject1).h;
    if (localObject1 == null) {
      localObject1 = this.g;
    }
    Object localObject2 = this.j;
    if ((localObject2 == null) || (((b)localObject1).a + 1 != ((Bitmap)localObject2).getWidth()) || (((b)localObject1).b + 1 != this.j.getHeight()))
    {
      localObject2 = Bitmap.createBitmap(((b)localObject1).a + 1, ((b)localObject1).b + 1, Bitmap.Config.ARGB_8888);
      this.j = ((Bitmap)localObject2);
      this.f.setBitmap((Bitmap)localObject2);
    }
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = paramArrayOfByte.d;
    for (int k = 0; k < localSparseArray.size(); k++)
    {
      this.f.save();
      paramArrayOfByte = (e)localSparseArray.valueAt(k);
      paramInt = localSparseArray.keyAt(k);
      f localf = (f)this.i.c.get(paramInt);
      int m = paramArrayOfByte.a + ((b)localObject1).c;
      int n = paramArrayOfByte.b + ((b)localObject1).e;
      paramInt = Math.min(localf.c + m, ((b)localObject1).d);
      int i1 = Math.min(localf.d + n, ((b)localObject1).f);
      this.f.clipRect(m, n, paramInt, i1);
      localObject2 = (a)this.i.d.get(localf.g);
      paramArrayOfByte = (byte[])localObject2;
      if (localObject2 == null)
      {
        localObject2 = (a)this.i.f.get(localf.g);
        paramArrayOfByte = (byte[])localObject2;
        if (localObject2 == null) {
          paramArrayOfByte = this.h;
        }
      }
      localObject2 = localf.k;
      for (paramInt = 0; paramInt < ((SparseArray)localObject2).size(); paramInt++)
      {
        i1 = ((SparseArray)localObject2).keyAt(paramInt);
        g localg = (g)((SparseArray)localObject2).valueAt(paramInt);
        c localc = (c)this.i.e.get(i1);
        if (localc == null) {
          localc = (c)this.i.g.get(i1);
        }
        if (localc != null)
        {
          Paint localPaint;
          if (localc.b) {
            localPaint = null;
          } else {
            localPaint = this.d;
          }
          k(localc, paramArrayOfByte, localf.f, localg.c + m, n + localg.d, localPaint, this.f);
        }
      }
      if (localf.b)
      {
        paramInt = localf.f;
        if (paramInt == 3) {
          paramInt = paramArrayOfByte.d[localf.h];
        } else if (paramInt == 2) {
          paramInt = paramArrayOfByte.c[localf.i];
        } else {
          paramInt = paramArrayOfByte.b[localf.j];
        }
        this.e.setColor(paramInt);
        this.f.drawRect(m, n, localf.c + m, localf.d + n, this.e);
      }
      localArrayList.add(new c.b().f(Bitmap.createBitmap(this.j, m, n, localf.c, localf.d)).k(m / ((b)localObject1).a).l(0).h(n / ((b)localObject1).b, 0).i(0).n(localf.c / ((b)localObject1).a).g(localf.d / ((b)localObject1).b).a());
      this.f.drawColor(0, PorterDuff.Mode.CLEAR);
      this.f.restore();
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public void r()
  {
    this.i.a();
  }
  
  private static final class a
  {
    public final int a;
    public final int[] b;
    public final int[] c;
    public final int[] d;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
    {
      this.a = paramInt;
      this.b = paramArrayOfInt1;
      this.c = paramArrayOfInt2;
      this.d = paramArrayOfInt3;
    }
  }
  
  private static final class b
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
    }
  }
  
  private static final class c
  {
    public final int a;
    public final boolean b;
    public final byte[] c;
    public final byte[] d;
    
    public c(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.a = paramInt;
      this.b = paramBoolean;
      this.c = paramArrayOfByte1;
      this.d = paramArrayOfByte2;
    }
  }
  
  private static final class d
  {
    public final int a;
    public final int b;
    public final int c;
    public final SparseArray<b.e> d;
    
    public d(int paramInt1, int paramInt2, int paramInt3, SparseArray<b.e> paramSparseArray)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramSparseArray;
    }
  }
  
  private static final class e
  {
    public final int a;
    public final int b;
    
    public e(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
  
  private static final class f
  {
    public final int a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final SparseArray<b.g> k;
    
    public f(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, SparseArray<b.g> paramSparseArray)
    {
      this.a = paramInt1;
      this.b = paramBoolean;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
      this.g = paramInt6;
      this.h = paramInt7;
      this.i = paramInt8;
      this.j = paramInt9;
      this.k = paramSparseArray;
    }
    
    public void a(f paramf)
    {
      paramf = paramf.k;
      for (int m = 0; m < paramf.size(); m++) {
        this.k.put(paramf.keyAt(m), (b.g)paramf.valueAt(m));
      }
    }
  }
  
  private static final class g
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    
    public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
    }
  }
  
  private static final class h
  {
    public final int a;
    public final int b;
    public final SparseArray<b.f> c;
    public final SparseArray<b.a> d;
    public final SparseArray<b.c> e;
    public final SparseArray<b.a> f;
    public final SparseArray<b.c> g;
    @Nullable
    public b.b h;
    @Nullable
    public b.d i;
    
    public h(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new SparseArray();
      this.d = new SparseArray();
      this.e = new SparseArray();
      this.f = new SparseArray();
      this.g = new SparseArray();
    }
    
    public void a()
    {
      this.c.clear();
      this.d.clear();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      this.h = null;
      this.i = null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\n\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */