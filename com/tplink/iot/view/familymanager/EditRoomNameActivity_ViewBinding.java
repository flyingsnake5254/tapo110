package com.tplink.iot.view.familymanager;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.widget.DrawableEditText;

public class EditRoomNameActivity_ViewBinding
  implements Unbinder
{
  private EditRoomNameActivity b;
  
  @UiThread
  public EditRoomNameActivity_ViewBinding(EditRoomNameActivity paramEditRoomNameActivity, View paramView)
  {
    this.b = paramEditRoomNameActivity;
    paramEditRoomNameActivity.mRoomNameEditText = ((DrawableEditText)c.d(paramView, 2131362514, "field 'mRoomNameEditText'", DrawableEditText.class));
  }
  
  @CallSuper
  public void a()
  {
    EditRoomNameActivity localEditRoomNameActivity = this.b;
    if (localEditRoomNameActivity != null)
    {
      this.b = null;
      localEditRoomNameActivity.mRoomNameEditText = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\EditRoomNameActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */