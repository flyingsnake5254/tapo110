package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpcontrols.z0.e;
import com.tplink.libtpcontrols.z0.f;

public class TPSwitchableTab
  extends FrameLayout
  implements View.OnClickListener
{
  View c = null;
  private float d;
  private float f;
  private f p0;
  private e p1;
  private int q = 0;
  private TextView x;
  private TextView y;
  private boolean z = false;
  
  public TPSwitchableTab(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public TPSwitchableTab(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(t0.switchable_tab_main, this, true);
    this.c = findViewById(s0.tab_slider);
    this.x = ((TextView)findViewById(s0.tab_one_title));
    this.y = ((TextView)findViewById(s0.tab_two_title));
    this.c.post(new g0(this));
    s();
  }
  
  public TPSwitchableTab(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    if (this.z) {
      return;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (g())
    {
      if (this.q == 0)
      {
        if ((f1 >= 0.0F) && (f1 <= getWidth() - this.x.getWidth()) && (f2 >= 0.0F) && (f2 <= getHeight())) {
          t();
        }
      }
      else if ((f1 >= this.x.getWidth()) && (f1 <= getWidth()) && (f2 >= 0.0F) && (f2 <= getHeight())) {
        t();
      }
    }
    else if (this.q == 0)
    {
      if ((f1 >= this.x.getWidth()) && (f1 <= getWidth()) && (f2 >= 0.0F) && (f2 <= getHeight())) {
        t();
      }
    }
    else if ((f1 >= 0.0F) && (f1 <= getWidth() - this.x.getWidth()) && (f2 >= 0.0F) && (f2 <= getHeight())) {
      t();
    }
  }
  
  private void f()
  {
    float f1 = Math.abs(this.c.getTranslationX() / this.f);
    int i = this.q;
    if (i == 0)
    {
      if (f1 > 0.35D) {
        t();
      } else {
        r();
      }
    }
    else if (i == 1) {
      if (f1 <= 0.65D) {
        t();
      } else {
        r();
      }
    }
  }
  
  private boolean g()
  {
    int i = getResources().getConfiguration().getLayoutDirection();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private void r()
  {
    float f1 = this.c.getTranslationX() / this.f;
    Object localObject;
    if (this.q == 0)
    {
      localObject = this.c;
      localObject = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { ((View)localObject).getTranslationX(), 0.0F });
      ((ObjectAnimator)localObject).setDuration(f1 * 300L);
    }
    else
    {
      localObject = this.c;
      float f2 = ((View)localObject).getTranslationX();
      float f3;
      if (g()) {
        f3 = -this.f;
      } else {
        f3 = this.f;
      }
      localObject = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { f2, f3 });
      ((ObjectAnimator)localObject).setDuration((1.0F - f1) * 300L);
    }
    ((ObjectAnimator)localObject).start();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void s()
  {
    this.c.setOnTouchListener(new j0(this));
    setOnTouchListener(new i0(this));
  }
  
  private void t()
  {
    this.z = true;
    float f1 = Math.abs(this.c.getTranslationX() / this.f);
    Object localObject;
    if (this.q == 0)
    {
      localObject = this.c;
      float f2 = ((View)localObject).getTranslationX();
      float f3;
      if (g()) {
        f3 = -this.f;
      } else {
        f3 = this.f;
      }
      localObject = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { f2, f3 });
      ((ObjectAnimator)localObject).setDuration((1.0F - f1) * 300L);
    }
    else
    {
      localObject = this.c;
      localObject = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { ((View)localObject).getTranslationX(), 0.0F });
      ((ObjectAnimator)localObject).setDuration(f1 * 300L);
    }
    ((ObjectAnimator)localObject).addListener(new a());
    ((ObjectAnimator)localObject).addUpdateListener(new h0(this));
    ((ObjectAnimator)localObject).start();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == s0.tab_one_title) && (this.q != 0)) {
      t();
    }
    if ((paramView.getId() == s0.tab_two_title) && (this.q != 1)) {
      t();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.c.setEnabled(paramBoolean);
  }
  
  public void setListener(f paramf)
  {
    this.p0 = paramf;
  }
  
  public void setOnTouchCancelListener(e parame)
  {
    this.p1 = parame;
  }
  
  public void setTab(int paramInt)
  {
    if (this.q == paramInt) {
      return;
    }
    this.q = paramInt;
    this.c.post(new f0(this));
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      if (TPSwitchableTab.a(TPSwitchableTab.this) == 0) {
        TPSwitchableTab.b(TPSwitchableTab.this, 1);
      } else {
        TPSwitchableTab.b(TPSwitchableTab.this, 0);
      }
      TPSwitchableTab.c(TPSwitchableTab.this, false);
      if (TPSwitchableTab.d(TPSwitchableTab.this) != null) {
        TPSwitchableTab.d(TPSwitchableTab.this).a(TPSwitchableTab.a(TPSwitchableTab.this));
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (TPSwitchableTab.a(TPSwitchableTab.this) == 0) {
        TPSwitchableTab.b(TPSwitchableTab.this, 1);
      } else {
        TPSwitchableTab.b(TPSwitchableTab.this, 0);
      }
      TPSwitchableTab.c(TPSwitchableTab.this, false);
      if (TPSwitchableTab.d(TPSwitchableTab.this) != null) {
        TPSwitchableTab.d(TPSwitchableTab.this).a(TPSwitchableTab.a(TPSwitchableTab.this));
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPSwitchableTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */