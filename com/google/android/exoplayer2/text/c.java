package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.v0;
import com.google.common.base.k;
import org.checkerframework.dataflow.qual.Pure;

public final class c
{
  public static final c a = new b().o("").a();
  public static final v0<c> b = a.a;
  @Nullable
  public final CharSequence c;
  @Nullable
  public final Layout.Alignment d;
  @Nullable
  public final Layout.Alignment e;
  @Nullable
  public final Bitmap f;
  public final float g;
  public final int h;
  public final int i;
  public final float j;
  public final int k;
  public final float l;
  public final float m;
  public final boolean n;
  public final int o;
  public final int p;
  public final float q;
  public final int r;
  public final float s;
  
  private c(@Nullable CharSequence paramCharSequence, @Nullable Layout.Alignment paramAlignment1, @Nullable Layout.Alignment paramAlignment2, @Nullable Bitmap paramBitmap, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean, int paramInt5, int paramInt6, float paramFloat6)
  {
    if (paramCharSequence == null)
    {
      g.e(paramBitmap);
    }
    else
    {
      boolean bool;
      if (paramBitmap == null) {
        bool = true;
      } else {
        bool = false;
      }
      g.a(bool);
    }
    if ((paramCharSequence instanceof Spanned)) {
      this.c = SpannedString.valueOf(paramCharSequence);
    }
    for (;;)
    {
      break;
      if (paramCharSequence != null) {
        this.c = paramCharSequence.toString();
      } else {
        this.c = null;
      }
    }
    this.d = paramAlignment1;
    this.e = paramAlignment2;
    this.f = paramBitmap;
    this.g = paramFloat1;
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramFloat2;
    this.k = paramInt3;
    this.l = paramFloat4;
    this.m = paramFloat5;
    this.n = paramBoolean;
    this.o = paramInt5;
    this.p = paramInt4;
    this.q = paramFloat3;
    this.r = paramInt6;
    this.s = paramFloat6;
  }
  
  public b a()
  {
    return new b(this, null);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (c.class == paramObject.getClass()))
    {
      paramObject = (c)paramObject;
      if ((TextUtils.equals(this.c, ((c)paramObject).c)) && (this.d == ((c)paramObject).d) && (this.e == ((c)paramObject).e))
      {
        Bitmap localBitmap1 = this.f;
        if (localBitmap1 == null)
        {
          if (((c)paramObject).f != null) {
            break label257;
          }
        }
        else
        {
          Bitmap localBitmap2 = ((c)paramObject).f;
          if ((localBitmap2 == null) || (!localBitmap1.sameAs(localBitmap2))) {
            break label257;
          }
        }
        if ((this.g == ((c)paramObject).g) && (this.h == ((c)paramObject).h) && (this.i == ((c)paramObject).i) && (this.j == ((c)paramObject).j) && (this.k == ((c)paramObject).k) && (this.l == ((c)paramObject).l) && (this.m == ((c)paramObject).m) && (this.n == ((c)paramObject).n) && (this.o == ((c)paramObject).o) && (this.p == ((c)paramObject).p) && (this.q == ((c)paramObject).q) && (this.r == ((c)paramObject).r) && (this.s == ((c)paramObject).s)) {
          break label259;
        }
      }
      label257:
      bool = false;
      label259:
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { this.c, this.d, this.e, this.f, Float.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Float.valueOf(this.j), Integer.valueOf(this.k), Float.valueOf(this.l), Float.valueOf(this.m), Boolean.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.q), Integer.valueOf(this.r), Float.valueOf(this.s) });
  }
  
  public static final class b
  {
    @Nullable
    private CharSequence a;
    @Nullable
    private Bitmap b;
    @Nullable
    private Layout.Alignment c;
    @Nullable
    private Layout.Alignment d;
    private float e;
    private int f;
    private int g;
    private float h;
    private int i;
    private int j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    @ColorInt
    private int o;
    private int p;
    private float q;
    
    public b()
    {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = -3.4028235E38F;
      this.f = Integer.MIN_VALUE;
      this.g = Integer.MIN_VALUE;
      this.h = -3.4028235E38F;
      this.i = Integer.MIN_VALUE;
      this.j = Integer.MIN_VALUE;
      this.k = -3.4028235E38F;
      this.l = -3.4028235E38F;
      this.m = -3.4028235E38F;
      this.n = false;
      this.o = -16777216;
      this.p = Integer.MIN_VALUE;
    }
    
    private b(c paramc)
    {
      this.a = paramc.c;
      this.b = paramc.f;
      this.c = paramc.d;
      this.d = paramc.e;
      this.e = paramc.g;
      this.f = paramc.h;
      this.g = paramc.i;
      this.h = paramc.j;
      this.i = paramc.k;
      this.j = paramc.p;
      this.k = paramc.q;
      this.l = paramc.l;
      this.m = paramc.m;
      this.n = paramc.n;
      this.o = paramc.o;
      this.p = paramc.r;
      this.q = paramc.s;
    }
    
    public c a()
    {
      return new c(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, null);
    }
    
    public b b()
    {
      this.n = false;
      return this;
    }
    
    @Pure
    public int c()
    {
      return this.g;
    }
    
    @Pure
    public int d()
    {
      return this.i;
    }
    
    @Pure
    @Nullable
    public CharSequence e()
    {
      return this.a;
    }
    
    public b f(Bitmap paramBitmap)
    {
      this.b = paramBitmap;
      return this;
    }
    
    public b g(float paramFloat)
    {
      this.m = paramFloat;
      return this;
    }
    
    public b h(float paramFloat, int paramInt)
    {
      this.e = paramFloat;
      this.f = paramInt;
      return this;
    }
    
    public b i(int paramInt)
    {
      this.g = paramInt;
      return this;
    }
    
    public b j(@Nullable Layout.Alignment paramAlignment)
    {
      this.d = paramAlignment;
      return this;
    }
    
    public b k(float paramFloat)
    {
      this.h = paramFloat;
      return this;
    }
    
    public b l(int paramInt)
    {
      this.i = paramInt;
      return this;
    }
    
    public b m(float paramFloat)
    {
      this.q = paramFloat;
      return this;
    }
    
    public b n(float paramFloat)
    {
      this.l = paramFloat;
      return this;
    }
    
    public b o(CharSequence paramCharSequence)
    {
      this.a = paramCharSequence;
      return this;
    }
    
    public b p(@Nullable Layout.Alignment paramAlignment)
    {
      this.c = paramAlignment;
      return this;
    }
    
    public b q(float paramFloat, int paramInt)
    {
      this.k = paramFloat;
      this.j = paramInt;
      return this;
    }
    
    public b r(int paramInt)
    {
      this.p = paramInt;
      return this;
    }
    
    public b s(@ColorInt int paramInt)
    {
      this.o = paramInt;
      this.n = true;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */