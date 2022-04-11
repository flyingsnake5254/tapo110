package com.tplink.iot.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tplink.iot.widget.j.a.a;

public class g
  extends a
{
  private LinearLayout a;
  private ImageView b;
  private Animation c;
  
  public void a()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    this.b.startAnimation(this.c);
  }
  
  public void c(View paramView, int paramInt) {}
  
  public void d()
  {
    ImageView localImageView = this.b;
    if (localImageView != null)
    {
      localImageView.clearAnimation();
      this.b.setVisibility(8);
    }
  }
  
  public void g(View paramView)
  {
    if (this.b.getVisibility() == 8) {
      this.a.setVisibility(0);
    }
  }
  
  public void k(View paramView, boolean paramBoolean) {}
  
  public View m(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559207, paramViewGroup, true);
    this.a = ((LinearLayout)paramLayoutInflater.findViewById(2131363323));
    this.b = ((ImageView)paramLayoutInflater.findViewById(2131363064));
    this.c = AnimationUtils.loadAnimation(paramViewGroup.getContext(), 2130771982);
    return paramLayoutInflater;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */