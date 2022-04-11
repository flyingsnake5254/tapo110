package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo.ClientType;
import com.google.android.datatransport.cct.internal.ClientInfo.a;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo.NetworkType;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.cct.internal.a.a;
import com.google.android.datatransport.cct.internal.j;
import com.google.android.datatransport.cct.internal.k;
import com.google.android.datatransport.cct.internal.k.a;
import com.google.android.datatransport.cct.internal.l.a;
import com.google.android.datatransport.h.h;
import com.google.android.datatransport.h.i;
import com.google.android.datatransport.h.i.a;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.f;
import com.google.firebase.encoders.DataEncoder;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

final class d
  implements com.google.android.datatransport.runtime.backends.l
{
  private final DataEncoder a = j.b();
  private final ConnectivityManager b;
  private final Context c;
  final URL d;
  private final com.google.android.datatransport.h.y.a e;
  private final com.google.android.datatransport.h.y.a f;
  private final int g;
  
  d(Context paramContext, com.google.android.datatransport.h.y.a parama1, com.google.android.datatransport.h.y.a parama2)
  {
    this(paramContext, parama1, parama2, 40000);
  }
  
  d(Context paramContext, com.google.android.datatransport.h.y.a parama1, com.google.android.datatransport.h.y.a parama2, int paramInt)
  {
    this.c = paramContext;
    this.b = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.d = m(c.a);
    this.e = parama2;
    this.f = parama1;
    this.g = paramInt;
  }
  
  /* Error */
  private b c(a parama)
    throws IOException
  {
    // Byte code:
    //   0: ldc 82
    //   2: ldc 84
    //   4: aload_1
    //   5: getfield 86	com/google/android/datatransport/cct/d$a:a	Ljava/net/URL;
    //   8: invokestatic 91	com/google/android/datatransport/h/v/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   11: aload_1
    //   12: getfield 86	com/google/android/datatransport/cct/d$a:a	Ljava/net/URL;
    //   15: invokevirtual 97	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 99	java/net/HttpURLConnection
    //   21: astore_2
    //   22: aload_2
    //   23: sipush 30000
    //   26: invokevirtual 103	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   29: aload_2
    //   30: aload_0
    //   31: getfield 71	com/google/android/datatransport/cct/d:g	I
    //   34: invokevirtual 106	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   37: aload_2
    //   38: iconst_1
    //   39: invokevirtual 110	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   42: aload_2
    //   43: iconst_0
    //   44: invokevirtual 113	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   47: aload_2
    //   48: ldc 115
    //   50: invokevirtual 119	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   53: aload_2
    //   54: ldc 121
    //   56: ldc 123
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: ldc 125
    //   66: aastore
    //   67: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 135	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_2
    //   74: ldc -119
    //   76: ldc -117
    //   78: invokevirtual 135	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_2
    //   82: ldc -115
    //   84: ldc -113
    //   86: invokevirtual 135	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_2
    //   90: ldc -111
    //   92: ldc -117
    //   94: invokevirtual 135	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: getfield 147	com/google/android/datatransport/cct/d$a:c	Ljava/lang/String;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnull +10 -> 113
    //   106: aload_2
    //   107: ldc -107
    //   109: aload_3
    //   110: invokevirtual 135	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_2
    //   114: invokevirtual 153	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   117: astore_3
    //   118: new 155	java/util/zip/GZIPOutputStream
    //   121: astore 4
    //   123: aload 4
    //   125: aload_3
    //   126: invokespecial 158	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   129: aload_0
    //   130: getfield 40	com/google/android/datatransport/cct/d:a	Lcom/google/firebase/encoders/DataEncoder;
    //   133: astore 5
    //   135: aload_1
    //   136: getfield 161	com/google/android/datatransport/cct/d$a:b	Lcom/google/android/datatransport/cct/internal/j;
    //   139: astore_1
    //   140: new 163	java/io/BufferedWriter
    //   143: astore 6
    //   145: new 165	java/io/OutputStreamWriter
    //   148: astore 7
    //   150: aload 7
    //   152: aload 4
    //   154: invokespecial 166	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   157: aload 6
    //   159: aload 7
    //   161: invokespecial 169	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   164: aload 5
    //   166: aload_1
    //   167: aload 6
    //   169: invokeinterface 175 3 0
    //   174: aload 4
    //   176: invokevirtual 180	java/io/OutputStream:close	()V
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 180	java/io/OutputStream:close	()V
    //   187: aload_2
    //   188: invokevirtual 184	java/net/HttpURLConnection:getResponseCode	()I
    //   191: istore 8
    //   193: new 186	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   200: astore_1
    //   201: aload_1
    //   202: ldc -67
    //   204: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_1
    //   209: iload 8
    //   211: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: ldc 82
    //   217: aload_1
    //   218: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 202	com/google/android/datatransport/h/v/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: new 186	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   231: astore_1
    //   232: aload_1
    //   233: ldc -52
    //   235: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: aload_2
    //   241: ldc -115
    //   243: invokevirtual 208	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 82
    //   252: aload_1
    //   253: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 202	com/google/android/datatransport/h/v/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: new 186	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   266: astore_1
    //   267: aload_1
    //   268: ldc -46
    //   270: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload_2
    //   276: ldc -119
    //   278: invokevirtual 208	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   281: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: ldc 82
    //   287: aload_1
    //   288: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 202	com/google/android/datatransport/h/v/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: iload 8
    //   296: sipush 302
    //   299: if_icmpeq +159 -> 458
    //   302: iload 8
    //   304: sipush 301
    //   307: if_icmpeq +151 -> 458
    //   310: iload 8
    //   312: sipush 307
    //   315: if_icmpne +6 -> 321
    //   318: goto +140 -> 458
    //   321: iload 8
    //   323: sipush 200
    //   326: if_icmpeq +15 -> 341
    //   329: new 11	com/google/android/datatransport/cct/d$b
    //   332: dup
    //   333: iload 8
    //   335: aconst_null
    //   336: lconst_0
    //   337: invokespecial 213	com/google/android/datatransport/cct/d$b:<init>	(ILjava/net/URL;J)V
    //   340: areturn
    //   341: aload_2
    //   342: invokevirtual 217	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   345: astore_1
    //   346: aload_1
    //   347: aload_2
    //   348: ldc -119
    //   350: invokevirtual 208	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   353: invokestatic 221	com/google/android/datatransport/cct/d:l	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   356: astore_2
    //   357: new 223	java/io/BufferedReader
    //   360: astore 4
    //   362: new 225	java/io/InputStreamReader
    //   365: astore_3
    //   366: aload_3
    //   367: aload_2
    //   368: invokespecial 228	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   371: aload 4
    //   373: aload_3
    //   374: invokespecial 231	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   377: aload 4
    //   379: invokestatic 236	com/google/android/datatransport/cct/internal/m:b	(Ljava/io/Reader;)Lcom/google/android/datatransport/cct/internal/m;
    //   382: invokevirtual 239	com/google/android/datatransport/cct/internal/m:c	()J
    //   385: lstore 9
    //   387: new 11	com/google/android/datatransport/cct/d$b
    //   390: astore_3
    //   391: aload_3
    //   392: iload 8
    //   394: aconst_null
    //   395: lload 9
    //   397: invokespecial 213	com/google/android/datatransport/cct/d$b:<init>	(ILjava/net/URL;J)V
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 242	java/io/InputStream:close	()V
    //   408: aload_1
    //   409: ifnull +7 -> 416
    //   412: aload_1
    //   413: invokevirtual 242	java/io/InputStream:close	()V
    //   416: aload_3
    //   417: areturn
    //   418: astore_3
    //   419: aload_2
    //   420: ifnull +16 -> 436
    //   423: aload_2
    //   424: invokevirtual 242	java/io/InputStream:close	()V
    //   427: goto +9 -> 436
    //   430: astore_2
    //   431: aload_3
    //   432: aload_2
    //   433: invokevirtual 248	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   436: aload_3
    //   437: athrow
    //   438: astore_2
    //   439: aload_1
    //   440: ifnull +16 -> 456
    //   443: aload_1
    //   444: invokevirtual 242	java/io/InputStream:close	()V
    //   447: goto +9 -> 456
    //   450: astore_1
    //   451: aload_2
    //   452: aload_1
    //   453: invokevirtual 248	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   456: aload_2
    //   457: athrow
    //   458: new 11	com/google/android/datatransport/cct/d$b
    //   461: dup
    //   462: iload 8
    //   464: new 93	java/net/URL
    //   467: dup
    //   468: aload_2
    //   469: ldc -6
    //   471: invokevirtual 208	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   474: invokespecial 252	java/net/URL:<init>	(Ljava/lang/String;)V
    //   477: lconst_0
    //   478: invokespecial 213	com/google/android/datatransport/cct/d$b:<init>	(ILjava/net/URL;J)V
    //   481: areturn
    //   482: astore_1
    //   483: aload 4
    //   485: invokevirtual 180	java/io/OutputStream:close	()V
    //   488: goto +9 -> 497
    //   491: astore_2
    //   492: aload_1
    //   493: aload_2
    //   494: invokevirtual 248	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   497: aload_1
    //   498: athrow
    //   499: astore_1
    //   500: aload_3
    //   501: ifnull +16 -> 517
    //   504: aload_3
    //   505: invokevirtual 180	java/io/OutputStream:close	()V
    //   508: goto +9 -> 517
    //   511: astore_2
    //   512: aload_1
    //   513: aload_2
    //   514: invokevirtual 248	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   517: aload_1
    //   518: athrow
    //   519: astore_1
    //   520: goto +4 -> 524
    //   523: astore_1
    //   524: ldc 82
    //   526: ldc -2
    //   528: aload_1
    //   529: invokestatic 257	com/google/android/datatransport/h/v/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   532: new 11	com/google/android/datatransport/cct/d$b
    //   535: dup
    //   536: sipush 400
    //   539: aconst_null
    //   540: lconst_0
    //   541: invokespecial 213	com/google/android/datatransport/cct/d$b:<init>	(ILjava/net/URL;J)V
    //   544: areturn
    //   545: astore_1
    //   546: goto +4 -> 550
    //   549: astore_1
    //   550: ldc 82
    //   552: ldc_w 259
    //   555: aload_1
    //   556: invokestatic 257	com/google/android/datatransport/h/v/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   559: new 11	com/google/android/datatransport/cct/d$b
    //   562: dup
    //   563: sipush 500
    //   566: aconst_null
    //   567: lconst_0
    //   568: invokespecial 213	com/google/android/datatransport/cct/d$b:<init>	(ILjava/net/URL;J)V
    //   571: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	d
    //   0	572	1	parama	a
    //   21	403	2	localObject1	Object
    //   430	3	2	localThrowable1	Throwable
    //   438	31	2	localObject2	Object
    //   491	3	2	localThrowable2	Throwable
    //   511	3	2	localThrowable3	Throwable
    //   101	316	3	localObject3	Object
    //   418	87	3	localObject4	Object
    //   121	363	4	localObject5	Object
    //   133	32	5	localDataEncoder	DataEncoder
    //   143	25	6	localBufferedWriter	java.io.BufferedWriter
    //   148	12	7	localOutputStreamWriter	java.io.OutputStreamWriter
    //   191	272	8	i	int
    //   385	11	9	l	long
    // Exception table:
    //   from	to	target	type
    //   357	400	418	finally
    //   423	427	430	finally
    //   346	357	438	finally
    //   404	408	438	finally
    //   431	436	438	finally
    //   436	438	438	finally
    //   443	447	450	finally
    //   129	174	482	finally
    //   483	488	491	finally
    //   118	129	499	finally
    //   174	179	499	finally
    //   492	497	499	finally
    //   497	499	499	finally
    //   504	508	511	finally
    //   113	118	519	java/io/IOException
    //   183	187	519	java/io/IOException
    //   512	517	519	java/io/IOException
    //   517	519	519	java/io/IOException
    //   113	118	523	com/google/firebase/encoders/EncodingException
    //   183	187	523	com/google/firebase/encoders/EncodingException
    //   512	517	523	com/google/firebase/encoders/EncodingException
    //   517	519	523	com/google/firebase/encoders/EncodingException
    //   113	118	545	java/net/UnknownHostException
    //   183	187	545	java/net/UnknownHostException
    //   512	517	545	java/net/UnknownHostException
    //   517	519	545	java/net/UnknownHostException
    //   113	118	549	java/net/ConnectException
    //   183	187	549	java/net/ConnectException
    //   512	517	549	java/net/ConnectException
    //   517	519	549	java/net/ConnectException
  }
  
  private static int d(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
    }
    int i = paramNetworkInfo.getSubtype();
    if (i == -1) {
      return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
    }
    if (NetworkConnectionInfo.MobileSubtype.forNumber(i) == null) {
      i = 0;
    }
    return i;
  }
  
  private static int e(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return NetworkConnectionInfo.NetworkType.NONE.getValue();
    }
    return paramNetworkInfo.getType();
  }
  
  private static int f(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      com.google.android.datatransport.h.v.a.c("CctTransportBackend", "Unable to find version code for package", paramContext);
    }
    return -1;
  }
  
  private j g(f paramf)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramf.b().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      i locali1 = (i)((Iterator)localObject2).next();
      paramf = locali1.j();
      if (!((HashMap)localObject1).containsKey(paramf))
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add(locali1);
        ((HashMap)localObject1).put(paramf, localObject3);
      }
      else
      {
        ((List)((HashMap)localObject1).get(paramf)).add(locali1);
      }
    }
    localObject2 = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramf = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (i)((List)paramf.getValue()).get(0);
      localObject3 = com.google.android.datatransport.cct.internal.l.a().f(QosTier.DEFAULT).g(this.f.a()).h(this.e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(com.google.android.datatransport.cct.internal.a.a().m(Integer.valueOf(((i)localObject3).g("sdk-version"))).j(((i)localObject3).b("model")).f(((i)localObject3).b("hardware")).d(((i)localObject3).b("device")).l(((i)localObject3).b("product")).k(((i)localObject3).b("os-uild")).h(((i)localObject3).b("manufacturer")).e(((i)localObject3).b("fingerprint")).c(((i)localObject3).b("country")).g(((i)localObject3).b("locale")).i(((i)localObject3).b("mcc_mnc")).b(((i)localObject3).b("application_build")).a()).a());
      try
      {
        ((l.a)localObject3).i(Integer.parseInt((String)paramf.getKey()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ((l.a)localObject3).j((String)paramf.getKey());
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((List)paramf.getValue()).iterator();
      while (localIterator.hasNext())
      {
        i locali2 = (i)localIterator.next();
        paramf = locali2.e();
        com.google.android.datatransport.b localb = paramf.b();
        if (localb.equals(com.google.android.datatransport.b.b("proto")))
        {
          paramf = k.j(paramf.a());
        }
        else
        {
          if (!localb.equals(com.google.android.datatransport.b.b("json"))) {
            break label608;
          }
          paramf = k.i(new String(paramf.a(), Charset.forName("UTF-8")));
        }
        paramf.c(locali2.f()).d(locali2.k()).h(locali2.h("tz-offset")).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.forNumber(locali2.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.forNumber(locali2.g("mobile-subtype"))).a());
        if (locali2.d() != null) {
          paramf.b(locali2.d());
        }
        localArrayList.add(paramf.a());
        continue;
        label608:
        com.google.android.datatransport.h.v.a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", localb);
      }
      ((l.a)localObject3).c(localArrayList);
      ((List)localObject2).add(((l.a)localObject3).a());
    }
    return j.a((List)localObject2);
  }
  
  private static TelephonyManager h(Context paramContext)
  {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  @VisibleForTesting
  static long i()
  {
    Calendar.getInstance();
    return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
  }
  
  private static InputStream l(InputStream paramInputStream, String paramString)
    throws IOException
  {
    if ("gzip".equals(paramString)) {
      return new GZIPInputStream(paramInputStream);
    }
    return paramInputStream;
  }
  
  private static URL m(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid url: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString(), localMalformedURLException);
    }
  }
  
  public i a(i parami)
  {
    NetworkInfo localNetworkInfo = this.b.getActiveNetworkInfo();
    return parami.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", i()).a("net-type", e(localNetworkInfo)).a("mobile-subtype", d(localNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", h(this.c).getSimOperator()).c("application_build", Integer.toString(f(this.c))).d();
  }
  
  public BackendResponse b(f paramf)
  {
    j localj = g(paramf);
    URL localURL = this.d;
    Object localObject1 = paramf.c();
    f localf = null;
    Object localObject2 = null;
    Object localObject3 = localURL;
    if (localObject1 != null) {
      try
      {
        localObject1 = c.c(paramf.c());
        paramf = (f)localObject2;
        if (((c)localObject1).d() != null) {
          paramf = ((c)localObject1).d();
        }
        localObject3 = localURL;
        localf = paramf;
        if (((c)localObject1).e() != null)
        {
          localObject3 = m(((c)localObject1).e());
          localf = paramf;
        }
      }
      catch (IllegalArgumentException paramf)
      {
        return BackendResponse.a();
      }
    }
    try
    {
      paramf = new com/google/android/datatransport/cct/d$a;
      paramf.<init>((URL)localObject3, localj, localf);
      localObject3 = new com/google/android/datatransport/cct/b;
      ((b)localObject3).<init>(this);
      paramf = (b)com.google.android.datatransport.h.w.b.a(5, paramf, (com.google.android.datatransport.h.w.a)localObject3, a.a);
      int i = paramf.a;
      if (i == 200) {
        return BackendResponse.d(paramf.c);
      }
      if ((i < 500) && (i != 404)) {
        return BackendResponse.a();
      }
      paramf = BackendResponse.e();
      return paramf;
    }
    catch (IOException paramf)
    {
      com.google.android.datatransport.h.v.a.c("CctTransportBackend", "Could not make request to the backend", paramf);
    }
    return BackendResponse.e();
  }
  
  static final class a
  {
    final URL a;
    final j b;
    @Nullable
    final String c;
    
    a(URL paramURL, j paramj, @Nullable String paramString)
    {
      this.a = paramURL;
      this.b = paramj;
      this.c = paramString;
    }
    
    a a(URL paramURL)
    {
      return new a(paramURL, this.b, this.c);
    }
  }
  
  static final class b
  {
    final int a;
    @Nullable
    final URL b;
    final long c;
    
    b(int paramInt, @Nullable URL paramURL, long paramLong)
    {
      this.a = paramInt;
      this.b = paramURL;
      this.c = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */