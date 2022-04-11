package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.MotionEventCompat;
import com.tplink.libtpcontrols.z0.e;

public class HomeSwitch
  extends SwitchCompat
{
  private b c;
  private boolean d = false;
  private boolean f = false;
  private e q;
  
  public HomeSwitch(Context paramContext)
  {
    super(paramContext);
  }
  
  public HomeSwitch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HomeSwitch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public void setOnSwitchCheckedChangeListener(b paramb)
  {
    this.c = paramb;
    setOnCheckedChangeListener(new a());
  }
  
  public void setOnTouchCancelListener(e parame)
  {
    this.q = parame;
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (HomeSwitch.a(HomeSwitch.this) != null) {
        HomeSwitch.a(HomeSwitch.this).c(paramCompoundButton, paramBoolean, HomeSwitch.b(HomeSwitch.this));
      }
      HomeSwitch.d(HomeSwitch.this, true);
      HomeSwitch.c(HomeSwitch.this, false);
    }
  }
  
  public static abstract interface b
  {
    public abstract void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\HomeSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */