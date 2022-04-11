package io.netty.channel.socket.nio;

import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;

final class ProtocolFamilyConverter
{
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public static ProtocolFamily convert(InternetProtocolFamily paramInternetProtocolFamily)
  {
    int i = 1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[paramInternetProtocolFamily.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return StandardProtocolFamily.INET6;
      }
      throw new IllegalArgumentException();
    }
    return StandardProtocolFamily.INET;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\nio\ProtocolFamilyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */