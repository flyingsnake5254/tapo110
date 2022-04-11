package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

class PortWatcher
  implements Runnable
{
  private static InetAddress anyLocalAddress = null;
  private static Vector pool = new Vector();
  InetAddress boundaddress;
  int connectTimeout = 0;
  String host;
  int lport;
  int rport;
  Session session;
  ServerSocket ss;
  Runnable thread;
  
  static
  {
    try
    {
      anyLocalAddress = InetAddress.getByName("0.0.0.0");
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;) {}
    }
  }
  
  PortWatcher(Session paramSession, String paramString1, int paramInt1, String paramString2, int paramInt2, ServerSocketFactory paramServerSocketFactory)
    throws JSchException
  {
    this.session = paramSession;
    this.lport = paramInt1;
    this.host = paramString2;
    this.rport = paramInt2;
    try
    {
      paramSession = InetAddress.getByName(paramString1);
      this.boundaddress = paramSession;
      if (paramServerSocketFactory == null)
      {
        paramSession = new java/net/ServerSocket;
        paramSession.<init>(paramInt1, 0, this.boundaddress);
      }
      else
      {
        paramSession = paramServerSocketFactory.createServerSocket(paramInt1, 0, paramSession);
      }
      this.ss = paramSession;
      if (paramInt1 == 0)
      {
        paramInt1 = paramSession.getLocalPort();
        if (paramInt1 != -1) {
          this.lport = paramInt1;
        }
      }
      return;
    }
    catch (Exception paramSession)
    {
      paramString2 = new StringBuilder();
      paramString2.append("PortForwardingL: local port ");
      paramString2.append(paramString1);
      paramString2.append(":");
      paramString2.append(paramInt1);
      paramString2.append(" cannot be bound.");
      throw new JSchException(paramString2.toString(), paramSession);
    }
  }
  
  static PortWatcher addPort(Session paramSession, String paramString1, int paramInt1, String paramString2, int paramInt2, ServerSocketFactory paramServerSocketFactory)
    throws JSchException
  {
    paramString1 = normalize(paramString1);
    if (getPort(paramSession, paramString1, paramInt1) == null)
    {
      paramSession = new PortWatcher(paramSession, paramString1, paramInt1, paramString2, paramInt2, paramServerSocketFactory);
      pool.addElement(paramSession);
      return paramSession;
    }
    paramSession = new StringBuilder();
    paramSession.append("PortForwardingL: local port ");
    paramSession.append(paramString1);
    paramSession.append(":");
    paramSession.append(paramInt1);
    paramSession.append(" is already registered.");
    throw new JSchException(paramSession.toString());
  }
  
  static void delPort(Session paramSession)
  {
    synchronized (pool)
    {
      PortWatcher[] arrayOfPortWatcher = new PortWatcher[pool.size()];
      int i = 0;
      int j = 0;
      int m;
      for (int k = 0;; k = m)
      {
        m = i;
        if (j >= pool.size()) {
          break;
        }
        PortWatcher localPortWatcher = (PortWatcher)pool.elementAt(j);
        m = k;
        if (localPortWatcher.session == paramSession)
        {
          localPortWatcher.delete();
          arrayOfPortWatcher[k] = localPortWatcher;
          m = k + 1;
        }
        j++;
      }
      while (m < k)
      {
        paramSession = arrayOfPortWatcher[m];
        pool.removeElement(paramSession);
        m++;
      }
      return;
    }
  }
  
  static void delPort(Session paramSession, String paramString, int paramInt)
    throws JSchException
  {
    paramString = normalize(paramString);
    paramSession = getPort(paramSession, paramString, paramInt);
    if (paramSession != null)
    {
      paramSession.delete();
      pool.removeElement(paramSession);
      return;
    }
    paramSession = new StringBuilder();
    paramSession.append("PortForwardingL: local port ");
    paramSession.append(paramString);
    paramSession.append(":");
    paramSession.append(paramInt);
    paramSession.append(" is not registered.");
    throw new JSchException(paramSession.toString());
  }
  
  /* Error */
  static PortWatcher getPort(Session paramSession, String paramString, int paramInt)
    throws JSchException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 44	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   4: astore_3
    //   5: getstatic 34	com/jcraft/jsch/PortWatcher:pool	Ljava/util/Vector;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: iconst_0
    //   12: istore 4
    //   14: iload 4
    //   16: getstatic 34	com/jcraft/jsch/PortWatcher:pool	Ljava/util/Vector;
    //   19: invokevirtual 130	java/util/Vector:size	()I
    //   22: if_icmpge +80 -> 102
    //   25: getstatic 34	com/jcraft/jsch/PortWatcher:pool	Ljava/util/Vector;
    //   28: iload 4
    //   30: invokevirtual 134	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   33: checkcast 2	com/jcraft/jsch/PortWatcher
    //   36: astore 5
    //   38: aload 5
    //   40: getfield 55	com/jcraft/jsch/PortWatcher:session	Lcom/jcraft/jsch/Session;
    //   43: aload_0
    //   44: if_acmpne +52 -> 96
    //   47: aload 5
    //   49: getfield 57	com/jcraft/jsch/PortWatcher:lport	I
    //   52: iload_2
    //   53: if_icmpne +43 -> 96
    //   56: getstatic 36	com/jcraft/jsch/PortWatcher:anyLocalAddress	Ljava/net/InetAddress;
    //   59: astore 6
    //   61: aload 6
    //   63: ifnull +16 -> 79
    //   66: aload 5
    //   68: getfield 63	com/jcraft/jsch/PortWatcher:boundaddress	Ljava/net/InetAddress;
    //   71: aload 6
    //   73: invokevirtual 147	java/net/InetAddress:equals	(Ljava/lang/Object;)Z
    //   76: ifne +15 -> 91
    //   79: aload 5
    //   81: getfield 63	com/jcraft/jsch/PortWatcher:boundaddress	Ljava/net/InetAddress;
    //   84: aload_3
    //   85: invokevirtual 147	java/net/InetAddress:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +8 -> 96
    //   91: aload_1
    //   92: monitorexit
    //   93: aload 5
    //   95: areturn
    //   96: iinc 4 1
    //   99: goto -85 -> 14
    //   102: aload_1
    //   103: monitorexit
    //   104: aconst_null
    //   105: areturn
    //   106: astore_0
    //   107: aload_1
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: new 82	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   119: astore_3
    //   120: aload_3
    //   121: ldc -107
    //   123: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_3
    //   128: aload_1
    //   129: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_3
    //   134: ldc -105
    //   136: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: new 48	com/jcraft/jsch/JSchException
    //   143: dup
    //   144: aload_3
    //   145: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: aload_0
    //   149: invokespecial 103	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramSession	Session
    //   0	153	1	paramString	String
    //   0	153	2	paramInt	int
    //   4	141	3	localObject	Object
    //   12	85	4	i	int
    //   36	58	5	localPortWatcher	PortWatcher
    //   59	13	6	localInetAddress	InetAddress
    // Exception table:
    //   from	to	target	type
    //   14	61	106	finally
    //   66	79	106	finally
    //   79	91	106	finally
    //   91	93	106	finally
    //   102	104	106	finally
    //   107	109	106	finally
    //   0	5	111	java/net/UnknownHostException
  }
  
  static String[] getPortForwarding(Session paramSession)
  {
    Vector localVector1 = new Vector();
    Vector localVector2 = pool;
    int i = 0;
    int j = 0;
    try
    {
      while (j < pool.size())
      {
        PortWatcher localPortWatcher = (PortWatcher)pool.elementAt(j);
        if (localPortWatcher.session == paramSession)
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(localPortWatcher.lport);
          localStringBuilder.append(":");
          localStringBuilder.append(localPortWatcher.host);
          localStringBuilder.append(":");
          localStringBuilder.append(localPortWatcher.rport);
          localVector1.addElement(localStringBuilder.toString());
        }
        j++;
      }
      paramSession = new String[localVector1.size()];
      for (j = i; j < localVector1.size(); j++) {
        paramSession[j] = ((String)localVector1.elementAt(j));
      }
      return paramSession;
    }
    finally {}
  }
  
  private static String normalize(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      if ((paramString.length() != 0) && (!paramString.equals("*")))
      {
        str = paramString;
        if (paramString.equals("localhost")) {
          str = "127.0.0.1";
        }
      }
      else
      {
        str = "0.0.0.0";
      }
    }
    return str;
  }
  
  void delete()
  {
    this.thread = null;
    try
    {
      ServerSocket localServerSocket = this.ss;
      if (localServerSocket != null) {
        localServerSocket.close();
      }
      this.ss = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void run()
  {
    this.thread = this;
    try
    {
      while (this.thread != null)
      {
        Socket localSocket = this.ss.accept();
        localSocket.setTcpNoDelay(true);
        InputStream localInputStream = localSocket.getInputStream();
        OutputStream localOutputStream = localSocket.getOutputStream();
        ChannelDirectTCPIP localChannelDirectTCPIP = new com/jcraft/jsch/ChannelDirectTCPIP;
        localChannelDirectTCPIP.<init>();
        localChannelDirectTCPIP.init();
        localChannelDirectTCPIP.setInputStream(localInputStream);
        localChannelDirectTCPIP.setOutputStream(localOutputStream);
        this.session.addChannel(localChannelDirectTCPIP);
        localChannelDirectTCPIP.setHost(this.host);
        localChannelDirectTCPIP.setPort(this.rport);
        localChannelDirectTCPIP.setOrgIPAddress(localSocket.getInetAddress().getHostAddress());
        localChannelDirectTCPIP.setOrgPort(localSocket.getPort());
        localChannelDirectTCPIP.connect(this.connectTimeout);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    delete();
  }
  
  void setConnectTimeout(int paramInt)
  {
    this.connectTimeout = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\PortWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */