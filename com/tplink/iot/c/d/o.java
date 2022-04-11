package com.tplink.iot.c.d;

import com.google.gson.Gson;
import com.google.gson.d;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor.Logger;
import okio.Buffer;

public class o
  implements Interceptor
{
  private static final Charset a = StandardCharsets.UTF_8;
  private final Gson b = new d().f().b();
  private final HttpLoggingInterceptor.Logger c;
  
  public o()
  {
    this(HttpLoggingInterceptor.Logger.DEFAULT);
  }
  
  public o(HttpLoggingInterceptor.Logger paramLogger)
  {
    this.c = paramLogger;
  }
  
  private static boolean a(Headers paramHeaders)
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
  
  static boolean b(Buffer paramBuffer)
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
  
  /* Error */
  public okhttp3.Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 111 1 0
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 114	java/lang/Object:hashCode	()I
    //   11: istore_3
    //   12: aload_2
    //   13: invokevirtual 120	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +9 -> 29
    //   23: iconst_1
    //   24: istore 5
    //   26: goto +6 -> 32
    //   29: iconst_0
    //   30: istore 5
    //   32: aload_1
    //   33: invokeinterface 124 1 0
    //   38: astore 6
    //   40: new 126	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   47: astore 7
    //   49: aload 7
    //   51: ldc -127
    //   53: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 7
    //   59: iload_3
    //   60: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 7
    //   66: ldc -118
    //   68: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: new 126	java/lang/StringBuilder
    //   75: dup
    //   76: aload 7
    //   78: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: astore 8
    //   86: aload 8
    //   88: ldc -109
    //   90: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 8
    //   96: ldc -107
    //   98: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 8
    //   104: aload_2
    //   105: invokevirtual 152	okhttp3/Request:method	()Ljava/lang/String;
    //   108: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 8
    //   114: ldc -102
    //   116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc -100
    //   122: astore 7
    //   124: aload 8
    //   126: ldc -100
    //   128: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 8
    //   134: aload_2
    //   135: invokevirtual 160	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   138: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 8
    //   144: ldc -102
    //   146: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 8
    //   152: ldc -91
    //   154: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 6
    //   160: ifnull +15 -> 175
    //   163: aload 6
    //   165: invokeinterface 171 1 0
    //   170: astore 6
    //   172: goto +7 -> 179
    //   175: ldc -83
    //   177: astore 6
    //   179: aload 8
    //   181: aload 6
    //   183: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 8
    //   189: ldc -81
    //   191: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: iload 5
    //   197: ifeq +77 -> 274
    //   200: aload 4
    //   202: invokevirtual 181	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   205: ifnull +30 -> 235
    //   208: aload 8
    //   210: ldc -73
    //   212: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 8
    //   218: aload 4
    //   220: invokevirtual 181	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   223: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 8
    //   229: ldc -71
    //   231: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 4
    //   237: invokevirtual 188	okhttp3/RequestBody:contentLength	()J
    //   240: ldc2_w 189
    //   243: lcmp
    //   244: ifeq +30 -> 274
    //   247: aload 8
    //   249: ldc -64
    //   251: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 8
    //   257: aload 4
    //   259: invokevirtual 188	okhttp3/RequestBody:contentLength	()J
    //   262: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 8
    //   268: ldc -71
    //   270: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_2
    //   275: invokevirtual 199	okhttp3/Request:headers	()Lokhttp3/Headers;
    //   278: astore 9
    //   280: aload 9
    //   282: invokevirtual 201	okhttp3/Headers:size	()I
    //   285: istore 10
    //   287: iconst_0
    //   288: istore 11
    //   290: aload 7
    //   292: astore 6
    //   294: iload 11
    //   296: iload 10
    //   298: if_icmpge +83 -> 381
    //   301: aload 9
    //   303: iload 11
    //   305: invokevirtual 205	okhttp3/Headers:name	(I)Ljava/lang/String;
    //   308: astore 7
    //   310: ldc -49
    //   312: aload 7
    //   314: invokevirtual 64	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   317: ifne +58 -> 375
    //   320: ldc -47
    //   322: aload 7
    //   324: invokevirtual 64	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   327: ifne +48 -> 375
    //   330: aload 8
    //   332: ldc -45
    //   334: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 8
    //   340: aload 7
    //   342: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 8
    //   348: ldc -43
    //   350: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 8
    //   356: aload 9
    //   358: iload 11
    //   360: invokevirtual 216	okhttp3/Headers:value	(I)Ljava/lang/String;
    //   363: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 8
    //   369: ldc -71
    //   371: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: iinc 11 1
    //   378: goto -84 -> 294
    //   381: aload 8
    //   383: ldc -38
    //   385: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: iload 5
    //   391: ifne +14 -> 405
    //   394: aload 8
    //   396: ldc -36
    //   398: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: goto +209 -> 611
    //   405: aload_2
    //   406: invokevirtual 199	okhttp3/Request:headers	()Lokhttp3/Headers;
    //   409: invokestatic 222	com/tplink/iot/c/d/o:a	(Lokhttp3/Headers;)Z
    //   412: ifeq +14 -> 426
    //   415: aload 8
    //   417: ldc -32
    //   419: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: goto -21 -> 402
    //   426: new 71	okio/Buffer
    //   429: dup
    //   430: invokespecial 72	okio/Buffer:<init>	()V
    //   433: astore 12
    //   435: aload 4
    //   437: aload 12
    //   439: invokevirtual 228	okhttp3/RequestBody:writeTo	(Lokio/BufferedSink;)V
    //   442: getstatic 21	com/tplink/iot/c/d/o:a	Ljava/nio/charset/Charset;
    //   445: astore 13
    //   447: aload 4
    //   449: invokevirtual 181	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   452: astore 14
    //   454: aload 13
    //   456: astore 7
    //   458: aload 14
    //   460: ifnull +25 -> 485
    //   463: aload 14
    //   465: aload 13
    //   467: invokevirtual 234	okhttp3/MediaType:charset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   470: astore 14
    //   472: aload 13
    //   474: astore 7
    //   476: aload 14
    //   478: ifnull +7 -> 485
    //   481: aload 14
    //   483: astore 7
    //   485: aload 8
    //   487: ldc -20
    //   489: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 12
    //   495: invokestatic 238	com/tplink/iot/c/d/o:b	(Lokio/Buffer;)Z
    //   498: ifeq +75 -> 573
    //   501: aload 12
    //   503: aload 7
    //   505: invokevirtual 242	okio/Buffer:readString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   508: astore 7
    //   510: aload_0
    //   511: getfield 45	com/tplink/iot/c/d/o:b	Lcom/google/gson/Gson;
    //   514: aload 7
    //   516: ldc -12
    //   518: invokevirtual 250	com/google/gson/Gson:l	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   521: checkcast 244	com/google/gson/i
    //   524: astore 13
    //   526: aload 8
    //   528: aload_0
    //   529: getfield 45	com/tplink/iot/c/d/o:b	Lcom/google/gson/Gson;
    //   532: aload 13
    //   534: invokevirtual 254	com/google/gson/Gson:t	(Lcom/google/gson/i;)Ljava/lang/String;
    //   537: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 8
    //   543: ldc -71
    //   545: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: goto +21 -> 570
    //   552: astore 13
    //   554: aload 8
    //   556: aload 7
    //   558: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 8
    //   564: ldc -71
    //   566: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: goto +32 -> 602
    //   573: aload 8
    //   575: ldc_w 256
    //   578: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 8
    //   584: aload 4
    //   586: invokevirtual 188	okhttp3/RequestBody:contentLength	()J
    //   589: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 8
    //   595: ldc_w 258
    //   598: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 8
    //   604: ldc_w 260
    //   607: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload_0
    //   612: getfield 47	com/tplink/iot/c/d/o:c	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   615: aload 8
    //   617: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokeinterface 263 2 0
    //   625: invokestatic 268	java/lang/System:nanoTime	()J
    //   628: lstore 15
    //   630: aload_1
    //   631: aload_2
    //   632: invokeinterface 272 2 0
    //   637: astore_2
    //   638: getstatic 278	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   641: invokestatic 268	java/lang/System:nanoTime	()J
    //   644: lload 15
    //   646: lsub
    //   647: invokevirtual 282	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   650: lstore 17
    //   652: new 126	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   659: astore_1
    //   660: aload_1
    //   661: ldc_w 284
    //   664: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload_1
    //   669: iload_3
    //   670: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload_1
    //   675: ldc_w 286
    //   678: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: new 126	java/lang/StringBuilder
    //   685: dup
    //   686: aload_1
    //   687: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   693: astore 8
    //   695: aload 8
    //   697: ldc_w 288
    //   700: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload 8
    //   706: ldc -91
    //   708: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 8
    //   714: aload_2
    //   715: invokevirtual 291	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   718: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload 8
    //   724: ldc -102
    //   726: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 8
    //   732: ldc_w 293
    //   735: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 8
    //   741: aload_2
    //   742: invokevirtual 296	okhttp3/Response:code	()I
    //   745: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 8
    //   751: ldc -102
    //   753: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 8
    //   759: ldc_w 298
    //   762: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 8
    //   768: aload_2
    //   769: invokevirtual 301	okhttp3/Response:message	()Ljava/lang/String;
    //   772: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 8
    //   778: ldc -102
    //   780: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload 8
    //   786: aload 6
    //   788: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: aload 8
    //   794: aload_2
    //   795: invokevirtual 302	okhttp3/Response:request	()Lokhttp3/Request;
    //   798: invokevirtual 160	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   801: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 8
    //   807: ldc -71
    //   809: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload_2
    //   814: invokevirtual 305	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   817: astore 14
    //   819: aload 14
    //   821: ifnonnull +36 -> 857
    //   824: aload 8
    //   826: ldc -38
    //   828: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 8
    //   834: ldc_w 307
    //   837: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload_0
    //   842: getfield 47	com/tplink/iot/c/d/o:c	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   845: aload 8
    //   847: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: invokeinterface 263 2 0
    //   855: aload_2
    //   856: areturn
    //   857: aload 14
    //   859: invokevirtual 310	okhttp3/ResponseBody:contentLength	()J
    //   862: lstore 15
    //   864: lload 15
    //   866: ldc2_w 189
    //   869: lcmp
    //   870: ifeq +34 -> 904
    //   873: new 126	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   880: astore_1
    //   881: aload_1
    //   882: lload 15
    //   884: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload_1
    //   889: ldc_w 312
    //   892: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload_1
    //   897: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: astore_1
    //   901: goto +7 -> 908
    //   904: ldc_w 314
    //   907: astore_1
    //   908: aload 8
    //   910: ldc_w 316
    //   913: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload 8
    //   919: lload 17
    //   921: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: aload 8
    //   927: ldc_w 318
    //   930: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload 8
    //   936: ldc_w 320
    //   939: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload 8
    //   945: aload_1
    //   946: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload 8
    //   952: ldc_w 322
    //   955: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload_2
    //   960: invokevirtual 323	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   963: astore 6
    //   965: aload 6
    //   967: invokevirtual 201	okhttp3/Headers:size	()I
    //   970: istore 5
    //   972: iconst_0
    //   973: istore 10
    //   975: iload 10
    //   977: iload 5
    //   979: if_icmpge +61 -> 1040
    //   982: aload 6
    //   984: iload 10
    //   986: invokevirtual 205	okhttp3/Headers:name	(I)Ljava/lang/String;
    //   989: astore_1
    //   990: aload 8
    //   992: ldc -45
    //   994: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: aload 8
    //   1000: aload_1
    //   1001: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload 8
    //   1007: ldc -43
    //   1009: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload 8
    //   1015: aload 6
    //   1017: iload 10
    //   1019: invokevirtual 216	okhttp3/Headers:value	(I)Ljava/lang/String;
    //   1022: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: aload 8
    //   1028: ldc -71
    //   1030: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: iinc 10 1
    //   1037: goto -62 -> 975
    //   1040: aload 8
    //   1042: ldc -38
    //   1044: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: aload_2
    //   1049: invokestatic 329	okhttp3/internal/http/HttpHeaders:hasBody	(Lokhttp3/Response;)Z
    //   1052: ifne +15 -> 1067
    //   1055: aload 8
    //   1057: ldc_w 331
    //   1060: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: goto +445 -> 1509
    //   1067: aload_2
    //   1068: invokevirtual 323	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   1071: invokestatic 222	com/tplink/iot/c/d/o:a	(Lokhttp3/Headers;)Z
    //   1074: ifeq +31 -> 1105
    //   1077: aload 8
    //   1079: ldc -32
    //   1081: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload 8
    //   1087: ldc -71
    //   1089: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: pop
    //   1093: aload 8
    //   1095: ldc_w 331
    //   1098: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: goto +407 -> 1509
    //   1105: aload 14
    //   1107: invokevirtual 335	okhttp3/ResponseBody:source	()Lokio/BufferedSource;
    //   1110: astore_1
    //   1111: aload_1
    //   1112: ldc2_w 336
    //   1115: invokeinterface 342 3 0
    //   1120: pop
    //   1121: aload_1
    //   1122: invokeinterface 346 1 0
    //   1127: astore 13
    //   1129: ldc 66
    //   1131: aload 9
    //   1133: ldc 50
    //   1135: invokevirtual 56	okhttp3/Headers:get	(Ljava/lang/String;)Ljava/lang/String;
    //   1138: invokevirtual 64	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1141: istore 19
    //   1143: aconst_null
    //   1144: astore 6
    //   1146: aconst_null
    //   1147: astore 7
    //   1149: aload 13
    //   1151: astore_1
    //   1152: iload 19
    //   1154: ifeq +76 -> 1230
    //   1157: aload 13
    //   1159: invokevirtual 76	okio/Buffer:size	()J
    //   1162: lstore 17
    //   1164: new 348	okio/GzipSource
    //   1167: astore 6
    //   1169: aload 6
    //   1171: aload 13
    //   1173: invokevirtual 351	okio/Buffer:clone	()Lokio/Buffer;
    //   1176: invokespecial 354	okio/GzipSource:<init>	(Lokio/Source;)V
    //   1179: new 71	okio/Buffer
    //   1182: astore_1
    //   1183: aload_1
    //   1184: invokespecial 72	okio/Buffer:<init>	()V
    //   1187: aload_1
    //   1188: aload 6
    //   1190: invokevirtual 358	okio/Buffer:writeAll	(Lokio/Source;)J
    //   1193: pop2
    //   1194: aload 6
    //   1196: invokevirtual 361	okio/GzipSource:close	()V
    //   1199: lload 17
    //   1201: invokestatic 367	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1204: astore 6
    //   1206: goto +24 -> 1230
    //   1209: astore_1
    //   1210: goto +8 -> 1218
    //   1213: astore_1
    //   1214: aload 7
    //   1216: astore 6
    //   1218: aload 6
    //   1220: ifnull +8 -> 1228
    //   1223: aload 6
    //   1225: invokevirtual 361	okio/GzipSource:close	()V
    //   1228: aload_1
    //   1229: athrow
    //   1230: getstatic 21	com/tplink/iot/c/d/o:a	Ljava/nio/charset/Charset;
    //   1233: astore 13
    //   1235: aload 14
    //   1237: invokevirtual 368	okhttp3/ResponseBody:contentType	()Lokhttp3/MediaType;
    //   1240: astore 14
    //   1242: aload 13
    //   1244: astore 7
    //   1246: aload 14
    //   1248: ifnull +25 -> 1273
    //   1251: aload 14
    //   1253: aload 13
    //   1255: invokevirtual 234	okhttp3/MediaType:charset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   1258: astore 14
    //   1260: aload 13
    //   1262: astore 7
    //   1264: aload 14
    //   1266: ifnull +7 -> 1273
    //   1269: aload 14
    //   1271: astore 7
    //   1273: aload 8
    //   1275: ldc_w 370
    //   1278: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload_1
    //   1283: invokestatic 238	com/tplink/iot/c/d/o:b	(Lokio/Buffer;)Z
    //   1286: ifne +55 -> 1341
    //   1289: aload 8
    //   1291: ldc_w 256
    //   1294: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: pop
    //   1298: aload 8
    //   1300: aload_1
    //   1301: invokevirtual 76	okio/Buffer:size	()J
    //   1304: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1307: pop
    //   1308: aload 8
    //   1310: ldc_w 258
    //   1313: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload 8
    //   1319: ldc -38
    //   1321: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload_0
    //   1326: getfield 47	com/tplink/iot/c/d/o:c	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1329: aload 8
    //   1331: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: invokeinterface 263 2 0
    //   1339: aload_2
    //   1340: areturn
    //   1341: lload 15
    //   1343: lconst_0
    //   1344: lcmp
    //   1345: ifeq +74 -> 1419
    //   1348: aload_1
    //   1349: invokevirtual 351	okio/Buffer:clone	()Lokio/Buffer;
    //   1352: aload 7
    //   1354: invokevirtual 242	okio/Buffer:readString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   1357: astore 7
    //   1359: aload_0
    //   1360: getfield 45	com/tplink/iot/c/d/o:b	Lcom/google/gson/Gson;
    //   1363: aload 7
    //   1365: ldc -12
    //   1367: invokevirtual 250	com/google/gson/Gson:l	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   1370: checkcast 244	com/google/gson/i
    //   1373: astore 13
    //   1375: aload 8
    //   1377: aload_0
    //   1378: getfield 45	com/tplink/iot/c/d/o:b	Lcom/google/gson/Gson;
    //   1381: aload 13
    //   1383: invokevirtual 254	com/google/gson/Gson:t	(Lcom/google/gson/i;)Ljava/lang/String;
    //   1386: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: pop
    //   1390: aload 8
    //   1392: ldc -71
    //   1394: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: goto +21 -> 1419
    //   1401: astore 13
    //   1403: aload 8
    //   1405: aload 7
    //   1407: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: pop
    //   1411: aload 8
    //   1413: ldc -71
    //   1415: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: pop
    //   1419: aload 6
    //   1421: ifnull +51 -> 1472
    //   1424: aload 8
    //   1426: ldc_w 372
    //   1429: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: pop
    //   1433: aload 8
    //   1435: aload_1
    //   1436: invokevirtual 76	okio/Buffer:size	()J
    //   1439: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1442: pop
    //   1443: aload 8
    //   1445: ldc_w 374
    //   1448: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: pop
    //   1452: aload 8
    //   1454: aload 6
    //   1456: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 8
    //   1462: ldc_w 376
    //   1465: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: goto +31 -> 1500
    //   1472: aload 8
    //   1474: ldc_w 372
    //   1477: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: aload 8
    //   1483: aload_1
    //   1484: invokevirtual 76	okio/Buffer:size	()J
    //   1487: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: aload 8
    //   1493: ldc_w 378
    //   1496: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: pop
    //   1500: aload 8
    //   1502: ldc_w 380
    //   1505: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: pop
    //   1509: aload_0
    //   1510: getfield 47	com/tplink/iot/c/d/o:c	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1513: aload 8
    //   1515: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1518: invokeinterface 263 2 0
    //   1523: aload_2
    //   1524: areturn
    //   1525: astore 7
    //   1527: aload_0
    //   1528: getfield 47	com/tplink/iot/c/d/o:c	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1531: astore_1
    //   1532: new 126	java/lang/StringBuilder
    //   1535: dup
    //   1536: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1539: astore 6
    //   1541: aload 6
    //   1543: ldc_w 382
    //   1546: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: pop
    //   1550: aload 6
    //   1552: aload 7
    //   1554: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1557: pop
    //   1558: aload_1
    //   1559: aload 6
    //   1561: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: invokeinterface 263 2 0
    //   1569: aload 7
    //   1571: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1572	0	this	o
    //   0	1572	1	paramChain	okhttp3.Interceptor.Chain
    //   6	1518	2	localObject1	Object
    //   11	659	3	i	int
    //   16	569	4	localRequestBody	okhttp3.RequestBody
    //   24	956	5	j	int
    //   38	1522	6	localObject2	Object
    //   47	1359	7	localObject3	Object
    //   1525	45	7	localException1	Exception
    //   84	1430	8	localStringBuilder	StringBuilder
    //   278	854	9	localHeaders	Headers
    //   285	750	10	k	int
    //   288	88	11	m	int
    //   433	69	12	localBuffer	Buffer
    //   445	88	13	localObject4	Object
    //   552	1	13	localException2	Exception
    //   1127	255	13	localObject5	Object
    //   1401	1	13	localException3	Exception
    //   452	818	14	localObject6	Object
    //   628	714	15	l1	long
    //   650	550	17	l2	long
    //   1141	12	19	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   510	549	552	java/lang/Exception
    //   1179	1194	1209	finally
    //   1164	1179	1213	finally
    //   1359	1398	1401	java/lang/Exception
    //   630	638	1525	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */