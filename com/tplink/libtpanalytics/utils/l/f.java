package com.tplink.libtpanalytics.utils.l;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import b.d.c.c.c;
import com.tplink.libtpanalytics.utils.j;
import java.io.File;
import org.json.JSONObject;

public class f
  implements c
{
  private static volatile String a;
  private static volatile com.tplink.libtputility.security.a b;
  private b.d.c.c.b c;
  private d d;
  private com.tplink.libtpanalytics.database.d.a e;
  private Handler f = new Handler(com.tplink.libtpanalytics.core.define.a.c.getLooper());
  
  private void b(Context paramContext, com.tplink.libtputility.security.b paramb)
  {
    b = new com.tplink.libtputility.security.a();
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("evo");
    ((StringBuilder)localObject).append(l);
    localObject = ((StringBuilder)localObject).toString();
    j.g(paramContext).j(l);
    n((String)localObject);
    j(paramb.b(b.h(), "tpa_model_file_key"), paramb.b(b.g(), "tpa_model_file_key"));
  }
  
  private boolean f(Context paramContext)
  {
    long l = j.g(paramContext).e();
    boolean bool;
    if ((l != -1L) && (System.currentTimeMillis() - l < 86400000L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  private JSONObject i()
  {
    // Byte code:
    //   0: new 55	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: getstatic 120	com/tplink/libtpanalytics/utils/l/f:a	Ljava/lang/String;
    //   12: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: getstatic 125	java/io/File:separator	Ljava/lang/String;
    //   19: astore_2
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_1
    //   27: ldc 127
    //   29: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: ldc 127
    //   42: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: new 122	java/io/File
    //   49: dup
    //   50: aload_1
    //   51: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_3
    //   60: new 131	java/io/FileReader
    //   63: astore_2
    //   64: aload_2
    //   65: aload_1
    //   66: invokespecial 134	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   69: new 136	java/io/BufferedReader
    //   72: astore_1
    //   73: aload_1
    //   74: aload_2
    //   75: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: aload_1
    //   79: astore 4
    //   81: aload_2
    //   82: astore 5
    //   84: new 55	java/lang/StringBuilder
    //   87: astore 6
    //   89: aload_1
    //   90: astore 4
    //   92: aload_2
    //   93: astore 5
    //   95: aload 6
    //   97: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   100: aload_1
    //   101: astore 4
    //   103: aload_2
    //   104: astore 5
    //   106: aload_1
    //   107: invokevirtual 142	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   110: astore 7
    //   112: aload 7
    //   114: ifnull +20 -> 134
    //   117: aload_1
    //   118: astore 4
    //   120: aload_2
    //   121: astore 5
    //   123: aload 6
    //   125: aload 7
    //   127: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: goto -31 -> 100
    //   134: aload_1
    //   135: astore 4
    //   137: aload_2
    //   138: astore 5
    //   140: new 144	org/json/JSONObject
    //   143: dup
    //   144: aload 6
    //   146: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   152: astore 7
    //   154: aload_1
    //   155: invokevirtual 148	java/io/BufferedReader:close	()V
    //   158: aload_2
    //   159: invokevirtual 149	java/io/FileReader:close	()V
    //   162: goto +11 -> 173
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   170: invokestatic 154	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   173: aload 7
    //   175: astore_1
    //   176: goto +124 -> 300
    //   179: astore 4
    //   181: aload_2
    //   182: astore 7
    //   184: aload 4
    //   186: astore_2
    //   187: goto +58 -> 245
    //   190: astore 4
    //   192: aload_2
    //   193: astore 7
    //   195: aload 4
    //   197: astore_2
    //   198: goto +47 -> 245
    //   201: astore_1
    //   202: aconst_null
    //   203: astore 4
    //   205: goto +101 -> 306
    //   208: astore 4
    //   210: goto +5 -> 215
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_2
    //   218: astore 7
    //   220: aload 4
    //   222: astore_2
    //   223: goto +22 -> 245
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_2
    //   229: aload_2
    //   230: astore 4
    //   232: goto +74 -> 306
    //   235: astore_2
    //   236: goto +4 -> 240
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_1
    //   242: aload_1
    //   243: astore 7
    //   245: aload_1
    //   246: astore 4
    //   248: aload 7
    //   250: astore 5
    //   252: aload_2
    //   253: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   256: invokestatic 154	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   259: aload_1
    //   260: ifnull +14 -> 274
    //   263: aload_1
    //   264: invokevirtual 148	java/io/BufferedReader:close	()V
    //   267: goto +7 -> 274
    //   270: astore_1
    //   271: goto +20 -> 291
    //   274: aload_3
    //   275: astore_1
    //   276: aload 7
    //   278: ifnull +22 -> 300
    //   281: aload 7
    //   283: invokevirtual 149	java/io/FileReader:close	()V
    //   286: aload_3
    //   287: astore_1
    //   288: goto +12 -> 300
    //   291: aload_1
    //   292: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   295: invokestatic 154	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   298: aload_3
    //   299: astore_1
    //   300: aload_1
    //   301: areturn
    //   302: astore_1
    //   303: aload 5
    //   305: astore_2
    //   306: aload 4
    //   308: ifnull +15 -> 323
    //   311: aload 4
    //   313: invokevirtual 148	java/io/BufferedReader:close	()V
    //   316: goto +7 -> 323
    //   319: astore_2
    //   320: goto +14 -> 334
    //   323: aload_2
    //   324: ifnull +17 -> 341
    //   327: aload_2
    //   328: invokevirtual 149	java/io/FileReader:close	()V
    //   331: goto +10 -> 341
    //   334: aload_2
    //   335: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   338: invokestatic 154	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   341: aload_1
    //   342: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	f
    //   7	148	1	localObject1	Object
    //   165	2	1	localIOException1	java.io.IOException
    //   175	1	1	localObject2	Object
    //   201	1	1	localObject3	Object
    //   216	1	1	localObject4	Object
    //   226	1	1	localObject5	Object
    //   241	23	1	localObject6	Object
    //   270	1	1	localIOException2	java.io.IOException
    //   275	26	1	localObject7	Object
    //   302	40	1	localObject8	Object
    //   19	211	2	localObject9	Object
    //   235	1	2	localJSONException1	org.json.JSONException
    //   239	14	2	localIOException3	java.io.IOException
    //   305	1	2	localObject10	Object
    //   319	16	2	localIOException4	java.io.IOException
    //   59	240	3	localObject11	Object
    //   79	57	4	localObject12	Object
    //   179	6	4	localJSONException2	org.json.JSONException
    //   190	6	4	localIOException5	java.io.IOException
    //   203	1	4	localObject13	Object
    //   208	1	4	localJSONException3	org.json.JSONException
    //   213	8	4	localIOException6	java.io.IOException
    //   230	82	4	localObject14	Object
    //   82	222	5	localObject15	Object
    //   87	58	6	localStringBuilder	StringBuilder
    //   110	172	7	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   154	162	165	java/io/IOException
    //   84	89	179	org/json/JSONException
    //   95	100	179	org/json/JSONException
    //   106	112	179	org/json/JSONException
    //   123	131	179	org/json/JSONException
    //   140	154	179	org/json/JSONException
    //   84	89	190	java/io/IOException
    //   95	100	190	java/io/IOException
    //   106	112	190	java/io/IOException
    //   123	131	190	java/io/IOException
    //   140	154	190	java/io/IOException
    //   69	78	201	finally
    //   69	78	208	org/json/JSONException
    //   69	78	213	java/io/IOException
    //   60	69	226	finally
    //   60	69	235	org/json/JSONException
    //   60	69	239	java/io/IOException
    //   263	267	270	java/io/IOException
    //   281	286	270	java/io/IOException
    //   84	89	302	finally
    //   95	100	302	finally
    //   106	112	302	finally
    //   123	131	302	finally
    //   140	154	302	finally
    //   252	259	302	finally
    //   311	316	319	java/io/IOException
    //   327	331	319	java/io/IOException
  }
  
  /* Error */
  private void j(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 55	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getstatic 120	com/tplink/libtpanalytics/utils/l/f:a	Ljava/lang/String;
    //   12: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: getstatic 125	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: ldc 127
    //   27: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: new 122	java/io/File
    //   34: dup
    //   35: aload_3
    //   36: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 161	java/io/File:exists	()Z
    //   47: ifne +8 -> 55
    //   50: aload_3
    //   51: invokevirtual 164	java/io/File:mkdirs	()Z
    //   54: pop
    //   55: new 122	java/io/File
    //   58: dup
    //   59: aload_3
    //   60: ldc 127
    //   62: invokespecial 167	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore_3
    //   66: new 144	org/json/JSONObject
    //   69: astore 4
    //   71: aload 4
    //   73: invokespecial 168	org/json/JSONObject:<init>	()V
    //   76: aload 4
    //   78: ldc -86
    //   80: aload_1
    //   81: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload 4
    //   87: ldc -80
    //   89: aload_2
    //   90: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: new 178	java/io/FileWriter
    //   97: astore_2
    //   98: aload_2
    //   99: aload_3
    //   100: invokespecial 179	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   103: new 181	java/io/BufferedWriter
    //   106: astore 5
    //   108: aload 5
    //   110: aload_2
    //   111: invokespecial 184	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   114: aload_2
    //   115: astore_3
    //   116: aload 5
    //   118: astore 6
    //   120: aload 5
    //   122: aload 4
    //   124: invokevirtual 185	org/json/JSONObject:toString	()Ljava/lang/String;
    //   127: invokevirtual 188	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   130: aload_2
    //   131: astore_3
    //   132: aload 5
    //   134: astore 6
    //   136: aload 5
    //   138: invokevirtual 191	java/io/BufferedWriter:flush	()V
    //   141: aload 5
    //   143: invokevirtual 192	java/io/BufferedWriter:close	()V
    //   146: aload_2
    //   147: invokevirtual 193	java/io/FileWriter:close	()V
    //   150: goto +113 -> 263
    //   153: astore_1
    //   154: aload_2
    //   155: astore 4
    //   157: aload 5
    //   159: astore_2
    //   160: goto +55 -> 215
    //   163: astore_1
    //   164: aload_2
    //   165: astore 4
    //   167: aload 5
    //   169: astore_2
    //   170: goto +45 -> 215
    //   173: astore_1
    //   174: aconst_null
    //   175: astore 6
    //   177: goto +90 -> 267
    //   180: astore_1
    //   181: goto +4 -> 185
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_2
    //   188: astore 4
    //   190: aload_3
    //   191: astore_2
    //   192: goto +23 -> 215
    //   195: astore_1
    //   196: aconst_null
    //   197: astore 6
    //   199: aload 6
    //   201: astore_2
    //   202: goto +65 -> 267
    //   205: astore_1
    //   206: goto +4 -> 210
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_2
    //   213: astore 4
    //   215: aload 4
    //   217: astore_3
    //   218: aload_2
    //   219: astore 6
    //   221: aload_1
    //   222: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   225: invokestatic 154	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   228: aload_2
    //   229: ifnull +14 -> 243
    //   232: aload_2
    //   233: invokevirtual 192	java/io/BufferedWriter:close	()V
    //   236: goto +7 -> 243
    //   239: astore_1
    //   240: goto +16 -> 256
    //   243: aload 4
    //   245: ifnull +18 -> 263
    //   248: aload 4
    //   250: invokevirtual 193	java/io/FileWriter:close	()V
    //   253: goto +10 -> 263
    //   256: aload_1
    //   257: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   260: invokestatic 154	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   263: return
    //   264: astore_1
    //   265: aload_3
    //   266: astore_2
    //   267: aload 6
    //   269: ifnull +15 -> 284
    //   272: aload 6
    //   274: invokevirtual 192	java/io/BufferedWriter:close	()V
    //   277: goto +7 -> 284
    //   280: astore_2
    //   281: goto +14 -> 295
    //   284: aload_2
    //   285: ifnull +17 -> 302
    //   288: aload_2
    //   289: invokevirtual 193	java/io/FileWriter:close	()V
    //   292: goto +10 -> 302
    //   295: aload_2
    //   296: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   299: invokestatic 154	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   302: aload_1
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	f
    //   0	304	1	paramString1	String
    //   0	304	2	paramString2	String
    //   7	259	3	localObject1	Object
    //   69	180	4	localObject2	Object
    //   106	62	5	localBufferedWriter	java.io.BufferedWriter
    //   118	155	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   120	130	153	org/json/JSONException
    //   136	141	153	org/json/JSONException
    //   120	130	163	java/io/IOException
    //   136	141	163	java/io/IOException
    //   103	114	173	finally
    //   103	114	180	org/json/JSONException
    //   103	114	184	java/io/IOException
    //   66	103	195	finally
    //   66	103	205	org/json/JSONException
    //   66	103	209	java/io/IOException
    //   141	150	239	java/io/IOException
    //   232	236	239	java/io/IOException
    //   248	253	239	java/io/IOException
    //   120	130	264	finally
    //   136	141	264	finally
    //   221	228	264	finally
    //   272	277	280	java/io/IOException
    //   288	292	280	java/io/IOException
  }
  
  private void m(Context paramContext)
  {
    long l = j.g(paramContext).e();
    paramContext = new StringBuilder();
    paramContext.append("evo");
    paramContext.append(l);
    n(paramContext.toString());
  }
  
  private void n(String paramString)
  {
    com.tplink.libtpanalytics.database.d.a locala = new com.tplink.libtpanalytics.database.d.a();
    this.e = locala;
    locala.e(paramString);
    locala.g(256);
    locala.h("AES/CBC/PKCS7Padding");
    paramString = Base64.decode(b.h(), 0);
    byte[] arrayOfByte1 = Base64.decode(b.g(), 0);
    byte[] arrayOfByte2 = new byte[paramString.length + arrayOfByte1.length];
    System.arraycopy(paramString, 0, arrayOfByte2, 0, paramString.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramString.length, arrayOfByte1.length);
    try
    {
      locala.f(Base64.encodeToString(this.d.n(arrayOfByte2), 2));
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    this.f.post(new a(this, locala));
  }
  
  public String a(String paramString)
  {
    if (b.d.w.h.b.d(paramString)) {
      return "";
    }
    if (b != null) {
      try
      {
        paramString = Base64.encodeToString(b.d(paramString.getBytes()), 2);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  public com.tplink.libtpanalytics.database.d.a c()
  {
    return this.e;
  }
  
  public String d()
  {
    com.tplink.libtpanalytics.database.d.a locala = this.e;
    if (locala != null) {
      return locala.a();
    }
    return "";
  }
  
  public void e(Context paramContext)
  {
    if (a == null) {
      try
      {
        Object localObject1 = paramContext.getCacheDir().getAbsolutePath();
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("tpa_model_cache");
        a = ((StringBuilder)localObject2).toString();
        Object localObject3 = new java/io/File;
        ((File)localObject3).<init>(a);
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        com.tplink.libtputility.security.b localb = com.tplink.libtputility.security.b.c();
        if (localb.f("tpa_model_file_key"))
        {
          localObject1 = i();
          localObject2 = null;
          if (localObject1 != null)
          {
            localObject2 = localb.a(((JSONObject)localObject1).optString("TPA_TPSERIALIZEUTILS_AES_KEY", ""), "tpa_model_file_key");
            localObject1 = localb.a(((JSONObject)localObject1).optString("TPA_TPSERIALIZEUTILS_AES_VECTOR", ""), "tpa_model_file_key");
          }
          else
          {
            localObject1 = null;
          }
          if ((!b.d.w.h.b.d((CharSequence)localObject2)) && (!b.d.w.h.b.d((CharSequence)localObject1)) && (f(paramContext)))
          {
            localObject3 = new com/tplink/libtputility/security/a;
            ((com.tplink.libtputility.security.a)localObject3).<init>((String)localObject2, (String)localObject1);
            b = (com.tplink.libtputility.security.a)localObject3;
            m(paramContext);
          }
          else
          {
            b.d.w.b.b.c((File)localObject3);
            b(paramContext, localb);
          }
        }
        else
        {
          localb.e(paramContext, "tpa_model_file_key");
          b(paramContext, localb);
        }
      }
      finally {}
    }
  }
  
  public void k(b.d.c.c.b paramb)
  {
    this.c = paramb;
  }
  
  public void l(d paramd)
  {
    this.d = paramd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\l\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */