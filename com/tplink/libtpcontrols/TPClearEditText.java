package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;

public class TPClearEditText
  extends AppCompatEditText
  implements View.OnFocusChangeListener, TextWatcher
{
  private Drawable c;
  
  public TPClearEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public TPClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    Drawable localDrawable = getCompoundDrawables()[2];
    this.c = localDrawable;
    if (localDrawable == null) {
      this.c = getResources().getDrawable(r0.ic_et_clear);
    }
    int i = (int)getTextSize();
    this.c.setBounds(0, 0, i, i);
    setClearIconVisible(false);
    setSingleLine(true);
    setOnFocusChangeListener(this);
    addTextChangedListener(this);
    setCompoundDrawablePadding((int)(getResources().getDisplayMetrics().density * 15.0F));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool;
    if ((isFocused()) && (paramEditable.length() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    setClearIconVisible(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      paramView = getText();
      if (paramView != null)
      {
        paramBoolean = bool;
        if (paramView.length() > 0) {
          paramBoolean = true;
        }
        setClearIconVisible(paramBoolean);
        super.setSelection(paramView.length());
      }
    }
    else
    {
      setClearIconVisible(false);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = 1;
    if ((i == 1) && (getCompoundDrawables()[2] != null))
    {
      if ((paramMotionEvent.getX() <= getWidth() - getTotalPaddingRight()) || (paramMotionEvent.getX() >= getWidth() - getPaddingRight())) {
        j = 0;
      }
      if (j != 0) {
        setText("");
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void setClearIconVisible(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.c;
    } else {
      localDrawable = null;
    }
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPClearEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */