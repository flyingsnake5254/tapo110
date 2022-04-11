package com.tplink.iot.view.smart.actionsetup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.LocationPrepareActivity;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.quicksetup.base.f.a;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerContainerFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.i;

public class ActionDetailActivity
  extends BaseActivity
{
  private TaskDeviceChooseFragment H3;
  private ConditionTriggerTimerFragment I3;
  private ConditionDeviceChooseFragment J3;
  private ActionSetupViewModel K3;
  private int L3 = -1;
  private int M3 = 1;
  private boolean N3 = false;
  private TaskAddFragment p0;
  private TaskShortcutFragment p1;
  private TaskAutomationFragment p2;
  private TaskAutomationEnableFragment p3;
  private ActionIconChooseFragment y;
  private ConditionAddFragment z;
  
  public static void F1(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, ActionDetailActivity.class);
    localIntent.putExtra("action_item_index", paramInt1);
    localIntent.putExtra("action_detail_type", paramInt2);
    paramContext.startActivity(localIntent);
  }
  
  public static Intent G1(Context paramContext, SmartInfo paramSmartInfo)
  {
    paramContext = new Intent(paramContext, ActionDetailActivity.class);
    paramContext.putExtra("action_smart_info", i.f(paramSmartInfo));
    paramContext.putExtra("action_from_featured_action", true);
    return paramContext;
  }
  
  private void H1(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("android:support:fragments");
      paramBundle.remove("android:fragments");
    }
  }
  
  private void I1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953991)).l(2131952391, 2131099804, null).o(2131952432, 2131099808, new e(this)).g(8, 8).b(false).c(false).a().show();
  }
  
  private void J1(Fragment paramFragment)
  {
    d1(2131362321, paramFragment, paramFragment.getTag());
  }
  
  private DeviceTriggerContainerFragment w1()
  {
    DeviceTriggerContainerFragment localDeviceTriggerContainerFragment = new DeviceTriggerContainerFragment();
    localDeviceTriggerContainerFragment.b1(new k0(this));
    return localDeviceTriggerContainerFragment;
  }
  
  private Fragment x1()
  {
    Object localObject = this.K3.t();
    int i;
    if ((localObject != null) && (!((BaseALIoTDevice)localObject).isBulb()) && (!((BaseALIoTDevice)localObject).isPlug()) && (!((BaseALIoTDevice)localObject).isSwitch())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject = new TaskDeviceControlFragment();
      ((TaskDeviceControlFragment)localObject).q1(new j0(this));
      return (Fragment)localObject;
    }
    DeviceControlContainerFragment localDeviceControlContainerFragment = new DeviceControlContainerFragment();
    localDeviceControlContainerFragment.P0(((BaseALIoTDevice)localObject).getDeviceIdMD5());
    localDeviceControlContainerFragment.c1(new v(this));
    return localDeviceControlContainerFragment;
  }
  
  private void y1()
  {
    ActionSetupFragment localActionSetupFragment = (ActionSetupFragment)V0(ActionSetupFragment.class, ActionSetupFragment.class.getSimpleName());
    this.y = ((ActionIconChooseFragment)V0(ActionIconChooseFragment.class, ActionIconChooseFragment.class.getSimpleName()));
    this.z = ((ConditionAddFragment)V0(ConditionAddFragment.class, ConditionAddFragment.class.getSimpleName()));
    this.p0 = ((TaskAddFragment)V0(TaskAddFragment.class, TaskAddFragment.class.getSimpleName()));
    this.p1 = ((TaskShortcutFragment)V0(TaskShortcutFragment.class, TaskShortcutFragment.class.getSimpleName()));
    this.p2 = ((TaskAutomationFragment)V0(TaskAutomationFragment.class, TaskAutomationFragment.class.getSimpleName()));
    this.p3 = ((TaskAutomationEnableFragment)V0(TaskAutomationEnableFragment.class, TaskAutomationEnableFragment.class.getSimpleName()));
    this.H3 = ((TaskDeviceChooseFragment)V0(TaskDeviceChooseFragment.class, TaskDeviceChooseFragment.class.getSimpleName()));
    J1(localActionSetupFragment);
    localActionSetupFragment.b1(new a());
    this.z.R0(new b());
    this.p0.P0(new c());
    this.p1.L0(new w(this));
    this.p2.L0(new c(this));
    this.H3.Q0(new d(this));
    this.p3.K0(new l0(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    H1(paramBundle);
    super.onCreate(paramBundle);
    setContentView(2131558659);
    if (getIntent() != null)
    {
      this.L3 = getIntent().getIntExtra("action_item_index", -1);
      this.M3 = getIntent().getIntExtra("action_detail_type", 1);
      this.N3 = getIntent().getBooleanExtra("action_from_featured_action", false);
      paramBundle = getIntent().getStringExtra("action_smart_info");
    }
    else
    {
      paramBundle = null;
    }
    this.K3 = ((ActionSetupViewModel)ViewModelProviders.of(this).get(ActionSetupViewModel.class));
    if ((this.N3) && (!TextUtils.isEmpty(paramBundle)))
    {
      paramBundle = (SmartInfo)i.d(paramBundle, SmartInfo.class);
      if (paramBundle != null)
      {
        this.K3.c0(-1);
        this.K3.b0(2);
        this.K3.p0(paramBundle);
      }
      else
      {
        this.K3.c0(-1);
        this.K3.b0(1);
      }
    }
    else
    {
      this.K3.c0(this.L3);
      this.K3.b0(this.M3);
    }
    y1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void u1()
  {
    if (!a.a(this)) {
      startActivity(new Intent(this, LocationPrepareActivity.class));
    } else {
      v1();
    }
  }
  
  public void v1()
  {
    this.I3.L0();
  }
  
  class a
    implements ActionSetupFragment.a
  {
    a() {}
    
    public void a()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.q1(localActionDetailActivity));
    }
    
    public void b(boolean paramBoolean)
    {
      if (paramBoolean) {
        ActionDetailActivity.o1(ActionDetailActivity.this);
      } else {
        ActionDetailActivity.this.finish();
      }
    }
    
    public void c()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.e1(localActionDetailActivity));
    }
    
    public void d()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.m1(localActionDetailActivity));
    }
    
    public void e()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.l1(localActionDetailActivity));
    }
    
    public void f()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.r1(localActionDetailActivity));
    }
    
    public void g()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.n1(localActionDetailActivity));
    }
    
    public void h()
    {
      if (ActionDetailActivity.p1(ActionDetailActivity.this)) {
        ActionDetailActivity.this.setResult(-1);
      }
      ActionDetailActivity.this.finish();
    }
    
    public void i()
    {
      ActionDetailActivity.f1(ActionDetailActivity.this, new EffectiveTimeFragment());
    }
  }
  
  class b
    implements ConditionAddFragment.f
  {
    b() {}
    
    public void a()
    {
      ActionDetailActivity.this.U0();
    }
    
    public void b()
    {
      ActionDetailActivity.t1(ActionDetailActivity.this, new ConditionTriggerTimerFragment());
      ActionDetailActivity.s1(ActionDetailActivity.this).S0(new a());
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.s1(localActionDetailActivity));
    }
    
    public void c()
    {
      ActionDetailActivity.h1(ActionDetailActivity.this, new ConditionDeviceChooseFragment());
      ActionDetailActivity.g1(ActionDetailActivity.this).S0(new b(this));
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.g1(localActionDetailActivity));
    }
    
    class a
      implements ConditionTriggerTimerFragment.b
    {
      a() {}
      
      public void a()
      {
        ActionDetailActivity.this.U0();
      }
      
      public void b()
      {
        ActionDetailActivity.this.u1();
      }
    }
  }
  
  class c
    implements TaskAddFragment.f
  {
    c() {}
    
    public void a()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.i1(localActionDetailActivity));
    }
    
    public void b()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.j1(localActionDetailActivity));
    }
    
    public void c()
    {
      ActionDetailActivity localActionDetailActivity = ActionDetailActivity.this;
      ActionDetailActivity.f1(localActionDetailActivity, ActionDetailActivity.k1(localActionDetailActivity));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\ActionDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */