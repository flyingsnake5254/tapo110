package com.tplink.iot.view.ipcamera.onboardingv2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraWiredConnectingBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredConnectingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.OnBoardingFragmentViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;
import io.reactivex.q;

public class CameraWiredConnectingFragment
  extends OnBoardingFragment<FragmentCameraWiredConnectingBinding, CameraWiredConnectingViewModel>
{
  private boolean H3 = true;
  private boolean I3;
  private Handler J3 = new Handler();
  private Bitmap p0;
  private boolean p1;
  private CountDownTimer p2;
  private boolean p3 = false;
  private ValueAnimator x;
  private ValueAnimator y;
  private ValueAnimator z;
  
  private void P0()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.x.cancel();
      this.x = null;
    }
    localObject = this.y;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.y.cancel();
      this.y = null;
    }
    localObject = this.z;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.z.cancel();
      this.z = null;
    }
    localObject = this.c;
    if (((FragmentCameraWiredConnectingBinding)localObject).p2 != null) {
      ((FragmentCameraWiredConnectingBinding)localObject).p2.f();
    }
    localObject = this.c;
    if (((FragmentCameraWiredConnectingBinding)localObject).p1 != null) {
      ((FragmentCameraWiredConnectingBinding)localObject).p1.f();
    }
  }
  
  private void Q0()
  {
    CountDownTimer localCountDownTimer = this.p2;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      this.p2 = null;
    }
  }
  
  private void R0()
  {
    this.p3 = true;
    if (isAdded()) {
      ((FragmentCameraWiredConnectingBinding)this.c).J3.setText(getString(2131953582));
    }
    ((FragmentCameraWiredConnectingBinding)this.c).p0.setVisibility(4);
    ((FragmentCameraWiredConnectingBinding)this.c).p0.setVisibility(0);
    ((FragmentCameraWiredConnectingBinding)this.c).c.setVisibility(4);
    ((FragmentCameraWiredConnectingBinding)this.c).p1.setTranslationY(0.0F);
    ValueAnimator localValueAnimator = this.z;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.z.cancel();
      this.z = null;
    }
    ((FragmentCameraWiredConnectingBinding)this.c).q.setVisibility(4);
    ((FragmentCameraWiredConnectingBinding)this.c).x.setVisibility(4);
    ((FragmentCameraWiredConnectingBinding)this.c).p1.f();
    ((FragmentCameraWiredConnectingBinding)this.c).p2.f();
    this.p1 = false;
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 400.0F }).setDuration(4000L);
    this.y = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.y.addUpdateListener(new d());
    this.y.addListener(new e());
    this.y.start();
  }
  
  private void T0()
  {
    this.p3 = false;
    this.q.e2(null);
    this.p2 = new b(30000L, 1000L);
    ViewDataBinding localViewDataBinding = this.c;
    if (((FragmentCameraWiredConnectingBinding)localViewDataBinding).p0 != null) {
      ((FragmentCameraWiredConnectingBinding)localViewDataBinding).p0.getViewTreeObserver().addOnGlobalLayoutListener(new c());
    }
  }
  
  private void U0()
  {
    if (this.p3) {
      return;
    }
    ((FragmentCameraWiredConnectingBinding)this.c).x.setTranslationY(0.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).q.setTranslationY(0.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).x.setVisibility(0);
    ((FragmentCameraWiredConnectingBinding)this.c).q.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1000L);
    this.z = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.z.addUpdateListener(new p1(this));
    this.z.setRepeatMode(1);
    this.z.setRepeatCount(-1);
    this.z.start();
  }
  
  private void V0()
  {
    if (this.I3) {
      return;
    }
    this.I3 = true;
    Object localObject = this.c;
    if (((FragmentCameraWiredConnectingBinding)localObject).c != null)
    {
      final int i = ((FragmentCameraWiredConnectingBinding)localObject).c.getHeight();
      ((FragmentCameraWiredConnectingBinding)this.c).c.setImageResource(2131100200);
      ((FragmentCameraWiredConnectingBinding)this.c).c.setVisibility(0);
      this.p0 = Bitmap.createBitmap(((FragmentCameraWiredConnectingBinding)this.c).c.getWidth(), i, Bitmap.Config.ARGB_8888);
      final Canvas localCanvas = new Canvas(this.p0);
      final Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setFilterBitmap(true);
      localPaint.setColor(ContextCompat.getColor(getActivity(), 2131099862));
      final RectF localRectF = new RectF();
      localRectF.left = 0.0F;
      localRectF.right = ((FragmentCameraWiredConnectingBinding)this.c).c.getWidth();
      localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(80L);
      this.x = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setStartDelay(200L);
      this.x.addUpdateListener(new f(localRectF, i, localCanvas, localPaint));
      this.x.addListener(new g());
      this.x.setRepeatMode(1);
      this.x.setRepeatCount(8);
      this.x.start();
    }
  }
  
  private void o1()
  {
    this.I3 = false;
    ((FragmentCameraWiredConnectingBinding)this.c).q.setVisibility(4);
    ((FragmentCameraWiredConnectingBinding)this.c).q.setTranslationY(0.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).x.setVisibility(4);
    ((FragmentCameraWiredConnectingBinding)this.c).x.setTranslationY(0.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).c.setImageResource(2131100200);
    ((FragmentCameraWiredConnectingBinding)this.c).c.setVisibility(0);
    ((FragmentCameraWiredConnectingBinding)this.c).c.setTranslationY(0.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).c.setAlpha(1.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).p1.setVisibility(0);
    ((FragmentCameraWiredConnectingBinding)this.c).p1.setTranslationY(0.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).p0.setVisibility(0);
    ((FragmentCameraWiredConnectingBinding)this.c).p0.setAlpha(1.0F);
    ((FragmentCameraWiredConnectingBinding)this.c).I3.setVisibility(0);
    ((FragmentCameraWiredConnectingBinding)this.c).I3.setAlpha(1.0F);
  }
  
  private void p1()
  {
    P0();
    o1();
    ((FragmentCameraWiredConnectingBinding)this.c).p1.e();
    ((FragmentCameraWiredConnectingBinding)this.c).p2.e();
    this.q.O1().E(new u1(this)).F0();
  }
  
  private void q1()
  {
    if (!this.q.h0())
    {
      V0();
      this.q.W1();
    }
  }
  
  private void r1()
  {
    ((FragmentCameraWiredConnectingBinding)this.c).p0.setImageResource(c.e(this.q.D()));
  }
  
  private void s1()
  {
    if (!isAdded()) {
      return;
    }
    UniversalDialog localUniversalDialog = new UniversalDialog.a().q(getString(2131952053)).u(getString(2131952752)).s(getString(2131951757)).t(new n1(this)).r(new s1(this)).l();
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    localFragmentTransaction.add(localUniversalDialog, "");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void t1()
  {
    this.q.I().observe(this, new m1(this));
    this.q.H().observe(this, new r1(this));
    this.q.K().observe(this, new q1(this));
  }
  
  public int A0()
  {
    return 2131558905;
  }
  
  public CameraWiredConnectingViewModel S0()
  {
    return (CameraWiredConnectingViewModel)ViewModelProviders.of(this).get(CameraWiredConnectingViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831)
    {
      if (!isAdded()) {
        return;
      }
      this.q.o2(20001);
    }
  }
  
  public void onDestroyView()
  {
    this.q.q2();
    super.onDestroyView();
    this.J3.removeCallbacksAndMessages(null);
    P0();
    Q0();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    r1();
    this.f.q0();
    this.q.n2(10002);
    T0();
    t1();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      CameraWiredConnectingFragment.this.q.l();
    }
  }
  
  class b
    extends CountDownTimer
  {
    b(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      f.H();
      CameraWiredConnectingFragment.this.q.q2();
      CameraWiredConnectingFragment.this.f.e0("CameraNotFoundFragment.TAG", null);
    }
    
    public void onTick(long paramLong)
    {
      if (CameraWiredConnectingFragment.G0(CameraWiredConnectingFragment.this))
      {
        CameraWiredConnectingFragment.H0(CameraWiredConnectingFragment.this, false);
        CameraWiredConnectingFragment.I0(CameraWiredConnectingFragment.this);
      }
    }
  }
  
  class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c() {}
    
    public void onGlobalLayout()
    {
      ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).p0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      CameraWiredConnectingFragment.J0(CameraWiredConnectingFragment.this);
    }
  }
  
  class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramValueAnimator = CameraWiredConnectingFragment.this.c;
      if (((FragmentCameraWiredConnectingBinding)paramValueAnimator).H3 == null) {
        return;
      }
      if (((FragmentCameraWiredConnectingBinding)paramValueAnimator).f == null) {
        return;
      }
      if (f1 < 60.0F) {
        ((FragmentCameraWiredConnectingBinding)paramValueAnimator).p1.setTranslationY(f1 / 60.0F * (((FragmentCameraWiredConnectingBinding)paramValueAnimator).c.getHeight() + ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).p0.getHeight()));
      }
      if ((f1 > 45.0F) && (f1 <= 100.0F))
      {
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).I3.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).p3.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).H3.setVisibility(0);
      }
      float f2;
      if ((f1 > 40.0F) && (f1 <= 100.0F))
      {
        paramValueAnimator = CameraWiredConnectingFragment.this.c;
        ((FragmentCameraWiredConnectingBinding)paramValueAnimator).H3.setTranslationY((40.0F - f1) / 100.0F * ((FragmentCameraWiredConnectingBinding)paramValueAnimator).c.getHeight());
        paramValueAnimator = ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).H3;
        f2 = (f1 - 40.0F) / 100.0F + 1.0F;
        paramValueAnimator.setScaleX(f2);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).H3.setScaleY(f2);
      }
      if ((f1 >= 100.0F) && (f1 <= 200.0F))
      {
        paramValueAnimator = ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).f;
        f2 = (f1 - 100.0F) / 100.0F;
        paramValueAnimator.setScaleX(f2);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).f.setScaleY(f2);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).f.setVisibility(0);
      }
      if ((f1 >= 200.0F) && (f1 <= 300.0F) && (!CameraWiredConnectingFragment.K0(CameraWiredConnectingFragment.this)))
      {
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).f.h();
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).J3.setText("");
        CameraWiredConnectingFragment.L0(CameraWiredConnectingFragment.this, true);
      }
      if (f1 > 300.0F)
      {
        paramValueAnimator = ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).f;
        f2 = 400.0F - f1;
        float f3 = f2 / 110.0F;
        paramValueAnimator.setScaleX(f3);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).f.setScaleY(f3);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).J3.setAlpha(f2 * 1.0F / 100.0F);
        paramValueAnimator = ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).H3;
        f1 = (f1 - 300.0F) * 8.0F / 100.0F + 1.6F;
        paramValueAnimator.setScaleX(f1);
        ((FragmentCameraWiredConnectingBinding)CameraWiredConnectingFragment.this.c).H3.setScaleY(f1);
      }
    }
  }
  
  class e
    implements Animator.AnimatorListener
  {
    e() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      CameraWiredConnectingFragment.this.f.e0("CameraSetNameFragment.TAG", null);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(RectF paramRectF, int paramInt, Canvas paramCanvas, Paint paramPaint) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramValueAnimator = localRectF;
      int i = i;
      int j = i / 12;
      OnBoardingFragmentViewModel localOnBoardingFragmentViewModel = CameraWiredConnectingFragment.this.d;
      paramValueAnimator.top = (i - j - ((CameraWiredConnectingViewModel)localOnBoardingFragmentViewModel).a * i / 8 - 3);
      paramValueAnimator.bottom = (i - ((CameraWiredConnectingViewModel)localOnBoardingFragmentViewModel).a * i / 8 - 3);
      localCanvas.drawRoundRect(paramValueAnimator, 8.0F, 8.0F, localPaint);
      paramValueAnimator = CameraWiredConnectingFragment.this;
      ((FragmentCameraWiredConnectingBinding)paramValueAnimator.c).c.setImageBitmap(CameraWiredConnectingFragment.N0(paramValueAnimator));
    }
  }
  
  class g
    implements Animator.AnimatorListener
  {
    g() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = CameraWiredConnectingFragment.this;
      ((CameraWiredConnectingViewModel)paramAnimator.d).a = 0;
      CameraWiredConnectingFragment.O0(paramAnimator);
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      paramAnimator = (CameraWiredConnectingViewModel)CameraWiredConnectingFragment.this.d;
      paramAnimator.a += 1;
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraWiredConnectingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */