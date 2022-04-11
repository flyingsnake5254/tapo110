package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public final class OpenSslSessionStats
{
  private final ReferenceCountedOpenSslContext context;
  
  OpenSslSessionStats(ReferenceCountedOpenSslContext paramReferenceCountedOpenSslContext)
  {
    this.context = paramReferenceCountedOpenSslContext;
  }
  
  public long accept()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionAccept(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long acceptGood()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionAcceptGood(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long acceptRenegotiate()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionAcceptRenegotiate(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long cacheFull()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionCacheFull(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long cbHits()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionCbHits(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long connect()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionConnect(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long connectGood()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionConnectGood(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long connectRenegotiate()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionConnectRenegotiate(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long hits()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionHits(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long misses()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionMisses(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long number()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionNumber(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long ticketKeyFail()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionTicketKeyFail(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long ticketKeyNew()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionTicketKeyNew(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long ticketKeyRenew()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionTicketKeyRenew(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long ticketKeyResume()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionTicketKeyResume(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public long timeouts()
  {
    Lock localLock = this.context.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.sessionTimeouts(this.context.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslSessionStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */