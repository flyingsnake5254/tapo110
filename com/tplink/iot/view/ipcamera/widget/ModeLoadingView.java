package com.tplink.iot.view.ipcamera.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import b.d.w.f.a;
import java.util.ArrayList;

public class ModeLoadingView
  extends LinearLayout
{
  ArrayList<ImageView> c;
  final int d = 5;
  final int f = 1200;
  final float p0 = 1.0F;
  AnimatorSet p1 = new AnimatorSet();
  final float q = 0.2F;
  final float x = 0.4F;
  final float y = 0.6F;
  final float z = 0.8F;
  
  public ModeLoadingView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ModeLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ModeLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext)
  {
    this.c = new ArrayList();
    setOrientation(0);
    for (int i = 0; i < 5; i++)
    {
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageResource(2131231310);
      this.c.add(localImageView);
      addView(localImageView);
      if (i != 0)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
        localLayoutParams.setMargins(a.a(paramContext, 8.0F), 0, 0, 0);
        localImageView.setLayoutParams(localLayoutParams);
      }
    }
    b();
  }
  
  public void b()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.c.get(0), "alpha", new float[] { 0.2F, 0.4F, 0.6F, 0.8F, 1.0F }).setDuration(1200L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.c.get(1), "alpha", new float[] { 1.0F, 0.2F, 0.4F, 0.6F, 0.8F }).setDuration(1200L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.c.get(2), "alpha", new float[] { 0.8F, 1.0F, 0.2F, 0.4F, 0.6F }).setDuration(1200L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.c.get(3), "alpha", new float[] { 0.6F, 0.8F, 1.0F, 0.2F, 0.4F }).setDuration(1200L);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.c.get(4), "alpha", new float[] { 0.4F, 0.6F, 0.8F, 1.0F, 0.2F }).setDuration(1200L);
    localObjectAnimator1.setRepeatCount(-1);
    localObjectAnimator1.setRepeatMode(1);
    localObjectAnimator2.setRepeatCount(-1);
    localObjectAnimator2.setRepeatMode(1);
    localObjectAnimator3.setRepeatCount(-1);
    localObjectAnimator3.setRepeatMode(1);
    localObjectAnimator4.setRepeatCount(-1);
    localObjectAnimator4.setRepeatMode(1);
    localObjectAnimator5.setRepeatCount(-1);
    localObjectAnimator5.setRepeatMode(1);
    this.p1.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5 });
    this.p1.start();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.p1.cancel();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\ModeLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */