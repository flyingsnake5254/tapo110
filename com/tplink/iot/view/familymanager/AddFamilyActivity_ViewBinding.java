package com.tplink.iot.view.familymanager;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class AddFamilyActivity_ViewBinding
  implements Unbinder
{
  private AddFamilyActivity b;
  private View c;
  
  @UiThread
  public AddFamilyActivity_ViewBinding(final AddFamilyActivity paramAddFamilyActivity, View paramView)
  {
    this.b = paramAddFamilyActivity;
    View localView = c.c(paramView, 2131362033, "field 'mAddHomeBtn' and method 'addHome'");
    paramAddFamilyActivity.mAddHomeBtn = ((TPRefreshableButton)c.b(localView, 2131362033, "field 'mAddHomeBtn'", TPRefreshableButton.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramAddFamilyActivity));
    paramAddFamilyActivity.mAddHomeEditText = ((DrawableEditText)c.d(paramView, 2131361936, "field 'mAddHomeEditText'", DrawableEditText.class));
  }
  
  @CallSuper
  public void a()
  {
    AddFamilyActivity localAddFamilyActivity = this.b;
    if (localAddFamilyActivity != null)
    {
      this.b = null;
      localAddFamilyActivity.mAddHomeBtn = null;
      localAddFamilyActivity.mAddHomeEditText = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(AddFamilyActivity paramAddFamilyActivity) {}
    
    public void a(View paramView)
    {
      paramAddFamilyActivity.addHome();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\AddFamilyActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */