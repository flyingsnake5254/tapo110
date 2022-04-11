package io.netty.channel.kqueue;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import java.io.IOException;

final class BsdSocket
  extends Socket
{
  private static final int APPLE_SND_LOW_AT_MAX = 131072;
  static final int BSD_SND_LOW_AT_MAX = Math.min(131072, 32768);
  private static final int FREEBSD_SND_LOW_AT_MAX = 32768;
  
  BsdSocket(int paramInt)
  {
    super(paramInt);
  }
  
  private static native String[] getAcceptFilter(int paramInt)
    throws IOException;
  
  private static native PeerCredentials getPeerCredentials(int paramInt)
    throws IOException;
  
  private static native int getSndLowAt(int paramInt)
    throws IOException;
  
  private static native int getTcpNoPush(int paramInt)
    throws IOException;
  
  public static BsdSocket newSocketDgram()
  {
    return new BsdSocket(Socket.newSocketDgram0());
  }
  
  public static BsdSocket newSocketDomain()
  {
    return new BsdSocket(Socket.newSocketDomain0());
  }
  
  public static BsdSocket newSocketStream()
  {
    return new BsdSocket(Socket.newSocketStream0());
  }
  
  private static native long sendFile(int paramInt, DefaultFileRegion paramDefaultFileRegion, long paramLong1, long paramLong2, long paramLong3)
    throws IOException;
  
  private static native void setAcceptFilter(int paramInt, String paramString1, String paramString2)
    throws IOException;
  
  private static native void setSndLowAt(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpNoPush(int paramInt1, int paramInt2)
    throws IOException;
  
  AcceptFilter getAcceptFilter()
    throws IOException
  {
    Object localObject = getAcceptFilter(intValue());
    if (localObject == null) {
      localObject = AcceptFilter.PLATFORM_UNSUPPORTED;
    } else {
      localObject = new AcceptFilter(localObject[0], localObject[1]);
    }
    return (AcceptFilter)localObject;
  }
  
  PeerCredentials getPeerCredentials()
    throws IOException
  {
    return getPeerCredentials(intValue());
  }
  
  int getSndLowAt()
    throws IOException
  {
    return getSndLowAt(intValue());
  }
  
  boolean isTcpNoPush()
    throws IOException
  {
    boolean bool;
    if (getTcpNoPush(intValue()) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  long sendFile(DefaultFileRegion paramDefaultFileRegion, long paramLong1, long paramLong2, long paramLong3)
    throws IOException
  {
    paramDefaultFileRegion.open();
    paramLong1 = sendFile(intValue(), paramDefaultFileRegion, paramLong1, paramLong2, paramLong3);
    if (paramLong1 >= 0L) {
      return paramLong1;
    }
    return Errors.ioResult("sendfile", (int)paramLong1);
  }
  
  void setAcceptFilter(AcceptFilter paramAcceptFilter)
    throws IOException
  {
    setAcceptFilter(intValue(), paramAcceptFilter.filterName(), paramAcceptFilter.filterArgs());
  }
  
  void setSndLowAt(int paramInt)
    throws IOException
  {
    setSndLowAt(intValue(), paramInt);
  }
  
  void setTcpNoPush(boolean paramBoolean)
    throws IOException
  {
    setTcpNoPush(intValue(), paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\BsdSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */