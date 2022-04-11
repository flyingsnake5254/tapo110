package io.netty.channel.epoll;

import io.netty.channel.ChannelException;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

final class LinuxSocket
  extends Socket
{
  static final InetAddress INET6_ANY = unsafeInetAddrByName("::");
  private static final InetAddress INET_ANY = unsafeInetAddrByName("0.0.0.0");
  private static final long MAX_UINT32_T = 4294967295L;
  
  LinuxSocket(int paramInt)
  {
    super(paramInt);
  }
  
  private static InetAddress deriveInetAddress(NetworkInterface paramNetworkInterface, boolean paramBoolean)
  {
    InetAddress localInetAddress;
    if (paramBoolean) {
      localInetAddress = INET6_ANY;
    } else {
      localInetAddress = INET_ANY;
    }
    if (paramNetworkInterface != null)
    {
      Enumeration localEnumeration = paramNetworkInterface.getInetAddresses();
      while (localEnumeration.hasMoreElements())
      {
        paramNetworkInterface = (InetAddress)localEnumeration.nextElement();
        if (paramNetworkInterface instanceof Inet6Address == paramBoolean) {
          return paramNetworkInterface;
        }
      }
    }
    return localInetAddress;
  }
  
  private InternetProtocolFamily family()
  {
    InternetProtocolFamily localInternetProtocolFamily;
    if (this.ipv6) {
      localInternetProtocolFamily = InternetProtocolFamily.IPv6;
    } else {
      localInternetProtocolFamily = InternetProtocolFamily.IPv4;
    }
    return localInternetProtocolFamily;
  }
  
  private static native int getInterface(int paramInt, boolean paramBoolean);
  
  private static native int getIpMulticastLoop(int paramInt, boolean paramBoolean)
    throws IOException;
  
  private static native PeerCredentials getPeerCredentials(int paramInt)
    throws IOException;
  
  private static native int getSoBusyPoll(int paramInt)
    throws IOException;
  
  private static native int getTcpDeferAccept(int paramInt)
    throws IOException;
  
  private static native void getTcpInfo(int paramInt, long[] paramArrayOfLong)
    throws IOException;
  
  private static native int getTcpKeepCnt(int paramInt)
    throws IOException;
  
  private static native int getTcpKeepIdle(int paramInt)
    throws IOException;
  
  private static native int getTcpKeepIntvl(int paramInt)
    throws IOException;
  
  private static native int getTcpNotSentLowAt(int paramInt)
    throws IOException;
  
  private static native int getTcpUserTimeout(int paramInt)
    throws IOException;
  
  private static native int getTimeToLive(int paramInt)
    throws IOException;
  
  private static InetAddress inetAddress(int paramInt)
  {
    int i = (byte)(paramInt >>> 24 & 0xFF);
    int j = (byte)(paramInt >>> 16 & 0xFF);
    int k = (byte)(paramInt >>> 8 & 0xFF);
    int m = (byte)(paramInt & 0xFF);
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(new byte[] { i, j, k, m });
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException) {}
    return null;
  }
  
  private static int interfaceIndex(InetAddress paramInetAddress)
    throws IOException
  {
    if (PlatformDependent.javaVersion() >= 7)
    {
      paramInetAddress = NetworkInterface.getByInetAddress(paramInetAddress);
      if (paramInetAddress != null) {
        return paramInetAddress.getIndex();
      }
    }
    return -1;
  }
  
  private static int interfaceIndex(NetworkInterface paramNetworkInterface)
  {
    int i;
    if (PlatformDependent.javaVersion() >= 7) {
      i = paramNetworkInterface.getIndex();
    } else {
      i = -1;
    }
    return i;
  }
  
  private static native int isIpFreeBind(int paramInt)
    throws IOException;
  
  private static native int isIpRecvOrigDestAddr(int paramInt)
    throws IOException;
  
  private static native int isIpTransparent(int paramInt)
    throws IOException;
  
  private static native int isTcpCork(int paramInt)
    throws IOException;
  
  private static native int isTcpFastOpenConnect(int paramInt)
    throws IOException;
  
  private static native int isTcpQuickAck(int paramInt)
    throws IOException;
  
  private static native void joinGroup(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
    throws IOException;
  
  private static native void joinSsmGroup(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, byte[] paramArrayOfByte3)
    throws IOException;
  
  private static native void leaveGroup(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
    throws IOException;
  
  private static native void leaveSsmGroup(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, byte[] paramArrayOfByte3)
    throws IOException;
  
  public static LinuxSocket newSocketDgram()
  {
    return newSocketDgram(Socket.isIPv6Preferred());
  }
  
  public static LinuxSocket newSocketDgram(boolean paramBoolean)
  {
    return new LinuxSocket(Socket.newSocketDgram0(paramBoolean));
  }
  
  public static LinuxSocket newSocketDomain()
  {
    return new LinuxSocket(Socket.newSocketDomain0());
  }
  
  public static LinuxSocket newSocketStream()
  {
    return newSocketStream(Socket.isIPv6Preferred());
  }
  
  public static LinuxSocket newSocketStream(boolean paramBoolean)
  {
    return new LinuxSocket(Socket.newSocketStream0(paramBoolean));
  }
  
  private static native long sendFile(int paramInt, DefaultFileRegion paramDefaultFileRegion, long paramLong1, long paramLong2, long paramLong3)
    throws IOException;
  
  private static native void setInterface(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException;
  
  private static native void setIpFreeBind(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setIpMulticastLoop(int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException;
  
  private static native void setIpRecvOrigDestAddr(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setIpTransparent(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setSoBusyPoll(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpCork(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpDeferAccept(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpFastOpen(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpFastOpenConnect(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpKeepCnt(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpKeepIdle(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpKeepIntvl(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpMd5Sig(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2)
    throws IOException;
  
  private static native void setTcpNotSentLowAt(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpQuickAck(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpUserTimeout(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTimeToLive(int paramInt1, int paramInt2)
    throws IOException;
  
  private static InetAddress unsafeInetAddrByName(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(paramString);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      throw new ChannelException(paramString);
    }
  }
  
  InetAddress getInterface()
    throws IOException
  {
    Object localObject = getNetworkInterface();
    if (localObject != null)
    {
      localObject = SocketUtils.addressesFromNetworkInterface((NetworkInterface)localObject);
      if (((Enumeration)localObject).hasMoreElements()) {
        return (InetAddress)((Enumeration)localObject).nextElement();
      }
    }
    return null;
  }
  
  NetworkInterface getNetworkInterface()
    throws IOException
  {
    int i = getInterface(intValue(), this.ipv6);
    boolean bool = this.ipv6;
    Object localObject = null;
    InetAddress localInetAddress = null;
    if (bool)
    {
      localObject = localInetAddress;
      if (PlatformDependent.javaVersion() >= 7) {
        localObject = NetworkInterface.getByIndex(i);
      }
      return (NetworkInterface)localObject;
    }
    localInetAddress = inetAddress(i);
    if (localInetAddress != null) {
      localObject = NetworkInterface.getByInetAddress(localInetAddress);
    }
    return (NetworkInterface)localObject;
  }
  
  PeerCredentials getPeerCredentials()
    throws IOException
  {
    return getPeerCredentials(intValue());
  }
  
  int getSoBusyPoll()
    throws IOException
  {
    return getSoBusyPoll(intValue());
  }
  
  int getTcpDeferAccept()
    throws IOException
  {
    return getTcpDeferAccept(intValue());
  }
  
  void getTcpInfo(EpollTcpInfo paramEpollTcpInfo)
    throws IOException
  {
    getTcpInfo(intValue(), paramEpollTcpInfo.info);
  }
  
  int getTcpKeepCnt()
    throws IOException
  {
    return getTcpKeepCnt(intValue());
  }
  
  int getTcpKeepIdle()
    throws IOException
  {
    return getTcpKeepIdle(intValue());
  }
  
  int getTcpKeepIntvl()
    throws IOException
  {
    return getTcpKeepIntvl(intValue());
  }
  
  long getTcpNotSentLowAt()
    throws IOException
  {
    return getTcpNotSentLowAt(intValue()) & 0xFFFFFFFF;
  }
  
  int getTcpUserTimeout()
    throws IOException
  {
    return getTcpUserTimeout(intValue());
  }
  
  int getTimeToLive()
    throws IOException
  {
    return getTimeToLive(intValue());
  }
  
  boolean isIpFreeBind()
    throws IOException
  {
    boolean bool;
    if (isIpFreeBind(intValue()) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isIpRecvOrigDestAddr()
    throws IOException
  {
    boolean bool;
    if (isIpRecvOrigDestAddr(intValue()) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isIpTransparent()
    throws IOException
  {
    boolean bool;
    if (isIpTransparent(intValue()) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isLoopbackModeDisabled()
    throws IOException
  {
    boolean bool;
    if (getIpMulticastLoop(intValue(), this.ipv6) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isTcpCork()
    throws IOException
  {
    boolean bool;
    if (isTcpCork(intValue()) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isTcpFastOpenConnect()
    throws IOException
  {
    boolean bool;
    if (isTcpFastOpenConnect(intValue()) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isTcpQuickAck()
    throws IOException
  {
    boolean bool;
    if (isTcpQuickAck(intValue()) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
    throws IOException
  {
    NativeInetAddress localNativeInetAddress = NativeInetAddress.newInstance(paramInetAddress1);
    paramInetAddress1 = NativeInetAddress.newInstance(deriveInetAddress(paramNetworkInterface, paramInetAddress1 instanceof Inet6Address));
    if (paramInetAddress2 != null)
    {
      paramInetAddress2 = NativeInetAddress.newInstance(paramInetAddress2);
      joinSsmGroup(intValue(), this.ipv6, localNativeInetAddress.address(), paramInetAddress1.address(), localNativeInetAddress.scopeId(), interfaceIndex(paramNetworkInterface), paramInetAddress2.address());
    }
    else
    {
      joinGroup(intValue(), this.ipv6, localNativeInetAddress.address(), paramInetAddress1.address(), localNativeInetAddress.scopeId(), interfaceIndex(paramNetworkInterface));
    }
  }
  
  void leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
    throws IOException
  {
    NativeInetAddress localNativeInetAddress = NativeInetAddress.newInstance(paramInetAddress1);
    paramInetAddress1 = NativeInetAddress.newInstance(deriveInetAddress(paramNetworkInterface, paramInetAddress1 instanceof Inet6Address));
    if (paramInetAddress2 != null)
    {
      paramInetAddress2 = NativeInetAddress.newInstance(paramInetAddress2);
      leaveSsmGroup(intValue(), this.ipv6, localNativeInetAddress.address(), paramInetAddress1.address(), localNativeInetAddress.scopeId(), interfaceIndex(paramNetworkInterface), paramInetAddress2.address());
    }
    else
    {
      leaveGroup(intValue(), this.ipv6, localNativeInetAddress.address(), paramInetAddress1.address(), localNativeInetAddress.scopeId(), interfaceIndex(paramNetworkInterface));
    }
  }
  
  int recvmmsg(NativeDatagramPacketArray.NativeDatagramPacket[] paramArrayOfNativeDatagramPacket, int paramInt1, int paramInt2)
    throws IOException
  {
    return Native.recvmmsg(intValue(), this.ipv6, paramArrayOfNativeDatagramPacket, paramInt1, paramInt2);
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
  
  int sendmmsg(NativeDatagramPacketArray.NativeDatagramPacket[] paramArrayOfNativeDatagramPacket, int paramInt1, int paramInt2)
    throws IOException
  {
    return Native.sendmmsg(intValue(), this.ipv6, paramArrayOfNativeDatagramPacket, paramInt1, paramInt2);
  }
  
  void setInterface(InetAddress paramInetAddress)
    throws IOException
  {
    NativeInetAddress localNativeInetAddress = NativeInetAddress.newInstance(paramInetAddress);
    setInterface(intValue(), this.ipv6, localNativeInetAddress.address(), localNativeInetAddress.scopeId(), interfaceIndex(paramInetAddress));
  }
  
  void setIpFreeBind(boolean paramBoolean)
    throws IOException
  {
    setIpFreeBind(intValue(), paramBoolean);
  }
  
  void setIpRecvOrigDestAddr(boolean paramBoolean)
    throws IOException
  {
    setIpRecvOrigDestAddr(intValue(), paramBoolean);
  }
  
  void setIpTransparent(boolean paramBoolean)
    throws IOException
  {
    setIpTransparent(intValue(), paramBoolean);
  }
  
  void setLoopbackModeDisabled(boolean paramBoolean)
    throws IOException
  {
    setIpMulticastLoop(intValue(), this.ipv6, paramBoolean ^ true);
  }
  
  void setNetworkInterface(NetworkInterface paramNetworkInterface)
    throws IOException
  {
    boolean bool;
    if (family() == InternetProtocolFamily.IPv6) {
      bool = true;
    } else {
      bool = false;
    }
    InetAddress localInetAddress = deriveInetAddress(paramNetworkInterface, bool);
    Object localObject;
    if (family() == InternetProtocolFamily.IPv4) {
      localObject = INET_ANY;
    } else {
      localObject = INET6_ANY;
    }
    if (!localInetAddress.equals(localObject))
    {
      localObject = NativeInetAddress.newInstance(localInetAddress);
      setInterface(intValue(), this.ipv6, ((NativeInetAddress)localObject).address(), ((NativeInetAddress)localObject).scopeId(), interfaceIndex(paramNetworkInterface));
      return;
    }
    paramNetworkInterface = new StringBuilder();
    paramNetworkInterface.append("NetworkInterface does not support ");
    paramNetworkInterface.append(family());
    throw new IOException(paramNetworkInterface.toString());
  }
  
  void setSoBusyPoll(int paramInt)
    throws IOException
  {
    setSoBusyPoll(intValue(), paramInt);
  }
  
  void setTcpCork(boolean paramBoolean)
    throws IOException
  {
    setTcpCork(intValue(), paramBoolean);
  }
  
  void setTcpDeferAccept(int paramInt)
    throws IOException
  {
    setTcpDeferAccept(intValue(), paramInt);
  }
  
  void setTcpFastOpen(int paramInt)
    throws IOException
  {
    setTcpFastOpen(intValue(), paramInt);
  }
  
  void setTcpFastOpenConnect(boolean paramBoolean)
    throws IOException
  {
    setTcpFastOpenConnect(intValue(), paramBoolean);
  }
  
  void setTcpKeepCnt(int paramInt)
    throws IOException
  {
    setTcpKeepCnt(intValue(), paramInt);
  }
  
  void setTcpKeepIdle(int paramInt)
    throws IOException
  {
    setTcpKeepIdle(intValue(), paramInt);
  }
  
  void setTcpKeepIntvl(int paramInt)
    throws IOException
  {
    setTcpKeepIntvl(intValue(), paramInt);
  }
  
  void setTcpMd5Sig(InetAddress paramInetAddress, byte[] paramArrayOfByte)
    throws IOException
  {
    paramInetAddress = NativeInetAddress.newInstance(paramInetAddress);
    setTcpMd5Sig(intValue(), this.ipv6, paramInetAddress.address(), paramInetAddress.scopeId(), paramArrayOfByte);
  }
  
  void setTcpNotSentLowAt(long paramLong)
    throws IOException
  {
    if ((paramLong >= 0L) && (paramLong <= 4294967295L))
    {
      setTcpNotSentLowAt(intValue(), (int)paramLong);
      return;
    }
    throw new IllegalArgumentException("tcpNotSentLowAt must be a uint32_t");
  }
  
  void setTcpQuickAck(boolean paramBoolean)
    throws IOException
  {
    setTcpQuickAck(intValue(), paramBoolean);
  }
  
  void setTcpUserTimeout(int paramInt)
    throws IOException
  {
    setTcpUserTimeout(intValue(), paramInt);
  }
  
  void setTimeToLive(int paramInt)
    throws IOException
  {
    setTimeToLive(intValue(), paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\LinuxSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */