package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;

public abstract interface e0
{
  public abstract b0 a(a parama, e parame, long paramLong);
  
  public abstract void b(b paramb);
  
  public abstract void d(Handler paramHandler, f0 paramf0);
  
  public abstract void e(f0 paramf0);
  
  public abstract l1 f();
  
  public abstract void g(b0 paramb0);
  
  public abstract void h(b paramb, @Nullable a0 parama0);
  
  public abstract void i(b paramb);
  
  public abstract void j(b paramb);
  
  public abstract void l(Handler paramHandler, v paramv);
  
  public abstract void m(v paramv);
  
  public abstract void n()
    throws IOException;
  
  public abstract boolean o();
  
  @Nullable
  public abstract j2 p();
  
  public static final class a
    extends c0
  {
    public a(c0 paramc0)
    {
      super();
    }
    
    public a(Object paramObject)
    {
      super();
    }
    
    public a(Object paramObject, int paramInt1, int paramInt2, long paramLong)
    {
      super(paramInt1, paramInt2, paramLong);
    }
    
    public a(Object paramObject, long paramLong)
    {
      super(paramLong);
    }
    
    public a(Object paramObject, long paramLong, int paramInt)
    {
      super(paramLong, paramInt);
    }
    
    public a c(Object paramObject)
    {
      return new a(super.a(paramObject));
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e0 parame0, j2 paramj2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */