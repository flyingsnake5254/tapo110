package b.d.u;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import androidx.annotation.NonNull;
import b.d.p.d;
import com.tplink.libmediakit.media.audioprocess.AudioProcessUtils;
import com.tplink.libmediakit.media.audioprocess.b;
import com.tplink.libtpmux.tsmux.e;
import io.reactivex.q;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class o
  extends m
  implements AudioRecord.OnRecordPositionUpdateListener
{
  private static final String v = o.class.getSimpleName();
  private e A;
  private short[] B;
  private short[] C;
  private Timer D;
  private int E;
  private AudioRecord w = null;
  private b<com.tplink.libmediakit.media.audioprocess.a> x;
  private final LinkedBlockingQueue<com.tplink.libmediakit.media.audioprocess.a> y = new LinkedBlockingQueue();
  private d z;
  
  public o(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    paramString1 = new short['Ȁ'];
    this.B = paramString1;
    Arrays.fill(paramString1, (short)-1);
    paramString1 = this.B;
    this.C = AudioProcessUtils.a(paramString1, paramString1.length);
    this.D = new Timer();
    this.E = 0;
    paramString1 = new b();
    this.x = paramString1;
    paramString1.l(8000);
    this.x.c(2);
    this.x.c(6);
    this.x.c(7);
  }
  
  private void A()
  {
    Timer localTimer = this.D;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.D = null;
    }
    this.E = -4;
    localTimer = new Timer();
    this.D = localTimer;
    localTimer.schedule(new c(), 0L, 1000L);
  }
  
  private void B(com.tplink.libmediakit.media.audioprocess.a parama)
  {
    if (this.r.get())
    {
      parama = parama.d;
      parama = b.d.e.c.b(parama, parama.length);
    }
    else
    {
      parama = o();
    }
    C(parama);
  }
  
  private void C(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (this.u == 0L) {
        this.u = (System.currentTimeMillis() / 1000L * 90000L);
      }
      byte[] arrayOfByte = this.t.k(paramArrayOfByte, paramArrayOfByte.length, this.u);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0))
      {
        this.u += paramArrayOfByte.length * 90000L / 8000L;
        com.tplink.libtpstreamclientmanager.m.V().S(this.k, arrayOfByte);
      }
    }
  }
  
  private void E()
  {
    com.tplink.libtpstreamclientmanager.m.V().H0(this.k);
    if (this.m.get()) {
      return;
    }
    this.m.set(true);
    try
    {
      y();
      this.D.schedule(new b(), 0L, 1000L);
      D();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.l.onDoubleTalkClose(this.k);
    }
  }
  
  private void y()
    throws Exception
  {
    int i = this.a;
    int j = this.j * i / 1000;
    this.g = j;
    this.h = (j * 2 * this.e * this.f / 8);
    j = AudioRecord.getMinBufferSize(i, this.b, this.c);
    if (this.h < j)
    {
      j = AudioRecord.getMinBufferSize(this.a, this.b, this.c);
      this.h = j;
      this.g = (j / (this.e * 2 * this.f / 8));
    }
    Object localObject = new AudioRecord(this.d, this.a, this.b, this.c, this.h);
    this.w = ((AudioRecord)localObject);
    if (((AudioRecord)localObject).getState() == 1)
    {
      this.i = (this.g * this.e * this.f / 8);
      this.A = new e();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AudioRecord initialization failed:");
    ((StringBuilder)localObject).append(this.w.getState());
    throw new Exception(((StringBuilder)localObject).toString());
  }
  
  private int z()
  {
    AudioRecord localAudioRecord = this.w;
    if ((localAudioRecord != null) && (localAudioRecord.getState() != 0))
    {
      this.w.release();
      this.w = null;
    }
    d.a(v, "Audio recorder stopped");
    return 0;
  }
  
  public int D()
  {
    Object localObject = this.w;
    if ((localObject != null) && (((AudioRecord)localObject).getState() != 0)) {
      this.w.startRecording();
    }
    localObject = this.A;
    if (localObject != null)
    {
      ((Thread)localObject).start();
      d.a(v, "Audio recorder start");
    }
    return 0;
  }
  
  public int F()
  {
    this.m.set(false);
    Object localObject = this.w;
    if ((localObject != null) && (((AudioRecord)localObject).getState() != 0)) {
      this.w.stop();
    }
    try
    {
      localObject = this.A;
      if (localObject != null) {
        ((Thread)localObject).join();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      String str = v;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(localInterruptedException);
      d.a(str, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  public void a()
  {
    this.o.set(false);
    this.D.cancel();
    this.E = 1;
    F();
    z();
    this.x.k(null);
    d locald = this.z;
    if (locald != null) {
      locald.c();
    }
    this.l = null;
    com.tplink.libtpstreamclientmanager.m.V().u0(this.k);
    this.t.n();
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
  
  public void d()
  {
    super.d();
    A();
  }
  
  public void f(b.d.v.b.c paramc)
  {
    this.l = paramc;
  }
  
  public void j()
  {
    super.j();
  }
  
  protected byte[] o()
  {
    short[] arrayOfShort = this.C;
    if (arrayOfShort != null)
    {
      int i = this.E;
      if (i < 0)
      {
        this.E = (i + 1);
        return b.d.e.c.f(arrayOfShort);
      }
      if (i % 6 == 0)
      {
        this.E = (i + 1);
        return b.d.e.c.f(arrayOfShort);
      }
    }
    return null;
  }
  
  public void onDoubleTalkClose(String paramString)
  {
    q.f0(paramString).l0(io.reactivex.d0.b.a.a()).G0(new k(this));
  }
  
  public void onDoubleTalkCreateFailure(String paramString, int paramInt)
  {
    q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new i(this, paramString, paramInt));
  }
  
  public void onDoubleTalkCreateSuccess(String paramString)
  {
    if (this.o.get())
    {
      Object localObject = this.n;
      if ((localObject != null) && (!((ExecutorService)localObject).isShutdown()))
      {
        this.x.k(new h(this));
        if (this.z == null)
        {
          localObject = new d();
          this.z = ((d)localObject);
          ((d)localObject).b(this.n.submit((Callable)localObject));
        }
      }
    }
    q.f0(paramString).l0(io.reactivex.d0.b.a.a()).G0(new j(this));
    E();
  }
  
  public void onDoubleTalkSendDataFailure(String paramString, int paramInt, Exception paramException)
  {
    q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new g(this, paramString, paramInt));
  }
  
  public void onMarkerReached(AudioRecord paramAudioRecord) {}
  
  public void onPeriodicNotification(AudioRecord paramAudioRecord) {}
  
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
  
  class b
    extends TimerTask
  {
    b() {}
    
    public void run()
    {
      o.k(o.this);
    }
  }
  
  class c
    extends TimerTask
  {
    c() {}
    
    public void run()
    {
      o.k(o.this);
    }
  }
  
  private class d
    implements Callable<Boolean>
  {
    private boolean c = true;
    private Future<Boolean> d;
    
    public d() {}
    
    public Boolean a()
      throws Exception
    {
      while (this.c)
      {
        com.tplink.libmediakit.media.audioprocess.a locala = (com.tplink.libmediakit.media.audioprocess.a)o.m(o.this).take();
        if ((locala.d != null) && (o.n(o.this) != null)) {
          o.n(o.this).i(locala);
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
      o.m(o.this).clear();
      o.m(o.this).offer(new com.tplink.libmediakit.media.audioprocess.a());
      Future localFuture = this.d;
      if (localFuture != null)
      {
        localFuture.cancel(true);
        this.d = null;
      }
    }
  }
  
  private class e
    extends Thread
  {
    public e()
    {
      super();
    }
    
    public void run()
    {
      byte[] arrayOfByte = new byte[o.this.i];
      while (o.this.m.get()) {
        if ((o.l(o.this) != null) && (o.l(o.this).getState() != 0))
        {
          int i = o.l(o.this).read(arrayOfByte, 0, o.this.i);
          if (i > 0)
          {
            ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte, 0, i);
            o.m(o.this).offer(new com.tplink.libmediakit.media.audioprocess.a(o.this.k, System.currentTimeMillis(), localByteBuffer));
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\u\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */