package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class SimpleTextSwitcher
  extends TextSwitcher
  implements ViewSwitcher.ViewFactory
{
  public SimpleTextSwitcher(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleTextSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFactory(this);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    TextView localTextView = (TextView)getNextView();
    int i;
    if (paramBoolean1) {
      i = getResources().getColor(2131099799);
    } else {
      i = -1;
    }
    localTextView.setTextColor(i);
    Object localObject;
    if (paramBoolean1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = getResources().getString(2131952440);
    }
    localTextView.setText((CharSequence)localObject);
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        setInAnimation(AnimationUtils.loadAnimation(getContext(), 2130772050));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2130772055));
      }
      else
      {
        localTextView.setText(getResources().getString(2131952440));
        setInAnimation(AnimationUtils.loadAnimation(getContext(), 2130772051));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2130772054));
      }
    }
    else
    {
      setInAnimation(null);
      setOutAnimation(null);
    }
    showNext();
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setTextSize(2, 20.0F);
    return localTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\SimpleTextSwitcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */