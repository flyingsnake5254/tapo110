package com.tplink.iot.view.login;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.c;

public class CloudRegionChooseActivity_ViewBinding
  implements Unbinder
{
  private CloudRegionChooseActivity b;
  
  @UiThread
  public CloudRegionChooseActivity_ViewBinding(CloudRegionChooseActivity paramCloudRegionChooseActivity, View paramView)
  {
    this.b = paramCloudRegionChooseActivity;
    paramCloudRegionChooseActivity.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
  }
  
  @CallSuper
  public void a()
  {
    CloudRegionChooseActivity localCloudRegionChooseActivity = this.b;
    if (localCloudRegionChooseActivity != null)
    {
      this.b = null;
      localCloudRegionChooseActivity.mToolbar = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\login\CloudRegionChooseActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */