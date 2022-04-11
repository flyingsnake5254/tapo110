package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxySOCKS5
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
  
  public ProxySOCKS5(String paramString)
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
  
  public ProxySOCKS5(String paramString, int paramInt)
  {
    this.proxy_host = paramString;
    this.proxy_port = paramInt;
  }
  
  private void fill(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
    throws JSchException, IOException
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(paramArrayOfByte, i, paramInt - i);
      if (j > 0) {
        i += j;
      } else {
        throw new JSchException("ProxySOCKS5: stream is closed");
      }
    }
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
    //   5: getfield 52	com/jcraft/jsch/ProxySOCKS5:proxy_host	Ljava/lang/String;
    //   8: aload_0
    //   9: getfield 54	com/jcraft/jsch/ProxySOCKS5:proxy_port	I
    //   12: iload 4
    //   14: invokestatic 99	com/jcraft/jsch/Util:createSocket	(Ljava/lang/String;II)Ljava/net/Socket;
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 103	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   28: putfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   36: invokevirtual 107	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   39: putfield 81	com/jcraft/jsch/ProxySOCKS5:out	Ljava/io/OutputStream;
    //   42: goto +51 -> 93
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 52	com/jcraft/jsch/ProxySOCKS5:proxy_host	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 54	com/jcraft/jsch/ProxySOCKS5:proxy_port	I
    //   54: invokeinterface 112 3 0
    //   59: astore 5
    //   61: aload_0
    //   62: aload 5
    //   64: putfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   67: aload_0
    //   68: aload_1
    //   69: aload 5
    //   71: invokeinterface 115 2 0
    //   76: putfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   79: aload_0
    //   80: aload_1
    //   81: aload_0
    //   82: getfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   85: invokeinterface 118 2 0
    //   90: putfield 81	com/jcraft/jsch/ProxySOCKS5:out	Ljava/io/OutputStream;
    //   93: iload 4
    //   95: ifle +12 -> 107
    //   98: aload_0
    //   99: getfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   102: iload 4
    //   104: invokevirtual 122	java/net/Socket:setSoTimeout	(I)V
    //   107: aload_0
    //   108: getfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   111: iconst_1
    //   112: invokevirtual 126	java/net/Socket:setTcpNoDelay	(Z)V
    //   115: sipush 1024
    //   118: newarray <illegal type>
    //   120: astore_1
    //   121: aload_1
    //   122: iconst_0
    //   123: iconst_5
    //   124: i2b
    //   125: bastore
    //   126: aload_1
    //   127: iconst_1
    //   128: iconst_2
    //   129: i2b
    //   130: bastore
    //   131: aload_1
    //   132: iconst_2
    //   133: iconst_0
    //   134: i2b
    //   135: bastore
    //   136: aload_1
    //   137: iconst_3
    //   138: iconst_2
    //   139: i2b
    //   140: bastore
    //   141: aload_0
    //   142: getfield 81	com/jcraft/jsch/ProxySOCKS5:out	Ljava/io/OutputStream;
    //   145: aload_1
    //   146: iconst_0
    //   147: iconst_4
    //   148: invokevirtual 130	java/io/OutputStream:write	([BII)V
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   156: aload_1
    //   157: iconst_2
    //   158: invokespecial 132	com/jcraft/jsch/ProxySOCKS5:fill	(Ljava/io/InputStream;[BI)V
    //   161: aload_1
    //   162: iconst_1
    //   163: baload
    //   164: sipush 255
    //   167: iand
    //   168: istore 4
    //   170: iload 4
    //   172: ifeq +167 -> 339
    //   175: iload 4
    //   177: iconst_2
    //   178: if_icmpeq +6 -> 184
    //   181: goto +152 -> 333
    //   184: aload_0
    //   185: getfield 134	com/jcraft/jsch/ProxySOCKS5:user	Ljava/lang/String;
    //   188: astore 5
    //   190: aload 5
    //   192: ifnull +141 -> 333
    //   195: aload_0
    //   196: getfield 136	com/jcraft/jsch/ProxySOCKS5:passwd	Ljava/lang/String;
    //   199: ifnonnull +6 -> 205
    //   202: goto +131 -> 333
    //   205: aload_1
    //   206: iconst_0
    //   207: iconst_1
    //   208: i2b
    //   209: bastore
    //   210: aload_1
    //   211: iconst_1
    //   212: aload 5
    //   214: invokevirtual 139	java/lang/String:length	()I
    //   217: i2b
    //   218: i2b
    //   219: bastore
    //   220: aload_0
    //   221: getfield 134	com/jcraft/jsch/ProxySOCKS5:user	Ljava/lang/String;
    //   224: invokestatic 143	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   227: iconst_0
    //   228: aload_1
    //   229: iconst_2
    //   230: aload_0
    //   231: getfield 134	com/jcraft/jsch/ProxySOCKS5:user	Ljava/lang/String;
    //   234: invokevirtual 139	java/lang/String:length	()I
    //   237: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   240: aload_0
    //   241: getfield 134	com/jcraft/jsch/ProxySOCKS5:user	Ljava/lang/String;
    //   244: invokevirtual 139	java/lang/String:length	()I
    //   247: iconst_2
    //   248: iadd
    //   249: istore 6
    //   251: iload 6
    //   253: iconst_1
    //   254: iadd
    //   255: istore 4
    //   257: aload_1
    //   258: iload 6
    //   260: aload_0
    //   261: getfield 136	com/jcraft/jsch/ProxySOCKS5:passwd	Ljava/lang/String;
    //   264: invokevirtual 139	java/lang/String:length	()I
    //   267: i2b
    //   268: i2b
    //   269: bastore
    //   270: aload_0
    //   271: getfield 136	com/jcraft/jsch/ProxySOCKS5:passwd	Ljava/lang/String;
    //   274: invokestatic 143	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   277: iconst_0
    //   278: aload_1
    //   279: iload 4
    //   281: aload_0
    //   282: getfield 136	com/jcraft/jsch/ProxySOCKS5:passwd	Ljava/lang/String;
    //   285: invokevirtual 139	java/lang/String:length	()I
    //   288: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   291: aload_0
    //   292: getfield 136	com/jcraft/jsch/ProxySOCKS5:passwd	Ljava/lang/String;
    //   295: invokevirtual 139	java/lang/String:length	()I
    //   298: istore 6
    //   300: aload_0
    //   301: getfield 81	com/jcraft/jsch/ProxySOCKS5:out	Ljava/io/OutputStream;
    //   304: aload_1
    //   305: iconst_0
    //   306: iload 4
    //   308: iload 6
    //   310: iadd
    //   311: invokevirtual 130	java/io/OutputStream:write	([BII)V
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   319: aload_1
    //   320: iconst_2
    //   321: invokespecial 132	com/jcraft/jsch/ProxySOCKS5:fill	(Ljava/io/InputStream;[BI)V
    //   324: aload_1
    //   325: iconst_1
    //   326: baload
    //   327: ifne +6 -> 333
    //   330: goto +9 -> 339
    //   333: iconst_0
    //   334: istore 4
    //   336: goto +6 -> 342
    //   339: iconst_1
    //   340: istore 4
    //   342: iload 4
    //   344: ifeq +242 -> 586
    //   347: aload_1
    //   348: iconst_0
    //   349: iconst_5
    //   350: i2b
    //   351: bastore
    //   352: aload_1
    //   353: iconst_1
    //   354: iconst_1
    //   355: i2b
    //   356: bastore
    //   357: aload_1
    //   358: iconst_2
    //   359: iconst_0
    //   360: i2b
    //   361: bastore
    //   362: aload_2
    //   363: invokestatic 143	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   366: astore_2
    //   367: aload_2
    //   368: arraylength
    //   369: istore 4
    //   371: aload_1
    //   372: iconst_3
    //   373: iconst_3
    //   374: i2b
    //   375: bastore
    //   376: aload_1
    //   377: iconst_4
    //   378: iload 4
    //   380: i2b
    //   381: i2b
    //   382: bastore
    //   383: aload_2
    //   384: iconst_0
    //   385: aload_1
    //   386: iconst_5
    //   387: iload 4
    //   389: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   392: iconst_5
    //   393: iload 4
    //   395: iadd
    //   396: istore 6
    //   398: iload 6
    //   400: iconst_1
    //   401: iadd
    //   402: istore 4
    //   404: aload_1
    //   405: iload 6
    //   407: iload_3
    //   408: bipush 8
    //   410: iushr
    //   411: i2b
    //   412: i2b
    //   413: bastore
    //   414: aload_1
    //   415: iload 4
    //   417: iload_3
    //   418: sipush 255
    //   421: iand
    //   422: i2b
    //   423: i2b
    //   424: bastore
    //   425: aload_0
    //   426: getfield 81	com/jcraft/jsch/ProxySOCKS5:out	Ljava/io/OutputStream;
    //   429: aload_1
    //   430: iconst_0
    //   431: iload 4
    //   433: iconst_1
    //   434: iadd
    //   435: invokevirtual 130	java/io/OutputStream:write	([BII)V
    //   438: aload_0
    //   439: aload_0
    //   440: getfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   443: aload_1
    //   444: iconst_4
    //   445: invokespecial 132	com/jcraft/jsch/ProxySOCKS5:fill	(Ljava/io/InputStream;[BI)V
    //   448: aload_1
    //   449: iconst_1
    //   450: baload
    //   451: ifne +86 -> 537
    //   454: aload_1
    //   455: iconst_3
    //   456: baload
    //   457: sipush 255
    //   460: iand
    //   461: istore_3
    //   462: iload_3
    //   463: iconst_1
    //   464: if_icmpeq +61 -> 525
    //   467: iload_3
    //   468: iconst_3
    //   469: if_icmpeq +25 -> 494
    //   472: iload_3
    //   473: iconst_4
    //   474: if_icmpeq +6 -> 480
    //   477: goto +59 -> 536
    //   480: aload_0
    //   481: aload_0
    //   482: getfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   485: aload_1
    //   486: bipush 18
    //   488: invokespecial 132	com/jcraft/jsch/ProxySOCKS5:fill	(Ljava/io/InputStream;[BI)V
    //   491: goto +45 -> 536
    //   494: aload_0
    //   495: aload_0
    //   496: getfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   499: aload_1
    //   500: iconst_1
    //   501: invokespecial 132	com/jcraft/jsch/ProxySOCKS5:fill	(Ljava/io/InputStream;[BI)V
    //   504: aload_0
    //   505: aload_0
    //   506: getfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   509: aload_1
    //   510: aload_1
    //   511: iconst_0
    //   512: baload
    //   513: sipush 255
    //   516: iand
    //   517: iconst_2
    //   518: iadd
    //   519: invokespecial 132	com/jcraft/jsch/ProxySOCKS5:fill	(Ljava/io/InputStream;[BI)V
    //   522: goto +14 -> 536
    //   525: aload_0
    //   526: aload_0
    //   527: getfield 77	com/jcraft/jsch/ProxySOCKS5:in	Ljava/io/InputStream;
    //   530: aload_1
    //   531: bipush 6
    //   533: invokespecial 132	com/jcraft/jsch/ProxySOCKS5:fill	(Ljava/io/InputStream;[BI)V
    //   536: return
    //   537: aload_0
    //   538: getfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   541: invokevirtual 89	java/net/Socket:close	()V
    //   544: new 59	com/jcraft/jsch/JSchException
    //   547: astore_2
    //   548: new 151	java/lang/StringBuilder
    //   551: astore 5
    //   553: aload 5
    //   555: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   558: aload 5
    //   560: ldc -102
    //   562: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 5
    //   568: aload_1
    //   569: iconst_1
    //   570: baload
    //   571: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_2
    //   576: aload 5
    //   578: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokespecial 71	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   584: aload_2
    //   585: athrow
    //   586: aload_0
    //   587: getfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   590: invokevirtual 89	java/net/Socket:close	()V
    //   593: new 59	com/jcraft/jsch/JSchException
    //   596: astore_1
    //   597: aload_1
    //   598: ldc -89
    //   600: invokespecial 71	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   603: aload_1
    //   604: athrow
    //   605: astore_1
    //   606: aload_0
    //   607: getfield 86	com/jcraft/jsch/ProxySOCKS5:socket	Ljava/net/Socket;
    //   610: astore_2
    //   611: aload_2
    //   612: ifnull +7 -> 619
    //   615: aload_2
    //   616: invokevirtual 89	java/net/Socket:close	()V
    //   619: new 151	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   626: astore_2
    //   627: aload_2
    //   628: ldc -87
    //   630: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload_2
    //   635: aload_1
    //   636: invokevirtual 170	java/lang/Exception:toString	()Ljava/lang/String;
    //   639: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: new 59	com/jcraft/jsch/JSchException
    //   646: dup
    //   647: aload_2
    //   648: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: aload_1
    //   652: invokespecial 173	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   655: athrow
    //   656: astore_1
    //   657: aload_1
    //   658: athrow
    //   659: astore_2
    //   660: goto -116 -> 544
    //   663: astore_1
    //   664: goto -71 -> 593
    //   667: astore_2
    //   668: goto -49 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	ProxySOCKS5
    //   0	671	1	paramSocketFactory	SocketFactory
    //   0	671	2	paramString	String
    //   0	671	3	paramInt1	int
    //   0	671	4	paramInt2	int
    //   59	518	5	localObject	Object
    //   249	157	6	i	int
    // Exception table:
    //   from	to	target	type
    //   4	42	605	java/lang/Exception
    //   45	93	605	java/lang/Exception
    //   98	107	605	java/lang/Exception
    //   107	121	605	java/lang/Exception
    //   141	161	605	java/lang/Exception
    //   184	190	605	java/lang/Exception
    //   195	202	605	java/lang/Exception
    //   210	251	605	java/lang/Exception
    //   257	324	605	java/lang/Exception
    //   362	371	605	java/lang/Exception
    //   383	392	605	java/lang/Exception
    //   425	448	605	java/lang/Exception
    //   480	491	605	java/lang/Exception
    //   494	522	605	java/lang/Exception
    //   525	536	605	java/lang/Exception
    //   544	586	605	java/lang/Exception
    //   593	605	605	java/lang/Exception
    //   4	42	656	java/lang/RuntimeException
    //   45	93	656	java/lang/RuntimeException
    //   98	107	656	java/lang/RuntimeException
    //   107	121	656	java/lang/RuntimeException
    //   141	161	656	java/lang/RuntimeException
    //   184	190	656	java/lang/RuntimeException
    //   195	202	656	java/lang/RuntimeException
    //   210	251	656	java/lang/RuntimeException
    //   257	324	656	java/lang/RuntimeException
    //   362	371	656	java/lang/RuntimeException
    //   383	392	656	java/lang/RuntimeException
    //   425	448	656	java/lang/RuntimeException
    //   480	491	656	java/lang/RuntimeException
    //   494	522	656	java/lang/RuntimeException
    //   525	536	656	java/lang/RuntimeException
    //   544	586	656	java/lang/RuntimeException
    //   593	605	656	java/lang/RuntimeException
    //   537	544	659	java/lang/Exception
    //   586	593	663	java/lang/Exception
    //   606	611	667	java/lang/Exception
    //   615	619	667	java/lang/Exception
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ProxySOCKS5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */