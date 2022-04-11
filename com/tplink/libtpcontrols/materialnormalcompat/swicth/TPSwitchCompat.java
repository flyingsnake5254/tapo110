package com.tplink.libtpcontrols.materialnormalcompat.swicth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.MotionEventCompat;
import com.tplink.libtpcontrols.z0.e;

public class TPSwitchCompat
  extends SwitchCompat
{
  private a c;
  private boolean d = false;
  private boolean f = false;
  private e q;
  
  public TPSwitchCompat(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPSwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TPSwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
            break label77;
          }
        }
      }
      else
      {
        this.f = false;
        locale = this.q;
        if (locale == null) {
          break label77;
        }
        locale.a(true);
        break label77;
      }
    }
    this.d = true;
    this.f = false;
    e locale = this.q;
    if (locale != null) {
      locale.a(false);
    }
    label77:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    if (!this.f) {
      this.d = false;
    }
  }
  
  public void setOnSwitchCheckedChangeListener(a parama)
  {
    this.c = parama;
    setOnCheckedChangeListener(new a(this));
  }
  
  public void setOnTouchCancelListener(e parame)
  {
    this.q = parame;
  }
  
  public static abstract interface a
  {
    public abstract void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\swicth\TPSwitchCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */