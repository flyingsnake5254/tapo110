package b.d.g;

import android.media.AudioTrack;
import android.media.AudioTrack.OnPlaybackPositionUpdateListener;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class b
  extends a
  implements AudioTrack.OnPlaybackPositionUpdateListener
{
  private final String f = b.class.getSimpleName();
  private long g;
  private long h;
  private long i;
  private int j;
  private final Queue<a> k = new LinkedList();
  private int l;
  private int m;
  private final Object n = new Object();
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void d(com.tplink.libmediakit.media.audioprocess.a arg1)
  {
    if (??? == null) {
      return;
    }
    super.d(???);
    Object localObject1 = new a();
    ((a)localObject1).f(???.a);
    ((a)localObject1).e(???.m() * this.e / 1000);
    ((a)localObject1).d(???);
    synchronized (this.n)
    {
      this.k.offer(localObject1);
      this.m += ((a)localObject1).b();
      localObject1 = p.a;
      return;
    }
  }
  
  public void h()
  {
    this.b.setPlaybackPositionUpdateListener(this);
    this.j = (this.e / 100);
    AudioTrack localAudioTrack = this.b;
    j.d(localAudioTrack, "audioTrack");
    localAudioTrack.setPositionNotificationPeriod(this.j);
    super.h();
  }
  
  public void onMarkerReached(AudioTrack paramAudioTrack) {}
  
  public void onPeriodicNotification(AudioTrack paramAudioTrack)
  {
    if (this.g == 0L) {
      this.g = (SystemClock.elapsedRealtime() - this.j * 1000 / this.e);
    }
    this.l += this.j;
    Object localObject1;
    int i1;
    for (;;)
    {
      localObject1 = (a)this.k.peek();
      if (localObject1 == null) {
        return;
      }
      i1 = this.l - ((a)localObject1).b();
      this.l = i1;
      if (i1 >= 0) {
        synchronized (this.n)
        {
          this.k.poll();
          this.m -= ((a)localObject1).b();
          paramAudioTrack = ((a)localObject1).a();
          Object localObject3 = null;
          if (paramAudioTrack != null) {
            paramAudioTrack = paramAudioTrack.d;
          } else {
            paramAudioTrack = null;
          }
          if (paramAudioTrack != null)
          {
            com.tplink.libmediakit.media.audioprocess.a locala = ((a)localObject1).a();
            paramAudioTrack = (AudioTrack)localObject3;
            if (locala != null) {
              paramAudioTrack = locala.o();
            }
            if (paramAudioTrack != null)
            {
              paramAudioTrack = ((a)localObject1).a();
              j.c(paramAudioTrack);
              i1 = paramAudioTrack.d.length * 8 * 1000 / 16 / this.e;
              long l1 = System.currentTimeMillis();
              long l2 = 20;
              long l3 = i1;
              if (this.d <= 0.0F)
              {
                paramAudioTrack = ((a)localObject1).a();
                j.c(paramAudioTrack);
                Arrays.fill(paramAudioTrack.d, (byte)0);
              }
              paramAudioTrack = b.d.d.m.b.a();
              localObject3 = ((a)localObject1).a();
              j.c(localObject3);
              localObject3 = ((com.tplink.libmediakit.media.audioprocess.a)localObject3).o();
              localObject1 = ((a)localObject1).a();
              j.c(localObject1);
              paramAudioTrack.b((String)localObject3, ((com.tplink.libmediakit.media.audioprocess.a)localObject1).d, i1);
              this.h = (l1 + l2 - l3);
            }
          }
          paramAudioTrack = p.a;
        }
      }
    }
    this.l = (i1 + ((a)localObject1).b());
    this.i = (((a)localObject1).c() + this.l * 1000L / this.e);
  }
  
  private static final class a
  {
    private long a;
    private int b;
    private com.tplink.libmediakit.media.audioprocess.a c;
    
    public final com.tplink.libmediakit.media.audioprocess.a a()
    {
      return this.c;
    }
    
    public final int b()
    {
      return this.b;
    }
    
    public final long c()
    {
      return this.a;
    }
    
    public final void d(com.tplink.libmediakit.media.audioprocess.a parama)
    {
      this.c = parama;
    }
    
    public final void e(int paramInt)
    {
      this.b = paramInt;
    }
    
    public final void f(long paramLong)
    {
      this.a = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */