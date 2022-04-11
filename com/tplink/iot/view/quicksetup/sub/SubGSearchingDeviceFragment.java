package com.tplink.iot.view.quicksetup.sub;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.cloud.bean.thing.common.SubThingSetupInfo;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.iot.databinding.FragmentSubGSearchingDeviceBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGBaseViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSearchingDeviceViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;
import java.util.Iterator;
import java.util.List;

public class SubGSearchingDeviceFragment
  extends SubGBaseFragment<FragmentSubGSearchingDeviceBinding, SubGSearchingDeviceViewModel>
{
  private com.tplink.iot.widget.plug.a H3;
  private ValueAnimator I3;
  private boolean p0;
  private Bitmap p1;
  private Handler p2 = new Handler();
  private ValueAnimator p3;
  private ValueAnimator x;
  private ValueAnimator y;
  private ValueAnimator z;
  
  private void O0()
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
    if (((FragmentSubGSearchingDeviceBinding)localObject).p0 != null) {
      ((FragmentSubGSearchingDeviceBinding)localObject).p0.f();
    }
    localObject = this.c;
    if (((FragmentSubGSearchingDeviceBinding)localObject).p1 != null) {
      ((FragmentSubGSearchingDeviceBinding)localObject).p1.f();
    }
  }
  
  private void P0()
  {
    Object localObject = this.p3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.p3.cancel();
      this.p3 = null;
    }
    localObject = this.H3;
    if (localObject != null)
    {
      ((com.tplink.iot.widget.plug.a)localObject).b();
      this.H3 = null;
    }
    localObject = this.I3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.I3.cancel();
      this.I3 = null;
    }
  }
  
  private void Q0()
  {
    ((FragmentSubGSearchingDeviceBinding)this.c).H3.setText(getString(2131954133));
    if (this.q.u() == SubDeviceModel.SWITCH_S220) {
      this.f.e0("SwitchQuickSetupGuideFragment", SwitchQuickSetupBaseFragment.I0(SwitchButton.FIRST));
    } else {
      this.f.e0("SubGSetupNameFragment.TAG", null);
    }
  }
  
  private void R0()
  {
    this.p2.postDelayed(new c(), 3000L);
  }
  
  private void S0()
  {
    W0();
    this.p2.postDelayed(new d(), 2000L);
  }
  
  private void U0()
  {
    this.f.e0("SubGNoFoundFragment.TAG", null);
  }
  
  private void V0()
  {
    ((FragmentSubGSearchingDeviceBinding)this.c).f.setTranslationY(0.0F);
    ((FragmentSubGSearchingDeviceBinding)this.c).d.setTranslationY(0.0F);
    ((FragmentSubGSearchingDeviceBinding)this.c).f.setVisibility(0);
    ((FragmentSubGSearchingDeviceBinding)this.c).d.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1000L);
    this.z = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.z.addUpdateListener(new p(this));
    this.z.setRepeatMode(1);
    this.z.setRepeatCount(-1);
    this.z.start();
  }
  
  private void W0()
  {
    if (this.p0) {
      return;
    }
    this.p0 = true;
    final Object localObject = this.c;
    if (((FragmentSubGSearchingDeviceBinding)localObject).c != null)
    {
      final int i = ((FragmentSubGSearchingDeviceBinding)localObject).c.getHeight();
      ((FragmentSubGSearchingDeviceBinding)this.c).c.setImageResource(2131100200);
      ((FragmentSubGSearchingDeviceBinding)this.c).c.setVisibility(0);
      this.p1 = Bitmap.createBitmap(((FragmentSubGSearchingDeviceBinding)this.c).c.getWidth(), i, Bitmap.Config.ARGB_8888);
      final Canvas localCanvas = new Canvas(this.p1);
      localObject = new Paint();
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setFilterBitmap(true);
      ((Paint)localObject).setColor(ContextCompat.getColor(getActivity(), 2131099862));
      final RectF localRectF = new RectF();
      localRectF.left = 0.0F;
      localRectF.right = ((FragmentSubGSearchingDeviceBinding)this.c).c.getWidth();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(80L);
      this.x = localValueAnimator;
      localValueAnimator.setStartDelay(200L);
      this.x.addUpdateListener(new e(localRectF, i, localCanvas, (Paint)localObject));
      this.x.addListener(new f());
      this.x.setRepeatMode(1);
      this.x.setRepeatCount(8);
      this.x.start();
    }
  }
  
  private void X0()
  {
    this.q.y().observe(getViewLifecycleOwner(), new a());
    this.q.u.observe(getViewLifecycleOwner(), new b());
  }
  
  private boolean Y0(SubDeviceModel paramSubDeviceModel, String paramString)
  {
    SubDeviceModel localSubDeviceModel = SubDeviceModel.SWITCH_S210;
    if ((paramSubDeviceModel != localSubDeviceModel) && (paramSubDeviceModel != SubDeviceModel.SWITCH_S220)) {
      return paramSubDeviceModel.value().equalsIgnoreCase(paramString);
    }
    boolean bool;
    if ((!localSubDeviceModel.value().equalsIgnoreCase(paramString)) && (!SubDeviceModel.SWITCH_S220.value().equalsIgnoreCase(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void i1(List<SubThingSetupInfo> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (SubThingSetupInfo)localIterator.next();
      if (Y0(this.q.u(), paramList.getDeviceModel())) {
        break label49;
      }
    }
    paramList = null;
    label49:
    if (paramList == null)
    {
      if ("scanning".equals(paramString))
      {
        paramList = new StringBuilder();
        paramList.append("scanning, 发现的设备列表中无机型：");
        paramList.append(this.q.u().value());
        paramList.append(", 继续扫描");
        b.d.w.c.a.e("subg", paramList.toString());
        R0();
      }
      else
      {
        paramList = new StringBuilder();
        paramList.append("scanning, 发现的设备列表中无机型：");
        paramList.append(this.q.u().value());
        paramList.append(", ---idle 失败");
        b.d.w.c.a.e("subg", paramList.toString());
        U0();
      }
    }
    else
    {
      this.q.y0(paramList.getDeviceId());
      this.q.x0(paramList);
      this.q.z0(paramList.getDeviceModel());
      S0();
    }
  }
  
  private void j1()
  {
    ((FragmentSubGSearchingDeviceBinding)this.c).z.setImageResource(this.q.z().h());
  }
  
  private void k1()
  {
    new TPMaterialDialogV2.Builder(getContext()).h(2131954140).o(2131952441, 2131099808, new m(this)).b(false).c(false).y();
  }
  
  private void l1()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.I3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new n(this));
    this.I3.setRepeatCount(-1);
    this.I3.setRepeatMode(2);
    this.I3.start();
  }
  
  private void m1()
  {
    Object localObject = this.q.z().g();
    if ((localObject != null) && (localObject.length != 0))
    {
      int i = localObject.length;
      int j = 0;
      if (i == 1)
      {
        ((FragmentSubGSearchingDeviceBinding)this.c).y.setVisibility(0);
        ((FragmentSubGSearchingDeviceBinding)this.c).y.setImageResource(localObject[0]);
        localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(500L);
        this.p3 = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).addUpdateListener(new o(this));
        this.p3.setRepeatCount(-1);
        this.p3.setRepeatMode(2);
        this.p3.start();
      }
      else
      {
        ((FragmentSubGSearchingDeviceBinding)this.c).y.setVisibility(0);
        Drawable[] arrayOfDrawable = new Drawable[localObject.length];
        while (j < localObject.length)
        {
          arrayOfDrawable[j] = getResources().getDrawable(localObject[j]);
          j++;
        }
        localObject = new com.tplink.iot.widget.plug.a(arrayOfDrawable, 500L);
        this.H3 = ((com.tplink.iot.widget.plug.a)localObject);
        ((com.tplink.iot.widget.plug.a)localObject).a(((FragmentSubGSearchingDeviceBinding)this.c).y);
        this.H3.c();
      }
    }
    else
    {
      ((FragmentSubGSearchingDeviceBinding)this.c).y.setVisibility(8);
    }
  }
  
  private void n1()
  {
    O0();
    m1();
    l1();
    ((FragmentSubGSearchingDeviceBinding)this.c).p0.e();
    ((FragmentSubGSearchingDeviceBinding)this.c).p1.e();
    SubGViewModel localSubGViewModel = this.q;
    localSubGViewModel.v0(localSubGViewModel.o());
  }
  
  public int B0()
  {
    return 2131558969;
  }
  
  public SubGSearchingDeviceViewModel T0()
  {
    return (SubGSearchingDeviceViewModel)ViewModelProviders.of(this).get(SubGSearchingDeviceViewModel.class);
  }
  
  public void h1()
  {
    this.q.g();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831)
    {
      if (!isAdded()) {
        return;
      }
      this.q.E0(20001);
    }
  }
  
  public void onDestroyView()
  {
    Handler localHandler = this.p2;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    O0();
    P0();
    super.onDestroyView();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    j1();
    this.f.q0();
    this.q.t0();
    n1();
    X0();
  }
  
  class a
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<i<SubThingScanListResult>>>
  {
    a() {}
    
    public void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<i<SubThingScanListResult>> parama)
    {
      Object localObject = (i)parama.a();
      if (localObject == null) {
        return;
      }
      parama = (SubThingScanListResult)((i)localObject).a();
      if ((((i)localObject).b() == 0) && (parama != null))
      {
        localObject = parama.getChildDeviceList();
        parama = parama.getScanStatus();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          b.d.w.c.a.e("subg", "list has value");
          SubGSearchingDeviceFragment.G0(SubGSearchingDeviceFragment.this, (List)localObject, parama);
        }
        else if (TextUtils.equals("scanning", parama))
        {
          b.d.w.c.a.e("subg", "scanning, 继续扫描");
          SubGSearchingDeviceFragment.H0(SubGSearchingDeviceFragment.this);
        }
        else
        {
          b.d.w.c.a.e("subg", "go to SubGNoFoundFragment 11111---idle");
          SubGSearchingDeviceFragment.I0(SubGSearchingDeviceFragment.this);
        }
      }
      else if (((i)localObject).b() == 64525)
      {
        SubGSearchingDeviceFragment.J0(SubGSearchingDeviceFragment.this);
      }
      else
      {
        b.d.w.c.a.e("subg", "go to SubGNoFoundFragment 1111111111----请求失败");
        SubGSearchingDeviceFragment.I0(SubGSearchingDeviceFragment.this);
      }
    }
  }
  
  class b
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    b() {}
    
    public void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      parama = (Boolean)parama.a();
      if (parama == null) {
        return;
      }
      if (parama.booleanValue())
      {
        SubGSearchingDeviceFragment.this.h1();
        SubGSearchingDeviceFragment.K0(SubGSearchingDeviceFragment.this);
      }
      else
      {
        SubGSearchingDeviceFragment.I0(SubGSearchingDeviceFragment.this);
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      SubGViewModel localSubGViewModel = SubGSearchingDeviceFragment.this.q;
      localSubGViewModel.x(localSubGViewModel.o());
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      SubGSearchingDeviceFragment.this.q.f();
    }
  }
  
  class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(RectF paramRectF, int paramInt, Canvas paramCanvas, Paint paramPaint) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramValueAnimator = localRectF;
      int i = i;
      int j = i / 12;
      SubGBaseViewModel localSubGBaseViewModel = SubGSearchingDeviceFragment.this.d;
      paramValueAnimator.top = (i - j - ((SubGSearchingDeviceViewModel)localSubGBaseViewModel).a * i / 8 - 3);
      paramValueAnimator.bottom = (i - ((SubGSearchingDeviceViewModel)localSubGBaseViewModel).a * i / 8 - 3);
      localCanvas.drawRoundRect(paramValueAnimator, 8.0F, 8.0F, localObject);
      paramValueAnimator = SubGSearchingDeviceFragment.this;
      ((FragmentSubGSearchingDeviceBinding)paramValueAnimator.c).c.setImageBitmap(SubGSearchingDeviceFragment.L0(paramValueAnimator));
    }
  }
  
  class f
    implements Animator.AnimatorListener
  {
    f() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = SubGSearchingDeviceFragment.this;
      ((SubGSearchingDeviceViewModel)paramAnimator.d).a = 0;
      SubGSearchingDeviceFragment.N0(paramAnimator);
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      paramAnimator = (SubGSearchingDeviceViewModel)SubGSearchingDeviceFragment.this.d;
      paramAnimator.a += 1;
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGSearchingDeviceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */