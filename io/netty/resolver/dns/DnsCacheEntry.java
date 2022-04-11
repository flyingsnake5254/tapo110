package io.netty.resolver.dns;

import java.net.InetAddress;

public abstract interface DnsCacheEntry
{
  public abstract InetAddress address();
  
  public abstract Throwable cause();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsCacheEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */