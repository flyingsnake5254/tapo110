package b.d.e0.i;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.Fragment;
import b.d.e0.d;
import com.tplink.zxing.activity.CaptureFragment;

public final class c
  extends Handler
{
  private static final String a = c.class.getSimpleName();
  private final CaptureFragment b;
  private final e c;
  private a d;
  
  public c(CaptureFragment paramCaptureFragment)
  {
    this.b = paramCaptureFragment;
    paramCaptureFragment = new e(paramCaptureFragment);
    this.c = paramCaptureFragment;
    paramCaptureFragment.start();
    this.d = a.d;
    b.d.e0.h.c.c().p();
    b();
  }
  
  private void b()
  {
    if (this.d == a.d)
    {
      this.d = a.c;
      b.d.e0.h.c.c().n(this.c.a(), d.decode);
      b.d.e0.h.c.c().m(this, d.auto_focus);
      this.b.A0();
    }
  }
  
  public void a()
  {
    this.d = a.f;
    b.d.e0.h.c.c().q();
    Message.obtain(this.c.a(), d.quit).sendToTarget();
    try
    {
      this.c.join();
      removeMessages(d.decode_succeeded);
      removeMessages(d.decode_failed);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int j = d.auto_focus;
    if (i == j)
    {
      if (this.d == a.c) {
        try
        {
          b.d.e0.h.c.c().m(this, j);
        }
        catch (Exception paramMessage)
        {
          Log.e(a, "RuntimeException: autoFocus failed");
        }
      }
    }
    else if (i == d.restart_preview)
    {
      Log.d(a, "Got restart preview message");
      b();
    }
    else if (i == d.decode_succeeded)
    {
      Log.d(a, "Got decode succeeded message");
      this.d = a.d;
      Object localObject = paramMessage.getData();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (Bitmap)((Bundle)localObject).getParcelable("barcode_bitmap");
      }
      this.b.C0((String)paramMessage.obj, (Bitmap)localObject);
    }
    else if (i == d.decode_failed)
    {
      this.d = a.c;
      b.d.e0.h.c.c().n(this.c.a(), d.decode);
    }
    else if (i == d.return_scan_result)
    {
      Log.d(a, "Got return scan result message");
      this.b.getActivity().setResult(-1, (Intent)paramMessage.obj);
      this.b.getActivity().finish();
    }
    else if (i == d.launch_product_query)
    {
      Log.d(a, "Got product query message");
      paramMessage = new Intent("android.intent.action.VIEW", Uri.parse((String)paramMessage.obj));
      paramMessage.addFlags(524288);
      this.b.getActivity().startActivity(paramMessage);
    }
  }
  
  private static enum a
  {
    static
    {
      a locala1 = new a("PREVIEW", 0);
      c = locala1;
      a locala2 = new a("SUCCESS", 1);
      d = locala2;
      a locala3 = new a("DONE", 2);
      f = locala3;
      q = new a[] { locala1, locala2, locala3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */