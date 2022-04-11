package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.b;
import io.reactivex.q;
import io.reactivex.v;

public final class s<T>
  extends q<T>
{
  final e c;
  
  public s(e parame)
  {
    this.c = parame;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv));
  }
  
  static final class a
    extends b<Void>
    implements io.reactivex.c
  {
    final v<?> c;
    io.reactivex.e0.c d;
    
    a(v<?> paramv)
    {
      this.c = paramv;
    }
    
    public Void a()
      throws Exception
    {
      return null;
    }
    
    public void clear() {}
    
    public void dispose()
    {
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.validate(this.d, paramc))
      {
        this.d = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    public int requestFusion(int paramInt)
    {
      return paramInt & 0x2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */