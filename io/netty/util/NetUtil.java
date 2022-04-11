package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class NetUtil
{
  private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
  private static final boolean IPV4_PREFERRED;
  private static final int IPV4_SEPARATORS = 3;
  private static final boolean IPV6_ADDRESSES_PREFERRED;
  private static final int IPV6_BYTE_COUNT = 16;
  private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
  private static final int IPV6_MAX_CHAR_COUNT = 39;
  private static final int IPV6_MAX_SEPARATORS = 8;
  private static final int IPV6_MIN_SEPARATORS = 2;
  private static final int IPV6_WORD_COUNT = 8;
  public static final InetAddress LOCALHOST;
  public static final Inet4Address LOCALHOST4;
  public static final Inet6Address LOCALHOST6;
  public static final NetworkInterface LOOPBACK_IF;
  public static final int SOMAXCONN = ((Integer)AccessController.doPrivileged(new PrivilegedAction()
  {
    /* Error */
    public Integer run()
    {
      // Byte code:
      //   0: invokestatic 24	io/netty/util/internal/PlatformDependent:isWindows	()Z
      //   3: ifeq +10 -> 13
      //   6: sipush 200
      //   9: istore_1
      //   10: goto +7 -> 17
      //   13: sipush 128
      //   16: istore_1
      //   17: new 26	java/io/File
      //   20: dup
      //   21: ldc 28
      //   23: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
      //   26: astore_2
      //   27: aconst_null
      //   28: astore_3
      //   29: aconst_null
      //   30: astore 4
      //   32: iload_1
      //   33: istore 5
      //   35: aload_2
      //   36: invokevirtual 34	java/io/File:exists	()Z
      //   39: ifeq +105 -> 144
      //   42: iload_1
      //   43: istore 5
      //   45: new 36	java/io/BufferedReader
      //   48: astore 6
      //   50: iload_1
      //   51: istore 5
      //   53: new 38	java/io/FileReader
      //   56: astore 7
      //   58: iload_1
      //   59: istore 5
      //   61: aload 7
      //   63: aload_2
      //   64: invokespecial 41	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   67: iload_1
      //   68: istore 5
      //   70: aload 6
      //   72: aload 7
      //   74: invokespecial 44	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   77: iload_1
      //   78: istore 8
      //   80: aload 6
      //   82: astore 7
      //   84: aload 6
      //   86: invokevirtual 48	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   89: invokestatic 54	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   92: istore_1
      //   93: iload_1
      //   94: istore 8
      //   96: aload 6
      //   98: astore 7
      //   100: invokestatic 58	io/netty/util/NetUtil:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   103: invokeinterface 63 1 0
      //   108: ifeq +25 -> 133
      //   111: iload_1
      //   112: istore 8
      //   114: aload 6
      //   116: astore 7
      //   118: invokestatic 58	io/netty/util/NetUtil:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   121: ldc 65
      //   123: aload_2
      //   124: iload_1
      //   125: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   128: invokeinterface 73 4 0
      //   133: aload 6
      //   135: astore 7
      //   137: goto +131 -> 268
      //   140: astore_3
      //   141: goto +165 -> 306
      //   144: iload_1
      //   145: istore 5
      //   147: ldc 75
      //   149: iconst_0
      //   150: invokestatic 81	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
      //   153: ifeq +70 -> 223
      //   156: iload_1
      //   157: istore 5
      //   159: ldc 83
      //   161: invokestatic 87	io/netty/util/NetUtil:access$100	(Ljava/lang/String;)Ljava/lang/Integer;
      //   164: astore 6
      //   166: aload 6
      //   168: ifnonnull +42 -> 210
      //   171: iload_1
      //   172: istore 5
      //   174: ldc 89
      //   176: invokestatic 87	io/netty/util/NetUtil:access$100	(Ljava/lang/String;)Ljava/lang/Integer;
      //   179: astore 7
      //   181: iload_1
      //   182: istore 8
      //   184: aload 7
      //   186: astore 6
      //   188: aload 7
      //   190: ifnull +39 -> 229
      //   193: iload_1
      //   194: istore 5
      //   196: aload 7
      //   198: invokevirtual 93	java/lang/Integer:intValue	()I
      //   201: istore 8
      //   203: aload 7
      //   205: astore 6
      //   207: goto +22 -> 229
      //   210: iload_1
      //   211: istore 5
      //   213: aload 6
      //   215: invokevirtual 93	java/lang/Integer:intValue	()I
      //   218: istore 8
      //   220: goto +9 -> 229
      //   223: aconst_null
      //   224: astore 6
      //   226: iload_1
      //   227: istore 8
      //   229: iload 8
      //   231: istore_1
      //   232: aload 4
      //   234: astore 7
      //   236: aload 6
      //   238: ifnonnull +30 -> 268
      //   241: iload 8
      //   243: istore 5
      //   245: invokestatic 58	io/netty/util/NetUtil:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   248: ldc 95
      //   250: aload_2
      //   251: iload 8
      //   253: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   256: invokeinterface 73 4 0
      //   261: aload 4
      //   263: astore 7
      //   265: iload 8
      //   267: istore_1
      //   268: iload_1
      //   269: istore 5
      //   271: aload 7
      //   273: ifnull +104 -> 377
      //   276: iload_1
      //   277: istore 5
      //   279: aload 7
      //   281: invokevirtual 98	java/io/BufferedReader:close	()V
      //   284: iload_1
      //   285: istore 5
      //   287: goto +90 -> 377
      //   290: astore 6
      //   292: aload_3
      //   293: astore 7
      //   295: goto +90 -> 385
      //   298: astore_3
      //   299: aconst_null
      //   300: astore 6
      //   302: iload 5
      //   304: istore 8
      //   306: aload 6
      //   308: astore 7
      //   310: invokestatic 58	io/netty/util/NetUtil:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   313: invokeinterface 63 1 0
      //   318: ifeq +37 -> 355
      //   321: aload 6
      //   323: astore 7
      //   325: invokestatic 58	io/netty/util/NetUtil:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   328: ldc 95
      //   330: iconst_3
      //   331: anewarray 5	java/lang/Object
      //   334: dup
      //   335: iconst_0
      //   336: aload_2
      //   337: aastore
      //   338: dup
      //   339: iconst_1
      //   340: iload 8
      //   342: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   345: aastore
      //   346: dup
      //   347: iconst_2
      //   348: aload_3
      //   349: aastore
      //   350: invokeinterface 101 3 0
      //   355: iload 8
      //   357: istore 5
      //   359: aload 6
      //   361: ifnull +16 -> 377
      //   364: iload 8
      //   366: istore 5
      //   368: aload 6
      //   370: invokevirtual 98	java/io/BufferedReader:close	()V
      //   373: iload 8
      //   375: istore 5
      //   377: iload 5
      //   379: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   382: areturn
      //   383: astore 6
      //   385: aload 7
      //   387: ifnull +8 -> 395
      //   390: aload 7
      //   392: invokevirtual 98	java/io/BufferedReader:close	()V
      //   395: aload 6
      //   397: athrow
      //   398: astore 6
      //   400: goto -23 -> 377
      //   403: astore 7
      //   405: goto -10 -> 395
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	408	0	this	1
      //   9	276	1	i	int
      //   26	311	2	localFile	java.io.File
      //   28	1	3	localObject1	Object
      //   140	153	3	localException1	Exception
      //   298	51	3	localException2	Exception
      //   30	232	4	localObject2	Object
      //   33	345	5	j	int
      //   48	189	6	localObject3	Object
      //   290	1	6	localObject4	Object
      //   300	69	6	localObject5	Object
      //   383	13	6	localObject6	Object
      //   398	1	6	localException3	Exception
      //   56	335	7	localObject7	Object
      //   403	1	7	localException4	Exception
      //   78	296	8	k	int
      // Exception table:
      //   from	to	target	type
      //   84	93	140	java/lang/Exception
      //   100	111	140	java/lang/Exception
      //   118	133	140	java/lang/Exception
      //   35	42	290	finally
      //   45	50	290	finally
      //   53	58	290	finally
      //   61	67	290	finally
      //   70	77	290	finally
      //   147	156	290	finally
      //   159	166	290	finally
      //   174	181	290	finally
      //   196	203	290	finally
      //   213	220	290	finally
      //   245	261	290	finally
      //   35	42	298	java/lang/Exception
      //   45	50	298	java/lang/Exception
      //   53	58	298	java/lang/Exception
      //   61	67	298	java/lang/Exception
      //   70	77	298	java/lang/Exception
      //   147	156	298	java/lang/Exception
      //   159	166	298	java/lang/Exception
      //   174	181	298	java/lang/Exception
      //   196	203	298	java/lang/Exception
      //   213	220	298	java/lang/Exception
      //   245	261	298	java/lang/Exception
      //   84	93	383	finally
      //   100	111	383	finally
      //   118	133	383	finally
      //   310	321	383	finally
      //   325	355	383	finally
      //   279	284	398	java/lang/Exception
      //   368	373	398	java/lang/Exception
      //   390	395	403	java/lang/Exception
    }
  })).intValue();
  private static final InternalLogger logger;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 43
    //   2: iconst_0
    //   3: invokestatic 49	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
    //   6: istore_0
    //   7: iload_0
    //   8: putstatic 51	io/netty/util/NetUtil:IPV4_PREFERRED	Z
    //   11: ldc 53
    //   13: iconst_0
    //   14: invokestatic 49	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
    //   17: istore_1
    //   18: iload_1
    //   19: putstatic 55	io/netty/util/NetUtil:IPV6_ADDRESSES_PREFERRED	Z
    //   22: ldc 2
    //   24: invokestatic 61	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   27: astore_2
    //   28: aload_2
    //   29: putstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   32: aload_2
    //   33: ldc 65
    //   35: iload_0
    //   36: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: invokeinterface 77 3 0
    //   44: aload_2
    //   45: ldc 79
    //   47: iload_1
    //   48: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   51: invokeinterface 77 3 0
    //   56: aconst_null
    //   57: astore_3
    //   58: ldc 81
    //   60: iconst_4
    //   61: newarray <illegal type>
    //   63: dup
    //   64: iconst_0
    //   65: ldc 82
    //   67: bastore
    //   68: dup
    //   69: iconst_1
    //   70: ldc 83
    //   72: bastore
    //   73: dup
    //   74: iconst_2
    //   75: ldc 83
    //   77: bastore
    //   78: dup
    //   79: iconst_3
    //   80: ldc 84
    //   82: bastore
    //   83: invokestatic 90	java/net/InetAddress:getByAddress	(Ljava/lang/String;[B)Ljava/net/InetAddress;
    //   86: checkcast 92	java/net/Inet4Address
    //   89: astore 4
    //   91: goto +11 -> 102
    //   94: astore_2
    //   95: aload_2
    //   96: invokestatic 98	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   99: aconst_null
    //   100: astore 4
    //   102: aload 4
    //   104: putstatic 100	io/netty/util/NetUtil:LOCALHOST4	Ljava/net/Inet4Address;
    //   107: ldc 81
    //   109: bipush 16
    //   111: newarray <illegal type>
    //   113: dup
    //   114: iconst_0
    //   115: ldc 83
    //   117: bastore
    //   118: dup
    //   119: iconst_1
    //   120: ldc 83
    //   122: bastore
    //   123: dup
    //   124: iconst_2
    //   125: ldc 83
    //   127: bastore
    //   128: dup
    //   129: iconst_3
    //   130: ldc 83
    //   132: bastore
    //   133: dup
    //   134: iconst_4
    //   135: ldc 83
    //   137: bastore
    //   138: dup
    //   139: iconst_5
    //   140: ldc 83
    //   142: bastore
    //   143: dup
    //   144: bipush 6
    //   146: ldc 83
    //   148: bastore
    //   149: dup
    //   150: bipush 7
    //   152: ldc 83
    //   154: bastore
    //   155: dup
    //   156: bipush 8
    //   158: ldc 83
    //   160: bastore
    //   161: dup
    //   162: bipush 9
    //   164: ldc 83
    //   166: bastore
    //   167: dup
    //   168: bipush 10
    //   170: ldc 83
    //   172: bastore
    //   173: dup
    //   174: bipush 11
    //   176: ldc 83
    //   178: bastore
    //   179: dup
    //   180: bipush 12
    //   182: ldc 83
    //   184: bastore
    //   185: dup
    //   186: bipush 13
    //   188: ldc 83
    //   190: bastore
    //   191: dup
    //   192: bipush 14
    //   194: ldc 83
    //   196: bastore
    //   197: dup
    //   198: bipush 15
    //   200: ldc 84
    //   202: bastore
    //   203: invokestatic 90	java/net/InetAddress:getByAddress	(Ljava/lang/String;[B)Ljava/net/InetAddress;
    //   206: checkcast 102	java/net/Inet6Address
    //   209: astore 5
    //   211: goto +11 -> 222
    //   214: astore_2
    //   215: aload_2
    //   216: invokestatic 98	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   219: aconst_null
    //   220: astore 5
    //   222: aload 5
    //   224: putstatic 104	io/netty/util/NetUtil:LOCALHOST6	Ljava/net/Inet6Address;
    //   227: new 106	java/util/ArrayList
    //   230: dup
    //   231: invokespecial 109	java/util/ArrayList:<init>	()V
    //   234: astore 6
    //   236: invokestatic 115	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   239: astore 7
    //   241: aload 7
    //   243: ifnull +60 -> 303
    //   246: aload 7
    //   248: invokeinterface 121 1 0
    //   253: ifeq +50 -> 303
    //   256: aload 7
    //   258: invokeinterface 125 1 0
    //   263: checkcast 111	java/net/NetworkInterface
    //   266: astore_2
    //   267: aload_2
    //   268: invokestatic 131	io/netty/util/internal/SocketUtils:addressesFromNetworkInterface	(Ljava/net/NetworkInterface;)Ljava/util/Enumeration;
    //   271: invokeinterface 121 1 0
    //   276: ifeq -30 -> 246
    //   279: aload 6
    //   281: aload_2
    //   282: invokeinterface 137 2 0
    //   287: pop
    //   288: goto -42 -> 246
    //   291: astore_2
    //   292: getstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   295: ldc -117
    //   297: aload_2
    //   298: invokeinterface 143 3 0
    //   303: aload 6
    //   305: invokeinterface 147 1 0
    //   310: astore 8
    //   312: aload 8
    //   314: invokeinterface 152 1 0
    //   319: ifeq +56 -> 375
    //   322: aload 8
    //   324: invokeinterface 155 1 0
    //   329: checkcast 111	java/net/NetworkInterface
    //   332: astore 7
    //   334: aload 7
    //   336: invokestatic 131	io/netty/util/internal/SocketUtils:addressesFromNetworkInterface	(Ljava/net/NetworkInterface;)Ljava/util/Enumeration;
    //   339: astore 9
    //   341: aload 9
    //   343: invokeinterface 121 1 0
    //   348: ifeq -36 -> 312
    //   351: aload 9
    //   353: invokeinterface 125 1 0
    //   358: checkcast 86	java/net/InetAddress
    //   361: astore_2
    //   362: aload_2
    //   363: invokevirtual 158	java/net/InetAddress:isLoopbackAddress	()Z
    //   366: ifeq -25 -> 341
    //   369: aload 7
    //   371: astore_3
    //   372: goto +5 -> 377
    //   375: aconst_null
    //   376: astore_2
    //   377: aload_3
    //   378: astore 8
    //   380: aload_2
    //   381: astore 7
    //   383: aload_3
    //   384: ifnonnull +190 -> 574
    //   387: aload_3
    //   388: astore 7
    //   390: aload_2
    //   391: astore 8
    //   393: aload 6
    //   395: invokeinterface 147 1 0
    //   400: astore 10
    //   402: aload_3
    //   403: astore 6
    //   405: aload_2
    //   406: astore 9
    //   408: aload_3
    //   409: astore 7
    //   411: aload_2
    //   412: astore 8
    //   414: aload 10
    //   416: invokeinterface 152 1 0
    //   421: ifeq +89 -> 510
    //   424: aload_3
    //   425: astore 7
    //   427: aload_2
    //   428: astore 8
    //   430: aload 10
    //   432: invokeinterface 155 1 0
    //   437: checkcast 111	java/net/NetworkInterface
    //   440: astore 6
    //   442: aload_3
    //   443: astore 7
    //   445: aload_2
    //   446: astore 8
    //   448: aload 6
    //   450: invokevirtual 161	java/net/NetworkInterface:isLoopback	()Z
    //   453: ifeq -51 -> 402
    //   456: aload_3
    //   457: astore 7
    //   459: aload_2
    //   460: astore 8
    //   462: aload 6
    //   464: invokestatic 131	io/netty/util/internal/SocketUtils:addressesFromNetworkInterface	(Ljava/net/NetworkInterface;)Ljava/util/Enumeration;
    //   467: astore 9
    //   469: aload_3
    //   470: astore 7
    //   472: aload_2
    //   473: astore 8
    //   475: aload 9
    //   477: invokeinterface 121 1 0
    //   482: istore_1
    //   483: iload_1
    //   484: ifeq -82 -> 402
    //   487: aload 9
    //   489: invokeinterface 125 1 0
    //   494: checkcast 86	java/net/InetAddress
    //   497: astore 9
    //   499: goto +11 -> 510
    //   502: astore_3
    //   503: aload 6
    //   505: astore 8
    //   507: goto +53 -> 560
    //   510: aload 6
    //   512: astore 8
    //   514: aload 9
    //   516: astore 7
    //   518: aload 6
    //   520: ifnonnull +54 -> 574
    //   523: aload 6
    //   525: astore 7
    //   527: aload 9
    //   529: astore 8
    //   531: getstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   534: ldc -93
    //   536: invokeinterface 166 2 0
    //   541: aload 6
    //   543: astore 8
    //   545: aload 9
    //   547: astore 7
    //   549: goto +25 -> 574
    //   552: astore_3
    //   553: aload 8
    //   555: astore_2
    //   556: aload 7
    //   558: astore 8
    //   560: getstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   563: ldc -93
    //   565: aload_3
    //   566: invokeinterface 143 3 0
    //   571: aload_2
    //   572: astore 7
    //   574: aload 8
    //   576: ifnull +44 -> 620
    //   579: getstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   582: ldc -88
    //   584: iconst_3
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload 8
    //   592: invokevirtual 172	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   595: aastore
    //   596: dup
    //   597: iconst_1
    //   598: aload 8
    //   600: invokevirtual 175	java/net/NetworkInterface:getDisplayName	()Ljava/lang/String;
    //   603: aastore
    //   604: dup
    //   605: iconst_2
    //   606: aload 7
    //   608: invokevirtual 178	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   611: aastore
    //   612: invokeinterface 181 3 0
    //   617: goto +92 -> 709
    //   620: aload 7
    //   622: ifnonnull +87 -> 709
    //   625: getstatic 104	io/netty/util/NetUtil:LOCALHOST6	Ljava/net/Inet6Address;
    //   628: invokestatic 185	java/net/NetworkInterface:getByInetAddress	(Ljava/net/InetAddress;)Ljava/net/NetworkInterface;
    //   631: ifnull +18 -> 649
    //   634: getstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   637: ldc -69
    //   639: aload 5
    //   641: invokeinterface 77 3 0
    //   646: goto +7 -> 653
    //   649: aload 7
    //   651: astore 5
    //   653: aload 5
    //   655: ifnonnull +6 -> 661
    //   658: goto +36 -> 694
    //   661: aload 5
    //   663: astore 4
    //   665: goto +48 -> 713
    //   668: astore_2
    //   669: aload 7
    //   671: ifnonnull +15 -> 686
    //   674: getstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   677: ldc -67
    //   679: aload 4
    //   681: invokeinterface 77 3 0
    //   686: aload_2
    //   687: athrow
    //   688: astore_2
    //   689: aload 7
    //   691: ifnonnull +18 -> 709
    //   694: getstatic 63	io/netty/util/NetUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   697: ldc -67
    //   699: aload 4
    //   701: invokeinterface 77 3 0
    //   706: goto +7 -> 713
    //   709: aload 7
    //   711: astore 4
    //   713: aload 8
    //   715: putstatic 191	io/netty/util/NetUtil:LOOPBACK_IF	Ljava/net/NetworkInterface;
    //   718: aload 4
    //   720: putstatic 193	io/netty/util/NetUtil:LOCALHOST	Ljava/net/InetAddress;
    //   723: new 6	io/netty/util/NetUtil$1
    //   726: dup
    //   727: invokespecial 194	io/netty/util/NetUtil$1:<init>	()V
    //   730: invokestatic 200	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   733: checkcast 202	java/lang/Integer
    //   736: invokevirtual 206	java/lang/Integer:intValue	()I
    //   739: putstatic 208	io/netty/util/NetUtil:SOMAXCONN	I
    //   742: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	30	0	bool1	boolean
    //   17	467	1	bool2	boolean
    //   27	18	2	localInternalLogger	InternalLogger
    //   94	2	2	localException1	Exception
    //   214	2	2	localException2	Exception
    //   266	16	2	localNetworkInterface	NetworkInterface
    //   291	7	2	localSocketException1	java.net.SocketException
    //   361	211	2	localObject1	Object
    //   668	19	2	localObject2	Object
    //   688	1	2	localException3	Exception
    //   57	413	3	localObject3	Object
    //   502	1	3	localSocketException2	java.net.SocketException
    //   552	14	3	localSocketException3	java.net.SocketException
    //   89	630	4	localObject4	Object
    //   209	453	5	localObject5	Object
    //   234	308	6	localObject6	Object
    //   239	471	7	localObject7	Object
    //   310	404	8	localObject8	Object
    //   339	207	9	localObject9	Object
    //   400	31	10	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   58	91	94	java/lang/Exception
    //   107	211	214	java/lang/Exception
    //   236	241	291	java/net/SocketException
    //   246	288	291	java/net/SocketException
    //   487	499	502	java/net/SocketException
    //   393	402	552	java/net/SocketException
    //   414	424	552	java/net/SocketException
    //   430	442	552	java/net/SocketException
    //   448	456	552	java/net/SocketException
    //   462	469	552	java/net/SocketException
    //   475	483	552	java/net/SocketException
    //   531	541	552	java/net/SocketException
    //   625	646	668	finally
    //   625	646	688	java/lang/Exception
  }
  
  public static String bytesToIpAddress(byte[] paramArrayOfByte)
  {
    return bytesToIpAddress(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String bytesToIpAddress(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 4)
    {
      if (paramInt2 == 16) {
        return toAddressString(paramArrayOfByte, paramInt1, false);
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("length: ");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(" (expected: 4 or 16)");
      throw new IllegalArgumentException(paramArrayOfByte.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(15);
    localStringBuilder.append(paramArrayOfByte[paramInt1] & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramArrayOfByte[(paramInt1 + 1)] & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramArrayOfByte[(paramInt1 + 2)] & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramArrayOfByte[(paramInt1 + 3)] & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static byte[] createByteArrayFromIpAddressString(String paramString)
  {
    if (isValidIpV4Address(paramString)) {
      return validIpV4ToBytes(paramString);
    }
    if (isValidIpV6Address(paramString))
    {
      String str = paramString;
      if (paramString.charAt(0) == '[') {
        str = paramString.substring(1, paramString.length() - 1);
      }
      int i = str.indexOf('%');
      paramString = str;
      if (i >= 0) {
        paramString = str.substring(0, i);
      }
      return getIPv6ByName(paramString, true);
    }
    return null;
  }
  
  private static int decimalDigit(String paramString, int paramInt)
  {
    return paramString.charAt(paramInt) - '0';
  }
  
  public static Inet6Address getByName(CharSequence paramCharSequence)
  {
    return getByName(paramCharSequence, true);
  }
  
  public static Inet6Address getByName(CharSequence paramCharSequence, boolean paramBoolean)
  {
    paramCharSequence = getIPv6ByName(paramCharSequence, paramBoolean);
    if (paramCharSequence == null) {
      return null;
    }
    try
    {
      paramCharSequence = Inet6Address.getByAddress(null, paramCharSequence, -1);
      return paramCharSequence;
    }
    catch (UnknownHostException paramCharSequence)
    {
      throw new RuntimeException(paramCharSequence);
    }
  }
  
  public static String getHostname(InetSocketAddress paramInetSocketAddress)
  {
    if (PlatformDependent.javaVersion() >= 7) {
      paramInetSocketAddress = paramInetSocketAddress.getHostString();
    } else {
      paramInetSocketAddress = paramInetSocketAddress.getHostName();
    }
    return paramInetSocketAddress;
  }
  
  private static byte[] getIPv6ByName(CharSequence paramCharSequence, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[16];
    int i = paramCharSequence.length();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = -1;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6;
    int i12;
    while (j < i)
    {
      char c = paramCharSequence.charAt(j);
      int i9;
      if (c != '.')
      {
        if (c != ':')
        {
          if ((isValidHexChar(c)) && ((m <= 0) || (isValidNumericChar(c))))
          {
            if (n < 0)
            {
              i6 = j;
            }
            else
            {
              i6 = n;
              if (j - n > 4) {
                return null;
              }
            }
            i4 += (StringUtil.decodeHexNibble(c) << (j - i6 << 2));
            n = i6;
            break label770;
          }
          return null;
        }
        int i7 = i1 + 1;
        n = j - n;
        if ((n <= 4) && (m <= 0) && (i7 <= 8))
        {
          i1 = i2 + 1;
          if (i1 < 16)
          {
            int i8 = i4 << (4 - n << 2);
            i9 = i3;
            if (i3 > 0) {
              i9 = i3 - 2;
            }
            arrayOfByte[i2] = ((byte)(byte)((i8 & 0xF) << 4 | i8 >> 4 & 0xF));
            int i10 = i1 + 1;
            arrayOfByte[i1] = ((byte)(byte)((i8 >> 8 & 0xF) << 4 | i8 >> 12 & 0xF));
            int i11 = j + 1;
            i6 = j;
            n = k;
            i4 = m;
            i1 = i7;
            i2 = i10;
            i3 = i9;
            i12 = i5;
            if (i11 < i)
            {
              i6 = j;
              n = k;
              i4 = m;
              i1 = i7;
              i2 = i10;
              i3 = i9;
              i12 = i5;
              if (paramCharSequence.charAt(i11) == ':')
              {
                i3 = i11 + 1;
                if ((k == 0) && ((i3 >= i) || (paramCharSequence.charAt(i3) != ':')))
                {
                  i1 = i7 + 1;
                  if ((i1 == 2) && (i8 == 0)) {
                    i3 = 1;
                  } else {
                    i3 = 0;
                  }
                  i12 = i3;
                  i3 = 16 - i10 - 2;
                  n = i10;
                  i6 = i11;
                  i4 = m;
                  i2 = i10;
                }
                else
                {
                  return null;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        i9 = -1;
        i5 = 0;
        j = i6;
        k = n;
        m = i4;
        n = i9;
        i4 = i5;
        i5 = i12;
        break;
        return null;
        m++;
        i6 = j - n;
        if ((i6 > 3) || (n < 0) || (m > 3) || ((i1 > 0) && (i2 + i3 < 12)) || (j + 1 >= i) || (i2 >= 16) || ((m == 1) && ((!paramBoolean) || ((i2 != 0) && (!isValidIPv4Mapped(arrayOfByte, i2, k, i3))) || ((i6 == 3) && ((!isValidNumericChar(paramCharSequence.charAt(j - 1))) || (!isValidNumericChar(paramCharSequence.charAt(j - 2))) || (!isValidNumericChar(paramCharSequence.charAt(j - 3))))) || ((i6 == 2) && ((!isValidNumericChar(paramCharSequence.charAt(j - 1))) || (!isValidNumericChar(paramCharSequence.charAt(j - 2))))) || ((i6 == 1) && (!isValidNumericChar(paramCharSequence.charAt(j - 1))))))) {
          break label776;
        }
        i4 <<= 3 - i6 << 2;
        i4 = (i4 & 0xF) * 100 + (i4 >> 4 & 0xF) * 10 + (i4 >> 8 & 0xF);
        if ((i4 < 0) || (i4 > 255)) {
          break label776;
        }
        arrayOfByte[i2] = ((byte)(byte)i4);
        i2++;
        i6 = j;
        n = k;
        i4 = m;
        i12 = i5;
      }
      label770:
      j++;
      continue;
      label776:
      return null;
    }
    if (k > 0) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    if (m > 0)
    {
      if (n > 0) {
        if (j - n > 3) {
          break label988;
        }
      }
      if ((m == 3) && (i2 < 16))
      {
        if (i1 == 0)
        {
          i3 = 12;
        }
        else
        {
          if (i1 < 2) {
            break label988;
          }
          if ((i6 == 0) && (i1 == 6) && (paramCharSequence.charAt(0) != ':')) {}
          for (;;)
          {
            break;
            if ((i6 == 0) || (i1 >= 8)) {
              break label988;
            }
            if (paramCharSequence.charAt(0) == ':') {
              if (k > 2) {
                break label988;
              }
            }
          }
          i3 -= 2;
        }
        j = i4 << (3 - (j - n) << 2);
        i1 = (j & 0xF) * 100 + (j >> 4 & 0xF) * 10 + (j >> 8 & 0xF);
        if ((i1 >= 0) && (i1 <= 255))
        {
          j = i2 + 1;
          arrayOfByte[i2] = ((byte)(byte)i1);
          break label1261;
        }
      }
      label988:
      return null;
    }
    else
    {
      i12 = i - 1;
      if (((n > 0) && (j - n > 4)) || (i1 < 2) || ((i6 == 0) && ((i1 + 1 != 8) || (paramCharSequence.charAt(0) == ':') || (paramCharSequence.charAt(i12) == ':'))) || ((i6 != 0) && ((i1 > 8) || ((i1 == 8) && (((k <= 2) && (paramCharSequence.charAt(0) != ':')) || ((k >= 14) && (paramCharSequence.charAt(i12) != ':'))))))) {
        break label1429;
      }
      i6 = i2 + 1;
      if ((i6 >= 16) || ((n < 0) && (paramCharSequence.charAt(i12 - 1) != ':')) || ((k > 2) && (paramCharSequence.charAt(0) == ':'))) {
        break label1429;
      }
      if (n >= 0)
      {
        i1 = j - n;
        j = i4;
        if (i1 <= 4) {
          j = i4 << (4 - i1 << 2);
        }
      }
      else
      {
        j = i4;
      }
      arrayOfByte[i2] = ((byte)(byte)(j >> 4 & 0xF | (j & 0xF) << 4));
      i1 = i6 + 1;
      arrayOfByte[i6] = ((byte)(byte)((j >> 8 & 0xF) << 4 | j >> 12 & 0xF));
      j = i1;
    }
    label1261:
    i4 = j + i3;
    if ((i5 == 0) && (i4 < 16)) {
      j = 0;
    }
    while (j < i3)
    {
      i1 = j + k;
      i5 = i1 + i3;
      if (i5 < 16)
      {
        arrayOfByte[i5] = ((byte)arrayOfByte[i1]);
        arrayOfByte[i1] = ((byte)0);
        j++;
        continue;
        i1 = j;
        i3 = k;
        if (i4 >= 16) {
          i3 = k + 1;
        }
        for (i1 = j; i1 < 16; i1++)
        {
          for (j = 15; j >= i3; j--) {
            arrayOfByte[j] = ((byte)arrayOfByte[(j - 1)]);
          }
          arrayOfByte[j] = ((byte)0);
          i3++;
        }
      }
    }
    if (m > 0)
    {
      arrayOfByte[11] = ((byte)-1);
      arrayOfByte[10] = ((byte)-1);
    }
    return arrayOfByte;
    label1429:
    return null;
  }
  
  private static boolean inRangeEndExclusive(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((paramInt1 >= paramInt2) && (paramInt1 < paramInt3)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static String intToIpAddress(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(15);
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt & 0xFF);
    return localStringBuilder.toString();
  }
  
  private static byte ipv4WordToByte(String paramString, int paramInt1, int paramInt2)
  {
    int i = decimalDigit(paramString, paramInt1);
    paramInt1++;
    if (paramInt1 == paramInt2) {
      return (byte)i;
    }
    i = i * 10 + decimalDigit(paramString, paramInt1);
    paramInt1++;
    if (paramInt1 == paramInt2) {
      return (byte)i;
    }
    return (byte)(i * 10 + decimalDigit(paramString, paramInt1));
  }
  
  public static boolean isIpV4StackPreferred()
  {
    return IPV4_PREFERRED;
  }
  
  public static boolean isIpV6AddressesPreferred()
  {
    return IPV6_ADDRESSES_PREFERRED;
  }
  
  private static boolean isValidHexChar(char paramChar)
  {
    boolean bool;
    if (((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'A') && (paramChar <= 'F')) || ((paramChar >= 'a') && (paramChar <= 'f'))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isValidIPv4Mapped(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt3 + paramInt2 >= 14) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((paramInt1 <= 12) && (paramInt1 >= 2) && ((!bool2) || (paramInt2 < 12)) && (isValidIPv4MappedSeparators(paramArrayOfByte[(paramInt1 - 1)], paramArrayOfByte[(paramInt1 - 2)], bool2)) && (PlatformDependent.isZero(paramArrayOfByte, 0, paramInt1 - 3))) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  private static boolean isValidIPv4MappedChar(char paramChar)
  {
    boolean bool;
    if ((paramChar != 'f') && (paramChar != 'F')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isValidIPv4MappedSeparators(byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if ((paramByte1 == paramByte2) && ((paramByte1 == 0) || ((!paramBoolean) && (paramByte2 == -1)))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private static boolean isValidIpV4Address(AsciiString paramAsciiString, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    boolean bool = true;
    if ((i <= 15) && (i >= 7))
    {
      i = paramAsciiString.indexOf('.', paramInt1 + 1);
      if ((i > 0) && (isValidIpV4Word(paramAsciiString, paramInt1, i)))
      {
        i += 2;
        paramInt1 = paramAsciiString.indexOf('.', i);
        if ((paramInt1 > 0) && (isValidIpV4Word(paramAsciiString, i - 1, paramInt1)))
        {
          i = paramInt1 + 2;
          paramInt1 = paramAsciiString.indexOf('.', i);
          if ((paramInt1 > 0) && (isValidIpV4Word(paramAsciiString, i - 1, paramInt1)) && (isValidIpV4Word(paramAsciiString, paramInt1 + 1, paramInt2))) {
            break label112;
          }
        }
      }
    }
    bool = false;
    label112:
    return bool;
  }
  
  public static boolean isValidIpV4Address(CharSequence paramCharSequence)
  {
    return isValidIpV4Address(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private static boolean isValidIpV4Address(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramCharSequence instanceof String)) {
      bool = isValidIpV4Address((String)paramCharSequence, paramInt1, paramInt2);
    } else if ((paramCharSequence instanceof AsciiString)) {
      bool = isValidIpV4Address((AsciiString)paramCharSequence, paramInt1, paramInt2);
    } else {
      bool = isValidIpV4Address0(paramCharSequence, paramInt1, paramInt2);
    }
    return bool;
  }
  
  public static boolean isValidIpV4Address(String paramString)
  {
    return isValidIpV4Address(paramString, 0, paramString.length());
  }
  
  private static boolean isValidIpV4Address(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    boolean bool = true;
    if ((i <= 15) && (i >= 7))
    {
      i = paramString.indexOf('.', paramInt1 + 1);
      if ((i > 0) && (isValidIpV4Word(paramString, paramInt1, i)))
      {
        i += 2;
        paramInt1 = paramString.indexOf('.', i);
        if ((paramInt1 > 0) && (isValidIpV4Word(paramString, i - 1, paramInt1)))
        {
          i = paramInt1 + 2;
          paramInt1 = paramString.indexOf('.', i);
          if ((paramInt1 > 0) && (isValidIpV4Word(paramString, i - 1, paramInt1)) && (isValidIpV4Word(paramString, paramInt1 + 1, paramInt2))) {
            break label112;
          }
        }
      }
    }
    bool = false;
    label112:
    return bool;
  }
  
  private static boolean isValidIpV4Address0(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    boolean bool = true;
    if ((i <= 15) && (i >= 7))
    {
      i = AsciiString.indexOf(paramCharSequence, '.', paramInt1 + 1);
      if ((i > 0) && (isValidIpV4Word(paramCharSequence, paramInt1, i)))
      {
        paramInt1 = i + 2;
        i = AsciiString.indexOf(paramCharSequence, '.', paramInt1);
        if ((i > 0) && (isValidIpV4Word(paramCharSequence, paramInt1 - 1, i)))
        {
          paramInt1 = i + 2;
          i = AsciiString.indexOf(paramCharSequence, '.', paramInt1);
          if ((i > 0) && (isValidIpV4Word(paramCharSequence, paramInt1 - 1, i)) && (isValidIpV4Word(paramCharSequence, i + 1, paramInt2))) {
            break label113;
          }
        }
      }
    }
    bool = false;
    label113:
    return bool;
  }
  
  private static boolean isValidIpV4Word(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = bool1;
    if (i >= 1)
    {
      bool3 = bool1;
      if (i <= 3)
      {
        paramInt2 = paramCharSequence.charAt(paramInt1);
        if (paramInt2 < 48)
        {
          bool3 = bool1;
        }
        else
        {
          if (i == 3)
          {
            i = paramCharSequence.charAt(paramInt1 + 1);
            bool3 = bool2;
            if (i >= 48)
            {
              paramInt1 = paramCharSequence.charAt(paramInt1 + 2);
              bool3 = bool2;
              if (paramInt1 >= 48)
              {
                if ((paramInt2 > 49) || (i > 57) || (paramInt1 > 57))
                {
                  bool3 = bool2;
                  if (paramInt2 != 50) {
                    break label161;
                  }
                  bool3 = bool2;
                  if (i > 53) {
                    break label161;
                  }
                  if (paramInt1 > 53)
                  {
                    bool3 = bool2;
                    if (i >= 53) {
                      break label161;
                    }
                    bool3 = bool2;
                    if (paramInt1 > 57) {
                      break label161;
                    }
                  }
                }
                bool3 = true;
              }
            }
            label161:
            return bool3;
          }
          bool3 = bool1;
          if (paramInt2 <= 57) {
            if (i != 1)
            {
              bool3 = bool1;
              if (!isValidNumericChar(paramCharSequence.charAt(paramInt1 + 1))) {}
            }
            else
            {
              bool3 = true;
            }
          }
        }
      }
    }
    return bool3;
  }
  
  public static boolean isValidIpV6Address(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 2;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i < 2) {
      return false;
    }
    int k = paramCharSequence.charAt(0);
    if (k == 91)
    {
      i--;
      if (paramCharSequence.charAt(i) != ']') {
        return false;
      }
      k = paramCharSequence.charAt(1);
      m = 1;
    }
    else
    {
      m = 0;
    }
    if (k == 58)
    {
      if (paramCharSequence.charAt(m + 1) != ':') {
        return false;
      }
      k = m + 2;
      n = m;
      m = k;
    }
    else
    {
      j = 0;
      n = -1;
    }
    k = m;
    int i1 = 0;
    for (;;)
    {
      i2 = i;
      if (k >= i) {
        break label442;
      }
      char c = paramCharSequence.charAt(k);
      if (isValidHexChar(c))
      {
        if (i1 < 4) {
          i1++;
        } else {
          return false;
        }
      }
      else
      {
        if (c == '%') {
          break label438;
        }
        if (c == '.') {
          break;
        }
        if (c != ':') {
          return false;
        }
        if (j > 7) {
          return false;
        }
        i2 = k - 1;
        if (paramCharSequence.charAt(i2) == ':')
        {
          if (n >= 0) {
            return false;
          }
          n = i2;
        }
        else
        {
          i1 = 0;
        }
        j++;
      }
      k++;
    }
    if (((n < 0) && (j != 6)) || ((j == 7) && (n >= m)) || (j > 7)) {
      return false;
    }
    i1 = k - i1;
    int n = i1 - 2;
    k = n;
    if (isValidIPv4MappedChar(paramCharSequence.charAt(n))) {
      if ((isValidIPv4MappedChar(paramCharSequence.charAt(n - 1))) && (isValidIPv4MappedChar(paramCharSequence.charAt(n - 2))) && (isValidIPv4MappedChar(paramCharSequence.charAt(n - 3)))) {
        k = n - 5;
      } else {
        return false;
      }
    }
    while (k >= m)
    {
      n = paramCharSequence.charAt(k);
      if ((n != 48) && (n != 58)) {
        return false;
      }
      k--;
    }
    int m = AsciiString.indexOf(paramCharSequence, '%', i1 + 7);
    if (m >= 0) {
      i = m;
    }
    return isValidIpV4Address(paramCharSequence, i1, i);
    label438:
    int i2 = k;
    label442:
    if (n < 0)
    {
      bool3 = bool2;
      if (j == 7)
      {
        bool3 = bool2;
        if (i1 > 0) {
          bool3 = true;
        }
      }
      return bool3;
    }
    if (n + 2 != i2)
    {
      bool3 = bool1;
      if (i1 <= 0) {
        break label508;
      }
      if (j >= 8)
      {
        bool3 = bool1;
        if (n > m) {
          break label508;
        }
      }
    }
    boolean bool3 = true;
    label508:
    return bool3;
  }
  
  public static boolean isValidIpV6Address(String paramString)
  {
    return isValidIpV6Address(paramString);
  }
  
  private static boolean isValidNumericChar(char paramChar)
  {
    boolean bool;
    if ((paramChar >= '0') && (paramChar <= '9')) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static StringBuilder newSocketAddressStringBuilder(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = paramString1.length();
    if (paramBoolean)
    {
      paramString2 = new StringBuilder(i + 1 + paramString2.length());
      paramString2.append(paramString1);
      return paramString2;
    }
    paramString2 = new StringBuilder(i + 3 + paramString2.length());
    if ((i > 1) && (paramString1.charAt(0) == '[') && (paramString1.charAt(i - 1) == ']'))
    {
      paramString2.append(paramString1);
      return paramString2;
    }
    paramString2.append('[');
    paramString2.append(paramString1);
    paramString2.append(']');
    return paramString2;
  }
  
  /* Error */
  private static Integer sysctlGetInt(String paramString)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 393	java/lang/ProcessBuilder
    //   3: dup
    //   4: iconst_2
    //   5: anewarray 270	java/lang/String
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 395
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_0
    //   17: aastore
    //   18: invokespecial 398	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   21: invokevirtual 402	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 408	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   29: astore_2
    //   30: new 410	java/io/InputStreamReader
    //   33: astore_3
    //   34: aload_3
    //   35: aload_2
    //   36: invokespecial 413	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: new 415	java/io/BufferedReader
    //   42: astore_2
    //   43: aload_2
    //   44: aload_3
    //   45: invokespecial 418	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: aload_2
    //   49: invokevirtual 421	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +68 -> 122
    //   57: aload_3
    //   58: aload_0
    //   59: invokevirtual 424	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifeq +60 -> 122
    //   65: aload_3
    //   66: invokevirtual 277	java/lang/String:length	()I
    //   69: iconst_1
    //   70: isub
    //   71: istore 4
    //   73: iload 4
    //   75: aload_0
    //   76: invokevirtual 277	java/lang/String:length	()I
    //   79: if_icmple +43 -> 122
    //   82: aload_3
    //   83: iload 4
    //   85: invokevirtual 274	java/lang/String:charAt	(I)C
    //   88: invokestatic 429	java/lang/Character:isDigit	(C)Z
    //   91: ifne +25 -> 116
    //   94: aload_3
    //   95: iload 4
    //   97: iconst_1
    //   98: iadd
    //   99: invokevirtual 431	java/lang/String:substring	(I)Ljava/lang/String;
    //   102: invokestatic 433	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   105: astore_0
    //   106: aload_2
    //   107: invokevirtual 436	java/io/BufferedReader:close	()V
    //   110: aload_1
    //   111: invokevirtual 439	java/lang/Process:destroy	()V
    //   114: aload_0
    //   115: areturn
    //   116: iinc 4 -1
    //   119: goto -46 -> 73
    //   122: aload_2
    //   123: invokevirtual 436	java/io/BufferedReader:close	()V
    //   126: aload_1
    //   127: invokevirtual 439	java/lang/Process:destroy	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 436	java/io/BufferedReader:close	()V
    //   137: aload_0
    //   138: athrow
    //   139: astore_0
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 439	java/lang/Process:destroy	()V
    //   148: aload_0
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   24	121	1	localProcess	Process
    //   29	105	2	localObject1	Object
    //   33	62	3	localObject2	Object
    //   71	46	4	i	int
    // Exception table:
    //   from	to	target	type
    //   48	53	132	finally
    //   57	73	132	finally
    //   73	106	132	finally
    //   25	48	139	finally
    //   106	110	139	finally
    //   122	126	139	finally
    //   133	139	139	finally
  }
  
  public static String toAddressString(InetAddress paramInetAddress)
  {
    return toAddressString(paramInetAddress, false);
  }
  
  public static String toAddressString(InetAddress paramInetAddress, boolean paramBoolean)
  {
    if ((paramInetAddress instanceof Inet4Address)) {
      return paramInetAddress.getHostAddress();
    }
    if ((paramInetAddress instanceof Inet6Address)) {
      return toAddressString(paramInetAddress.getAddress(), 0, paramBoolean);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unhandled type: ");
    localStringBuilder.append(paramInetAddress);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static String toAddressString(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[8];
    int j;
    int k;
    for (int i = paramInt;; i++)
    {
      j = 1;
      k = 1;
      if (i >= paramInt + 8) {
        break;
      }
      m = i << 1;
      n = paramArrayOfByte[m];
      arrayOfInt[i] = (paramArrayOfByte[(m + 1)] & 0xFF | (n & 0xFF) << 8);
    }
    int i1 = -1;
    int i2 = 0;
    int m = 0;
    int n = -1;
    paramInt = 0;
    int i5;
    for (i = -1; m < 8; i = i5)
    {
      int i3;
      int i4;
      if (arrayOfInt[m] == 0)
      {
        i3 = n;
        i4 = paramInt;
        i5 = i;
        if (n < 0)
        {
          i3 = m;
          i4 = paramInt;
          i5 = i;
        }
      }
      else
      {
        i3 = n;
        i4 = paramInt;
        i5 = i;
        if (n >= 0)
        {
          i3 = m - n;
          if (i3 > paramInt) {
            paramInt = i3;
          } else {
            n = i;
          }
          i3 = -1;
          i5 = n;
          i4 = paramInt;
        }
      }
      m++;
      n = i3;
      paramInt = i4;
    }
    if (n >= 0)
    {
      m -= n;
      if (m > paramInt)
      {
        paramInt = m;
        break label220;
      }
    }
    n = i;
    label220:
    if (paramInt == 1)
    {
      paramInt = 0;
      i = i1;
    }
    else
    {
      i = n;
    }
    m = paramInt + i;
    paramArrayOfByte = new StringBuilder(39);
    if (m < 0)
    {
      paramArrayOfByte.append(Integer.toHexString(arrayOfInt[0]));
      for (paramInt = k; paramInt < 8; paramInt++)
      {
        paramArrayOfByte.append(':');
        paramArrayOfByte.append(Integer.toHexString(arrayOfInt[paramInt]));
      }
    }
    if (inRangeEndExclusive(0, i, m))
    {
      paramArrayOfByte.append("::");
      paramInt = j;
      n = i2;
      if (paramBoolean)
      {
        paramInt = j;
        n = i2;
        if (m == 5)
        {
          paramInt = j;
          n = i2;
          if (arrayOfInt[5] == 65535)
          {
            n = 1;
            paramInt = j;
          }
        }
      }
    }
    else
    {
      paramArrayOfByte.append(Integer.toHexString(arrayOfInt[0]));
      n = i2;
    }
    for (paramInt = j; paramInt < 8; paramInt++) {
      if (!inRangeEndExclusive(paramInt, i, m))
      {
        if (!inRangeEndExclusive(paramInt - 1, i, m)) {
          if ((n != 0) && (paramInt != 6)) {
            paramArrayOfByte.append('.');
          } else {
            paramArrayOfByte.append(':');
          }
        }
        if ((n != 0) && (paramInt > 5))
        {
          paramArrayOfByte.append(arrayOfInt[paramInt] >> 8);
          paramArrayOfByte.append('.');
          paramArrayOfByte.append(arrayOfInt[paramInt] & 0xFF);
        }
        else
        {
          paramArrayOfByte.append(Integer.toHexString(arrayOfInt[paramInt]));
        }
      }
      else if (!inRangeEndExclusive(paramInt - 1, i, m))
      {
        paramArrayOfByte.append("::");
      }
    }
    return paramArrayOfByte.toString();
  }
  
  public static String toSocketAddressString(String paramString, int paramInt)
  {
    String str = String.valueOf(paramInt);
    paramString = newSocketAddressStringBuilder(paramString, str, isValidIpV6Address(paramString) ^ true);
    paramString.append(':');
    paramString.append(str);
    return paramString.toString();
  }
  
  public static String toSocketAddressString(InetSocketAddress paramInetSocketAddress)
  {
    String str = String.valueOf(paramInetSocketAddress.getPort());
    if (paramInetSocketAddress.isUnresolved())
    {
      paramInetSocketAddress = getHostname(paramInetSocketAddress);
      paramInetSocketAddress = newSocketAddressStringBuilder(paramInetSocketAddress, str, isValidIpV6Address(paramInetSocketAddress) ^ true);
    }
    else
    {
      paramInetSocketAddress = paramInetSocketAddress.getAddress();
      paramInetSocketAddress = newSocketAddressStringBuilder(toAddressString(paramInetSocketAddress), str, paramInetSocketAddress instanceof Inet4Address);
    }
    paramInetSocketAddress.append(':');
    paramInetSocketAddress.append(str);
    return paramInetSocketAddress.toString();
  }
  
  static byte[] validIpV4ToBytes(String paramString)
  {
    int i = paramString.indexOf('.', 1);
    int j = ipv4WordToByte(paramString, 0, i);
    int k = paramString.indexOf('.', i + 2);
    int m = ipv4WordToByte(paramString, i + 1, k);
    i = paramString.indexOf('.', k + 2);
    return new byte[] { j, m, ipv4WordToByte(paramString, k + 1, i), ipv4WordToByte(paramString, i + 1, paramString.length()) };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\NetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */