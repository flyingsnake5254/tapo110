package com.tplink.iot.view.iothub.guardmode;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.b;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter.a;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter.b;
import com.tplink.iot.databinding.FragmentGuardModeConfigBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class GuardModeConfigFragment
  extends IoTMVVMBaseFragment<FragmentGuardModeConfigBinding>
{
  private HashMap H3;
  private GuardModeConfigActivity p1;
  private MenuItem p2;
  private final f p3 = h.b(new e(this));
  
  private final String X0(GuardModeAlarmTimeBean paramGuardModeAlarmTimeBean)
  {
    Object localObject = paramGuardModeAlarmTimeBean.getEnumType();
    int i = b.b[localObject.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        GuardModeAlarmTimeAdapter.b localb = GuardModeAlarmTimeAdapter.k;
        localObject = this.p1;
        if (localObject == null) {
          j.t("mActivity");
        }
        paramGuardModeAlarmTimeBean = localb.c((Context)localObject, paramGuardModeAlarmTimeBean.getTime());
      }
      else
      {
        throw new NoWhenBranchMatchedException();
      }
    }
    else
    {
      paramGuardModeAlarmTimeBean = getResources().getString(2131952744);
      j.d(paramGuardModeAlarmTimeBean, "resources.getString(R.string.gm_alarm_time_always)");
    }
    return paramGuardModeAlarmTimeBean;
  }
  
  private final String Y0(int paramInt)
  {
    String str = getResources().getQuantityString(2131820544, paramInt, new Object[] { Integer.valueOf(paramInt) });
    j.d(str, "resources.getQuantityStr…evices_num, count, count)");
    return str;
  }
  
  private final GuardModeConfigViewModel Z0()
  {
    return (GuardModeConfigViewModel)this.p3.getValue();
  }
  
  private final void b1()
  {
    Z0().s().C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a()).j(new f(this)).i(new g(this)).l(new h(this)).y();
  }
  
  private final void c1(EnumGuardMode paramEnumGuardMode)
  {
    int i = b.a[paramEnumGuardMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          i = 2131952804;
        } else {
          throw new NoWhenBranchMatchedException();
        }
      }
      else {
        i = 2131952794;
      }
    }
    else {
      i = 2131952798;
    }
    ((FragmentGuardModeConfigBinding)J0()).H3.setText(i);
  }
  
  private final void d1(GuardModeConfigBean paramGuardModeConfigBean)
  {
    TextView localTextView = ((FragmentGuardModeConfigBinding)J0()).I3;
    j.d(localTextView, "mBinding.tvTriggerDevices");
    localTextView.setText(Y0(paramGuardModeConfigBean.getDeviceIdList().size()));
    localTextView = ((FragmentGuardModeConfigBinding)J0()).p2;
    j.d(localTextView, "mBinding.tvAlarmType");
    localTextView.setText(GuardModeAlarmTypeAdapter.g.a(paramGuardModeConfigBean.getAlarmType()));
    ((FragmentGuardModeConfigBinding)J0()).p3.setText(GuardModeAlarmVolumeAdapter.h.a(paramGuardModeConfigBean.getEnumAlarmVolume()));
    localTextView = ((FragmentGuardModeConfigBinding)J0()).p1;
    j.d(localTextView, "mBinding.tvAlarmTime");
    localTextView.setText(X0(paramGuardModeConfigBean.getAlarmTime()));
  }
  
  public void H0()
  {
    HashMap localHashMap = this.H3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558926;
  }
  
  public void N0()
  {
    ((FragmentGuardModeConfigBinding)J0()).p0.setOnClickListener(new a(this));
    ((FragmentGuardModeConfigBinding)J0()).y.setOnClickListener(new b(this));
    ((FragmentGuardModeConfigBinding)J0()).z.setOnClickListener(new c(this));
    ((FragmentGuardModeConfigBinding)J0()).x.setOnClickListener(new d(this));
    GuardModeConfigActivity localGuardModeConfigActivity = this.p1;
    if (localGuardModeConfigActivity == null) {
      j.t("mActivity");
    }
    c1(localGuardModeConfigActivity.g1());
  }
  
  public void R0()
  {
    Z0().i().observe(getViewLifecycleOwner(), new i(this));
    Z0().h().observe(getViewLifecycleOwner(), new Observer()
    {
      public void a(List<? extends BaseALIoTDevice<?>> paramAnonymousList) {}
    });
  }
  
  public final boolean a1()
  {
    return Z0().l();
  }
  
  public void onAttach(Context paramContext)
  {
    j.e(paramContext, "context");
    super.onAttach(paramContext);
    this.p1 = ((GuardModeConfigActivity)paramContext);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    j.e(paramMenu, "menu");
    j.e(paramMenuInflater, "inflater");
    paramMenuInflater.inflate(2131623941, paramMenu);
    paramMenu = paramMenu.findItem(2131362300);
    this.p2 = paramMenu;
    if (paramMenu != null) {
      paramMenu.setEnabled(Z0().l());
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    boolean bool;
    if (paramMenuItem.getItemId() != 2131362300)
    {
      bool = false;
    }
    else
    {
      b1();
      bool = true;
    }
    return bool;
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void onClick(View paramView)
    {
      GuardModeConfigFragment.S0(this.c).i1("AddTriggerDevicesFragment");
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void onClick(View paramView)
    {
      GuardModeConfigFragment.S0(this.c).i1("SetAlarmTypeFragment");
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void onClick(View paramView)
    {
      GuardModeConfigFragment.S0(this.c).i1("SetAlarmVolumeFragment");
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void onClick(View paramView)
    {
      GuardModeConfigFragment.S0(this.c).i1("SetAlarmTimeFragment");
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<GuardModeConfigViewModel>
  {
    e(GuardModeConfigFragment paramGuardModeConfigFragment)
    {
      super();
    }
    
    public final GuardModeConfigViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(GuardModeConfigFragment.S0(this.c), new IoTViewModelFactory(GuardModeConfigFragment.S0(this.c), GuardModeConfigFragment.T0(this.c))).get(GuardModeConfigViewModel.class);
      GuardModeConfigViewModel localGuardModeConfigViewModel = (GuardModeConfigViewModel)localViewModel;
      localGuardModeConfigViewModel.w(GuardModeConfigFragment.S0(this.c).g1());
      j.d(localViewModel, "ViewModelProvider(mActiv…e = mActivity.guardMode }");
      return localGuardModeConfigViewModel;
    }
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void a(Throwable paramThrowable)
    {
      s0.g();
      s0.p(GuardModeConfigFragment.S0(this.c), this.c.getResources().getString(2131952444));
    }
  }
  
  static final class g
    implements io.reactivex.g0.a
  {
    g(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void run()
    {
      s0.g();
      GuardModeConfigFragment.S0(this.a).finish();
    }
  }
  
  static final class h<T>
    implements g<c>
  {
    h(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void a(c paramc)
    {
      e.m(GuardModeConfigFragment.S0(this.c), null, 1, null);
    }
  }
  
  static final class i<T>
    implements Observer<GuardModeConfigBean>
  {
    i(GuardModeConfigFragment paramGuardModeConfigFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      MenuItem localMenuItem = GuardModeConfigFragment.U0(this.a);
      if (localMenuItem != null) {
        localMenuItem.setEnabled(GuardModeConfigFragment.V0(this.a).l());
      }
      if (paramGuardModeConfigBean != null) {
        GuardModeConfigFragment.W0(this.a, paramGuardModeConfigBean);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\GuardModeConfigFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */