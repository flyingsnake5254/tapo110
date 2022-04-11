package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.z;
import java.util.Arrays;
import java.util.Collections;

public final class q
  implements o
{
  private static final float[] a = { 1.0F, 1.0F, 1.0909091F, 0.90909094F, 1.4545455F, 1.2121212F, 1.0F };
  @Nullable
  private final k0 b;
  @Nullable
  private final d0 c;
  private final boolean[] d;
  private final a e;
  @Nullable
  private final w f;
  private b g;
  private long h;
  private String i;
  private b0 j;
  private boolean k;
  private long l;
  
  q(@Nullable k0 paramk0)
  {
    this.b = paramk0;
    this.d = new boolean[4];
    this.e = new a(128);
    if (paramk0 != null)
    {
      this.f = new w(178, 128);
      this.c = new d0();
    }
    else
    {
      this.f = null;
      this.c = null;
    }
  }
  
  private static Format a(a parama, int paramInt, String paramString)
  {
    byte[] arrayOfByte = Arrays.copyOf(parama.f, parama.d);
    parama = new c0(arrayOfByte);
    parama.s(paramInt);
    parama.s(4);
    parama.q();
    parama.r(8);
    if (parama.g())
    {
      parama.r(4);
      parama.r(3);
    }
    paramInt = parama.h(4);
    float f1 = 1.0F;
    if (paramInt == 15)
    {
      paramInt = parama.h(8);
      m = parama.h(8);
      if (m == 0) {
        u.h("H263Reader", "Invalid aspect ratio");
      } else {
        f1 = paramInt / m;
      }
    }
    else
    {
      float[] arrayOfFloat = a;
      if (paramInt < arrayOfFloat.length) {
        f1 = arrayOfFloat[paramInt];
      } else {
        u.h("H263Reader", "Invalid aspect ratio");
      }
    }
    if (parama.g())
    {
      parama.r(2);
      parama.r(1);
      if (parama.g())
      {
        parama.r(15);
        parama.q();
        parama.r(15);
        parama.q();
        parama.r(15);
        parama.q();
        parama.r(3);
        parama.r(11);
        parama.q();
        parama.r(15);
        parama.q();
      }
    }
    if (parama.h(2) != 0) {
      u.h("H263Reader", "Unhandled video object layer shape");
    }
    parama.q();
    paramInt = parama.h(16);
    parama.q();
    if (parama.g()) {
      if (paramInt == 0)
      {
        u.h("H263Reader", "Invalid vop_increment_time_resolution");
      }
      else
      {
        paramInt--;
        m = 0;
        while (paramInt > 0)
        {
          m++;
          paramInt >>= 1;
        }
        parama.r(m);
      }
    }
    parama.q();
    paramInt = parama.h(13);
    parama.q();
    int m = parama.h(13);
    parama.q();
    parama.q();
    return new Format.b().S(paramString).e0("video/mp4v-es").j0(paramInt).Q(m).a0(f1).T(Collections.singletonList(arrayOfByte)).E();
  }
  
  public void b(d0 paramd0)
  {
    g.i(this.g);
    g.i(this.j);
    int m = paramd0.e();
    int n = paramd0.f();
    byte[] arrayOfByte = paramd0.d();
    this.h += paramd0.a();
    this.j.c(paramd0, paramd0.a());
    for (;;)
    {
      int i1 = z.c(arrayOfByte, m, n, this.d);
      if (i1 == n)
      {
        if (!this.k) {
          this.e.a(arrayOfByte, m, n);
        }
        this.g.a(arrayOfByte, m, n);
        paramd0 = this.f;
        if (paramd0 != null) {
          paramd0.a(arrayOfByte, m, n);
        }
        return;
      }
      Object localObject = paramd0.d();
      int i2 = i1 + 3;
      int i3 = localObject[i2] & 0xFF;
      int i4 = i1 - m;
      boolean bool = this.k;
      int i5 = 0;
      if (!bool)
      {
        if (i4 > 0) {
          this.e.a(arrayOfByte, m, i1);
        }
        int i6;
        if (i4 < 0) {
          i6 = -i4;
        } else {
          i6 = 0;
        }
        if (this.e.b(i3, i6))
        {
          b0 localb0 = this.j;
          localObject = this.e;
          localb0.d(a((a)localObject, ((a)localObject).e, (String)g.e(this.i)));
          this.k = true;
        }
      }
      this.g.a(arrayOfByte, m, i1);
      localObject = this.f;
      if (localObject != null)
      {
        if (i4 > 0)
        {
          ((w)localObject).a(arrayOfByte, m, i1);
          m = i5;
        }
        else
        {
          m = -i4;
        }
        if (this.f.b(m))
        {
          localObject = this.f;
          m = z.k(((w)localObject).d, ((w)localObject).e);
          ((d0)o0.i(this.c)).N(this.f.d, m);
          ((k0)o0.i(this.b)).a(this.l, this.c);
        }
        if ((i3 == 178) && (paramd0.d()[(i1 + 2)] == 1)) {
          this.f.e(i3);
        }
      }
      m = n - i1;
      long l1 = this.h;
      long l2 = m;
      this.g.b(l1 - l2, m, this.k);
      this.g.c(i3, this.l);
      m = i2;
    }
  }
  
  public void c()
  {
    z.a(this.d);
    this.e.c();
    Object localObject = this.g;
    if (localObject != null) {
      ((b)localObject).d();
    }
    localObject = this.f;
    if (localObject != null) {
      ((w)localObject).d();
    }
    this.h = 0L;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.i = paramd.b();
    Object localObject = paraml.t(paramd.c(), 2);
    this.j = ((b0)localObject);
    this.g = new b((b0)localObject);
    localObject = this.b;
    if (localObject != null) {
      ((k0)localObject).b(paraml, paramd);
    }
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.l = paramLong;
  }
  
  private static final class a
  {
    private static final byte[] a = { 0, 0, 1 };
    private boolean b;
    private int c;
    public int d;
    public int e;
    public byte[] f;
    
    public a(int paramInt)
    {
      this.f = new byte[paramInt];
    }
    
    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.b) {
        return;
      }
      paramInt2 -= paramInt1;
      byte[] arrayOfByte = this.f;
      int i = arrayOfByte.length;
      int j = this.d;
      if (i < j + paramInt2) {
        this.f = Arrays.copyOf(arrayOfByte, (j + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.f, this.d, paramInt2);
      this.d += paramInt2;
    }
    
    public boolean b(int paramInt1, int paramInt2)
    {
      int i = this.c;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4)
              {
                if ((paramInt1 == 179) || (paramInt1 == 181))
                {
                  this.d -= paramInt2;
                  this.b = false;
                  return true;
                }
              }
              else {
                throw new IllegalStateException();
              }
            }
            else if ((paramInt1 & 0xF0) != 32)
            {
              u.h("H263Reader", "Unexpected start code value");
              c();
            }
            else
            {
              this.e = this.d;
              this.c = 4;
            }
          }
          else if (paramInt1 > 31)
          {
            u.h("H263Reader", "Unexpected start code value");
            c();
          }
          else
          {
            this.c = 3;
          }
        }
        else if (paramInt1 != 181)
        {
          u.h("H263Reader", "Unexpected start code value");
          c();
        }
        else
        {
          this.c = 2;
        }
      }
      else if (paramInt1 == 176)
      {
        this.c = 1;
        this.b = true;
      }
      byte[] arrayOfByte = a;
      a(arrayOfByte, 0, arrayOfByte.length);
      return false;
    }
    
    public void c()
    {
      this.b = false;
      this.d = 0;
      this.c = 0;
    }
  }
  
  private static final class b
  {
    private final b0 a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private long g;
    private long h;
    
    public b(b0 paramb0)
    {
      this.a = paramb0;
    }
    
    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.c)
      {
        int i = this.f;
        int j = paramInt1 + 1 - i;
        if (j < paramInt2)
        {
          boolean bool;
          if ((paramArrayOfByte[j] & 0xC0) >> 6 == 0) {
            bool = true;
          } else {
            bool = false;
          }
          this.d = bool;
          this.c = false;
        }
        else
        {
          this.f = (i + (paramInt2 - paramInt1));
        }
      }
    }
    
    public void b(long paramLong, int paramInt, boolean paramBoolean)
    {
      if ((this.e == 182) && (paramBoolean) && (this.b))
      {
        int i = (int)(paramLong - this.g);
        int j = this.d;
        this.a.e(this.h, j, i, paramInt, null);
      }
      if (this.e != 179) {
        this.g = paramLong;
      }
    }
    
    public void c(int paramInt, long paramLong)
    {
      this.e = paramInt;
      this.d = false;
      boolean bool1 = true;
      boolean bool2;
      if ((paramInt != 182) && (paramInt != 179)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      this.b = bool2;
      if (paramInt == 182) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      this.c = bool2;
      this.f = 0;
      this.h = paramLong;
    }
    
    public void d()
    {
      this.b = false;
      this.c = false;
      this.d = false;
      this.e = -1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */