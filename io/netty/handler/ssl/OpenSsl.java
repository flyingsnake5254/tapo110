package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class OpenSsl
{
  static final Set<String> AVAILABLE_CIPHER_SUITES;
  private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
  private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
  private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----";
  static final List<String> DEFAULT_CIPHERS;
  static final String[] EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
  private static final boolean IS_BORINGSSL;
  private static final String KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----";
  static final Set<String> SUPPORTED_PROTOCOLS_SET;
  private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
  private static final boolean SUPPORTS_OCSP;
  private static final boolean TLSV13_SUPPORTED;
  private static final Throwable UNAVAILABILITY_CAUSE;
  private static final boolean USE_KEYMANAGER_FACTORY;
  private static final InternalLogger logger;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 48	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: astore_0
    //   6: aload_0
    //   7: putstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   10: ldc 52
    //   12: iconst_0
    //   13: invokestatic 58	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
    //   16: ifeq +59 -> 75
    //   19: new 60	java/lang/UnsupportedOperationException
    //   22: dup
    //   23: ldc 62
    //   25: invokespecial 66	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: new 68	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: ldc 72
    //   40: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: ldc 78
    //   47: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   50: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: ldc 86
    //   57: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_0
    //   62: aload_2
    //   63: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: aload_1
    //   67: invokeinterface 95 3 0
    //   72: goto +228 -> 300
    //   75: ldc 97
    //   77: iconst_0
    //   78: ldc 2
    //   80: invokevirtual 101	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   83: invokestatic 105	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   86: pop
    //   87: aconst_null
    //   88: astore_2
    //   89: goto +50 -> 139
    //   92: astore_2
    //   93: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   96: astore_1
    //   97: new 68	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   104: astore_0
    //   105: aload_0
    //   106: ldc 107
    //   108: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: ldc 78
    //   115: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   118: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_0
    //   123: ldc 86
    //   125: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_1
    //   130: aload_0
    //   131: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokeinterface 109 2 0
    //   139: aload_2
    //   140: astore_1
    //   141: aload_2
    //   142: ifnonnull +158 -> 300
    //   145: invokestatic 112	io/netty/handler/ssl/OpenSsl:loadTcNative	()V
    //   148: goto +51 -> 199
    //   151: astore_2
    //   152: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   155: astore_1
    //   156: new 68	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   163: astore_0
    //   164: aload_0
    //   165: ldc 114
    //   167: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: ldc 78
    //   174: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   177: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_0
    //   182: ldc 116
    //   184: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: aload_0
    //   190: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: aload_2
    //   194: invokeinterface 95 3 0
    //   199: ldc 118
    //   201: aconst_null
    //   202: invokestatic 122	io/netty/util/internal/SystemPropertyUtil:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: astore_1
    //   206: aload_1
    //   207: ifnonnull +16 -> 223
    //   210: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   213: ldc 124
    //   215: invokeinterface 109 2 0
    //   220: goto +14 -> 234
    //   223: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   226: ldc 126
    //   228: aload_1
    //   229: invokeinterface 129 3 0
    //   234: aload_1
    //   235: invokestatic 133	io/netty/handler/ssl/OpenSsl:initializeTcNative	(Ljava/lang/String;)Z
    //   238: pop
    //   239: aconst_null
    //   240: astore_1
    //   241: goto +59 -> 300
    //   244: astore_0
    //   245: aload_2
    //   246: astore_1
    //   247: aload_2
    //   248: ifnonnull +5 -> 253
    //   251: aload_0
    //   252: astore_1
    //   253: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   256: astore_3
    //   257: new 68	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   264: astore_2
    //   265: aload_2
    //   266: ldc -121
    //   268: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_2
    //   273: ldc 78
    //   275: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   278: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_2
    //   283: ldc -119
    //   285: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_3
    //   290: aload_2
    //   291: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: aload_0
    //   295: invokeinterface 95 3 0
    //   300: aload_1
    //   301: putstatic 139	io/netty/handler/ssl/OpenSsl:UNAVAILABILITY_CAUSE	Ljava/lang/Throwable;
    //   304: aload_1
    //   305: ifnonnull +1548 -> 1853
    //   308: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   311: ldc -115
    //   313: invokestatic 146	io/netty/internal/tcnative/SSL:versionString	()Ljava/lang/String;
    //   316: invokeinterface 129 3 0
    //   321: new 148	java/util/ArrayList
    //   324: dup
    //   325: invokespecial 149	java/util/ArrayList:<init>	()V
    //   328: astore_2
    //   329: new 151	java/util/LinkedHashSet
    //   332: dup
    //   333: sipush 128
    //   336: invokespecial 154	java/util/LinkedHashSet:<init>	(I)V
    //   339: astore_0
    //   340: ldc -100
    //   342: invokestatic 157	io/netty/handler/ssl/OpenSsl:versionString	()Ljava/lang/String;
    //   345: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: istore 4
    //   350: iload 4
    //   352: putstatic 165	io/netty/handler/ssl/OpenSsl:IS_BORINGSSL	Z
    //   355: iload 4
    //   357: ifeq +28 -> 385
    //   360: iconst_3
    //   361: anewarray 159	java/lang/String
    //   364: dup
    //   365: iconst_0
    //   366: ldc -89
    //   368: aastore
    //   369: dup
    //   370: iconst_1
    //   371: ldc -87
    //   373: aastore
    //   374: dup
    //   375: iconst_2
    //   376: ldc -85
    //   378: aastore
    //   379: putstatic 173	io/netty/handler/ssl/OpenSsl:EXTRA_SUPPORTED_TLS_1_3_CIPHERS	[Ljava/lang/String;
    //   382: goto +9 -> 391
    //   385: getstatic 178	io/netty/util/internal/EmptyArrays:EMPTY_STRINGS	[Ljava/lang/String;
    //   388: putstatic 173	io/netty/handler/ssl/OpenSsl:EXTRA_SUPPORTED_TLS_1_3_CIPHERS	[Ljava/lang/String;
    //   391: bipush 63
    //   393: iconst_1
    //   394: invokestatic 184	io/netty/internal/tcnative/SSLContext:make	(II)J
    //   397: lstore 5
    //   399: new 68	java/lang/StringBuilder
    //   402: astore 7
    //   404: aload 7
    //   406: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   409: getstatic 189	io/netty/handler/ssl/SslUtils:TLSV13_CIPHERS	Ljava/util/Set;
    //   412: invokeinterface 195 1 0
    //   417: astore_3
    //   418: aload_3
    //   419: invokeinterface 201 1 0
    //   424: ifeq +41 -> 465
    //   427: aload_3
    //   428: invokeinterface 205 1 0
    //   433: checkcast 159	java/lang/String
    //   436: getstatic 165	io/netty/handler/ssl/OpenSsl:IS_BORINGSSL	Z
    //   439: invokestatic 211	io/netty/handler/ssl/CipherSuiteConverter:toOpenSsl	(Ljava/lang/String;Z)Ljava/lang/String;
    //   442: astore_1
    //   443: aload_1
    //   444: ifnull -26 -> 418
    //   447: aload 7
    //   449: aload_1
    //   450: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 7
    //   456: bipush 58
    //   458: invokevirtual 214	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: goto -44 -> 418
    //   465: aload 7
    //   467: invokevirtual 218	java/lang/StringBuilder:length	()I
    //   470: ifne +9 -> 479
    //   473: iconst_0
    //   474: istore 8
    //   476: goto +30 -> 506
    //   479: aload 7
    //   481: aload 7
    //   483: invokevirtual 218	java/lang/StringBuilder:length	()I
    //   486: iconst_1
    //   487: isub
    //   488: invokevirtual 221	java/lang/StringBuilder:setLength	(I)V
    //   491: lload 5
    //   493: aload 7
    //   495: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: iconst_1
    //   499: invokestatic 225	io/netty/internal/tcnative/SSLContext:setCipherSuite	(JLjava/lang/String;Z)Z
    //   502: pop
    //   503: iconst_1
    //   504: istore 8
    //   506: goto +20 -> 526
    //   509: astore_1
    //   510: iconst_0
    //   511: istore 4
    //   513: iconst_0
    //   514: istore 9
    //   516: iconst_0
    //   517: istore 8
    //   519: goto +860 -> 1379
    //   522: astore_1
    //   523: iconst_0
    //   524: istore 8
    //   526: lload 5
    //   528: ldc -29
    //   530: iconst_0
    //   531: invokestatic 225	io/netty/internal/tcnative/SSLContext:setCipherSuite	(JLjava/lang/String;Z)Z
    //   534: pop
    //   535: lload 5
    //   537: iconst_1
    //   538: invokestatic 231	io/netty/internal/tcnative/SSL:newSSL	(JZ)J
    //   541: lstore 10
    //   543: lload 10
    //   545: invokestatic 235	io/netty/internal/tcnative/SSL:getCiphers	(J)[Ljava/lang/String;
    //   548: astore_1
    //   549: aload_1
    //   550: arraylength
    //   551: istore 12
    //   553: iconst_0
    //   554: istore 13
    //   556: iload 13
    //   558: iload 12
    //   560: if_icmpge +58 -> 618
    //   563: aload_1
    //   564: iload 13
    //   566: aaload
    //   567: astore_3
    //   568: aload_3
    //   569: ifnull +43 -> 612
    //   572: aload_3
    //   573: invokevirtual 238	java/lang/String:isEmpty	()Z
    //   576: ifne +36 -> 612
    //   579: aload_0
    //   580: aload_3
    //   581: invokeinterface 241 2 0
    //   586: ifne +26 -> 612
    //   589: iload 8
    //   591: ifne +13 -> 604
    //   594: aload_3
    //   595: invokestatic 244	io/netty/handler/ssl/SslUtils:isTLSv13Cipher	(Ljava/lang/String;)Z
    //   598: ifeq +6 -> 604
    //   601: goto +11 -> 612
    //   604: aload_0
    //   605: aload_3
    //   606: invokeinterface 247 2 0
    //   611: pop
    //   612: iinc 13 1
    //   615: goto -59 -> 556
    //   618: getstatic 165	io/netty/handler/ssl/OpenSsl:IS_BORINGSSL	Z
    //   621: istore 4
    //   623: iload 4
    //   625: ifeq +37 -> 662
    //   628: aload_0
    //   629: getstatic 173	io/netty/handler/ssl/OpenSsl:EXTRA_SUPPORTED_TLS_1_3_CIPHERS	[Ljava/lang/String;
    //   632: invokestatic 253	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   635: pop
    //   636: aload_0
    //   637: iconst_3
    //   638: anewarray 159	java/lang/String
    //   641: dup
    //   642: iconst_0
    //   643: ldc -1
    //   645: aastore
    //   646: dup
    //   647: iconst_1
    //   648: ldc_w 257
    //   651: aastore
    //   652: dup
    //   653: iconst_2
    //   654: ldc_w 259
    //   657: aastore
    //   658: invokestatic 253	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   661: pop
    //   662: ldc 25
    //   664: getstatic 265	io/netty/util/CharsetUtil:US_ASCII	Ljava/nio/charset/Charset;
    //   667: invokevirtual 269	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   670: invokestatic 275	io/netty/handler/ssl/PemPrivateKey:valueOf	([B)Lio/netty/handler/ssl/PemPrivateKey;
    //   673: astore_3
    //   674: lload 5
    //   676: aconst_null
    //   677: invokestatic 279	io/netty/internal/tcnative/SSLContext:setCertificateCallback	(JLio/netty/internal/tcnative/CertificateCallback;)V
    //   680: invokestatic 283	io/netty/handler/ssl/OpenSsl:selfSignedCertificate	()Ljava/security/cert/X509Certificate;
    //   683: astore_1
    //   684: getstatic 289	io/netty/buffer/ByteBufAllocator:DEFAULT	Lio/netty/buffer/ByteBufAllocator;
    //   687: iconst_1
    //   688: anewarray 291	java/security/cert/X509Certificate
    //   691: dup
    //   692: iconst_0
    //   693: aload_1
    //   694: aastore
    //   695: invokestatic 297	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;[Ljava/security/cert/X509Certificate;)J
    //   698: lstore 14
    //   700: lload 14
    //   702: invokestatic 301	io/netty/internal/tcnative/SSL:parseX509Chain	(J)J
    //   705: lstore 16
    //   707: getstatic 306	io/netty/buffer/UnpooledByteBufAllocator:DEFAULT	Lio/netty/buffer/UnpooledByteBufAllocator;
    //   710: aload_3
    //   711: invokeinterface 312 1 0
    //   716: invokestatic 315	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/handler/ssl/PemEncoded;)J
    //   719: lstore 18
    //   721: lload 18
    //   723: aconst_null
    //   724: invokestatic 319	io/netty/internal/tcnative/SSL:parsePrivateKey	(JLjava/lang/String;)J
    //   727: lstore 20
    //   729: lload 10
    //   731: lload 16
    //   733: lload 20
    //   735: invokestatic 323	io/netty/internal/tcnative/SSL:setKeyMaterial	(JJJ)V
    //   738: ldc_w 325
    //   741: invokestatic 327	io/netty/util/internal/SystemPropertyUtil:contains	(Ljava/lang/String;)Z
    //   744: istore 22
    //   746: iload 4
    //   748: ifne +47 -> 795
    //   751: ldc_w 325
    //   754: iconst_1
    //   755: invokestatic 58	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
    //   758: istore 9
    //   760: iload 9
    //   762: istore 4
    //   764: iload 22
    //   766: ifeq +58 -> 824
    //   769: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   772: ldc_w 329
    //   775: invokeinterface 332 2 0
    //   780: iload 9
    //   782: istore 4
    //   784: goto +40 -> 824
    //   787: astore_1
    //   788: iload 9
    //   790: istore 4
    //   792: goto +39 -> 831
    //   795: iload 22
    //   797: ifeq +24 -> 821
    //   800: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   803: ldc_w 334
    //   806: invokeinterface 332 2 0
    //   811: goto +10 -> 821
    //   814: astore_1
    //   815: iconst_1
    //   816: istore 4
    //   818: goto +13 -> 831
    //   821: iconst_1
    //   822: istore 4
    //   824: goto +18 -> 842
    //   827: astore_1
    //   828: iconst_0
    //   829: istore 4
    //   831: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   834: ldc_w 336
    //   837: invokeinterface 109 2 0
    //   842: aload_3
    //   843: invokeinterface 341 1 0
    //   848: pop
    //   849: iconst_1
    //   850: istore 22
    //   852: iload 4
    //   854: istore 9
    //   856: iload 22
    //   858: istore 4
    //   860: goto +171 -> 1031
    //   863: astore_1
    //   864: iconst_1
    //   865: istore 9
    //   867: lload 18
    //   869: lstore 23
    //   871: goto +386 -> 1257
    //   874: astore_1
    //   875: iconst_1
    //   876: istore 22
    //   878: goto +276 -> 1154
    //   881: astore_1
    //   882: iconst_1
    //   883: istore 22
    //   885: iload 4
    //   887: istore 9
    //   889: iload 22
    //   891: istore 4
    //   893: goto +96 -> 989
    //   896: astore_1
    //   897: goto +64 -> 961
    //   900: astore_1
    //   901: goto +82 -> 983
    //   904: astore_1
    //   905: lconst_0
    //   906: lstore 20
    //   908: goto +53 -> 961
    //   911: astore_1
    //   912: lconst_0
    //   913: lstore 20
    //   915: goto +68 -> 983
    //   918: astore_1
    //   919: lconst_0
    //   920: lstore 18
    //   922: lload 18
    //   924: lstore 20
    //   926: goto +35 -> 961
    //   929: astore_1
    //   930: lconst_0
    //   931: lstore 18
    //   933: lload 18
    //   935: lstore 20
    //   937: goto +46 -> 983
    //   940: astore_1
    //   941: goto +11 -> 952
    //   944: astore_1
    //   945: goto +29 -> 974
    //   948: astore_1
    //   949: lconst_0
    //   950: lstore 14
    //   952: lconst_0
    //   953: lstore 16
    //   955: lconst_0
    //   956: lstore 18
    //   958: lconst_0
    //   959: lstore 20
    //   961: iconst_0
    //   962: istore 4
    //   964: iconst_0
    //   965: istore 22
    //   967: goto +187 -> 1154
    //   970: astore_1
    //   971: lconst_0
    //   972: lstore 14
    //   974: lconst_0
    //   975: lstore 16
    //   977: lconst_0
    //   978: lstore 18
    //   980: lconst_0
    //   981: lstore 20
    //   983: iconst_0
    //   984: istore 9
    //   986: iconst_0
    //   987: istore 4
    //   989: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   992: ldc_w 343
    //   995: invokeinterface 109 2 0
    //   1000: iload 9
    //   1002: istore 25
    //   1004: iload 4
    //   1006: istore 26
    //   1008: lload 18
    //   1010: lstore 23
    //   1012: lload 14
    //   1014: lstore 27
    //   1016: lload 16
    //   1018: lstore 29
    //   1020: lload 20
    //   1022: lstore 31
    //   1024: aload_3
    //   1025: invokeinterface 341 1 0
    //   1030: pop
    //   1031: iload 9
    //   1033: istore 26
    //   1035: iload 4
    //   1037: istore 22
    //   1039: lload 10
    //   1041: invokestatic 347	io/netty/internal/tcnative/SSL:freeSSL	(J)V
    //   1044: lload 14
    //   1046: lconst_0
    //   1047: lcmp
    //   1048: ifeq +16 -> 1064
    //   1051: iload 9
    //   1053: istore 26
    //   1055: iload 4
    //   1057: istore 22
    //   1059: lload 14
    //   1061: invokestatic 350	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   1064: lload 18
    //   1066: lconst_0
    //   1067: lcmp
    //   1068: ifeq +16 -> 1084
    //   1071: iload 9
    //   1073: istore 26
    //   1075: iload 4
    //   1077: istore 22
    //   1079: lload 18
    //   1081: invokestatic 350	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   1084: lload 16
    //   1086: lconst_0
    //   1087: lcmp
    //   1088: ifeq +16 -> 1104
    //   1091: iload 9
    //   1093: istore 26
    //   1095: iload 4
    //   1097: istore 22
    //   1099: lload 16
    //   1101: invokestatic 353	io/netty/internal/tcnative/SSL:freeX509Chain	(J)V
    //   1104: lload 20
    //   1106: lconst_0
    //   1107: lcmp
    //   1108: ifeq +16 -> 1124
    //   1111: iload 9
    //   1113: istore 26
    //   1115: iload 4
    //   1117: istore 22
    //   1119: lload 20
    //   1121: invokestatic 356	io/netty/internal/tcnative/SSL:freePrivateKey	(J)V
    //   1124: iload 9
    //   1126: istore 26
    //   1128: iload 4
    //   1130: istore 22
    //   1132: iload 8
    //   1134: istore 13
    //   1136: lload 5
    //   1138: invokestatic 360	io/netty/internal/tcnative/SSLContext:free	(J)I
    //   1141: pop
    //   1142: goto +307 -> 1449
    //   1145: astore_1
    //   1146: iload 4
    //   1148: istore 22
    //   1150: iload 9
    //   1152: istore 4
    //   1154: iload 4
    //   1156: istore 25
    //   1158: iload 22
    //   1160: istore 26
    //   1162: lload 18
    //   1164: lstore 23
    //   1166: lload 14
    //   1168: lstore 27
    //   1170: lload 16
    //   1172: lstore 29
    //   1174: lload 20
    //   1176: lstore 31
    //   1178: aload_3
    //   1179: invokeinterface 341 1 0
    //   1184: pop
    //   1185: iload 4
    //   1187: istore 25
    //   1189: iload 22
    //   1191: istore 26
    //   1193: lload 18
    //   1195: lstore 23
    //   1197: lload 14
    //   1199: lstore 27
    //   1201: lload 16
    //   1203: lstore 29
    //   1205: lload 20
    //   1207: lstore 31
    //   1209: aload_1
    //   1210: athrow
    //   1211: astore_1
    //   1212: iload 25
    //   1214: istore 4
    //   1216: iload 26
    //   1218: istore 9
    //   1220: lload 27
    //   1222: lstore 14
    //   1224: lload 29
    //   1226: lstore 16
    //   1228: lload 31
    //   1230: lstore 20
    //   1232: goto +25 -> 1257
    //   1235: astore_1
    //   1236: lconst_0
    //   1237: lstore 23
    //   1239: lload 23
    //   1241: lstore 14
    //   1243: lload 14
    //   1245: lstore 16
    //   1247: lload 16
    //   1249: lstore 20
    //   1251: iconst_0
    //   1252: istore 4
    //   1254: iconst_0
    //   1255: istore 9
    //   1257: iload 4
    //   1259: istore 26
    //   1261: iload 9
    //   1263: istore 22
    //   1265: lload 10
    //   1267: invokestatic 347	io/netty/internal/tcnative/SSL:freeSSL	(J)V
    //   1270: lload 14
    //   1272: lconst_0
    //   1273: lcmp
    //   1274: ifeq +16 -> 1290
    //   1277: iload 4
    //   1279: istore 26
    //   1281: iload 9
    //   1283: istore 22
    //   1285: lload 14
    //   1287: invokestatic 350	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   1290: lload 23
    //   1292: lconst_0
    //   1293: lcmp
    //   1294: ifeq +16 -> 1310
    //   1297: iload 4
    //   1299: istore 26
    //   1301: iload 9
    //   1303: istore 22
    //   1305: lload 23
    //   1307: invokestatic 350	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   1310: lload 16
    //   1312: lconst_0
    //   1313: lcmp
    //   1314: ifeq +16 -> 1330
    //   1317: iload 4
    //   1319: istore 26
    //   1321: iload 9
    //   1323: istore 22
    //   1325: lload 16
    //   1327: invokestatic 353	io/netty/internal/tcnative/SSL:freeX509Chain	(J)V
    //   1330: lload 20
    //   1332: lconst_0
    //   1333: lcmp
    //   1334: ifeq +16 -> 1350
    //   1337: iload 4
    //   1339: istore 26
    //   1341: iload 9
    //   1343: istore 22
    //   1345: lload 20
    //   1347: invokestatic 356	io/netty/internal/tcnative/SSL:freePrivateKey	(J)V
    //   1350: iload 4
    //   1352: istore 26
    //   1354: iload 9
    //   1356: istore 22
    //   1358: aload_1
    //   1359: athrow
    //   1360: astore_1
    //   1361: iload 26
    //   1363: istore 4
    //   1365: iload 22
    //   1367: istore 9
    //   1369: goto +10 -> 1379
    //   1372: astore_1
    //   1373: iconst_0
    //   1374: istore 4
    //   1376: iconst_0
    //   1377: istore 9
    //   1379: iload 4
    //   1381: istore 26
    //   1383: iload 9
    //   1385: istore 22
    //   1387: iload 8
    //   1389: istore 13
    //   1391: lload 5
    //   1393: invokestatic 360	io/netty/internal/tcnative/SSLContext:free	(J)I
    //   1396: pop
    //   1397: iload 4
    //   1399: istore 26
    //   1401: iload 9
    //   1403: istore 22
    //   1405: iload 8
    //   1407: istore 13
    //   1409: aload_1
    //   1410: athrow
    //   1411: astore_1
    //   1412: goto +13 -> 1425
    //   1415: astore_1
    //   1416: iconst_0
    //   1417: istore 26
    //   1419: iconst_0
    //   1420: istore 22
    //   1422: iconst_0
    //   1423: istore 13
    //   1425: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   1428: ldc_w 362
    //   1431: aload_1
    //   1432: invokeinterface 365 3 0
    //   1437: iload 13
    //   1439: istore 8
    //   1441: iload 22
    //   1443: istore 4
    //   1445: iload 26
    //   1447: istore 9
    //   1449: aload_0
    //   1450: invokestatic 369	java/util/Collections:unmodifiableSet	(Ljava/util/Set;)Ljava/util/Set;
    //   1453: astore_1
    //   1454: aload_1
    //   1455: putstatic 371	io/netty/handler/ssl/OpenSsl:AVAILABLE_OPENSSL_CIPHER_SUITES	Ljava/util/Set;
    //   1458: new 151	java/util/LinkedHashSet
    //   1461: dup
    //   1462: aload_1
    //   1463: invokeinterface 374 1 0
    //   1468: iconst_2
    //   1469: imul
    //   1470: invokespecial 154	java/util/LinkedHashSet:<init>	(I)V
    //   1473: astore_0
    //   1474: aload_1
    //   1475: invokeinterface 195 1 0
    //   1480: astore_3
    //   1481: aload_3
    //   1482: invokeinterface 201 1 0
    //   1487: ifeq +62 -> 1549
    //   1490: aload_3
    //   1491: invokeinterface 205 1 0
    //   1496: checkcast 159	java/lang/String
    //   1499: astore_1
    //   1500: aload_1
    //   1501: invokestatic 244	io/netty/handler/ssl/SslUtils:isTLSv13Cipher	(Ljava/lang/String;)Z
    //   1504: ifne +34 -> 1538
    //   1507: aload_0
    //   1508: aload_1
    //   1509: ldc_w 376
    //   1512: invokestatic 379	io/netty/handler/ssl/CipherSuiteConverter:toJava	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1515: invokeinterface 247 2 0
    //   1520: pop
    //   1521: aload_0
    //   1522: aload_1
    //   1523: ldc_w 381
    //   1526: invokestatic 379	io/netty/handler/ssl/CipherSuiteConverter:toJava	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1529: invokeinterface 247 2 0
    //   1534: pop
    //   1535: goto -54 -> 1481
    //   1538: aload_0
    //   1539: aload_1
    //   1540: invokeinterface 247 2 0
    //   1545: pop
    //   1546: goto -65 -> 1481
    //   1549: aload_0
    //   1550: aload_2
    //   1551: getstatic 384	io/netty/handler/ssl/SslUtils:DEFAULT_CIPHER_SUITES	[Ljava/lang/String;
    //   1554: invokestatic 388	io/netty/handler/ssl/SslUtils:addIfSupported	(Ljava/util/Set;Ljava/util/List;[Ljava/lang/String;)V
    //   1557: aload_0
    //   1558: aload_2
    //   1559: getstatic 391	io/netty/handler/ssl/SslUtils:TLSV13_CIPHER_SUITES	[Ljava/lang/String;
    //   1562: invokestatic 388	io/netty/handler/ssl/SslUtils:addIfSupported	(Ljava/util/Set;Ljava/util/List;[Ljava/lang/String;)V
    //   1565: aload_2
    //   1566: aload_0
    //   1567: invokestatic 395	io/netty/handler/ssl/SslUtils:useFallbackCiphersIfDefaultIsEmpty	(Ljava/util/List;Ljava/lang/Iterable;)V
    //   1570: aload_2
    //   1571: invokestatic 399	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1574: astore_1
    //   1575: aload_1
    //   1576: putstatic 401	io/netty/handler/ssl/OpenSsl:DEFAULT_CIPHERS	Ljava/util/List;
    //   1579: aload_0
    //   1580: invokestatic 369	java/util/Collections:unmodifiableSet	(Ljava/util/Set;)Ljava/util/Set;
    //   1583: astore_0
    //   1584: aload_0
    //   1585: putstatic 403	io/netty/handler/ssl/OpenSsl:AVAILABLE_JAVA_CIPHER_SUITES	Ljava/util/Set;
    //   1588: getstatic 371	io/netty/handler/ssl/OpenSsl:AVAILABLE_OPENSSL_CIPHER_SUITES	Ljava/util/Set;
    //   1591: astore_2
    //   1592: new 151	java/util/LinkedHashSet
    //   1595: dup
    //   1596: aload_2
    //   1597: invokeinterface 374 1 0
    //   1602: aload_0
    //   1603: invokeinterface 374 1 0
    //   1608: iadd
    //   1609: invokespecial 154	java/util/LinkedHashSet:<init>	(I)V
    //   1612: astore_3
    //   1613: aload_3
    //   1614: aload_2
    //   1615: invokeinterface 406 2 0
    //   1620: pop
    //   1621: aload_3
    //   1622: aload_0
    //   1623: invokeinterface 406 2 0
    //   1628: pop
    //   1629: aload_3
    //   1630: putstatic 408	io/netty/handler/ssl/OpenSsl:AVAILABLE_CIPHER_SUITES	Ljava/util/Set;
    //   1633: iload 4
    //   1635: putstatic 410	io/netty/handler/ssl/OpenSsl:SUPPORTS_KEYMANAGER_FACTORY	Z
    //   1638: iload 9
    //   1640: putstatic 412	io/netty/handler/ssl/OpenSsl:USE_KEYMANAGER_FACTORY	Z
    //   1643: new 151	java/util/LinkedHashSet
    //   1646: dup
    //   1647: bipush 6
    //   1649: invokespecial 154	java/util/LinkedHashSet:<init>	(I)V
    //   1652: astore_2
    //   1653: aload_2
    //   1654: ldc_w 414
    //   1657: invokeinterface 247 2 0
    //   1662: pop
    //   1663: iconst_1
    //   1664: getstatic 418	io/netty/internal/tcnative/SSL:SSL_OP_NO_SSLv2	I
    //   1667: invokestatic 422	io/netty/handler/ssl/OpenSsl:doesSupportProtocol	(II)Z
    //   1670: ifeq +13 -> 1683
    //   1673: aload_2
    //   1674: ldc_w 424
    //   1677: invokeinterface 247 2 0
    //   1682: pop
    //   1683: iconst_2
    //   1684: getstatic 427	io/netty/internal/tcnative/SSL:SSL_OP_NO_SSLv3	I
    //   1687: invokestatic 422	io/netty/handler/ssl/OpenSsl:doesSupportProtocol	(II)Z
    //   1690: ifeq +13 -> 1703
    //   1693: aload_2
    //   1694: ldc_w 429
    //   1697: invokeinterface 247 2 0
    //   1702: pop
    //   1703: iconst_4
    //   1704: getstatic 432	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1	I
    //   1707: invokestatic 422	io/netty/handler/ssl/OpenSsl:doesSupportProtocol	(II)Z
    //   1710: ifeq +13 -> 1723
    //   1713: aload_2
    //   1714: ldc_w 434
    //   1717: invokeinterface 247 2 0
    //   1722: pop
    //   1723: bipush 8
    //   1725: getstatic 437	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1_1	I
    //   1728: invokestatic 422	io/netty/handler/ssl/OpenSsl:doesSupportProtocol	(II)Z
    //   1731: ifeq +13 -> 1744
    //   1734: aload_2
    //   1735: ldc_w 439
    //   1738: invokeinterface 247 2 0
    //   1743: pop
    //   1744: bipush 16
    //   1746: getstatic 442	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1_2	I
    //   1749: invokestatic 422	io/netty/handler/ssl/OpenSsl:doesSupportProtocol	(II)Z
    //   1752: ifeq +13 -> 1765
    //   1755: aload_2
    //   1756: ldc_w 444
    //   1759: invokeinterface 247 2 0
    //   1764: pop
    //   1765: iload 8
    //   1767: ifeq +31 -> 1798
    //   1770: bipush 32
    //   1772: getstatic 447	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1_3	I
    //   1775: invokestatic 422	io/netty/handler/ssl/OpenSsl:doesSupportProtocol	(II)Z
    //   1778: ifeq +20 -> 1798
    //   1781: aload_2
    //   1782: ldc_w 449
    //   1785: invokeinterface 247 2 0
    //   1790: pop
    //   1791: iconst_1
    //   1792: putstatic 451	io/netty/handler/ssl/OpenSsl:TLSV13_SUPPORTED	Z
    //   1795: goto +7 -> 1802
    //   1798: iconst_0
    //   1799: putstatic 451	io/netty/handler/ssl/OpenSsl:TLSV13_SUPPORTED	Z
    //   1802: aload_2
    //   1803: invokestatic 369	java/util/Collections:unmodifiableSet	(Ljava/util/Set;)Ljava/util/Set;
    //   1806: astore_0
    //   1807: aload_0
    //   1808: putstatic 453	io/netty/handler/ssl/OpenSsl:SUPPORTED_PROTOCOLS_SET	Ljava/util/Set;
    //   1811: invokestatic 456	io/netty/handler/ssl/OpenSsl:doesSupportOcsp	()Z
    //   1814: putstatic 458	io/netty/handler/ssl/OpenSsl:SUPPORTS_OCSP	Z
    //   1817: getstatic 50	io/netty/handler/ssl/OpenSsl:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   1820: astore_2
    //   1821: aload_2
    //   1822: invokeinterface 461 1 0
    //   1827: ifeq +82 -> 1909
    //   1830: aload_2
    //   1831: ldc_w 463
    //   1834: aload_0
    //   1835: invokeinterface 129 3 0
    //   1840: aload_2
    //   1841: ldc_w 465
    //   1844: aload_1
    //   1845: invokeinterface 129 3 0
    //   1850: goto +59 -> 1909
    //   1853: invokestatic 469	java/util/Collections:emptyList	()Ljava/util/List;
    //   1856: putstatic 401	io/netty/handler/ssl/OpenSsl:DEFAULT_CIPHERS	Ljava/util/List;
    //   1859: invokestatic 473	java/util/Collections:emptySet	()Ljava/util/Set;
    //   1862: putstatic 371	io/netty/handler/ssl/OpenSsl:AVAILABLE_OPENSSL_CIPHER_SUITES	Ljava/util/Set;
    //   1865: invokestatic 473	java/util/Collections:emptySet	()Ljava/util/Set;
    //   1868: putstatic 403	io/netty/handler/ssl/OpenSsl:AVAILABLE_JAVA_CIPHER_SUITES	Ljava/util/Set;
    //   1871: invokestatic 473	java/util/Collections:emptySet	()Ljava/util/Set;
    //   1874: putstatic 408	io/netty/handler/ssl/OpenSsl:AVAILABLE_CIPHER_SUITES	Ljava/util/Set;
    //   1877: iconst_0
    //   1878: putstatic 410	io/netty/handler/ssl/OpenSsl:SUPPORTS_KEYMANAGER_FACTORY	Z
    //   1881: iconst_0
    //   1882: putstatic 412	io/netty/handler/ssl/OpenSsl:USE_KEYMANAGER_FACTORY	Z
    //   1885: invokestatic 473	java/util/Collections:emptySet	()Ljava/util/Set;
    //   1888: putstatic 453	io/netty/handler/ssl/OpenSsl:SUPPORTED_PROTOCOLS_SET	Ljava/util/Set;
    //   1891: iconst_0
    //   1892: putstatic 458	io/netty/handler/ssl/OpenSsl:SUPPORTS_OCSP	Z
    //   1895: iconst_0
    //   1896: putstatic 451	io/netty/handler/ssl/OpenSsl:TLSV13_SUPPORTED	Z
    //   1899: iconst_0
    //   1900: putstatic 165	io/netty/handler/ssl/OpenSsl:IS_BORINGSSL	Z
    //   1903: getstatic 178	io/netty/util/internal/EmptyArrays:EMPTY_STRINGS	[Ljava/lang/String;
    //   1906: putstatic 173	io/netty/handler/ssl/OpenSsl:EXTRA_SUPPORTED_TLS_1_3_CIPHERS	[Ljava/lang/String;
    //   1909: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	185	0	localObject1	Object
    //   244	51	0	localThrowable1	Throwable
    //   339	1496	0	localObject2	Object
    //   28	422	1	localObject3	Object
    //   509	1	1	localObject4	Object
    //   522	1	1	localException1	Exception
    //   548	146	1	localObject5	Object
    //   787	1	1	localObject6	Object
    //   814	1	1	localObject7	Object
    //   827	1	1	localObject8	Object
    //   863	1	1	localObject9	Object
    //   874	1	1	localObject10	Object
    //   881	1	1	localError1	Error
    //   896	1	1	localObject11	Object
    //   900	1	1	localError2	Error
    //   904	1	1	localObject12	Object
    //   911	1	1	localError3	Error
    //   918	1	1	localObject13	Object
    //   929	1	1	localError4	Error
    //   940	1	1	localObject14	Object
    //   944	1	1	localError5	Error
    //   948	1	1	localObject15	Object
    //   970	1	1	localError6	Error
    //   1145	65	1	localObject16	Object
    //   1211	1	1	localObject17	Object
    //   1235	124	1	localObject18	Object
    //   1360	1	1	localObject19	Object
    //   1372	38	1	localObject20	Object
    //   1411	1	1	localException2	Exception
    //   1415	17	1	localException3	Exception
    //   1453	392	1	localObject21	Object
    //   36	53	2	localStringBuilder1	StringBuilder
    //   92	50	2	localClassNotFoundException	ClassNotFoundException
    //   151	97	2	localThrowable2	Throwable
    //   264	1577	2	localObject22	Object
    //   256	1374	3	localObject23	Object
    //   348	1286	4	bool1	boolean
    //   397	995	5	l1	long
    //   402	92	7	localStringBuilder2	StringBuilder
    //   474	1292	8	i	int
    //   514	1125	9	bool2	boolean
    //   541	725	10	l2	long
    //   551	10	12	j	int
    //   554	884	13	k	int
    //   698	588	14	l3	long
    //   705	621	16	l4	long
    //   719	475	18	l5	long
    //   727	619	20	l6	long
    //   744	698	22	bool3	boolean
    //   869	437	23	l7	long
    //   1002	211	25	bool4	boolean
    //   1006	440	26	bool5	boolean
    //   1014	207	27	l8	long
    //   1018	207	29	l9	long
    //   1022	207	31	l10	long
    // Exception table:
    //   from	to	target	type
    //   75	87	92	java/lang/ClassNotFoundException
    //   145	148	151	finally
    //   199	206	244	finally
    //   210	220	244	finally
    //   223	234	244	finally
    //   234	239	244	finally
    //   399	418	509	finally
    //   418	443	509	finally
    //   447	462	509	finally
    //   465	473	509	finally
    //   479	503	509	finally
    //   399	418	522	java/lang/Exception
    //   418	443	522	java/lang/Exception
    //   447	462	522	java/lang/Exception
    //   465	473	522	java/lang/Exception
    //   479	503	522	java/lang/Exception
    //   769	780	787	finally
    //   800	811	814	finally
    //   738	746	827	finally
    //   751	760	827	finally
    //   842	849	863	finally
    //   831	842	874	finally
    //   831	842	881	java/lang/Error
    //   729	738	896	finally
    //   729	738	900	java/lang/Error
    //   721	729	904	finally
    //   721	729	911	java/lang/Error
    //   707	721	918	finally
    //   707	721	929	java/lang/Error
    //   700	707	940	finally
    //   700	707	944	java/lang/Error
    //   674	700	948	finally
    //   674	700	970	java/lang/Error
    //   989	1000	1145	finally
    //   1024	1031	1211	finally
    //   1178	1185	1211	finally
    //   1209	1211	1211	finally
    //   543	553	1235	finally
    //   572	589	1235	finally
    //   594	601	1235	finally
    //   604	612	1235	finally
    //   618	623	1235	finally
    //   628	662	1235	finally
    //   662	674	1235	finally
    //   1039	1044	1360	finally
    //   1059	1064	1360	finally
    //   1079	1084	1360	finally
    //   1099	1104	1360	finally
    //   1119	1124	1360	finally
    //   1265	1270	1360	finally
    //   1285	1290	1360	finally
    //   1305	1310	1360	finally
    //   1325	1330	1360	finally
    //   1345	1350	1360	finally
    //   1358	1360	1360	finally
    //   526	543	1372	finally
    //   1136	1142	1411	java/lang/Exception
    //   1391	1397	1411	java/lang/Exception
    //   1409	1411	1411	java/lang/Exception
    //   391	399	1415	java/lang/Exception
  }
  
  @Deprecated
  public static Set<String> availableCipherSuites()
  {
    return availableOpenSslCipherSuites();
  }
  
  public static Set<String> availableJavaCipherSuites()
  {
    return AVAILABLE_JAVA_CIPHER_SUITES;
  }
  
  public static Set<String> availableOpenSslCipherSuites()
  {
    return AVAILABLE_OPENSSL_CIPHER_SUITES;
  }
  
  /* Error */
  private static boolean doesSupportOcsp()
  {
    // Byte code:
    //   0: invokestatic 487	io/netty/handler/ssl/OpenSsl:version	()I
    //   3: i2l
    //   4: lstore_0
    //   5: iconst_1
    //   6: istore_2
    //   7: lload_0
    //   8: ldc2_w 488
    //   11: lcmp
    //   12: iflt +86 -> 98
    //   15: bipush 16
    //   17: iconst_1
    //   18: invokestatic 184	io/netty/internal/tcnative/SSLContext:make	(II)J
    //   21: lstore_0
    //   22: lload_0
    //   23: iconst_0
    //   24: invokestatic 493	io/netty/internal/tcnative/SSLContext:enableOcsp	(JZ)V
    //   27: iload_2
    //   28: istore_3
    //   29: lload_0
    //   30: ldc2_w 494
    //   33: lcmp
    //   34: ifeq +66 -> 100
    //   37: lload_0
    //   38: invokestatic 360	io/netty/internal/tcnative/SSLContext:free	(J)I
    //   41: pop
    //   42: iload_2
    //   43: istore_3
    //   44: goto +56 -> 100
    //   47: astore 4
    //   49: goto +14 -> 63
    //   52: astore 4
    //   54: goto +31 -> 85
    //   57: astore 4
    //   59: ldc2_w 494
    //   62: lstore_0
    //   63: lload_0
    //   64: ldc2_w 494
    //   67: lcmp
    //   68: ifeq +8 -> 76
    //   71: lload_0
    //   72: invokestatic 360	io/netty/internal/tcnative/SSLContext:free	(J)I
    //   75: pop
    //   76: aload 4
    //   78: athrow
    //   79: astore 4
    //   81: ldc2_w 494
    //   84: lstore_0
    //   85: lload_0
    //   86: ldc2_w 494
    //   89: lcmp
    //   90: ifeq +8 -> 98
    //   93: lload_0
    //   94: invokestatic 360	io/netty/internal/tcnative/SSLContext:free	(J)I
    //   97: pop
    //   98: iconst_0
    //   99: istore_3
    //   100: iload_3
    //   101: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   4	90	0	l	long
    //   6	37	2	bool1	boolean
    //   28	73	3	bool2	boolean
    //   47	1	4	localObject1	Object
    //   52	1	4	localException1	Exception
    //   57	20	4	localObject2	Object
    //   79	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   22	27	47	finally
    //   22	27	52	java/lang/Exception
    //   15	22	57	finally
    //   15	22	79	java/lang/Exception
  }
  
  /* Error */
  private static boolean doesSupportProtocol(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: iload_0
    //   7: iconst_2
    //   8: invokestatic 184	io/netty/internal/tcnative/SSLContext:make	(II)J
    //   11: lstore_2
    //   12: lload_2
    //   13: ldc2_w 494
    //   16: lcmp
    //   17: ifeq +8 -> 25
    //   20: lload_2
    //   21: invokestatic 360	io/netty/internal/tcnative/SSLContext:free	(J)I
    //   24: pop
    //   25: iconst_1
    //   26: ireturn
    //   27: astore 4
    //   29: aload 4
    //   31: athrow
    //   32: astore 4
    //   34: iconst_0
    //   35: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramInt1	int
    //   0	36	1	paramInt2	int
    //   11	10	2	l	long
    //   27	3	4	localObject	Object
    //   32	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	12	27	finally
    //   6	12	32	java/lang/Exception
  }
  
  public static void ensureAvailability()
  {
    Throwable localThrowable = UNAVAILABILITY_CAUSE;
    if (localThrowable == null) {
      return;
    }
    throw ((Error)new UnsatisfiedLinkError("failed to load the required native library").initCause(localThrowable));
  }
  
  private static boolean initializeTcNative(String paramString)
    throws Exception
  {
    return Library.initialize("provided", paramString);
  }
  
  @Deprecated
  public static boolean isAlpnSupported()
  {
    boolean bool;
    if (version() >= 268443648L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isAvailable()
  {
    boolean bool;
    if (UNAVAILABILITY_CAUSE == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isBoringSSL()
  {
    return IS_BORINGSSL;
  }
  
  public static boolean isCipherSuiteAvailable(String paramString)
  {
    String str = CipherSuiteConverter.toOpenSsl(paramString, IS_BORINGSSL);
    if (str != null) {
      paramString = str;
    }
    return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(paramString);
  }
  
  public static boolean isOcspSupported()
  {
    return SUPPORTS_OCSP;
  }
  
  static boolean isTlsv13Supported()
  {
    return TLSV13_SUPPORTED;
  }
  
  private static void loadTcNative()
    throws Exception
  {
    Object localObject1 = PlatformDependent.normalizedOs();
    String str1 = PlatformDependent.normalizedArch();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(5);
    Object localObject2;
    if ("linux".equalsIgnoreCase((String)localObject1))
    {
      localObject2 = PlatformDependent.normalizedLinuxClassifiers().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = (String)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("netty_tcnative");
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append('_');
        localStringBuilder.append(str1);
        localStringBuilder.append("_");
        localStringBuilder.append(str2);
        localLinkedHashSet.add(localStringBuilder.toString());
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("netty_tcnative");
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append('_');
      ((StringBuilder)localObject2).append(str1);
      localLinkedHashSet.add(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("netty_tcnative");
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append('_');
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("_fedora");
      localLinkedHashSet.add(((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("netty_tcnative");
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append('_');
      ((StringBuilder)localObject2).append(str1);
      localLinkedHashSet.add(((StringBuilder)localObject2).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("netty_tcnative");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(str1);
    localLinkedHashSet.add(((StringBuilder)localObject1).toString());
    localLinkedHashSet.add("netty_tcnative");
    NativeLibraryLoader.loadFirstAvailable(SSLContext.class.getClassLoader(), (String[])localLinkedHashSet.toArray(new String[0]));
  }
  
  static long memoryAddress(ByteBuf paramByteBuf)
  {
    long l;
    if (paramByteBuf.hasMemoryAddress()) {
      l = paramByteBuf.memoryAddress();
    } else {
      l = Buffer.address(paramByteBuf.nioBuffer());
    }
    return l;
  }
  
  static void releaseIfNeeded(ReferenceCounted paramReferenceCounted)
  {
    if (paramReferenceCounted.refCnt() > 0) {
      ReferenceCountUtil.safeRelease(paramReferenceCounted);
    }
  }
  
  static X509Certificate selfSignedCertificate()
    throws CertificateException
  {
    return (X509Certificate)SslContext.X509_CERT_FACTORY.generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----".getBytes(CharsetUtil.US_ASCII)));
  }
  
  @Deprecated
  public static boolean supportsHostnameValidation()
  {
    return isAvailable();
  }
  
  public static boolean supportsKeyManagerFactory()
  {
    return SUPPORTS_KEYMANAGER_FACTORY;
  }
  
  public static Throwable unavailabilityCause()
  {
    return UNAVAILABILITY_CAUSE;
  }
  
  static boolean useKeyManagerFactory()
  {
    return USE_KEYMANAGER_FACTORY;
  }
  
  public static int version()
  {
    int i;
    if (isAvailable()) {
      i = SSL.version();
    } else {
      i = -1;
    }
    return i;
  }
  
  public static String versionString()
  {
    String str;
    if (isAvailable()) {
      str = SSL.versionString();
    } else {
      str = null;
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */