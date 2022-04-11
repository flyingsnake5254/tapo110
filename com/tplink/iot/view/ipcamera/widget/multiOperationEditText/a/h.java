package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;

@TargetApi(12)
@RequiresApi(12)
class h
  extends f.d
{
  private final ValueAnimator a = new ValueAnimator();
  
  public void a(final f.d.b paramb)
  {
    this.a.addUpdateListener(new a(paramb));
  }
  
  public void b()
  {
    this.a.cancel();
  }
  
  public float c()
  {
    return ((Float)this.a.getAnimatedValue()).floatValue();
  }
  
  public boolean d()
  {
    return this.a.isRunning();
  }
  
  public void e(long paramLong)
  {
    this.a.setDuration(paramLong);
  }
  
  public void f(float paramFloat1, float paramFloat2)
  {
    this.a.setFloatValues(new float[] { paramFloat1, paramFloat2 });
  }
  
  public void g(Interpolator paramInterpolator)
  {
    this.a.setInterpolator(paramInterpolator);
  }
  
  public void h()
  {
    this.a.start();
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(f.d.b paramb) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramb.a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */