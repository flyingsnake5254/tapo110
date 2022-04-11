package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxySOCKS4
  implements Proxy
{
  private static int DEFAULTPORT = 1080;
  private InputStream in;
  private OutputStream out;
  private String passwd;
  private String proxy_host;
  private int proxy_port;
  private Socket socket;
  private String user;
  
  public ProxySOCKS4(String paramString)
  {
    i = DEFAULTPORT;
    j = i;
    String str1 = paramString;
    if (paramString.indexOf(':') != -1) {}
    try
    {
      str1 = paramString.substring(0, paramString.indexOf(':'));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label54:
        j = i;
        String str2 = paramString;
      }
    }
    try
    {
      j = Integer.parseInt(paramString.substring(paramString.indexOf(':') + 1));
      i = j;
    }
    catch (Exception paramString)
    {
      break label54;
    }
    j = i;
    this.proxy_host = str1;
    this.proxy_port = j;
  }
  
  public ProxySOCKS4(String paramString, int paramInt)
  {
    this.proxy_host = paramString;
    this.proxy_port = paramInt;
  }
  
  public static int getDefaultPort()
  {
    return DEFAULTPORT;
  }
  
  public void close()
  {
    try
    {
      Object localObject = this.in;
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
      localObject = this.out;
      if (localObject != null) {
        ((OutputStream)localObject).close();
      }
      localObject = this.socket;
      if (localObject != null) {
        ((Socket)localObject).close();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.in = null;
    this.out = null;
    this.socket = null;
  }
  
  /* Error */
  public void connect(SocketFactory paramSocketFactory, String paramString, int paramInt1, int paramInt2)
    throws JSchException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +44 -> 45
    //   4: aload_0
    //   5: getfield 52	com/jcraft/jsch/ProxySOCKS4:proxy_host	Ljava/lang/String;
    //   8: aload_0
    //   9: getfield 54	com/jcraft/jsch/ProxySOCKS4:proxy_port	I
    //   12: iload 4
    //   14: invokestatic 88	com/jcraft/jsch/Util:createSocket	(Ljava/lang/String;II)Ljava/net/Socket;
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 92	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   28: putfield 60	com/jcraft/jsch/ProxySOCKS4:in	Ljava/io/InputStream;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   36: invokevirtual 96	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   39: putfield 66	com/jcraft/jsch/ProxySOCKS4:out	Ljava/io/OutputStream;
    //   42: goto +51 -> 93
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 52	com/jcraft/jsch/ProxySOCKS4:proxy_host	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 54	com/jcraft/jsch/ProxySOCKS4:proxy_port	I
    //   54: invokeinterface 101 3 0
    //   59: astore 5
    //   61: aload_0
    //   62: aload 5
    //   64: putfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   67: aload_0
    //   68: aload_1
    //   69: aload 5
    //   71: invokeinterface 104 2 0
    //   76: putfield 60	com/jcraft/jsch/ProxySOCKS4:in	Ljava/io/InputStream;
    //   79: aload_0
    //   80: aload_1
    //   81: aload_0
    //   82: getfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   85: invokeinterface 107 2 0
    //   90: putfield 66	com/jcraft/jsch/ProxySOCKS4:out	Ljava/io/OutputStream;
    //   93: iload 4
    //   95: ifle +12 -> 107
    //   98: aload_0
    //   99: getfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   102: iload 4
    //   104: invokevirtual 111	java/net/Socket:setSoTimeout	(I)V
    //   107: aload_0
    //   108: getfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   111: iconst_1
    //   112: invokevirtual 115	java/net/Socket:setTcpNoDelay	(Z)V
    //   115: sipush 1024
    //   118: newarray <illegal type>
    //   120: astore_1
    //   121: iconst_4
    //   122: istore 6
    //   124: aload_1
    //   125: iconst_0
    //   126: iconst_4
    //   127: i2b
    //   128: bastore
    //   129: aload_1
    //   130: iconst_1
    //   131: iconst_1
    //   132: i2b
    //   133: bastore
    //   134: aload_1
    //   135: iconst_2
    //   136: iload_3
    //   137: bipush 8
    //   139: iushr
    //   140: i2b
    //   141: i2b
    //   142: bastore
    //   143: aload_1
    //   144: iconst_3
    //   145: iload_3
    //   146: sipush 255
    //   149: iand
    //   150: i2b
    //   151: i2b
    //   152: bastore
    //   153: aload_2
    //   154: invokestatic 121	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   157: invokevirtual 125	java/net/InetAddress:getAddress	()[B
    //   160: astore_2
    //   161: iconst_0
    //   162: istore 4
    //   164: iload 6
    //   166: istore_3
    //   167: iload 4
    //   169: aload_2
    //   170: arraylength
    //   171: if_icmpge +20 -> 191
    //   174: aload_1
    //   175: iload_3
    //   176: aload_2
    //   177: iload 4
    //   179: baload
    //   180: i2b
    //   181: bastore
    //   182: iinc 4 1
    //   185: iinc 3 1
    //   188: goto -21 -> 167
    //   191: aload_0
    //   192: getfield 127	com/jcraft/jsch/ProxySOCKS4:user	Ljava/lang/String;
    //   195: astore_2
    //   196: iload_3
    //   197: istore 4
    //   199: aload_2
    //   200: ifnull +31 -> 231
    //   203: aload_2
    //   204: invokestatic 131	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   207: iconst_0
    //   208: aload_1
    //   209: iload_3
    //   210: aload_0
    //   211: getfield 127	com/jcraft/jsch/ProxySOCKS4:user	Ljava/lang/String;
    //   214: invokevirtual 134	java/lang/String:length	()I
    //   217: invokestatic 140	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   220: iload_3
    //   221: aload_0
    //   222: getfield 127	com/jcraft/jsch/ProxySOCKS4:user	Ljava/lang/String;
    //   225: invokevirtual 134	java/lang/String:length	()I
    //   228: iadd
    //   229: istore 4
    //   231: aload_1
    //   232: iload 4
    //   234: iconst_0
    //   235: i2b
    //   236: bastore
    //   237: aload_0
    //   238: getfield 66	com/jcraft/jsch/ProxySOCKS4:out	Ljava/io/OutputStream;
    //   241: aload_1
    //   242: iconst_0
    //   243: iload 4
    //   245: iconst_1
    //   246: iadd
    //   247: invokevirtual 144	java/io/OutputStream:write	([BII)V
    //   250: iconst_0
    //   251: istore_3
    //   252: iload_3
    //   253: bipush 8
    //   255: if_icmpge +43 -> 298
    //   258: aload_0
    //   259: getfield 60	com/jcraft/jsch/ProxySOCKS4:in	Ljava/io/InputStream;
    //   262: aload_1
    //   263: iload_3
    //   264: bipush 8
    //   266: iload_3
    //   267: isub
    //   268: invokevirtual 148	java/io/InputStream:read	([BII)I
    //   271: istore 4
    //   273: iload 4
    //   275: ifle +11 -> 286
    //   278: iload_3
    //   279: iload 4
    //   281: iadd
    //   282: istore_3
    //   283: goto -31 -> 252
    //   286: new 78	com/jcraft/jsch/JSchException
    //   289: astore_1
    //   290: aload_1
    //   291: ldc -106
    //   293: invokespecial 152	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   296: aload_1
    //   297: athrow
    //   298: aload_1
    //   299: iconst_0
    //   300: baload
    //   301: ifne +60 -> 361
    //   304: aload_1
    //   305: iconst_1
    //   306: baload
    //   307: istore_3
    //   308: iload_3
    //   309: bipush 90
    //   311: if_icmpne +4 -> 315
    //   314: return
    //   315: aload_0
    //   316: getfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   319: invokevirtual 74	java/net/Socket:close	()V
    //   322: new 154	java/lang/StringBuilder
    //   325: astore_2
    //   326: aload_2
    //   327: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   330: aload_2
    //   331: ldc -99
    //   333: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_2
    //   338: aload_1
    //   339: iconst_1
    //   340: baload
    //   341: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_2
    //   346: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: astore_1
    //   350: new 78	com/jcraft/jsch/JSchException
    //   353: astore_2
    //   354: aload_2
    //   355: aload_1
    //   356: invokespecial 152	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   359: aload_2
    //   360: athrow
    //   361: new 78	com/jcraft/jsch/JSchException
    //   364: astore 5
    //   366: new 154	java/lang/StringBuilder
    //   369: astore_2
    //   370: aload_2
    //   371: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   374: aload_2
    //   375: ldc -86
    //   377: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_2
    //   382: aload_1
    //   383: iconst_0
    //   384: baload
    //   385: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 5
    //   391: aload_2
    //   392: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokespecial 152	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   398: aload 5
    //   400: athrow
    //   401: astore_2
    //   402: new 78	com/jcraft/jsch/JSchException
    //   405: astore 5
    //   407: new 154	java/lang/StringBuilder
    //   410: astore_1
    //   411: aload_1
    //   412: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   415: aload_1
    //   416: ldc -84
    //   418: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_1
    //   423: aload_2
    //   424: invokevirtual 173	java/net/UnknownHostException:toString	()Ljava/lang/String;
    //   427: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 5
    //   433: aload_1
    //   434: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: aload_2
    //   438: invokespecial 176	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload 5
    //   443: athrow
    //   444: astore_1
    //   445: aload_0
    //   446: getfield 71	com/jcraft/jsch/ProxySOCKS4:socket	Ljava/net/Socket;
    //   449: astore_2
    //   450: aload_2
    //   451: ifnull +7 -> 458
    //   454: aload_2
    //   455: invokevirtual 74	java/net/Socket:close	()V
    //   458: new 154	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   465: astore_2
    //   466: aload_2
    //   467: ldc -84
    //   469: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_2
    //   474: aload_1
    //   475: invokevirtual 177	java/lang/Exception:toString	()Ljava/lang/String;
    //   478: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: new 78	com/jcraft/jsch/JSchException
    //   485: dup
    //   486: aload_2
    //   487: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokespecial 152	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   493: athrow
    //   494: astore_1
    //   495: aload_1
    //   496: athrow
    //   497: astore_2
    //   498: goto -176 -> 322
    //   501: astore_2
    //   502: goto -44 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	ProxySOCKS4
    //   0	505	1	paramSocketFactory	SocketFactory
    //   0	505	2	paramString	String
    //   0	505	3	paramInt1	int
    //   0	505	4	paramInt2	int
    //   59	383	5	localObject	Object
    //   122	43	6	i	int
    // Exception table:
    //   from	to	target	type
    //   153	161	401	java/net/UnknownHostException
    //   167	174	401	java/net/UnknownHostException
    //   4	42	444	java/lang/Exception
    //   45	93	444	java/lang/Exception
    //   98	107	444	java/lang/Exception
    //   107	121	444	java/lang/Exception
    //   153	161	444	java/lang/Exception
    //   167	174	444	java/lang/Exception
    //   191	196	444	java/lang/Exception
    //   203	231	444	java/lang/Exception
    //   237	250	444	java/lang/Exception
    //   258	273	444	java/lang/Exception
    //   286	298	444	java/lang/Exception
    //   322	361	444	java/lang/Exception
    //   361	401	444	java/lang/Exception
    //   402	444	444	java/lang/Exception
    //   4	42	494	java/lang/RuntimeException
    //   45	93	494	java/lang/RuntimeException
    //   98	107	494	java/lang/RuntimeException
    //   107	121	494	java/lang/RuntimeException
    //   153	161	494	java/lang/RuntimeException
    //   167	174	494	java/lang/RuntimeException
    //   191	196	494	java/lang/RuntimeException
    //   203	231	494	java/lang/RuntimeException
    //   237	250	494	java/lang/RuntimeException
    //   258	273	494	java/lang/RuntimeException
    //   286	298	494	java/lang/RuntimeException
    //   322	361	494	java/lang/RuntimeException
    //   361	401	494	java/lang/RuntimeException
    //   402	444	494	java/lang/RuntimeException
    //   315	322	497	java/lang/Exception
    //   445	450	501	java/lang/Exception
    //   454	458	501	java/lang/Exception
  }
  
  public InputStream getInputStream()
  {
    return this.in;
  }
  
  public OutputStream getOutputStream()
  {
    return this.out;
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  public void setUserPasswd(String paramString1, String paramString2)
  {
    this.user = paramString1;
    this.passwd = paramString2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ProxySOCKS4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */