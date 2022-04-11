package com.bumptech.glide.k;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
  implements Closeable
{
  private long H3 = 0L;
  final ThreadPoolExecutor I3 = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
  private final Callable<Void> J3 = new a();
  private final File c;
  private final File d;
  private final File f;
  private long p0 = 0L;
  private Writer p1;
  private final LinkedHashMap<String, d> p2 = new LinkedHashMap(0, 0.75F, true);
  private int p3;
  private final File q;
  private final int x;
  private long y;
  private final int z;
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.c = paramFile;
    this.x = paramInt1;
    this.d = new File(paramFile, "journal");
    this.f = new File(paramFile, "journal.tmp");
    this.q = new File(paramFile, "journal.bkp");
    this.z = paramInt2;
    this.y = paramLong;
  }
  
  private boolean B()
  {
    int i = this.p3;
    boolean bool;
    if ((i >= 2000) && (i >= this.p2.size())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static a C(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong > 0L)
    {
      if (paramInt2 > 0)
      {
        Object localObject = new File(paramFile, "journal.bkp");
        if (((File)localObject).exists())
        {
          File localFile = new File(paramFile, "journal");
          if (localFile.exists()) {
            ((File)localObject).delete();
          } else {
            I((File)localObject, localFile, false);
          }
        }
        a locala = new a(paramFile, paramInt1, paramInt2, paramLong);
        if (locala.d.exists()) {
          try
          {
            locala.E();
            locala.D();
            return locala;
          }
          catch (IOException localIOException)
          {
            localObject = System.out;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("DiskLruCache ");
            localStringBuilder.append(paramFile);
            localStringBuilder.append(" is corrupt: ");
            localStringBuilder.append(localIOException.getMessage());
            localStringBuilder.append(", removing");
            ((PrintStream)localObject).println(localStringBuilder.toString());
            locala.v();
          }
        }
        paramFile.mkdirs();
        paramFile = new a(paramFile, paramInt1, paramInt2, paramLong);
        paramFile.G();
        return paramFile;
      }
      throw new IllegalArgumentException("valueCount <= 0");
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void D()
    throws IOException
  {
    w(this.f);
    Iterator localIterator = this.p2.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      c localc = d.g(locald);
      int i = 0;
      int j = 0;
      if (localc == null)
      {
        while (j < this.z)
        {
          this.p0 += d.a(locald)[j];
          j++;
        }
      }
      else
      {
        d.h(locald, null);
        for (j = i; j < this.z; j++)
        {
          w(locald.j(j));
          w(locald.k(j));
        }
        localIterator.remove();
      }
    }
  }
  
  private void E()
    throws IOException
  {
    b localb = new b(new FileInputStream(this.d), c.a);
    try
    {
      String str1 = localb.g();
      Object localObject2 = localb.g();
      Object localObject3 = localb.g();
      Object localObject4 = localb.g();
      String str2 = localb.g();
      FileOutputStream localFileOutputStream;
      if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(localObject2)) && (Integer.toString(this.x).equals(localObject3)) && (Integer.toString(this.z).equals(localObject4)))
      {
        boolean bool = "".equals(str2);
        if (bool)
        {
          int i = 0;
          try
          {
            for (;;)
            {
              F(localb.g());
              i++;
            }
            localIOException = new java/io/IOException;
          }
          catch (EOFException localEOFException)
          {
            this.p3 = (i - this.p2.size());
            if (localb.e())
            {
              G();
            }
            else
            {
              localObject2 = new java/io/BufferedWriter;
              localObject4 = new java/io/OutputStreamWriter;
              localFileOutputStream = new java/io/FileOutputStream;
              localFileOutputStream.<init>(this.d, true);
              ((OutputStreamWriter)localObject4).<init>(localFileOutputStream, c.a);
              ((BufferedWriter)localObject2).<init>((Writer)localObject4);
              this.p1 = ((Writer)localObject2);
            }
            return;
          }
        }
      }
      IOException localIOException;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      ((StringBuilder)localObject3).append("unexpected journal header: [");
      ((StringBuilder)localObject3).append(localFileOutputStream);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append((String)localObject4);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(str2);
      ((StringBuilder)localObject3).append("]");
      localIOException.<init>(((StringBuilder)localObject3).toString());
      throw localIOException;
    }
    finally
    {
      c.a(localb);
    }
  }
  
  private void F(String paramString)
    throws IOException
  {
    int i = paramString.indexOf(' ');
    if (i != -1)
    {
      int j = i + 1;
      int k = paramString.indexOf(' ', j);
      if (k == -1)
      {
        localObject1 = paramString.substring(j);
        localObject2 = localObject1;
        if (i == 6)
        {
          localObject2 = localObject1;
          if (paramString.startsWith("REMOVE")) {
            this.p2.remove(localObject1);
          }
        }
      }
      else
      {
        localObject2 = paramString.substring(j, k);
      }
      d locald = (d)this.p2.get(localObject2);
      Object localObject1 = locald;
      if (locald == null)
      {
        localObject1 = new d((String)localObject2, null);
        this.p2.put(localObject2, localObject1);
      }
      if ((k != -1) && (i == 5) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        d.f((d)localObject1, true);
        d.h((d)localObject1, null);
        d.i((d)localObject1, paramString);
      }
      else if ((k == -1) && (i == 5) && (paramString.startsWith("DIRTY")))
      {
        d.h((d)localObject1, new c((d)localObject1, null));
      }
      else
      {
        if ((k != -1) || (i != 4) || (!paramString.startsWith("READ"))) {
          break label252;
        }
      }
      return;
      label252:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unexpected journal line: ");
      ((StringBuilder)localObject2).append(paramString);
      throw new IOException(((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unexpected journal line: ");
    ((StringBuilder)localObject2).append(paramString);
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  /* Error */
  private void G()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 294	com/bumptech/glide/k/a:p1	Ljava/io/Writer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: aload_1
    //   12: invokestatic 363	com/bumptech/glide/k/a:t	(Ljava/io/Writer;)V
    //   15: new 279	java/io/BufferedWriter
    //   18: astore_1
    //   19: new 281	java/io/OutputStreamWriter
    //   22: astore_2
    //   23: new 283	java/io/FileOutputStream
    //   26: astore_3
    //   27: aload_3
    //   28: aload_0
    //   29: getfield 101	com/bumptech/glide/k/a:f	Ljava/io/File;
    //   32: invokespecial 364	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: aload_2
    //   36: aload_3
    //   37: getstatic 250	com/bumptech/glide/k/c:a	Ljava/nio/charset/Charset;
    //   40: invokespecial 289	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   43: aload_1
    //   44: aload_2
    //   45: invokespecial 292	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   48: aload_1
    //   49: ldc_w 257
    //   52: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: ldc_w 371
    //   59: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: ldc_w 265
    //   66: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   69: aload_1
    //   70: ldc_w 371
    //   73: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: aload_0
    //   78: getfield 88	com/bumptech/glide/k/a:x	I
    //   81: invokestatic 270	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   84: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: ldc_w 371
    //   91: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: aload_0
    //   96: getfield 107	com/bumptech/glide/k/a:z	I
    //   99: invokestatic 270	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   102: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   105: aload_1
    //   106: ldc_w 371
    //   109: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: ldc_w 371
    //   116: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 56	com/bumptech/glide/k/a:p2	Ljava/util/LinkedHashMap;
    //   123: invokevirtual 200	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   126: invokeinterface 206 1 0
    //   131: astore_2
    //   132: aload_2
    //   133: invokeinterface 211 1 0
    //   138: ifeq +128 -> 266
    //   141: aload_2
    //   142: invokeinterface 215 1 0
    //   147: checkcast 16	com/bumptech/glide/k/a$d
    //   150: astore_3
    //   151: aload_3
    //   152: invokestatic 219	com/bumptech/glide/k/a$d:g	(Lcom/bumptech/glide/k/a$d;)Lcom/bumptech/glide/k/a$c;
    //   155: ifnull +52 -> 207
    //   158: new 147	java/lang/StringBuilder
    //   161: astore 4
    //   163: aload 4
    //   165: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   168: aload 4
    //   170: ldc_w 373
    //   173: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: aload_3
    //   180: invokestatic 376	com/bumptech/glide/k/a$d:b	(Lcom/bumptech/glide/k/a$d;)Ljava/lang/String;
    //   183: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 4
    //   189: bipush 10
    //   191: invokevirtual 379	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: aload 4
    //   198: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   204: goto -72 -> 132
    //   207: new 147	java/lang/StringBuilder
    //   210: astore 4
    //   212: aload 4
    //   214: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   217: aload 4
    //   219: ldc_w 381
    //   222: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 4
    //   228: aload_3
    //   229: invokestatic 376	com/bumptech/glide/k/a$d:b	(Lcom/bumptech/glide/k/a$d;)Ljava/lang/String;
    //   232: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 4
    //   238: aload_3
    //   239: invokevirtual 384	com/bumptech/glide/k/a$d:l	()Ljava/lang/String;
    //   242: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 4
    //   248: bipush 10
    //   250: invokevirtual 379	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: aload 4
    //   257: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 369	java/io/Writer:write	(Ljava/lang/String;)V
    //   263: goto -131 -> 132
    //   266: aload_1
    //   267: invokestatic 363	com/bumptech/glide/k/a:t	(Ljava/io/Writer;)V
    //   270: aload_0
    //   271: getfield 97	com/bumptech/glide/k/a:d	Ljava/io/File;
    //   274: invokevirtual 125	java/io/File:exists	()Z
    //   277: ifeq +15 -> 292
    //   280: aload_0
    //   281: getfield 97	com/bumptech/glide/k/a:d	Ljava/io/File;
    //   284: aload_0
    //   285: getfield 105	com/bumptech/glide/k/a:q	Ljava/io/File;
    //   288: iconst_1
    //   289: invokestatic 131	com/bumptech/glide/k/a:I	(Ljava/io/File;Ljava/io/File;Z)V
    //   292: aload_0
    //   293: getfield 101	com/bumptech/glide/k/a:f	Ljava/io/File;
    //   296: aload_0
    //   297: getfield 97	com/bumptech/glide/k/a:d	Ljava/io/File;
    //   300: iconst_0
    //   301: invokestatic 131	com/bumptech/glide/k/a:I	(Ljava/io/File;Ljava/io/File;Z)V
    //   304: aload_0
    //   305: getfield 105	com/bumptech/glide/k/a:q	Ljava/io/File;
    //   308: invokevirtual 128	java/io/File:delete	()Z
    //   311: pop
    //   312: new 279	java/io/BufferedWriter
    //   315: astore_2
    //   316: new 281	java/io/OutputStreamWriter
    //   319: astore_1
    //   320: new 283	java/io/FileOutputStream
    //   323: astore_3
    //   324: aload_3
    //   325: aload_0
    //   326: getfield 97	com/bumptech/glide/k/a:d	Ljava/io/File;
    //   329: iconst_1
    //   330: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   333: aload_1
    //   334: aload_3
    //   335: getstatic 250	com/bumptech/glide/k/c:a	Ljava/nio/charset/Charset;
    //   338: invokespecial 289	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   341: aload_2
    //   342: aload_1
    //   343: invokespecial 292	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   346: aload_0
    //   347: aload_2
    //   348: putfield 294	com/bumptech/glide/k/a:p1	Ljava/io/Writer;
    //   351: aload_0
    //   352: monitorexit
    //   353: return
    //   354: astore_2
    //   355: aload_1
    //   356: invokestatic 363	com/bumptech/glide/k/a:t	(Ljava/io/Writer;)V
    //   359: aload_2
    //   360: athrow
    //   361: astore_1
    //   362: aload_0
    //   363: monitorexit
    //   364: aload_1
    //   365: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	a
    //   6	350	1	localObject1	Object
    //   361	4	1	localObject2	Object
    //   22	326	2	localObject3	Object
    //   354	6	2	localObject4	Object
    //   26	309	3	localObject5	Object
    //   161	95	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	132	354	finally
    //   132	204	354	finally
    //   207	263	354	finally
    //   2	7	361	finally
    //   11	15	361	finally
    //   15	48	361	finally
    //   266	292	361	finally
    //   292	351	361	finally
    //   355	361	361	finally
  }
  
  private static void I(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      w(paramFile2);
    }
    if (paramFile1.renameTo(paramFile2)) {
      return;
    }
    throw new IOException();
  }
  
  private void J()
    throws IOException
  {
    while (this.p0 > this.y) {
      H((String)((Map.Entry)this.p2.entrySet().iterator().next()).getKey());
    }
  }
  
  private void s()
  {
    if (this.p1 != null) {
      return;
    }
    throw new IllegalStateException("cache is closed");
  }
  
  @TargetApi(26)
  private static void t(Writer paramWriter)
    throws IOException
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      paramWriter.close();
      return;
    }
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitUnbufferedIo().build());
    try
    {
      paramWriter.close();
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  private void u(c paramc, boolean paramBoolean)
    throws IOException
  {
    try
    {
      Object localObject = c.c(paramc);
      if (d.g((d)localObject) == paramc)
      {
        int i = 0;
        int j = i;
        if (paramBoolean)
        {
          j = i;
          if (!d.e((d)localObject))
          {
            for (int k = 0;; k++)
            {
              j = i;
              if (k >= this.z) {
                break label129;
              }
              if (c.d(paramc)[k] == 0) {
                break;
              }
              if (!((d)localObject).k(k).exists())
              {
                paramc.a();
                return;
              }
            }
            paramc.a();
            localObject = new java/lang/IllegalStateException;
            paramc = new java/lang/StringBuilder;
            paramc.<init>();
            paramc.append("Newly created entry didn't create value for index ");
            paramc.append(k);
            ((IllegalStateException)localObject).<init>(paramc.toString());
            throw ((Throwable)localObject);
          }
        }
        label129:
        long l2;
        while (j < this.z)
        {
          File localFile = ((d)localObject).k(j);
          if (paramBoolean)
          {
            if (localFile.exists())
            {
              paramc = ((d)localObject).j(j);
              localFile.renameTo(paramc);
              long l1 = d.a(localObject)[j];
              l2 = paramc.length();
              d.a((d)localObject)[j] = l2;
              this.p0 = (this.p0 - l1 + l2);
            }
          }
          else {
            w(localFile);
          }
          j++;
        }
        this.p3 += 1;
        d.h((d)localObject, null);
        if ((d.e((d)localObject) | paramBoolean))
        {
          d.f((d)localObject, true);
          this.p1.append("CLEAN");
          this.p1.append(' ');
          this.p1.append(d.b((d)localObject));
          this.p1.append(((d)localObject).l());
          this.p1.append('\n');
          if (paramBoolean)
          {
            l2 = this.H3;
            this.H3 = (1L + l2);
            d.d((d)localObject, l2);
          }
        }
        else
        {
          this.p2.remove(d.b((d)localObject));
          this.p1.append("REMOVE");
          this.p1.append(' ');
          this.p1.append(d.b((d)localObject));
          this.p1.append('\n');
        }
        z(this.p1);
        if ((this.p0 > this.y) || (B())) {
          this.I3.submit(this.J3);
        }
        return;
      }
      paramc = new java/lang/IllegalStateException;
      paramc.<init>();
      throw paramc;
    }
    finally {}
  }
  
  private static void w(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private c y(String paramString, long paramLong)
    throws IOException
  {
    try
    {
      s();
      d locald = (d)this.p2.get(paramString);
      if (paramLong != -1L) {
        if (locald != null)
        {
          long l = d.c(locald);
          if (l == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      if (locald == null)
      {
        locald = new com/bumptech/glide/k/a$d;
        locald.<init>(this, paramString, null);
        this.p2.put(paramString, locald);
      }
      else
      {
        localc = d.g(locald);
        if (localc != null) {
          return null;
        }
      }
      c localc = new com/bumptech/glide/k/a$c;
      localc.<init>(this, locald, null);
      d.h(locald, localc);
      this.p1.append("DIRTY");
      this.p1.append(' ');
      this.p1.append(paramString);
      this.p1.append('\n');
      z(this.p1);
      return localc;
    }
    finally {}
  }
  
  @TargetApi(26)
  private static void z(Writer paramWriter)
    throws IOException
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      paramWriter.flush();
      return;
    }
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitUnbufferedIo().build());
    try
    {
      paramWriter.flush();
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  public e A(String paramString)
    throws IOException
  {
    try
    {
      s();
      d locald = (d)this.p2.get(paramString);
      if (locald == null) {
        return null;
      }
      boolean bool = d.e(locald);
      if (!bool) {
        return null;
      }
      File[] arrayOfFile = locald.c;
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        bool = arrayOfFile[j].exists();
        if (!bool) {
          return null;
        }
      }
      this.p3 += 1;
      this.p1.append("READ");
      this.p1.append(' ');
      this.p1.append(paramString);
      this.p1.append('\n');
      if (B()) {
        this.I3.submit(this.J3);
      }
      paramString = new e(paramString, d.c(locald), locald.c, d.a(locald), null);
      return paramString;
    }
    finally {}
  }
  
  public boolean H(String paramString)
    throws IOException
  {
    try
    {
      s();
      Object localObject = (d)this.p2.get(paramString);
      int i = 0;
      if ((localObject != null) && (d.g((d)localObject) == null))
      {
        while (i < this.z)
        {
          File localFile = ((d)localObject).j(i);
          if ((localFile.exists()) && (!localFile.delete()))
          {
            paramString = new java/io/IOException;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            ((StringBuilder)localObject).append("failed to delete ");
            ((StringBuilder)localObject).append(localFile);
            paramString.<init>(((StringBuilder)localObject).toString());
            throw paramString;
          }
          this.p0 -= d.a(localObject)[i];
          d.a((d)localObject)[i] = 0L;
          i++;
        }
        this.p3 += 1;
        this.p1.append("REMOVE");
        this.p1.append(' ');
        this.p1.append(paramString);
        this.p1.append('\n');
        this.p2.remove(paramString);
        if (B()) {
          this.I3.submit(this.J3);
        }
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void close()
    throws IOException
  {
    try
    {
      Object localObject1 = this.p1;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>(this.p2.values());
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (d)localIterator.next();
        if (d.g((d)localObject1) != null) {
          d.g((d)localObject1).a();
        }
      }
      J();
      t(this.p1);
      this.p1 = null;
      return;
    }
    finally {}
  }
  
  public void v()
    throws IOException
  {
    close();
    c.b(this.c);
  }
  
  public c x(String paramString)
    throws IOException
  {
    return y(paramString, -1L);
  }
  
  class a
    implements Callable<Void>
  {
    a() {}
    
    public Void a()
      throws Exception
    {
      synchronized (a.this)
      {
        if (a.a(a.this) == null) {
          return null;
        }
        a.e(a.this);
        if (a.j(a.this))
        {
          a.k(a.this);
          a.l(a.this, 0);
        }
        return null;
      }
    }
  }
  
  private static final class b
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      try
      {
        Thread localThread = new java/lang/Thread;
        localThread.<init>(paramRunnable, "glide-disk-lru-cache-thread");
        localThread.setPriority(1);
        return localThread;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
  
  public final class c
  {
    private final a.d a;
    private final boolean[] b;
    private boolean c;
    
    private c(a.d paramd)
    {
      this.a = paramd;
      if (a.d.e(paramd)) {
        this$1 = null;
      } else {
        this$1 = new boolean[a.c(a.this)];
      }
      this.b = a.this;
    }
    
    public void a()
      throws IOException
    {
      a.i(a.this, this, false);
    }
    
    public void b()
    {
      if (!this.c) {}
      try
      {
        a();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    public void e()
      throws IOException
    {
      a.i(a.this, this, true);
      this.c = true;
    }
    
    public File f(int paramInt)
      throws IOException
    {
      synchronized (a.this)
      {
        if (a.d.g(this.a) == this)
        {
          if (!a.d.e(this.a)) {
            this.b[paramInt] = true;
          }
          localObject1 = this.a.k(paramInt);
          a.g(a.this).mkdirs();
          return (File)localObject1;
        }
        Object localObject1 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject1).<init>();
        throw ((Throwable)localObject1);
      }
    }
  }
  
  private final class d
  {
    private final String a;
    private final long[] b;
    File[] c;
    File[] d;
    private boolean e;
    private a.c f;
    private long g;
    
    private d(String paramString)
    {
      this.a = paramString;
      this.b = new long[a.c(a.this)];
      this.c = new File[a.c(a.this)];
      this.d = new File[a.c(a.this)];
      paramString = new StringBuilder(paramString);
      paramString.append('.');
      int i = paramString.length();
      for (int j = 0; j < a.c(a.this); j++)
      {
        paramString.append(j);
        this.c[j] = new File(a.g(a.this), paramString.toString());
        paramString.append(".tmp");
        this.d[j] = new File(a.g(a.this), paramString.toString());
        paramString.setLength(i);
      }
    }
    
    private IOException m(String[] paramArrayOfString)
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unexpected journal line: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      throw new IOException(localStringBuilder.toString());
    }
    
    private void n(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length == a.c(a.this))
      {
        int i = 0;
        try
        {
          while (i < paramArrayOfString.length)
          {
            this.b[i] = Long.parseLong(paramArrayOfString[i]);
            i++;
          }
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw m(paramArrayOfString);
        }
      }
      throw m(paramArrayOfString);
    }
    
    public File j(int paramInt)
    {
      return this.c[paramInt];
    }
    
    public File k(int paramInt)
    {
      return this.d[paramInt];
    }
    
    public String l()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (long l : this.b)
      {
        localStringBuilder.append(' ');
        localStringBuilder.append(l);
      }
      return localStringBuilder.toString();
    }
  }
  
  public final class e
  {
    private final String a;
    private final long b;
    private final long[] c;
    private final File[] d;
    
    private e(String paramString, long paramLong, File[] paramArrayOfFile, long[] paramArrayOfLong)
    {
      this.a = paramString;
      this.b = paramLong;
      this.d = paramArrayOfFile;
      this.c = paramArrayOfLong;
    }
    
    public File a(int paramInt)
    {
      return this.d[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */