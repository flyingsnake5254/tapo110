package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public final class OpenSslServerSessionContext
  extends OpenSslSessionContext
{
  OpenSslServerSessionContext(ReferenceCountedOpenSslContext paramReferenceCountedOpenSslContext, OpenSslKeyMaterialProvider paramOpenSslKeyMaterialProvider)
  {
    super(paramReferenceCountedOpenSslContext, paramOpenSslKeyMaterialProvider);
  }
  
  public int getSessionCacheSize()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.getSessionCacheSize(this.context.ctx);
      int i = (int)l;
      return i;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public int getSessionTimeout()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.getSessionCacheTimeout(this.context.ctx);
      int i = (int)l;
      return i;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public boolean isSessionCacheEnabled()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l1 = SSLContext.getSessionCacheMode(this.context.ctx);
      long l2 = SSL.SSL_SESS_CACHE_SERVER;
      boolean bool;
      if (l1 == l2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void setSessionCacheEnabled(boolean paramBoolean)
  {
    long l;
    if (paramBoolean) {
      l = SSL.SSL_SESS_CACHE_SERVER;
    } else {
      l = SSL.SSL_SESS_CACHE_OFF;
    }
    Lock localLock = this.context.ctxLock.writeLock();
    localLock.lock();
    try
    {
      SSLContext.setSessionCacheMode(this.context.ctx, l);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void setSessionCacheSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      Lock localLock = this.context.ctxLock.writeLock();
      localLock.lock();
      try
      {
        SSLContext.setSessionCacheSize(this.context.ctx, paramInt);
        return;
      }
      finally
      {
        localLock.unlock();
      }
    }
    throw new IllegalArgumentException();
  }
  
  public boolean setSessionIdContext(byte[] paramArrayOfByte)
  {
    Lock localLock = this.context.ctxLock.writeLock();
    localLock.lock();
    try
    {
      boolean bool = SSLContext.setSessionIdContext(this.context.ctx, paramArrayOfByte);
      return bool;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void setSessionTimeout(int paramInt)
  {
    if (paramInt >= 0)
    {
      Lock localLock = this.context.ctxLock.writeLock();
      localLock.lock();
      try
      {
        SSLContext.setSessionCacheTimeout(this.context.ctx, paramInt);
        return;
      }
      finally
      {
        localLock.unlock();
      }
    }
    throw new IllegalArgumentException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslServerSessionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */