package b.d.u;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.util.Log;
import androidx.annotation.NonNull;
import io.reactivex.q;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class l
  extends m
  implements AudioRecord.OnRecordPositionUpdateListener
{
  private static final String v = l.class.getSimpleName();
  private b A;
  private c B;
  private long C;
  private long D = 0L;
  private long E;
  private boolean F = false;
  private int G = 0;
  private int H = 0;
  private AudioRecord w = null;
  private com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> x;
  private LinkedBlockingQueue<com.tplink.libmediakit.media.audioprocess.a> y = new LinkedBlockingQueue();
  private final LinkedBlockingQueue<com.tplink.libmediakit.media.audioprocess.a> z = new LinkedBlockingQueue();
  
  public l(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    paramString2 = new com.tplink.libmediakit.media.audioprocess.b();
    this.x = paramString2;
    paramString2.m(this.y);
    this.x.l(8000);
    this.x.n(new b(this, paramString1));
    this.x.c(1);
    this.x.c(2);
    this.x.c(6);
    this.x.c(7);
  }
  
  private void F()
    throws Exception
  {
    int i = this.a;
    int j = this.j * i / 1000;
    this.g = j;
    this.h = (j * 2 * this.e * this.f / 8);
    i = AudioRecord.getMinBufferSize(i, this.b, this.c);
    if (this.h < i)
    {
      i = AudioRecord.getMinBufferSize(this.a, this.b, this.c);
      this.h = i;
      this.g = (i / (this.e * 2 * this.f / 8));
    }
    Object localObject = new AudioRecord(this.d, this.a, this.b, this.c, this.h);
    this.w = ((AudioRecord)localObject);
    if (((AudioRecord)localObject).getState() == 1)
    {
      this.i = (this.g * this.e * this.f / 8);
      this.B = new c();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AudioRecord initialization failed:");
    ((StringBuilder)localObject).append(this.w.getState());
    throw new Exception(((StringBuilder)localObject).toString());
  }
  
  private int G()
  {
    AudioRecord localAudioRecord = this.w;
    if ((localAudioRecord != null) && (localAudioRecord.getState() != 0))
    {
      this.w.release();
      this.w = null;
    }
    Log.d(v, "Audio recorder stopped");
    return 0;
  }
  
  private void H(com.tplink.libmediakit.media.audioprocess.a parama)
  {
    if (!this.s.get())
    {
      parama = parama.d;
      parama = b.d.e.c.b(parama, parama.length);
      if (this.u == 0L) {
        this.u = (System.currentTimeMillis() / 1000L * 90000L);
      }
      byte[] arrayOfByte = this.t.k(parama, parama.length, this.u);
      this.u += parama.length * 90000L / 8000L;
      com.tplink.libtpstreamclientmanager.m.V().S(this.k, arrayOfByte);
    }
  }
  
  private void J()
  {
    com.tplink.libtpstreamclientmanager.m.V().H0(this.k);
    if (this.m.get()) {
      return;
    }
    this.m.set(true);
    try
    {
      F();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.l.onDoubleTalkClose(this.k);
    }
    I();
  }
  
  private float t()
  {
    int i = this.G;
    int j = (i / 2 - this.H) / (i / 5);
    int k = 0;
    int m = 1;
    int i1;
    if (j != 1)
    {
      n = k;
      i = j;
      i1 = m;
      if (j != -1) {}
    }
    else
    {
      i = 0;
      i1 = m;
    }
    for (int n = k; n < (int)Math.log10(i); n++) {
      i1 *= 10;
    }
    i /= i1;
    float f;
    if (i > 0) {
      f = (float)(1.0D / Math.pow(2.0D, i));
    } else if (i < 0) {
      f = -i;
    } else {
      f = 1.0F;
    }
    return f;
  }
  
  public int I()
  {
    this.w.setRecordPositionUpdateListener(this);
    int i = this.a;
    int j = i / 100;
    this.C = (j * 1000L / i);
    this.w.setPositionNotificationPeriod(j);
    AudioRecord localAudioRecord = this.w;
    if ((localAudioRecord != null) && (localAudioRecord.getState() != 0)) {
      this.w.startRecording();
    }
    this.B.start();
    b.d.p.d.a(v, "Audio recorder start");
    return 0;
  }
  
  public int K()
  {
    this.m.set(false);
    Object localObject = this.w;
    if ((localObject != null) && (((AudioRecord)localObject).getState() != 0)) {
      this.w.stop();
    }
    localObject = this.B;
    if (localObject != null) {
      try
      {
        ((Thread)localObject).join();
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject = v;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localInterruptedException);
        Log.d((String)localObject, localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  public void a()
  {
    this.o.set(false);
    K();
    G();
    this.x.o();
    this.x.k(null);
    b localb = this.A;
    if (localb != null) {
      localb.c();
    }
    this.y.clear();
    this.l = null;
    com.tplink.libtpstreamclientmanager.m.V().u0(this.k);
    this.t.n();
  }
  
  public void b(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && ("aec".equals(this.q))) {
      this.y.offer(new com.tplink.libmediakit.media.audioprocess.a(this.k, paramLong, paramArrayOfByte));
    }
  }
  
  public void c()
  {
    if (this.o.get()) {
      return;
    }
    this.o.set(true);
    this.n = Executors.newFixedThreadPool(1, new a());
    com.tplink.libtpstreamclientmanager.m.V().P(this.k, this, this.q);
  }
  
  public void f(b.d.v.b.c paramc)
  {
    this.l = paramc;
  }
  
  public void g(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void i(int paramInt)
  {
    this.H = paramInt;
    com.tplink.libmediakit.media.audioprocess.b localb = this.x;
    if (localb != null) {
      localb.j(t());
    }
  }
  
  public void onDoubleTalkClose(String paramString)
  {
    q.f0(paramString).l0(io.reactivex.d0.b.a.a()).G0(new d(this));
  }
  
  public void onDoubleTalkCreateFailure(String paramString, int paramInt)
  {
    q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new f(this, paramString, paramInt));
  }
  
  public void onDoubleTalkCreateSuccess(String paramString)
  {
    if (this.o.get())
    {
      Object localObject = this.n;
      if ((localObject != null) && (!((ExecutorService)localObject).isShutdown()))
      {
        this.x.k(new e(this));
        if (this.A == null)
        {
          localObject = new b();
          this.A = ((b)localObject);
          ((b)localObject).b(this.n.submit((Callable)localObject));
        }
      }
    }
    q.f0(paramString).l0(io.reactivex.d0.b.a.a()).G0(new c(this));
    J();
  }
  
  public void onDoubleTalkSendDataFailure(String paramString, int paramInt, Exception paramException)
  {
    q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new a(this, paramString, paramInt));
  }
  
  public void onMarkerReached(AudioRecord paramAudioRecord) {}
  
  public void onPeriodicNotification(AudioRecord paramAudioRecord)
  {
    if (this.D == 0L)
    {
      long l = System.currentTimeMillis() - this.C;
      this.D = l;
      this.E = l;
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
      localStringBuilder.append("pool-AecDoubleTalkClient.speakerService-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
  
  private class b
    implements Callable<Boolean>
  {
    private boolean c = true;
    private Future<Boolean> d;
    
    public b() {}
    
    public Boolean a()
      throws Exception
    {
      while (this.c)
      {
        com.tplink.libmediakit.media.audioprocess.a locala = (com.tplink.libmediakit.media.audioprocess.a)l.o(l.this).take();
        if ((locala.d != null) && (l.s(l.this) != null)) {
          l.s(l.this).i(locala);
        }
      }
      return Boolean.TRUE;
    }
    
    public void b(Future<Boolean> paramFuture)
    {
      this.d = paramFuture;
    }
    
    public void c()
    {
      this.c = false;
      l.o(l.this).clear();
      l.o(l.this).offer(new com.tplink.libmediakit.media.audioprocess.a());
      Future localFuture = this.d;
      if (localFuture != null)
      {
        localFuture.cancel(true);
        this.d = null;
      }
    }
  }
  
  private class c
    extends Thread
  {
    public c()
    {
      super();
    }
    
    public void run()
    {
      byte[] arrayOfByte = new byte[l.this.i];
      Log.d(l.k(), "Recording...");
      while (l.this.m.get()) {
        if ((l.l(l.this) != null) && (l.l(l.this).getState() != 0) && (l.m(l.this) > 0L))
        {
          int i = l.l(l.this).read(arrayOfByte, 0, l.this.i);
          if (i > 0)
          {
            Object localObject1 = l.this;
            localObject1 = new com.tplink.libmediakit.media.audioprocess.a(((m)localObject1).k, l.m((l)localObject1), ByteBuffer.wrap(arrayOfByte, 0, i));
            l.o(l.this).offer(localObject1);
            localObject1 = l.this;
            long l = ((m)localObject1).i * 8L * 1000L / ((m)localObject1).f / ((m)localObject1).e / ((m)localObject1).a;
            if (!l.p((l)localObject1))
            {
              l.q(l.this, true);
              localObject2 = l.r(l.this);
              localObject1 = l.this;
              ((LinkedBlockingQueue)localObject2).offer(new com.tplink.libmediakit.media.audioprocess.a(((m)localObject1).k, l.m((l)localObject1) - 60L - l, (byte[])arrayOfByte.clone()));
            }
            localObject1 = l.this;
            Object localObject2 = ((m)localObject1).p;
            if (localObject2 != null) {
              ((n)localObject2).b(((m)localObject1).k, l.m((l)localObject1) - 60L);
            }
            l.n(l.this, l);
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\u\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */