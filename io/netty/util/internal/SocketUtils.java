package io.netty.util.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.Enumeration;

public final class SocketUtils
{
  private static final Enumeration<Object> EMPTY = Collections.enumeration(Collections.emptyList());
  
  public static SocketChannel accept(ServerSocketChannel paramServerSocketChannel)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local5 = new io/netty/util/internal/SocketUtils$5;
      local5.<init>(paramServerSocketChannel);
      paramServerSocketChannel = (SocketChannel)AccessController.doPrivileged(local5);
      return paramServerSocketChannel;
    }
    catch (PrivilegedActionException paramServerSocketChannel)
    {
      throw ((IOException)paramServerSocketChannel.getCause());
    }
  }
  
  public static InetAddress addressByName(String paramString)
    throws UnknownHostException
  {
    try
    {
      PrivilegedExceptionAction local8 = new io/netty/util/internal/SocketUtils$8;
      local8.<init>(paramString);
      paramString = (InetAddress)AccessController.doPrivileged(local8);
      return paramString;
    }
    catch (PrivilegedActionException paramString)
    {
      throw ((UnknownHostException)paramString.getCause());
    }
  }
  
  public static Enumeration<InetAddress> addressesFromNetworkInterface(NetworkInterface paramNetworkInterface)
  {
    Enumeration localEnumeration = (Enumeration)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Enumeration<InetAddress> run()
      {
        return this.val$intf.getInetAddresses();
      }
    });
    paramNetworkInterface = localEnumeration;
    if (localEnumeration == null) {
      paramNetworkInterface = empty();
    }
    return paramNetworkInterface;
  }
  
  public static InetAddress[] allAddressesByName(String paramString)
    throws UnknownHostException
  {
    try
    {
      PrivilegedExceptionAction local9 = new io/netty/util/internal/SocketUtils$9;
      local9.<init>(paramString);
      paramString = (InetAddress[])AccessController.doPrivileged(local9);
      return paramString;
    }
    catch (PrivilegedActionException paramString)
    {
      throw ((UnknownHostException)paramString.getCause());
    }
  }
  
  public static void bind(Socket paramSocket, SocketAddress paramSocketAddress)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local2 = new io/netty/util/internal/SocketUtils$2;
      local2.<init>(paramSocket, paramSocketAddress);
      AccessController.doPrivileged(local2);
      return;
    }
    catch (PrivilegedActionException paramSocket)
    {
      throw ((IOException)paramSocket.getCause());
    }
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public static void bind(DatagramChannel paramDatagramChannel, SocketAddress paramSocketAddress)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local6 = new io/netty/util/internal/SocketUtils$6;
      local6.<init>(paramDatagramChannel, paramSocketAddress);
      AccessController.doPrivileged(local6);
      return;
    }
    catch (PrivilegedActionException paramDatagramChannel)
    {
      throw ((IOException)paramDatagramChannel.getCause());
    }
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public static void bind(SocketChannel paramSocketChannel, SocketAddress paramSocketAddress)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local4 = new io/netty/util/internal/SocketUtils$4;
      local4.<init>(paramSocketChannel, paramSocketAddress);
      AccessController.doPrivileged(local4);
      return;
    }
    catch (PrivilegedActionException paramSocketChannel)
    {
      throw ((IOException)paramSocketChannel.getCause());
    }
  }
  
  public static void connect(Socket paramSocket, SocketAddress paramSocketAddress, int paramInt)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local1 = new io/netty/util/internal/SocketUtils$1;
      local1.<init>(paramSocket, paramSocketAddress, paramInt);
      AccessController.doPrivileged(local1);
      return;
    }
    catch (PrivilegedActionException paramSocket)
    {
      throw ((IOException)paramSocket.getCause());
    }
  }
  
  public static boolean connect(SocketChannel paramSocketChannel, SocketAddress paramSocketAddress)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local3 = new io/netty/util/internal/SocketUtils$3;
      local3.<init>(paramSocketChannel, paramSocketAddress);
      boolean bool = ((Boolean)AccessController.doPrivileged(local3)).booleanValue();
      return bool;
    }
    catch (PrivilegedActionException paramSocketChannel)
    {
      throw ((IOException)paramSocketChannel.getCause());
    }
  }
  
  private static <T> Enumeration<T> empty()
  {
    return EMPTY;
  }
  
  public static byte[] hardwareAddressFromNetworkInterface(NetworkInterface paramNetworkInterface)
    throws SocketException
  {
    try
    {
      PrivilegedExceptionAction local13 = new io/netty/util/internal/SocketUtils$13;
      local13.<init>(paramNetworkInterface);
      paramNetworkInterface = (byte[])AccessController.doPrivileged(local13);
      return paramNetworkInterface;
    }
    catch (PrivilegedActionException paramNetworkInterface)
    {
      throw ((SocketException)paramNetworkInterface.getCause());
    }
  }
  
  public static SocketAddress localSocketAddress(ServerSocket paramServerSocket)
  {
    (SocketAddress)AccessController.doPrivileged(new PrivilegedAction()
    {
      public SocketAddress run()
      {
        return this.val$socket.getLocalSocketAddress();
      }
    });
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public static InetAddress loopbackAddress()
  {
    (InetAddress)AccessController.doPrivileged(new PrivilegedAction()
    {
      public InetAddress run()
      {
        if (PlatformDependent.javaVersion() >= 7) {
          return InetAddress.getLoopbackAddress();
        }
        try
        {
          InetAddress localInetAddress = InetAddress.getByName(null);
          return localInetAddress;
        }
        catch (UnknownHostException localUnknownHostException)
        {
          throw new IllegalStateException(localUnknownHostException);
        }
      }
    });
  }
  
  public static InetSocketAddress socketAddress(String paramString, final int paramInt)
  {
    (InetSocketAddress)AccessController.doPrivileged(new PrivilegedAction()
    {
      public InetSocketAddress run()
      {
        return new InetSocketAddress(this.val$hostname, paramInt);
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\SocketUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */