package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

public abstract interface t
{
  public abstract void E(long paramLong);
  
  public abstract void L(com.google.android.exoplayer2.decoder.d paramd);
  
  public abstract void V(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(Exception paramException);
  
  public abstract void b0(Exception paramException);
  
  @Deprecated
  public abstract void c0(Format paramFormat);
  
  public abstract void h0(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void i(com.google.android.exoplayer2.decoder.d paramd);
  
  public abstract void t(String paramString);
  
  public abstract void u(String paramString, long paramLong1, long paramLong2);
  
  public static final class a
  {
    @Nullable
    private final Handler a;
    @Nullable
    private final t b;
    
    public a(@Nullable Handler paramHandler, @Nullable t paramt)
    {
      if (paramt != null) {
        paramHandler = (Handler)com.google.android.exoplayer2.util.g.e(paramHandler);
      } else {
        paramHandler = null;
      }
      this.a = paramHandler;
      this.b = paramt;
    }
    
    public void B(long paramLong)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new i(this, paramLong));
      }
    }
    
    public void C(boolean paramBoolean)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new b(this, paramBoolean));
      }
    }
    
    public void D(int paramInt, long paramLong1, long paramLong2)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new j(this, paramInt, paramLong1, paramLong2));
      }
    }
    
    public void a(Exception paramException)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new d(this, paramException));
      }
    }
    
    public void b(Exception paramException)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new e(this, paramException));
      }
    }
    
    public void c(String paramString, long paramLong1, long paramLong2)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new g(this, paramString, paramLong1, paramLong2));
      }
    }
    
    public void d(String paramString)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new h(this, paramString));
      }
    }
    
    public void e(com.google.android.exoplayer2.decoder.d paramd)
    {
      paramd.c();
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new c(this, paramd));
      }
    }
    
    public void f(com.google.android.exoplayer2.decoder.d paramd)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new k(this, paramd));
      }
    }
    
    public void g(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame)
    {
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.post(new f(this, paramFormat, parame));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */