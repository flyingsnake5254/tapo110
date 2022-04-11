package io.netty.channel.unix;

import io.netty.channel.ChannelException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Socket
  extends FileDescriptor
{
  private static final AtomicBoolean INITIALIZED = new AtomicBoolean();
  public static final int UDS_SUN_PATH_SIZE = ;
  protected final boolean ipv6;
  
  public Socket(int paramInt)
  {
    super(paramInt);
    this.ipv6 = isIPv6(paramInt);
  }
  
  private static native int accept(int paramInt, byte[] paramArrayOfByte);
  
  private static native int bind(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private static native int bindDomainSocket(int paramInt, byte[] paramArrayOfByte);
  
  private static native int connect(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private static native int connectDomainSocket(int paramInt, byte[] paramArrayOfByte);
  
  private static native int disconnect(int paramInt, boolean paramBoolean);
  
  private static native int finishConnect(int paramInt);
  
  private static native int getReceiveBufferSize(int paramInt)
    throws IOException;
  
  private static native int getSendBufferSize(int paramInt)
    throws IOException;
  
  private static native int getSoError(int paramInt)
    throws IOException;
  
  private static native int getSoLinger(int paramInt)
    throws IOException;
  
  private static native int getTrafficClass(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public static void initialize()
  {
    if (INITIALIZED.compareAndSet(false, true)) {
      initialize(NetUtil.isIpV4StackPreferred());
    }
  }
  
  private static native void initialize(boolean paramBoolean);
  
  private static native int isBroadcast(int paramInt)
    throws IOException;
  
  private static native boolean isIPv6(int paramInt);
  
  public static native boolean isIPv6Preferred();
  
  private static native int isKeepAlive(int paramInt)
    throws IOException;
  
  private static native int isReuseAddress(int paramInt)
    throws IOException;
  
  private static native int isReusePort(int paramInt)
    throws IOException;
  
  private static native int isTcpNoDelay(int paramInt)
    throws IOException;
  
  private static native int listen(int paramInt1, int paramInt2);
  
  private static native byte[] localAddress(int paramInt);
  
  public static Socket newSocketDgram()
  {
    return new Socket(newSocketDgram0());
  }
  
  protected static int newSocketDgram0()
  {
    return newSocketDgram0(isIPv6Preferred());
  }
  
  protected static int newSocketDgram0(boolean paramBoolean)
  {
    int i = newSocketDgramFd(paramBoolean);
    if (i >= 0) {
      return i;
    }
    throw new ChannelException(Errors.newIOException("newSocketDgram", i));
  }
  
  private static native int newSocketDgramFd(boolean paramBoolean);
  
  public static Socket newSocketDomain()
  {
    return new Socket(newSocketDomain0());
  }
  
  protected static int newSocketDomain0()
  {
    int i = newSocketDomainFd();
    if (i >= 0) {
      return i;
    }
    throw new ChannelException(Errors.newIOException("newSocketDomain", i));
  }
  
  private static native int newSocketDomainFd();
  
  public static Socket newSocketStream()
  {
    return new Socket(newSocketStream0());
  }
  
  protected static int newSocketStream0()
  {
    return newSocketStream0(isIPv6Preferred());
  }
  
  protected static int newSocketStream0(boolean paramBoolean)
  {
    int i = newSocketStreamFd(paramBoolean);
    if (i >= 0) {
      return i;
    }
    throw new ChannelException(Errors.newIOException("newSocketStream", i));
  }
  
  private static native int newSocketStreamFd(boolean paramBoolean);
  
  private static native int recvFd(int paramInt);
  
  private static native DatagramSocketAddress recvFrom(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    throws IOException;
  
  private static native DatagramSocketAddress recvFromAddress(int paramInt1, long paramLong, int paramInt2, int paramInt3)
    throws IOException;
  
  private static native byte[] remoteAddress(int paramInt);
  
  private static native int sendFd(int paramInt1, int paramInt2);
  
  private static native int sendTo(int paramInt1, boolean paramBoolean, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4, int paramInt5);
  
  private static native int sendToAddress(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4, int paramInt5);
  
  private static native int sendToAddresses(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4);
  
  private static native void setBroadcast(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setKeepAlive(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setReceiveBufferSize(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setReuseAddress(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setReusePort(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setSendBufferSize(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setSoLinger(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTcpNoDelay(int paramInt1, int paramInt2)
    throws IOException;
  
  private static native void setTrafficClass(int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException;
  
  private static native int shutdown(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final int accept(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = accept(this.fd, paramArrayOfByte);
    if (i >= 0) {
      return i;
    }
    if ((i != Errors.ERRNO_EAGAIN_NEGATIVE) && (i != Errors.ERRNO_EWOULDBLOCK_NEGATIVE)) {
      throw Errors.newIOException("accept", i);
    }
    return -1;
  }
  
  public final void bind(SocketAddress paramSocketAddress)
    throws IOException
  {
    int i;
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      localObject = (InetSocketAddress)paramSocketAddress;
      paramSocketAddress = NativeInetAddress.newInstance(((InetSocketAddress)localObject).getAddress());
      i = bind(this.fd, this.ipv6, paramSocketAddress.address, paramSocketAddress.scopeId, ((InetSocketAddress)localObject).getPort());
      if (i < 0) {
        throw Errors.newIOException("bind", i);
      }
    }
    else
    {
      if (!(paramSocketAddress instanceof DomainSocketAddress)) {
        break label100;
      }
      paramSocketAddress = (DomainSocketAddress)paramSocketAddress;
      i = bindDomainSocket(this.fd, paramSocketAddress.path().getBytes(CharsetUtil.UTF_8));
      if (i < 0) {
        break label93;
      }
    }
    return;
    label93:
    throw Errors.newIOException("bind", i);
    label100:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected SocketAddress implementation ");
    ((StringBuilder)localObject).append(paramSocketAddress);
    throw new Error(((StringBuilder)localObject).toString());
  }
  
  public final boolean connect(SocketAddress paramSocketAddress)
    throws IOException
  {
    int i;
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      paramSocketAddress = (InetSocketAddress)paramSocketAddress;
      localObject = NativeInetAddress.newInstance(paramSocketAddress.getAddress());
      i = connect(this.fd, this.ipv6, ((NativeInetAddress)localObject).address, ((NativeInetAddress)localObject).scopeId, paramSocketAddress.getPort());
    }
    else
    {
      if (!(paramSocketAddress instanceof DomainSocketAddress)) {
        break label98;
      }
      paramSocketAddress = (DomainSocketAddress)paramSocketAddress;
      i = connectDomainSocket(this.fd, paramSocketAddress.path().getBytes(CharsetUtil.UTF_8));
    }
    if (i < 0)
    {
      if (i == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
        return false;
      }
      Errors.throwConnectException("connect", i);
    }
    return true;
    label98:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected SocketAddress implementation ");
    ((StringBuilder)localObject).append(paramSocketAddress);
    throw new Error(((StringBuilder)localObject).toString());
  }
  
  public final void disconnect()
    throws IOException
  {
    int i = disconnect(this.fd, this.ipv6);
    if (i < 0) {
      Errors.throwConnectException("disconnect", i);
    }
  }
  
  public final boolean finishConnect()
    throws IOException
  {
    int i = finishConnect(this.fd);
    if (i < 0)
    {
      if (i == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
        return false;
      }
      Errors.throwConnectException("finishConnect", i);
    }
    return true;
  }
  
  public final int getReceiveBufferSize()
    throws IOException
  {
    return getReceiveBufferSize(this.fd);
  }
  
  public final int getSendBufferSize()
    throws IOException
  {
    return getSendBufferSize(this.fd);
  }
  
  public final int getSoError()
    throws IOException
  {
    return getSoError(this.fd);
  }
  
  public final int getSoLinger()
    throws IOException
  {
    return getSoLinger(this.fd);
  }
  
  public final int getTrafficClass()
    throws IOException
  {
    return getTrafficClass(this.fd, this.ipv6);
  }
  
  public final boolean isBroadcast()
    throws IOException
  {
    boolean bool;
    if (isBroadcast(this.fd) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isInputShutdown()
  {
    return FileDescriptor.isInputShutdown(this.state);
  }
  
  public final boolean isKeepAlive()
    throws IOException
  {
    boolean bool;
    if (isKeepAlive(this.fd) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isOutputShutdown()
  {
    return FileDescriptor.isOutputShutdown(this.state);
  }
  
  public final boolean isReuseAddress()
    throws IOException
  {
    boolean bool;
    if (isReuseAddress(this.fd) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isReusePort()
    throws IOException
  {
    boolean bool;
    if (isReusePort(this.fd) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isShutdown()
  {
    int i = this.state;
    boolean bool;
    if ((FileDescriptor.isInputShutdown(i)) && (FileDescriptor.isOutputShutdown(i))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isTcpNoDelay()
    throws IOException
  {
    boolean bool;
    if (isTcpNoDelay(this.fd) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void listen(int paramInt)
    throws IOException
  {
    paramInt = listen(this.fd, paramInt);
    if (paramInt >= 0) {
      return;
    }
    throw Errors.newIOException("listen", paramInt);
  }
  
  public final InetSocketAddress localAddress()
  {
    Object localObject = localAddress(this.fd);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = NativeInetAddress.address((byte[])localObject, 0, localObject.length);
    }
    return (InetSocketAddress)localObject;
  }
  
  public final int recvFd()
    throws IOException
  {
    int i = recvFd(this.fd);
    if (i > 0) {
      return i;
    }
    if (i == 0) {
      return -1;
    }
    if ((i != Errors.ERRNO_EAGAIN_NEGATIVE) && (i != Errors.ERRNO_EWOULDBLOCK_NEGATIVE)) {
      throw Errors.newIOException("recvFd", i);
    }
    return 0;
  }
  
  public final DatagramSocketAddress recvFrom(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    throws IOException
  {
    return recvFrom(this.fd, paramByteBuffer, paramInt1, paramInt2);
  }
  
  public final DatagramSocketAddress recvFromAddress(long paramLong, int paramInt1, int paramInt2)
    throws IOException
  {
    return recvFromAddress(this.fd, paramLong, paramInt1, paramInt2);
  }
  
  public final InetSocketAddress remoteAddress()
  {
    Object localObject = remoteAddress(this.fd);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = NativeInetAddress.address((byte[])localObject, 0, localObject.length);
    }
    return (InetSocketAddress)localObject;
  }
  
  public final int sendFd(int paramInt)
    throws IOException
  {
    paramInt = sendFd(this.fd, paramInt);
    if (paramInt >= 0) {
      return paramInt;
    }
    if ((paramInt != Errors.ERRNO_EAGAIN_NEGATIVE) && (paramInt != Errors.ERRNO_EWOULDBLOCK_NEGATIVE)) {
      throw Errors.newIOException("sendFd", paramInt);
    }
    return -1;
  }
  
  public final int sendTo(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, InetAddress paramInetAddress, int paramInt3)
    throws IOException
  {
    int i;
    if ((paramInetAddress instanceof Inet6Address))
    {
      byte[] arrayOfByte = paramInetAddress.getAddress();
      i = ((Inet6Address)paramInetAddress).getScopeId();
      paramInetAddress = arrayOfByte;
    }
    else
    {
      paramInetAddress = NativeInetAddress.ipv4MappedIpv6Address(paramInetAddress.getAddress());
      i = 0;
    }
    paramInt1 = sendTo(this.fd, this.ipv6, paramByteBuffer, paramInt1, paramInt2, paramInetAddress, i, paramInt3);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    if (paramInt1 != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
      return Errors.ioResult("sendTo", paramInt1);
    }
    throw new PortUnreachableException("sendTo failed");
  }
  
  public final int sendToAddress(long paramLong, int paramInt1, int paramInt2, InetAddress paramInetAddress, int paramInt3)
    throws IOException
  {
    int i;
    if ((paramInetAddress instanceof Inet6Address))
    {
      byte[] arrayOfByte = paramInetAddress.getAddress();
      i = ((Inet6Address)paramInetAddress).getScopeId();
      paramInetAddress = arrayOfByte;
    }
    else
    {
      paramInetAddress = NativeInetAddress.ipv4MappedIpv6Address(paramInetAddress.getAddress());
      i = 0;
    }
    paramInt1 = sendToAddress(this.fd, this.ipv6, paramLong, paramInt1, paramInt2, paramInetAddress, i, paramInt3);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    if (paramInt1 != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
      return Errors.ioResult("sendToAddress", paramInt1);
    }
    throw new PortUnreachableException("sendToAddress failed");
  }
  
  public final int sendToAddresses(long paramLong, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    int i;
    if ((paramInetAddress instanceof Inet6Address))
    {
      byte[] arrayOfByte = paramInetAddress.getAddress();
      i = ((Inet6Address)paramInetAddress).getScopeId();
      paramInetAddress = arrayOfByte;
    }
    else
    {
      paramInetAddress = NativeInetAddress.ipv4MappedIpv6Address(paramInetAddress.getAddress());
      i = 0;
    }
    paramInt1 = sendToAddresses(this.fd, this.ipv6, paramLong, paramInt1, paramInetAddress, i, paramInt2);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    if (paramInt1 != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
      return Errors.ioResult("sendToAddresses", paramInt1);
    }
    throw new PortUnreachableException("sendToAddresses failed");
  }
  
  public final void setBroadcast(boolean paramBoolean)
    throws IOException
  {
    setBroadcast(this.fd, paramBoolean);
  }
  
  public final void setKeepAlive(boolean paramBoolean)
    throws IOException
  {
    setKeepAlive(this.fd, paramBoolean);
  }
  
  public final void setReceiveBufferSize(int paramInt)
    throws IOException
  {
    setReceiveBufferSize(this.fd, paramInt);
  }
  
  public final void setReuseAddress(boolean paramBoolean)
    throws IOException
  {
    setReuseAddress(this.fd, paramBoolean);
  }
  
  public final void setReusePort(boolean paramBoolean)
    throws IOException
  {
    setReusePort(this.fd, paramBoolean);
  }
  
  public final void setSendBufferSize(int paramInt)
    throws IOException
  {
    setSendBufferSize(this.fd, paramInt);
  }
  
  public final void setSoLinger(int paramInt)
    throws IOException
  {
    setSoLinger(this.fd, paramInt);
  }
  
  public final void setTcpNoDelay(boolean paramBoolean)
    throws IOException
  {
    setTcpNoDelay(this.fd, paramBoolean);
  }
  
  public final void setTrafficClass(int paramInt)
    throws IOException
  {
    setTrafficClass(this.fd, this.ipv6, paramInt);
  }
  
  public final void shutdown()
    throws IOException
  {
    shutdown(true, true);
  }
  
  public final void shutdown(boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    int i;
    int k;
    do
    {
      i = this.state;
      if (FileDescriptor.isClosed(i)) {
        break;
      }
      if ((paramBoolean1) && (!FileDescriptor.isInputShutdown(i))) {
        j = FileDescriptor.inputShutdown(i);
      } else {
        j = i;
      }
      k = j;
      if (paramBoolean2)
      {
        k = j;
        if (!FileDescriptor.isOutputShutdown(j)) {
          k = FileDescriptor.outputShutdown(j);
        }
      }
      if (k == i) {
        return;
      }
    } while (!casState(i, k));
    int j = shutdown(this.fd, paramBoolean1, paramBoolean2);
    if (j < 0) {
      Errors.ioResult("shutdown", j);
    }
    return;
    throw new ClosedChannelException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Socket{fd=");
    localStringBuilder.append(this.fd);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\Socket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */