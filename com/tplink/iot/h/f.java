package com.tplink.iot.h;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tplink.iot.h.i.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f
{
  private static int a;
  private static int b;
  private static long c;
  private final String d = f.class.getSimpleName();
  private com.tplink.iot.h.i.b e;
  private String f;
  private String g;
  private String h;
  private long i;
  private long j;
  private float k;
  private boolean l;
  private String m;
  private int n;
  private boolean o;
  private int p;
  private int q;
  private Timer r;
  private ExecutorService s;
  private b.d.y.a t;
  private Handler u;
  
  public f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.d.q.b.p.b.h());
    String str = File.separator;
    localStringBuilder.append(str);
    localStringBuilder.append("cloudvideo");
    localStringBuilder.append(str);
    localStringBuilder.append("m3u8TempDownload");
    localStringBuilder.append(str);
    this.f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.d.q.b.p.b.h());
    localStringBuilder.append(str);
    localStringBuilder.append("cloudvideo");
    localStringBuilder.append(str);
    localStringBuilder.append("download");
    localStringBuilder.append(str);
    this.g = localStringBuilder.toString();
    this.h = "";
    this.i = 0L;
    this.j = 0L;
    this.k = 0.0F;
    this.l = false;
    this.m = "0";
    this.n = 1;
    this.o = true;
    this.p = 1800000;
    this.q = 10000;
    this.u = new a();
    this.m = paramString;
  }
  
  private void A(String paramString1, String paramString2)
  {
    g.d().e(paramString1, paramString2, new b());
  }
  
  private void D(Throwable paramThrowable)
  {
    if (!"Task running".equals(paramThrowable.getMessage())) {
      G();
    }
    if ("thread interrupted".equals(paramThrowable.getMessage())) {
      return;
    }
    Message localMessage = this.u.obtainMessage();
    localMessage.obj = paramThrowable;
    localMessage.what = 1001;
    this.u.sendMessage(localMessage);
  }
  
  private void F(final com.tplink.iot.h.h.a parama)
  {
    if (parama == null)
    {
      D(new Throwable("M3U8 is invalid"));
      return;
    }
    final File localFile = new File(this.f);
    if (!localFile.exists()) {
      localFile.mkdirs();
    } else {
      com.tplink.iot.h.j.a.b(localFile);
    }
    b = parama.c().size();
    Object localObject = parama.c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tplink.iot.h.h.b localb = (com.tplink.iot.h.h.b)((Iterator)localObject).next();
      if (localb != null)
      {
        this.j += localb.b();
        this.k += localb.c();
      }
    }
    localObject = this.s;
    if ((localObject != null) && (((ExecutorService)localObject).isTerminated()))
    {
      this.s.shutdownNow();
      this.s = null;
    }
    this.s = Executors.newFixedThreadPool(this.n);
    parama.b();
    localObject = new Timer();
    this.r = ((Timer)localObject);
    ((Timer)localObject).schedule(new c(), 0L, 1000L);
    this.s.execute(new d(localFile, parama));
  }
  
  private void G()
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.r = null;
    }
    this.l = false;
    localObject = this.s;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdownNow();
    }
  }
  
  public String B()
  {
    Object localObject = this.h;
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(this.h);
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public int C(String paramString)
  {
    int i1 = 0;
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new android/media/MediaMetadataRetriever;
      localMediaMetadataRetriever.<init>();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      int i2 = i1;
      if (paramString != null) {
        if ("0".equals(paramString)) {
          i2 = i1;
        } else {
          i2 = Math.round(Float.parseFloat(paramString) / 1000.0F);
        }
      }
      return i2;
    }
    finally
    {
      b.d.w.c.a.e(this.d, Log.getStackTraceString(paramString));
    }
    return 0;
  }
  
  public boolean E()
  {
    return this.l;
  }
  
  public void y()
  {
    if (this.l) {
      D(new Throwable("Download task cancelled by user"));
    }
  }
  
  public void z(String paramString1, String paramString2, String paramString3, com.tplink.iot.h.i.b paramb)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      this.h = paramString1;
      this.e = paramb;
      if (!E()) {
        A(paramString2, paramString3);
      } else {
        D(new Throwable("Task running"));
      }
      return;
    }
    D(new Throwable("uuid invalid"));
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        break;
      case 1003: 
        if (f.q(f.this) != null) {
          f.q(f.this).cancel();
        }
        paramMessage = f.this;
        int i = paramMessage.C(paramMessage.B());
        int j = i;
        if (i == 0) {
          j = (int)Math.ceil(f.r(f.this));
        }
        f.a(f.this).b(200, j);
        break;
      case 1002: 
        f.a(f.this).a(f.b(f.this), f.m(f.this), f.o());
        break;
      case 1001: 
        f.a(f.this).onError((Throwable)paramMessage.obj);
      }
    }
  }
  
  class b
    implements c
  {
    b() {}
    
    public void c(final com.tplink.iot.h.h.a parama)
    {
      new a(parama).start();
    }
    
    public void onError(Throwable paramThrowable)
    {
      f.i(f.this, paramThrowable);
    }
    
    public void onStart()
    {
      f.a(f.this).onStart();
      f.x(f.this, true);
    }
    
    class a
      extends Thread
    {
      a(com.tplink.iot.h.h.a parama) {}
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   4: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   7: aload_0
        //   8: getfield 18	com/tplink/iot/h/f$b$a:c	Lcom/tplink/iot/h/h/a;
        //   11: invokestatic 103	com/tplink/iot/h/f:s	(Lcom/tplink/iot/h/f;Lcom/tplink/iot/h/h/a;)V
        //   14: aload_0
        //   15: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   18: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   21: invokestatic 107	com/tplink/iot/h/f:t	(Lcom/tplink/iot/h/f;)Ljava/util/concurrent/ExecutorService;
        //   24: ifnull +18 -> 42
        //   27: aload_0
        //   28: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   31: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   34: invokestatic 107	com/tplink/iot/h/f:t	(Lcom/tplink/iot/h/f;)Ljava/util/concurrent/ExecutorService;
        //   37: invokeinterface 112 1 0
        //   42: aload_0
        //   43: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   46: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   49: invokestatic 107	com/tplink/iot/h/f:t	(Lcom/tplink/iot/h/f;)Ljava/util/concurrent/ExecutorService;
        //   52: ifnull +30 -> 82
        //   55: aload_0
        //   56: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   59: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   62: invokestatic 107	com/tplink/iot/h/f:t	(Lcom/tplink/iot/h/f;)Ljava/util/concurrent/ExecutorService;
        //   65: invokeinterface 116 1 0
        //   70: ifne +12 -> 82
        //   73: ldc2_w 117
        //   76: invokestatic 122	java/lang/Thread:sleep	(J)V
        //   79: goto -37 -> 42
        //   82: aload_0
        //   83: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   86: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   89: astore_1
        //   90: new 124	b/d/y/a
        //   93: astore_2
        //   94: aload_2
        //   95: invokespecial 125	b/d/y/a:<init>	()V
        //   98: aload_1
        //   99: aload_2
        //   100: invokestatic 129	com/tplink/iot/h/f:v	(Lcom/tplink/iot/h/f;Lb/d/y/a;)Lb/d/y/a;
        //   103: pop
        //   104: aload_0
        //   105: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   108: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   111: invokestatic 132	com/tplink/iot/h/f:w	(Lcom/tplink/iot/h/f;)Z
        //   114: ifeq +320 -> 434
        //   117: new 29	java/lang/StringBuilder
        //   120: astore_1
        //   121: aload_1
        //   122: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   125: aload_1
        //   126: aload_0
        //   127: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   130: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   133: invokestatic 134	com/tplink/iot/h/f:c	(Lcom/tplink/iot/h/f;)Ljava/lang/String;
        //   136: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: pop
        //   140: aload_1
        //   141: aload_0
        //   142: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   145: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   148: invokestatic 136	com/tplink/iot/h/f:d	(Lcom/tplink/iot/h/f;)Ljava/lang/String;
        //   151: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   154: pop
        //   155: aload_1
        //   156: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   159: astore_1
        //   160: aload_1
        //   161: invokestatic 140	b/d/q/b/l:d	(Ljava/lang/String;)V
        //   164: new 29	java/lang/StringBuilder
        //   167: astore_2
        //   168: aload_2
        //   169: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   172: aload_2
        //   173: aload_0
        //   174: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   177: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   180: invokestatic 77	com/tplink/iot/h/f:e	(Lcom/tplink/iot/h/f;)Ljava/lang/String;
        //   183: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   186: pop
        //   187: aload_2
        //   188: ldc -114
        //   190: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   193: pop
        //   194: aload_2
        //   195: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   198: astore_2
        //   199: aload_0
        //   200: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   203: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   206: invokestatic 146	com/tplink/iot/h/f:u	(Lcom/tplink/iot/h/f;)Lb/d/y/a;
        //   209: astore_3
        //   210: new 74	java/io/File
        //   213: astore 4
        //   215: aload 4
        //   217: aload_2
        //   218: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
        //   221: new 74	java/io/File
        //   224: astore 5
        //   226: aload 5
        //   228: aload_1
        //   229: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
        //   232: new 148	com/tplink/iot/h/a
        //   235: astore 6
        //   237: aload 6
        //   239: aload_0
        //   240: aload_2
        //   241: invokespecial 151	com/tplink/iot/h/a:<init>	(Lcom/tplink/iot/h/f$b$a;Ljava/lang/String;)V
        //   244: new 153	com/tplink/iot/h/e
        //   247: astore 7
        //   249: aload 7
        //   251: aload_0
        //   252: invokespecial 156	com/tplink/iot/h/e:<init>	(Lcom/tplink/iot/h/f$b$a;)V
        //   255: new 158	com/tplink/iot/h/d
        //   258: astore 8
        //   260: aload 8
        //   262: aload_0
        //   263: invokespecial 159	com/tplink/iot/h/d:<init>	(Lcom/tplink/iot/h/f$b$a;)V
        //   266: new 161	com/tplink/iot/h/b
        //   269: astore 9
        //   271: aload 9
        //   273: aload_0
        //   274: invokespecial 162	com/tplink/iot/h/b:<init>	(Lcom/tplink/iot/h/f$b$a;)V
        //   277: aload_3
        //   278: aload 4
        //   280: aload 5
        //   282: bipush 10
        //   284: aload 6
        //   286: aload 7
        //   288: aload 8
        //   290: aload 9
        //   292: invokevirtual 165	b/d/y/a:h	(Ljava/io/File;Ljava/io/File;ILkotlin/jvm/b/a;Lkotlin/jvm/b/a;Lkotlin/jvm/b/l;Lkotlin/jvm/b/a;)V
        //   295: goto +139 -> 434
        //   298: astore 7
        //   300: aload_0
        //   301: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   304: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   307: invokestatic 167	com/tplink/iot/h/f:f	(Lcom/tplink/iot/h/f;)Ljava/lang/String;
        //   310: aload 7
        //   312: invokestatic 173	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   315: invokestatic 178	b/d/w/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   318: new 74	java/io/File
        //   321: astore 7
        //   323: aload 7
        //   325: aload_1
        //   326: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
        //   329: aload 7
        //   331: invokevirtual 181	java/io/File:exists	()Z
        //   334: ifeq +9 -> 343
        //   337: aload 7
        //   339: invokevirtual 184	java/io/File:delete	()Z
        //   342: pop
        //   343: aload_2
        //   344: aload_1
        //   345: invokestatic 186	com/tplink/iot/h/j/a:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   348: aload_0
        //   349: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   352: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   355: invokestatic 72	com/tplink/iot/h/f:g	(Lcom/tplink/iot/h/f;)Z
        //   358: ifeq +32 -> 390
        //   361: aload_0
        //   362: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   365: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   368: invokestatic 56	com/tplink/iot/h/f:h	(Lcom/tplink/iot/h/f;)Landroid/os/Handler;
        //   371: astore_1
        //   372: new 188	com/tplink/iot/h/c
        //   375: astore_2
        //   376: aload_2
        //   377: aload_0
        //   378: invokespecial 189	com/tplink/iot/h/c:<init>	(Lcom/tplink/iot/h/f$b$a;)V
        //   381: aload_1
        //   382: aload_2
        //   383: ldc2_w 190
        //   386: invokevirtual 195	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
        //   389: pop
        //   390: aload_0
        //   391: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   394: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   397: invokestatic 56	com/tplink/iot/h/f:h	(Lcom/tplink/iot/h/f;)Landroid/os/Handler;
        //   400: sipush 1003
        //   403: invokevirtual 62	android/os/Handler:sendEmptyMessage	(I)Z
        //   406: pop
        //   407: aload_0
        //   408: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   411: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   414: iconst_0
        //   415: invokestatic 69	com/tplink/iot/h/f:x	(Lcom/tplink/iot/h/f;Z)Z
        //   418: pop
        //   419: goto +15 -> 434
        //   422: astore_1
        //   423: aload_0
        //   424: getfield 16	com/tplink/iot/h/f$b$a:d	Lcom/tplink/iot/h/f$b;
        //   427: getfield 27	com/tplink/iot/h/f$b:a	Lcom/tplink/iot/h/f;
        //   430: aload_1
        //   431: invokestatic 51	com/tplink/iot/h/f:i	(Lcom/tplink/iot/h/f;Ljava/lang/Throwable;)V
        //   434: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	435	0	this	a
        //   89	293	1	localObject1	Object
        //   422	9	1	localInterruptedException	InterruptedException
        //   93	290	2	localObject2	Object
        //   209	69	3	locala	b.d.y.a
        //   213	66	4	localFile1	File
        //   224	57	5	localFile2	File
        //   235	50	6	locala1	a
        //   247	40	7	locale	e
        //   298	13	7	localThrowable	Throwable
        //   321	17	7	localFile3	File
        //   258	31	8	locald	d
        //   269	22	9	localb	b
        // Exception table:
        //   from	to	target	type
        //   199	295	298	finally
        //   0	42	422	java/lang/InterruptedException
        //   42	79	422	java/lang/InterruptedException
        //   82	199	422	java/lang/InterruptedException
        //   300	343	422	java/lang/InterruptedException
        //   343	390	422	java/lang/InterruptedException
        //   390	419	422	java/lang/InterruptedException
      }
    }
  }
  
  class c
    extends TimerTask
  {
    c() {}
    
    public void run()
    {
      f.h(f.this).sendEmptyMessage(1002);
    }
  }
  
  class d
    implements Runnable
  {
    d(File paramFile, com.tplink.iot.h.h.a parama) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: new 36	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   7: astore_1
      //   8: aload_1
      //   9: aload_0
      //   10: getfield 23	com/tplink/iot/h/f$d:c	Ljava/io/File;
      //   13: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   16: pop
      //   17: aload_1
      //   18: getstatic 47	java/io/File:separator	Ljava/lang/String;
      //   21: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: pop
      //   25: aload_1
      //   26: ldc 52
      //   28: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   31: pop
      //   32: new 43	java/io/File
      //   35: dup
      //   36: aload_1
      //   37: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
      //   43: astore_2
      //   44: aload_2
      //   45: invokevirtual 63	java/io/File:exists	()Z
      //   48: ifeq +8 -> 56
      //   51: aload_2
      //   52: invokevirtual 66	java/io/File:delete	()Z
      //   55: pop
      //   56: aconst_null
      //   57: astore_3
      //   58: aconst_null
      //   59: astore_1
      //   60: aload_0
      //   61: getfield 25	com/tplink/iot/h/f$d:d	Lcom/tplink/iot/h/h/a;
      //   64: invokevirtual 71	com/tplink/iot/h/h/a:b	()Ljava/lang/String;
      //   67: astore 4
      //   69: new 73	java/net/URL
      //   72: astore 5
      //   74: aload 5
      //   76: aload 4
      //   78: invokespecial 74	java/net/URL:<init>	(Ljava/lang/String;)V
      //   81: aload 5
      //   83: invokevirtual 78	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   86: checkcast 80	java/net/HttpURLConnection
      //   89: astore 6
      //   91: aload 6
      //   93: aload_0
      //   94: getfield 21	com/tplink/iot/h/f$d:f	Lcom/tplink/iot/h/f;
      //   97: invokestatic 84	com/tplink/iot/h/f:j	(Lcom/tplink/iot/h/f;)I
      //   100: invokevirtual 88	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   103: aload 6
      //   105: aload_0
      //   106: getfield 21	com/tplink/iot/h/f$d:f	Lcom/tplink/iot/h/f;
      //   109: invokestatic 91	com/tplink/iot/h/f:k	(Lcom/tplink/iot/h/f;)I
      //   112: invokevirtual 94	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   115: aload 6
      //   117: invokevirtual 98	java/net/HttpURLConnection:getResponseCode	()I
      //   120: sipush 200
      //   123: if_icmpne +165 -> 288
      //   126: aload 6
      //   128: invokevirtual 102	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   131: astore_1
      //   132: new 104	java/io/FileOutputStream
      //   135: astore 4
      //   137: aload 4
      //   139: aload_2
      //   140: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   143: aload_1
      //   144: astore_3
      //   145: aload 4
      //   147: astore 5
      //   149: ldc 108
      //   151: newarray <illegal type>
      //   153: astore 7
      //   155: aload_1
      //   156: astore_3
      //   157: aload 4
      //   159: astore 5
      //   161: aload_1
      //   162: aload 7
      //   164: invokevirtual 114	java/io/InputStream:read	([B)I
      //   167: istore 8
      //   169: iload 8
      //   171: iconst_m1
      //   172: if_icmpeq +55 -> 227
      //   175: aload_1
      //   176: astore_3
      //   177: aload 4
      //   179: astore 5
      //   181: aload_0
      //   182: getfield 21	com/tplink/iot/h/f$d:f	Lcom/tplink/iot/h/f;
      //   185: astore 6
      //   187: aload_1
      //   188: astore_3
      //   189: aload 4
      //   191: astore 5
      //   193: aload 6
      //   195: aload 6
      //   197: invokestatic 118	com/tplink/iot/h/f:m	(Lcom/tplink/iot/h/f;)J
      //   200: iload 8
      //   202: i2l
      //   203: ladd
      //   204: invokestatic 122	com/tplink/iot/h/f:n	(Lcom/tplink/iot/h/f;J)J
      //   207: pop2
      //   208: aload_1
      //   209: astore_3
      //   210: aload 4
      //   212: astore 5
      //   214: aload 4
      //   216: aload 7
      //   218: iconst_0
      //   219: iload 8
      //   221: invokevirtual 126	java/io/FileOutputStream:write	([BII)V
      //   224: goto -69 -> 155
      //   227: goto +95 -> 322
      //   230: astore 6
      //   232: aload_1
      //   233: astore 7
      //   235: aload 4
      //   237: astore_1
      //   238: goto +128 -> 366
      //   241: astore 6
      //   243: aload_1
      //   244: astore 7
      //   246: aload 4
      //   248: astore_1
      //   249: goto +161 -> 410
      //   252: astore 4
      //   254: aconst_null
      //   255: astore 5
      //   257: goto +207 -> 464
      //   260: astore 6
      //   262: aconst_null
      //   263: astore 4
      //   265: aload_1
      //   266: astore 7
      //   268: aload 4
      //   270: astore_1
      //   271: goto +95 -> 366
      //   274: astore 6
      //   276: aconst_null
      //   277: astore 4
      //   279: aload_1
      //   280: astore 7
      //   282: aload 4
      //   284: astore_1
      //   285: goto +125 -> 410
      //   288: aload_0
      //   289: getfield 21	com/tplink/iot/h/f$d:f	Lcom/tplink/iot/h/f;
      //   292: astore 5
      //   294: new 128	java/lang/Throwable
      //   297: astore 4
      //   299: aload 4
      //   301: aload 6
      //   303: invokevirtual 98	java/net/HttpURLConnection:getResponseCode	()I
      //   306: invokestatic 134	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   309: invokespecial 135	java/lang/Throwable:<init>	(Ljava/lang/String;)V
      //   312: aload 5
      //   314: aload 4
      //   316: invokestatic 139	com/tplink/iot/h/f:i	(Lcom/tplink/iot/h/f;Ljava/lang/Throwable;)V
      //   319: aconst_null
      //   320: astore 4
      //   322: aload_1
      //   323: ifnull +11 -> 334
      //   326: aload_1
      //   327: invokevirtual 142	java/io/InputStream:close	()V
      //   330: goto +4 -> 334
      //   333: astore_1
      //   334: aload 4
      //   336: ifnull +111 -> 447
      //   339: aload 4
      //   341: astore_1
      //   342: aload_1
      //   343: invokevirtual 143	java/io/FileOutputStream:close	()V
      //   346: goto +101 -> 447
      //   349: astore 4
      //   351: aconst_null
      //   352: astore 5
      //   354: aload_3
      //   355: astore_1
      //   356: goto +108 -> 464
      //   359: astore 6
      //   361: aconst_null
      //   362: astore_1
      //   363: aload_1
      //   364: astore 7
      //   366: aload 7
      //   368: astore_3
      //   369: aload_1
      //   370: astore 5
      //   372: aload_0
      //   373: getfield 21	com/tplink/iot/h/f$d:f	Lcom/tplink/iot/h/f;
      //   376: aload 6
      //   378: invokestatic 139	com/tplink/iot/h/f:i	(Lcom/tplink/iot/h/f;Ljava/lang/Throwable;)V
      //   381: aload 7
      //   383: ifnull +13 -> 396
      //   386: aload 7
      //   388: invokevirtual 142	java/io/InputStream:close	()V
      //   391: goto +5 -> 396
      //   394: astore 4
      //   396: aload_1
      //   397: ifnull +50 -> 447
      //   400: goto -58 -> 342
      //   403: astore 6
      //   405: aconst_null
      //   406: astore_1
      //   407: aload_1
      //   408: astore 7
      //   410: aload 7
      //   412: astore_3
      //   413: aload_1
      //   414: astore 5
      //   416: aload_0
      //   417: getfield 21	com/tplink/iot/h/f$d:f	Lcom/tplink/iot/h/f;
      //   420: aload 6
      //   422: invokestatic 139	com/tplink/iot/h/f:i	(Lcom/tplink/iot/h/f;Ljava/lang/Throwable;)V
      //   425: aload 7
      //   427: ifnull +13 -> 440
      //   430: aload 7
      //   432: invokevirtual 142	java/io/InputStream:close	()V
      //   435: goto +5 -> 440
      //   438: astore 4
      //   440: aload_1
      //   441: ifnull +6 -> 447
      //   444: goto -102 -> 342
      //   447: invokestatic 146	com/tplink/iot/h/f:p	()I
      //   450: pop
      //   451: aload_2
      //   452: invokevirtual 150	java/io/File:length	()J
      //   455: invokestatic 154	com/tplink/iot/h/f:l	(J)J
      //   458: pop2
      //   459: return
      //   460: astore 4
      //   462: aload_3
      //   463: astore_1
      //   464: aload_1
      //   465: ifnull +11 -> 476
      //   468: aload_1
      //   469: invokevirtual 142	java/io/InputStream:close	()V
      //   472: goto +4 -> 476
      //   475: astore_1
      //   476: aload 5
      //   478: ifnull +8 -> 486
      //   481: aload 5
      //   483: invokevirtual 143	java/io/FileOutputStream:close	()V
      //   486: aload 4
      //   488: athrow
      //   489: astore_1
      //   490: goto -43 -> 447
      //   493: astore_1
      //   494: goto -8 -> 486
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	497	0	this	d
      //   7	320	1	localObject1	Object
      //   333	1	1	localIOException1	java.io.IOException
      //   341	128	1	localObject2	Object
      //   475	1	1	localIOException2	java.io.IOException
      //   489	1	1	localIOException3	java.io.IOException
      //   493	1	1	localIOException4	java.io.IOException
      //   43	409	2	localFile	File
      //   57	406	3	localObject3	Object
      //   67	180	4	localObject4	Object
      //   252	1	4	localObject5	Object
      //   263	77	4	localThrowable	Throwable
      //   349	1	4	localObject6	Object
      //   394	1	4	localIOException5	java.io.IOException
      //   438	1	4	localIOException6	java.io.IOException
      //   460	27	4	localObject7	Object
      //   72	410	5	localObject8	Object
      //   89	107	6	localObject9	Object
      //   230	1	6	localIOException7	java.io.IOException
      //   241	1	6	localMalformedURLException1	java.net.MalformedURLException
      //   260	1	6	localIOException8	java.io.IOException
      //   274	28	6	localMalformedURLException2	java.net.MalformedURLException
      //   359	18	6	localIOException9	java.io.IOException
      //   403	18	6	localMalformedURLException3	java.net.MalformedURLException
      //   153	278	7	localObject10	Object
      //   167	53	8	i	int
      // Exception table:
      //   from	to	target	type
      //   149	155	230	java/io/IOException
      //   161	169	230	java/io/IOException
      //   181	187	230	java/io/IOException
      //   193	208	230	java/io/IOException
      //   214	224	230	java/io/IOException
      //   149	155	241	java/net/MalformedURLException
      //   161	169	241	java/net/MalformedURLException
      //   181	187	241	java/net/MalformedURLException
      //   193	208	241	java/net/MalformedURLException
      //   214	224	241	java/net/MalformedURLException
      //   132	143	252	finally
      //   132	143	260	java/io/IOException
      //   132	143	274	java/net/MalformedURLException
      //   326	330	333	java/io/IOException
      //   60	132	349	finally
      //   288	319	349	finally
      //   60	132	359	java/io/IOException
      //   288	319	359	java/io/IOException
      //   386	391	394	java/io/IOException
      //   60	132	403	java/net/MalformedURLException
      //   288	319	403	java/net/MalformedURLException
      //   430	435	438	java/io/IOException
      //   149	155	460	finally
      //   161	169	460	finally
      //   181	187	460	finally
      //   193	208	460	finally
      //   214	224	460	finally
      //   372	381	460	finally
      //   416	425	460	finally
      //   468	472	475	java/io/IOException
      //   342	346	489	java/io/IOException
      //   481	486	493	java/io/IOException
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */