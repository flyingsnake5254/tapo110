package io.netty.util.internal;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFilePermission;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public final class NativeLibraryLoader
{
  private static final boolean DELETE_NATIVE_LIB_AFTER_LOADING;
  private static final String NATIVE_RESOURCE_HOME = "META-INF/native/";
  private static final boolean TRY_TO_PATCH_SHADED_ID;
  private static final byte[] UNIQUE_ID_BYTES;
  private static final File WORKDIR;
  private static final InternalLogger logger;
  
  static
  {
    Object localObject1 = InternalLoggerFactory.getInstance(NativeLibraryLoader.class);
    logger = (InternalLogger)localObject1;
    UNIQUE_ID_BYTES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes(CharsetUtil.US_ASCII);
    Object localObject2 = SystemPropertyUtil.get("io.netty.native.workdir");
    if (localObject2 != null)
    {
      localObject1 = new File((String)localObject2);
      ((File)localObject1).mkdirs();
    }
    try
    {
      localObject2 = ((File)localObject1).getAbsoluteFile();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject3;
      boolean bool;
      for (;;) {}
    }
    WORKDIR = (File)localObject1;
    localObject3 = logger;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("-Dio.netty.native.workdir: ");
    ((StringBuilder)localObject2).append(localObject1);
    ((InternalLogger)localObject3).debug(((StringBuilder)localObject2).toString());
    break label140;
    localObject3 = PlatformDependent.tmpdir();
    WORKDIR = (File)localObject3;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("-Dio.netty.native.workdir: ");
    ((StringBuilder)localObject2).append(localObject3);
    ((StringBuilder)localObject2).append(" (io.netty.tmpdir)");
    ((InternalLogger)localObject1).debug(((StringBuilder)localObject2).toString());
    label140:
    bool = SystemPropertyUtil.getBoolean("io.netty.native.deleteLibAfterLoading", true);
    DELETE_NATIVE_LIB_AFTER_LOADING = bool;
    localObject1 = logger;
    ((InternalLogger)localObject1).debug("-Dio.netty.native.deleteLibAfterLoading: {}", Boolean.valueOf(bool));
    bool = SystemPropertyUtil.getBoolean("io.netty.native.tryPatchShadedId", true);
    TRY_TO_PATCH_SHADED_ID = bool;
    ((InternalLogger)localObject1).debug("-Dio.netty.native.tryPatchShadedId: {}", Boolean.valueOf(bool));
  }
  
  private static String calculatePackagePrefix()
  {
    String str1 = NativeLibraryLoader.class.getName();
    String str2 = "io!netty!util!internal!NativeLibraryLoader".replace('!', '.');
    if (str1.endsWith(str2)) {
      return str1.substring(0, str1.length() - str2.length());
    }
    throw new UnsatisfiedLinkError(String.format("Could not find prefix added to %s to get %s. When shading, only adding a package prefix is supported", new Object[] { str2, str1 }));
  }
  
  /* Error */
  private static byte[] classToByteArray(Class<?> paramClass)
    throws ClassNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 140	java/lang/Class:getName	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: bipush 46
    //   8: invokevirtual 177	java/lang/String:lastIndexOf	(I)I
    //   11: istore_2
    //   12: aload_1
    //   13: astore_3
    //   14: iload_2
    //   15: ifle +11 -> 26
    //   18: aload_1
    //   19: iload_2
    //   20: iconst_1
    //   21: iadd
    //   22: invokevirtual 180	java/lang/String:substring	(I)Ljava/lang/String;
    //   25: astore_3
    //   26: new 80	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   33: astore_1
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: ldc -74
    //   43: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokevirtual 186	java/lang/Class:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +138 -> 197
    //   62: sipush 1024
    //   65: newarray <illegal type>
    //   67: astore 5
    //   69: new 188	java/io/ByteArrayOutputStream
    //   72: dup
    //   73: sipush 4096
    //   76: invokespecial 191	java/io/ByteArrayOutputStream:<init>	(I)V
    //   79: astore 6
    //   81: aconst_null
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 197	java/net/URL:openStream	()Ljava/io/InputStream;
    //   90: astore 4
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: astore_1
    //   98: aload 4
    //   100: aload 5
    //   102: invokevirtual 203	java/io/InputStream:read	([B)I
    //   105: istore_2
    //   106: iload_2
    //   107: iconst_m1
    //   108: if_icmpeq +21 -> 129
    //   111: aload 4
    //   113: astore_3
    //   114: aload 4
    //   116: astore_1
    //   117: aload 6
    //   119: aload 5
    //   121: iconst_0
    //   122: iload_2
    //   123: invokevirtual 207	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -34 -> 92
    //   129: aload 4
    //   131: astore_3
    //   132: aload 4
    //   134: astore_1
    //   135: aload 6
    //   137: invokevirtual 211	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   140: astore 5
    //   142: aload 4
    //   144: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   147: aload 6
    //   149: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   152: aload 5
    //   154: areturn
    //   155: astore_0
    //   156: goto +30 -> 186
    //   159: astore 5
    //   161: aload_1
    //   162: astore_3
    //   163: new 171	java/lang/ClassNotFoundException
    //   166: astore 4
    //   168: aload_1
    //   169: astore_3
    //   170: aload 4
    //   172: aload_0
    //   173: invokevirtual 140	java/lang/Class:getName	()Ljava/lang/String;
    //   176: aload 5
    //   178: invokespecial 218	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_1
    //   182: astore_3
    //   183: aload 4
    //   185: athrow
    //   186: aload_3
    //   187: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   190: aload 6
    //   192: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   195: aload_0
    //   196: athrow
    //   197: new 171	java/lang/ClassNotFoundException
    //   200: dup
    //   201: aload_0
    //   202: invokevirtual 140	java/lang/Class:getName	()Ljava/lang/String;
    //   205: invokespecial 219	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramClass	Class<?>
    //   4	178	1	localObject1	Object
    //   11	112	2	i	int
    //   13	174	3	localObject2	Object
    //   55	129	4	localObject3	Object
    //   67	86	5	arrayOfByte	byte[]
    //   159	18	5	localIOException	IOException
    //   79	112	6	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   85	92	155	finally
    //   98	106	155	finally
    //   117	126	155	finally
    //   135	142	155	finally
    //   163	168	155	finally
    //   170	181	155	finally
    //   183	186	155	finally
    //   85	92	159	java/io/IOException
    //   98	106	159	java/io/IOException
    //   117	126	159	java/io/IOException
    //   135	142	159	java/io/IOException
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public static void load(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: invokestatic 231	io/netty/util/internal/NativeLibraryLoader:calculatePackagePrefix	()Ljava/lang/String;
    //   3: bipush 46
    //   5: bipush 95
    //   7: invokevirtual 146	java/lang/String:replace	(CC)Ljava/lang/String;
    //   10: astore_2
    //   11: new 80	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_3
    //   26: aload_0
    //   27: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 4
    //   37: new 233	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 234	java/util/ArrayList:<init>	()V
    //   44: astore 5
    //   46: aload_1
    //   47: aload 4
    //   49: iconst_0
    //   50: invokestatic 238	io/netty/util/internal/NativeLibraryLoader:loadLibrary	(Ljava/lang/ClassLoader;Ljava/lang/String;Z)V
    //   53: return
    //   54: astore_3
    //   55: aload 5
    //   57: aload_3
    //   58: invokeinterface 244 2 0
    //   63: pop
    //   64: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   67: invokeinterface 247 1 0
    //   72: ifeq +32 -> 104
    //   75: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   78: ldc -7
    //   80: iconst_3
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload 4
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: getstatic 78	io/netty/util/internal/NativeLibraryLoader:WORKDIR	Ljava/io/File;
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: aload_3
    //   98: aastore
    //   99: invokeinterface 252 3 0
    //   104: aload 4
    //   106: invokestatic 257	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 6
    //   111: new 80	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   118: astore_3
    //   119: aload_3
    //   120: ldc 19
    //   122: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_3
    //   127: aload 6
    //   129: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_3
    //   134: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 7
    //   139: aload_1
    //   140: ifnonnull +12 -> 152
    //   143: aload 7
    //   145: invokestatic 262	java/lang/ClassLoader:getSystemResource	(Ljava/lang/String;)Ljava/net/URL;
    //   148: astore_3
    //   149: goto +10 -> 159
    //   152: aload_1
    //   153: aload 7
    //   155: invokevirtual 263	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   158: astore_3
    //   159: aconst_null
    //   160: astore 8
    //   162: aconst_null
    //   163: astore 9
    //   165: aconst_null
    //   166: astore 10
    //   168: aload_3
    //   169: astore 11
    //   171: aload_3
    //   172: ifnonnull +167 -> 339
    //   175: invokestatic 266	io/netty/util/internal/PlatformDependent:isOsx	()Z
    //   178: ifeq +143 -> 321
    //   181: aload 7
    //   183: ldc_w 268
    //   186: invokevirtual 150	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   189: istore 12
    //   191: iload 12
    //   193: ifeq +43 -> 236
    //   196: new 80	java/lang/StringBuilder
    //   199: astore_3
    //   200: aload_3
    //   201: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   204: aload_3
    //   205: ldc_w 270
    //   208: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: aload 4
    //   215: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: ldc_w 272
    //   223: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_3
    //   228: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 11
    //   233: goto +40 -> 273
    //   236: new 80	java/lang/StringBuilder
    //   239: astore_3
    //   240: aload_3
    //   241: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   244: aload_3
    //   245: ldc_w 270
    //   248: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_3
    //   253: aload 4
    //   255: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_3
    //   260: ldc_w 268
    //   263: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_3
    //   268: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: astore 11
    //   273: aload_1
    //   274: ifnonnull +12 -> 286
    //   277: aload 11
    //   279: invokestatic 262	java/lang/ClassLoader:getSystemResource	(Ljava/lang/String;)Ljava/net/URL;
    //   282: astore_3
    //   283: goto +10 -> 293
    //   286: aload_1
    //   287: aload 11
    //   289: invokevirtual 263	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   292: astore_3
    //   293: aload_3
    //   294: ifnull +9 -> 303
    //   297: aload_3
    //   298: astore 11
    //   300: goto +39 -> 339
    //   303: new 274	java/io/FileNotFoundException
    //   306: astore_0
    //   307: aload_0
    //   308: aload 11
    //   310: invokespecial 275	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   313: aload_0
    //   314: aload 5
    //   316: invokestatic 281	io/netty/util/internal/ThrowableUtil:addSuppressedAndClear	(Ljava/lang/Throwable;Ljava/util/List;)V
    //   319: aload_0
    //   320: athrow
    //   321: new 274	java/io/FileNotFoundException
    //   324: astore_0
    //   325: aload_0
    //   326: aload 7
    //   328: invokespecial 275	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   331: aload_0
    //   332: aload 5
    //   334: invokestatic 281	io/netty/util/internal/ThrowableUtil:addSuppressedAndClear	(Ljava/lang/Throwable;Ljava/util/List;)V
    //   337: aload_0
    //   338: athrow
    //   339: aload 6
    //   341: bipush 46
    //   343: invokevirtual 177	java/lang/String:lastIndexOf	(I)I
    //   346: istore 13
    //   348: aload 6
    //   350: iconst_0
    //   351: iload 13
    //   353: invokevirtual 158	java/lang/String:substring	(II)Ljava/lang/String;
    //   356: aload 6
    //   358: iload 13
    //   360: invokevirtual 180	java/lang/String:substring	(I)Ljava/lang/String;
    //   363: getstatic 78	io/netty/util/internal/NativeLibraryLoader:WORKDIR	Ljava/io/File;
    //   366: invokestatic 285	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   369: astore_3
    //   370: aload 11
    //   372: invokevirtual 197	java/net/URL:openStream	()Ljava/io/InputStream;
    //   375: astore 11
    //   377: new 287	java/io/FileOutputStream
    //   380: astore 10
    //   382: aload 10
    //   384: aload_3
    //   385: invokespecial 290	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   388: aload_2
    //   389: invokestatic 293	io/netty/util/internal/NativeLibraryLoader:shouldShadedLibraryIdBePatched	(Ljava/lang/String;)Z
    //   392: ifeq +17 -> 409
    //   395: aload 11
    //   397: aload 10
    //   399: aload_0
    //   400: aload 4
    //   402: invokestatic 297	io/netty/util/internal/NativeLibraryLoader:patchShadedLibraryId	(Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/lang/String;Ljava/lang/String;)Z
    //   405: pop
    //   406: goto +34 -> 440
    //   409: sipush 8192
    //   412: newarray <illegal type>
    //   414: astore_0
    //   415: aload 11
    //   417: aload_0
    //   418: invokevirtual 203	java/io/InputStream:read	([B)I
    //   421: istore 13
    //   423: iload 13
    //   425: ifle +15 -> 440
    //   428: aload 10
    //   430: aload_0
    //   431: iconst_0
    //   432: iload 13
    //   434: invokevirtual 300	java/io/OutputStream:write	([BII)V
    //   437: goto -22 -> 415
    //   440: aload 10
    //   442: invokevirtual 303	java/io/OutputStream:flush	()V
    //   445: aload 10
    //   447: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   450: aload_1
    //   451: aload_3
    //   452: invokevirtual 306	java/io/File:getPath	()Ljava/lang/String;
    //   455: iconst_1
    //   456: invokestatic 238	io/netty/util/internal/NativeLibraryLoader:loadLibrary	(Ljava/lang/ClassLoader;Ljava/lang/String;Z)V
    //   459: aload 11
    //   461: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   464: aconst_null
    //   465: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   468: getstatic 115	io/netty/util/internal/NativeLibraryLoader:DELETE_NATIVE_LIB_AFTER_LOADING	Z
    //   471: ifeq +10 -> 481
    //   474: aload_3
    //   475: invokevirtual 309	java/io/File:delete	()Z
    //   478: ifne +7 -> 485
    //   481: aload_3
    //   482: invokevirtual 312	java/io/File:deleteOnExit	()V
    //   485: return
    //   486: astore_1
    //   487: aload 10
    //   489: astore_0
    //   490: goto +283 -> 773
    //   493: astore_1
    //   494: aload 10
    //   496: astore_0
    //   497: aload_1
    //   498: astore 10
    //   500: goto +20 -> 520
    //   503: astore_0
    //   504: aload 10
    //   506: astore_1
    //   507: goto +56 -> 563
    //   510: astore_1
    //   511: aconst_null
    //   512: astore_0
    //   513: goto +260 -> 773
    //   516: astore 10
    //   518: aconst_null
    //   519: astore_0
    //   520: aload 11
    //   522: astore_1
    //   523: aload 10
    //   525: astore 11
    //   527: goto +72 -> 599
    //   530: astore_0
    //   531: aconst_null
    //   532: astore_1
    //   533: goto +30 -> 563
    //   536: astore_1
    //   537: aconst_null
    //   538: astore_0
    //   539: aload 9
    //   541: astore 11
    //   543: goto +230 -> 773
    //   546: astore 11
    //   548: aconst_null
    //   549: astore_0
    //   550: aload 10
    //   552: astore_1
    //   553: goto +46 -> 599
    //   556: astore_0
    //   557: aconst_null
    //   558: astore 11
    //   560: aload 11
    //   562: astore_1
    //   563: aload_3
    //   564: astore 10
    //   566: aload 11
    //   568: astore_3
    //   569: aload_1
    //   570: astore 11
    //   572: aload 10
    //   574: astore_1
    //   575: goto +104 -> 679
    //   578: astore_1
    //   579: aconst_null
    //   580: astore_3
    //   581: aload_3
    //   582: astore_0
    //   583: aload 9
    //   585: astore 11
    //   587: goto +186 -> 773
    //   590: astore 11
    //   592: aconst_null
    //   593: astore_3
    //   594: aload_3
    //   595: astore_0
    //   596: aload 10
    //   598: astore_1
    //   599: new 160	java/lang/UnsatisfiedLinkError
    //   602: astore 9
    //   604: new 80	java/lang/StringBuilder
    //   607: astore 10
    //   609: aload 10
    //   611: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   614: aload 10
    //   616: ldc_w 314
    //   619: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 10
    //   625: aload 4
    //   627: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 9
    //   633: aload 10
    //   635: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokespecial 167	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   641: aload 9
    //   643: aload 11
    //   645: invokevirtual 318	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   648: pop
    //   649: aload 9
    //   651: aload 5
    //   653: invokestatic 281	io/netty/util/internal/ThrowableUtil:addSuppressedAndClear	(Ljava/lang/Throwable;Ljava/util/List;)V
    //   656: aload 9
    //   658: athrow
    //   659: astore 10
    //   661: aload_1
    //   662: astore 11
    //   664: aload 10
    //   666: astore_1
    //   667: goto +106 -> 773
    //   670: astore_0
    //   671: aconst_null
    //   672: astore_3
    //   673: aload_3
    //   674: astore 11
    //   676: aload 8
    //   678: astore_1
    //   679: aload_1
    //   680: ifnull +70 -> 750
    //   683: aload_1
    //   684: invokevirtual 321	java/io/File:isFile	()Z
    //   687: ifeq +63 -> 750
    //   690: aload_1
    //   691: invokevirtual 324	java/io/File:canRead	()Z
    //   694: ifeq +56 -> 750
    //   697: aload_1
    //   698: invokestatic 328	io/netty/util/internal/NativeLibraryLoader$NoexecVolumeDetector:access$000	(Ljava/io/File;)Z
    //   701: ifne +49 -> 750
    //   704: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   707: ldc_w 330
    //   710: aload_1
    //   711: invokevirtual 306	java/io/File:getPath	()Ljava/lang/String;
    //   714: ldc 56
    //   716: invokeinterface 334 4 0
    //   721: goto +29 -> 750
    //   724: astore 10
    //   726: aload 5
    //   728: aload 10
    //   730: invokeinterface 244 2 0
    //   735: pop
    //   736: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   739: ldc_w 336
    //   742: aload_1
    //   743: aload 10
    //   745: invokeinterface 338 4 0
    //   750: aload_0
    //   751: aload 5
    //   753: invokestatic 281	io/netty/util/internal/ThrowableUtil:addSuppressedAndClear	(Ljava/lang/Throwable;Ljava/util/List;)V
    //   756: aload_0
    //   757: athrow
    //   758: astore_0
    //   759: aload_1
    //   760: astore 10
    //   762: aload_0
    //   763: astore_1
    //   764: aload 11
    //   766: astore_0
    //   767: aload_3
    //   768: astore 11
    //   770: aload 10
    //   772: astore_3
    //   773: aload 11
    //   775: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   778: aload_0
    //   779: invokestatic 215	io/netty/util/internal/NativeLibraryLoader:closeQuietly	(Ljava/io/Closeable;)V
    //   782: aload_3
    //   783: ifnull +20 -> 803
    //   786: getstatic 115	io/netty/util/internal/NativeLibraryLoader:DELETE_NATIVE_LIB_AFTER_LOADING	Z
    //   789: ifeq +10 -> 799
    //   792: aload_3
    //   793: invokevirtual 309	java/io/File:delete	()Z
    //   796: ifne +7 -> 803
    //   799: aload_3
    //   800: invokevirtual 312	java/io/File:deleteOnExit	()V
    //   803: aload_1
    //   804: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	805	0	paramString	String
    //   0	805	1	paramClassLoader	ClassLoader
    //   10	379	2	str1	String
    //   18	14	3	localStringBuilder	StringBuilder
    //   54	44	3	localObject1	Object
    //   118	682	3	localObject2	Object
    //   35	591	4	str2	String
    //   44	708	5	localArrayList	ArrayList
    //   109	248	6	str3	String
    //   137	190	7	str4	String
    //   160	517	8	localObject3	Object
    //   163	494	9	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   166	339	10	localObject4	Object
    //   516	35	10	localException1	Exception
    //   564	70	10	localObject5	Object
    //   659	6	10	localObject6	Object
    //   724	20	10	localObject7	Object
    //   760	11	10	localClassLoader	ClassLoader
    //   169	373	11	localObject8	Object
    //   546	1	11	localException2	Exception
    //   558	28	11	localObject9	Object
    //   590	54	11	localException3	Exception
    //   662	112	11	localObject10	Object
    //   189	3	12	bool	boolean
    //   346	87	13	i	int
    // Exception table:
    //   from	to	target	type
    //   46	53	54	finally
    //   388	406	486	finally
    //   409	415	486	finally
    //   415	423	486	finally
    //   428	437	486	finally
    //   440	450	486	finally
    //   388	406	493	java/lang/Exception
    //   409	415	493	java/lang/Exception
    //   415	423	493	java/lang/Exception
    //   428	437	493	java/lang/Exception
    //   440	450	493	java/lang/Exception
    //   388	406	503	java/lang/UnsatisfiedLinkError
    //   409	415	503	java/lang/UnsatisfiedLinkError
    //   415	423	503	java/lang/UnsatisfiedLinkError
    //   428	437	503	java/lang/UnsatisfiedLinkError
    //   440	450	503	java/lang/UnsatisfiedLinkError
    //   377	388	510	finally
    //   450	459	510	finally
    //   377	388	516	java/lang/Exception
    //   450	459	516	java/lang/Exception
    //   377	388	530	java/lang/UnsatisfiedLinkError
    //   450	459	530	java/lang/UnsatisfiedLinkError
    //   370	377	536	finally
    //   370	377	546	java/lang/Exception
    //   370	377	556	java/lang/UnsatisfiedLinkError
    //   175	191	578	finally
    //   196	233	578	finally
    //   236	273	578	finally
    //   277	283	578	finally
    //   286	293	578	finally
    //   303	321	578	finally
    //   321	339	578	finally
    //   339	370	578	finally
    //   175	191	590	java/lang/Exception
    //   196	233	590	java/lang/Exception
    //   236	273	590	java/lang/Exception
    //   277	283	590	java/lang/Exception
    //   286	293	590	java/lang/Exception
    //   303	321	590	java/lang/Exception
    //   321	339	590	java/lang/Exception
    //   339	370	590	java/lang/Exception
    //   599	659	659	finally
    //   175	191	670	java/lang/UnsatisfiedLinkError
    //   196	233	670	java/lang/UnsatisfiedLinkError
    //   236	273	670	java/lang/UnsatisfiedLinkError
    //   277	283	670	java/lang/UnsatisfiedLinkError
    //   286	293	670	java/lang/UnsatisfiedLinkError
    //   303	321	670	java/lang/UnsatisfiedLinkError
    //   321	339	670	java/lang/UnsatisfiedLinkError
    //   339	370	670	java/lang/UnsatisfiedLinkError
    //   683	721	724	finally
    //   726	750	758	finally
    //   750	758	758	finally
  }
  
  public static void loadFirstAvailable(ClassLoader paramClassLoader, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i)
    {
      String str = paramVarArgs[j];
      try
      {
        load(str, paramClassLoader);
        return;
      }
      finally
      {
        localArrayList.add(localObject);
        logger.debug("Unable to load the library '{}', trying next name...", str, localObject);
        j++;
      }
    }
    paramClassLoader = new StringBuilder();
    paramClassLoader.append("Failed to load any of the given libraries: ");
    paramClassLoader.append(Arrays.toString(paramVarArgs));
    paramClassLoader = new IllegalArgumentException(paramClassLoader.toString());
    ThrowableUtil.addSuppressedAndClear(paramClassLoader, localArrayList);
    throw paramClassLoader;
  }
  
  /* Error */
  private static void loadLibrary(ClassLoader paramClassLoader, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 356
    //   4: invokestatic 360	io/netty/util/internal/NativeLibraryLoader:tryToLoadClass	(Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Class;
    //   7: aload_1
    //   8: iload_2
    //   9: invokestatic 364	io/netty/util/internal/NativeLibraryLoader:loadLibraryByHelper	(Ljava/lang/Class;Ljava/lang/String;Z)V
    //   12: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   15: ldc_w 366
    //   18: aload_1
    //   19: invokeinterface 126 3 0
    //   24: return
    //   25: astore_3
    //   26: aload_3
    //   27: astore_0
    //   28: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   31: ldc_w 368
    //   34: aload_1
    //   35: aload_3
    //   36: invokeinterface 338 4 0
    //   41: goto +19 -> 60
    //   44: astore_3
    //   45: aload_3
    //   46: astore_0
    //   47: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   50: ldc_w 368
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 338 4 0
    //   60: aload_3
    //   61: astore_0
    //   62: aload_1
    //   63: iload_2
    //   64: invokestatic 371	io/netty/util/internal/NativeLibraryUtil:loadLibrary	(Ljava/lang/String;Z)V
    //   67: aload_3
    //   68: astore_0
    //   69: getstatic 38	io/netty/util/internal/NativeLibraryLoader:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   72: ldc_w 366
    //   75: aload_1
    //   76: invokeinterface 126 3 0
    //   81: return
    //   82: astore_1
    //   83: aload_1
    //   84: aload_0
    //   85: invokestatic 375	io/netty/util/internal/ThrowableUtil:addSuppressed	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramClassLoader	ClassLoader
    //   0	90	1	paramString	String
    //   0	90	2	paramBoolean	boolean
    //   25	11	3	localException	Exception
    //   44	24	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   0	24	25	java/lang/Exception
    //   0	24	44	java/lang/UnsatisfiedLinkError
    //   28	41	82	java/lang/UnsatisfiedLinkError
    //   47	60	82	java/lang/UnsatisfiedLinkError
    //   62	67	82	java/lang/UnsatisfiedLinkError
    //   69	81	82	java/lang/UnsatisfiedLinkError
  }
  
  private static void loadLibraryByHelper(Class<?> paramClass, final String paramString, final boolean paramBoolean)
    throws UnsatisfiedLinkError
  {
    paramClass = AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        try
        {
          Object localObject = this.val$helper.getMethod("loadLibrary", new Class[] { String.class, Boolean.TYPE });
          ((Method)localObject).setAccessible(true);
          localObject = ((Method)localObject).invoke(null, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
          return localObject;
        }
        catch (Exception localException)
        {
          return localException;
        }
      }
    });
    if ((paramClass instanceof Throwable))
    {
      paramClass = (Throwable)paramClass;
      paramString = paramClass.getCause();
      if ((paramString instanceof UnsatisfiedLinkError)) {
        throw ((UnsatisfiedLinkError)paramString);
      }
      paramString = new UnsatisfiedLinkError(paramClass.getMessage());
      paramString.initCause(paramClass);
      throw paramString;
    }
  }
  
  static boolean patchShadedLibraryId(InputStream paramInputStream, OutputStream paramOutputStream, String paramString1, String paramString2)
    throws IOException
  {
    Object localObject1 = new byte[' '];
    Object localObject2 = new ByteArrayOutputStream(paramInputStream.available());
    for (;;)
    {
      int i = paramInputStream.read((byte[])localObject1);
      if (i <= 0) {
        break;
      }
      ((ByteArrayOutputStream)localObject2).write((byte[])localObject1, 0, i);
    }
    ((ByteArrayOutputStream)localObject2).flush();
    paramInputStream = ((ByteArrayOutputStream)localObject2).toByteArray();
    ((ByteArrayOutputStream)localObject2).close();
    boolean bool;
    if (!patchShadedLibraryId(paramInputStream, paramString1, paramString2))
    {
      localObject2 = PlatformDependent.normalizedOs();
      localObject1 = PlatformDependent.normalizedArch();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("_");
      localStringBuilder.append((String)localObject1);
      localObject2 = localStringBuilder.toString();
      if (paramString1.endsWith((String)localObject2)) {
        bool = patchShadedLibraryId(paramInputStream, paramString1.substring(0, paramString1.length() - ((String)localObject2).length()), paramString2);
      } else {
        bool = false;
      }
    }
    else
    {
      bool = true;
    }
    paramOutputStream.write(paramInputStream, 0, paramInputStream.length);
    return bool;
  }
  
  private static boolean patchShadedLibraryId(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    byte[] arrayOfByte = paramString1.getBytes(CharsetUtil.UTF_8);
    for (int i = 0; (i < paramArrayOfByte.length) && (paramArrayOfByte.length - i >= arrayOfByte.length); i++)
    {
      int j = i;
      int n;
      for (k = 0; k < arrayOfByte.length; k = n)
      {
        int m = paramArrayOfByte[j];
        n = k + 1;
        if (m != arrayOfByte[k]) {
          break;
        }
        if (n == arrayOfByte.length) {
          break label95;
        }
        j++;
      }
    }
    i = -1;
    label95:
    if (i == -1)
    {
      logger.debug("Was not able to find the ID of the shaded native library {}, can't adjust it.", paramString2);
      return false;
    }
    for (int k = 0; k < arrayOfByte.length; k++)
    {
      localObject = UNIQUE_ID_BYTES;
      paramArrayOfByte[(i + k)] = ((byte)localObject[PlatformDependent.threadLocalRandom().nextInt(localObject.length)]);
    }
    Object localObject = logger;
    if (((InternalLogger)localObject).isDebugEnabled()) {
      ((InternalLogger)localObject).debug("Found the ID of the shaded native library {}. Replacing ID part {} with {}", new Object[] { paramString2, paramString1, new String(paramArrayOfByte, i, arrayOfByte.length, CharsetUtil.UTF_8) });
    }
    return true;
  }
  
  private static boolean shouldShadedLibraryIdBePatched(String paramString)
  {
    boolean bool;
    if ((TRY_TO_PATCH_SHADED_ID) && (PlatformDependent.isOsx()) && (!paramString.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static Class<?> tryToLoadClass(ClassLoader paramClassLoader, Class<?> paramClass)
    throws ClassNotFoundException
  {
    try
    {
      Class localClass = Class.forName(paramClass.getName(), false, paramClassLoader);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      if (paramClassLoader != null) {
        try
        {
          byte[] arrayOfByte = classToByteArray(paramClass);
          PrivilegedAction local2 = new io/netty/util/internal/NativeLibraryLoader$2;
          local2.<init>(paramClassLoader, paramClass, arrayOfByte);
          paramClassLoader = (Class)AccessController.doPrivileged(local2);
          return paramClassLoader;
        }
        catch (Error paramClassLoader)
        {
          ThrowableUtil.addSuppressed(paramClassLoader, localClassNotFoundException);
          throw paramClassLoader;
        }
        catch (RuntimeException paramClassLoader)
        {
          ThrowableUtil.addSuppressed(paramClassLoader, localClassNotFoundException);
          throw paramClassLoader;
        }
        catch (ClassNotFoundException paramClassLoader)
        {
          ThrowableUtil.addSuppressed(paramClassLoader, localClassNotFoundException);
          throw paramClassLoader;
        }
      }
      throw localClassNotFoundException;
    }
  }
  
  private static final class NoexecVolumeDetector
  {
    @SuppressJava6Requirement(reason="Usage guarded by java version check")
    private static boolean canExecuteExecutable(File paramFile)
      throws IOException
    {
      if (PlatformDependent.javaVersion() < 7) {
        return true;
      }
      if (paramFile.canExecute()) {
        return true;
      }
      Object localObject = Files.getPosixFilePermissions(paramFile.toPath(), new LinkOption[0]);
      EnumSet localEnumSet = EnumSet.of(PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_EXECUTE);
      if (((Set)localObject).containsAll(localEnumSet)) {
        return false;
      }
      localObject = EnumSet.copyOf((Collection)localObject);
      ((Set)localObject).addAll(localEnumSet);
      Files.setPosixFilePermissions(paramFile.toPath(), (Set)localObject);
      return paramFile.canExecute();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\NativeLibraryLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */