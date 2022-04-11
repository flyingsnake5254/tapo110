package com.tplink.iot.viewmodel.iothub.guardmode;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.q;
import kotlin.jvm.internal.j;

public final class GuardModeViewModel
  extends AndroidViewModel
{
  private final HubRepository a;
  
  public GuardModeViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((HubRepository)e.a(paramThingContext, HubRepository.class));
  }
  
  public final q<GuardModeRuleResult> f()
  {
    Object localObject = this.a;
    j.d(localObject, "mHubRepository");
    localObject = ((HubRepository)localObject).m5();
    j.d(localObject, "mHubRepository.guardModeConfigs");
    return (q<GuardModeRuleResult>)localObject;
  }
  
  public final void g()
  {
    HubRepository localHubRepository = this.a;
    j.d(localHubRepository, "mHubRepository");
    localHubRepository.p5().F0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iothub\guardmode\GuardModeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */