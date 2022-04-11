package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.zip.ZipInputStream;

public class b
{
  private final Context a;
  private final String b;
  @Nullable
  private final a c;
  
  private b(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    paramContext = paramContext.getApplicationContext();
    this.a = paramContext;
    this.b = paramString1;
    if (paramString2 == null) {
      this.c = null;
    } else {
      this.c = new a(paramContext);
    }
  }
  
  @Nullable
  @WorkerThread
  private com.airbnb.lottie.d a()
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((a)localObject1).a(this.b);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = (FileExtension)((Pair)localObject2).first;
    localObject2 = (InputStream)((Pair)localObject2).second;
    if (localObject1 == FileExtension.ZIP) {
      localObject1 = e.s(new ZipInputStream((InputStream)localObject2), this.b);
    } else {
      localObject1 = e.i((InputStream)localObject2, this.b);
    }
    if (((l)localObject1).b() != null) {
      return (com.airbnb.lottie.d)((l)localObject1).b();
    }
    return null;
  }
  
  @WorkerThread
  private l<com.airbnb.lottie.d> b()
  {
    try
    {
      l locall = c();
      return locall;
    }
    catch (IOException localIOException)
    {
      return new l(localIOException);
    }
  }
  
  /* Error */
  @WorkerThread
  private l<com.airbnb.lottie.d> c()
    throws IOException
  {
    // Byte code:
    //   0: new 94	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 97
    //   11: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 26	com/airbnb/lottie/network/b:b	Ljava/lang/String;
    //   20: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 110	com/airbnb/lottie/v/d:a	(Ljava/lang/String;)V
    //   31: new 112	java/net/URL
    //   34: dup
    //   35: aload_0
    //   36: getfield 26	com/airbnb/lottie/network/b:b	Ljava/lang/String;
    //   39: invokespecial 114	java/net/URL:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 118	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   45: checkcast 120	java/net/HttpURLConnection
    //   48: astore_1
    //   49: aload_1
    //   50: ldc 122
    //   52: invokevirtual 125	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: invokevirtual 128	java/net/HttpURLConnection:connect	()V
    //   59: aload_1
    //   60: invokevirtual 132	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   63: ifnonnull +73 -> 136
    //   66: aload_1
    //   67: invokevirtual 136	java/net/HttpURLConnection:getResponseCode	()I
    //   70: sipush 200
    //   73: if_icmpeq +6 -> 79
    //   76: goto +60 -> 136
    //   79: aload_0
    //   80: aload_1
    //   81: invokespecial 140	com/airbnb/lottie/network/b:g	(Ljava/net/HttpURLConnection;)Lcom/airbnb/lottie/l;
    //   84: astore_2
    //   85: new 94	java/lang/StringBuilder
    //   88: astore_3
    //   89: aload_3
    //   90: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   93: aload_3
    //   94: ldc -114
    //   96: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_2
    //   101: invokevirtual 77	com/airbnb/lottie/l:b	()Ljava/lang/Object;
    //   104: ifnull +9 -> 113
    //   107: iconst_1
    //   108: istore 4
    //   110: goto +6 -> 116
    //   113: iconst_0
    //   114: istore 4
    //   116: aload_3
    //   117: iload 4
    //   119: invokevirtual 145	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 110	com/airbnb/lottie/v/d:a	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   134: aload_2
    //   135: areturn
    //   136: aload_0
    //   137: aload_1
    //   138: invokespecial 152	com/airbnb/lottie/network/b:f	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   141: astore_2
    //   142: new 154	java/lang/IllegalArgumentException
    //   145: astore 5
    //   147: new 94	java/lang/StringBuilder
    //   150: astore_3
    //   151: aload_3
    //   152: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   155: aload_3
    //   156: ldc -100
    //   158: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_3
    //   163: aload_0
    //   164: getfield 26	com/airbnb/lottie/network/b:b	Ljava/lang/String;
    //   167: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: ldc -98
    //   174: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_3
    //   179: aload_1
    //   180: invokevirtual 136	java/net/HttpURLConnection:getResponseCode	()I
    //   183: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_3
    //   188: ldc -93
    //   190: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_3
    //   195: aload_2
    //   196: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 5
    //   202: aload_3
    //   203: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 164	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   209: new 74	com/airbnb/lottie/l
    //   212: dup
    //   213: aload 5
    //   215: invokespecial 88	com/airbnb/lottie/l:<init>	(Ljava/lang/Throwable;)V
    //   218: astore_3
    //   219: aload_1
    //   220: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   223: aload_3
    //   224: areturn
    //   225: astore_3
    //   226: goto +19 -> 245
    //   229: astore_3
    //   230: new 74	com/airbnb/lottie/l
    //   233: dup
    //   234: aload_3
    //   235: invokespecial 88	com/airbnb/lottie/l:<init>	(Ljava/lang/Throwable;)V
    //   238: astore_3
    //   239: aload_1
    //   240: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   243: aload_3
    //   244: areturn
    //   245: aload_1
    //   246: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   249: aload_3
    //   250: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	b
    //   7	239	1	localObject1	Object
    //   84	112	2	localObject2	Object
    //   88	136	3	localObject3	Object
    //   225	1	3	localObject4	Object
    //   229	6	3	localException	Exception
    //   238	12	3	locall	l
    //   108	10	4	bool	boolean
    //   145	69	5	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   55	76	225	finally
    //   79	107	225	finally
    //   116	130	225	finally
    //   136	219	225	finally
    //   230	239	225	finally
    //   55	76	229	java/lang/Exception
    //   79	107	229	java/lang/Exception
    //   116	130	229	java/lang/Exception
    //   136	219	229	java/lang/Exception
  }
  
  public static l<com.airbnb.lottie.d> e(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    return new b(paramContext, paramString1, paramString2).d();
  }
  
  /* Error */
  private String f(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 136	java/net/HttpURLConnection:getResponseCode	()I
    //   4: pop
    //   5: new 175	java/io/BufferedReader
    //   8: dup
    //   9: new 177	java/io/InputStreamReader
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 132	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   17: invokespecial 178	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 181	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: new 94	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   31: astore_2
    //   32: aload_1
    //   33: invokevirtual 184	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +19 -> 57
    //   41: aload_2
    //   42: aload_3
    //   43: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_2
    //   48: bipush 10
    //   50: invokevirtual 187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -22 -> 32
    //   57: aload_1
    //   58: invokevirtual 190	java/io/BufferedReader:close	()V
    //   61: aload_2
    //   62: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: areturn
    //   66: astore_2
    //   67: goto +6 -> 73
    //   70: astore_2
    //   71: aload_2
    //   72: athrow
    //   73: aload_1
    //   74: invokevirtual 190	java/io/BufferedReader:close	()V
    //   77: aload_2
    //   78: athrow
    //   79: astore_1
    //   80: goto -19 -> 61
    //   83: astore_1
    //   84: goto -7 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	b
    //   0	87	1	paramHttpURLConnection	HttpURLConnection
    //   31	31	2	localStringBuilder	StringBuilder
    //   66	1	2	localObject	Object
    //   70	8	2	localException	Exception
    //   36	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   32	37	66	finally
    //   41	54	66	finally
    //   71	73	66	finally
    //   32	37	70	java/lang/Exception
    //   41	54	70	java/lang/Exception
    //   57	61	79	java/lang/Exception
    //   73	77	83	java/lang/Exception
  }
  
  @Nullable
  private l<com.airbnb.lottie.d> g(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    Object localObject1 = paramHttpURLConnection.getContentType();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "application/json";
    }
    if (((String)localObject2).contains("application/zip"))
    {
      com.airbnb.lottie.v.d.a("Handling zip response.");
      localObject2 = FileExtension.ZIP;
      localObject1 = this.c;
      if (localObject1 == null) {
        paramHttpURLConnection = e.s(new ZipInputStream(paramHttpURLConnection.getInputStream()), null);
      } else {
        paramHttpURLConnection = e.s(new ZipInputStream(new FileInputStream(((a)localObject1).f(this.b, paramHttpURLConnection.getInputStream(), (FileExtension)localObject2))), this.b);
      }
    }
    else
    {
      com.airbnb.lottie.v.d.a("Received json response.");
      localObject2 = FileExtension.JSON;
      localObject1 = this.c;
      if (localObject1 == null) {
        paramHttpURLConnection = e.i(paramHttpURLConnection.getInputStream(), null);
      } else {
        paramHttpURLConnection = e.i(new FileInputStream(new File(((a)localObject1).f(this.b, paramHttpURLConnection.getInputStream(), (FileExtension)localObject2).getAbsolutePath())), this.b);
      }
    }
    if ((this.c != null) && (paramHttpURLConnection.b() != null)) {
      this.c.e(this.b, (FileExtension)localObject2);
    }
    return paramHttpURLConnection;
  }
  
  @WorkerThread
  public l<com.airbnb.lottie.d> d()
  {
    Object localObject = a();
    if (localObject != null) {
      return new l(localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Animation for ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" not found in cache. Fetching from network.");
    com.airbnb.lottie.v.d.a(((StringBuilder)localObject).toString());
    return b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\network\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */