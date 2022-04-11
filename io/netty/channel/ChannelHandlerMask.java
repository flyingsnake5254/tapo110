package io.netty.channel;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.WeakHashMap;

final class ChannelHandlerMask
{
  private static final FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>> MASKS = new FastThreadLocal()
  {
    protected Map<Class<? extends ChannelHandler>, Integer> initialValue()
    {
      return new WeakHashMap(32);
    }
  };
  private static final int MASK_ALL_INBOUND = 511;
  private static final int MASK_ALL_OUTBOUND = 130561;
  static final int MASK_BIND = 512;
  static final int MASK_CHANNEL_ACTIVE = 8;
  static final int MASK_CHANNEL_INACTIVE = 16;
  static final int MASK_CHANNEL_READ = 32;
  static final int MASK_CHANNEL_READ_COMPLETE = 64;
  static final int MASK_CHANNEL_REGISTERED = 2;
  static final int MASK_CHANNEL_UNREGISTERED = 4;
  static final int MASK_CHANNEL_WRITABILITY_CHANGED = 256;
  static final int MASK_CLOSE = 4096;
  static final int MASK_CONNECT = 1024;
  static final int MASK_DEREGISTER = 8192;
  static final int MASK_DISCONNECT = 2048;
  static final int MASK_EXCEPTION_CAUGHT = 1;
  static final int MASK_FLUSH = 65536;
  static final int MASK_ONLY_INBOUND = 510;
  static final int MASK_ONLY_OUTBOUND = 130560;
  static final int MASK_READ = 16384;
  static final int MASK_USER_EVENT_TRIGGERED = 128;
  static final int MASK_WRITE = 32768;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelHandlerMask.class);
  
  private static boolean isSkippable(Class<?> paramClass, final String paramString, final Class<?>... paramVarArgs)
    throws Exception
  {
    ((Boolean)AccessController.doPrivileged(new PrivilegedExceptionAction()
    {
      public Boolean run()
        throws Exception
      {
        boolean bool = true;
        try
        {
          Method localMethod = this.val$handlerType.getMethod(paramString, paramVarArgs);
          if ((localMethod == null) || (!localMethod.isAnnotationPresent(ChannelHandlerMask.a.class))) {
            bool = false;
          }
          return Boolean.valueOf(bool);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          if (ChannelHandlerMask.logger.isDebugEnabled()) {
            ChannelHandlerMask.logger.debug("Class {} missing method {}, assume we can not skip execution", new Object[] { this.val$handlerType, paramString, localNoSuchMethodException });
          }
        }
        return Boolean.FALSE;
      }
    })).booleanValue();
  }
  
  static int mask(Class<? extends ChannelHandler> paramClass)
  {
    Map localMap = (Map)MASKS.get();
    Integer localInteger1 = (Integer)localMap.get(paramClass);
    Integer localInteger2 = localInteger1;
    if (localInteger1 == null)
    {
      localInteger2 = Integer.valueOf(mask0(paramClass));
      localMap.put(paramClass, localInteger2);
    }
    return localInteger2.intValue();
  }
  
  /* Error */
  private static int mask0(Class<? extends ChannelHandler> paramClass)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc -123
    //   4: aload_0
    //   5: invokevirtual 139	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +260 -> 270
    //   13: sipush 511
    //   16: istore_3
    //   17: aload_0
    //   18: ldc -115
    //   20: iconst_1
    //   21: anewarray 135	java/lang/Class
    //   24: dup
    //   25: iconst_0
    //   26: ldc -113
    //   28: aastore
    //   29: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +7 -> 41
    //   37: sipush 509
    //   40: istore_3
    //   41: iload_3
    //   42: istore 4
    //   44: iload_3
    //   45: istore_1
    //   46: aload_0
    //   47: ldc -109
    //   49: iconst_1
    //   50: anewarray 135	java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc -113
    //   57: aastore
    //   58: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   61: ifeq +9 -> 70
    //   64: iload_3
    //   65: bipush -5
    //   67: iand
    //   68: istore 4
    //   70: iload 4
    //   72: istore_3
    //   73: iload 4
    //   75: istore_1
    //   76: aload_0
    //   77: ldc -107
    //   79: iconst_1
    //   80: anewarray 135	java/lang/Class
    //   83: dup
    //   84: iconst_0
    //   85: ldc -113
    //   87: aastore
    //   88: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   91: ifeq +9 -> 100
    //   94: iload 4
    //   96: bipush -9
    //   98: iand
    //   99: istore_3
    //   100: iload_3
    //   101: istore 4
    //   103: iload_3
    //   104: istore_1
    //   105: aload_0
    //   106: ldc -105
    //   108: iconst_1
    //   109: anewarray 135	java/lang/Class
    //   112: dup
    //   113: iconst_0
    //   114: ldc -113
    //   116: aastore
    //   117: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   120: ifeq +9 -> 129
    //   123: iload_3
    //   124: bipush -17
    //   126: iand
    //   127: istore 4
    //   129: iload 4
    //   131: istore_3
    //   132: iload 4
    //   134: istore_1
    //   135: aload_0
    //   136: ldc -103
    //   138: iconst_2
    //   139: anewarray 135	java/lang/Class
    //   142: dup
    //   143: iconst_0
    //   144: ldc -113
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: ldc 4
    //   151: aastore
    //   152: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   155: ifeq +9 -> 164
    //   158: iload 4
    //   160: bipush -33
    //   162: iand
    //   163: istore_3
    //   164: iload_3
    //   165: istore 4
    //   167: iload_3
    //   168: istore_1
    //   169: aload_0
    //   170: ldc -101
    //   172: iconst_1
    //   173: anewarray 135	java/lang/Class
    //   176: dup
    //   177: iconst_0
    //   178: ldc -113
    //   180: aastore
    //   181: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   184: ifeq +9 -> 193
    //   187: iload_3
    //   188: bipush -65
    //   190: iand
    //   191: istore 4
    //   193: iload 4
    //   195: istore_3
    //   196: iload 4
    //   198: istore_1
    //   199: aload_0
    //   200: ldc -99
    //   202: iconst_1
    //   203: anewarray 135	java/lang/Class
    //   206: dup
    //   207: iconst_0
    //   208: ldc -113
    //   210: aastore
    //   211: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   214: ifeq +10 -> 224
    //   217: iload 4
    //   219: sipush 65279
    //   222: iand
    //   223: istore_3
    //   224: iload_3
    //   225: istore 4
    //   227: iload_3
    //   228: istore_1
    //   229: aload_0
    //   230: ldc -97
    //   232: iconst_2
    //   233: anewarray 135	java/lang/Class
    //   236: dup
    //   237: iconst_0
    //   238: ldc -113
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: ldc 4
    //   245: aastore
    //   246: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   249: ifeq +24 -> 273
    //   252: iload_3
    //   253: sipush 65407
    //   256: iand
    //   257: istore 4
    //   259: goto +14 -> 273
    //   262: astore_0
    //   263: sipush 511
    //   266: istore_1
    //   267: goto +365 -> 632
    //   270: iconst_1
    //   271: istore 4
    //   273: iload 4
    //   275: istore_3
    //   276: iload 4
    //   278: istore_1
    //   279: ldc -95
    //   281: aload_0
    //   282: invokevirtual 139	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   285: ifeq +305 -> 590
    //   288: iload 4
    //   290: ldc 19
    //   292: ior
    //   293: istore 4
    //   295: iload 4
    //   297: istore_3
    //   298: iload 4
    //   300: istore_1
    //   301: aload_0
    //   302: ldc -93
    //   304: iconst_3
    //   305: anewarray 135	java/lang/Class
    //   308: dup
    //   309: iconst_0
    //   310: ldc -113
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: ldc -91
    //   317: aastore
    //   318: dup
    //   319: iconst_2
    //   320: ldc -89
    //   322: aastore
    //   323: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   326: ifeq +10 -> 336
    //   329: iload 4
    //   331: sipush 65023
    //   334: iand
    //   335: istore_3
    //   336: iload_3
    //   337: istore 4
    //   339: iload_3
    //   340: istore_1
    //   341: aload_0
    //   342: ldc -87
    //   344: iconst_4
    //   345: anewarray 135	java/lang/Class
    //   348: dup
    //   349: iconst_0
    //   350: ldc -113
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: ldc -91
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: ldc -91
    //   362: aastore
    //   363: dup
    //   364: iconst_3
    //   365: ldc -89
    //   367: aastore
    //   368: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   371: ifeq +10 -> 381
    //   374: iload_3
    //   375: sipush 64511
    //   378: iand
    //   379: istore 4
    //   381: iload 4
    //   383: istore 5
    //   385: iload 4
    //   387: istore_1
    //   388: aload_0
    //   389: ldc -85
    //   391: iconst_2
    //   392: anewarray 135	java/lang/Class
    //   395: dup
    //   396: iconst_0
    //   397: ldc -113
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: ldc -89
    //   404: aastore
    //   405: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   408: ifeq +11 -> 419
    //   411: iload 4
    //   413: sipush 63487
    //   416: iand
    //   417: istore 5
    //   419: iload 5
    //   421: istore_3
    //   422: iload 5
    //   424: istore_1
    //   425: aload_0
    //   426: ldc -83
    //   428: iconst_2
    //   429: anewarray 135	java/lang/Class
    //   432: dup
    //   433: iconst_0
    //   434: ldc -113
    //   436: aastore
    //   437: dup
    //   438: iconst_1
    //   439: ldc -89
    //   441: aastore
    //   442: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   445: ifeq +10 -> 455
    //   448: iload 5
    //   450: sipush 61439
    //   453: iand
    //   454: istore_3
    //   455: iload_3
    //   456: istore 4
    //   458: iload_3
    //   459: istore_1
    //   460: aload_0
    //   461: ldc -81
    //   463: iconst_2
    //   464: anewarray 135	java/lang/Class
    //   467: dup
    //   468: iconst_0
    //   469: ldc -113
    //   471: aastore
    //   472: dup
    //   473: iconst_1
    //   474: ldc -89
    //   476: aastore
    //   477: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   480: ifeq +10 -> 490
    //   483: iload_3
    //   484: sipush 57343
    //   487: iand
    //   488: istore 4
    //   490: iload 4
    //   492: istore_3
    //   493: iload 4
    //   495: istore_1
    //   496: aload_0
    //   497: ldc -79
    //   499: iconst_1
    //   500: anewarray 135	java/lang/Class
    //   503: dup
    //   504: iconst_0
    //   505: ldc -113
    //   507: aastore
    //   508: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   511: ifeq +10 -> 521
    //   514: iload 4
    //   516: sipush 49151
    //   519: iand
    //   520: istore_3
    //   521: iload_3
    //   522: istore 4
    //   524: iload_3
    //   525: istore_1
    //   526: aload_0
    //   527: ldc -77
    //   529: iconst_3
    //   530: anewarray 135	java/lang/Class
    //   533: dup
    //   534: iconst_0
    //   535: ldc -113
    //   537: aastore
    //   538: dup
    //   539: iconst_1
    //   540: ldc 4
    //   542: aastore
    //   543: dup
    //   544: iconst_2
    //   545: ldc -89
    //   547: aastore
    //   548: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   551: ifeq +9 -> 560
    //   554: ldc -76
    //   556: iload_3
    //   557: iand
    //   558: istore 4
    //   560: iload 4
    //   562: istore_3
    //   563: iload 4
    //   565: istore_1
    //   566: aload_0
    //   567: ldc -74
    //   569: iconst_1
    //   570: anewarray 135	java/lang/Class
    //   573: dup
    //   574: iconst_0
    //   575: ldc -113
    //   577: aastore
    //   578: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   581: ifeq +9 -> 590
    //   584: iload 4
    //   586: ldc -73
    //   588: iand
    //   589: istore_3
    //   590: iload_3
    //   591: istore_1
    //   592: aload_0
    //   593: ldc -71
    //   595: iconst_2
    //   596: anewarray 135	java/lang/Class
    //   599: dup
    //   600: iconst_0
    //   601: ldc -113
    //   603: aastore
    //   604: dup
    //   605: iconst_1
    //   606: ldc -69
    //   608: aastore
    //   609: invokestatic 145	io/netty/channel/ChannelHandlerMask:isSkippable	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Z
    //   612: istore_2
    //   613: iload_3
    //   614: istore_1
    //   615: iload_2
    //   616: ifeq +20 -> 636
    //   619: iload_3
    //   620: bipush -2
    //   622: iand
    //   623: istore_1
    //   624: goto +12 -> 636
    //   627: astore_0
    //   628: goto +4 -> 632
    //   631: astore_0
    //   632: aload_0
    //   633: invokestatic 193	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   636: iload_1
    //   637: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramClass	Class<? extends ChannelHandler>
    //   1	636	1	i	int
    //   8	608	2	bool	boolean
    //   16	607	3	j	int
    //   42	547	4	k	int
    //   383	71	5	m	int
    // Exception table:
    //   from	to	target	type
    //   17	33	262	java/lang/Exception
    //   46	64	627	java/lang/Exception
    //   76	94	627	java/lang/Exception
    //   105	123	627	java/lang/Exception
    //   135	158	627	java/lang/Exception
    //   169	187	627	java/lang/Exception
    //   199	217	627	java/lang/Exception
    //   229	252	627	java/lang/Exception
    //   279	288	627	java/lang/Exception
    //   301	329	627	java/lang/Exception
    //   341	374	627	java/lang/Exception
    //   388	411	627	java/lang/Exception
    //   425	448	627	java/lang/Exception
    //   460	483	627	java/lang/Exception
    //   496	514	627	java/lang/Exception
    //   526	554	627	java/lang/Exception
    //   566	584	627	java/lang/Exception
    //   592	613	627	java/lang/Exception
    //   2	9	631	java/lang/Exception
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD})
  static @interface a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelHandlerMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */