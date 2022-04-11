package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public class a
{
  private static final GmsLogger a = new GmsLogger("StreamingFormatChecker", "");
  private final LinkedList<Long> b = new LinkedList();
  private long c = -1L;
  
  @KeepForSdk
  public void a(b.b.a.a.a.a parama)
  {
    if (parama.d() != -1) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    this.b.add(Long.valueOf(l1));
    if (this.b.size() > 5) {
      this.b.removeFirst();
    }
    if ((this.b.size() == 5) && (l1 - ((Long)this.b.peekFirst()).longValue() < 5000L))
    {
      long l2 = this.c;
      if ((l2 == -1L) || (l1 - l2 >= TimeUnit.SECONDS.toMillis(5L)))
      {
        this.c = l1;
        a.w("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */