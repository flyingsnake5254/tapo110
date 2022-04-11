package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

@SuppressJava6Requirement(reason="Unsafe access is guarded")
final class PlatformDependent0
{
  private static final long ADDRESS_FIELD_OFFSET;
  private static final Method ALLOCATE_ARRAY_METHOD;
  private static final long BYTE_ARRAY_BASE_OFFSET;
  private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
  private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
  static final int HASH_CODE_ASCII_SEED = -1028477387;
  static final int HASH_CODE_C1 = -862048943;
  static final int HASH_CODE_C2 = 461845907;
  private static final Object INTERNAL_UNSAFE;
  private static final long INT_ARRAY_BASE_OFFSET;
  private static final long INT_ARRAY_INDEX_SCALE;
  private static final boolean IS_ANDROID;
  private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
  private static final int JAVA_VERSION;
  private static final long LONG_ARRAY_BASE_OFFSET;
  private static final long LONG_ARRAY_INDEX_SCALE;
  private static final boolean UNALIGNED;
  static final Unsafe UNSAFE;
  private static final long UNSAFE_COPY_THRESHOLD = 1048576L;
  private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
  private static final InternalLogger logger;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 79	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: astore_0
    //   6: aload_0
    //   7: putstatic 81	io/netty/util/internal/PlatformDependent0:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   10: invokestatic 85	io/netty/util/internal/PlatformDependent0:explicitNoUnsafeCause0	()Ljava/lang/Throwable;
    //   13: astore_1
    //   14: aload_1
    //   15: putstatic 87	io/netty/util/internal/PlatformDependent0:EXPLICIT_NO_UNSAFE_CAUSE	Ljava/lang/Throwable;
    //   18: invokestatic 91	io/netty/util/internal/PlatformDependent0:javaVersion0	()I
    //   21: putstatic 93	io/netty/util/internal/PlatformDependent0:JAVA_VERSION	I
    //   24: invokestatic 97	io/netty/util/internal/PlatformDependent0:isAndroid0	()Z
    //   27: putstatic 99	io/netty/util/internal/PlatformDependent0:IS_ANDROID	Z
    //   30: invokestatic 102	io/netty/util/internal/PlatformDependent0:explicitTryReflectionSetAccessible0	()Z
    //   33: putstatic 104	io/netty/util/internal/PlatformDependent0:IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE	Z
    //   36: aconst_null
    //   37: astore_2
    //   38: aconst_null
    //   39: astore_3
    //   40: aconst_null
    //   41: astore 4
    //   43: aconst_null
    //   44: astore 5
    //   46: aload_1
    //   47: ifnull +17 -> 64
    //   50: aconst_null
    //   51: astore 6
    //   53: aload 6
    //   55: astore 7
    //   57: aload 7
    //   59: astore 8
    //   61: goto +304 -> 365
    //   64: iconst_1
    //   65: invokestatic 110	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   68: astore 9
    //   70: new 6	io/netty/util/internal/PlatformDependent0$1
    //   73: dup
    //   74: invokespecial 113	io/netty/util/internal/PlatformDependent0$1:<init>	()V
    //   77: invokestatic 119	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   80: astore 10
    //   82: aload 10
    //   84: instanceof 121
    //   87: ifeq +26 -> 113
    //   90: aload 10
    //   92: checkcast 121	java/lang/Throwable
    //   95: astore 7
    //   97: aload_0
    //   98: ldc 123
    //   100: aload 7
    //   102: invokeinterface 129 3 0
    //   107: aconst_null
    //   108: astore 10
    //   110: goto +21 -> 131
    //   113: aload 10
    //   115: checkcast 131	sun/misc/Unsafe
    //   118: astore 10
    //   120: aload_0
    //   121: ldc -123
    //   123: invokeinterface 136 2 0
    //   128: aload_1
    //   129: astore 7
    //   131: aload 7
    //   133: astore 11
    //   135: aload 10
    //   137: astore 12
    //   139: aload 10
    //   141: ifnull +61 -> 202
    //   144: new 10	io/netty/util/internal/PlatformDependent0$2
    //   147: dup
    //   148: aload 10
    //   150: invokespecial 139	io/netty/util/internal/PlatformDependent0$2:<init>	(Lsun/misc/Unsafe;)V
    //   153: invokestatic 119	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   156: astore 11
    //   158: aload 11
    //   160: ifnonnull +22 -> 182
    //   163: aload_0
    //   164: ldc -115
    //   166: invokeinterface 136 2 0
    //   171: aload 7
    //   173: astore 11
    //   175: aload 10
    //   177: astore 12
    //   179: goto +23 -> 202
    //   182: aload 11
    //   184: checkcast 121	java/lang/Throwable
    //   187: astore 11
    //   189: aload_0
    //   190: ldc -113
    //   192: aload 11
    //   194: invokeinterface 129 3 0
    //   199: aconst_null
    //   200: astore 12
    //   202: aload 12
    //   204: ifnull +72 -> 276
    //   207: new 12	io/netty/util/internal/PlatformDependent0$3
    //   210: dup
    //   211: aload 12
    //   213: aload 9
    //   215: invokespecial 146	io/netty/util/internal/PlatformDependent0$3:<init>	(Lsun/misc/Unsafe;Ljava/nio/ByteBuffer;)V
    //   218: invokestatic 119	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   221: astore 10
    //   223: aload 10
    //   225: instanceof 148
    //   228: ifeq +21 -> 249
    //   231: aload 10
    //   233: checkcast 148	java/lang/reflect/Field
    //   236: astore 10
    //   238: aload_0
    //   239: ldc -106
    //   241: invokeinterface 136 2 0
    //   246: goto +33 -> 279
    //   249: aload 10
    //   251: checkcast 121	java/lang/Throwable
    //   254: astore 11
    //   256: aload_0
    //   257: ldc -104
    //   259: aload 11
    //   261: invokeinterface 129 3 0
    //   266: aconst_null
    //   267: astore 12
    //   269: aload 12
    //   271: astore 10
    //   273: goto +6 -> 279
    //   276: aconst_null
    //   277: astore 10
    //   279: aload 11
    //   281: astore_1
    //   282: aload 9
    //   284: astore 6
    //   286: aload 12
    //   288: astore 7
    //   290: aload 10
    //   292: astore 8
    //   294: aload 12
    //   296: ifnull +69 -> 365
    //   299: aload 12
    //   301: ldc -102
    //   303: invokevirtual 158	sun/misc/Unsafe:arrayIndexScale	(Ljava/lang/Class;)I
    //   306: i2l
    //   307: lstore 13
    //   309: aload 11
    //   311: astore_1
    //   312: aload 9
    //   314: astore 6
    //   316: aload 12
    //   318: astore 7
    //   320: aload 10
    //   322: astore 8
    //   324: lload 13
    //   326: lconst_1
    //   327: lcmp
    //   328: ifeq +37 -> 365
    //   331: aload_0
    //   332: ldc -96
    //   334: lload 13
    //   336: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: invokeinterface 169 3 0
    //   344: new 171	java/lang/UnsupportedOperationException
    //   347: dup
    //   348: ldc -83
    //   350: invokespecial 175	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   353: astore_1
    //   354: aconst_null
    //   355: astore 7
    //   357: aload 10
    //   359: astore 8
    //   361: aload 9
    //   363: astore 6
    //   365: aload_1
    //   366: putstatic 177	io/netty/util/internal/PlatformDependent0:UNSAFE_UNAVAILABILITY_CAUSE	Ljava/lang/Throwable;
    //   369: aload 7
    //   371: putstatic 179	io/netty/util/internal/PlatformDependent0:UNSAFE	Lsun/misc/Unsafe;
    //   374: aload 7
    //   376: ifnonnull +58 -> 434
    //   379: ldc2_w 180
    //   382: putstatic 183	io/netty/util/internal/PlatformDependent0:ADDRESS_FIELD_OFFSET	J
    //   385: ldc2_w 180
    //   388: putstatic 185	io/netty/util/internal/PlatformDependent0:BYTE_ARRAY_BASE_OFFSET	J
    //   391: ldc2_w 180
    //   394: putstatic 187	io/netty/util/internal/PlatformDependent0:LONG_ARRAY_BASE_OFFSET	J
    //   397: ldc2_w 180
    //   400: putstatic 189	io/netty/util/internal/PlatformDependent0:LONG_ARRAY_INDEX_SCALE	J
    //   403: ldc2_w 180
    //   406: putstatic 191	io/netty/util/internal/PlatformDependent0:INT_ARRAY_BASE_OFFSET	J
    //   409: ldc2_w 180
    //   412: putstatic 193	io/netty/util/internal/PlatformDependent0:INT_ARRAY_INDEX_SCALE	J
    //   415: iconst_0
    //   416: putstatic 195	io/netty/util/internal/PlatformDependent0:UNALIGNED	Z
    //   419: aconst_null
    //   420: putstatic 197	io/netty/util/internal/PlatformDependent0:DIRECT_BUFFER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   423: aconst_null
    //   424: putstatic 199	io/netty/util/internal/PlatformDependent0:ALLOCATE_ARRAY_METHOD	Ljava/lang/reflect/Method;
    //   427: aload 4
    //   429: astore 10
    //   431: goto +502 -> 933
    //   434: new 14	io/netty/util/internal/PlatformDependent0$4
    //   437: astore 10
    //   439: aload 10
    //   441: aload 6
    //   443: invokespecial 202	io/netty/util/internal/PlatformDependent0$4:<init>	(Ljava/nio/ByteBuffer;)V
    //   446: aload 10
    //   448: invokestatic 119	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   451: astore 10
    //   453: aload 10
    //   455: instanceof 204
    //   458: ifeq +70 -> 528
    //   461: aload 7
    //   463: lconst_1
    //   464: invokevirtual 208	sun/misc/Unsafe:allocateMemory	(J)J
    //   467: lstore 13
    //   469: aload 10
    //   471: checkcast 204	java/lang/reflect/Constructor
    //   474: iconst_2
    //   475: anewarray 4	java/lang/Object
    //   478: dup
    //   479: iconst_0
    //   480: lload 13
    //   482: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: iconst_1
    //   489: invokestatic 213	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: invokevirtual 217	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   496: pop
    //   497: aload 10
    //   499: checkcast 204	java/lang/reflect/Constructor
    //   502: astore 10
    //   504: aload_0
    //   505: ldc -37
    //   507: invokeinterface 136 2 0
    //   512: goto +37 -> 549
    //   515: astore 10
    //   517: goto +465 -> 982
    //   520: astore 10
    //   522: aconst_null
    //   523: astore 10
    //   525: goto +24 -> 549
    //   528: aload_0
    //   529: ldc -35
    //   531: aload 10
    //   533: checkcast 121	java/lang/Throwable
    //   536: invokeinterface 129 3 0
    //   541: aconst_null
    //   542: astore 10
    //   544: ldc2_w 180
    //   547: lstore 13
    //   549: lload 13
    //   551: ldc2_w 180
    //   554: lcmp
    //   555: ifeq +11 -> 566
    //   558: getstatic 179	io/netty/util/internal/PlatformDependent0:UNSAFE	Lsun/misc/Unsafe;
    //   561: lload 13
    //   563: invokevirtual 225	sun/misc/Unsafe:freeMemory	(J)V
    //   566: aload 10
    //   568: putstatic 197	io/netty/util/internal/PlatformDependent0:DIRECT_BUFFER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   571: aload 8
    //   573: invokestatic 229	io/netty/util/internal/PlatformDependent0:objectFieldOffset	(Ljava/lang/reflect/Field;)J
    //   576: putstatic 183	io/netty/util/internal/PlatformDependent0:ADDRESS_FIELD_OFFSET	J
    //   579: getstatic 179	io/netty/util/internal/PlatformDependent0:UNSAFE	Lsun/misc/Unsafe;
    //   582: astore 10
    //   584: aload 10
    //   586: ldc -102
    //   588: invokevirtual 232	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   591: i2l
    //   592: putstatic 185	io/netty/util/internal/PlatformDependent0:BYTE_ARRAY_BASE_OFFSET	J
    //   595: aload 10
    //   597: ldc -22
    //   599: invokevirtual 232	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   602: i2l
    //   603: putstatic 191	io/netty/util/internal/PlatformDependent0:INT_ARRAY_BASE_OFFSET	J
    //   606: aload 10
    //   608: ldc -22
    //   610: invokevirtual 158	sun/misc/Unsafe:arrayIndexScale	(Ljava/lang/Class;)I
    //   613: i2l
    //   614: putstatic 193	io/netty/util/internal/PlatformDependent0:INT_ARRAY_INDEX_SCALE	J
    //   617: aload 10
    //   619: ldc -20
    //   621: invokevirtual 232	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   624: i2l
    //   625: putstatic 187	io/netty/util/internal/PlatformDependent0:LONG_ARRAY_BASE_OFFSET	J
    //   628: aload 10
    //   630: ldc -20
    //   632: invokevirtual 158	sun/misc/Unsafe:arrayIndexScale	(Ljava/lang/Class;)I
    //   635: i2l
    //   636: putstatic 189	io/netty/util/internal/PlatformDependent0:LONG_ARRAY_INDEX_SCALE	J
    //   639: new 16	io/netty/util/internal/PlatformDependent0$5
    //   642: dup
    //   643: invokespecial 237	io/netty/util/internal/PlatformDependent0$5:<init>	()V
    //   646: invokestatic 119	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   649: astore 10
    //   651: aload 10
    //   653: instanceof 239
    //   656: ifeq +31 -> 687
    //   659: aload 10
    //   661: checkcast 239	java/lang/Boolean
    //   664: invokevirtual 242	java/lang/Boolean:booleanValue	()Z
    //   667: istore 15
    //   669: getstatic 81	io/netty/util/internal/PlatformDependent0:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   672: ldc -12
    //   674: iload 15
    //   676: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   679: invokeinterface 169 3 0
    //   684: goto +43 -> 727
    //   687: ldc -7
    //   689: ldc -5
    //   691: invokestatic 257	io/netty/util/internal/SystemPropertyUtil:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   694: ldc_w 259
    //   697: invokevirtual 265	java/lang/String:matches	(Ljava/lang/String;)Z
    //   700: istore 15
    //   702: aload 10
    //   704: checkcast 121	java/lang/Throwable
    //   707: astore 10
    //   709: getstatic 81	io/netty/util/internal/PlatformDependent0:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   712: ldc_w 267
    //   715: iload 15
    //   717: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   720: aload 10
    //   722: invokeinterface 270 4 0
    //   727: iload 15
    //   729: putstatic 195	io/netty/util/internal/PlatformDependent0:UNALIGNED	Z
    //   732: invokestatic 273	io/netty/util/internal/PlatformDependent0:javaVersion	()I
    //   735: bipush 9
    //   737: if_icmplt +174 -> 911
    //   740: new 18	io/netty/util/internal/PlatformDependent0$6
    //   743: dup
    //   744: invokespecial 274	io/netty/util/internal/PlatformDependent0$6:<init>	()V
    //   747: invokestatic 119	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   750: astore 7
    //   752: aload 7
    //   754: instanceof 121
    //   757: ifne +107 -> 864
    //   760: new 20	io/netty/util/internal/PlatformDependent0$7
    //   763: dup
    //   764: aload 7
    //   766: invokespecial 277	io/netty/util/internal/PlatformDependent0$7:<init>	(Ljava/lang/Object;)V
    //   769: invokestatic 119	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   772: astore 12
    //   774: aload 12
    //   776: astore 10
    //   778: aload 5
    //   780: astore 11
    //   782: aload 12
    //   784: instanceof 279
    //   787: ifeq +62 -> 849
    //   790: aload 12
    //   792: checkcast 279	java/lang/reflect/Method
    //   795: astore 11
    //   797: aload 11
    //   799: aload 7
    //   801: iconst_2
    //   802: anewarray 4	java/lang/Object
    //   805: dup
    //   806: iconst_0
    //   807: getstatic 285	java/lang/Byte:TYPE	Ljava/lang/Class;
    //   810: aastore
    //   811: dup
    //   812: iconst_1
    //   813: bipush 8
    //   815: invokestatic 213	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   818: aastore
    //   819: invokevirtual 289	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   822: checkcast 154	[B
    //   825: astore 10
    //   827: aload 12
    //   829: astore 10
    //   831: goto +18 -> 849
    //   834: astore 10
    //   836: aload 5
    //   838: astore 11
    //   840: goto +9 -> 849
    //   843: astore 10
    //   845: aload 5
    //   847: astore 11
    //   849: aload 10
    //   851: astore 12
    //   853: aload 7
    //   855: astore 10
    //   857: aload 12
    //   859: astore 7
    //   861: goto +9 -> 870
    //   864: aconst_null
    //   865: astore 10
    //   867: aload_2
    //   868: astore 11
    //   870: aload 7
    //   872: instanceof 121
    //   875: ifeq +22 -> 897
    //   878: getstatic 81	io/netty/util/internal/PlatformDependent0:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   881: ldc_w 291
    //   884: aload 7
    //   886: checkcast 121	java/lang/Throwable
    //   889: invokeinterface 129 3 0
    //   894: goto +34 -> 928
    //   897: getstatic 81	io/netty/util/internal/PlatformDependent0:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   900: ldc_w 293
    //   903: invokeinterface 136 2 0
    //   908: goto +20 -> 928
    //   911: getstatic 81	io/netty/util/internal/PlatformDependent0:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   914: ldc_w 295
    //   917: invokeinterface 136 2 0
    //   922: aconst_null
    //   923: astore 10
    //   925: aload_3
    //   926: astore 11
    //   928: aload 11
    //   930: putstatic 199	io/netty/util/internal/PlatformDependent0:ALLOCATE_ARRAY_METHOD	Ljava/lang/reflect/Method;
    //   933: aload 10
    //   935: putstatic 297	io/netty/util/internal/PlatformDependent0:INTERNAL_UNSAFE	Ljava/lang/Object;
    //   938: getstatic 81	io/netty/util/internal/PlatformDependent0:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   941: astore 11
    //   943: getstatic 197	io/netty/util/internal/PlatformDependent0:DIRECT_BUFFER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   946: ifnull +11 -> 957
    //   949: ldc_w 299
    //   952: astore 10
    //   954: goto +8 -> 962
    //   957: ldc_w 301
    //   960: astore 10
    //   962: aload 11
    //   964: ldc_w 303
    //   967: aload 10
    //   969: invokeinterface 169 3 0
    //   974: return
    //   975: astore 10
    //   977: ldc2_w 180
    //   980: lstore 13
    //   982: lload 13
    //   984: ldc2_w 180
    //   987: lcmp
    //   988: ifeq +11 -> 999
    //   991: getstatic 179	io/netty/util/internal/PlatformDependent0:UNSAFE	Lsun/misc/Unsafe;
    //   994: lload 13
    //   996: invokevirtual 225	sun/misc/Unsafe:freeMemory	(J)V
    //   999: aload 10
    //   1001: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	524	0	localInternalLogger	InternalLogger
    //   13	353	1	localObject1	Object
    //   37	831	2	localObject2	Object
    //   39	887	3	localObject3	Object
    //   41	387	4	localObject4	Object
    //   44	802	5	localObject5	Object
    //   51	391	6	localObject6	Object
    //   55	830	7	localObject7	Object
    //   59	513	8	localObject8	Object
    //   68	294	9	localByteBuffer	ByteBuffer
    //   80	423	10	localObject9	Object
    //   515	1	10	localObject10	Object
    //   520	1	10	localInstantiationException	InstantiationException
    //   523	307	10	localObject11	Object
    //   834	1	10	localInvocationTargetException	InvocationTargetException
    //   843	7	10	localIllegalAccessException	IllegalAccessException
    //   855	113	10	localObject12	Object
    //   975	25	10	localObject13	Object
    //   133	830	11	localObject14	Object
    //   137	721	12	localObject15	Object
    //   307	688	13	l	long
    //   667	61	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   469	512	515	finally
    //   469	512	520	java/lang/InstantiationException
    //   469	512	520	java/lang/IllegalAccessException
    //   469	512	520	java/lang/reflect/InvocationTargetException
    //   790	827	834	java/lang/reflect/InvocationTargetException
    //   790	827	843	java/lang/IllegalAccessException
    //   434	469	975	finally
    //   528	541	975	finally
  }
  
  static int addressSize()
  {
    return UNSAFE.addressSize();
  }
  
  static ByteBuffer allocateDirectNoCleaner(int paramInt)
  {
    return newDirectBuffer(UNSAFE.allocateMemory(Math.max(1, paramInt)), paramInt);
  }
  
  static long allocateMemory(long paramLong)
  {
    return UNSAFE.allocateMemory(paramLong);
  }
  
  static byte[] allocateUninitializedArray(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = (byte[])ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, new Object[] { Byte.TYPE, Integer.valueOf(paramInt) });
      return arrayOfByte;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new Error(localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new Error(localIllegalAccessException);
    }
  }
  
  static long byteArrayBaseOffset()
  {
    return BYTE_ARRAY_BASE_OFFSET;
  }
  
  static void copyMemory(long paramLong1, long paramLong2, long paramLong3)
  {
    if (javaVersion() <= 8) {
      copyMemoryWithSafePointPolling(paramLong1, paramLong2, paramLong3);
    } else {
      UNSAFE.copyMemory(paramLong1, paramLong2, paramLong3);
    }
  }
  
  static void copyMemory(Object paramObject1, long paramLong1, Object paramObject2, long paramLong2, long paramLong3)
  {
    if (javaVersion() <= 8) {
      copyMemoryWithSafePointPolling(paramObject1, paramLong1, paramObject2, paramLong2, paramLong3);
    } else {
      UNSAFE.copyMemory(paramObject1, paramLong1, paramObject2, paramLong2, paramLong3);
    }
  }
  
  private static void copyMemoryWithSafePointPolling(long paramLong1, long paramLong2, long paramLong3)
  {
    while (paramLong3 > 0L)
    {
      long l = Math.min(paramLong3, 1048576L);
      UNSAFE.copyMemory(paramLong1, paramLong2, l);
      paramLong3 -= l;
      paramLong1 += l;
      paramLong2 += l;
    }
  }
  
  private static void copyMemoryWithSafePointPolling(Object paramObject1, long paramLong1, Object paramObject2, long paramLong2, long paramLong3)
  {
    while (paramLong3 > 0L)
    {
      long l = Math.min(paramLong3, 1048576L);
      UNSAFE.copyMemory(paramObject1, paramLong1, paramObject2, paramLong2, l);
      paramLong3 -= l;
      paramLong1 += l;
      paramLong2 += l;
    }
  }
  
  static long directBufferAddress(ByteBuffer paramByteBuffer)
  {
    return getLong(paramByteBuffer, ADDRESS_FIELD_OFFSET);
  }
  
  static boolean equals(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    int i = paramInt3 & 0x7;
    long l1 = BYTE_ARRAY_BASE_OFFSET + paramInt1;
    long l2 = paramInt2 - paramInt1;
    boolean bool1 = false;
    boolean bool2 = false;
    Unsafe localUnsafe;
    if (paramInt3 >= 8)
    {
      long l3 = i + l1;
      for (l4 = l1 - 8L + paramInt3; l4 >= l3; l4 -= 8L)
      {
        localUnsafe = UNSAFE;
        if (localUnsafe.getLong(paramArrayOfByte1, l4) != localUnsafe.getLong(paramArrayOfByte2, l4 + l2)) {
          return false;
        }
      }
    }
    paramInt1 = i;
    if (i >= 4)
    {
      paramInt1 = i - 4;
      l4 = paramInt1 + l1;
      localUnsafe = UNSAFE;
      if (localUnsafe.getInt(paramArrayOfByte1, l4) != localUnsafe.getInt(paramArrayOfByte2, l4 + l2)) {
        return false;
      }
    }
    long l4 = l2 + l1;
    if (paramInt1 >= 2)
    {
      localUnsafe = UNSAFE;
      bool1 = bool2;
      if (localUnsafe.getChar(paramArrayOfByte1, l1) == localUnsafe.getChar(paramArrayOfByte2, l4)) {
        if (paramInt1 != 2)
        {
          bool1 = bool2;
          if (localUnsafe.getByte(paramArrayOfByte1, l1 + 2L) != localUnsafe.getByte(paramArrayOfByte2, l4 + 2L)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 != 0)
    {
      localUnsafe = UNSAFE;
      if (localUnsafe.getByte(paramArrayOfByte1, l1) != localUnsafe.getByte(paramArrayOfByte2, l4)) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  static int equalsConstantTime(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    long l1 = paramInt3 & 0x7;
    long l2 = BYTE_ARRAY_BASE_OFFSET + paramInt1;
    long l3 = l2 + l1;
    long l4 = paramInt2 - paramInt1;
    long l5 = l2 - 8L + paramInt3;
    long l6 = 0L;
    Unsafe localUnsafe;
    while (l5 >= l3)
    {
      localUnsafe = UNSAFE;
      l6 |= localUnsafe.getLong(paramArrayOfByte1, l5) ^ localUnsafe.getLong(paramArrayOfByte2, l5 + l4);
      l5 -= 8L;
    }
    long l7 = l1;
    l5 = l6;
    if (l1 >= 4L)
    {
      localUnsafe = UNSAFE;
      paramInt1 = localUnsafe.getInt(paramArrayOfByte1, l2);
      l5 = l6 | localUnsafe.getInt(paramArrayOfByte2, l2 + l4) ^ paramInt1;
      l7 = l1 - 4L;
    }
    l1 = l7;
    l6 = l5;
    if (l7 >= 2L)
    {
      l6 = l3 - l7;
      localUnsafe = UNSAFE;
      paramInt1 = localUnsafe.getChar(paramArrayOfByte1, l6);
      l6 = l5 | localUnsafe.getChar(paramArrayOfByte2, l6 + l4) ^ paramInt1;
      l1 = l7 - 2L;
    }
    l5 = l6;
    if (l1 == 1L)
    {
      l5 = l3 - 1L;
      localUnsafe = UNSAFE;
      l5 = l6 | localUnsafe.getByte(paramArrayOfByte1, l5) ^ localUnsafe.getByte(paramArrayOfByte2, l5 + l4);
    }
    return ConstantTimeUtils.equalsConstantTime(l5, 0L);
  }
  
  private static Throwable explicitNoUnsafeCause0()
  {
    boolean bool = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
    InternalLogger localInternalLogger = logger;
    localInternalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(bool));
    if (bool)
    {
      localInternalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
      return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
    }
    String str = "io.netty.tryUnsafe";
    if (!SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
      str = "org.jboss.netty.tryUnsafe";
    }
    if (!SystemPropertyUtil.getBoolean(str, true))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sun.misc.Unsafe: unavailable (");
      localStringBuilder.append(str);
      localStringBuilder.append(")");
      str = localStringBuilder.toString();
      localInternalLogger.debug(str);
      return new UnsupportedOperationException(str);
    }
    return null;
  }
  
  private static boolean explicitTryReflectionSetAccessible0()
  {
    boolean bool;
    if (javaVersion() < 9) {
      bool = true;
    } else {
      bool = false;
    }
    return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", bool);
  }
  
  static void freeMemory(long paramLong)
  {
    UNSAFE.freeMemory(paramLong);
  }
  
  static byte getByte(long paramLong)
  {
    return UNSAFE.getByte(paramLong);
  }
  
  static byte getByte(byte[] paramArrayOfByte, int paramInt)
  {
    return UNSAFE.getByte(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt);
  }
  
  static byte getByte(byte[] paramArrayOfByte, long paramLong)
  {
    return UNSAFE.getByte(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramLong);
  }
  
  static ClassLoader getClassLoader(Class<?> paramClass)
  {
    if (System.getSecurityManager() == null) {
      return paramClass.getClassLoader();
    }
    (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
    {
      public ClassLoader run()
      {
        return this.val$clazz.getClassLoader();
      }
    });
  }
  
  static ClassLoader getContextClassLoader()
  {
    if (System.getSecurityManager() == null) {
      return Thread.currentThread().getContextClassLoader();
    }
    (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
    {
      public ClassLoader run()
      {
        return Thread.currentThread().getContextClassLoader();
      }
    });
  }
  
  static int getInt(long paramLong)
  {
    return UNSAFE.getInt(paramLong);
  }
  
  static int getInt(Object paramObject, long paramLong)
  {
    return UNSAFE.getInt(paramObject, paramLong);
  }
  
  static int getInt(byte[] paramArrayOfByte, int paramInt)
  {
    return UNSAFE.getInt(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt);
  }
  
  static int getInt(int[] paramArrayOfInt, long paramLong)
  {
    return UNSAFE.getInt(paramArrayOfInt, INT_ARRAY_BASE_OFFSET + INT_ARRAY_INDEX_SCALE * paramLong);
  }
  
  static long getLong(long paramLong)
  {
    return UNSAFE.getLong(paramLong);
  }
  
  private static long getLong(Object paramObject, long paramLong)
  {
    return UNSAFE.getLong(paramObject, paramLong);
  }
  
  static long getLong(byte[] paramArrayOfByte, int paramInt)
  {
    return UNSAFE.getLong(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt);
  }
  
  static long getLong(long[] paramArrayOfLong, long paramLong)
  {
    return UNSAFE.getLong(paramArrayOfLong, LONG_ARRAY_BASE_OFFSET + LONG_ARRAY_INDEX_SCALE * paramLong);
  }
  
  static Object getObject(Object paramObject, long paramLong)
  {
    return UNSAFE.getObject(paramObject, paramLong);
  }
  
  static short getShort(long paramLong)
  {
    return UNSAFE.getShort(paramLong);
  }
  
  static short getShort(byte[] paramArrayOfByte, int paramInt)
  {
    return UNSAFE.getShort(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt);
  }
  
  static ClassLoader getSystemClassLoader()
  {
    if (System.getSecurityManager() == null) {
      return ClassLoader.getSystemClassLoader();
    }
    (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
    {
      public ClassLoader run()
      {
        return ClassLoader.getSystemClassLoader();
      }
    });
  }
  
  static Throwable getUnsafeUnavailabilityCause()
  {
    return UNSAFE_UNAVAILABILITY_CAUSE;
  }
  
  static boolean hasAllocateArrayMethod()
  {
    boolean bool;
    if (ALLOCATE_ARRAY_METHOD != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean hasDirectBufferNoCleanerConstructor()
  {
    boolean bool;
    if (DIRECT_BUFFER_CONSTRUCTOR != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean hasUnsafe()
  {
    boolean bool;
    if (UNSAFE != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static int hashCodeAscii(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = BYTE_ARRAY_BASE_OFFSET + paramInt1;
    int i = paramInt2 & 0x7;
    long l2 = i;
    long l3 = l1 - 8L + paramInt2;
    paramInt2 = -1028477387;
    while (l3 >= l2 + l1)
    {
      paramInt2 = hashCodeAsciiCompute(UNSAFE.getLong(paramArrayOfByte, l3), paramInt2);
      l3 -= 8L;
    }
    if (i == 0) {
      return paramInt2;
    }
    int j = 0;
    if (i != 2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (i != 4) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (i != 6) {
      m = 1;
    } else {
      m = 0;
    }
    int n = 461845907;
    if ((paramInt1 & k & m) != 0)
    {
      paramInt2 = paramInt2 * -862048943 + hashCodeAsciiSanitize(UNSAFE.getByte(paramArrayOfByte, l1));
      l3 = l1 + 1L;
      paramInt1 = 461845907;
    }
    else
    {
      paramInt1 = -862048943;
      l3 = l1;
    }
    if (i != 1) {
      m = 1;
    } else {
      m = 0;
    }
    int i1;
    if (i != 4) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i != 5) {
      j = 1;
    }
    l1 = l3;
    int i2 = paramInt1;
    int k = paramInt2;
    if ((j & m & i1) != 0)
    {
      k = paramInt2 * paramInt1 + hashCodeAsciiSanitize(UNSAFE.getShort(paramArrayOfByte, l3));
      if (paramInt1 == -862048943) {
        paramInt1 = n;
      } else {
        paramInt1 = -862048943;
      }
      l1 = l3 + 2L;
      i2 = paramInt1;
    }
    paramInt1 = k;
    if (i >= 4) {
      paramInt1 = k * i2 + hashCodeAsciiSanitize(UNSAFE.getInt(paramArrayOfByte, l1));
    }
    return paramInt1;
  }
  
  static int hashCodeAsciiCompute(long paramLong, int paramInt)
  {
    return paramInt * -862048943 + hashCodeAsciiSanitize((int)paramLong) * 461845907 + (int)((paramLong & 0x1F1F1F1F00000000) >>> 32);
  }
  
  static int hashCodeAsciiSanitize(byte paramByte)
  {
    return paramByte & 0x1F;
  }
  
  static int hashCodeAsciiSanitize(int paramInt)
  {
    return paramInt & 0x1F1F1F1F;
  }
  
  static int hashCodeAsciiSanitize(short paramShort)
  {
    return paramShort & 0x1F1F;
  }
  
  static boolean isAndroid()
  {
    return IS_ANDROID;
  }
  
  private static boolean isAndroid0()
  {
    boolean bool = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
    if (bool) {
      logger.debug("Platform: Android");
    }
    return bool;
  }
  
  static boolean isExplicitNoUnsafe()
  {
    boolean bool;
    if (EXPLICIT_NO_UNSAFE_CAUSE != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isExplicitTryReflectionSetAccessible()
  {
    return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
  }
  
  static boolean isUnaligned()
  {
    return UNALIGNED;
  }
  
  static boolean isZero(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramInt2 <= 0) {
      return true;
    }
    long l1 = BYTE_ARRAY_BASE_OFFSET + paramInt1;
    int i = paramInt2 & 0x7;
    long l2 = i;
    for (long l3 = l1 - 8L + paramInt2; l3 >= l2 + l1; l3 -= 8L) {
      if (UNSAFE.getLong(paramArrayOfByte, l3) != 0L) {
        return false;
      }
    }
    paramInt2 = i;
    if (i >= 4)
    {
      i -= 4;
      paramInt2 = i;
      if (UNSAFE.getInt(paramArrayOfByte, i + l1) != 0) {
        return false;
      }
    }
    if (paramInt2 >= 2)
    {
      if (UNSAFE.getChar(paramArrayOfByte, l1) == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 2) {
          break label153;
        }
        if (paramArrayOfByte[(paramInt1 + 2)] == 0)
        {
          bool1 = bool2;
          break label153;
        }
      }
      bool1 = false;
      label153:
      return bool1;
    }
    if (paramArrayOfByte[paramInt1] != 0) {
      bool1 = false;
    }
    return bool1;
  }
  
  static int javaVersion()
  {
    return JAVA_VERSION;
  }
  
  private static int javaVersion0()
  {
    int i;
    if (isAndroid0()) {
      i = 6;
    } else {
      i = majorVersionFromJavaSpecificationVersion();
    }
    logger.debug("Java version: {}", Integer.valueOf(i));
    return i;
  }
  
  static int majorVersion(String paramString)
  {
    paramString = paramString.split("\\.");
    int[] arrayOfInt = new int[paramString.length];
    for (int i = 0; i < paramString.length; i++) {
      arrayOfInt[i] = Integer.parseInt(paramString[i]);
    }
    if (arrayOfInt[0] == 1) {
      return arrayOfInt[1];
    }
    return arrayOfInt[0];
  }
  
  static int majorVersionFromJavaSpecificationVersion()
  {
    return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
  }
  
  static ByteBuffer newDirectBuffer(long paramLong, int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "capacity");
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)DIRECT_BUFFER_CONSTRUCTOR.newInstance(new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    finally
    {
      if ((localThrowable instanceof Error)) {
        throw ((Error)localThrowable);
      }
    }
  }
  
  static long objectFieldOffset(Field paramField)
  {
    return UNSAFE.objectFieldOffset(paramField);
  }
  
  static void putByte(long paramLong, byte paramByte)
  {
    UNSAFE.putByte(paramLong, paramByte);
  }
  
  static void putByte(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    UNSAFE.putByte(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt, paramByte);
  }
  
  static void putInt(long paramLong, int paramInt)
  {
    UNSAFE.putInt(paramLong, paramInt);
  }
  
  static void putInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    UNSAFE.putInt(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt1, paramInt2);
  }
  
  static void putLong(long paramLong1, long paramLong2)
  {
    UNSAFE.putLong(paramLong1, paramLong2);
  }
  
  static void putLong(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    UNSAFE.putLong(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt, paramLong);
  }
  
  static void putObject(Object paramObject1, long paramLong, Object paramObject2)
  {
    UNSAFE.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void putShort(long paramLong, short paramShort)
  {
    UNSAFE.putShort(paramLong, paramShort);
  }
  
  static void putShort(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    UNSAFE.putShort(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt, paramShort);
  }
  
  static ByteBuffer reallocateDirectNoCleaner(ByteBuffer paramByteBuffer, int paramInt)
  {
    return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(paramByteBuffer), paramInt), paramInt);
  }
  
  static long reallocateMemory(long paramLong1, long paramLong2)
  {
    return UNSAFE.reallocateMemory(paramLong1, paramLong2);
  }
  
  static void setMemory(long paramLong1, long paramLong2, byte paramByte)
  {
    UNSAFE.setMemory(paramLong1, paramLong2, paramByte);
  }
  
  static void setMemory(Object paramObject, long paramLong1, long paramLong2, byte paramByte)
  {
    UNSAFE.setMemory(paramObject, paramLong1, paramLong2, paramByte);
  }
  
  static void throwException(Throwable paramThrowable)
  {
    UNSAFE.throwException((Throwable)ObjectUtil.checkNotNull(paramThrowable, "cause"));
  }
  
  static boolean unalignedAccess()
  {
    return UNALIGNED;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\PlatformDependent0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */