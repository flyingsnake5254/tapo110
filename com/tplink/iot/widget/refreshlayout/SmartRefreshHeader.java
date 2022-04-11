package com.tplink.iot.widget.refreshlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.a.d;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;

public class SmartRefreshHeader
  extends SimpleComponent
  implements d
{
  private LinearLayout q;
  private ImageView x;
  private Animation y;
  
  public SmartRefreshHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmartRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmartRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131559219, this);
    this.q = ((LinearLayout)paramAttributeSet.findViewById(2131363323));
    this.x = ((ImageView)paramAttributeSet.findViewById(2131363064));
    this.y = AnimationUtils.loadAnimation(paramContext, 2130771982);
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
          paramf = this.x;
          if (paramf != null)
          {
            paramf.clearAnimation();
            this.x.setVisibility(8);
          }
        }
      }
      else
      {
        paramf = this.q;
        if (paramf != null) {
          paramf.setVisibility(8);
        }
        paramf = this.x;
        if (paramf != null)
        {
          paramf.setVisibility(0);
          this.x.startAnimation(this.y);
        }
      }
    }
    else
    {
      paramf = this.x;
      if ((paramf != null) && (paramf.getVisibility() == 8))
      {
        paramf = this.q;
        if (paramf != null) {
          paramf.setVisibility(0);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\refreshlayout\SmartRefreshHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */