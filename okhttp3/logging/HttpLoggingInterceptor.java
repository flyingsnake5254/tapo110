package okhttp3.logging;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;
import okio.Buffer;

public final class HttpLoggingInterceptor
  implements Interceptor
{
  private static final Charset UTF8 = Charset.forName("UTF-8");
  private volatile Set<String> headersToRedact = Collections.emptySet();
  private volatile Level level = Level.NONE;
  private final Logger logger;
  
  public HttpLoggingInterceptor()
  {
    this(Logger.DEFAULT);
  }
  
  public HttpLoggingInterceptor(Logger paramLogger)
  {
    this.logger = paramLogger;
  }
  
  private static boolean bodyHasUnknownEncoding(Headers paramHeaders)
  {
    paramHeaders = paramHeaders.get("Content-Encoding");
    boolean bool;
    if ((paramHeaders != null) && (!paramHeaders.equalsIgnoreCase("identity")) && (!paramHeaders.equalsIgnoreCase("gzip"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isPlaintext(Buffer paramBuffer)
  {
    try
    {
      Buffer localBuffer = new okio/Buffer;
      localBuffer.<init>();
      long l;
      if (paramBuffer.size() < 64L) {
        l = paramBuffer.size();
      } else {
        l = 64L;
      }
      paramBuffer.copyTo(localBuffer, 0L, l);
      for (int i = 0; (i < 16) && (!localBuffer.exhausted()); i++)
      {
        int j = localBuffer.readUtf8CodePoint();
        if (Character.isISOControl(j))
        {
          boolean bool = Character.isWhitespace(j);
          if (!bool) {
            return false;
          }
        }
      }
      return true;
    }
    catch (EOFException paramBuffer) {}
    return false;
  }
  
  private void logHeader(Headers paramHeaders, int paramInt)
  {
    String str;
    if (this.headersToRedact.contains(paramHeaders.name(paramInt))) {
      str = "██";
    } else {
      str = paramHeaders.value(paramInt);
    }
    Logger localLogger = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHeaders.name(paramInt));
    localStringBuilder.append(": ");
    localStringBuilder.append(str);
    localLogger.log(localStringBuilder.toString());
  }
  
  public Level getLevel()
  {
    return this.level;
  }
  
  /* Error */
  public okhttp3.Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	okhttp3/logging/HttpLoggingInterceptor:level	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   4: astore_2
    //   5: aload_1
    //   6: invokeinterface 162 1 0
    //   11: astore_3
    //   12: aload_2
    //   13: getstatic 56	okhttp3/logging/HttpLoggingInterceptor$Level:NONE	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   16: if_acmpne +11 -> 27
    //   19: aload_1
    //   20: aload_3
    //   21: invokeinterface 166 2 0
    //   26: areturn
    //   27: getstatic 169	okhttp3/logging/HttpLoggingInterceptor$Level:BODY	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   30: astore 4
    //   32: iconst_1
    //   33: istore 5
    //   35: aload_2
    //   36: aload 4
    //   38: if_acmpne +9 -> 47
    //   41: iconst_1
    //   42: istore 6
    //   44: goto +6 -> 50
    //   47: iconst_0
    //   48: istore 6
    //   50: iload 6
    //   52: ifne +19 -> 71
    //   55: aload_2
    //   56: getstatic 172	okhttp3/logging/HttpLoggingInterceptor$Level:HEADERS	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   59: if_acmpne +6 -> 65
    //   62: goto +9 -> 71
    //   65: iconst_0
    //   66: istore 7
    //   68: goto +6 -> 74
    //   71: iconst_1
    //   72: istore 7
    //   74: aload_3
    //   75: invokevirtual 178	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   78: astore 8
    //   80: aload 8
    //   82: ifnull +6 -> 88
    //   85: goto +6 -> 91
    //   88: iconst_0
    //   89: istore 5
    //   91: aload_1
    //   92: invokeinterface 182 1 0
    //   97: astore_2
    //   98: new 133	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   105: astore 4
    //   107: aload 4
    //   109: ldc -72
    //   111: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: aload_3
    //   118: invokevirtual 187	okhttp3/Request:method	()Ljava/lang/String;
    //   121: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 4
    //   127: bipush 32
    //   129: invokevirtual 190	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: aload_3
    //   136: invokevirtual 194	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   139: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: ifnull +41 -> 185
    //   147: new 133	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   154: astore 9
    //   156: aload 9
    //   158: ldc -57
    //   160: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 9
    //   166: aload_2
    //   167: invokeinterface 205 1 0
    //   172: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 9
    //   178: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore_2
    //   182: goto +6 -> 188
    //   185: ldc -49
    //   187: astore_2
    //   188: aload 4
    //   190: aload_2
    //   191: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 4
    //   197: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: astore_2
    //   205: iload 7
    //   207: ifne +55 -> 262
    //   210: aload 4
    //   212: astore_2
    //   213: iload 5
    //   215: ifeq +47 -> 262
    //   218: new 133	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   225: astore_2
    //   226: aload_2
    //   227: aload 4
    //   229: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: ldc -47
    //   236: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: aload 8
    //   243: invokevirtual 214	okhttp3/RequestBody:contentLength	()J
    //   246: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: ldc -37
    //   253: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_2
    //   258: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: astore_2
    //   262: aload_0
    //   263: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   266: aload_2
    //   267: invokeinterface 148 2 0
    //   272: iload 7
    //   274: ifeq +510 -> 784
    //   277: iload 5
    //   279: ifeq +111 -> 390
    //   282: aload 8
    //   284: invokevirtual 223	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   287: ifnull +47 -> 334
    //   290: aload_0
    //   291: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   294: astore_2
    //   295: new 133	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   302: astore 4
    //   304: aload 4
    //   306: ldc -31
    //   308: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 4
    //   314: aload 8
    //   316: invokevirtual 223	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   319: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_2
    //   324: aload 4
    //   326: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokeinterface 148 2 0
    //   334: aload 8
    //   336: invokevirtual 214	okhttp3/RequestBody:contentLength	()J
    //   339: ldc2_w 226
    //   342: lcmp
    //   343: ifeq +47 -> 390
    //   346: aload_0
    //   347: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   350: astore_2
    //   351: new 133	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   358: astore 4
    //   360: aload 4
    //   362: ldc -27
    //   364: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 4
    //   370: aload 8
    //   372: invokevirtual 214	okhttp3/RequestBody:contentLength	()J
    //   375: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: aload 4
    //   382: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokeinterface 148 2 0
    //   390: aload_3
    //   391: invokevirtual 233	okhttp3/Request:headers	()Lokhttp3/Headers;
    //   394: astore 4
    //   396: aload 4
    //   398: invokevirtual 235	okhttp3/Headers:size	()I
    //   401: istore 10
    //   403: iconst_0
    //   404: istore 11
    //   406: iload 11
    //   408: iload 10
    //   410: if_icmpge +43 -> 453
    //   413: aload 4
    //   415: iload 11
    //   417: invokevirtual 120	okhttp3/Headers:name	(I)Ljava/lang/String;
    //   420: astore_2
    //   421: ldc -19
    //   423: aload_2
    //   424: invokevirtual 78	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   427: ifne +20 -> 447
    //   430: ldc -17
    //   432: aload_2
    //   433: invokevirtual 78	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   436: ifne +11 -> 447
    //   439: aload_0
    //   440: aload 4
    //   442: iload 11
    //   444: invokespecial 241	okhttp3/logging/HttpLoggingInterceptor:logHeader	(Lokhttp3/Headers;I)V
    //   447: iinc 11 1
    //   450: goto -44 -> 406
    //   453: iload 6
    //   455: ifeq +288 -> 743
    //   458: iload 5
    //   460: ifne +6 -> 466
    //   463: goto +280 -> 743
    //   466: aload_3
    //   467: invokevirtual 233	okhttp3/Request:headers	()Lokhttp3/Headers;
    //   470: invokestatic 243	okhttp3/logging/HttpLoggingInterceptor:bodyHasUnknownEncoding	(Lokhttp3/Headers;)Z
    //   473: ifeq +54 -> 527
    //   476: aload_0
    //   477: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   480: astore 4
    //   482: new 133	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   489: astore_2
    //   490: aload_2
    //   491: ldc -11
    //   493: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_2
    //   498: aload_3
    //   499: invokevirtual 187	okhttp3/Request:method	()Ljava/lang/String;
    //   502: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_2
    //   507: ldc -9
    //   509: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 4
    //   515: aload_2
    //   516: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokeinterface 148 2 0
    //   524: goto +260 -> 784
    //   527: new 86	okio/Buffer
    //   530: dup
    //   531: invokespecial 87	okio/Buffer:<init>	()V
    //   534: astore 9
    //   536: aload 8
    //   538: aload 9
    //   540: invokevirtual 251	okhttp3/RequestBody:writeTo	(Lokio/BufferedSink;)V
    //   543: getstatic 35	okhttp3/logging/HttpLoggingInterceptor:UTF8	Ljava/nio/charset/Charset;
    //   546: astore 4
    //   548: aload 8
    //   550: invokevirtual 223	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   553: astore 12
    //   555: aload 4
    //   557: astore_2
    //   558: aload 12
    //   560: ifnull +11 -> 571
    //   563: aload 12
    //   565: aload 4
    //   567: invokevirtual 257	okhttp3/MediaType:charset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   570: astore_2
    //   571: aload_0
    //   572: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   575: ldc -49
    //   577: invokeinterface 148 2 0
    //   582: aload 9
    //   584: invokestatic 259	okhttp3/logging/HttpLoggingInterceptor:isPlaintext	(Lokio/Buffer;)Z
    //   587: ifeq +86 -> 673
    //   590: aload_0
    //   591: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   594: aload 9
    //   596: aload_2
    //   597: invokevirtual 263	okio/Buffer:readString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   600: invokeinterface 148 2 0
    //   605: aload_0
    //   606: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   609: astore 4
    //   611: new 133	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   618: astore_2
    //   619: aload_2
    //   620: ldc -11
    //   622: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload_2
    //   627: aload_3
    //   628: invokevirtual 187	okhttp3/Request:method	()Ljava/lang/String;
    //   631: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_2
    //   636: ldc -47
    //   638: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload_2
    //   643: aload 8
    //   645: invokevirtual 214	okhttp3/RequestBody:contentLength	()J
    //   648: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload_2
    //   653: ldc -37
    //   655: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 4
    //   661: aload_2
    //   662: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokeinterface 148 2 0
    //   670: goto +114 -> 784
    //   673: aload_0
    //   674: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   677: astore 4
    //   679: new 133	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   686: astore_2
    //   687: aload_2
    //   688: ldc -11
    //   690: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload_2
    //   695: aload_3
    //   696: invokevirtual 187	okhttp3/Request:method	()Ljava/lang/String;
    //   699: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload_2
    //   704: ldc_w 265
    //   707: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload_2
    //   712: aload 8
    //   714: invokevirtual 214	okhttp3/RequestBody:contentLength	()J
    //   717: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload_2
    //   722: ldc_w 267
    //   725: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 4
    //   731: aload_2
    //   732: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokeinterface 148 2 0
    //   740: goto +44 -> 784
    //   743: aload_0
    //   744: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   747: astore 4
    //   749: new 133	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   756: astore_2
    //   757: aload_2
    //   758: ldc -11
    //   760: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload_2
    //   765: aload_3
    //   766: invokevirtual 187	okhttp3/Request:method	()Ljava/lang/String;
    //   769: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload 4
    //   775: aload_2
    //   776: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokeinterface 148 2 0
    //   784: invokestatic 272	java/lang/System:nanoTime	()J
    //   787: lstore 13
    //   789: aload_1
    //   790: aload_3
    //   791: invokeinterface 166 2 0
    //   796: astore 8
    //   798: getstatic 278	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   801: invokestatic 272	java/lang/System:nanoTime	()J
    //   804: lload 13
    //   806: lsub
    //   807: invokevirtual 282	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   810: lstore 15
    //   812: aload 8
    //   814: invokevirtual 287	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   817: astore 9
    //   819: aload 9
    //   821: invokevirtual 290	okhttp3/ResponseBody:contentLength	()J
    //   824: lstore 13
    //   826: lload 13
    //   828: ldc2_w 226
    //   831: lcmp
    //   832: ifeq +34 -> 866
    //   835: new 133	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   842: astore_1
    //   843: aload_1
    //   844: lload 13
    //   846: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload_1
    //   851: ldc_w 292
    //   854: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload_1
    //   859: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: astore_1
    //   863: goto +7 -> 870
    //   866: ldc_w 294
    //   869: astore_1
    //   870: aload_0
    //   871: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   874: astore 4
    //   876: new 133	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   883: astore_3
    //   884: aload_3
    //   885: ldc_w 296
    //   888: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload_3
    //   893: aload 8
    //   895: invokevirtual 299	okhttp3/Response:code	()I
    //   898: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: aload 8
    //   904: invokevirtual 305	okhttp3/Response:message	()Ljava/lang/String;
    //   907: invokevirtual 308	java/lang/String:isEmpty	()Z
    //   910: ifeq +9 -> 919
    //   913: ldc -49
    //   915: astore_2
    //   916: goto +33 -> 949
    //   919: new 133	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   926: astore_2
    //   927: aload_2
    //   928: bipush 32
    //   930: invokevirtual 190	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload_2
    //   935: aload 8
    //   937: invokevirtual 305	okhttp3/Response:message	()Ljava/lang/String;
    //   940: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload_2
    //   945: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: astore_2
    //   949: aload_3
    //   950: aload_2
    //   951: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload_3
    //   956: bipush 32
    //   958: invokevirtual 190	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: aload_3
    //   963: aload 8
    //   965: invokevirtual 309	okhttp3/Response:request	()Lokhttp3/Request;
    //   968: invokevirtual 194	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   971: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload_3
    //   976: ldc -47
    //   978: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload_3
    //   983: lload 15
    //   985: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload_3
    //   990: ldc_w 311
    //   993: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: iload 7
    //   999: ifne +41 -> 1040
    //   1002: new 133	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1009: astore_2
    //   1010: aload_2
    //   1011: ldc_w 313
    //   1014: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: pop
    //   1018: aload_2
    //   1019: aload_1
    //   1020: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload_2
    //   1025: ldc_w 315
    //   1028: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload_2
    //   1033: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: astore_1
    //   1037: goto +6 -> 1043
    //   1040: ldc -49
    //   1042: astore_1
    //   1043: aload_3
    //   1044: aload_1
    //   1045: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload_3
    //   1050: bipush 41
    //   1052: invokevirtual 190	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload 4
    //   1058: aload_3
    //   1059: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokeinterface 148 2 0
    //   1067: iload 7
    //   1069: ifeq +466 -> 1535
    //   1072: aload 8
    //   1074: invokevirtual 316	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   1077: astore_1
    //   1078: aload_1
    //   1079: invokevirtual 235	okhttp3/Headers:size	()I
    //   1082: istore 5
    //   1084: iconst_0
    //   1085: istore 7
    //   1087: iload 7
    //   1089: iload 5
    //   1091: if_icmpge +16 -> 1107
    //   1094: aload_0
    //   1095: aload_1
    //   1096: iload 7
    //   1098: invokespecial 241	okhttp3/logging/HttpLoggingInterceptor:logHeader	(Lokhttp3/Headers;I)V
    //   1101: iinc 7 1
    //   1104: goto -17 -> 1087
    //   1107: iload 6
    //   1109: ifeq +414 -> 1523
    //   1112: aload 8
    //   1114: invokestatic 322	okhttp3/internal/http/HttpHeaders:hasBody	(Lokhttp3/Response;)Z
    //   1117: ifne +6 -> 1123
    //   1120: goto +403 -> 1523
    //   1123: aload 8
    //   1125: invokevirtual 316	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   1128: invokestatic 243	okhttp3/logging/HttpLoggingInterceptor:bodyHasUnknownEncoding	(Lokhttp3/Headers;)Z
    //   1131: ifeq +18 -> 1149
    //   1134: aload_0
    //   1135: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1138: ldc_w 324
    //   1141: invokeinterface 148 2 0
    //   1146: goto +389 -> 1535
    //   1149: aload 9
    //   1151: invokevirtual 328	okhttp3/ResponseBody:source	()Lokio/BufferedSource;
    //   1154: astore_2
    //   1155: aload_2
    //   1156: ldc2_w 329
    //   1159: invokeinterface 335 3 0
    //   1164: pop
    //   1165: aload_2
    //   1166: invokeinterface 339 1 0
    //   1171: astore_3
    //   1172: ldc 80
    //   1174: aload_1
    //   1175: ldc 64
    //   1177: invokevirtual 70	okhttp3/Headers:get	(Ljava/lang/String;)Ljava/lang/String;
    //   1180: invokevirtual 78	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1183: istore 17
    //   1185: aconst_null
    //   1186: astore_2
    //   1187: aconst_null
    //   1188: astore 4
    //   1190: aload_3
    //   1191: astore_1
    //   1192: iload 17
    //   1194: ifeq +66 -> 1260
    //   1197: aload_3
    //   1198: invokevirtual 91	okio/Buffer:size	()J
    //   1201: lstore 15
    //   1203: new 341	okio/GzipSource
    //   1206: astore_2
    //   1207: aload_2
    //   1208: aload_3
    //   1209: invokevirtual 344	okio/Buffer:clone	()Lokio/Buffer;
    //   1212: invokespecial 347	okio/GzipSource:<init>	(Lokio/Source;)V
    //   1215: new 86	okio/Buffer
    //   1218: astore_1
    //   1219: aload_1
    //   1220: invokespecial 87	okio/Buffer:<init>	()V
    //   1223: aload_1
    //   1224: aload_2
    //   1225: invokevirtual 351	okio/Buffer:writeAll	(Lokio/Source;)J
    //   1228: pop2
    //   1229: aload_2
    //   1230: invokevirtual 354	okio/GzipSource:close	()V
    //   1233: lload 15
    //   1235: invokestatic 360	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1238: astore_2
    //   1239: goto +21 -> 1260
    //   1242: astore_1
    //   1243: goto +7 -> 1250
    //   1246: astore_1
    //   1247: aload 4
    //   1249: astore_2
    //   1250: aload_2
    //   1251: ifnull +7 -> 1258
    //   1254: aload_2
    //   1255: invokevirtual 354	okio/GzipSource:close	()V
    //   1258: aload_1
    //   1259: athrow
    //   1260: getstatic 35	okhttp3/logging/HttpLoggingInterceptor:UTF8	Ljava/nio/charset/Charset;
    //   1263: astore_3
    //   1264: aload 9
    //   1266: invokevirtual 361	okhttp3/ResponseBody:contentType	()Lokhttp3/MediaType;
    //   1269: astore 9
    //   1271: aload_3
    //   1272: astore 4
    //   1274: aload 9
    //   1276: ifnull +11 -> 1287
    //   1279: aload 9
    //   1281: aload_3
    //   1282: invokevirtual 257	okhttp3/MediaType:charset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   1285: astore 4
    //   1287: aload_1
    //   1288: invokestatic 259	okhttp3/logging/HttpLoggingInterceptor:isPlaintext	(Lokio/Buffer;)Z
    //   1291: ifne +70 -> 1361
    //   1294: aload_0
    //   1295: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1298: ldc -49
    //   1300: invokeinterface 148 2 0
    //   1305: aload_0
    //   1306: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1309: astore_2
    //   1310: new 133	java/lang/StringBuilder
    //   1313: dup
    //   1314: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1317: astore 4
    //   1319: aload 4
    //   1321: ldc_w 363
    //   1324: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: pop
    //   1328: aload 4
    //   1330: aload_1
    //   1331: invokevirtual 91	okio/Buffer:size	()J
    //   1334: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: aload 4
    //   1340: ldc_w 267
    //   1343: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: pop
    //   1347: aload_2
    //   1348: aload 4
    //   1350: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1353: invokeinterface 148 2 0
    //   1358: aload 8
    //   1360: areturn
    //   1361: lload 13
    //   1363: lconst_0
    //   1364: lcmp
    //   1365: ifeq +32 -> 1397
    //   1368: aload_0
    //   1369: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1372: ldc -49
    //   1374: invokeinterface 148 2 0
    //   1379: aload_0
    //   1380: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1383: aload_1
    //   1384: invokevirtual 344	okio/Buffer:clone	()Lokio/Buffer;
    //   1387: aload 4
    //   1389: invokevirtual 263	okio/Buffer:readString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   1392: invokeinterface 148 2 0
    //   1397: aload_2
    //   1398: ifnull +70 -> 1468
    //   1401: aload_0
    //   1402: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1405: astore 4
    //   1407: new 133	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1414: astore_3
    //   1415: aload_3
    //   1416: ldc_w 365
    //   1419: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: pop
    //   1423: aload_3
    //   1424: aload_1
    //   1425: invokevirtual 91	okio/Buffer:size	()J
    //   1428: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1431: pop
    //   1432: aload_3
    //   1433: ldc_w 367
    //   1436: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload_3
    //   1441: aload_2
    //   1442: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1445: pop
    //   1446: aload_3
    //   1447: ldc_w 369
    //   1450: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: pop
    //   1454: aload 4
    //   1456: aload_3
    //   1457: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokeinterface 148 2 0
    //   1465: goto +70 -> 1535
    //   1468: aload_0
    //   1469: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1472: astore_2
    //   1473: new 133	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1480: astore 4
    //   1482: aload 4
    //   1484: ldc_w 365
    //   1487: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: aload 4
    //   1493: aload_1
    //   1494: invokevirtual 91	okio/Buffer:size	()J
    //   1497: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1500: pop
    //   1501: aload 4
    //   1503: ldc -37
    //   1505: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: pop
    //   1509: aload_2
    //   1510: aload 4
    //   1512: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1515: invokeinterface 148 2 0
    //   1520: goto +15 -> 1535
    //   1523: aload_0
    //   1524: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1527: ldc_w 371
    //   1530: invokeinterface 148 2 0
    //   1535: aload 8
    //   1537: areturn
    //   1538: astore 4
    //   1540: aload_0
    //   1541: getfield 60	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1544: astore_2
    //   1545: new 133	java/lang/StringBuilder
    //   1548: dup
    //   1549: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1552: astore_1
    //   1553: aload_1
    //   1554: ldc_w 373
    //   1557: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: aload_1
    //   1562: aload 4
    //   1564: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: aload_2
    //   1569: aload_1
    //   1570: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1573: invokeinterface 148 2 0
    //   1578: aload 4
    //   1580: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1581	0	this	HttpLoggingInterceptor
    //   0	1581	1	paramChain	okhttp3.Interceptor.Chain
    //   4	1565	2	localObject1	Object
    //   11	1446	3	localObject2	Object
    //   30	1481	4	localObject3	Object
    //   1538	41	4	localException	Exception
    //   33	1059	5	i	int
    //   42	1066	6	j	int
    //   66	1036	7	k	int
    //   78	1458	8	localObject4	Object
    //   154	1126	9	localObject5	Object
    //   401	10	10	m	int
    //   404	44	11	n	int
    //   553	11	12	localMediaType	okhttp3.MediaType
    //   787	575	13	l1	long
    //   810	424	15	l2	long
    //   1183	10	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   1215	1229	1242	finally
    //   1203	1215	1246	finally
    //   789	798	1538	java/lang/Exception
  }
  
  public void redactHeader(String paramString)
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    localTreeSet.addAll(this.headersToRedact);
    localTreeSet.add(paramString);
    this.headersToRedact = localTreeSet;
  }
  
  public HttpLoggingInterceptor setLevel(Level paramLevel)
  {
    Objects.requireNonNull(paramLevel, "level == null. Use Level.NONE instead.");
    this.level = paramLevel;
    return this;
  }
  
  public static enum Level
  {
    static
    {
      Level localLevel1 = new Level("NONE", 0);
      NONE = localLevel1;
      Level localLevel2 = new Level("BASIC", 1);
      BASIC = localLevel2;
      Level localLevel3 = new Level("HEADERS", 2);
      HEADERS = localLevel3;
      Level localLevel4 = new Level("BODY", 3);
      BODY = localLevel4;
      $VALUES = new Level[] { localLevel1, localLevel2, localLevel3, localLevel4 };
    }
  }
  
  public static abstract interface Logger
  {
    public static final Logger DEFAULT = new Logger()
    {
      public void log(String paramAnonymousString)
      {
        Platform.get().log(4, paramAnonymousString, null);
      }
    };
    
    public abstract void log(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\logging\HttpLoggingInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */