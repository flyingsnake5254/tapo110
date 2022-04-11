package com.tplink.iot.view.ipcamera.play;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;

public class ForcedUpdateFwDialog_ViewBinding
  implements Unbinder
{
  private ForcedUpdateFwDialog b;
  private View c;
  private View d;
  private View e;
  
  @UiThread
  public ForcedUpdateFwDialog_ViewBinding(final ForcedUpdateFwDialog paramForcedUpdateFwDialog, View paramView)
  {
    this.b = paramForcedUpdateFwDialog;
    View localView = c.c(paramView, 2131364747, "field 'laterTv' and method 'doUpdateLater'");
    paramForcedUpdateFwDialog.laterTv = ((TextView)c.b(localView, 2131364747, "field 'laterTv'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramForcedUpdateFwDialog));
    paramForcedUpdateFwDialog.deviceName = ((TextView)c.d(paramView, 2131362415, "field 'deviceName'", TextView.class));
    paramForcedUpdateFwDialog.fwInfoTv = ((TextView)c.d(paramView, 2131362404, "field 'fwInfoTv'", TextView.class));
    localView = c.c(paramView, 2131362398, "field 'detail' and method 'detailClick'");
    paramForcedUpdateFwDialog.detail = ((TextView)c.b(localView, 2131362398, "field 'detail'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new b(paramForcedUpdateFwDialog));
    paramView = c.c(paramView, 2131364748, "method 'doUpdate'");
    this.e = paramView;
    paramView.setOnClickListener(new c(paramForcedUpdateFwDialog));
  }
  
  @CallSuper
  public void a()
  {
    ForcedUpdateFwDialog localForcedUpdateFwDialog = this.b;
    if (localForcedUpdateFwDialog != null)
    {
      this.b = null;
      localForcedUpdateFwDialog.laterTv = null;
      localForcedUpdateFwDialog.deviceName = null;
      localForcedUpdateFwDialog.fwInfoTv = null;
      localForcedUpdateFwDialog.detail = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(ForcedUpdateFwDialog paramForcedUpdateFwDialog) {}
    
    public void a(View paramView)
    {
      paramForcedUpdateFwDialog.doUpdateLater();
    }
  }
  
  class b
    extends b
  {
    b(ForcedUpdateFwDialog paramForcedUpdateFwDialog) {}
    
    public void a(View paramView)
    {
      paramForcedUpdateFwDialog.detailClick();
    }
  }
  
  class c
    extends b
  {
    c(ForcedUpdateFwDialog paramForcedUpdateFwDialog) {}
    
    public void a(View paramView)
    {
      paramForcedUpdateFwDialog.doUpdate();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\ForcedUpdateFwDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */