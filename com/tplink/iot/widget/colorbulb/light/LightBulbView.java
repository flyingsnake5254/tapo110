package com.tplink.iot.widget.colorbulb.light;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.a;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class LightBulbView
  extends RelativeLayout
{
  private SimpleTextSwitcher H3;
  private View I3;
  private boolean J3 = true;
  int K3;
  int L3;
  int M3;
  private boolean N3 = true;
  private int O3;
  private c P3;
  private ImageView c;
  private ImageView d;
  private LightMaskView f;
  private Animator.AnimatorListener p0;
  private boolean p1;
  private boolean p2;
  private LightBgAnimView p3;
  private TPCheckboxCompat q;
  private d x;
  private int y = 50;
  private ObjectAnimator z;
  
  public LightBulbView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LightBulbView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LightBulbView(@NonNull final Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559429, this, true);
    this.c = ((ImageView)findViewById(2131362021));
    this.d = ((ImageView)findViewById(2131362155));
    this.f = ((LightMaskView)findViewById(2131363409));
    paramAttributeSet = (TPCheckboxCompat)findViewById(2131362156);
    this.q = paramAttributeSet;
    paramAttributeSet.setOnCheckedChangeListener(new a(paramContext));
    paramContext = ObjectAnimator.ofFloat(this, "animValue", new float[] { 0.0F, 1.0F });
    this.z = paramContext;
    paramContext.setInterpolator(new AccelerateDecelerateInterpolator());
    this.z.addListener(new b());
  }
  
  private void n()
  {
    Object localObject = this.I3;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    boolean bool = this.q.isChecked();
    this.d.setVisibility(0);
    localObject = this.c;
    int i;
    if (bool) {
      i = 2131689585;
    } else {
      i = 2131689584;
    }
    ((ImageView)localObject).setImageResource(i);
  }
  
  private void o()
  {
    boolean bool = this.q.isChecked();
    Object localObject = this.I3;
    int i = 0;
    int j;
    if (localObject != null)
    {
      ((View)localObject).setAlpha(1.0F);
      localObject = this.I3;
      if (bool) {
        j = 0;
      } else {
        j = 4;
      }
      ((View)localObject).setVisibility(j);
    }
    localObject = this.d;
    if (bool) {
      j = i;
    } else {
      j = 4;
    }
    ((ImageView)localObject).setVisibility(j);
    localObject = this.c;
    if (bool) {
      j = 2131689585;
    } else {
      j = 2131689584;
    }
    ((ImageView)localObject).setImageResource(j);
  }
  
  private void q(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.y = paramInt1;
    this.q.setChecked(paramBoolean);
    this.f.c(paramBoolean, paramInt1);
    ImageView localImageView = this.d;
    if (paramBoolean) {
      paramInt1 = 0;
    } else {
      paramInt1 = 4;
    }
    localImageView.setVisibility(paramInt1);
  }
  
  private void s()
  {
    c localc = this.P3;
    if (localc != null) {
      localc.dispose();
    }
    this.N3 = false;
    this.O3 = this.f.getBrightness();
    this.P3 = q.a0(500L, 500L, TimeUnit.MILLISECONDS).L0(io.reactivex.l0.a.c()).G0(new c());
  }
  
  public boolean getOnStatus()
  {
    return this.q.isChecked();
  }
  
  public void m(LightBgAnimView paramLightBgAnimView, View paramView, SimpleTextSwitcher paramSimpleTextSwitcher)
  {
    this.p3 = paramLightBgAnimView;
    this.I3 = paramView;
    this.H3 = paramSimpleTextSwitcher;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.q.isChecked()) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          i = (int)(paramMotionEvent.getY() - this.K3);
          i = (int)((this.L3 - i) * 1.0F * 100.0F / this.M3);
          if (i < 1) {
            i = 1;
          } else {
            i = Math.min(i, 100);
          }
          this.f.setBrightness(i);
          paramMotionEvent = this.x;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.L(i);
            paramMotionEvent = this.p3;
            if (paramMotionEvent != null) {
              paramMotionEvent.setBrightness(i);
            }
          }
        }
      }
      else
      {
        if (getParent() != null) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        this.N3 = true;
      }
    }
    else
    {
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.K3 = ((int)paramMotionEvent.getY());
      i = this.f.getMeasuredHeight();
      this.M3 = i;
      this.L3 = ((int)(this.y * 1.0F * i / 100.0F));
      this.N3 = false;
      s();
    }
    return true;
  }
  
  public void p()
  {
    ObjectAnimator localObjectAnimator = this.z;
    if (localObjectAnimator != null)
    {
      localObjectAnimator.cancel();
      this.z = null;
    }
    this.p3 = null;
    this.I3 = null;
  }
  
  public void r(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.p3;
    if (localObject != null) {
      ((LightBgAnimView)localObject).a(paramBoolean, paramInt2, paramInt1);
    }
    boolean bool = this.p2;
    int i = 0;
    if ((bool != paramBoolean) && (!this.J3))
    {
      this.J3 = false;
      this.p2 = paramBoolean;
      this.q.setChecked(paramBoolean);
      if (this.p1)
      {
        b.d.w.c.a.d("bulb anim cancel");
        this.z.cancel();
      }
      this.f.d(paramBoolean, paramInt1);
      localObject = this.H3;
      if (localObject != null) {
        ((SimpleTextSwitcher)localObject).a(paramBoolean, paramInt1, true);
      }
      this.z.setDuration(800L);
      this.z.start();
    }
    else
    {
      this.J3 = false;
      this.p2 = paramBoolean;
      q(paramBoolean, paramInt1, paramInt2);
      localObject = this.H3;
      if (localObject != null) {
        ((SimpleTextSwitcher)localObject).a(paramBoolean, paramInt1, false);
      }
      localObject = this.I3;
      if (localObject != null)
      {
        if (paramBoolean) {
          paramInt1 = i;
        } else {
          paramInt1 = 4;
        }
        ((View)localObject).setVisibility(paramInt1);
      }
    }
  }
  
  @Keep
  public void setAnimValue(float paramFloat)
  {
    this.f.a(paramFloat);
    Object localObject = this.p3;
    if (localObject != null) {
      ((LightBgAnimView)localObject).setAnimValueChange(paramFloat);
    }
    localObject = this.I3;
    if (localObject != null)
    {
      if (!this.q.isChecked()) {
        paramFloat = 1.0F - paramFloat;
      }
      ((View)localObject).setAlpha(paramFloat);
    }
  }
  
  public void setOnBulbOperationListener(d paramd)
  {
    this.x = paramd;
  }
  
  class a
    implements TPCheckboxCompat.a
  {
    a(Context paramContext) {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean2) && (LightBulbView.a(LightBulbView.this) != null))
      {
        LightBulbView.b(LightBulbView.this).setEnabled(false);
        LightBulbView.a(LightBulbView.this).w0(paramBoolean1);
        u0.a(paramContext, 200L);
        LightBulbView.b(LightBulbView.this).postDelayed(new a(), 800L);
      }
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        LightBulbView.b(LightBulbView.this).setEnabled(true);
      }
    }
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      LightBulbView.d(LightBulbView.this, false);
      LightBulbView.e(LightBulbView.this).setRunning(false);
      LightBulbView.i(LightBulbView.this);
      if (LightBulbView.g(LightBulbView.this) != null) {
        LightBulbView.g(LightBulbView.this).setRunning(false);
      }
      if (LightBulbView.h(LightBulbView.this) != null) {
        LightBulbView.h(LightBulbView.this).onAnimationCancel(paramAnimator);
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      LightBulbView.d(LightBulbView.this, false);
      LightBulbView.e(LightBulbView.this).setRunning(false);
      LightBulbView.i(LightBulbView.this);
      if (LightBulbView.g(LightBulbView.this) != null) {
        LightBulbView.g(LightBulbView.this).setRunning(false);
      }
      if (LightBulbView.h(LightBulbView.this) != null) {
        LightBulbView.h(LightBulbView.this).onAnimationEnd(paramAnimator);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (LightBulbView.h(LightBulbView.this) != null) {
        LightBulbView.h(LightBulbView.this).onAnimationRepeat(paramAnimator);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      LightBulbView.d(LightBulbView.this, true);
      LightBulbView.e(LightBulbView.this).setRunning(true);
      LightBulbView.f(LightBulbView.this);
      if (LightBulbView.g(LightBulbView.this) != null) {
        LightBulbView.g(LightBulbView.this).setRunning(true);
      }
      if (LightBulbView.h(LightBulbView.this) != null) {
        LightBulbView.h(LightBulbView.this).onAnimationStart(paramAnimator);
      }
    }
  }
  
  class c
    implements g<Long>
  {
    c() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      int i = LightBulbView.e(LightBulbView.this).getBrightness();
      int j = 1;
      if (i >= 1) {
        j = Math.min(i, 100);
      }
      if ((j != LightBulbView.j(LightBulbView.this)) && (LightBulbView.a(LightBulbView.this) != null)) {
        LightBulbView.a(LightBulbView.this).J(j, LightBulbView.l(LightBulbView.this));
      }
      LightBulbView.k(LightBulbView.this, j);
      if ((LightBulbView.l(LightBulbView.this)) && (LightBulbView.c(LightBulbView.this) != null)) {
        LightBulbView.c(LightBulbView.this).dispose();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void J(int paramInt, boolean paramBoolean);
    
    public abstract void L(int paramInt);
    
    public abstract void w0(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\light\LightBulbView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */