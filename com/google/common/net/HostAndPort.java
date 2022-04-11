package com.google.common.net;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.s;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class HostAndPort
  implements Serializable
{
  private static final int NO_PORT = -1;
  private static final long serialVersionUID = 0L;
  private final boolean hasBracketlessColons;
  private final String host;
  private final int port;
  
  private HostAndPort(String paramString, int paramInt, boolean paramBoolean)
  {
    this.host = paramString;
    this.port = paramInt;
    this.hasBracketlessColons = paramBoolean;
  }
  
  public static HostAndPort fromHost(String paramString)
  {
    HostAndPort localHostAndPort = fromString(paramString);
    n.j(localHostAndPort.hasPort() ^ true, "Host has a port: %s", paramString);
    return localHostAndPort;
  }
  
  public static HostAndPort fromParts(String paramString, int paramInt)
  {
    n.f(isValidPort(paramInt), "Port out of range: %s", paramInt);
    HostAndPort localHostAndPort = fromString(paramString);
    n.j(localHostAndPort.hasPort() ^ true, "Host has a port: %s", paramString);
    return new HostAndPort(localHostAndPort.host, paramInt, localHostAndPort.hasBracketlessColons);
  }
  
  public static HostAndPort fromString(String paramString)
  {
    n.o(paramString);
    boolean bool1 = paramString.startsWith("[");
    int i = -1;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject;
    String str;
    if (bool1)
    {
      localObject = getHostAndPortFromBracketedHost(paramString);
      str = localObject[0];
      localObject = localObject[1];
      bool3 = bool2;
    }
    else
    {
      int j = paramString.indexOf(':');
      if (j >= 0)
      {
        int k = j + 1;
        if (paramString.indexOf(':', k) == -1)
        {
          str = paramString.substring(0, j);
          localObject = paramString.substring(k);
          bool3 = bool2;
          break label115;
        }
      }
      if (j >= 0) {
        bool3 = true;
      }
      localObject = null;
      str = paramString;
    }
    label115:
    if (!s.a((String)localObject))
    {
      n.j(((String)localObject).startsWith("+") ^ true, "Unparseable port number: %s", paramString);
      try
      {
        i = Integer.parseInt((String)localObject);
        n.j(isValidPort(i), "Port number out of range: %s", paramString);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unparseable port number: ");
        localStringBuilder.append(paramString);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    return new HostAndPort(str, i, bool3);
  }
  
  private static String[] getHostAndPortFromBracketedHost(String paramString)
  {
    boolean bool;
    if (paramString.charAt(0) == '[') {
      bool = true;
    } else {
      bool = false;
    }
    n.j(bool, "Bracketed host-port string must start with a bracket: %s", paramString);
    int i = paramString.indexOf(':');
    int j = paramString.lastIndexOf(']');
    if ((i > -1) && (j > i)) {
      bool = true;
    } else {
      bool = false;
    }
    n.j(bool, "Invalid bracketed host/port: %s", paramString);
    String str = paramString.substring(1, j);
    i = j + 1;
    if (i == paramString.length()) {
      return new String[] { str, "" };
    }
    if (paramString.charAt(i) == ':') {
      bool = true;
    } else {
      bool = false;
    }
    n.j(bool, "Only a colon may follow a close bracket: %s", paramString);
    i = j + 2;
    for (j = i; j < paramString.length(); j++) {
      n.j(Character.isDigit(paramString.charAt(j)), "Port must be numeric: %s", paramString);
    }
    return new String[] { str, paramString.substring(i) };
  }
  
  private static boolean isValidPort(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= 65535)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof HostAndPort))
    {
      paramObject = (HostAndPort)paramObject;
      if ((!k.a(this.host, ((HostAndPort)paramObject).host)) || (this.port != ((HostAndPort)paramObject).port)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public int getPort()
  {
    n.u(hasPort());
    return this.port;
  }
  
  public int getPortOrDefault(int paramInt)
  {
    if (hasPort()) {
      paramInt = this.port;
    }
    return paramInt;
  }
  
  public boolean hasPort()
  {
    boolean bool;
    if (this.port >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { this.host, Integer.valueOf(this.port) });
  }
  
  public HostAndPort requireBracketsForIPv6()
  {
    n.j(this.hasBracketlessColons ^ true, "Possible bracketless IPv6 literal: %s", this.host);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.host.length() + 8);
    if (this.host.indexOf(':') >= 0)
    {
      localStringBuilder.append('[');
      localStringBuilder.append(this.host);
      localStringBuilder.append(']');
    }
    else
    {
      localStringBuilder.append(this.host);
    }
    if (hasPort())
    {
      localStringBuilder.append(':');
      localStringBuilder.append(this.port);
    }
    return localStringBuilder.toString();
  }
  
  public HostAndPort withDefaultPort(int paramInt)
  {
    n.d(isValidPort(paramInt));
    if (hasPort()) {
      return this;
    }
    return new HostAndPort(this.host, paramInt, this.hasBracketlessColons);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\net\HostAndPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */