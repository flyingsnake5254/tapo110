package com.tplink.libtputility.security;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Base64;
import androidx.annotation.NonNull;
import b.d.w.c.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;

public class b
{
  private static volatile b a;
  private static a b;
  private KeyStore c;
  
  private b()
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      this.c = localKeyStore;
      localKeyStore.load(null);
    }
    catch (IOException localIOException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}catch (CertificateException localCertificateException) {}catch (KeyStoreException localKeyStoreException) {}
    a.f("AndroidKeyStoreDelegate", localKeyStoreException, "AndroidKeyStoreDelegate", new Object[0]);
  }
  
  public static b c()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          b localb = new com/tplink/libtputility/security/b;
          localb.<init>();
          a = localb;
        }
      }
      finally {}
    }
    return a;
  }
  
  private KeyStore.PrivateKeyEntry d(@NonNull String paramString)
  {
    try
    {
      this.c.load(null);
      Object localObject = this.c.getEntry(paramString, null);
      if (localObject == null)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("No key found under alias: ");
        ((StringBuilder)localObject).append(paramString);
        a.n("AndroidKeyStoreDelegate", ((StringBuilder)localObject).toString());
        return null;
      }
      if (!(localObject instanceof KeyStore.PrivateKeyEntry))
      {
        a.n("AndroidKeyStoreDelegate", "Not an instance of a PrivateKeyEntry");
        return null;
      }
      paramString = (KeyStore.PrivateKeyEntry)localObject;
      return paramString;
    }
    catch (NullPointerException paramString) {}catch (IOException paramString) {}catch (CertificateException paramString) {}catch (KeyStoreException paramString) {}catch (UnrecoverableEntryException paramString) {}catch (NoSuchAlgorithmException paramString) {}
    a.f("AndroidKeyStoreDelegate", paramString, "getPrivateKey", new Object[0]);
    return null;
  }
  
  private void g(Context paramContext)
  {
    h(paramContext, Locale.ENGLISH);
  }
  
  private void h(Context paramContext, Locale paramLocale)
  {
    Locale.setDefault(paramLocale);
    paramContext = paramContext.getResources();
    Configuration localConfiguration = paramContext.getConfiguration();
    localConfiguration.locale = paramLocale;
    paramContext.updateConfiguration(localConfiguration, paramContext.getDisplayMetrics());
  }
  
  public String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    boolean bool = paramString1.isEmpty();
    String str = "";
    Object localObject = str;
    if (!bool)
    {
      localObject = str;
      if (!paramString2.isEmpty())
      {
        paramString2 = d(paramString2);
        if (paramString2 == null) {
          return "";
        }
        try
        {
          localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding");
          ((Cipher)localObject).init(2, paramString2.getPrivateKey());
          paramString2 = new javax/crypto/CipherInputStream;
          ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
          localByteArrayInputStream.<init>(Base64.decode(paramString1, 0));
          paramString2.<init>(localByteArrayInputStream, (Cipher)localObject);
          paramString1 = new java/util/ArrayList;
          paramString1.<init>();
          for (;;)
          {
            i = paramString2.read();
            if (i == -1) {
              break;
            }
            paramString1.add(Byte.valueOf((byte)i));
          }
          int j = paramString1.size();
          paramString2 = new byte[j];
          for (int i = 0; i < j; i++) {
            paramString2[i] = ((Byte)paramString1.get(i)).byteValue();
          }
          localObject = new String(paramString2, 0, j, "UTF-8");
        }
        catch (NoSuchPaddingException paramString1) {}catch (InvalidKeyException paramString1) {}catch (NoSuchAlgorithmException paramString1) {}catch (IOException paramString1) {}
        a.f("AndroidKeyStoreDelegate", paramString1, "decryptString", new Object[0]);
        localObject = str;
      }
    }
    return (String)localObject;
  }
  
  public String b(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((!paramString1.isEmpty()) && (!paramString2.isEmpty()))
    {
      Object localObject1 = null;
      Object localObject2 = d(paramString2);
      if (localObject2 == null) {
        return "";
      }
      try
      {
        paramString2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        paramString2.init(1, ((KeyStore.PrivateKeyEntry)localObject2).getCertificate().getPublicKey());
        ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
        localByteArrayOutputStream.<init>();
        localObject2 = new javax/crypto/CipherOutputStream;
        ((CipherOutputStream)localObject2).<init>(localByteArrayOutputStream, paramString2);
        ((CipherOutputStream)localObject2).write(paramString1.getBytes("UTF-8"));
        ((CipherOutputStream)localObject2).close();
        paramString1 = localByteArrayOutputStream.toByteArray();
      }
      catch (NoSuchPaddingException paramString1) {}catch (InvalidKeyException paramString1) {}catch (NoSuchAlgorithmException paramString1) {}catch (IOException paramString1) {}
      a.f("AndroidKeyStoreDelegate", paramString1, "encryptString", new Object[0]);
      paramString1 = (String)localObject1;
      return Base64.encodeToString(paramString1, 0);
    }
    return "";
  }
  
  /* Error */
  public void e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 139	java/lang/String:isEmpty	()Z
    //   4: ifne +820 -> 824
    //   7: aload_0
    //   8: aload_2
    //   9: invokevirtual 259	com/tplink/libtputility/security/b:f	(Ljava/lang/String;)Z
    //   12: ifne +812 -> 824
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore 6
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 8
    //   32: invokestatic 263	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   35: astore 9
    //   37: aload 9
    //   39: astore 8
    //   41: aload 9
    //   43: astore_3
    //   44: aload 9
    //   46: astore 4
    //   48: aload 9
    //   50: astore 5
    //   52: aload 9
    //   54: astore 6
    //   56: aload 9
    //   58: astore 7
    //   60: aload_0
    //   61: aload_1
    //   62: invokespecial 265	com/tplink/libtputility/security/b:g	(Landroid/content/Context;)V
    //   65: aload 9
    //   67: astore 8
    //   69: aload 9
    //   71: astore_3
    //   72: aload 9
    //   74: astore 4
    //   76: aload 9
    //   78: astore 5
    //   80: aload 9
    //   82: astore 6
    //   84: aload 9
    //   86: astore 7
    //   88: invokestatic 263	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   91: invokestatic 270	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   94: astore 10
    //   96: aload 9
    //   98: astore 8
    //   100: aload 9
    //   102: astore_3
    //   103: aload 9
    //   105: astore 4
    //   107: aload 9
    //   109: astore 5
    //   111: aload 9
    //   113: astore 6
    //   115: aload 9
    //   117: astore 7
    //   119: invokestatic 263	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   122: invokestatic 270	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   125: astore 11
    //   127: aload 9
    //   129: astore 8
    //   131: aload 9
    //   133: astore_3
    //   134: aload 9
    //   136: astore 4
    //   138: aload 9
    //   140: astore 5
    //   142: aload 9
    //   144: astore 6
    //   146: aload 9
    //   148: astore 7
    //   150: aload 11
    //   152: iconst_1
    //   153: bipush 100
    //   155: invokevirtual 273	java/util/Calendar:add	(II)V
    //   158: aload 9
    //   160: astore 8
    //   162: aload 9
    //   164: astore_3
    //   165: aload 9
    //   167: astore 4
    //   169: aload 9
    //   171: astore 5
    //   173: aload 9
    //   175: astore 6
    //   177: aload 9
    //   179: astore 7
    //   181: getstatic 279	android/os/Build$VERSION:SDK_INT	I
    //   184: istore 12
    //   186: iload 12
    //   188: bipush 23
    //   190: if_icmpge +209 -> 399
    //   193: aload 9
    //   195: astore 8
    //   197: aload 9
    //   199: astore_3
    //   200: aload 9
    //   202: astore 4
    //   204: aload 9
    //   206: astore 5
    //   208: aload 9
    //   210: astore 6
    //   212: aload 9
    //   214: astore 7
    //   216: new 281	android/security/KeyPairGeneratorSpec$Builder
    //   219: astore 13
    //   221: aload 9
    //   223: astore 8
    //   225: aload 9
    //   227: astore_3
    //   228: aload 9
    //   230: astore 4
    //   232: aload 9
    //   234: astore 5
    //   236: aload 9
    //   238: astore 6
    //   240: aload 9
    //   242: astore 7
    //   244: aload 13
    //   246: aload_1
    //   247: invokevirtual 285	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   250: invokespecial 287	android/security/KeyPairGeneratorSpec$Builder:<init>	(Landroid/content/Context;)V
    //   253: aload 9
    //   255: astore 8
    //   257: aload 9
    //   259: astore_3
    //   260: aload 9
    //   262: astore 4
    //   264: aload 9
    //   266: astore 5
    //   268: aload 9
    //   270: astore 6
    //   272: aload 9
    //   274: astore 7
    //   276: aload 13
    //   278: aload_2
    //   279: invokevirtual 291	android/security/KeyPairGeneratorSpec$Builder:setAlias	(Ljava/lang/String;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   282: astore 13
    //   284: aload 9
    //   286: astore 8
    //   288: aload 9
    //   290: astore_3
    //   291: aload 9
    //   293: astore 4
    //   295: aload 9
    //   297: astore 5
    //   299: aload 9
    //   301: astore 6
    //   303: aload 9
    //   305: astore 7
    //   307: new 293	javax/security/auth/x500/X500Principal
    //   310: astore_2
    //   311: aload 9
    //   313: astore 8
    //   315: aload 9
    //   317: astore_3
    //   318: aload 9
    //   320: astore 4
    //   322: aload 9
    //   324: astore 5
    //   326: aload 9
    //   328: astore 6
    //   330: aload 9
    //   332: astore 7
    //   334: aload_2
    //   335: ldc_w 295
    //   338: invokespecial 298	javax/security/auth/x500/X500Principal:<init>	(Ljava/lang/String;)V
    //   341: aload 9
    //   343: astore 8
    //   345: aload 9
    //   347: astore_3
    //   348: aload 9
    //   350: astore 4
    //   352: aload 9
    //   354: astore 5
    //   356: aload 9
    //   358: astore 6
    //   360: aload 9
    //   362: astore 7
    //   364: aload 13
    //   366: aload_2
    //   367: invokevirtual 302	android/security/KeyPairGeneratorSpec$Builder:setSubject	(Ljavax/security/auth/x500/X500Principal;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   370: getstatic 308	java/math/BigInteger:ONE	Ljava/math/BigInteger;
    //   373: invokevirtual 312	android/security/KeyPairGeneratorSpec$Builder:setSerialNumber	(Ljava/math/BigInteger;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   376: aload 10
    //   378: invokevirtual 316	java/util/Calendar:getTime	()Ljava/util/Date;
    //   381: invokevirtual 320	android/security/KeyPairGeneratorSpec$Builder:setStartDate	(Ljava/util/Date;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   384: aload 11
    //   386: invokevirtual 316	java/util/Calendar:getTime	()Ljava/util/Date;
    //   389: invokevirtual 323	android/security/KeyPairGeneratorSpec$Builder:setEndDate	(Ljava/util/Date;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   392: invokevirtual 327	android/security/KeyPairGeneratorSpec$Builder:build	()Landroid/security/KeyPairGeneratorSpec;
    //   395: astore_2
    //   396: goto +199 -> 595
    //   399: aload 9
    //   401: astore 8
    //   403: aload 9
    //   405: astore_3
    //   406: aload 9
    //   408: astore 4
    //   410: aload 9
    //   412: astore 5
    //   414: aload 9
    //   416: astore 6
    //   418: aload 9
    //   420: astore 7
    //   422: new 329	android/security/keystore/KeyGenParameterSpec$Builder
    //   425: astore 13
    //   427: aload 9
    //   429: astore 8
    //   431: aload 9
    //   433: astore_3
    //   434: aload 9
    //   436: astore 4
    //   438: aload 9
    //   440: astore 5
    //   442: aload 9
    //   444: astore 6
    //   446: aload 9
    //   448: astore 7
    //   450: aload 13
    //   452: aload_2
    //   453: iconst_3
    //   454: invokespecial 332	android/security/keystore/KeyGenParameterSpec$Builder:<init>	(Ljava/lang/String;I)V
    //   457: aload 9
    //   459: astore 8
    //   461: aload 9
    //   463: astore_3
    //   464: aload 9
    //   466: astore 4
    //   468: aload 9
    //   470: astore 5
    //   472: aload 9
    //   474: astore 6
    //   476: aload 9
    //   478: astore 7
    //   480: new 293	javax/security/auth/x500/X500Principal
    //   483: astore_2
    //   484: aload 9
    //   486: astore 8
    //   488: aload 9
    //   490: astore_3
    //   491: aload 9
    //   493: astore 4
    //   495: aload 9
    //   497: astore 5
    //   499: aload 9
    //   501: astore 6
    //   503: aload 9
    //   505: astore 7
    //   507: aload_2
    //   508: ldc_w 295
    //   511: invokespecial 298	javax/security/auth/x500/X500Principal:<init>	(Ljava/lang/String;)V
    //   514: aload 9
    //   516: astore 8
    //   518: aload 9
    //   520: astore_3
    //   521: aload 9
    //   523: astore 4
    //   525: aload 9
    //   527: astore 5
    //   529: aload 9
    //   531: astore 6
    //   533: aload 9
    //   535: astore 7
    //   537: aload 13
    //   539: aload_2
    //   540: invokevirtual 336	android/security/keystore/KeyGenParameterSpec$Builder:setCertificateSubject	(Ljavax/security/auth/x500/X500Principal;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   543: iconst_1
    //   544: anewarray 135	java/lang/String
    //   547: dup
    //   548: iconst_0
    //   549: ldc_w 338
    //   552: aastore
    //   553: invokevirtual 342	android/security/keystore/KeyGenParameterSpec$Builder:setDigests	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   556: iconst_1
    //   557: anewarray 135	java/lang/String
    //   560: dup
    //   561: iconst_0
    //   562: ldc_w 344
    //   565: aastore
    //   566: invokevirtual 347	android/security/keystore/KeyGenParameterSpec$Builder:setEncryptionPaddings	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   569: getstatic 308	java/math/BigInteger:ONE	Ljava/math/BigInteger;
    //   572: invokevirtual 351	android/security/keystore/KeyGenParameterSpec$Builder:setCertificateSerialNumber	(Ljava/math/BigInteger;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   575: aload 10
    //   577: invokevirtual 316	java/util/Calendar:getTime	()Ljava/util/Date;
    //   580: invokevirtual 355	android/security/keystore/KeyGenParameterSpec$Builder:setCertificateNotBefore	(Ljava/util/Date;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   583: aload 11
    //   585: invokevirtual 316	java/util/Calendar:getTime	()Ljava/util/Date;
    //   588: invokevirtual 358	android/security/keystore/KeyGenParameterSpec$Builder:setCertificateNotAfter	(Ljava/util/Date;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   591: invokevirtual 361	android/security/keystore/KeyGenParameterSpec$Builder:build	()Landroid/security/keystore/KeyGenParameterSpec;
    //   594: astore_2
    //   595: aload 9
    //   597: astore 8
    //   599: aload 9
    //   601: astore_3
    //   602: aload 9
    //   604: astore 4
    //   606: aload 9
    //   608: astore 5
    //   610: aload 9
    //   612: astore 6
    //   614: aload 9
    //   616: astore 7
    //   618: ldc_w 363
    //   621: ldc 28
    //   623: invokestatic 368	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   626: astore 10
    //   628: aload 9
    //   630: astore 8
    //   632: aload 9
    //   634: astore_3
    //   635: aload 9
    //   637: astore 4
    //   639: aload 9
    //   641: astore 5
    //   643: aload 9
    //   645: astore 6
    //   647: aload 9
    //   649: astore 7
    //   651: aload 10
    //   653: aload_2
    //   654: invokevirtual 372	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   657: aload 9
    //   659: astore 8
    //   661: aload 9
    //   663: astore_3
    //   664: aload 9
    //   666: astore 4
    //   668: aload 9
    //   670: astore 5
    //   672: aload 9
    //   674: astore 6
    //   676: aload 9
    //   678: astore 7
    //   680: aload 10
    //   682: invokevirtual 376	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   685: pop
    //   686: aload 9
    //   688: ifnull +136 -> 824
    //   691: aload 9
    //   693: astore_2
    //   694: goto +107 -> 801
    //   697: astore_2
    //   698: goto +112 -> 810
    //   701: astore_2
    //   702: aload_3
    //   703: astore 8
    //   705: ldc 42
    //   707: aload_2
    //   708: ldc_w 378
    //   711: iconst_0
    //   712: anewarray 4	java/lang/Object
    //   715: invokestatic 48	b/d/w/c/a:f	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   718: aload_3
    //   719: astore 8
    //   721: getstatic 380	com/tplink/libtputility/security/b:b	Lcom/tplink/libtputility/security/b$a;
    //   724: astore 9
    //   726: aload 9
    //   728: ifnull +14 -> 742
    //   731: aload_3
    //   732: astore 8
    //   734: aload 9
    //   736: aload_2
    //   737: invokeinterface 384 2 0
    //   742: aload_3
    //   743: ifnull +81 -> 824
    //   746: aload_3
    //   747: astore_2
    //   748: goto +53 -> 801
    //   751: astore 9
    //   753: aload 4
    //   755: astore_2
    //   756: goto +24 -> 780
    //   759: astore 9
    //   761: aload 5
    //   763: astore_2
    //   764: goto +16 -> 780
    //   767: astore 9
    //   769: aload 6
    //   771: astore_2
    //   772: goto +8 -> 780
    //   775: astore 9
    //   777: aload 7
    //   779: astore_2
    //   780: aload_2
    //   781: astore 8
    //   783: ldc 42
    //   785: aload 9
    //   787: ldc_w 378
    //   790: iconst_0
    //   791: anewarray 4	java/lang/Object
    //   794: invokestatic 48	b/d/w/c/a:f	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   797: aload_2
    //   798: ifnull +26 -> 824
    //   801: aload_0
    //   802: aload_1
    //   803: aload_2
    //   804: invokespecial 99	com/tplink/libtputility/security/b:h	(Landroid/content/Context;Ljava/util/Locale;)V
    //   807: goto +17 -> 824
    //   810: aload 8
    //   812: ifnull +10 -> 822
    //   815: aload_0
    //   816: aload_1
    //   817: aload 8
    //   819: invokespecial 99	com/tplink/libtputility/security/b:h	(Landroid/content/Context;Ljava/util/Locale;)V
    //   822: aload_2
    //   823: athrow
    //   824: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	825	0	this	b
    //   0	825	1	paramContext	Context
    //   0	825	2	paramString	String
    //   16	731	3	localObject1	Object
    //   18	736	4	localObject2	Object
    //   21	741	5	localObject3	Object
    //   24	746	6	localObject4	Object
    //   27	751	7	localObject5	Object
    //   30	788	8	localObject6	Object
    //   35	700	9	localObject7	Object
    //   751	1	9	localProviderException	java.security.ProviderException
    //   759	1	9	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   767	1	9	localNoSuchProviderException	java.security.NoSuchProviderException
    //   775	11	9	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   94	587	10	localObject8	Object
    //   125	459	11	localCalendar	java.util.Calendar
    //   184	7	12	i	int
    //   219	319	13	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   32	37	697	finally
    //   60	65	697	finally
    //   88	96	697	finally
    //   119	127	697	finally
    //   150	158	697	finally
    //   181	186	697	finally
    //   216	221	697	finally
    //   244	253	697	finally
    //   276	284	697	finally
    //   307	311	697	finally
    //   334	341	697	finally
    //   364	396	697	finally
    //   422	427	697	finally
    //   450	457	697	finally
    //   480	484	697	finally
    //   507	514	697	finally
    //   537	595	697	finally
    //   618	628	697	finally
    //   651	657	697	finally
    //   680	686	697	finally
    //   705	718	697	finally
    //   721	726	697	finally
    //   734	742	697	finally
    //   783	797	697	finally
    //   32	37	701	java/lang/Exception
    //   60	65	701	java/lang/Exception
    //   88	96	701	java/lang/Exception
    //   119	127	701	java/lang/Exception
    //   150	158	701	java/lang/Exception
    //   181	186	701	java/lang/Exception
    //   216	221	701	java/lang/Exception
    //   244	253	701	java/lang/Exception
    //   276	284	701	java/lang/Exception
    //   307	311	701	java/lang/Exception
    //   334	341	701	java/lang/Exception
    //   364	396	701	java/lang/Exception
    //   422	427	701	java/lang/Exception
    //   450	457	701	java/lang/Exception
    //   480	484	701	java/lang/Exception
    //   507	514	701	java/lang/Exception
    //   537	595	701	java/lang/Exception
    //   618	628	701	java/lang/Exception
    //   651	657	701	java/lang/Exception
    //   680	686	701	java/lang/Exception
    //   32	37	751	java/security/ProviderException
    //   60	65	751	java/security/ProviderException
    //   88	96	751	java/security/ProviderException
    //   119	127	751	java/security/ProviderException
    //   150	158	751	java/security/ProviderException
    //   181	186	751	java/security/ProviderException
    //   216	221	751	java/security/ProviderException
    //   244	253	751	java/security/ProviderException
    //   276	284	751	java/security/ProviderException
    //   307	311	751	java/security/ProviderException
    //   334	341	751	java/security/ProviderException
    //   364	396	751	java/security/ProviderException
    //   422	427	751	java/security/ProviderException
    //   450	457	751	java/security/ProviderException
    //   480	484	751	java/security/ProviderException
    //   507	514	751	java/security/ProviderException
    //   537	595	751	java/security/ProviderException
    //   618	628	751	java/security/ProviderException
    //   651	657	751	java/security/ProviderException
    //   680	686	751	java/security/ProviderException
    //   32	37	759	java/security/InvalidAlgorithmParameterException
    //   60	65	759	java/security/InvalidAlgorithmParameterException
    //   88	96	759	java/security/InvalidAlgorithmParameterException
    //   119	127	759	java/security/InvalidAlgorithmParameterException
    //   150	158	759	java/security/InvalidAlgorithmParameterException
    //   181	186	759	java/security/InvalidAlgorithmParameterException
    //   216	221	759	java/security/InvalidAlgorithmParameterException
    //   244	253	759	java/security/InvalidAlgorithmParameterException
    //   276	284	759	java/security/InvalidAlgorithmParameterException
    //   307	311	759	java/security/InvalidAlgorithmParameterException
    //   334	341	759	java/security/InvalidAlgorithmParameterException
    //   364	396	759	java/security/InvalidAlgorithmParameterException
    //   422	427	759	java/security/InvalidAlgorithmParameterException
    //   450	457	759	java/security/InvalidAlgorithmParameterException
    //   480	484	759	java/security/InvalidAlgorithmParameterException
    //   507	514	759	java/security/InvalidAlgorithmParameterException
    //   537	595	759	java/security/InvalidAlgorithmParameterException
    //   618	628	759	java/security/InvalidAlgorithmParameterException
    //   651	657	759	java/security/InvalidAlgorithmParameterException
    //   680	686	759	java/security/InvalidAlgorithmParameterException
    //   32	37	767	java/security/NoSuchProviderException
    //   60	65	767	java/security/NoSuchProviderException
    //   88	96	767	java/security/NoSuchProviderException
    //   119	127	767	java/security/NoSuchProviderException
    //   150	158	767	java/security/NoSuchProviderException
    //   181	186	767	java/security/NoSuchProviderException
    //   216	221	767	java/security/NoSuchProviderException
    //   244	253	767	java/security/NoSuchProviderException
    //   276	284	767	java/security/NoSuchProviderException
    //   307	311	767	java/security/NoSuchProviderException
    //   334	341	767	java/security/NoSuchProviderException
    //   364	396	767	java/security/NoSuchProviderException
    //   422	427	767	java/security/NoSuchProviderException
    //   450	457	767	java/security/NoSuchProviderException
    //   480	484	767	java/security/NoSuchProviderException
    //   507	514	767	java/security/NoSuchProviderException
    //   537	595	767	java/security/NoSuchProviderException
    //   618	628	767	java/security/NoSuchProviderException
    //   651	657	767	java/security/NoSuchProviderException
    //   680	686	767	java/security/NoSuchProviderException
    //   32	37	775	java/security/NoSuchAlgorithmException
    //   60	65	775	java/security/NoSuchAlgorithmException
    //   88	96	775	java/security/NoSuchAlgorithmException
    //   119	127	775	java/security/NoSuchAlgorithmException
    //   150	158	775	java/security/NoSuchAlgorithmException
    //   181	186	775	java/security/NoSuchAlgorithmException
    //   216	221	775	java/security/NoSuchAlgorithmException
    //   244	253	775	java/security/NoSuchAlgorithmException
    //   276	284	775	java/security/NoSuchAlgorithmException
    //   307	311	775	java/security/NoSuchAlgorithmException
    //   334	341	775	java/security/NoSuchAlgorithmException
    //   364	396	775	java/security/NoSuchAlgorithmException
    //   422	427	775	java/security/NoSuchAlgorithmException
    //   450	457	775	java/security/NoSuchAlgorithmException
    //   480	484	775	java/security/NoSuchAlgorithmException
    //   507	514	775	java/security/NoSuchAlgorithmException
    //   537	595	775	java/security/NoSuchAlgorithmException
    //   618	628	775	java/security/NoSuchAlgorithmException
    //   651	657	775	java/security/NoSuchAlgorithmException
    //   680	686	775	java/security/NoSuchAlgorithmException
  }
  
  public boolean f(@NonNull String paramString)
  {
    KeyStore localKeyStore = this.c;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localKeyStore != null)
    {
      bool2 = bool1;
      try
      {
        if (!localKeyStore.containsAlias(paramString)) {
          break label68;
        }
        paramString = this.c.getCertificateChain(paramString);
        bool2 = bool1;
        if (paramString == null) {
          break label68;
        }
        bool2 = true;
      }
      catch (NullPointerException paramString) {}catch (KeyStoreException paramString) {}
      a.f("AndroidKeyStoreDelegate", paramString, "isKeyStorePrepared", new Object[0]);
      bool2 = bool1;
    }
    label68:
    return bool2;
  }
  
  public static abstract interface a
  {
    public abstract void onException(Exception paramException);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\security\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */