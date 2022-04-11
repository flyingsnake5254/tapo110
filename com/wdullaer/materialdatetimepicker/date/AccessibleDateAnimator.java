package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ViewAnimator;
import java.util.List;

public class AccessibleDateAnimator
  extends ViewAnimator
{
  private long c;
  
  public AccessibleDateAnimator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.getText().clear();
      String str = DateUtils.formatDateTime(getContext(), this.c, 22);
      paramAccessibilityEvent.getText().add(str);
      return true;
    }
    return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public void setDateMillis(long paramLong)
  {
    this.c = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\AccessibleDateAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */