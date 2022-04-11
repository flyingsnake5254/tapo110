package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetShutdownModeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.a;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.EnumShutdownMode;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ShutdownInfoBean;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class TRVSetShutdownModeActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetShutdownModeBinding>
  implements TPRadioButton.a
{
  public static final a p0 = new a(null);
  private final f p1 = h.b(new b(this));
  private ShutdownInfoBean p2;
  private boolean p3;
  
  private final TRVSettingsViewModel s1()
  {
    return (TRVSettingsViewModel)this.p1.getValue();
  }
  
  private final void t1(boolean paramBoolean)
  {
    Object localObject = ((ActivityTrvSetShutdownModeBinding)f1()).f;
    j.d(localObject, "mBinding.rgShutdownMode");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    localObject = this.p2;
    if (localObject != null)
    {
      localObject = ((ShutdownInfoBean)localObject).getEnumMode();
      if (localObject != null) {}
    }
    else
    {
      localObject = EnumShutdownMode.FULL_CLOSED;
    }
    if (!paramBoolean) {
      u1(false, (EnumShutdownMode)localObject);
    } else {
      u1(true, (EnumShutdownMode)localObject);
    }
  }
  
  private final void u1(boolean paramBoolean, EnumShutdownMode paramEnumShutdownMode)
  {
    s1().q0(paramBoolean, paramEnumShutdownMode).r(io.reactivex.d0.b.a.a()).l(new c(this)).i(new d(this)).j(new e(this)).y();
  }
  
  private final void v1(ShutdownInfoBean paramShutdownInfoBean)
  {
    Object localObject = ((ActivityTrvSetShutdownModeBinding)f1()).x;
    j.d(localObject, "mBinding.switchButton");
    ((TPSwitchCompat)localObject).setChecked(paramShutdownInfoBean.getEnable());
    localObject = ((ActivityTrvSetShutdownModeBinding)f1()).f;
    j.d(localObject, "mBinding.rgShutdownMode");
    int i;
    if (paramShutdownInfoBean.getEnable()) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    paramShutdownInfoBean = paramShutdownInfoBean.getMode();
    if (j.a(paramShutdownInfoBean, EnumShutdownMode.FULL_CLOSED.getValue())) {
      ((ActivityTrvSetShutdownModeBinding)f1()).f.check(2131363758);
    } else if (j.a(paramShutdownInfoBean, EnumShutdownMode.FULL_OPEN.getValue())) {
      ((ActivityTrvSetShutdownModeBinding)f1()).f.check(2131363759);
    }
  }
  
  public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramCompoundButton != null) && (paramCompoundButton.getId() == 2131363758) && (paramBoolean1) && (paramBoolean2)) {
      u1(true, EnumShutdownMode.FULL_CLOSED);
    } else if ((paramCompoundButton != null) && (paramCompoundButton.getId() == 2131363759) && (paramBoolean1) && (paramBoolean2)) {
      u1(true, EnumShutdownMode.FULL_OPEN);
    }
  }
  
  public int e1()
  {
    return 2131558698;
  }
  
  public void h1()
  {
    super.h1();
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("FromDetailPageExtra", false);
    }
    this.p3 = bool;
  }
  
  public void j1()
  {
    b1(2131954346);
  }
  
  public void k1()
  {
    if ((this.p3) || (s1().W().getValue() == null)) {
      s1().V();
    }
  }
  
  public void l1()
  {
    ((ActivityTrvSetShutdownModeBinding)f1()).x.setOnSwitchCheckedChangeListener(new f(this));
    ((ActivityTrvSetShutdownModeBinding)f1()).c.setOnCheckedChangeListener(this);
    ((ActivityTrvSetShutdownModeBinding)f1()).d.setOnCheckedChangeListener(this);
  }
  
  public void m1()
  {
    s1().W().observe(this, new g(this));
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, boolean paramBoolean)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIDMD5");
      Intent localIntent = new Intent(paramContext, TRVSetShutdownModeActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("FromDetailPageExtra", paramBoolean);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    b(TRVSetShutdownModeActivity paramTRVSetShutdownModeActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetShutdownModeActivity.o1((TRVSetShutdownModeActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class c<T>
    implements g<c>
  {
    c(TRVSetShutdownModeActivity paramTRVSetShutdownModeActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class d
    implements io.reactivex.g0.a
  {
    d(TRVSetShutdownModeActivity paramTRVSetShutdownModeActivity) {}
    
    public final void run()
    {
      e.g(this.a, null, 1, null);
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(TRVSetShutdownModeActivity paramTRVSetShutdownModeActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class f
    implements TPSwitchCompat.a
  {
    f(TRVSetShutdownModeActivity paramTRVSetShutdownModeActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        paramCompoundButton = TRVSetShutdownModeActivity.n1(this.a).x;
        j.d(paramCompoundButton, "mBinding.switchButton");
        i.b(paramCompoundButton, 0L, 1, null);
        TRVSetShutdownModeActivity.p1(this.a, paramBoolean1);
      }
    }
  }
  
  static final class g<T>
    implements Observer<ShutdownInfoBean>
  {
    g(TRVSetShutdownModeActivity paramTRVSetShutdownModeActivity) {}
    
    public final void a(ShutdownInfoBean paramShutdownInfoBean)
    {
      TRVSetShutdownModeActivity.q1(this.a, paramShutdownInfoBean);
      if (paramShutdownInfoBean != null) {
        TRVSetShutdownModeActivity.r1(this.a, paramShutdownInfoBean);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetShutdownModeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */