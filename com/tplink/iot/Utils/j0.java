package com.tplink.iot.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class j0
{
  private Activity a;
  private Dialog b;
  private RelativeLayout c;
  private TextView d;
  private b e = null;
  
  public j0(Activity paramActivity, String paramString)
  {
    this.a = paramActivity;
    paramActivity = new Dialog(paramActivity, 2132017573);
    this.b = paramActivity;
    paramActivity.setContentView(2131559381);
    this.b.setCancelable(false);
    this.c = ((RelativeLayout)this.b.findViewById(2131363883));
    paramActivity = (TextView)this.b.findViewById(2131363452);
    this.d = paramActivity;
    paramActivity.setText(paramString);
    this.b.setOnDismissListener(new a());
  }
  
  public void b()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      localObject = this.a;
      if ((localObject != null) && (!((Activity)localObject).isDestroyed()) && (!this.a.isFinishing())) {
        this.b.dismiss();
      }
    }
  }
  
  public void c(b paramb)
  {
    this.e = paramb;
  }
  
  public void d()
  {
    Dialog localDialog = this.b;
    if ((localDialog != null) && (!localDialog.isShowing())) {
      this.b.show();
    }
  }
  
  class a
    implements DialogInterface.OnDismissListener
  {
    a() {}
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if (j0.a(j0.this) != null) {
        j0.a(j0.this).onDismiss();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */