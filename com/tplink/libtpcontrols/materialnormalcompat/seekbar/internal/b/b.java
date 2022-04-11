package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;

@TargetApi(11)
public class b
  extends a
{
  ValueAnimator a;
  
  public b(float paramFloat1, float paramFloat2, final a.a parama)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    this.a = localValueAnimator;
    localValueAnimator.addUpdateListener(new a(parama));
  }
  
  public void a()
  {
    this.a.cancel();
  }
  
  public boolean c()
  {
    return this.a.isRunning();
  }
  
  public void d(int paramInt)
  {
    this.a.setDuration(paramInt);
  }
  
  public void e()
  {
    this.a.start();
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(a.a parama) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      parama.a(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */