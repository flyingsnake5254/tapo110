package io.netty.handler.ssl.util;

import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

public final class SelfSignedCertificate
{
  private static final int DEFAULT_KEY_LENGTH_BITS = SystemPropertyUtil.getInt("io.netty.handler.ssl.util.selfSignedKeyStrength", 2048);
  private static final Date DEFAULT_NOT_AFTER;
  private static final Date DEFAULT_NOT_BEFORE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(SelfSignedCertificate.class);
  private final X509Certificate cert;
  private final File certificate;
  private final PrivateKey key;
  private final File privateKey;
  
  static
  {
    DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
    DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));
  }
  
  public SelfSignedCertificate()
    throws CertificateException
  {
    this(DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
  }
  
  public SelfSignedCertificate(String paramString)
    throws CertificateException
  {
    this(paramString, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
  }
  
  public SelfSignedCertificate(String paramString1, String paramString2, int paramInt)
    throws CertificateException
  {
    this(paramString1, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, paramString2, paramInt);
  }
  
  public SelfSignedCertificate(String paramString, SecureRandom paramSecureRandom, int paramInt)
    throws CertificateException
  {
    this(paramString, paramSecureRandom, paramInt, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA");
  }
  
  public SelfSignedCertificate(String paramString, SecureRandom paramSecureRandom, int paramInt, Date paramDate1, Date paramDate2)
    throws CertificateException
  {
    this(paramString, paramSecureRandom, paramInt, paramDate1, paramDate2, "RSA");
  }
  
  /* Error */
  public SelfSignedCertificate(String paramString1, SecureRandom paramSecureRandom, int paramInt, Date paramDate1, Date paramDate2, String paramString2)
    throws CertificateException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 93	java/lang/Object:<init>	()V
    //   4: aload 6
    //   6: ldc 95
    //   8: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   11: ifne +50 -> 61
    //   14: aload 6
    //   16: ldc 71
    //   18: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   21: ifeq +6 -> 27
    //   24: goto +37 -> 61
    //   27: new 103	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   34: astore_1
    //   35: aload_1
    //   36: ldc 106
    //   38: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: aload 6
    //   45: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 112	java/lang/IllegalArgumentException
    //   52: dup
    //   53: aload_1
    //   54: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 118	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: aload 6
    //   63: invokestatic 123	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   66: astore 7
    //   68: aload 7
    //   70: iload_3
    //   71: aload_2
    //   72: invokevirtual 127	java/security/KeyPairGenerator:initialize	(ILjava/security/SecureRandom;)V
    //   75: aload 7
    //   77: invokevirtual 131	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   80: astore 8
    //   82: aload_1
    //   83: aload 8
    //   85: aload_2
    //   86: aload 4
    //   88: aload 5
    //   90: aload 6
    //   92: invokestatic 137	io/netty/handler/ssl/util/OpenJdkSelfSignedCertGenerator:generate	(Ljava/lang/String;Ljava/security/KeyPair;Ljava/security/SecureRandom;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore 7
    //   97: aload 7
    //   99: astore_1
    //   100: goto +31 -> 131
    //   103: astore 7
    //   105: getstatic 28	io/netty/handler/ssl/util/SelfSignedCertificate:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   108: ldc -117
    //   110: aload 7
    //   112: invokeinterface 145 3 0
    //   117: aload_1
    //   118: aload 8
    //   120: aload_2
    //   121: aload 4
    //   123: aload 5
    //   125: aload 6
    //   127: invokestatic 148	io/netty/handler/ssl/util/BouncyCastleSelfSignedCertGenerator:generate	(Ljava/lang/String;Ljava/security/KeyPair;Ljava/security/SecureRandom;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)[Ljava/lang/String;
    //   130: astore_1
    //   131: new 150	java/io/File
    //   134: dup
    //   135: aload_1
    //   136: iconst_0
    //   137: aaload
    //   138: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: astore 4
    //   143: aload_0
    //   144: aload 4
    //   146: putfield 153	io/netty/handler/ssl/util/SelfSignedCertificate:certificate	Ljava/io/File;
    //   149: aload_0
    //   150: new 150	java/io/File
    //   153: dup
    //   154: aload_1
    //   155: iconst_1
    //   156: aaload
    //   157: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: putfield 155	io/netty/handler/ssl/util/SelfSignedCertificate:privateKey	Ljava/io/File;
    //   163: aload_0
    //   164: aload 8
    //   166: invokevirtual 161	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   169: putfield 163	io/netty/handler/ssl/util/SelfSignedCertificate:key	Ljava/security/PrivateKey;
    //   172: new 165	java/io/FileInputStream
    //   175: astore_2
    //   176: aload_2
    //   177: aload 4
    //   179: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   182: aload_2
    //   183: astore_1
    //   184: aload_0
    //   185: ldc -86
    //   187: invokestatic 175	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   190: aload_2
    //   191: invokevirtual 179	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   194: checkcast 181	java/security/cert/X509Certificate
    //   197: putfield 183	io/netty/handler/ssl/util/SelfSignedCertificate:cert	Ljava/security/cert/X509Certificate;
    //   200: aload_2
    //   201: invokevirtual 186	java/io/FileInputStream:close	()V
    //   204: goto +56 -> 260
    //   207: astore 4
    //   209: getstatic 28	io/netty/handler/ssl/util/SelfSignedCertificate:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   212: invokeinterface 190 1 0
    //   217: ifeq +43 -> 260
    //   220: getstatic 28	io/netty/handler/ssl/util/SelfSignedCertificate:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   223: astore_1
    //   224: new 103	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   231: astore_2
    //   232: aload_2
    //   233: ldc -64
    //   235: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_2
    //   240: aload_0
    //   241: getfield 153	io/netty/handler/ssl/util/SelfSignedCertificate:certificate	Ljava/io/File;
    //   244: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: aload_2
    //   250: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: aload 4
    //   255: invokeinterface 198 3 0
    //   260: return
    //   261: astore 4
    //   263: goto +13 -> 276
    //   266: astore_1
    //   267: aconst_null
    //   268: astore_2
    //   269: goto +35 -> 304
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_2
    //   276: aload_2
    //   277: astore_1
    //   278: new 200	java/security/cert/CertificateEncodingException
    //   281: astore 5
    //   283: aload_2
    //   284: astore_1
    //   285: aload 5
    //   287: aload 4
    //   289: invokespecial 203	java/security/cert/CertificateEncodingException:<init>	(Ljava/lang/Throwable;)V
    //   292: aload_2
    //   293: astore_1
    //   294: aload 5
    //   296: athrow
    //   297: astore 4
    //   299: aload_1
    //   300: astore_2
    //   301: aload 4
    //   303: astore_1
    //   304: aload_2
    //   305: ifnull +67 -> 372
    //   308: aload_2
    //   309: invokevirtual 186	java/io/FileInputStream:close	()V
    //   312: goto +60 -> 372
    //   315: astore 4
    //   317: getstatic 28	io/netty/handler/ssl/util/SelfSignedCertificate:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   320: invokeinterface 190 1 0
    //   325: ifeq +47 -> 372
    //   328: getstatic 28	io/netty/handler/ssl/util/SelfSignedCertificate:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   331: astore_2
    //   332: new 103	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   339: astore 5
    //   341: aload 5
    //   343: ldc -64
    //   345: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 5
    //   351: aload_0
    //   352: getfield 153	io/netty/handler/ssl/util/SelfSignedCertificate:certificate	Ljava/io/File;
    //   355: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_2
    //   360: aload 5
    //   362: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: aload 4
    //   367: invokeinterface 198 3 0
    //   372: aload_1
    //   373: athrow
    //   374: astore_1
    //   375: getstatic 28	io/netty/handler/ssl/util/SelfSignedCertificate:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   378: ldc -51
    //   380: aload_1
    //   381: invokeinterface 145 3 0
    //   386: new 69	java/security/cert/CertificateException
    //   389: dup
    //   390: ldc -49
    //   392: aload_1
    //   393: invokespecial 209	java/security/cert/CertificateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   396: astore_1
    //   397: aload_1
    //   398: aload 7
    //   400: invokestatic 215	io/netty/util/internal/ThrowableUtil:addSuppressed	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   403: aload_1
    //   404: athrow
    //   405: astore_1
    //   406: new 217	java/lang/Error
    //   409: dup
    //   410: aload_1
    //   411: invokespecial 218	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   414: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	SelfSignedCertificate
    //   0	415	1	paramString1	String
    //   0	415	2	paramSecureRandom	SecureRandom
    //   0	415	3	paramInt	int
    //   0	415	4	paramDate1	Date
    //   0	415	5	paramDate2	Date
    //   0	415	6	paramString2	String
    //   66	32	7	localObject	Object
    //   103	296	7	localThrowable	Throwable
    //   80	85	8	localKeyPair	java.security.KeyPair
    // Exception table:
    //   from	to	target	type
    //   82	97	103	finally
    //   200	204	207	java/io/IOException
    //   184	200	261	java/lang/Exception
    //   172	182	266	finally
    //   172	182	272	java/lang/Exception
    //   184	200	297	finally
    //   278	283	297	finally
    //   285	292	297	finally
    //   294	297	297	finally
    //   308	312	315	java/io/IOException
    //   117	131	374	finally
    //   61	82	405	java/security/NoSuchAlgorithmException
  }
  
  public SelfSignedCertificate(String paramString1, SecureRandom paramSecureRandom, String paramString2, int paramInt)
    throws CertificateException
  {
    this(paramString1, paramSecureRandom, paramInt, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, paramString2);
  }
  
  public SelfSignedCertificate(String paramString, Date paramDate1, Date paramDate2)
    throws CertificateException
  {
    this(paramString, ThreadLocalInsecureRandom.current(), DEFAULT_KEY_LENGTH_BITS, paramDate1, paramDate2, "RSA");
  }
  
  public SelfSignedCertificate(String paramString1, Date paramDate1, Date paramDate2, String paramString2, int paramInt)
    throws CertificateException
  {
    this(paramString1, ThreadLocalInsecureRandom.current(), paramInt, paramDate1, paramDate2, paramString2);
  }
  
  public SelfSignedCertificate(Date paramDate1, Date paramDate2)
    throws CertificateException
  {
    this("localhost", paramDate1, paramDate2, "RSA", DEFAULT_KEY_LENGTH_BITS);
  }
  
  public SelfSignedCertificate(Date paramDate1, Date paramDate2, String paramString, int paramInt)
    throws CertificateException
  {
    this("localhost", paramDate1, paramDate2, paramString, paramInt);
  }
  
  /* Error */
  static String[] newSelfSignedCertificate(String paramString, PrivateKey paramPrivateKey, X509Certificate paramX509Certificate)
    throws IOException, java.security.cert.CertificateEncodingException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 237 1 0
    //   6: invokestatic 243	io/netty/buffer/Unpooled:wrappedBuffer	([B)Lio/netty/buffer/ByteBuf;
    //   9: astore_3
    //   10: aload_3
    //   11: iconst_1
    //   12: invokestatic 249	io/netty/handler/codec/base64/Base64:encode	(Lio/netty/buffer/ByteBuf;Z)Lio/netty/buffer/ByteBuf;
    //   15: astore 4
    //   17: new 103	java/lang/StringBuilder
    //   20: astore 5
    //   22: aload 5
    //   24: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   27: aload 5
    //   29: ldc -5
    //   31: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: getstatic 257	io/netty/util/CharsetUtil:US_ASCII	Ljava/nio/charset/Charset;
    //   38: astore_1
    //   39: aload 5
    //   41: aload 4
    //   43: aload_1
    //   44: invokevirtual 262	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   47: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 5
    //   53: ldc_w 264
    //   56: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore 5
    //   67: aload 4
    //   69: invokeinterface 269 1 0
    //   74: pop
    //   75: aload_3
    //   76: invokeinterface 269 1 0
    //   81: pop
    //   82: new 103	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   89: astore_3
    //   90: aload_3
    //   91: ldc_w 271
    //   94: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_3
    //   99: aload_0
    //   100: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: bipush 95
    //   107: invokevirtual 274	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_3
    //   112: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: ldc_w 276
    //   118: invokestatic 280	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   121: astore_3
    //   122: aload_3
    //   123: invokevirtual 283	java/io/File:deleteOnExit	()V
    //   126: new 285	java/io/FileOutputStream
    //   129: dup
    //   130: aload_3
    //   131: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   134: astore 4
    //   136: aload 4
    //   138: aload 5
    //   140: aload_1
    //   141: invokevirtual 290	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   144: invokevirtual 296	java/io/OutputStream:write	([B)V
    //   147: aload 4
    //   149: invokevirtual 297	java/io/OutputStream:close	()V
    //   152: aload_2
    //   153: invokevirtual 298	java/security/cert/X509Certificate:getEncoded	()[B
    //   156: invokestatic 243	io/netty/buffer/Unpooled:wrappedBuffer	([B)Lio/netty/buffer/ByteBuf;
    //   159: astore 5
    //   161: aload 5
    //   163: iconst_1
    //   164: invokestatic 249	io/netty/handler/codec/base64/Base64:encode	(Lio/netty/buffer/ByteBuf;Z)Lio/netty/buffer/ByteBuf;
    //   167: astore 4
    //   169: new 103	java/lang/StringBuilder
    //   172: astore_2
    //   173: aload_2
    //   174: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   177: aload_2
    //   178: ldc_w 300
    //   181: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_2
    //   186: aload 4
    //   188: aload_1
    //   189: invokevirtual 262	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   192: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_2
    //   197: ldc_w 302
    //   200: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_2
    //   205: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: astore_2
    //   209: aload 4
    //   211: invokeinterface 269 1 0
    //   216: pop
    //   217: aload 5
    //   219: invokeinterface 269 1 0
    //   224: pop
    //   225: new 103	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   232: astore 5
    //   234: aload 5
    //   236: ldc_w 271
    //   239: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 5
    //   245: aload_0
    //   246: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 5
    //   252: bipush 95
    //   254: invokevirtual 274	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 5
    //   260: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: ldc_w 304
    //   266: invokestatic 280	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 283	java/io/File:deleteOnExit	()V
    //   274: new 285	java/io/FileOutputStream
    //   277: dup
    //   278: aload_0
    //   279: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   282: astore 5
    //   284: aload 5
    //   286: aload_2
    //   287: aload_1
    //   288: invokevirtual 290	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   291: invokevirtual 296	java/io/OutputStream:write	([B)V
    //   294: aload 5
    //   296: invokevirtual 297	java/io/OutputStream:close	()V
    //   299: iconst_2
    //   300: anewarray 97	java/lang/String
    //   303: dup
    //   304: iconst_0
    //   305: aload_0
    //   306: invokevirtual 307	java/io/File:getPath	()Ljava/lang/String;
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: aload_3
    //   313: invokevirtual 307	java/io/File:getPath	()Ljava/lang/String;
    //   316: aastore
    //   317: areturn
    //   318: astore_1
    //   319: aload_0
    //   320: aload 5
    //   322: invokestatic 311	io/netty/handler/ssl/util/SelfSignedCertificate:safeClose	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   325: aload_0
    //   326: invokestatic 314	io/netty/handler/ssl/util/SelfSignedCertificate:safeDelete	(Ljava/io/File;)V
    //   329: aload_3
    //   330: invokestatic 314	io/netty/handler/ssl/util/SelfSignedCertificate:safeDelete	(Ljava/io/File;)V
    //   333: aload_1
    //   334: athrow
    //   335: astore_0
    //   336: aload 4
    //   338: invokeinterface 269 1 0
    //   343: pop
    //   344: aload_0
    //   345: athrow
    //   346: astore_0
    //   347: aload 5
    //   349: invokeinterface 269 1 0
    //   354: pop
    //   355: aload_0
    //   356: athrow
    //   357: astore_0
    //   358: aload_3
    //   359: aload 4
    //   361: invokestatic 311	io/netty/handler/ssl/util/SelfSignedCertificate:safeClose	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   364: aload_3
    //   365: invokestatic 314	io/netty/handler/ssl/util/SelfSignedCertificate:safeDelete	(Ljava/io/File;)V
    //   368: aload_0
    //   369: athrow
    //   370: astore_0
    //   371: aload 4
    //   373: invokeinterface 269 1 0
    //   378: pop
    //   379: aload_0
    //   380: athrow
    //   381: astore_0
    //   382: aload_3
    //   383: invokeinterface 269 1 0
    //   388: pop
    //   389: aload_0
    //   390: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString	String
    //   0	391	1	paramPrivateKey	PrivateKey
    //   0	391	2	paramX509Certificate	X509Certificate
    //   9	374	3	localObject1	Object
    //   15	357	4	localObject2	Object
    //   20	328	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   284	299	318	finally
    //   169	209	335	finally
    //   161	169	346	finally
    //   209	217	346	finally
    //   336	346	346	finally
    //   136	152	357	finally
    //   17	67	370	finally
    //   10	17	381	finally
    //   67	75	381	finally
    //   371	381	381	finally
  }
  
  private static void safeClose(File paramFile, OutputStream paramOutputStream)
  {
    try
    {
      paramOutputStream.close();
    }
    catch (IOException localIOException)
    {
      if (logger.isWarnEnabled())
      {
        InternalLogger localInternalLogger = logger;
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("Failed to close a file: ");
        paramOutputStream.append(paramFile);
        localInternalLogger.warn(paramOutputStream.toString(), localIOException);
      }
    }
  }
  
  private static void safeDelete(File paramFile)
  {
    if (!paramFile.delete())
    {
      InternalLogger localInternalLogger = logger;
      if (localInternalLogger.isWarnEnabled())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to delete a file: ");
        localStringBuilder.append(paramFile);
        localInternalLogger.warn(localStringBuilder.toString());
      }
    }
  }
  
  public X509Certificate cert()
  {
    return this.cert;
  }
  
  public File certificate()
  {
    return this.certificate;
  }
  
  public void delete()
  {
    safeDelete(this.certificate);
    safeDelete(this.privateKey);
  }
  
  public PrivateKey key()
  {
    return this.key;
  }
  
  public File privateKey()
  {
    return this.privateKey;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\SelfSignedCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */