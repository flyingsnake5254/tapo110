package com.tplink.iot.Utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

public class x
{
  public static void a(View paramView)
  {
    paramView.setVisibility(0);
    paramView.startAnimation(AnimationUtils.loadAnimation(paramView.getContext(), 2130772050));
  }
  
  public static void b(View paramView)
  {
    paramView.setVisibility(0);
    paramView.startAnimation(AnimationUtils.loadAnimation(paramView.getContext(), 2130772051));
  }
  
  public static void c(View paramView)
  {
    if ((paramView != null) && (paramView.getContext() != null))
    {
      Animation localAnimation = AnimationUtils.loadAnimation(paramView.getContext(), 2130772059);
      paramView.startAnimation(localAnimation);
      localAnimation.setAnimationListener(new a(paramView));
    }
  }
  
  public static void d(View paramView)
  {
    if ((paramView != null) && (paramView.getContext() != null))
    {
      Animation localAnimation = AnimationUtils.loadAnimation(paramView.getContext(), 2130772058);
      paramView.startAnimation(localAnimation);
      localAnimation.setAnimationListener(new b(paramView));
    }
  }
  
  static final class a
    implements Animation.AnimationListener
  {
    a(View paramView) {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      this.c.setVisibility(8);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  static final class b
    implements Animation.AnimationListener
  {
    b(View paramView) {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      this.c.setVisibility(8);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */