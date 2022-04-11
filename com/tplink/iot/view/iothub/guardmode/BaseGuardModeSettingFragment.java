package com.tplink.iot.view.iothub.guardmode;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import java.util.HashMap;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract class BaseGuardModeSettingFragment
  extends BaseFragment
{
  protected GuardModeConfigActivity q;
  private String x = "";
  private final f y = h.b(new a(this));
  private HashMap z;
  
  public void H0()
  {
    HashMap localHashMap = this.z;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected abstract int J0();
  
  protected final GuardModeConfigActivity K0()
  {
    GuardModeConfigActivity localGuardModeConfigActivity = this.q;
    if (localGuardModeConfigActivity == null) {
      j.t("mActivity");
    }
    return localGuardModeConfigActivity;
  }
  
  protected final GuardModeConfigViewModel L0()
  {
    return (GuardModeConfigViewModel)this.y.getValue();
  }
  
  protected abstract void N0();
  
  protected abstract void O0();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    O0();
  }
  
  public void onAttach(Context paramContext)
  {
    j.e(paramContext, "context");
    super.onAttach(paramContext);
    paramContext = (GuardModeConfigActivity)paramContext;
    this.q = paramContext;
    if (paramContext == null) {
      j.t("mActivity");
    }
    paramContext.b1(J0());
    paramContext = getArguments();
    if (paramContext != null)
    {
      paramContext = paramContext.getString("device_id_md5");
      if (paramContext != null) {}
    }
    else
    {
      paramContext = "";
    }
    this.x = paramContext;
  }
  
  public void onDestroy()
  {
    N0();
    super.onDestroy();
  }
  
  static final class a
    extends Lambda
    implements a<GuardModeConfigViewModel>
  {
    a(BaseGuardModeSettingFragment paramBaseGuardModeSettingFragment)
    {
      super();
    }
    
    public final GuardModeConfigViewModel a()
    {
      GuardModeConfigViewModel localGuardModeConfigViewModel = (GuardModeConfigViewModel)new ViewModelProvider(this.c.K0(), new IoTViewModelFactory(this.c.K0(), BaseGuardModeSettingFragment.I0(this.c))).get(GuardModeConfigViewModel.class);
      localGuardModeConfigViewModel.w(this.c.K0().g1());
      return localGuardModeConfigViewModel;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\BaseGuardModeSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */