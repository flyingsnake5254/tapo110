package com.tplink.libtpcontrols;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.EditText;

public class TPClearPswText
  extends TPClearEditText
{
  public TPClearPswText(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPClearPswText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TPClearPswText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setTransformationMethod(PasswordTransformationMethod.getInstance());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPClearPswText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */