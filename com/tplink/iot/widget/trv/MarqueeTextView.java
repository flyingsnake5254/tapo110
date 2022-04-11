package com.tplink.iot.widget.trv;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public final class MarqueeTextView
  extends AppCompatTextView
{
  public MarqueeTextView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public MarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isFocused()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\trv\MarqueeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */