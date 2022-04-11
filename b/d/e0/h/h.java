package b.d.e0.h;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public final class h
  implements Camera.PreviewCallback
{
  private static final String a = h.class.getSimpleName();
  private final b b;
  private final boolean c;
  private Handler d;
  private int e;
  
  h(b paramb, boolean paramBoolean)
  {
    this.b = paramb;
    this.c = paramBoolean;
  }
  
  public void a(Handler paramHandler, int paramInt)
  {
    this.d = paramHandler;
    this.e = paramInt;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Point localPoint = this.b.c();
    if (!this.c) {
      paramCamera.setPreviewCallback(null);
    }
    paramCamera = this.d;
    if (paramCamera != null)
    {
      paramCamera.obtainMessage(this.e, localPoint.x, localPoint.y, paramArrayOfByte).sendToTarget();
      this.d = null;
    }
    else
    {
      Log.d(a, "Got preview callback, but no handler for it");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */