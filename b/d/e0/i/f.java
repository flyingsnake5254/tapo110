package b.d.e0.i;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class f
  implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable
{
  private final Activity c;
  
  public f(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    run();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    run();
  }
  
  public void run()
  {
    this.c.finish();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\i\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */