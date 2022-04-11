package com.tplink.iot.view.ipcamera.setting;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;

public class ScheduleEditActivity_ViewBinding
  implements Unbinder
{
  private ScheduleEditActivity b;
  private View c;
  
  @UiThread
  public ScheduleEditActivity_ViewBinding(final ScheduleEditActivity paramScheduleEditActivity, View paramView)
  {
    this.b = paramScheduleEditActivity;
    paramView = c.c(paramView, 2131364106, "method 'onDeleteClick'");
    this.c = paramView;
    paramView.setOnClickListener(new a(paramScheduleEditActivity));
  }
  
  @CallSuper
  public void a()
  {
    if (this.b != null)
    {
      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(ScheduleEditActivity paramScheduleEditActivity) {}
    
    public void a(View paramView)
    {
      paramScheduleEditActivity.onDeleteClick();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\ScheduleEditActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */