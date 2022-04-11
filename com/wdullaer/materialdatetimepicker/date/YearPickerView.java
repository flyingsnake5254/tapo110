package com.wdullaer.materialdatetimepicker.date;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class YearPickerView
  extends ListView
  implements AdapterView.OnItemClickListener, b
{
  private final a c;
  private TextViewWithCircularIndicator d;
  
  private static int a(TextView paramTextView)
  {
    return Integer.valueOf(paramTextView.getText().toString()).intValue();
  }
  
  public int getFirstPositionOffset()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      paramAccessibilityEvent.setFromIndex(0);
      paramAccessibilityEvent.setToIndex(0);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c.a();
    paramAdapterView = (TextViewWithCircularIndicator)paramView;
    if (paramAdapterView != null)
    {
      paramView = this.d;
      if (paramAdapterView != paramView)
      {
        if (paramView != null)
        {
          paramView.a(false);
          this.d.requestLayout();
        }
        paramAdapterView.a(true);
        paramAdapterView.requestLayout();
        this.d = paramAdapterView;
      }
      this.c.n(a(paramAdapterView));
      throw null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\YearPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */