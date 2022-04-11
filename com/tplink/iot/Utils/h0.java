package com.tplink.iot.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

public class h0
{
  private Activity a;
  private Dialog b;
  private RelativeLayout c;
  private TPCircleProgressBar d;
  private TextView e;
  
  public h0(Activity paramActivity)
  {
    this(paramActivity, 2131231518, 2131100206);
  }
  
  public h0(Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.a = paramActivity;
    Object localObject = new Dialog(paramActivity, 2132017573);
    this.b = ((Dialog)localObject);
    ((Dialog)localObject).setContentView(2131559378);
    this.b.setCancelable(false);
    localObject = (RelativeLayout)this.b.findViewById(2131363883);
    this.c = ((RelativeLayout)localObject);
    ((RelativeLayout)localObject).setBackgroundResource(paramInt1);
    localObject = (TPCircleProgressBar)this.b.findViewById(2131363711);
    this.d = ((TPCircleProgressBar)localObject);
    ((TPCircleProgressBar)localObject).setProgressBarColor(ContextCompat.getColor(paramActivity, paramInt2));
    this.d.h();
    paramActivity = (TextView)this.b.findViewById(2131363452);
    this.e = paramActivity;
    paramActivity.setVisibility(8);
    this.b.setOnDismissListener(new a());
  }
  
  public void c()
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
  
  public Activity d()
  {
    return this.a;
  }
  
  @Nullable
  public Dialog e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    Dialog localDialog = this.b;
    boolean bool;
    if ((localDialog != null) && (localDialog.isShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void g(boolean paramBoolean)
  {
    Dialog localDialog = this.b;
    if ((localDialog != null) && (!localDialog.isShowing())) {
      this.b.setCancelable(paramBoolean);
    }
  }
  
  public void h(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.e.setText(paramString);
      this.e.setVisibility(0);
    }
    else
    {
      this.e.setVisibility(8);
    }
  }
  
  public void i()
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
      if (h0.a(h0.this) != null)
      {
        h0.a(h0.this).i();
        h0.b(h0.this, null);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */