package com.tplink.iot.devices.featuredactions.view.base;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.databinding.FragmentAbstractFeaturedActionChooseBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment.a;
import com.tplink.iot.devices.featuredactions.adapter.FeaturedActionChooseAdapter;
import java.util.HashMap;
import java.util.List;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract class AbstractFeaturedActionChooseFragment
  extends IoTMVVMBaseFragment<FragmentAbstractFeaturedActionChooseBinding>
  implements com.tplink.iot.devices.featuredactions.adapter.a
{
  private final f p1 = h.b(new a(this));
  private String p2 = "";
  private HashMap p3;
  
  private final FeaturedActionChooseAdapter W0()
  {
    Object localObject = requireContext();
    j.d(localObject, "requireContext()");
    localObject = new FeaturedActionChooseAdapter((Context)localObject, U0());
    ((FeaturedActionChooseAdapter)localObject).C(this);
    return (FeaturedActionChooseAdapter)localObject;
  }
  
  public void H0()
  {
    HashMap localHashMap = this.p3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558854;
  }
  
  public void N0()
  {
    ((FragmentAbstractFeaturedActionChooseBinding)J0()).c.setAdapter(W0());
  }
  
  protected final com.tplink.iot.g.a.a.a T0(String paramString, int paramInt)
  {
    j.e(paramString, "id");
    String str = getString(paramInt);
    j.d(str, "getString(titleId)");
    return new com.tplink.iot.g.a.a.a(paramString, str);
  }
  
  public abstract List<com.tplink.iot.g.a.a.a> U0();
  
  protected final Bundle V0()
  {
    return (Bundle)this.p1.getValue();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("DeviceModel");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "";
    }
    this.p2 = paramBundle;
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.a<Bundle>
  {
    a(AbstractFeaturedActionChooseFragment paramAbstractFeaturedActionChooseFragment)
    {
      super();
    }
    
    public final Bundle invoke()
    {
      return IoTMVVMBaseFragment.q.a(AbstractFeaturedActionChooseFragment.S0(this.c));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\base\AbstractFeaturedActionChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */