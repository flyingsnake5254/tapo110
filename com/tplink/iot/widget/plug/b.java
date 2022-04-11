package com.tplink.iot.widget.plug;

import android.graphics.drawable.TransitionDrawable;
import io.reactivex.d0.b.a;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public final class b
{
  private c a;
  private final TransitionDrawable b;
  private long c;
  
  public b(TransitionDrawable paramTransitionDrawable, long paramLong)
  {
    this.b = paramTransitionDrawable;
    this.c = paramLong;
    paramTransitionDrawable.setCrossFadeEnabled(true);
  }
  
  public final void b()
  {
    this.b.resetTransition();
    c localc = this.a;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final void d()
  {
    this.b.startTransition((int)this.c);
    this.a = q.c0(this.c + 50L, TimeUnit.MILLISECONDS).l0(a.a()).G0(new a(this));
  }
  
  static final class a<T>
    implements g<Long>
  {
    a(b paramb) {}
    
    public final void a(Long paramLong)
    {
      b.a(this.c).reverseTransition((int)this.c.c());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\plug\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */