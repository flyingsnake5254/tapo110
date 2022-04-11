package com.tplink.iot.view.ipcamera.setting.privacymask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.l;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityPrivacyMaskBinding;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.privacymask.PrivacyMaskViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.iot.widget.UniversalDialog.c;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class PrivacyMaskActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int p0;
  private int p1;
  private ActivityPrivacyMaskBinding p2;
  private final LinkedList<ChangeableAreaView> p3 = new LinkedList();
  private String y;
  private PrivacyMaskViewModel z;
  
  private final void j1()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, VideoPlayActivity.class);
    String str = this.y;
    if (str == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    localIntent.putExtra("device_id_md5", str);
    startActivity(localIntent);
  }
  
  private final void k1()
  {
    Object localObject = this.z;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    if (((PrivacyMaskViewModel)localObject).o())
    {
      localObject = PrivacyMaskZonesActivity.z;
      String str = this.y;
      if (str == null) {
        kotlin.jvm.internal.j.t("mDeviceIdMD5");
      }
      ((PrivacyMaskZonesActivity.a)localObject).a(this, str);
    }
    else
    {
      kotlin.jvm.internal.j.d(TSnackbar.x(this, 2131952741, -1), "TSnackbar.make(this, R.s…, TSnackbar.LENGTH_SHORT)");
    }
  }
  
  private final void l1(ChangeableAreaView paramChangeableAreaView, d paramd)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    double d1 = paramd.c();
    double d2 = '✐';
    localLayoutParams.leftMargin = ((int)(d1 * 1.0D / d2 * this.p0));
    localLayoutParams.topMargin = ((int)(paramd.d() * 1.0D / d2 * this.p1));
    localLayoutParams.width = ((int)(paramd.b() * 1.0D / d2 * this.p0));
    localLayoutParams.height = ((int)(paramd.a() * 1.0D / d2 * this.p1));
    paramChangeableAreaView.setLayoutParams(localLayoutParams);
  }
  
  private final void m1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.y = ((String)localObject);
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(PrivacyMaskViewModel.class);
    kotlin.jvm.internal.j.d(localObject, "ViewModelProviders.of(th…askViewModel::class.java)");
    localObject = (PrivacyMaskViewModel)localObject;
    this.z = ((PrivacyMaskViewModel)localObject);
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((PrivacyMaskViewModel)localObject).r(this);
  }
  
  private final void n1()
  {
    ActivityPrivacyMaskBinding localActivityPrivacyMaskBinding = (ActivityPrivacyMaskBinding)DataBindingUtil.setContentView(this, 2131558615);
    kotlin.jvm.internal.j.d(localActivityPrivacyMaskBinding, "this");
    this.p2 = localActivityPrivacyMaskBinding;
    localActivityPrivacyMaskBinding.setLifecycleOwner(this);
    Object localObject = this.z;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localActivityPrivacyMaskBinding.i((PrivacyMaskViewModel)localObject);
    localActivityPrivacyMaskBinding.x.setOnCheckedChangeListener(new a(this));
    localActivityPrivacyMaskBinding.h(this);
    localObject = localActivityPrivacyMaskBinding.f;
    kotlin.jvm.internal.j.d(localObject, "this.privacyMaskContainer");
    p1((View)localObject);
    q1();
    setTitle(2131953852);
  }
  
  private final void o1()
  {
    Object localObject1 = this.p3.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ChangeableAreaView)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject3 = this.p2;
        if (localObject3 == null) {
          kotlin.jvm.internal.j.t("binding");
        }
        ((ActivityPrivacyMaskBinding)localObject3).f.removeView((View)localObject2);
      }
    }
    Object localObject2 = this.z;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    if ((kotlin.jvm.internal.j.a((Boolean)((PrivacyMaskViewModel)localObject2).i().getValue(), Boolean.TRUE) ^ true)) {
      return;
    }
    localObject2 = this.z;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localObject2 = com.tplink.libtpnetwork.Utils.j.e(((PrivacyMaskViewModel)localObject2).k(), new LinkedList());
    kotlin.jvm.internal.j.d(localObject2, "LiveDataUtils.getValue(m…yMaskZones, LinkedList())");
    localObject2 = (List)localObject2;
    if (((List)localObject2).isEmpty()) {
      return;
    }
    this.p3.clear();
    localObject2 = ((Iterable)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d)((Iterator)localObject2).next();
      localObject1 = new ChangeableAreaView(this);
      ((View)localObject1).setBackgroundColor(-16777216);
      ((ChangeableAreaView)localObject1).setBorderColor(-16777216);
      l1((ChangeableAreaView)localObject1, (d)localObject3);
      ((ChangeableAreaView)localObject1).i(false);
      ((ChangeableAreaView)localObject1).setCanBeEdit(false);
      this.p3.add(localObject1);
      localObject3 = this.p2;
      if (localObject3 == null) {
        kotlin.jvm.internal.j.t("binding");
      }
      localObject3 = ((ActivityPrivacyMaskBinding)localObject3).f;
      i++;
      ((FrameLayout)localObject3).addView((View)localObject1, i);
    }
  }
  
  private final void p1(View paramView)
  {
    if ((paramView.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      int i = com.tplink.libtpnetwork.cameranetwork.util.e.b(this)[0];
      this.p0 = i;
      this.p1 = ((int)(i * 9.0D / 16));
      paramView.getLayoutParams().width = this.p0;
      paramView.getLayoutParams().height = this.p1;
    }
  }
  
  private final void q1()
  {
    String str = this.y;
    if (str == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    l.e(str, new b(this));
  }
  
  private final void r1()
  {
    new UniversalDialog.a().q(getString(2131953210)).s(getString(2131951763)).u(getString(2131952751)).t(new d(this)).l().show(getSupportFragmentManager(), "PREVIEW");
  }
  
  private final void s1()
  {
    PrivacyMaskViewModel localPrivacyMaskViewModel = this.z;
    if (localPrivacyMaskViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    com.tplink.libtpnetwork.Utils.j.c(localPrivacyMaskViewModel.m(), this, new e(this));
    localPrivacyMaskViewModel = this.z;
    if (localPrivacyMaskViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localPrivacyMaskViewModel.k().observe(this, new f(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if (((paramView != null) && (paramView.intValue() == 2131363699)) || ((paramView != null) && (paramView.intValue() == 2131363695)))
    {
      paramView = this.z;
      if (paramView == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      if (kotlin.jvm.internal.j.a((Boolean)paramView.i().getValue(), Boolean.TRUE)) {
        k1();
      } else {
        r1();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    m1();
    n1();
    s1();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    new Handler().postDelayed(new c(this), 1500L);
  }
  
  protected void onStart()
  {
    super.onStart();
    PrivacyMaskViewModel localPrivacyMaskViewModel = this.z;
    if (localPrivacyMaskViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localPrivacyMaskViewModel.h();
  }
  
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(PrivacyMaskActivity paramPrivacyMaskActivity) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (paramBoolean != kotlin.jvm.internal.j.a((Boolean)PrivacyMaskActivity.f1(this.a).j().getValue(), Boolean.TRUE))
      {
        kotlin.jvm.internal.j.d(paramCompoundButton, "buttonView");
        if (paramCompoundButton.isPressed()) {
          PrivacyMaskActivity.f1(this.a).s(paramBoolean);
        }
      }
    }
  }
  
  static final class b<T>
    implements b<com.tplink.libtpmediaother.database.model.c>
  {
    b(PrivacyMaskActivity paramPrivacyMaskActivity) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.c paramc)
    {
      if ((paramc != null) && (!TextUtils.isEmpty(paramc.i())))
      {
        paramc = paramc.i();
        PrivacyMaskActivity.f1(this.a).i().setValue(Boolean.TRUE);
        com.bumptech.glide.c.u(this.a.getApplication()).s(paramc).x0(PrivacyMaskActivity.e1(this.a).q);
        PrivacyMaskActivity.h1(this.a);
      }
      else
      {
        PrivacyMaskActivity.f1(this.a).i().setValue(Boolean.FALSE);
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    c(PrivacyMaskActivity paramPrivacyMaskActivity) {}
    
    public final void run()
    {
      PrivacyMaskActivity.i1(this.c);
    }
  }
  
  static final class d
    implements UniversalDialog.c
  {
    d(PrivacyMaskActivity paramPrivacyMaskActivity) {}
    
    public final void a()
    {
      PrivacyMaskActivity.g1(this.a);
    }
  }
  
  static final class e<T>
    implements b<String>
  {
    e(PrivacyMaskActivity paramPrivacyMaskActivity) {}
    
    public final void b(String paramString)
    {
      TSnackbar.y(this.a, paramString, -1).N();
    }
  }
  
  static final class f<T>
    implements Observer<List<? extends d>>
  {
    f(PrivacyMaskActivity paramPrivacyMaskActivity) {}
    
    public final void a(List<? extends d> paramList)
    {
      PrivacyMaskActivity.h1(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\privacymask\PrivacyMaskActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */