package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.databinding.ActivityMsgPushBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.MsgPushViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.EventObserver;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;

public final class MsgPushActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private int H3 = 3;
  private HashMap I3;
  private ActivityMsgPushBinding p0;
  private MsgPushViewModel p1;
  private CloudVideoViewModel p2;
  private String p3;
  private final int z = 111;
  
  private final void k1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.p3 = ((String)localObject);
    this.H3 = getIntent().getIntExtra("detection_home_mode", 3);
    localObject = this.p3;
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(MsgPushViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ushViewModel::class.java)");
    this.p1 = ((MsgPushViewModel)localObject);
    localObject = ViewModelProviders.of(this).get(CloudVideoViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…deoViewModel::class.java]");
    this.p2 = ((CloudVideoViewModel)localObject);
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    MsgPushViewModel localMsgPushViewModel = this.p1;
    if (localMsgPushViewModel == null) {
      j.t("viewModel");
    }
    ((ActivityMsgPushBinding)localObject).i(localMsgPushViewModel);
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivityMsgPushBinding)localObject).h(this);
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    ((MsgPushViewModel)localObject).m(this.H3);
  }
  
  private final void l1()
  {
    MsgPushViewModel localMsgPushViewModel = this.p1;
    if (localMsgPushViewModel == null) {
      j.t("viewModel");
    }
    localMsgPushViewModel.a.observe(this, new b(this));
    localMsgPushViewModel = this.p1;
    if (localMsgPushViewModel == null) {
      j.t("viewModel");
    }
    localMsgPushViewModel.b.observe(this, new c(this));
    localMsgPushViewModel = this.p1;
    if (localMsgPushViewModel == null) {
      j.t("viewModel");
    }
    localMsgPushViewModel.o.observe(this, new EventObserver(new d(this)));
    localMsgPushViewModel = this.p1;
    if (localMsgPushViewModel == null) {
      j.t("viewModel");
    }
    localMsgPushViewModel.p.observe(this, new EventObserver(new e(this)));
    localMsgPushViewModel = this.p1;
    if (localMsgPushViewModel == null) {
      j.t("viewModel");
    }
    localMsgPushViewModel.q.observe(this, new EventObserver(new f(this)));
  }
  
  private final void m1()
  {
    b1(2131951770);
  }
  
  private final void n1()
  {
    CloudVideoViewModel localCloudVideoViewModel = this.p2;
    if (localCloudVideoViewModel == null) {
      j.t("mCloudVideoViewModel");
    }
    localCloudVideoViewModel.N().observe(this, new Observer()
    {
      public void a(List<? extends OrderInfo> paramAnonymousList)
      {
        MsgPushActivity.g1(this.a).N().removeObserver(this);
        if (MsgPushActivity.g1(this.a).H(paramAnonymousList, ""))
        {
          BillingDialogActivity.f1(this.a, e.x());
        }
        else
        {
          paramAnonymousList = this.a;
          BillingDialogActivity.f1(paramAnonymousList, e.u(h.j(MsgPushActivity.f1(paramAnonymousList))));
        }
      }
    });
  }
  
  private final void o1()
  {
    Intent localIntent = new Intent(this, MsgPushCustomTimeActivity.class);
    Object localObject = this.p3;
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localIntent.putExtra("device_id_md5", (String)localObject);
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localIntent.putExtra("startTime", ((MsgPushViewModel)localObject).h.get());
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localIntent.putExtra("endTime", ((MsgPushViewModel)localObject).i.get());
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localIntent.putExtra("weekday", ((MsgPushViewModel)localObject).j.get());
    startActivityForResult(localIntent, this.z);
  }
  
  private final void p1()
  {
    new TPMaterialDialogV2.Builder(this).i(2131953668, 2131099788).o(2131953975, 2131099808, new j(this)).l(2131952391, 2131099804, new k(this)).b(false).c(false).g(8, 8).y();
  }
  
  public View e1(int paramInt)
  {
    if (this.I3 == null) {
      this.I3 = new HashMap();
    }
    View localView1 = (View)this.I3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.I3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == this.z) && (paramInt2 == -1) && (paramIntent != null))
    {
      int i = paramIntent.getIntExtra("startTime", 540);
      paramInt1 = paramIntent.getIntExtra("endTime", 1020);
      paramInt2 = paramIntent.getIntExtra("weekday", 127);
      paramIntent = this.p1;
      if (paramIntent == null) {
        j.t("viewModel");
      }
      paramIntent.s0(i, paramInt1, paramInt2);
      MsgPushViewModel localMsgPushViewModel = this.p1;
      if (localMsgPushViewModel == null) {
        j.t("viewModel");
      }
      paramIntent = this.p1;
      if (paramIntent == null) {
        j.t("viewModel");
      }
      localMsgPushViewModel.p0(true, paramIntent.f(i, paramInt1, paramInt2));
    }
    else if (paramInt1 == 1345)
    {
      paramIntent = this.p3;
      if (paramIntent == null) {
        j.t("deviceIdMD5");
      }
      h.o(paramIntent, false, new g(this)).H0(h.c, i.c);
      com.tplink.iot.Utils.v0.b.a().b();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = a.notification_switch;
    Object localObject;
    if (j.a(paramView, (CheckBox)e1(i)))
    {
      paramView = this.p1;
      if (paramView == null) {
        j.t("viewModel");
      }
      localObject = (CheckBox)e1(i);
      j.d(localObject, "notification_switch");
      paramView.m0(((CheckBox)localObject).isChecked());
    }
    else if (j.a(paramView, (NoninteractiveCheckBox)e1(a.rich_notification_switch)))
    {
      paramView = this.p1;
      if (paramView == null) {
        j.t("viewModel");
      }
      localObject = this.p1;
      if (localObject == null) {
        j.t("viewModel");
      }
      paramView.h(((MsgPushViewModel)localObject).f);
    }
    else if (j.a(paramView, (RadioButton)e1(a.always_item)))
    {
      paramView = this.p1;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.o0(false);
    }
    else if (j.a(paramView, (RadioButton)e1(a.custom_item)))
    {
      paramView = this.p1;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.o0(true);
    }
    else if (j.a(paramView, (RelativeLayout)e1(a.item_custom_time_more)))
    {
      o1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558586);
    j.d(paramBundle, "DataBindingUtil.setConte…layout.activity_msg_push)");
    this.p0 = ((ActivityMsgPushBinding)paramBundle);
    m1();
    k1();
    l1();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, MsgPushActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(MsgPushActivity paramMsgPushActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        s0.l(this.a);
      } else {
        s0.g();
      }
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(MsgPushActivity paramMsgPushActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        TSnackbar.y(paramBoolean, paramBoolean.getString(2131952741), 3000).N();
      }
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(MsgPushActivity paramMsgPushActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (org.apache.commons.lang.b.b(paramBoolean)) {
        MsgPushActivity.j1(this.a);
      }
    }
  }
  
  static final class e<T>
    implements Observer<Boolean>
  {
    e(MsgPushActivity paramMsgPushActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (org.apache.commons.lang.b.b(paramBoolean)) {
        MsgPushActivity.i1(this.a);
      }
    }
  }
  
  static final class f<T>
    implements Observer<Boolean>
  {
    f(MsgPushActivity paramMsgPushActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (org.apache.commons.lang.b.b(paramBoolean))
      {
        paramBoolean = this.a;
        TrialDialogActivity.f1(paramBoolean, e.v(h.j(MsgPushActivity.f1(paramBoolean))));
      }
    }
  }
  
  static final class g<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<Boolean>
  {
    g(MsgPushActivity paramMsgPushActivity) {}
    
    public final void b(Boolean paramBoolean)
    {
      MsgPushActivity.h1(this.a).a.postValue(paramBoolean);
    }
  }
  
  static final class h<T>
    implements g<Integer>
  {
    public static final h c = new h();
    
    public final void a(Integer paramInteger) {}
  }
  
  static final class i<T>
    implements g<Throwable>
  {
    public static final i c = new i();
    
    public final void a(Throwable paramThrowable) {}
  }
  
  static final class j
    implements TPMaterialDialogV2.d
  {
    j(MsgPushActivity paramMsgPushActivity) {}
    
    public final void onClick(View paramView)
    {
      MsgPushActivity.h1(this.a).f.set(true);
      MsgPushActivity.h1(this.a).r0(true);
    }
  }
  
  static final class k
    implements TPMaterialDialogV2.d
  {
    k(MsgPushActivity paramMsgPushActivity) {}
    
    public final void onClick(View paramView)
    {
      MsgPushActivity.h1(this.a).f.set(true);
      MsgPushActivity.h1(this.a).q0(true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\MsgPushActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */