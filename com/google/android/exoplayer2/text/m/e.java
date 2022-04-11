package com.google.android.exoplayer2.text.m;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.f.a;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class e
  implements com.google.android.exoplayer2.text.g
{
  private final ArrayDeque<b> a = new ArrayDeque();
  private final ArrayDeque<j> b;
  private final PriorityQueue<b> c;
  @Nullable
  private b d;
  private long e;
  private long f;
  
  public e()
  {
    int i = 0;
    for (int j = 0; j < 10; j++) {
      this.a.add(new b(null));
    }
    this.b = new ArrayDeque();
    for (j = i; j < 2; j++) {
      this.b.add(new c(new b(this)));
    }
    this.c = new PriorityQueue();
  }
  
  private void m(b paramb)
  {
    paramb.f();
    this.a.add(paramb);
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  protected abstract f e();
  
  protected abstract void f(i parami);
  
  public void flush()
  {
    this.f = 0L;
    this.e = 0L;
    while (!this.c.isEmpty()) {
      m((b)o0.i((b)this.c.poll()));
    }
    b localb = this.d;
    if (localb != null)
    {
      m(localb);
      this.d = null;
    }
  }
  
  @Nullable
  public i g()
    throws SubtitleDecoderException
  {
    boolean bool;
    if (this.d == null) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    if (this.a.isEmpty()) {
      return null;
    }
    b localb = (b)this.a.pollFirst();
    this.d = localb;
    return localb;
  }
  
  @Nullable
  public j h()
    throws SubtitleDecoderException
  {
    if (this.b.isEmpty()) {
      return null;
    }
    while ((!this.c.isEmpty()) && (((b)o0.i((b)this.c.peek())).x <= this.e))
    {
      b localb = (b)o0.i((b)this.c.poll());
      j localj;
      if (localb.k())
      {
        localj = (j)o0.i((j)this.b.pollFirst());
        localj.e(4);
        m(localb);
        return localj;
      }
      f(localb);
      if (k())
      {
        f localf = e();
        localj = (j)o0.i((j)this.b.pollFirst());
        localj.o(localb.x, localf, Long.MAX_VALUE);
        m(localb);
        return localj;
      }
      m(localb);
    }
    return null;
  }
  
  @Nullable
  protected final j i()
  {
    return (j)this.b.pollFirst();
  }
  
  protected final long j()
  {
    return this.e;
  }
  
  protected abstract boolean k();
  
  public void l(i parami)
    throws SubtitleDecoderException
  {
    boolean bool;
    if (parami == this.d) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.a(bool);
    parami = (b)parami;
    if (parami.j())
    {
      m(parami);
    }
    else
    {
      long l = this.f;
      this.f = (1L + l);
      b.t(parami, l);
      this.c.add(parami);
    }
    this.d = null;
  }
  
  protected void n(j paramj)
  {
    paramj.f();
    this.b.add(paramj);
  }
  
  public void release() {}
  
  private static final class b
    extends i
    implements Comparable<b>
  {
    private long p2;
    
    public int u(b paramb)
    {
      boolean bool1 = k();
      boolean bool2 = paramb.k();
      int i = 1;
      int j = 1;
      if (bool1 != bool2)
      {
        if (!k()) {
          j = -1;
        }
        return j;
      }
      long l1 = this.x - paramb.x;
      long l2 = l1;
      if (l1 == 0L)
      {
        l1 = this.p2 - paramb.p2;
        l2 = l1;
        if (l1 == 0L) {
          return 0;
        }
      }
      if (l2 > 0L) {
        j = i;
      } else {
        j = -1;
      }
      return j;
    }
  }
  
  private static final class c
    extends j
  {
    private f.a<c> y;
    
    public c(f.a<c> parama)
    {
      this.y = parama;
    }
    
    public final void n()
    {
      this.y.a(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\m\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */