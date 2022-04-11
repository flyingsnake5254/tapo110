package b.d.w.c.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.tplink.libtputility.log.tiny.bean.d;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class f
  extends Handler
{
  private static final String a = System.getProperty("line.separator");
  private final com.tplink.libtputility.security.a b;
  private final String c;
  private final String d;
  private final StringBuffer e;
  private final BlockingQueue<com.tplink.libtputility.log.tiny.bean.a> f;
  private final ExecutorService g;
  private int h;
  
  public f(Context paramContext, Looper paramLooper)
  {
    super(paramLooper);
    Object localObject = new byte[0];
    try
    {
      paramLooper = b.d.w.h.a.f(PlainEncryptKeyDelegate.b().getBytes("utf-8"));
    }
    catch (UnsupportedEncodingException paramLooper) {}catch (NoSuchAlgorithmException paramLooper) {}
    paramLooper.printStackTrace();
    paramLooper = (Looper)localObject;
    this.b = new com.tplink.libtputility.security.a(paramLooper, null, "AES");
    paramContext = paramContext.getApplicationContext().getCacheDir().getAbsolutePath();
    paramLooper = new StringBuilder();
    paramLooper.append(paramContext);
    paramContext = File.separator;
    paramLooper.append(paramContext);
    paramLooper.append("tiny_logger");
    paramLooper = paramLooper.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLooper);
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("snap");
    this.c = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLooper);
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("block");
    this.d = ((StringBuilder)localObject).toString();
    this.f = new LinkedBlockingQueue();
    this.e = new StringBuffer(2048002);
    paramContext = Executors.newFixedThreadPool(1, new a());
    this.g = paramContext;
    paramContext.execute(new c(this));
  }
  
  private void a(d paramd)
  {
    if ((paramd != null) && (paramd.b() != null))
    {
      if (paramd.b().length() >= 1024000 - this.e.length())
      {
        Object localObject;
        try
        {
          com.tplink.libtputility.log.tiny.bean.a locala = new com/tplink/libtputility/log/tiny/bean/a;
          locala.<init>(this.e.toString());
        }
        catch (Exception localException)
        {
          localObject = null;
        }
        if (localObject != null)
        {
          l((com.tplink.libtputility.log.tiny.bean.a)localObject);
          ((com.tplink.libtputility.log.tiny.bean.a)localObject).j(this.d);
          if ((this.h - 2048000 > 0) && (this.f.size() > 2)) {
            f(2);
          }
          b.d.w.b.b.c(new File(this.c, "logs_snap.dat"));
          localObject = this.e;
          ((StringBuffer)localObject).delete(0, ((StringBuffer)localObject).length());
        }
      }
      p(paramd);
    }
  }
  
  private File c()
  {
    b.d.w.b.b.d(this.c);
    return new File(this.c, "logs_snap.dat");
  }
  
  private String d(String paramString)
    throws Exception
  {
    paramString = Base64.decode(paramString, 2);
    return new String(b.d.w.h.a.e(this.b.b(paramString)), "UTF-8");
  }
  
  private String e(String paramString)
    throws Exception
  {
    paramString = b.d.w.h.a.d(paramString.getBytes("UTF-8"));
    return new String(Base64.encode(this.b.d(paramString), 2), "UTF-8");
  }
  
  private void f(int paramInt)
  {
    if (paramInt <= this.f.size()) {
      for (int i = 0; i < paramInt; i++) {
        m();
      }
    }
  }
  
  private void l(com.tplink.libtputility.log.tiny.bean.a parama)
  {
    this.f.offer(parama);
    this.h += parama.g();
  }
  
  private void m()
  {
    com.tplink.libtputility.log.tiny.bean.a locala = (com.tplink.libtputility.log.tiny.bean.a)this.f.poll();
    if (locala != null)
    {
      this.h -= locala.g();
      b.d.w.b.b.c(new File(this.d, locala.f()));
    }
  }
  
  private void n()
  {
    Object localObject = new File(this.d);
    if ((((File)localObject).exists()) && (!((File)localObject).isFile()))
    {
      localObject = b.d.w.b.b.f(((File)localObject).listFiles()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tplink.libtputility.log.tiny.bean.a locala = com.tplink.libtputility.log.tiny.bean.a.d((File)((Iterator)localObject).next());
        if (locala != null) {
          l(locala);
        }
      }
    }
    o();
  }
  
  /* Error */
  private void o()
  {
    // Byte code:
    //   0: ldc_w 315
    //   3: astore_1
    //   4: aload_1
    //   5: astore_2
    //   6: new 317	java/io/FileReader
    //   9: astore_3
    //   10: aload_1
    //   11: astore_2
    //   12: aload_3
    //   13: aload_0
    //   14: invokespecial 319	b/d/w/c/c/f:c	()Ljava/io/File;
    //   17: invokespecial 322	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   20: aload_1
    //   21: astore 4
    //   23: new 324	java/io/BufferedReader
    //   26: astore_2
    //   27: aload_1
    //   28: astore 4
    //   30: aload_2
    //   31: aload_3
    //   32: invokespecial 327	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: new 92	java/lang/StringBuilder
    //   38: astore 4
    //   40: aload 4
    //   42: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   45: aload_2
    //   46: invokevirtual 330	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +18 -> 71
    //   56: aload 4
    //   58: aload_0
    //   59: aload 5
    //   61: invokespecial 332	b/d/w/c/c/f:d	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -23 -> 45
    //   71: aload 4
    //   73: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore 5
    //   78: aload 5
    //   80: astore 4
    //   82: aload_2
    //   83: invokevirtual 335	java/io/BufferedReader:close	()V
    //   86: aload 5
    //   88: astore_2
    //   89: aload_3
    //   90: invokevirtual 336	java/io/FileReader:close	()V
    //   93: aload 5
    //   95: astore_2
    //   96: goto +60 -> 156
    //   99: astore 5
    //   101: aload 5
    //   103: athrow
    //   104: astore 6
    //   106: aload_2
    //   107: invokevirtual 335	java/io/BufferedReader:close	()V
    //   110: goto +13 -> 123
    //   113: astore_2
    //   114: aload_1
    //   115: astore 4
    //   117: aload 5
    //   119: aload_2
    //   120: invokevirtual 342	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: aload_1
    //   124: astore 4
    //   126: aload 6
    //   128: athrow
    //   129: astore_1
    //   130: aload_1
    //   131: athrow
    //   132: astore 5
    //   134: aload_3
    //   135: invokevirtual 336	java/io/FileReader:close	()V
    //   138: goto +12 -> 150
    //   141: astore_3
    //   142: aload 4
    //   144: astore_2
    //   145: aload_1
    //   146: aload_3
    //   147: invokevirtual 342	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   150: aload 4
    //   152: astore_2
    //   153: aload 5
    //   155: athrow
    //   156: aload_0
    //   157: getfield 127	b/d/w/c/c/f:e	Ljava/lang/StringBuffer;
    //   160: aload_2
    //   161: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: return
    //   166: astore 4
    //   168: goto -12 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	f
    //   3	121	1	str1	String
    //   129	17	1	localObject1	Object
    //   5	102	2	localObject2	Object
    //   113	7	2	localThrowable1	Throwable
    //   144	17	2	localObject3	Object
    //   9	126	3	localFileReader	java.io.FileReader
    //   141	6	3	localThrowable2	Throwable
    //   21	130	4	localObject4	Object
    //   166	1	4	localException	Exception
    //   49	45	5	str2	String
    //   99	19	5	localObject5	Object
    //   132	22	5	localObject6	Object
    //   104	23	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   35	45	99	finally
    //   45	51	99	finally
    //   56	68	99	finally
    //   71	78	99	finally
    //   101	104	104	finally
    //   106	110	113	finally
    //   23	27	129	finally
    //   30	35	129	finally
    //   82	86	129	finally
    //   117	123	129	finally
    //   126	129	129	finally
    //   130	132	132	finally
    //   134	138	141	finally
    //   6	10	166	java/lang/Exception
    //   12	20	166	java/lang/Exception
    //   89	93	166	java/lang/Exception
    //   145	150	166	java/lang/Exception
    //   153	156	166	java/lang/Exception
  }
  
  /* Error */
  private void p(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	b/d/w/c/c/f:e	Ljava/lang/StringBuffer;
    //   4: aload_1
    //   5: invokevirtual 151	com/tplink/libtputility/log/tiny/bean/d:b	()Ljava/lang/String;
    //   8: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   11: pop
    //   12: new 347	java/io/FileWriter
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: invokespecial 319	b/d/w/c/c/f:c	()Ljava/io/File;
    //   21: iconst_1
    //   22: invokespecial 350	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 351	com/tplink/libtputility/log/tiny/bean/d:a	()Ljava/lang/String;
    //   30: invokevirtual 354	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   33: pop
    //   34: aload_2
    //   35: invokevirtual 357	java/io/FileWriter:flush	()V
    //   38: aload_2
    //   39: invokevirtual 358	java/io/FileWriter:close	()V
    //   42: goto +22 -> 64
    //   45: astore_3
    //   46: aload_3
    //   47: athrow
    //   48: astore_1
    //   49: aload_2
    //   50: invokevirtual 358	java/io/FileWriter:close	()V
    //   53: goto +9 -> 62
    //   56: astore_2
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 342	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   62: aload_1
    //   63: athrow
    //   64: return
    //   65: astore_1
    //   66: goto -2 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	f
    //   0	69	1	paramd	d
    //   15	35	2	localFileWriter	java.io.FileWriter
    //   56	3	2	localThrowable	Throwable
    //   45	13	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	38	45	finally
    //   46	48	48	finally
    //   49	53	56	finally
    //   12	25	65	java/lang/Exception
    //   38	42	65	java/lang/Exception
    //   57	62	65	java/lang/Exception
    //   62	64	65	java/lang/Exception
  }
  
  public Future<String> b()
  {
    return this.g.submit(new b(this));
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (String)paramMessage.obj;
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(e(paramMessage));
      ((StringBuilder)localObject).append(a);
      localObject = ((StringBuilder)localObject).toString();
      ExecutorService localExecutorService = this.g;
      a locala = new b/d/w/c/c/a;
      locala.<init>(this, (String)localObject, paramMessage);
      localExecutorService.execute(locala);
      return;
    }
    catch (Exception paramMessage)
    {
      for (;;) {}
    }
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pool-tinyLogCache.executorService-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\c\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */