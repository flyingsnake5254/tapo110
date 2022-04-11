package com.google.android.datatransport.h.x.j;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.h.i;
import com.google.android.datatransport.h.n;
import java.io.Closeable;

@WorkerThread
public abstract interface y
  extends Closeable
{
  public abstract int b();
  
  public abstract void d(Iterable<e0> paramIterable);
  
  public abstract void f(n paramn, long paramLong);
  
  public abstract Iterable<n> h();
  
  public abstract long m(n paramn);
  
  public abstract boolean n(n paramn);
  
  public abstract void o(Iterable<e0> paramIterable);
  
  public abstract Iterable<e0> p(n paramn);
  
  @Nullable
  public abstract e0 r(n paramn, i parami);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\j\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */