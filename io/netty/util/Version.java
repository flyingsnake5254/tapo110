package io.netty.util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public final class Version
{
  private static final String PROP_BUILD_DATE = ".buildDate";
  private static final String PROP_COMMIT_DATE = ".commitDate";
  private static final String PROP_LONG_COMMIT_HASH = ".longCommitHash";
  private static final String PROP_REPO_STATUS = ".repoStatus";
  private static final String PROP_SHORT_COMMIT_HASH = ".shortCommitHash";
  private static final String PROP_VERSION = ".version";
  private final String artifactId;
  private final String artifactVersion;
  private final long buildTimeMillis;
  private final long commitTimeMillis;
  private final String longCommitHash;
  private final String repositoryStatus;
  private final String shortCommitHash;
  
  private Version(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    this.artifactId = paramString1;
    this.artifactVersion = paramString2;
    this.buildTimeMillis = paramLong1;
    this.commitTimeMillis = paramLong2;
    this.shortCommitHash = paramString3;
    this.longCommitHash = paramString4;
    this.repositoryStatus = paramString5;
  }
  
  public static Map<String, Version> identify()
  {
    return identify(null);
  }
  
  /* Error */
  public static Map<String, Version> identify(ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +10 -> 11
    //   4: invokestatic 66	io/netty/util/internal/PlatformDependent:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   7: astore_0
    //   8: goto +3 -> 11
    //   11: new 68	java/util/Properties
    //   14: dup
    //   15: invokespecial 69	java/util/Properties:<init>	()V
    //   18: astore_1
    //   19: aload_0
    //   20: ldc 71
    //   22: invokevirtual 77	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   25: astore_0
    //   26: aload_0
    //   27: invokeinterface 83 1 0
    //   32: ifeq +35 -> 67
    //   35: aload_0
    //   36: invokeinterface 87 1 0
    //   41: checkcast 89	java/net/URL
    //   44: invokevirtual 93	java/net/URL:openStream	()Ljava/io/InputStream;
    //   47: astore_2
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 97	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   53: aload_2
    //   54: invokevirtual 102	java/io/InputStream:close	()V
    //   57: goto -31 -> 26
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 102	java/io/InputStream:close	()V
    //   65: aload_0
    //   66: athrow
    //   67: new 104	java/util/HashSet
    //   70: dup
    //   71: invokespecial 105	java/util/HashSet:<init>	()V
    //   74: astore_0
    //   75: aload_1
    //   76: invokevirtual 109	java/util/Properties:keySet	()Ljava/util/Set;
    //   79: invokeinterface 115 1 0
    //   84: astore_2
    //   85: aload_2
    //   86: invokeinterface 120 1 0
    //   91: ifeq +267 -> 358
    //   94: aload_2
    //   95: invokeinterface 123 1 0
    //   100: checkcast 125	java/lang/String
    //   103: astore_3
    //   104: aload_3
    //   105: bipush 46
    //   107: invokevirtual 129	java/lang/String:indexOf	(I)I
    //   110: istore 4
    //   112: iload 4
    //   114: ifgt +6 -> 120
    //   117: goto -32 -> 85
    //   120: aload_3
    //   121: iconst_0
    //   122: iload 4
    //   124: invokevirtual 133	java/lang/String:substring	(II)Ljava/lang/String;
    //   127: astore_3
    //   128: new 135	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   135: astore 5
    //   137: aload 5
    //   139: aload_3
    //   140: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 5
    //   146: ldc 23
    //   148: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_1
    //   153: aload 5
    //   155: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 148	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   161: ifeq -76 -> 85
    //   164: new 135	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   171: astore 5
    //   173: aload 5
    //   175: aload_3
    //   176: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 5
    //   182: ldc 8
    //   184: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: aload 5
    //   191: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 148	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   197: ifeq -112 -> 85
    //   200: new 135	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   207: astore 5
    //   209: aload 5
    //   211: aload_3
    //   212: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: ldc 11
    //   220: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload 5
    //   227: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 148	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   233: ifeq -148 -> 85
    //   236: new 135	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   243: astore 5
    //   245: aload 5
    //   247: aload_3
    //   248: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 5
    //   254: ldc 20
    //   256: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: aload 5
    //   263: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 148	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   269: ifeq -184 -> 85
    //   272: new 135	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   279: astore 5
    //   281: aload 5
    //   283: aload_3
    //   284: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 5
    //   290: ldc 14
    //   292: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_1
    //   297: aload 5
    //   299: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 148	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   305: ifeq -220 -> 85
    //   308: new 135	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   315: astore 5
    //   317: aload 5
    //   319: aload_3
    //   320: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 5
    //   326: ldc 17
    //   328: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_1
    //   333: aload 5
    //   335: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokevirtual 148	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   341: ifne +6 -> 347
    //   344: goto -259 -> 85
    //   347: aload_0
    //   348: aload_3
    //   349: invokeinterface 151 2 0
    //   354: pop
    //   355: goto -270 -> 85
    //   358: new 153	java/util/TreeMap
    //   361: dup
    //   362: invokespecial 154	java/util/TreeMap:<init>	()V
    //   365: astore_2
    //   366: aload_0
    //   367: invokeinterface 115 1 0
    //   372: astore_0
    //   373: aload_0
    //   374: invokeinterface 120 1 0
    //   379: ifeq +256 -> 635
    //   382: aload_0
    //   383: invokeinterface 123 1 0
    //   388: checkcast 125	java/lang/String
    //   391: astore_3
    //   392: new 135	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   399: astore 5
    //   401: aload 5
    //   403: aload_3
    //   404: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 5
    //   410: ldc 23
    //   412: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_1
    //   417: aload 5
    //   419: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   425: astore 5
    //   427: new 135	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   434: astore 6
    //   436: aload 6
    //   438: aload_3
    //   439: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 6
    //   445: ldc 8
    //   447: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_1
    //   452: aload 6
    //   454: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   460: invokestatic 162	io/netty/util/Version:parseIso8601	(Ljava/lang/String;)J
    //   463: lstore 7
    //   465: new 135	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   472: astore 6
    //   474: aload 6
    //   476: aload_3
    //   477: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 6
    //   483: ldc 11
    //   485: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload_1
    //   490: aload 6
    //   492: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   498: invokestatic 162	io/netty/util/Version:parseIso8601	(Ljava/lang/String;)J
    //   501: lstore 9
    //   503: new 135	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   510: astore 6
    //   512: aload 6
    //   514: aload_3
    //   515: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 6
    //   521: ldc 20
    //   523: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_1
    //   528: aload 6
    //   530: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   536: astore 6
    //   538: new 135	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   545: astore 11
    //   547: aload 11
    //   549: aload_3
    //   550: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 11
    //   556: ldc 14
    //   558: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload_1
    //   563: aload 11
    //   565: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   571: astore 11
    //   573: new 135	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   580: astore 12
    //   582: aload 12
    //   584: aload_3
    //   585: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 12
    //   591: ldc 17
    //   593: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload_2
    //   598: aload_3
    //   599: new 2	io/netty/util/Version
    //   602: dup
    //   603: aload_3
    //   604: aload 5
    //   606: lload 7
    //   608: lload 9
    //   610: aload 6
    //   612: aload 11
    //   614: aload_1
    //   615: aload 12
    //   617: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   623: invokespecial 164	io/netty/util/Version:<init>	(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   626: invokeinterface 170 3 0
    //   631: pop
    //   632: goto -259 -> 373
    //   635: aload_2
    //   636: areturn
    //   637: astore_0
    //   638: goto -571 -> 67
    //   641: astore_2
    //   642: goto -616 -> 26
    //   645: astore_2
    //   646: goto -581 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	paramClassLoader	ClassLoader
    //   18	597	1	localProperties	java.util.Properties
    //   47	589	2	localObject1	Object
    //   641	1	2	localException1	Exception
    //   645	1	2	localException2	Exception
    //   103	501	3	str	String
    //   110	13	4	i	int
    //   135	470	5	localObject2	Object
    //   434	177	6	localObject3	Object
    //   463	144	7	l1	long
    //   501	108	9	l2	long
    //   545	68	11	localObject4	Object
    //   580	36	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	53	60	finally
    //   19	26	637	java/lang/Exception
    //   26	48	637	java/lang/Exception
    //   65	67	637	java/lang/Exception
    //   53	57	641	java/lang/Exception
    //   61	65	645	java/lang/Exception
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = identify().values().iterator();
    while (paramArrayOfString.hasNext())
    {
      Version localVersion = (Version)paramArrayOfString.next();
      System.err.println(localVersion);
    }
  }
  
  private static long parseIso8601(String paramString)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new java/text/SimpleDateFormat;
      localSimpleDateFormat.<init>("yyyy-MM-dd HH:mm:ss Z");
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString) {}
    return 0L;
  }
  
  public String artifactId()
  {
    return this.artifactId;
  }
  
  public String artifactVersion()
  {
    return this.artifactVersion;
  }
  
  public long buildTimeMillis()
  {
    return this.buildTimeMillis;
  }
  
  public long commitTimeMillis()
  {
    return this.commitTimeMillis;
  }
  
  public String longCommitHash()
  {
    return this.longCommitHash;
  }
  
  public String repositoryStatus()
  {
    return this.repositoryStatus;
  }
  
  public String shortCommitHash()
  {
    return this.shortCommitHash;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.artifactId);
    localStringBuilder.append('-');
    localStringBuilder.append(this.artifactVersion);
    localStringBuilder.append('.');
    localStringBuilder.append(this.shortCommitHash);
    Object localObject;
    if ("clean".equals(this.repositoryStatus))
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" (repository: ");
      ((StringBuilder)localObject).append(this.repositoryStatus);
      ((StringBuilder)localObject).append(')');
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */