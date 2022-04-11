package io.netty.resolver;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HostsFileEntries
{
  static final HostsFileEntries EMPTY = new HostsFileEntries(Collections.emptyMap(), Collections.emptyMap());
  private final Map<String, Inet4Address> inet4Entries;
  private final Map<String, Inet6Address> inet6Entries;
  
  public HostsFileEntries(Map<String, Inet4Address> paramMap, Map<String, Inet6Address> paramMap1)
  {
    this.inet4Entries = Collections.unmodifiableMap(new HashMap(paramMap));
    this.inet6Entries = Collections.unmodifiableMap(new HashMap(paramMap1));
  }
  
  public Map<String, Inet4Address> inet4Entries()
  {
    return this.inet4Entries;
  }
  
  public Map<String, Inet6Address> inet6Entries()
  {
    return this.inet6Entries;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\HostsFileEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */