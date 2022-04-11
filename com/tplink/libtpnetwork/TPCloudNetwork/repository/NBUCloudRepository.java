package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import b.d.b.d.a.c;
import b.d.b.d.a.c.a;
import b.d.b.d.a.d;
import com.tplink.cloud.context.b;
import com.tplink.libtpnetwork.TPCloudNetwork.nbu.AdvertResult;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.internal.tls.OkHostnameVerifier;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;
import retrofit2.r.b;
import retrofit2.x.f;
import retrofit2.x.s;
import retrofit2.x.t;

public class NBUCloudRepository
  extends b.d.b.f.a
  implements c.a
{
  private static f c;
  private e d = (e)d.b(this).a("https://api-homecare-transition.i.tplinknbu.com").b(e.class);
  private MutableLiveData<String> e = new MutableLiveData();
  
  public NBUCloudRepository(b paramb)
  {
    super(paramb);
  }
  
  private void e(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    String str = Integer.toString(paramInt2);
    for (paramInt2 = 0; paramInt2 < paramInt1 - str.length(); paramInt2++) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(str);
  }
  
  private static X509TrustManager f(TrustManager[] paramArrayOfTrustManager)
  {
    int i = paramArrayOfTrustManager.length;
    for (int j = 0; j < i; j++)
    {
      TrustManager localTrustManager = paramArrayOfTrustManager[j];
      if ((localTrustManager instanceof X509TrustManager)) {
        return (X509TrustManager)localTrustManager;
      }
    }
    return null;
  }
  
  private String h()
  {
    Object localObject = TimeZone.getDefault();
    int i = (((TimeZone)localObject).getRawOffset() + ((TimeZone)localObject).getDSTSavings()) / 60000;
    char c1;
    char c2;
    if (i < 0)
    {
      c1 = '-';
      i = -i;
      c2 = c1;
    }
    else
    {
      c1 = '+';
      c2 = c1;
    }
    localObject = new StringBuilder(9);
    ((StringBuilder)localObject).append("GMT");
    ((StringBuilder)localObject).append(c2);
    e((StringBuilder)localObject, 2, i / 60);
    ((StringBuilder)localObject).append(':');
    e((StringBuilder)localObject, 2, i % 60);
    return ((StringBuilder)localObject).toString();
  }
  
  /* Error */
  public static void i(@NonNull android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 20	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f
    //   3: dup
    //   4: invokespecial 118	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f:<init>	()V
    //   7: putstatic 120	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository:c	Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f;
    //   10: aconst_null
    //   11: astore_1
    //   12: aconst_null
    //   13: astore_2
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: invokestatic 125	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   22: invokestatic 129	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   25: astore 5
    //   27: aload 5
    //   29: aconst_null
    //   30: invokevirtual 133	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   33: ldc -121
    //   35: invokestatic 140	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   38: astore 6
    //   40: new 142	okio/Buffer
    //   43: astore 7
    //   45: aload 7
    //   47: invokespecial 143	okio/Buffer:<init>	()V
    //   50: aload 7
    //   52: ldc -111
    //   54: invokevirtual 149	okio/Buffer:writeUtf8	(Ljava/lang/String;)Lokio/Buffer;
    //   57: invokevirtual 153	okio/Buffer:inputStream	()Ljava/io/InputStream;
    //   60: astore 8
    //   62: aload 4
    //   64: astore_2
    //   65: aload_1
    //   66: astore 7
    //   68: aload 5
    //   70: ldc -101
    //   72: aload 6
    //   74: aload 8
    //   76: invokevirtual 159	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   79: invokevirtual 163	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   82: aload 4
    //   84: astore_2
    //   85: aload_1
    //   86: astore 7
    //   88: invokestatic 168	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   91: invokestatic 171	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   94: astore_3
    //   95: aload 4
    //   97: astore_2
    //   98: aload_1
    //   99: astore 7
    //   101: aload_3
    //   102: aload 5
    //   104: invokevirtual 175	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   107: aload 4
    //   109: astore_2
    //   110: aload_1
    //   111: astore 7
    //   113: aload_3
    //   114: invokevirtual 179	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   117: astore 6
    //   119: aload 4
    //   121: astore_2
    //   122: aload_1
    //   123: astore 7
    //   125: ldc -75
    //   127: invokestatic 186	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   130: astore 5
    //   132: aload 4
    //   134: astore_2
    //   135: aload_1
    //   136: astore 7
    //   138: new 14	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$d
    //   141: astore_3
    //   142: aload 4
    //   144: astore_2
    //   145: aload_1
    //   146: astore 7
    //   148: aload_3
    //   149: aload 6
    //   151: invokestatic 62	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository:f	([Ljavax/net/ssl/TrustManager;)Ljavax/net/ssl/X509TrustManager;
    //   154: invokespecial 189	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$d:<init>	(Ljavax/net/ssl/X509TrustManager;)V
    //   157: aload 4
    //   159: astore_2
    //   160: aload_1
    //   161: astore 7
    //   163: aload_0
    //   164: invokevirtual 195	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   167: ldc -59
    //   169: invokevirtual 203	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   172: astore_0
    //   173: aload_0
    //   174: astore_2
    //   175: aload_0
    //   176: astore 7
    //   178: ldc -51
    //   180: invokestatic 129	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   183: astore_1
    //   184: aload_0
    //   185: astore_2
    //   186: aload_0
    //   187: astore 7
    //   189: aload_1
    //   190: aload_0
    //   191: ldc -49
    //   193: invokevirtual 211	java/lang/String:toCharArray	()[C
    //   196: invokevirtual 214	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   199: aload_0
    //   200: astore_2
    //   201: aload_0
    //   202: astore 7
    //   204: invokestatic 217	javax/net/ssl/KeyManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   207: invokestatic 220	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   210: astore 4
    //   212: aload_0
    //   213: astore_2
    //   214: aload_0
    //   215: astore 7
    //   217: aload 4
    //   219: aload_1
    //   220: ldc -49
    //   222: invokevirtual 211	java/lang/String:toCharArray	()[C
    //   225: invokevirtual 223	javax/net/ssl/KeyManagerFactory:init	(Ljava/security/KeyStore;[C)V
    //   228: aload_0
    //   229: astore_2
    //   230: aload_0
    //   231: astore 7
    //   233: aload 4
    //   235: invokevirtual 227	javax/net/ssl/KeyManagerFactory:getKeyManagers	()[Ljavax/net/ssl/KeyManager;
    //   238: astore 4
    //   240: aload_0
    //   241: astore_2
    //   242: aload_0
    //   243: astore 7
    //   245: new 229	java/security/SecureRandom
    //   248: astore_1
    //   249: aload_0
    //   250: astore_2
    //   251: aload_0
    //   252: astore 7
    //   254: aload_1
    //   255: invokespecial 230	java/security/SecureRandom:<init>	()V
    //   258: aload_0
    //   259: astore_2
    //   260: aload_0
    //   261: astore 7
    //   263: aload 5
    //   265: aload 4
    //   267: iconst_1
    //   268: anewarray 232	javax/net/ssl/TrustManager
    //   271: dup
    //   272: iconst_0
    //   273: aload_3
    //   274: aastore
    //   275: aload_1
    //   276: invokevirtual 235	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   279: aload_0
    //   280: astore_2
    //   281: aload_0
    //   282: astore 7
    //   284: getstatic 120	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository:c	Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f;
    //   287: astore_1
    //   288: aload_0
    //   289: astore_2
    //   290: aload_0
    //   291: astore 7
    //   293: new 237	b/d/b/d/a/f
    //   296: astore 4
    //   298: aload_0
    //   299: astore_2
    //   300: aload_0
    //   301: astore 7
    //   303: aload 4
    //   305: aload 5
    //   307: invokevirtual 241	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   310: invokespecial 244	b/d/b/d/a/f:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   313: aload_0
    //   314: astore_2
    //   315: aload_0
    //   316: astore 7
    //   318: aload_1
    //   319: aload 4
    //   321: invokestatic 247	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f:a	(Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f;Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/SSLSocketFactory;
    //   324: pop
    //   325: aload_0
    //   326: astore_2
    //   327: aload_0
    //   328: astore 7
    //   330: getstatic 120	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository:c	Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f;
    //   333: aload_3
    //   334: invokestatic 250	com/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f:b	(Lcom/tplink/libtpnetwork/TPCloudNetwork/repository/NBUCloudRepository$f;Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/X509TrustManager;
    //   337: pop
    //   338: aload 8
    //   340: ifnull +16 -> 356
    //   343: aload 8
    //   345: invokevirtual 255	java/io/InputStream:close	()V
    //   348: goto +8 -> 356
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   356: aload_0
    //   357: ifnull +81 -> 438
    //   360: aload_0
    //   361: invokevirtual 255	java/io/InputStream:close	()V
    //   364: goto +74 -> 438
    //   367: astore 7
    //   369: aload_2
    //   370: astore_0
    //   371: aload 8
    //   373: astore_2
    //   374: goto +67 -> 441
    //   377: astore 4
    //   379: aload 7
    //   381: astore_0
    //   382: aload 8
    //   384: astore_2
    //   385: goto +16 -> 401
    //   388: astore 7
    //   390: aconst_null
    //   391: astore_0
    //   392: aload_3
    //   393: astore_2
    //   394: goto +47 -> 441
    //   397: astore 4
    //   399: aconst_null
    //   400: astore_0
    //   401: aload 4
    //   403: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   406: aload_2
    //   407: ifnull +15 -> 422
    //   410: aload_2
    //   411: invokevirtual 255	java/io/InputStream:close	()V
    //   414: goto +8 -> 422
    //   417: astore_2
    //   418: aload_2
    //   419: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   422: aload_0
    //   423: ifnull +15 -> 438
    //   426: aload_0
    //   427: invokevirtual 255	java/io/InputStream:close	()V
    //   430: goto +8 -> 438
    //   433: astore_0
    //   434: aload_0
    //   435: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   438: return
    //   439: astore 7
    //   441: aload_2
    //   442: ifnull +15 -> 457
    //   445: aload_2
    //   446: invokevirtual 255	java/io/InputStream:close	()V
    //   449: goto +8 -> 457
    //   452: astore_2
    //   453: aload_2
    //   454: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   457: aload_0
    //   458: ifnull +15 -> 473
    //   461: aload_0
    //   462: invokevirtual 255	java/io/InputStream:close	()V
    //   465: goto +8 -> 473
    //   468: astore_0
    //   469: aload_0
    //   470: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   473: aload 7
    //   475: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	paramContext	android.content.Context
    //   11	308	1	localObject1	Object
    //   13	314	2	localObject2	Object
    //   351	19	2	localIOException1	IOException
    //   373	38	2	localObject3	Object
    //   417	29	2	localIOException2	IOException
    //   452	2	2	localIOException3	IOException
    //   15	378	3	localObject4	Object
    //   17	303	4	localObject5	Object
    //   377	1	4	localException1	Exception
    //   397	5	4	localException2	Exception
    //   25	281	5	localObject6	Object
    //   38	112	6	localObject7	Object
    //   43	286	7	localObject8	Object
    //   367	13	7	localObject9	Object
    //   388	1	7	localObject10	Object
    //   439	35	7	localObject11	Object
    //   60	323	8	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   343	348	351	java/io/IOException
    //   68	82	367	finally
    //   88	95	367	finally
    //   101	107	367	finally
    //   113	119	367	finally
    //   125	132	367	finally
    //   138	142	367	finally
    //   148	157	367	finally
    //   163	173	367	finally
    //   178	184	367	finally
    //   189	199	367	finally
    //   204	212	367	finally
    //   217	228	367	finally
    //   233	240	367	finally
    //   245	249	367	finally
    //   254	258	367	finally
    //   263	279	367	finally
    //   284	288	367	finally
    //   293	298	367	finally
    //   303	313	367	finally
    //   318	325	367	finally
    //   330	338	367	finally
    //   68	82	377	java/lang/Exception
    //   88	95	377	java/lang/Exception
    //   101	107	377	java/lang/Exception
    //   113	119	377	java/lang/Exception
    //   125	132	377	java/lang/Exception
    //   138	142	377	java/lang/Exception
    //   148	157	377	java/lang/Exception
    //   163	173	377	java/lang/Exception
    //   178	184	377	java/lang/Exception
    //   189	199	377	java/lang/Exception
    //   204	212	377	java/lang/Exception
    //   217	228	377	java/lang/Exception
    //   233	240	377	java/lang/Exception
    //   245	249	377	java/lang/Exception
    //   254	258	377	java/lang/Exception
    //   263	279	377	java/lang/Exception
    //   284	288	377	java/lang/Exception
    //   293	298	377	java/lang/Exception
    //   303	313	377	java/lang/Exception
    //   318	325	377	java/lang/Exception
    //   330	338	377	java/lang/Exception
    //   19	62	388	finally
    //   19	62	397	java/lang/Exception
    //   410	414	417	java/io/IOException
    //   360	364	433	java/io/IOException
    //   426	430	433	java/io/IOException
    //   401	406	439	finally
    //   445	449	452	java/io/IOException
    //   461	465	468	java/io/IOException
  }
  
  public r c()
  {
    Object localObject1 = new OkHttpClient.Builder();
    Object localObject2 = TimeUnit.SECONDS;
    localObject2 = ((OkHttpClient.Builder)localObject1).connectTimeout(30L, (TimeUnit)localObject2).readTimeout(30L, (TimeUnit)localObject2).writeTimeout(30L, (TimeUnit)localObject2);
    localObject1 = c;
    if ((localObject1 != null) && (((f)localObject1).c() != null) && (c.d() != null)) {
      ((OkHttpClient.Builder)localObject2).sslSocketFactory(c.c(), c.d());
    }
    ((OkHttpClient.Builder)localObject2).hostnameVerifier(new a());
    ((OkHttpClient.Builder)localObject2).addInterceptor(new b());
    return new r.b().c("https://api-in-app-marketing-auth.i.tplinknbu.com").g(((OkHttpClient.Builder)localObject2).build()).b(retrofit2.w.a.a.f()).a(g.d()).e();
  }
  
  public q<String> g(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    return this.d.a("https://api-in-app-marketing-auth.i.tplinknbu.com", paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, h()).g0(new c()).L0(io.reactivex.l0.a.c());
  }
  
  class a
    implements HostnameVerifier
  {
    a() {}
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      if ((paramString.equals(paramSSLSession.getPeerHost())) && (paramString.endsWith("tplinknbu.com"))) {
        return true;
      }
      if (HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession)) {
        return true;
      }
      return OkHostnameVerifier.INSTANCE.verify(paramString, paramSSLSession);
    }
  }
  
  class b
    implements Interceptor
  {
    b() {}
    
    @NonNull
    public Response intercept(@NonNull Interceptor.Chain paramChain)
      throws IOException
    {
      Request localRequest = paramChain.request();
      Request.Builder localBuilder = localRequest.newBuilder();
      if (localRequest.header("Content-Type") == null) {
        localBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
      }
      return paramChain.proceed(localBuilder.build());
    }
  }
  
  class c
    implements j<AdvertResult, String>
  {
    c() {}
    
    public String a(AdvertResult paramAdvertResult)
      throws Exception
    {
      return paramAdvertResult.getAdvertUrl();
    }
  }
  
  private static class d
    implements X509TrustManager
  {
    private X509TrustManager a;
    private X509TrustManager b;
    
    d(X509TrustManager paramX509TrustManager)
      throws NoSuchAlgorithmException, KeyStoreException
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init(null);
      this.a = NBUCloudRepository.d(localTrustManagerFactory.getTrustManagers());
      this.b = paramX509TrustManager;
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      try
      {
        this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      }
      catch (CertificateException localCertificateException)
      {
        this.b.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      try
      {
        this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      }
      catch (CertificateException localCertificateException)
      {
        this.b.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
  
  static abstract interface e
  {
    @f("{url}/service/url")
    public abstract q<AdvertResult> a(@s(encoded=true, value="url") String paramString1, @t("accountId") String paramString2, @t("clientId") String paramString3, @t("appType") String paramString4, @t("country") String paramString5, @t("sourceFlag") int paramInt1, @t("timestamp") int paramInt2, @t("timezone") String paramString6);
  }
  
  static class f
  {
    private SSLSocketFactory a;
    private X509TrustManager b;
    
    SSLSocketFactory c()
    {
      return this.a;
    }
    
    X509TrustManager d()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\NBUCloudRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */