package com.tplink.iot.adapter.feedback;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class SelectFeedbackDeviceAdapter$RemindViewHolder_ViewBinding
  implements Unbinder
{
  private SelectFeedbackDeviceAdapter.RemindViewHolder b;
  
  @UiThread
  public SelectFeedbackDeviceAdapter$RemindViewHolder_ViewBinding(SelectFeedbackDeviceAdapter.RemindViewHolder paramRemindViewHolder, View paramView)
  {
    this.b = paramRemindViewHolder;
    paramRemindViewHolder.mRemindTv = ((TextView)c.d(paramView, 2131364595, "field 'mRemindTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    SelectFeedbackDeviceAdapter.RemindViewHolder localRemindViewHolder = this.b;
    if (localRemindViewHolder != null)
    {
      this.b = null;
      localRemindViewHolder.mRemindTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\feedback\SelectFeedbackDeviceAdapter$RemindViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */