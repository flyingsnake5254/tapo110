package b.d.e0.h;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import android.util.Log;

public final class a
  implements Camera.AutoFocusCallback
{
  private static final String a = a.class.getSimpleName();
  private Handler b;
  private int c;
  
  public void a(Handler paramHandler, int paramInt)
  {
    this.b = paramHandler;
    this.c = paramInt;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    paramCamera = this.b;
    if (paramCamera != null)
    {
      paramCamera = paramCamera.obtainMessage(this.c, Boolean.valueOf(paramBoolean));
      this.b.sendMessageDelayed(paramCamera, 1500L);
      this.b = null;
    }
    else
    {
      Log.d(a, "Got auto-focus callback, but no handler for it");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */