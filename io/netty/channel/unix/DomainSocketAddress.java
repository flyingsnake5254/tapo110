package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.net.SocketAddress;

public final class DomainSocketAddress
  extends SocketAddress
{
  private static final long serialVersionUID = -6934618000832236893L;
  private final String socketPath;
  
  public DomainSocketAddress(File paramFile)
  {
    this(paramFile.getPath());
  }
  
  public DomainSocketAddress(String paramString)
  {
    this.socketPath = ((String)ObjectUtil.checkNotNull(paramString, "socketPath"));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DomainSocketAddress)) {
      return false;
    }
    return ((DomainSocketAddress)paramObject).socketPath.equals(this.socketPath);
  }
  
  public int hashCode()
  {
    return this.socketPath.hashCode();
  }
  
  public String path()
  {
    return this.socketPath;
  }
  
  public String toString()
  {
    return path();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\DomainSocketAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */