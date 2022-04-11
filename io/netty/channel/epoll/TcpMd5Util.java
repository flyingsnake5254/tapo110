package io.netty.channel.epoll;

import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class TcpMd5Util
{
  static Collection<InetAddress> newTcpMd5Sigs(AbstractEpollChannel paramAbstractEpollChannel, Collection<InetAddress> paramCollection, Map<InetAddress, byte[]> paramMap)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramAbstractEpollChannel, "channel");
    ObjectUtil.checkNotNull(paramCollection, "current");
    ObjectUtil.checkNotNull(paramMap, "newKeys");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      byte[] arrayOfByte = (byte[])((Map.Entry)localObject).getValue();
      if (((Map.Entry)localObject).getKey() != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newKeys[");
        localStringBuilder.append(((Map.Entry)localObject).getKey());
        localStringBuilder.append(']');
        ObjectUtil.checkNotNull(arrayOfByte, localStringBuilder.toString());
        if (arrayOfByte.length != 0)
        {
          int i = arrayOfByte.length;
          int j = Native.TCP_MD5SIG_MAXKEYLEN;
          if (i > j)
          {
            paramAbstractEpollChannel = new StringBuilder();
            paramAbstractEpollChannel.append("newKeys[");
            paramAbstractEpollChannel.append(((Map.Entry)localObject).getKey());
            paramAbstractEpollChannel.append("] has a key with invalid length; should not exceed the maximum length (");
            paramAbstractEpollChannel.append(j);
            paramAbstractEpollChannel.append(')');
            throw new IllegalArgumentException(paramAbstractEpollChannel.toString());
          }
        }
        else
        {
          paramAbstractEpollChannel = new StringBuilder();
          paramAbstractEpollChannel.append("newKeys[");
          paramAbstractEpollChannel.append(((Map.Entry)localObject).getKey());
          paramAbstractEpollChannel.append("] has an empty key.");
          throw new IllegalArgumentException(paramAbstractEpollChannel.toString());
        }
      }
      else
      {
        paramAbstractEpollChannel = new StringBuilder();
        paramAbstractEpollChannel.append("newKeys contains an entry with null address: ");
        paramAbstractEpollChannel.append(paramMap);
        throw new IllegalArgumentException(paramAbstractEpollChannel.toString());
      }
    }
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramCollection = (InetAddress)((Iterator)localObject).next();
      if (!paramMap.containsKey(paramCollection)) {
        paramAbstractEpollChannel.socket.setTcpMd5Sig(paramCollection, null);
      }
    }
    if (paramMap.isEmpty()) {
      return Collections.emptySet();
    }
    paramCollection = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      paramAbstractEpollChannel.socket.setTcpMd5Sig((InetAddress)((Map.Entry)localObject).getKey(), (byte[])((Map.Entry)localObject).getValue());
      paramCollection.add(((Map.Entry)localObject).getKey());
    }
    return paramCollection;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\TcpMd5Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */