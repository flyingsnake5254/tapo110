package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

public abstract interface y
{
  @Deprecated
  public abstract void C(Format paramFormat);
  
  public abstract void D(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame);
  
  public abstract void F(Exception paramException);
  
  public abstract void H(com.google.android.exoplayer2.decoder.d paramd);
  
  public abstract void T(int paramInt, long paramLong);
  
  public abstract void X(Object paramObject, long paramLong);
  
  public abstract void Z(com.google.android.exoplayer2.decoder.d paramd);
  
  public abstract void c(z paramz);
  
  public abstract void h(String paramString);
  
  public abstract void j0(long paramLong, int paramInt);
  
  public abstract void k(String paramString, long paramLong1, long paramLong2);
  
  public static final class a
  {
    @Nullable
    private final Handler a;
    @Nullable
    private final y b;
    
    public a(@Nullable Handler paramHandler, @Nullable y paramy)
    {
      if (paramy != null) {
        paramHandler = (Handler)com.google.android.exoplayer2.util.g.e(paramHandler);
      } else {
        paramHandler = null;
      }
      this.a = paramHandler;
      this.b = paramy;
    }
    
    public void A(Object paramObject)
    {
      if (this.a != null)
      {
        long l = SystemClock.elapsedRealtime();
        this.a.post(new f(this, paramObject, l));
      }
    }
    
    public void B(long paramLong, int paramInt)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new k(this, paramLong, paramInt));
      }
    }
    
    public void C(Exception paramException)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new d(this, paramException));
      }
    }
    
    public void D(z paramz)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new i(this, paramz));
      }
    }
    
    public void a(String paramString, long paramLong1, long paramLong2)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new h(this, paramString, paramLong1, paramLong2));
      }
    }
    
    public void b(String paramString)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new c(this, paramString));
      }
    }
    
    public void c(com.google.android.exoplayer2.decoder.d paramd)
    {
      paramd.c();
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new b(this, paramd));
      }
    }
    
    public void d(int paramInt, long paramLong)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new g(this, paramInt, paramLong));
      }
    }
    
    public void e(com.google.android.exoplayer2.decoder.d paramd)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new e(this, paramd));
      }
    }
    
    public void f(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new j(this, paramFormat, parame));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */