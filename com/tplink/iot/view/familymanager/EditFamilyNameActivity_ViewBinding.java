package com.tplink.iot.view.familymanager;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.widget.DrawableEditText;

public class EditFamilyNameActivity_ViewBinding
  implements Unbinder
{
  private EditFamilyNameActivity b;
  
  @UiThread
  public EditFamilyNameActivity_ViewBinding(EditFamilyNameActivity paramEditFamilyNameActivity, View paramView)
  {
    this.b = paramEditFamilyNameActivity;
    paramEditFamilyNameActivity.mHomeNameEditText = ((DrawableEditText)c.d(paramView, 2131362509, "field 'mHomeNameEditText'", DrawableEditText.class));
  }
  
  @CallSuper
  public void a()
  {
    EditFamilyNameActivity localEditFamilyNameActivity = this.b;
    if (localEditFamilyNameActivity != null)
    {
      this.b = null;
      localEditFamilyNameActivity.mHomeNameEditText = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\EditFamilyNameActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */