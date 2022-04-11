package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class TitleSelectorView
  extends LinearLayout
  implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener
{
  private RadioButton c;
  private RadioButton d;
  private ViewPager f;
  private RadioGroup q;
  private a x;
  
  public TitleSelectorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TitleSelectorView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TitleSelectorView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559445, this, true);
    setOrientation(0);
    paramContext = (RadioGroup)findViewById(2131363848);
    this.q = paramContext;
    paramContext.setOnCheckedChangeListener(this);
    this.c = ((RadioButton)findViewById(2131364689));
    this.d = ((RadioButton)findViewById(2131364690));
    this.q.check(2131364689);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 2131364690: 
      this.c.setTextColor(getContext().getResources().getColor(2131099736));
      this.d.setTextColor(getContext().getResources().getColor(2131100206));
      paramRadioGroup = this.f;
      if (paramRadioGroup != null) {
        paramRadioGroup.setCurrentItem(1);
      }
      paramRadioGroup = this.x;
      if (paramRadioGroup != null) {
        paramRadioGroup.a(1);
      }
      break;
    case 2131364689: 
      this.c.setTextColor(getContext().getResources().getColor(2131100206));
      this.d.setTextColor(getContext().getResources().getColor(2131099736));
      paramRadioGroup = this.f;
      if (paramRadioGroup != null) {
        paramRadioGroup.setCurrentItem(0);
      }
      paramRadioGroup = this.x;
      if (paramRadioGroup != null) {
        paramRadioGroup.a(0);
      }
      break;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    RadioGroup localRadioGroup = this.q;
    if (paramInt == 0) {
      paramInt = 2131364689;
    } else {
      paramInt = 2131364690;
    }
    localRadioGroup.check(paramInt);
  }
  
  public void setOnSelectedTitleListener(a parama)
  {
    this.x = parama;
  }
  
  public void setSelectedTitleIndex(int paramInt)
  {
    RadioGroup localRadioGroup = this.q;
    if (paramInt == 0) {
      paramInt = 2131364689;
    } else {
      paramInt = 2131364690;
    }
    localRadioGroup.check(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\TitleSelectorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */