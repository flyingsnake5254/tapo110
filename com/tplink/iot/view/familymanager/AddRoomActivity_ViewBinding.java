package com.tplink.iot.view.familymanager;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class AddRoomActivity_ViewBinding
  implements Unbinder
{
  private AddRoomActivity b;
  private View c;
  
  @UiThread
  public AddRoomActivity_ViewBinding(final AddRoomActivity paramAddRoomActivity, View paramView)
  {
    this.b = paramAddRoomActivity;
    View localView = c.c(paramView, 2131362034, "field 'mAddRoomBtn' and method 'addRoom'");
    paramAddRoomActivity.mAddRoomBtn = ((TPRefreshableButton)c.b(localView, 2131362034, "field 'mAddRoomBtn'", TPRefreshableButton.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramAddRoomActivity));
    paramAddRoomActivity.mAddRoomEditText = ((DrawableEditText)c.d(paramView, 2131361941, "field 'mAddRoomEditText'", DrawableEditText.class));
    paramAddRoomActivity.mLineBreakLayout = ((LineBreakLayout)c.d(paramView, 2131363241, "field 'mLineBreakLayout'", LineBreakLayout.class));
  }
  
  @CallSuper
  public void a()
  {
    AddRoomActivity localAddRoomActivity = this.b;
    if (localAddRoomActivity != null)
    {
      this.b = null;
      localAddRoomActivity.mAddRoomBtn = null;
      localAddRoomActivity.mAddRoomEditText = null;
      localAddRoomActivity.mLineBreakLayout = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(AddRoomActivity paramAddRoomActivity) {}
    
    public void a(View paramView)
    {
      paramAddRoomActivity.addRoom();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\AddRoomActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */