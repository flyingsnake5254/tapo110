package com.tplink.iot.view.ipcamera.setting;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.widget.CustomTimePicker;

public class ModeTimePickerDialog_ViewBinding
  implements Unbinder
{
  private ModeTimePickerDialog b;
  private View c;
  private View d;
  
  @UiThread
  public ModeTimePickerDialog_ViewBinding(final ModeTimePickerDialog paramModeTimePickerDialog, View paramView)
  {
    this.b = paramModeTimePickerDialog;
    paramModeTimePickerDialog.startOrEndTv = ((TextView)c.d(paramView, 2131364238, "field 'startOrEndTv'", TextView.class));
    paramModeTimePickerDialog.timePicker = ((CustomTimePicker)c.d(paramView, 2131364239, "field 'timePicker'", CustomTimePicker.class));
    View localView = c.c(paramView, 2131364227, "method 'onCancelClick'");
    this.c = localView;
    localView.setOnClickListener(new a(paramModeTimePickerDialog));
    paramView = c.c(paramView, 2131364228, "method 'onConfirmClick'");
    this.d = paramView;
    paramView.setOnClickListener(new b(paramModeTimePickerDialog));
  }
  
  @CallSuper
  public void a()
  {
    ModeTimePickerDialog localModeTimePickerDialog = this.b;
    if (localModeTimePickerDialog != null)
    {
      this.b = null;
      localModeTimePickerDialog.startOrEndTv = null;
      localModeTimePickerDialog.timePicker = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(ModeTimePickerDialog paramModeTimePickerDialog) {}
    
    public void a(View paramView)
    {
      paramModeTimePickerDialog.onCancelClick();
    }
  }
  
  class b
    extends b
  {
    b(ModeTimePickerDialog paramModeTimePickerDialog) {}
    
    public void a(View paramView)
    {
      paramModeTimePickerDialog.onConfirmClick();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\ModeTimePickerDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */