package b.d.b.d.a;

import androidx.annotation.RequiresApi;
import java.net.Socket;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

public class a
{
  private static X509TrustManager b(TrustManager[] paramArrayOfTrustManager)
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
  
  /* Error */
  public static c c(java.util.List<String> paramList)
  {
    // Byte code:
    //   0: new 12	b/d/b/d/a/a$c
    //   3: dup
    //   4: invokespecial 28	b/d/b/d/a/a$c:<init>	()V
    //   7: astore_1
    //   8: ldc 30
    //   10: invokestatic 36	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   13: astore_2
    //   14: invokestatic 42	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   17: invokestatic 45	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   20: astore_3
    //   21: aload_3
    //   22: aconst_null
    //   23: invokevirtual 49	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   26: aconst_null
    //   27: astore 4
    //   29: iconst_0
    //   30: istore 5
    //   32: aload 4
    //   34: astore 6
    //   36: aload 4
    //   38: astore 7
    //   40: iload 5
    //   42: aload_0
    //   43: invokeinterface 55 1 0
    //   48: if_icmpge +157 -> 205
    //   51: aload 4
    //   53: astore 6
    //   55: aload 4
    //   57: astore 7
    //   59: new 57	okio/Buffer
    //   62: astore 8
    //   64: aload 4
    //   66: astore 6
    //   68: aload 4
    //   70: astore 7
    //   72: aload 8
    //   74: invokespecial 58	okio/Buffer:<init>	()V
    //   77: aload 4
    //   79: astore 6
    //   81: aload 4
    //   83: astore 7
    //   85: aload 8
    //   87: aload_0
    //   88: iload 5
    //   90: invokeinterface 62 2 0
    //   95: checkcast 64	java/lang/String
    //   98: invokevirtual 68	okio/Buffer:writeUtf8	(Ljava/lang/String;)Lokio/Buffer;
    //   101: invokevirtual 72	okio/Buffer:inputStream	()Ljava/io/InputStream;
    //   104: astore 4
    //   106: aload 4
    //   108: astore 6
    //   110: aload 4
    //   112: astore 7
    //   114: aload_2
    //   115: aload 4
    //   117: invokevirtual 76	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   120: astore 8
    //   122: aload 4
    //   124: astore 6
    //   126: aload 4
    //   128: astore 7
    //   130: new 78	java/lang/StringBuilder
    //   133: astore 9
    //   135: aload 4
    //   137: astore 6
    //   139: aload 4
    //   141: astore 7
    //   143: aload 9
    //   145: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   148: aload 4
    //   150: astore 6
    //   152: aload 4
    //   154: astore 7
    //   156: aload 9
    //   158: ldc 81
    //   160: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 4
    //   166: astore 6
    //   168: aload 4
    //   170: astore 7
    //   172: aload 9
    //   174: iload 5
    //   176: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 4
    //   182: astore 6
    //   184: aload 4
    //   186: astore 7
    //   188: aload_3
    //   189: aload 9
    //   191: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aload 8
    //   196: invokevirtual 95	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   199: iinc 5 1
    //   202: goto -170 -> 32
    //   205: aload 4
    //   207: astore 6
    //   209: aload 4
    //   211: astore 7
    //   213: invokestatic 100	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   216: invokestatic 103	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   219: astore_0
    //   220: aload 4
    //   222: astore 6
    //   224: aload 4
    //   226: astore 7
    //   228: aload_0
    //   229: aload_3
    //   230: invokevirtual 107	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   233: aload 4
    //   235: astore 6
    //   237: aload 4
    //   239: astore 7
    //   241: aload_0
    //   242: invokevirtual 111	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   245: astore_0
    //   246: aload 4
    //   248: astore 6
    //   250: aload 4
    //   252: astore 7
    //   254: ldc 113
    //   256: invokestatic 118	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   259: astore_3
    //   260: aload 4
    //   262: astore 6
    //   264: aload 4
    //   266: astore 7
    //   268: aload_0
    //   269: invokestatic 16	b/d/b/d/a/a:b	([Ljavax/net/ssl/TrustManager;)Ljavax/net/ssl/X509TrustManager;
    //   272: astore_2
    //   273: aload 4
    //   275: astore 6
    //   277: aload 4
    //   279: astore 7
    //   281: getstatic 124	android/os/Build$VERSION:SDK_INT	I
    //   284: bipush 24
    //   286: if_icmplt +31 -> 317
    //   289: aload 4
    //   291: astore 6
    //   293: aload 4
    //   295: astore 7
    //   297: new 6	b/d/b/d/a/a$a
    //   300: astore_0
    //   301: aload 4
    //   303: astore 6
    //   305: aload 4
    //   307: astore 7
    //   309: aload_0
    //   310: aload_2
    //   311: invokespecial 127	b/d/b/d/a/a$a:<init>	(Ljavax/net/ssl/X509TrustManager;)V
    //   314: goto +20 -> 334
    //   317: aload 4
    //   319: astore 6
    //   321: aload 4
    //   323: astore 7
    //   325: new 9	b/d/b/d/a/a$b
    //   328: dup
    //   329: aload_2
    //   330: invokespecial 128	b/d/b/d/a/a$b:<init>	(Ljavax/net/ssl/X509TrustManager;)V
    //   333: astore_0
    //   334: aload 4
    //   336: astore 6
    //   338: aload 4
    //   340: astore 7
    //   342: aload_3
    //   343: aconst_null
    //   344: iconst_1
    //   345: anewarray 130	javax/net/ssl/TrustManager
    //   348: dup
    //   349: iconst_0
    //   350: aload_0
    //   351: aastore
    //   352: aconst_null
    //   353: invokevirtual 133	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   356: aload 4
    //   358: astore 6
    //   360: aload 4
    //   362: astore 7
    //   364: new 135	b/d/b/d/a/f
    //   367: astore_2
    //   368: aload 4
    //   370: astore 6
    //   372: aload 4
    //   374: astore 7
    //   376: aload_2
    //   377: aload_3
    //   378: invokevirtual 139	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   381: invokespecial 142	b/d/b/d/a/f:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   384: aload 4
    //   386: astore 6
    //   388: aload 4
    //   390: astore 7
    //   392: aload_1
    //   393: aload_2
    //   394: invokestatic 145	b/d/b/d/a/a$c:a	(Lb/d/b/d/a/a$c;Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/SSLSocketFactory;
    //   397: pop
    //   398: aload 4
    //   400: astore 6
    //   402: aload 4
    //   404: astore 7
    //   406: aload_1
    //   407: aload_0
    //   408: invokestatic 148	b/d/b/d/a/a$c:b	(Lb/d/b/d/a/a$c;Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/X509TrustManager;
    //   411: pop
    //   412: aload 4
    //   414: ifnull +75 -> 489
    //   417: aload 4
    //   419: invokevirtual 153	java/io/InputStream:close	()V
    //   422: goto +67 -> 489
    //   425: astore_0
    //   426: aload_0
    //   427: aconst_null
    //   428: iconst_0
    //   429: anewarray 4	java/lang/Object
    //   432: invokestatic 159	b/d/w/c/a:g	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   435: goto +54 -> 489
    //   438: astore_0
    //   439: goto +14 -> 453
    //   442: astore_0
    //   443: aconst_null
    //   444: astore 7
    //   446: goto +46 -> 492
    //   449: astore_0
    //   450: aconst_null
    //   451: astore 6
    //   453: aload 6
    //   455: astore 7
    //   457: aload_0
    //   458: aconst_null
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokestatic 159	b/d/w/c/a:g	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload 6
    //   468: ifnull +21 -> 489
    //   471: aload 6
    //   473: invokevirtual 153	java/io/InputStream:close	()V
    //   476: goto +13 -> 489
    //   479: astore_0
    //   480: aload_0
    //   481: aconst_null
    //   482: iconst_0
    //   483: anewarray 4	java/lang/Object
    //   486: invokestatic 159	b/d/w/c/a:g	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: aload_1
    //   490: areturn
    //   491: astore_0
    //   492: aload 7
    //   494: ifnull +23 -> 517
    //   497: aload 7
    //   499: invokevirtual 153	java/io/InputStream:close	()V
    //   502: goto +15 -> 517
    //   505: astore 7
    //   507: aload 7
    //   509: aconst_null
    //   510: iconst_0
    //   511: anewarray 4	java/lang/Object
    //   514: invokestatic 159	b/d/w/c/a:g	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   517: aload_0
    //   518: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	paramList	java.util.List<String>
    //   7	483	1	localc	c
    //   13	381	2	localObject1	Object
    //   20	358	3	localObject2	Object
    //   27	391	4	localInputStream1	java.io.InputStream
    //   30	170	5	i	int
    //   34	438	6	localInputStream2	java.io.InputStream
    //   38	460	7	localInputStream3	java.io.InputStream
    //   505	3	7	localIOException	java.io.IOException
    //   62	133	8	localObject3	Object
    //   133	57	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   417	422	425	java/io/IOException
    //   40	51	438	java/lang/Exception
    //   59	64	438	java/lang/Exception
    //   72	77	438	java/lang/Exception
    //   85	106	438	java/lang/Exception
    //   114	122	438	java/lang/Exception
    //   130	135	438	java/lang/Exception
    //   143	148	438	java/lang/Exception
    //   156	164	438	java/lang/Exception
    //   172	180	438	java/lang/Exception
    //   188	199	438	java/lang/Exception
    //   213	220	438	java/lang/Exception
    //   228	233	438	java/lang/Exception
    //   241	246	438	java/lang/Exception
    //   254	260	438	java/lang/Exception
    //   268	273	438	java/lang/Exception
    //   281	289	438	java/lang/Exception
    //   297	301	438	java/lang/Exception
    //   309	314	438	java/lang/Exception
    //   325	334	438	java/lang/Exception
    //   342	356	438	java/lang/Exception
    //   364	368	438	java/lang/Exception
    //   376	384	438	java/lang/Exception
    //   392	398	438	java/lang/Exception
    //   406	412	438	java/lang/Exception
    //   8	26	442	finally
    //   8	26	449	java/lang/Exception
    //   471	476	479	java/io/IOException
    //   40	51	491	finally
    //   59	64	491	finally
    //   72	77	491	finally
    //   85	106	491	finally
    //   114	122	491	finally
    //   130	135	491	finally
    //   143	148	491	finally
    //   156	164	491	finally
    //   172	180	491	finally
    //   188	199	491	finally
    //   213	220	491	finally
    //   228	233	491	finally
    //   241	246	491	finally
    //   254	260	491	finally
    //   268	273	491	finally
    //   281	289	491	finally
    //   297	301	491	finally
    //   309	314	491	finally
    //   325	334	491	finally
    //   342	356	491	finally
    //   364	368	491	finally
    //   376	384	491	finally
    //   392	398	491	finally
    //   406	412	491	finally
    //   457	466	491	finally
    //   497	502	505	java/io/IOException
  }
  
  @RequiresApi(api=24)
  public static class a
    extends X509ExtendedTrustManager
  {
    private final X509TrustManager a;
    private final X509TrustManager b;
    
    public a(X509TrustManager paramX509TrustManager)
      throws NoSuchAlgorithmException, KeyStoreException
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init(null);
      this.a = a.a(localTrustManagerFactory.getTrustManagers());
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
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, Socket paramSocket)
      throws CertificateException
    {
      try
      {
        X509TrustManager localX509TrustManager1 = this.a;
        if ((localX509TrustManager1 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager1).checkClientTrusted(paramArrayOfX509Certificate, paramString, paramSocket);
        } else {
          localX509TrustManager1.checkClientTrusted(paramArrayOfX509Certificate, paramString);
        }
      }
      catch (CertificateException localCertificateException)
      {
        X509TrustManager localX509TrustManager2 = this.b;
        if ((localX509TrustManager2 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager2).checkClientTrusted(paramArrayOfX509Certificate, paramString, paramSocket);
        } else {
          localX509TrustManager2.checkClientTrusted(paramArrayOfX509Certificate, paramString);
        }
      }
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, SSLEngine paramSSLEngine)
      throws CertificateException
    {
      try
      {
        X509TrustManager localX509TrustManager1 = this.a;
        if ((localX509TrustManager1 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager1).checkClientTrusted(paramArrayOfX509Certificate, paramString, paramSSLEngine);
        } else {
          localX509TrustManager1.checkClientTrusted(paramArrayOfX509Certificate, paramString);
        }
      }
      catch (CertificateException localCertificateException)
      {
        X509TrustManager localX509TrustManager2 = this.b;
        if ((localX509TrustManager2 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager2).checkClientTrusted(paramArrayOfX509Certificate, paramString, paramSSLEngine);
        } else {
          localX509TrustManager2.checkClientTrusted(paramArrayOfX509Certificate, paramString);
        }
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
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, Socket paramSocket)
      throws CertificateException
    {
      try
      {
        X509TrustManager localX509TrustManager1 = this.a;
        if ((localX509TrustManager1 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager1).checkServerTrusted(paramArrayOfX509Certificate, paramString, paramSocket);
        } else {
          localX509TrustManager1.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        }
      }
      catch (CertificateException localCertificateException)
      {
        X509TrustManager localX509TrustManager2 = this.b;
        if ((localX509TrustManager2 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager2).checkServerTrusted(paramArrayOfX509Certificate, paramString, paramSocket);
        } else {
          localX509TrustManager2.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        }
      }
    }
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, SSLEngine paramSSLEngine)
      throws CertificateException
    {
      try
      {
        X509TrustManager localX509TrustManager1 = this.a;
        if ((localX509TrustManager1 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager1).checkServerTrusted(paramArrayOfX509Certificate, paramString, paramSSLEngine);
        } else {
          localX509TrustManager1.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        }
      }
      catch (CertificateException localCertificateException)
      {
        X509TrustManager localX509TrustManager2 = this.b;
        if ((localX509TrustManager2 instanceof X509ExtendedTrustManager)) {
          ((X509ExtendedTrustManager)localX509TrustManager2).checkServerTrusted(paramArrayOfX509Certificate, paramString, paramSSLEngine);
        } else {
          localX509TrustManager2.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        }
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
  
  public static class b
    implements X509TrustManager
  {
    private final X509TrustManager a;
    private final X509TrustManager b;
    
    public b(X509TrustManager paramX509TrustManager)
      throws NoSuchAlgorithmException, KeyStoreException
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init(null);
      this.a = a.a(localTrustManagerFactory.getTrustManagers());
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
  
  public static class c
  {
    private SSLSocketFactory a;
    private X509TrustManager b;
    
    public SSLSocketFactory c()
    {
      return this.a;
    }
    
    public X509TrustManager d()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */