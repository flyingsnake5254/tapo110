package com.tplink.iot.devices.lightstrip.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.databinding.LayoutLightStripDetailBgBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LightStripDetailBgLayout
  extends FrameLayout
{
  private final LayoutLightStripDetailBgBinding c;
  private final RippleRevealFrameLayout d;
  private final long f;
  private final ValueAnimator q;
  private boolean x;
  private boolean y;
  private final List<View> z;
  
  public LightStripDetailBgLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightStripDetailBgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightStripDetailBgLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559171, this, true);
    j.d(paramContext, "DataBindingUtil.inflate(…ip_detail_bg, this, true)");
    paramContext = (LayoutLightStripDetailBgBinding)paramContext;
    this.c = paramContext;
    paramContext = paramContext.c;
    j.d(paramContext, "mBinding.bgRippleLayout");
    this.d = paramContext;
    this.f = 800L;
    paramAttributeSet = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramAttributeSet.setDuration(800L);
    paramAttributeSet.addUpdateListener(new a(this));
    p localp = p.a;
    this.q = paramAttributeSet;
    this.y = true;
    this.z = new ArrayList();
    paramContext.setAnimDuration(800L);
  }
  
  private final void c(float paramFloat)
  {
    Object localObject = this.c.d;
    j.d(localObject, "mBinding.bgViewBottom");
    ((View)localObject).setAlpha(1 - paramFloat);
    localObject = this.z.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).setAlpha(paramFloat);
    }
  }
  
  private final void e(boolean paramBoolean)
  {
    if ((this.x == paramBoolean) && (!this.y)) {
      return;
    }
    this.x = paramBoolean;
    if (this.y)
    {
      this.y = false;
      Object localObject = this.d;
      if (paramBoolean) {
        ((RippleRevealFrameLayout)localObject).d();
      } else {
        ((RippleRevealFrameLayout)localObject).b();
      }
      localObject = this.c.d;
      j.d(localObject, "mBinding.bgViewBottom");
      float f1;
      if (paramBoolean) {
        f1 = 0.0F;
      } else {
        f1 = 1.0F;
      }
      ((View)localObject).setAlpha(f1);
    }
    else
    {
      this.q.cancel();
      if (paramBoolean)
      {
        this.d.c();
        this.q.setFloatValues(new float[] { 0.0F, 1.0F });
        this.q.start();
      }
      else
      {
        this.d.a();
        this.q.setFloatValues(new float[] { 1.0F, 0.0F });
        this.q.start();
      }
    }
  }
  
  public final void b(View paramView)
  {
    j.e(paramView, "view");
    if (!this.z.contains(paramView)) {
      this.z.add(paramView);
    }
  }
  
  public final void d(boolean paramBoolean, int paramInt)
  {
    e(paramBoolean);
    if (paramBoolean)
    {
      View localView = this.c.q;
      j.d(localView, "mBinding.maskView");
      localView.setAlpha(1 - paramInt / 100.0F);
    }
  }
  
  public final void f(List<Integer> paramList)
  {
    j.e(paramList, "colors");
    this.c.f.b(paramList);
  }
  
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(LightStripDetailBgLayout paramLightStripDetailBgLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      LightStripDetailBgLayout localLightStripDetailBgLayout = this.c;
      j.d(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
      LightStripDetailBgLayout.a(localLightStripDetailBgLayout, ((Float)paramValueAnimator).floatValue());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightStripDetailBgLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */