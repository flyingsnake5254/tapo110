package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SessionTicketKey;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

public abstract class OpenSslSessionContext
  implements SSLSessionContext
{
  private static final Enumeration<byte[]> EMPTY = new EmptyEnumeration(null);
  final ReferenceCountedOpenSslContext context;
  private final OpenSslKeyMaterialProvider provider;
  private final OpenSslSessionStats stats;
  
  OpenSslSessionContext(ReferenceCountedOpenSslContext paramReferenceCountedOpenSslContext, OpenSslKeyMaterialProvider paramOpenSslKeyMaterialProvider)
  {
    this.context = paramReferenceCountedOpenSslContext;
    this.provider = paramOpenSslKeyMaterialProvider;
    this.stats = new OpenSslSessionStats(paramReferenceCountedOpenSslContext);
  }
  
  final void destroy()
  {
    OpenSslKeyMaterialProvider localOpenSslKeyMaterialProvider = this.provider;
    if (localOpenSslKeyMaterialProvider != null) {
      localOpenSslKeyMaterialProvider.destroy();
    }
  }
  
  public Enumeration<byte[]> getIds()
  {
    return EMPTY;
  }
  
  public SSLSession getSession(byte[] paramArrayOfByte)
  {
    ObjectUtil.checkNotNull(paramArrayOfByte, "bytes");
    return null;
  }
  
  public abstract boolean isSessionCacheEnabled();
  
  public abstract void setSessionCacheEnabled(boolean paramBoolean);
  
  @Deprecated
  public void setTicketKeys(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length % 48 == 0)
    {
      int i = paramArrayOfByte.length / 48;
      SessionTicketKey[] arrayOfSessionTicketKey = new SessionTicketKey[i];
      int j = 0;
      int k = 0;
      while (j < i)
      {
        byte[] arrayOfByte1 = Arrays.copyOfRange(paramArrayOfByte, k, 16);
        k += 16;
        byte[] arrayOfByte2 = Arrays.copyOfRange(paramArrayOfByte, k, 16);
        j += 16;
        byte[] arrayOfByte3 = Arrays.copyOfRange(paramArrayOfByte, k, 16);
        k += 16;
        arrayOfSessionTicketKey[j] = new SessionTicketKey(arrayOfByte1, arrayOfByte2, arrayOfByte3);
        j++;
      }
      paramArrayOfByte = this.context.ctxLock.writeLock();
      paramArrayOfByte.lock();
      try
      {
        SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
        SSLContext.setSessionTicketKeys(this.context.ctx, arrayOfSessionTicketKey);
        return;
      }
      finally
      {
        paramArrayOfByte.unlock();
      }
    }
    throw new IllegalArgumentException("keys.length % 48 != 0");
  }
  
  public void setTicketKeys(OpenSslSessionTicketKey... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "keys");
    int i = paramVarArgs.length;
    SessionTicketKey[] arrayOfSessionTicketKey = new SessionTicketKey[i];
    for (int j = 0; j < i; j++) {
      arrayOfSessionTicketKey[j] = paramVarArgs[j].key;
    }
    paramVarArgs = this.context.ctxLock.writeLock();
    paramVarArgs.lock();
    try
    {
      SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
      if (i > 0) {
        SSLContext.setSessionTicketKeys(this.context.ctx, arrayOfSessionTicketKey);
      }
      return;
    }
    finally
    {
      paramVarArgs.unlock();
    }
  }
  
  public OpenSslSessionStats stats()
  {
    return this.stats;
  }
  
  final boolean useKeyManager()
  {
    boolean bool;
    if (this.provider != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static final class EmptyEnumeration
    implements Enumeration<byte[]>
  {
    public boolean hasMoreElements()
    {
      return false;
    }
    
    public byte[] nextElement()
    {
      throw new NoSuchElementException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslSessionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */