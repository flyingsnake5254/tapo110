package com.tplink.libtpcontrols.materialnormalcompat.radio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.view.MotionEventCompat;

public class TPRadioButton
  extends AppCompatRadioButton
{
  private a c;
  private boolean d = false;
  private boolean f = false;
  
  public TPRadioButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TPRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 3) {
            break label45;
          }
        }
      }
      else
      {
        this.f = false;
        break label45;
      }
    }
    this.d = true;
    this.f = false;
    label45:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    if (!this.f) {
      this.d = false;
    }
  }
  
  public void setOnCheckedChangeListener(a parama)
  {
    this.c = parama;
    setOnCheckedChangeListener(new a(this));
  }
  
  public static abstract interface a
  {
    public abstract void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\radio\TPRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */