package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.net.Socket;
import java.util.Vector;

public class ChannelForwardedTCPIP
  extends Channel
{
  private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
  private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
  private static final int TIMEOUT = 10000;
  private static Vector pool = new Vector();
  private Config config = null;
  private ForwardedTCPIPDaemon daemon = null;
  private Socket socket = null;
  
  ChannelForwardedTCPIP()
  {
    setLocalWindowSizeMax(131072);
    setLocalWindowSize(131072);
    setLocalPacketSize(16384);
    this.io = new IO();
    this.connected = true;
  }
  
  static void addPort(Session paramSession, String arg1, int paramInt1, int paramInt2, String paramString2, int paramInt3, SocketFactory paramSocketFactory)
    throws JSchException
  {
    String str = normalize(???);
    synchronized (pool)
    {
      if (getPort(paramSession, str, paramInt1) == null)
      {
        ConfigLHost localConfigLHost = new com/jcraft/jsch/ChannelForwardedTCPIP$ConfigLHost;
        localConfigLHost.<init>();
        localConfigLHost.session = paramSession;
        localConfigLHost.rport = paramInt1;
        localConfigLHost.allocated_rport = paramInt2;
        localConfigLHost.target = paramString2;
        localConfigLHost.lport = paramInt3;
        localConfigLHost.address_to_bind = str;
        localConfigLHost.factory = paramSocketFactory;
        pool.addElement(localConfigLHost);
        return;
      }
      paramString2 = new com/jcraft/jsch/JSchException;
      paramSession = new java/lang/StringBuilder;
      paramSession.<init>();
      paramSession.append("PortForwardingR: remote port ");
      paramSession.append(paramInt1);
      paramSession.append(" is already registered.");
      paramString2.<init>(paramSession.toString());
      throw paramString2;
    }
  }
  
  static void addPort(Session paramSession, String arg1, int paramInt1, int paramInt2, String paramString2, Object[] paramArrayOfObject)
    throws JSchException
  {
    String str = normalize(???);
    synchronized (pool)
    {
      if (getPort(paramSession, str, paramInt1) == null)
      {
        ConfigDaemon localConfigDaemon = new com/jcraft/jsch/ChannelForwardedTCPIP$ConfigDaemon;
        localConfigDaemon.<init>();
        localConfigDaemon.session = paramSession;
        localConfigDaemon.rport = paramInt1;
        localConfigDaemon.allocated_rport = paramInt1;
        localConfigDaemon.target = paramString2;
        localConfigDaemon.arg = paramArrayOfObject;
        localConfigDaemon.address_to_bind = str;
        pool.addElement(localConfigDaemon);
        return;
      }
      paramString2 = new com/jcraft/jsch/JSchException;
      paramSession = new java/lang/StringBuilder;
      paramSession.<init>();
      paramSession.append("PortForwardingR: remote port ");
      paramSession.append(paramInt1);
      paramSession.append(" is already registered.");
      paramString2.<init>(paramSession.toString());
      throw paramString2;
    }
  }
  
  static void delPort(ChannelForwardedTCPIP paramChannelForwardedTCPIP)
  {
    Session localSession2;
    try
    {
      Session localSession1 = paramChannelForwardedTCPIP.getSession();
    }
    catch (JSchException localJSchException)
    {
      localSession2 = null;
    }
    if (localSession2 != null)
    {
      paramChannelForwardedTCPIP = paramChannelForwardedTCPIP.config;
      if (paramChannelForwardedTCPIP != null) {
        delPort(localSession2, paramChannelForwardedTCPIP.rport);
      }
    }
  }
  
  static void delPort(Session paramSession)
  {
    synchronized (pool)
    {
      int[] arrayOfInt = new int[pool.size()];
      int i = 0;
      int j = 0;
      int m;
      for (int k = 0; j < pool.size(); k = m)
      {
        Config localConfig = (Config)pool.elementAt(j);
        m = k;
        if (localConfig.session == paramSession)
        {
          arrayOfInt[k] = localConfig.rport;
          m = k + 1;
        }
        j++;
      }
      for (j = i; j < k; j++) {
        delPort(paramSession, arrayOfInt[j]);
      }
      return;
    }
  }
  
  static void delPort(Session paramSession, int paramInt)
  {
    delPort(paramSession, null, paramInt);
  }
  
  static void delPort(Session paramSession, String paramString, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    synchronized (pool)
    {
      localObject1 = getPort(paramSession, normalize(paramString), paramInt);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getPort(paramSession, null, paramInt);
      }
      if (localObject2 == null) {
        return;
      }
      pool.removeElement(localObject2);
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = ((Config)localObject2).address_to_bind;
      }
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "0.0.0.0";
      }
      localObject2 = new Buffer(100);
      localObject1 = new Packet((Buffer)localObject2);
    }
    try
    {
      ((Packet)localObject1).reset();
      ((Buffer)localObject2).putByte((byte)80);
      ((Buffer)localObject2).putString(Util.str2byte("cancel-tcpip-forward"));
      ((Buffer)localObject2).putByte((byte)0);
      ((Buffer)localObject2).putString(Util.str2byte(paramString));
      ((Buffer)localObject2).putInt(paramInt);
      paramSession.write((Packet)localObject1);
      return;
      paramSession = finally;
      throw paramSession;
    }
    catch (Exception paramSession)
    {
      for (;;) {}
    }
  }
  
  private static Config getPort(Session paramSession, String paramString, int paramInt)
  {
    Vector localVector = pool;
    int i = 0;
    try
    {
      while (i < pool.size())
      {
        Config localConfig = (Config)pool.elementAt(i);
        if (localConfig.session == paramSession)
        {
          int j = localConfig.rport;
          if (((j == paramInt) || ((j == 0) && (localConfig.allocated_rport == paramInt))) && ((paramString == null) || (localConfig.address_to_bind.equals(paramString)))) {}
        }
        else
        {
          i++;
          continue;
        }
        return localConfig;
      }
      return null;
    }
    finally {}
  }
  
  static String[] getPortForwarding(Session paramSession)
  {
    paramSession = new Vector();
    Object localObject = pool;
    int i = 0;
    int j = 0;
    try
    {
      while (j < pool.size())
      {
        Config localConfig = (Config)pool.elementAt(j);
        StringBuilder localStringBuilder;
        if ((localConfig instanceof ConfigDaemon))
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(localConfig.allocated_rport);
          localStringBuilder.append(":");
          localStringBuilder.append(localConfig.target);
          localStringBuilder.append(":");
          paramSession.addElement(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(localConfig.allocated_rport);
          localStringBuilder.append(":");
          localStringBuilder.append(localConfig.target);
          localStringBuilder.append(":");
          localStringBuilder.append(((ConfigLHost)localConfig).lport);
          paramSession.addElement(localStringBuilder.toString());
        }
        j++;
      }
      localObject = new String[paramSession.size()];
      for (j = i; j < paramSession.size(); j++) {
        localObject[j] = ((String)paramSession.elementAt(j));
      }
      return (String[])localObject;
    }
    finally {}
  }
  
  static String normalize(String paramString)
  {
    if (paramString == null) {
      return "localhost";
    }
    if ((paramString.length() != 0) && (!paramString.equals("*"))) {
      return paramString;
    }
    return "";
  }
  
  private void setSocketFactory(SocketFactory paramSocketFactory)
  {
    Config localConfig = this.config;
    if ((localConfig != null) && ((localConfig instanceof ConfigLHost))) {
      ((ConfigLHost)localConfig).factory = paramSocketFactory;
    }
  }
  
  void getData(Buffer paramBuffer)
  {
    setRecipient(paramBuffer.getInt());
    setRemoteWindowSize(paramBuffer.getUInt());
    setRemotePacketSize(paramBuffer.getInt());
    byte[] arrayOfByte = paramBuffer.getString();
    int i = paramBuffer.getInt();
    paramBuffer.getString();
    paramBuffer.getInt();
    try
    {
      paramBuffer = getSession();
    }
    catch (JSchException paramBuffer)
    {
      paramBuffer = null;
    }
    Object localObject = getPort(paramBuffer, Util.byte2str(arrayOfByte), i);
    this.config = ((Config)localObject);
    if (localObject == null) {
      this.config = getPort(paramBuffer, null, i);
    }
    if ((this.config == null) && (JSch.getLogger().isEnabled(3)))
    {
      localObject = JSch.getLogger();
      paramBuffer = new StringBuilder();
      paramBuffer.append("ChannelForwardedTCPIP: ");
      paramBuffer.append(Util.byte2str(arrayOfByte));
      paramBuffer.append(":");
      paramBuffer.append(i);
      paramBuffer.append(" is not registered.");
      ((Logger)localObject).log(3, paramBuffer.toString());
    }
  }
  
  public int getRemotePort()
  {
    Config localConfig = this.config;
    int i;
    if (localConfig != null) {
      i = localConfig.rport;
    } else {
      i = 0;
    }
    return i;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.config;
        if ((localObject1 instanceof ConfigDaemon))
        {
          localObject3 = (ConfigDaemon)localObject1;
          this.daemon = ((ForwardedTCPIPDaemon)Class.forName(((Config)localObject3).target).newInstance());
          localObject1 = new java/io/PipedOutputStream;
          ((PipedOutputStream)localObject1).<init>();
          localObject4 = this.io;
          localObject5 = new com/jcraft/jsch/Channel$PassiveInputStream;
          ((Channel.PassiveInputStream)localObject5).<init>(this, (PipedOutputStream)localObject1, 32768);
          ((IO)localObject4).setInputStream((InputStream)localObject5, false);
          this.daemon.setChannel(this, getInputStream(), (OutputStream)localObject1);
          this.daemon.setArg(((ConfigDaemon)localObject3).arg);
          localObject1 = new java/lang/Thread;
          ((Thread)localObject1).<init>(this.daemon);
          ((Thread)localObject1).start();
        }
        else
        {
          localObject3 = (ConfigLHost)localObject1;
          localObject1 = ((ConfigLHost)localObject3).factory;
          if (localObject1 == null) {
            localObject1 = Util.createSocket(((Config)localObject3).target, ((ConfigLHost)localObject3).lport, 10000);
          } else {
            localObject1 = ((SocketFactory)localObject1).createSocket(((Config)localObject3).target, ((ConfigLHost)localObject3).lport);
          }
          this.socket = ((Socket)localObject1);
          ((Socket)localObject1).setTcpNoDelay(true);
          this.io.setInputStream(this.socket.getInputStream());
          this.io.setOutputStream(this.socket.getOutputStream());
        }
        sendOpenConfirmation();
        this.thread = Thread.currentThread();
        localObject1 = new Buffer(this.rmpsize);
        localObject3 = new Packet((Buffer)localObject1);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        sendOpenFailure(1);
        this.close = true;
        disconnect();
        return;
      }
      try
      {
        localObject4 = getSession();
        if (this.thread != null)
        {
          localObject5 = this.io;
          if (localObject5 != null)
          {
            localObject5 = ((IO)localObject5).in;
            if (localObject5 != null)
            {
              byte[] arrayOfByte = ((Buffer)localObject1).buffer;
              int i = ((InputStream)localObject5).read(arrayOfByte, 14, arrayOfByte.length - 14 - 128);
              if (i <= 0)
              {
                eof();
              }
              else
              {
                ((Packet)localObject3).reset();
                ((Buffer)localObject1).putByte((byte)94);
                ((Buffer)localObject1).putInt(this.recipient);
                ((Buffer)localObject1).putInt(i);
                ((Buffer)localObject1).skip(i);
                try
                {
                  if (this.close) {}
                  ((Session)localObject4).write((Packet)localObject3, this, i);
                }
                finally {}
              }
            }
          }
        }
      }
      catch (Exception localException2) {}
    }
    disconnect();
  }
  
  static abstract class Config
  {
    String address_to_bind;
    int allocated_rport;
    int rport;
    Session session;
    String target;
  }
  
  static class ConfigDaemon
    extends ChannelForwardedTCPIP.Config
  {
    Object[] arg;
  }
  
  static class ConfigLHost
    extends ChannelForwardedTCPIP.Config
  {
    SocketFactory factory;
    int lport;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelForwardedTCPIP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */