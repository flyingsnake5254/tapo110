package com.google.android.exoplayer2.text.o;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

public final class a
  extends d
{
  private final d0 o = new d0();
  private final d0 p = new d0();
  private final a q = new a();
  @Nullable
  private Inflater r;
  
  public a()
  {
    super("PgsDecoder");
  }
  
  private void B(d0 paramd0)
  {
    if ((paramd0.a() > 0) && (paramd0.h() == 120))
    {
      if (this.r == null) {
        this.r = new Inflater();
      }
      if (o0.i0(paramd0, this.p, this.r)) {
        paramd0.N(this.p.d(), this.p.f());
      }
    }
  }
  
  @Nullable
  private static c C(d0 paramd0, a parama)
  {
    int i = paramd0.f();
    int j = paramd0.D();
    int k = paramd0.J();
    int m = paramd0.e() + k;
    c localc = null;
    if (m > i)
    {
      paramd0.P(i);
      return null;
    }
    if (j != 128)
    {
      switch (j)
      {
      default: 
        parama = localc;
        break;
      case 22: 
        a.c(parama, paramd0, k);
        parama = localc;
        break;
      case 21: 
        a.b(parama, paramd0, k);
        parama = localc;
        break;
      case 20: 
        a.a(parama, paramd0, k);
        parama = localc;
        break;
      }
    }
    else
    {
      localc = parama.d();
      parama.h();
      parama = localc;
    }
    paramd0.P(m);
    return parama;
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws SubtitleDecoderException
  {
    this.o.N(paramArrayOfByte, paramInt);
    B(this.o);
    this.q.h();
    ArrayList localArrayList = new ArrayList();
    while (this.o.a() >= 3)
    {
      paramArrayOfByte = C(this.o, this.q);
      if (paramArrayOfByte != null) {
        localArrayList.add(paramArrayOfByte);
      }
    }
    return new b(Collections.unmodifiableList(localArrayList));
  }
  
  private static final class a
  {
    private final d0 a = new d0();
    private final int[] b = new int['Ā'];
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    
    private void e(d0 paramd0, int paramInt)
    {
      if (paramInt < 4) {
        return;
      }
      paramd0.Q(3);
      if ((paramd0.D() & 0x80) != 0) {
        j = 1;
      } else {
        j = 0;
      }
      int k = paramInt - 4;
      paramInt = k;
      if (j != 0)
      {
        if (k < 7) {
          return;
        }
        paramInt = paramd0.G();
        if (paramInt < 4) {
          return;
        }
        this.h = paramd0.J();
        this.i = paramd0.J();
        this.a.L(paramInt - 4);
        paramInt = k - 7;
      }
      int j = this.a.e();
      k = this.a.f();
      if ((j < k) && (paramInt > 0))
      {
        paramInt = Math.min(paramInt, k - j);
        paramd0.j(this.a.d(), j, paramInt);
        this.a.P(j + paramInt);
      }
    }
    
    private void f(d0 paramd0, int paramInt)
    {
      if (paramInt < 19) {
        return;
      }
      this.d = paramd0.J();
      this.e = paramd0.J();
      paramd0.Q(11);
      this.f = paramd0.J();
      this.g = paramd0.J();
    }
    
    private void g(d0 paramd0, int paramInt)
    {
      if (paramInt % 5 != 2) {
        return;
      }
      paramd0.Q(2);
      Arrays.fill(this.b, 0);
      int j = paramInt / 5;
      for (paramInt = 0; paramInt < j; paramInt++)
      {
        int k = paramd0.D();
        int m = paramd0.D();
        int n = paramd0.D();
        int i1 = paramd0.D();
        int i2 = paramd0.D();
        double d1 = m;
        double d2 = n - 128;
        m = (int)(1.402D * d2 + d1);
        double d3 = i1 - 128;
        n = (int)(d1 - 0.34414D * d3 - d2 * 0.71414D);
        i1 = (int)(d1 + d3 * 1.772D);
        int[] arrayOfInt = this.b;
        m = o0.p(m, 0, 255);
        n = o0.p(n, 0, 255);
        arrayOfInt[k] = (o0.p(i1, 0, 255) | n << 8 | i2 << 24 | m << 16);
      }
      this.c = true;
    }
    
    @Nullable
    public c d()
    {
      if ((this.d != 0) && (this.e != 0) && (this.h != 0) && (this.i != 0) && (this.a.f() != 0) && (this.a.e() == this.a.f()) && (this.c))
      {
        this.a.P(0);
        int j = this.h * this.i;
        Object localObject = new int[j];
        int k = 0;
        if (k < j)
        {
          int m = this.a.D();
          int n;
          if (m != 0)
          {
            n = k + 1;
            localObject[k] = this.b[m];
          }
          for (k = n;; k = n)
          {
            break;
            m = this.a.D();
            if (m == 0) {
              break;
            }
            if ((m & 0x40) == 0) {
              n = m & 0x3F;
            } else {
              n = (m & 0x3F) << 8 | this.a.D();
            }
            if ((m & 0x80) == 0) {
              m = 0;
            } else {
              m = this.b[this.a.D()];
            }
            n += k;
            Arrays.fill((int[])localObject, k, n, m);
          }
        }
        localObject = Bitmap.createBitmap((int[])localObject, this.h, this.i, Bitmap.Config.ARGB_8888);
        return new c.b().f((Bitmap)localObject).k(this.f / this.d).l(0).h(this.g / this.e, 0).i(0).n(this.h / this.d).g(this.i / this.e).a();
      }
      return null;
    }
    
    public void h()
    {
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 0;
      this.i = 0;
      this.a.L(0);
      this.c = false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\o\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */