package com.tplink.iot.view.feedback;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;

public class SelectFeedbackDeviceFragment_ViewBinding
  implements Unbinder
{
  private SelectFeedbackDeviceFragment b;
  private View c;
  
  @UiThread
  public SelectFeedbackDeviceFragment_ViewBinding(final SelectFeedbackDeviceFragment paramSelectFeedbackDeviceFragment, View paramView)
  {
    this.b = paramSelectFeedbackDeviceFragment;
    paramSelectFeedbackDeviceFragment.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
    paramSelectFeedbackDeviceFragment.mToolbarTitle = ((TextView)c.d(paramView, 2131364290, "field 'mToolbarTitle'", TextView.class));
    paramSelectFeedbackDeviceFragment.mSelectFeedbackDeviceRV = ((RecyclerView)c.d(paramView, 2131363808, "field 'mSelectFeedbackDeviceRV'", RecyclerView.class));
    View localView = c.c(paramView, 2131362060, "field 'mFeedbackBtn' and method 'feedback'");
    paramSelectFeedbackDeviceFragment.mFeedbackBtn = ((TextView)c.b(localView, 2131362060, "field 'mFeedbackBtn'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramSelectFeedbackDeviceFragment));
    paramSelectFeedbackDeviceFragment.mTipsBar = ((TipsBar)c.d(paramView, 2131364248, "field 'mTipsBar'", TipsBar.class));
  }
  
  @CallSuper
  public void a()
  {
    SelectFeedbackDeviceFragment localSelectFeedbackDeviceFragment = this.b;
    if (localSelectFeedbackDeviceFragment != null)
    {
      this.b = null;
      localSelectFeedbackDeviceFragment.mToolbar = null;
      localSelectFeedbackDeviceFragment.mToolbarTitle = null;
      localSelectFeedbackDeviceFragment.mSelectFeedbackDeviceRV = null;
      localSelectFeedbackDeviceFragment.mFeedbackBtn = null;
      localSelectFeedbackDeviceFragment.mTipsBar = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(SelectFeedbackDeviceFragment paramSelectFeedbackDeviceFragment) {}
    
    public void a(View paramView)
    {
      paramSelectFeedbackDeviceFragment.feedback();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\SelectFeedbackDeviceFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */