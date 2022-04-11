package com.tplink.iot.view.ipcamera.setting.targrttrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.databinding.ActivityTargetTrackBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.targettrack.TargetTrackViewModel;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;

public final class TargetTrackActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  public TargetTrackViewModel p0;
  public CloudVideoViewModel p1;
  private final io.reactivex.e0.b p2 = new io.reactivex.e0.b();
  private int p3 = 3;
  public String z;
  
  private final void g1(Boolean paramBoolean)
  {
    if (kotlin.jvm.internal.j.a(paramBoolean, Boolean.TRUE))
    {
      paramBoolean = this.p0;
      if (paramBoolean == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      paramBoolean.z(false);
    }
    else
    {
      paramBoolean = this.p0;
      if (paramBoolean == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      paramBoolean.i();
    }
  }
  
  private final void k1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.z = ((String)localObject);
    this.p3 = getIntent().getIntExtra("detection_home_mode", 3);
    localObject = this.z;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(TargetTrackViewModel.class);
    kotlin.jvm.internal.j.d(localObject, "ViewModelProviders.of(th…ackViewModel::class.java)");
    this.p0 = ((TargetTrackViewModel)localObject);
    localObject = ViewModelProviders.of(this).get(CloudVideoViewModel.class);
    kotlin.jvm.internal.j.d(localObject, "ViewModelProviders.of(th…deoViewModel::class.java)");
    this.p1 = ((CloudVideoViewModel)localObject);
    localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((TargetTrackViewModel)localObject).v(this.p3);
    localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((TargetTrackViewModel)localObject).y(this);
  }
  
  private final void l1()
  {
    ActivityTargetTrackBinding localActivityTargetTrackBinding = (ActivityTargetTrackBinding)DataBindingUtil.setContentView(this, 2131558689);
    kotlin.jvm.internal.j.d(localActivityTargetTrackBinding, "this");
    localActivityTargetTrackBinding.setLifecycleOwner(this);
    TargetTrackViewModel localTargetTrackViewModel = this.p0;
    if (localTargetTrackViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localActivityTargetTrackBinding.h(localTargetTrackViewModel);
    localActivityTargetTrackBinding.q.setOnClickListener(new b(this));
    setTitle(2131954275);
  }
  
  private final void m1()
  {
    CloudVideoViewModel localCloudVideoViewModel = this.p1;
    if (localCloudVideoViewModel == null) {
      kotlin.jvm.internal.j.t("mCloudVideoViewModel");
    }
    localCloudVideoViewModel.N().observe(this, new Observer()
    {
      public void a(List<? extends OrderInfo> paramAnonymousList)
      {
        this.a.h1().N().removeObserver(this);
        if (this.a.h1().H(paramAnonymousList, ""))
        {
          BillingDialogActivity.f1(this.a, e.x());
        }
        else
        {
          paramAnonymousList = this.a;
          BillingDialogActivity.f1(paramAnonymousList, e.n(h.j(paramAnonymousList.i1())));
        }
      }
    });
  }
  
  private final void n1()
  {
    TargetTrackViewModel localTargetTrackViewModel = this.p0;
    if (localTargetTrackViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    com.tplink.libtpnetwork.Utils.j.c(localTargetTrackViewModel.s(), this, new f(this));
    localTargetTrackViewModel = this.p0;
    if (localTargetTrackViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    com.tplink.libtpnetwork.Utils.j.c(localTargetTrackViewModel.o(), this, new g(this));
    localTargetTrackViewModel = this.p0;
    if (localTargetTrackViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    com.tplink.libtpnetwork.Utils.j.c(localTargetTrackViewModel.p(), this, new h(this));
  }
  
  public final CloudVideoViewModel h1()
  {
    CloudVideoViewModel localCloudVideoViewModel = this.p1;
    if (localCloudVideoViewModel == null) {
      kotlin.jvm.internal.j.t("mCloudVideoViewModel");
    }
    return localCloudVideoViewModel;
  }
  
  public final String i1()
  {
    String str = this.z;
    if (str == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    return str;
  }
  
  public final TargetTrackViewModel j1()
  {
    TargetTrackViewModel localTargetTrackViewModel = this.p0;
    if (localTargetTrackViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    return localTargetTrackViewModel;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1345)
    {
      paramIntent = this.z;
      if (paramIntent == null) {
        kotlin.jvm.internal.j.t("mDeviceIdMD5");
      }
      paramIntent = h.o(paramIntent, false, c.a).H0(d.c, e.c);
      this.p2.b(paramIntent);
      com.tplink.iot.Utils.v0.b.a().b();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    k1();
    l1();
    n1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.p2.d();
  }
  
  protected void onStart()
  {
    super.onStart();
    TargetTrackViewModel localTargetTrackViewModel = this.p0;
    if (localTargetTrackViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localTargetTrackViewModel.k();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      kotlin.jvm.internal.j.e(paramContext, "context");
      kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, TargetTrackActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(TargetTrackActivity paramTargetTrackActivity) {}
    
    public final void onClick(View paramView)
    {
      w.I(this.c.i1(), kotlin.jvm.internal.j.a((Boolean)this.c.j1().r().getValue(), Boolean.FALSE));
      paramView = this.c;
      TargetTrackActivity.e1(paramView, (Boolean)paramView.j1().r().getValue());
    }
  }
  
  static final class c<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<Boolean>
  {
    public static final c a = new c();
    
    public final void b(Boolean paramBoolean) {}
  }
  
  static final class d<T>
    implements g<Integer>
  {
    public static final d c = new d();
    
    public final void a(Integer paramInteger) {}
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    public static final e c = new e();
    
    public final void a(Throwable paramThrowable)
    {
      a.e("CameraSettingsActivity", Log.getStackTraceString(paramThrowable));
    }
  }
  
  static final class f<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<String>
  {
    f(TargetTrackActivity paramTargetTrackActivity) {}
    
    public final void b(String paramString)
    {
      TSnackbar.y(this.a, paramString, -1).N();
    }
  }
  
  static final class g<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<Boolean>
  {
    g(TargetTrackActivity paramTargetTrackActivity) {}
    
    public final void b(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        TargetTrackActivity.f1(this.a);
      }
    }
  }
  
  static final class h<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<Boolean>
  {
    h(TargetTrackActivity paramTargetTrackActivity) {}
    
    public final void b(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        TrialDialogActivity.f1(paramBoolean, e.o(h.j(paramBoolean.i1())));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\targrttrack\TargetTrackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */