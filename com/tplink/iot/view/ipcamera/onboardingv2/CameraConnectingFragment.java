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
import android.text.TextUtils;
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
import com.tplink.iot.databinding.FragmentCameraV2ConnectingBinding;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer.a;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpwifi.b;

public class CameraConnectingFragment
  extends OnBoardingFragment<FragmentCameraV2ConnectingBinding, CameraConnectingViewModel>
  implements AutoRefreshTimer.a
{
  private boolean H3 = false;
  private boolean I3 = true;
  private boolean J3 = true;
  private boolean K3;
  private Handler L3 = new Handler();
  private boolean M3 = false;
  private Bitmap p0;
  private boolean p1;
  private AutoRefreshTimer p2;
  private CountDownTimer p3;
  private ValueAnimator x;
  private ValueAnimator y;
  private ValueAnimator z;
  
  private void U0()
  {
    if (this.q.V())
    {
      AutoRefreshTimer localAutoRefreshTimer = new AutoRefreshTimer(0L, 3000L, this);
      this.p2 = localAutoRefreshTimer;
      localAutoRefreshTimer.a(this);
    }
  }
  
  private void V0()
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
    if (((FragmentCameraV2ConnectingBinding)localObject).p2 != null) {
      ((FragmentCameraV2ConnectingBinding)localObject).p2.f();
    }
    localObject = this.c;
    if (((FragmentCameraV2ConnectingBinding)localObject).p1 != null) {
      ((FragmentCameraV2ConnectingBinding)localObject).p1.f();
    }
  }
  
  private void W0()
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      ((AutoRefreshTimer)localObject).cancel();
      this.p2 = null;
    }
    localObject = this.p3;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      this.p3 = null;
    }
  }
  
  private void X0()
  {
    this.H3 = true;
    if (isAdded()) {
      ((FragmentCameraV2ConnectingBinding)this.c).J3.setText(getString(2131953582));
    }
    ((FragmentCameraV2ConnectingBinding)this.c).p0.setVisibility(4);
    ((FragmentCameraV2ConnectingBinding)this.c).p0.setVisibility(0);
    ((FragmentCameraV2ConnectingBinding)this.c).c.setVisibility(4);
    ((FragmentCameraV2ConnectingBinding)this.c).p1.setTranslationY(0.0F);
    ValueAnimator localValueAnimator = this.z;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.z.cancel();
      this.z = null;
    }
    ((FragmentCameraV2ConnectingBinding)this.c).q.setVisibility(4);
    ((FragmentCameraV2ConnectingBinding)this.c).x.setVisibility(4);
    ((FragmentCameraV2ConnectingBinding)this.c).p1.f();
    ((FragmentCameraV2ConnectingBinding)this.c).p2.f();
    this.p1 = false;
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 400.0F }).setDuration(4000L);
    this.y = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.y.addUpdateListener(new c());
    this.y.start();
  }
  
  private void Z0()
  {
    this.H3 = false;
    this.p3 = new a(45000L, 1000L);
    ViewDataBinding localViewDataBinding = this.c;
    if (((FragmentCameraV2ConnectingBinding)localViewDataBinding).p0 != null) {
      ((FragmentCameraV2ConnectingBinding)localViewDataBinding).p0.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }
  }
  
  private void a1()
  {
    if (this.H3) {
      return;
    }
    ((FragmentCameraV2ConnectingBinding)this.c).x.setTranslationY(0.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).q.setTranslationY(0.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).x.setVisibility(0);
    ((FragmentCameraV2ConnectingBinding)this.c).q.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1000L);
    this.z = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.z.addUpdateListener(new q(this));
    this.z.setRepeatMode(1);
    this.z.setRepeatCount(-1);
    this.z.start();
  }
  
  private void b1()
  {
    if (this.K3) {
      return;
    }
    this.K3 = true;
    Object localObject = this.c;
    if (((FragmentCameraV2ConnectingBinding)localObject).c != null)
    {
      final int i = ((FragmentCameraV2ConnectingBinding)localObject).c.getHeight();
      ((FragmentCameraV2ConnectingBinding)this.c).c.setImageResource(2131100200);
      ((FragmentCameraV2ConnectingBinding)this.c).c.setVisibility(0);
      this.p0 = Bitmap.createBitmap(((FragmentCameraV2ConnectingBinding)this.c).c.getWidth(), i, Bitmap.Config.ARGB_8888);
      final Canvas localCanvas = new Canvas(this.p0);
      final Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setFilterBitmap(true);
      localPaint.setColor(ContextCompat.getColor(getActivity(), 2131099862));
      final RectF localRectF = new RectF();
      localRectF.left = 0.0F;
      localRectF.right = ((FragmentCameraV2ConnectingBinding)this.c).c.getWidth();
      localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(80L);
      this.x = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setStartDelay(200L);
      this.x.addUpdateListener(new d(localRectF, i, localCanvas, localPaint));
      this.x.addListener(new e());
      this.x.setRepeatMode(1);
      this.x.setRepeatCount(8);
      this.x.start();
    }
  }
  
  private void u1()
  {
    this.K3 = false;
    ((FragmentCameraV2ConnectingBinding)this.c).q.setVisibility(4);
    ((FragmentCameraV2ConnectingBinding)this.c).q.setTranslationY(0.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).x.setVisibility(4);
    ((FragmentCameraV2ConnectingBinding)this.c).x.setTranslationY(0.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).c.setImageResource(2131100200);
    ((FragmentCameraV2ConnectingBinding)this.c).c.setVisibility(0);
    ((FragmentCameraV2ConnectingBinding)this.c).c.setTranslationY(0.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).c.setAlpha(1.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).p1.setVisibility(0);
    ((FragmentCameraV2ConnectingBinding)this.c).p1.setTranslationY(0.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).p0.setVisibility(0);
    ((FragmentCameraV2ConnectingBinding)this.c).p0.setAlpha(1.0F);
    ((FragmentCameraV2ConnectingBinding)this.c).I3.setVisibility(0);
    ((FragmentCameraV2ConnectingBinding)this.c).I3.setAlpha(1.0F);
  }
  
  private void v1()
  {
    V0();
    u1();
    ((FragmentCameraV2ConnectingBinding)this.c).p1.e();
    ((FragmentCameraV2ConnectingBinding)this.c).p2.e();
    this.q.O1().E(new t(this)).F0();
  }
  
  private void w1()
  {
    if (!this.q.h0())
    {
      b1();
      this.q.W1();
    }
  }
  
  private void x1()
  {
    ((FragmentCameraV2ConnectingBinding)this.c).p0.setImageResource(c.e(this.q.D()));
  }
  
  private void y1()
  {
    if (!isAdded()) {
      return;
    }
    UniversalDialog localUniversalDialog = new UniversalDialog.a().q(getString(2131952053)).u(getString(2131952752)).s(getString(2131951757)).t(new u(this)).r(new r(this)).n(false).l();
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    localFragmentTransaction.add(localUniversalDialog, "");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void z1()
  {
    this.q.I().observe(this, new v(this));
    this.q.L().observe(this, new y(this));
    this.q.K().observe(this, new x(this));
  }
  
  public int A0()
  {
    return 2131558873;
  }
  
  public CameraConnectingViewModel Y0()
  {
    return (CameraConnectingViewModel)ViewModelProviders.of(this).get(CameraConnectingViewModel.class);
  }
  
  public void h()
  {
    if (!this.q.V()) {
      return;
    }
    if (!this.q.d0()) {
      com.tplink.iot.Utils.y.b(this.q.Q(), null, null);
    }
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
    super.onDestroyView();
    this.L3.removeCallbacksAndMessages(null);
    V0();
    W0();
  }
  
  public void onResume()
  {
    super.onResume();
    U0();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    x1();
    this.f.q0();
    this.q.n2(10002);
    Z0();
    z1();
  }
  
  class a
    extends CountDownTimer
  {
    a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      f.H();
      CameraConnectingFragment.this.q.q2();
      CameraConnectingFragment.this.f.e0("CameraNotFoundFragment.TAG", null);
    }
    
    public void onTick(long paramLong)
    {
      if ((!CameraConnectingFragment.this.q.V()) && (!CameraConnectingFragment.G0(CameraConnectingFragment.this)))
      {
        CameraConnectingFragment.H0(CameraConnectingFragment.this, true);
        CameraConnectingFragment.I0(CameraConnectingFragment.this);
        return;
      }
      if ((paramLong < 37000L) && (!CameraConnectingFragment.this.q.d0())) {
        CameraConnectingFragment.this.f.e0("CameraInstructionFragment.TAG", null);
      }
      if ((CameraConnectingFragment.this.q.d0()) && (!CameraConnectingFragment.G0(CameraConnectingFragment.this)))
      {
        if (CameraConnectingFragment.J0(CameraConnectingFragment.this))
        {
          f.s(CameraConnectingFragment.this.q.Q());
          CameraConnectingFragment.K0(CameraConnectingFragment.this, false);
        }
        CameraConnectingFragment.H0(CameraConnectingFragment.this, true);
        CameraConnectingFragment.I0(CameraConnectingFragment.this);
      }
      else if (CameraConnectingFragment.L0(CameraConnectingFragment.this))
      {
        String str = b.k().j();
        if ((str != null) && (!TextUtils.equals(str, "00:00:00:00:00:00")))
        {
          f.E();
          CameraConnectingFragment.N0(CameraConnectingFragment.this, false);
        }
      }
    }
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public void onGlobalLayout()
    {
      ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).p0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      CameraConnectingFragment.O0(CameraConnectingFragment.this);
    }
  }
  
  class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramValueAnimator = CameraConnectingFragment.this.c;
      if (((FragmentCameraV2ConnectingBinding)paramValueAnimator).H3 == null) {
        return;
      }
      if (((FragmentCameraV2ConnectingBinding)paramValueAnimator).f == null) {
        return;
      }
      if (f1 < 60.0F) {
        ((FragmentCameraV2ConnectingBinding)paramValueAnimator).p1.setTranslationY(f1 / 60.0F * (((FragmentCameraV2ConnectingBinding)paramValueAnimator).c.getHeight() + ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).p0.getHeight()));
      }
      if ((f1 > 45.0F) && (f1 <= 100.0F))
      {
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).I3.setVisibility(4);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).p3.setVisibility(4);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).H3.setVisibility(0);
      }
      float f2;
      if ((f1 > 40.0F) && (f1 <= 100.0F))
      {
        paramValueAnimator = CameraConnectingFragment.this.c;
        ((FragmentCameraV2ConnectingBinding)paramValueAnimator).H3.setTranslationY((40.0F - f1) / 100.0F * ((FragmentCameraV2ConnectingBinding)paramValueAnimator).c.getHeight());
        paramValueAnimator = ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).H3;
        f2 = (f1 - 40.0F) / 100.0F + 1.0F;
        paramValueAnimator.setScaleX(f2);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).H3.setScaleY(f2);
      }
      if ((f1 >= 100.0F) && (f1 <= 200.0F))
      {
        paramValueAnimator = ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).f;
        f2 = (f1 - 100.0F) / 100.0F;
        paramValueAnimator.setScaleX(f2);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).f.setScaleY(f2);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).f.setVisibility(0);
      }
      if ((f1 >= 200.0F) && (f1 <= 300.0F) && (!CameraConnectingFragment.P0(CameraConnectingFragment.this)))
      {
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).f.h();
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).J3.setText("");
        CameraConnectingFragment.Q0(CameraConnectingFragment.this, true);
      }
      if (f1 > 300.0F)
      {
        paramValueAnimator = ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).f;
        f2 = 400.0F - f1;
        float f3 = f2 / 110.0F;
        paramValueAnimator.setScaleX(f3);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).f.setScaleY(f3);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).J3.setAlpha(f2 * 1.0F / 100.0F);
        paramValueAnimator = ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).H3;
        f2 = (f1 - 300.0F) * 8.0F / 100.0F + 1.6F;
        paramValueAnimator.setScaleX(f2);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).H3.setScaleY(f2);
      }
      if (f1 >= 400.0F)
      {
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).f.setVisibility(4);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).H3.setVisibility(4);
        if (CameraConnectingFragment.R0(CameraConnectingFragment.this) != null) {
          CameraConnectingFragment.R0(CameraConnectingFragment.this).cancel();
        }
        CameraConnectingFragment.Q0(CameraConnectingFragment.this, false);
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).p1.e();
        ((FragmentCameraV2ConnectingBinding)CameraConnectingFragment.this.c).J3.setAlpha(1.0F);
        if (CameraConnectingFragment.this.isAdded())
        {
          paramValueAnimator = CameraConnectingFragment.this;
          ((FragmentCameraV2ConnectingBinding)paramValueAnimator.c).J3.setText(paramValueAnimator.getString(2131953617));
        }
      }
    }
  }
  
  class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(RectF paramRectF, int paramInt, Canvas paramCanvas, Paint paramPaint) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      RectF localRectF = localRectF;
      int i = i;
      int j = i / 12;
      paramValueAnimator = CameraConnectingFragment.this.d;
      localRectF.top = (i - j - ((CameraConnectingViewModel)paramValueAnimator).a * i / 8 - 3);
      localRectF.bottom = (i - ((CameraConnectingViewModel)paramValueAnimator).a * i / 8 - 3);
      localCanvas.drawRoundRect(localRectF, 8.0F, 8.0F, localPaint);
      paramValueAnimator = CameraConnectingFragment.this;
      ((FragmentCameraV2ConnectingBinding)paramValueAnimator.c).c.setImageBitmap(CameraConnectingFragment.S0(paramValueAnimator));
    }
  }
  
  class e
    implements Animator.AnimatorListener
  {
    e() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = CameraConnectingFragment.this;
      ((CameraConnectingViewModel)paramAnimator.d).a = 0;
      CameraConnectingFragment.T0(paramAnimator);
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      paramAnimator = (CameraConnectingViewModel)CameraConnectingFragment.this.d;
      paramAnimator.a += 1;
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraConnectingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */