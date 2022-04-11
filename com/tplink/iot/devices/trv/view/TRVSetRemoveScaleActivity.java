package com.tplink.iot.devices.trv.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetRemoveScaleBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.RemoveScaleInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.RemoveScaleStatusResult;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class TRVSetRemoveScaleActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetRemoveScaleBinding>
{
  private final f p0 = h.b(new a(this));
  private boolean p1;
  
  private final void t1()
  {
    if (!this.p1)
    {
      this.p1 = true;
      ActivityTrvSetRemoveScaleBinding localActivityTrvSetRemoveScaleBinding = (ActivityTrvSetRemoveScaleBinding)f1();
      Object localObject = localActivityTrvSetRemoveScaleBinding.x;
      j.d(localObject, "rlSwitch");
      ((RelativeLayout)localObject).setAlpha(0.5F);
      localObject = localActivityTrvSetRemoveScaleBinding.y;
      j.d(localObject, "switchButton");
      ((CompoundButton)localObject).setEnabled(false);
      localObject = localActivityTrvSetRemoveScaleBinding.z;
      j.d(localObject, "tvRemoveScale");
      ((TextView)localObject).setAlpha(0.5F);
      localObject = localActivityTrvSetRemoveScaleBinding.z;
      j.d(localObject, "tvRemoveScale");
      ((TextView)localObject).setEnabled(false);
      localObject = localActivityTrvSetRemoveScaleBinding.c;
      j.d(localObject, "circleProgressBar");
      ((View)localObject).setVisibility(0);
      localActivityTrvSetRemoveScaleBinding.c.h();
    }
  }
  
  private final void u1()
  {
    if (this.p1)
    {
      this.p1 = false;
      ActivityTrvSetRemoveScaleBinding localActivityTrvSetRemoveScaleBinding = (ActivityTrvSetRemoveScaleBinding)f1();
      Object localObject = localActivityTrvSetRemoveScaleBinding.x;
      j.d(localObject, "rlSwitch");
      ((RelativeLayout)localObject).setAlpha(1.0F);
      localObject = localActivityTrvSetRemoveScaleBinding.y;
      j.d(localObject, "switchButton");
      ((CompoundButton)localObject).setEnabled(true);
      localObject = localActivityTrvSetRemoveScaleBinding.z;
      j.d(localObject, "tvRemoveScale");
      ((TextView)localObject).setAlpha(1.0F);
      localObject = localActivityTrvSetRemoveScaleBinding.z;
      j.d(localObject, "tvRemoveScale");
      ((TextView)localObject).setEnabled(true);
      localObject = localActivityTrvSetRemoveScaleBinding.c;
      j.d(localObject, "circleProgressBar");
      ((View)localObject).setVisibility(8);
      localActivityTrvSetRemoveScaleBinding.c.i();
    }
  }
  
  private final TRVSettingsViewModel v1()
  {
    return (TRVSettingsViewModel)this.p0.getValue();
  }
  
  private final void w1()
  {
    t1();
    v1().l0();
  }
  
  public int e1()
  {
    return 2131558697;
  }
  
  public void j1()
  {
    b1(2131954337);
  }
  
  public void l1()
  {
    ActivityTrvSetRemoveScaleBinding localActivityTrvSetRemoveScaleBinding = (ActivityTrvSetRemoveScaleBinding)f1();
    localActivityTrvSetRemoveScaleBinding.c.setProgressBarColor(getResources().getColor(2131099808));
    localActivityTrvSetRemoveScaleBinding.y.setOnSwitchCheckedChangeListener(new b(this));
    localActivityTrvSetRemoveScaleBinding.z.setOnClickListener(new c(this));
  }
  
  public void m1()
  {
    v1().T().observe(this, new d(this));
    v1().U().observe(this, new e(this));
    v1().S().observe(this, new f(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    v1().F();
  }
  
  protected void onDestroy()
  {
    v1().D();
    super.onDestroy();
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    a(TRVSetRemoveScaleActivity paramTRVSetRemoveScaleActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetRemoveScaleActivity.q1((TRVSetRemoveScaleActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class b
    implements TPSwitchCompat.a
  {
    b(TRVSetRemoveScaleActivity paramTRVSetRemoveScaleActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        paramCompoundButton = TRVSetRemoveScaleActivity.p1(this.a).y;
        j.d(paramCompoundButton, "mBinding.switchButton");
        i.b(paramCompoundButton, 0L, 1, null);
        TRVSetRemoveScaleActivity.r1(this.a).m0(paramBoolean1);
      }
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(TRVSetRemoveScaleActivity paramTRVSetRemoveScaleActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVSetRemoveScaleActivity.s1(this.c);
    }
  }
  
  static final class d<T>
    implements Observer<RemoveScaleInfoBean>
  {
    d(TRVSetRemoveScaleActivity paramTRVSetRemoveScaleActivity) {}
    
    public final void a(RemoveScaleInfoBean paramRemoveScaleInfoBean)
    {
      if (paramRemoveScaleInfoBean != null)
      {
        TPSwitchCompat localTPSwitchCompat = TRVSetRemoveScaleActivity.p1(this.a).y;
        j.d(localTPSwitchCompat, "mBinding.switchButton");
        localTPSwitchCompat.setChecked(paramRemoveScaleInfoBean.getAuto());
      }
    }
  }
  
  static final class e<T>
    implements Observer<RemoveScaleStatusResult>
  {
    e(TRVSetRemoveScaleActivity paramTRVSetRemoveScaleActivity) {}
    
    public final void a(RemoveScaleStatusResult paramRemoveScaleStatusResult)
    {
      if (paramRemoveScaleStatusResult != null) {
        if (paramRemoveScaleStatusResult.getStatus() != 1) {
          TRVSetRemoveScaleActivity.o1(this.a);
        } else {
          TRVSetRemoveScaleActivity.n1(this.a);
        }
      }
    }
  }
  
  static final class f<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    f(TRVSetRemoveScaleActivity paramTRVSetRemoveScaleActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      if (parama != null)
      {
        parama = (Boolean)parama.a();
        if ((parama != null) && (!parama.booleanValue())) {
          e.e(this.a, null, 1, null);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetRemoveScaleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */