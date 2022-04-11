package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.l1.h;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;

public final class s0
  extends m
{
  private final n g;
  private final l.a h;
  private final Format i;
  private final long j;
  private final x k;
  private final boolean l;
  private final j2 m;
  private final l1 n;
  @Nullable
  private a0 o;
  
  private s0(@Nullable String paramString, l1.h paramh, l.a parama, long paramLong, x paramx, boolean paramBoolean, @Nullable Object paramObject)
  {
    this.h = parama;
    this.j = paramLong;
    this.k = paramx;
    this.l = paramBoolean;
    parama = new l1.c().u(Uri.EMPTY).p(paramh.a.toString()).s(Collections.singletonList(paramh)).t(paramObject).a();
    this.n = parama;
    this.i = new Format.b().S(paramString).e0(paramh.b).V(paramh.c).g0(paramh.d).c0(paramh.e).U(paramh.f).E();
    this.g = new n.b().i(paramh.a).b(1).a();
    this.m = new q0(paramLong, true, false, false, null, parama);
  }
  
  public b0 a(e0.a parama, e parame, long paramLong)
  {
    return new r0(this.g, this.h, this.o, this.i, this.j, this.k, t(parama), this.l);
  }
  
  public l1 f()
  {
    return this.n;
  }
  
  public void g(b0 paramb0)
  {
    ((r0)paramb0).t();
  }
  
  public void n() {}
  
  protected void x(@Nullable a0 parama0)
  {
    this.o = parama0;
    y(this.m);
  }
  
  protected void z() {}
  
  public static final class b
  {
    private final l.a a;
    private x b;
    private boolean c;
    @Nullable
    private Object d;
    @Nullable
    private String e;
    
    public b(l.a parama)
    {
      this.a = ((l.a)g.e(parama));
      this.b = new t();
      this.c = true;
    }
    
    public s0 a(l1.h paramh, long paramLong)
    {
      return new s0(this.e, paramh, this.a, paramLong, this.b, this.c, this.d, null);
    }
    
    public b b(@Nullable x paramx)
    {
      if (paramx == null) {
        paramx = new t();
      }
      this.b = paramx;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */