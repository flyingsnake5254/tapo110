package com.tplink.iot.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class k0
{
  private Activity a;
  private Dialog b;
  private RelativeLayout c;
  private TextView d;
  private b e = null;
  
  public k0(Activity paramActivity, String paramString)
  {
    this.a = paramActivity;
    this.b = new Dialog(paramActivity, 2132017573);
    if ((paramString != null) && (!paramString.isEmpty()) && (paramString.length() > 14)) {
      this.b.setContentView(2131559383);
    } else {
      this.b.setContentView(2131559382);
    }
    this.b.setCancelable(false);
    this.c = ((RelativeLayout)this.b.findViewById(2131363883));
    paramActivity = (TextView)this.b.findViewById(2131363452);
    this.d = paramActivity;
    paramActivity.setVisibility(8);
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
  
  public void c(boolean paramBoolean)
  {
    Dialog localDialog = this.b;
    if ((localDialog != null) && (!localDialog.isShowing())) {
      this.b.setCancelable(paramBoolean);
    }
  }
  
  public void d(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.d.setText(paramString);
      this.d.setVisibility(0);
    }
    else
    {
      this.d.setVisibility(8);
    }
  }
  
  public void e(b paramb)
  {
    this.e = paramb;
  }
  
  public void f()
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
      if (k0.a(k0.this) != null) {
        k0.a(k0.this).onDismiss();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */