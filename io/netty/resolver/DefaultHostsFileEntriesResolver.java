package io.netty.resolver;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;

public final class DefaultHostsFileEntriesResolver
  implements HostsFileEntriesResolver
{
  private final Map<String, Inet4Address> inet4Entries;
  private final Map<String, Inet6Address> inet6Entries;
  
  public DefaultHostsFileEntriesResolver()
  {
    this(parseEntries());
  }
  
  DefaultHostsFileEntriesResolver(HostsFileEntries paramHostsFileEntries)
  {
    this.inet4Entries = paramHostsFileEntries.inet4Entries();
    this.inet6Entries = paramHostsFileEntries.inet6Entries();
  }
  
  private static HostsFileEntries parseEntries()
  {
    if (PlatformDependent.isWindows()) {
      return HostsFileParser.parseSilently(new Charset[] { Charset.defaultCharset(), CharsetUtil.UTF_16, CharsetUtil.UTF_8 });
    }
    return HostsFileParser.parseSilently();
  }
  
  public InetAddress address(String paramString, ResolvedAddressTypes paramResolvedAddressTypes)
  {
    String str = normalize(paramString);
    int i = 1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[paramResolvedAddressTypes.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            paramString = (Inet6Address)this.inet6Entries.get(str);
            if (paramString == null) {
              paramString = (InetAddress)this.inet4Entries.get(str);
            }
            return paramString;
          }
          paramString = new StringBuilder();
          paramString.append("Unknown ResolvedAddressTypes ");
          paramString.append(paramResolvedAddressTypes);
          throw new IllegalArgumentException(paramString.toString());
        }
        paramString = (Inet4Address)this.inet4Entries.get(str);
        if (paramString == null) {
          paramString = (InetAddress)this.inet6Entries.get(str);
        }
        return paramString;
      }
      return (InetAddress)this.inet6Entries.get(str);
    }
    return (InetAddress)this.inet4Entries.get(str);
  }
  
  String normalize(String paramString)
  {
    return paramString.toLowerCase(Locale.ENGLISH);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\DefaultHostsFileEntriesResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */