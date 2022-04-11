package com.tplink.iot.view.feedback;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.widget.viewgroup.AutoScrolledWebView;

public class HelpAndFeedbackActivity_ViewBinding
  implements Unbinder
{
  private HelpAndFeedbackActivity b;
  private View c;
  private View d;
  
  @UiThread
  public HelpAndFeedbackActivity_ViewBinding(final HelpAndFeedbackActivity paramHelpAndFeedbackActivity, View paramView)
  {
    this.b = paramHelpAndFeedbackActivity;
    paramHelpAndFeedbackActivity.mLoadingProgress = ((ProgressBar)c.d(paramView, 2131362632, "field 'mLoadingProgress'", ProgressBar.class));
    View localView = c.c(paramView, 2131362630, "field 'mRefreshLayout' and method 'refreshLayout'");
    paramHelpAndFeedbackActivity.mRefreshLayout = localView;
    this.c = localView;
    localView.setOnClickListener(new a(paramHelpAndFeedbackActivity));
    paramHelpAndFeedbackActivity.mFeedbackWebView = ((AutoScrolledWebView)c.d(paramView, 2131362631, "field 'mFeedbackWebView'", AutoScrolledWebView.class));
    paramView = c.c(paramView, 2131362059, "field 'mFeedback' and method 'gotoSelectFeedbackDeviceActivity'");
    paramHelpAndFeedbackActivity.mFeedback = ((TextView)c.b(paramView, 2131362059, "field 'mFeedback'", TextView.class));
    this.d = paramView;
    paramView.setOnClickListener(new b(paramHelpAndFeedbackActivity));
  }
  
  @CallSuper
  public void a()
  {
    HelpAndFeedbackActivity localHelpAndFeedbackActivity = this.b;
    if (localHelpAndFeedbackActivity != null)
    {
      this.b = null;
      localHelpAndFeedbackActivity.mLoadingProgress = null;
      localHelpAndFeedbackActivity.mRefreshLayout = null;
      localHelpAndFeedbackActivity.mFeedbackWebView = null;
      localHelpAndFeedbackActivity.mFeedback = null;
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
    a(HelpAndFeedbackActivity paramHelpAndFeedbackActivity) {}
    
    public void a(View paramView)
    {
      paramHelpAndFeedbackActivity.refreshLayout();
    }
  }
  
  class b
    extends b
  {
    b(HelpAndFeedbackActivity paramHelpAndFeedbackActivity) {}
    
    public void a(View paramView)
    {
      paramHelpAndFeedbackActivity.gotoSelectFeedbackDeviceActivity();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\HelpAndFeedbackActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */