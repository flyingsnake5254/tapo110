package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.k;
import java.util.Arrays;
import java.util.List;

public final class m1
{
  public static final m1 a = new b().F();
  public static final v0<m1> b = f0.a;
  @Nullable
  public final CharSequence A;
  @Nullable
  public final CharSequence B;
  @Nullable
  public final CharSequence C;
  @Nullable
  public final Integer D;
  @Nullable
  public final Integer E;
  @Nullable
  public final CharSequence F;
  @Nullable
  public final CharSequence G;
  @Nullable
  public final Bundle H;
  @Nullable
  public final CharSequence c;
  @Nullable
  public final CharSequence d;
  @Nullable
  public final CharSequence e;
  @Nullable
  public final CharSequence f;
  @Nullable
  public final CharSequence g;
  @Nullable
  public final CharSequence h;
  @Nullable
  public final CharSequence i;
  @Nullable
  public final Uri j;
  @Nullable
  public final z1 k;
  @Nullable
  public final z1 l;
  @Nullable
  public final byte[] m;
  @Nullable
  public final Integer n;
  @Nullable
  public final Uri o;
  @Nullable
  public final Integer p;
  @Nullable
  public final Integer q;
  @Nullable
  public final Integer r;
  @Nullable
  public final Boolean s;
  @Deprecated
  @Nullable
  public final Integer t;
  @Nullable
  public final Integer u;
  @Nullable
  public final Integer v;
  @Nullable
  public final Integer w;
  @Nullable
  public final Integer x;
  @Nullable
  public final Integer y;
  @Nullable
  public final Integer z;
  
  private m1(b paramb)
  {
    this.c = b.a(paramb);
    this.d = b.l(paramb);
    this.e = b.w(paramb);
    this.f = b.z(paramb);
    this.g = b.A(paramb);
    this.h = b.B(paramb);
    this.i = b.C(paramb);
    this.j = b.D(paramb);
    this.k = b.E(paramb);
    this.l = b.b(paramb);
    this.m = b.c(paramb);
    this.n = b.d(paramb);
    this.o = b.e(paramb);
    this.p = b.f(paramb);
    this.q = b.g(paramb);
    this.r = b.h(paramb);
    this.s = b.i(paramb);
    this.t = b.j(paramb);
    this.u = b.j(paramb);
    this.v = b.k(paramb);
    this.w = b.m(paramb);
    this.x = b.n(paramb);
    this.y = b.o(paramb);
    this.z = b.p(paramb);
    this.A = b.q(paramb);
    this.B = b.r(paramb);
    this.C = b.s(paramb);
    this.D = b.t(paramb);
    this.E = b.u(paramb);
    this.F = b.v(paramb);
    this.G = b.x(paramb);
    this.H = b.y(paramb);
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
    if ((paramObject != null) && (m1.class == paramObject.getClass()))
    {
      paramObject = (m1)paramObject;
      if ((!o0.b(this.c, ((m1)paramObject).c)) || (!o0.b(this.d, ((m1)paramObject).d)) || (!o0.b(this.e, ((m1)paramObject).e)) || (!o0.b(this.f, ((m1)paramObject).f)) || (!o0.b(this.g, ((m1)paramObject).g)) || (!o0.b(this.h, ((m1)paramObject).h)) || (!o0.b(this.i, ((m1)paramObject).i)) || (!o0.b(this.j, ((m1)paramObject).j)) || (!o0.b(this.k, ((m1)paramObject).k)) || (!o0.b(this.l, ((m1)paramObject).l)) || (!Arrays.equals(this.m, ((m1)paramObject).m)) || (!o0.b(this.n, ((m1)paramObject).n)) || (!o0.b(this.o, ((m1)paramObject).o)) || (!o0.b(this.p, ((m1)paramObject).p)) || (!o0.b(this.q, ((m1)paramObject).q)) || (!o0.b(this.r, ((m1)paramObject).r)) || (!o0.b(this.s, ((m1)paramObject).s)) || (!o0.b(this.u, ((m1)paramObject).u)) || (!o0.b(this.v, ((m1)paramObject).v)) || (!o0.b(this.w, ((m1)paramObject).w)) || (!o0.b(this.x, ((m1)paramObject).x)) || (!o0.b(this.y, ((m1)paramObject).y)) || (!o0.b(this.z, ((m1)paramObject).z)) || (!o0.b(this.A, ((m1)paramObject).A)) || (!o0.b(this.B, ((m1)paramObject).B)) || (!o0.b(this.C, ((m1)paramObject).C)) || (!o0.b(this.D, ((m1)paramObject).D)) || (!o0.b(this.E, ((m1)paramObject).E)) || (!o0.b(this.F, ((m1)paramObject).F)) || (!o0.b(this.G, ((m1)paramObject).G))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, Integer.valueOf(Arrays.hashCode(this.m)), this.n, this.o, this.p, this.q, this.r, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G });
  }
  
  public static final class b
  {
    @Nullable
    private Integer A;
    @Nullable
    private Integer B;
    @Nullable
    private CharSequence C;
    @Nullable
    private CharSequence D;
    @Nullable
    private Bundle E;
    @Nullable
    private CharSequence a;
    @Nullable
    private CharSequence b;
    @Nullable
    private CharSequence c;
    @Nullable
    private CharSequence d;
    @Nullable
    private CharSequence e;
    @Nullable
    private CharSequence f;
    @Nullable
    private CharSequence g;
    @Nullable
    private Uri h;
    @Nullable
    private z1 i;
    @Nullable
    private z1 j;
    @Nullable
    private byte[] k;
    @Nullable
    private Integer l;
    @Nullable
    private Uri m;
    @Nullable
    private Integer n;
    @Nullable
    private Integer o;
    @Nullable
    private Integer p;
    @Nullable
    private Boolean q;
    @Nullable
    private Integer r;
    @Nullable
    private Integer s;
    @Nullable
    private Integer t;
    @Nullable
    private Integer u;
    @Nullable
    private Integer v;
    @Nullable
    private Integer w;
    @Nullable
    private CharSequence x;
    @Nullable
    private CharSequence y;
    @Nullable
    private CharSequence z;
    
    public b() {}
    
    private b(m1 paramm1)
    {
      this.a = paramm1.c;
      this.b = paramm1.d;
      this.c = paramm1.e;
      this.d = paramm1.f;
      this.e = paramm1.g;
      this.f = paramm1.h;
      this.g = paramm1.i;
      this.h = paramm1.j;
      this.i = paramm1.k;
      this.j = paramm1.l;
      this.k = paramm1.m;
      this.l = paramm1.n;
      this.m = paramm1.o;
      this.n = paramm1.p;
      this.o = paramm1.q;
      this.p = paramm1.r;
      this.q = paramm1.s;
      this.r = paramm1.u;
      this.s = paramm1.v;
      this.t = paramm1.w;
      this.u = paramm1.x;
      this.v = paramm1.y;
      this.w = paramm1.z;
      this.x = paramm1.A;
      this.y = paramm1.B;
      this.z = paramm1.C;
      this.A = paramm1.D;
      this.B = paramm1.E;
      this.C = paramm1.F;
      this.D = paramm1.G;
      this.E = paramm1.H;
    }
    
    public m1 F()
    {
      return new m1(this, null);
    }
    
    public b G(byte[] paramArrayOfByte, int paramInt)
    {
      if ((this.k == null) || (o0.b(Integer.valueOf(paramInt), Integer.valueOf(3))) || (!o0.b(this.l, Integer.valueOf(3))))
      {
        this.k = ((byte[])paramArrayOfByte.clone());
        this.l = Integer.valueOf(paramInt);
      }
      return this;
    }
    
    public b H(Metadata paramMetadata)
    {
      for (int i1 = 0; i1 < paramMetadata.d(); i1++) {
        paramMetadata.c(i1).j(this);
      }
      return this;
    }
    
    public b I(List<Metadata> paramList)
    {
      for (int i1 = 0; i1 < paramList.size(); i1++)
      {
        Metadata localMetadata = (Metadata)paramList.get(i1);
        for (int i2 = 0; i2 < localMetadata.d(); i2++) {
          localMetadata.c(i2).j(this);
        }
      }
      return this;
    }
    
    public b J(@Nullable CharSequence paramCharSequence)
    {
      this.d = paramCharSequence;
      return this;
    }
    
    public b K(@Nullable CharSequence paramCharSequence)
    {
      this.c = paramCharSequence;
      return this;
    }
    
    public b L(@Nullable CharSequence paramCharSequence)
    {
      this.b = paramCharSequence;
      return this;
    }
    
    public b M(@Nullable CharSequence paramCharSequence)
    {
      this.y = paramCharSequence;
      return this;
    }
    
    public b N(@Nullable CharSequence paramCharSequence)
    {
      this.z = paramCharSequence;
      return this;
    }
    
    public b O(@Nullable CharSequence paramCharSequence)
    {
      this.g = paramCharSequence;
      return this;
    }
    
    public b P(@IntRange(from=1L, to=31L) @Nullable Integer paramInteger)
    {
      this.t = paramInteger;
      return this;
    }
    
    public b Q(@IntRange(from=1L, to=12L) @Nullable Integer paramInteger)
    {
      this.s = paramInteger;
      return this;
    }
    
    public b R(@Nullable Integer paramInteger)
    {
      this.r = paramInteger;
      return this;
    }
    
    public b S(@IntRange(from=1L, to=31L) @Nullable Integer paramInteger)
    {
      this.w = paramInteger;
      return this;
    }
    
    public b T(@IntRange(from=1L, to=12L) @Nullable Integer paramInteger)
    {
      this.v = paramInteger;
      return this;
    }
    
    public b U(@Nullable Integer paramInteger)
    {
      this.u = paramInteger;
      return this;
    }
    
    public b V(@Nullable CharSequence paramCharSequence)
    {
      this.a = paramCharSequence;
      return this;
    }
    
    public b W(@Nullable Integer paramInteger)
    {
      this.o = paramInteger;
      return this;
    }
    
    public b X(@Nullable Integer paramInteger)
    {
      this.n = paramInteger;
      return this;
    }
    
    public b Y(@Nullable CharSequence paramCharSequence)
    {
      this.x = paramCharSequence;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\m1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */