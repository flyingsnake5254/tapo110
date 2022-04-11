package b.d.e0.i;

import android.os.Handler;
import android.os.Looper;
import com.tplink.zxing.activity.CaptureFragment;
import java.util.concurrent.CountDownLatch;

final class e
  extends Thread
{
  private final CaptureFragment c;
  private Handler d;
  private final CountDownLatch f;
  
  e(CaptureFragment paramCaptureFragment)
  {
    this.c = paramCaptureFragment;
    this.f = new CountDownLatch(1);
  }
  
  Handler a()
  {
    try
    {
      this.f.await();
      return this.d;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.d = new d(this.c);
    this.f.countDown();
    Looper.loop();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */