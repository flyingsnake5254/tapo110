package com.tplink.iot.widget.refreshlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.a.c;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;

public class SmartRefreshFooter
  extends SimpleComponent
  implements c
{
  private ImageView q;
  private Animation x;
  
  public SmartRefreshFooter(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmartRefreshFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmartRefreshFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.q = ((ImageView)LayoutInflater.from(paramContext).inflate(2131559218, this).findViewById(2131363081));
    this.x = AnimationUtils.loadAnimation(paramContext, 2130771982);
  }
  
  public void h(@NonNull f paramf, @NonNull RefreshState paramRefreshState1, @NonNull RefreshState paramRefreshState2)
  {
    int i = a.a[paramRefreshState2.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          paramf = this.q;
          if (paramf != null)
          {
            paramf.clearAnimation();
            this.q.setVisibility(8);
          }
        }
      }
      else
      {
        paramf = this.q;
        if (paramf != null)
        {
          paramf.setVisibility(0);
          this.q.startAnimation(this.x);
        }
      }
    }
    else
    {
      paramf = this.q;
      if (paramf != null) {
        paramf.setVisibility(0);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\refreshlayout\SmartRefreshFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */