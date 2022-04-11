package com.tplink.iot.view.iothub.guardmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.a;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter.a;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SetAlarmVolumeFragment
  extends BaseGuardModeSettingFragment
{
  public static final a p0 = new a(null);
  private final int p1 = 2131952747;
  private GuardModeAlarmVolumeAdapter p2;
  private HashMap p3;
  
  public void H0()
  {
    HashMap localHashMap = this.p3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected int J0()
  {
    return this.p1;
  }
  
  protected void N0()
  {
    Object localObject = this.p2;
    if (localObject == null) {
      j.t("mAdapter");
    }
    localObject = (GuardModeAlarmVolumeAdapter.a)((SingleCheckMarkAdapter)localObject).t();
    L0().v(((GuardModeAlarmVolumeAdapter.a)localObject).b());
  }
  
  protected void O0()
  {
    L0().i().observe(getViewLifecycleOwner(), new b(this));
  }
  
  public View P0(int paramInt)
  {
    if (this.p3 == null) {
      this.p3 = new HashMap();
    }
    View localView1 = (View)this.p3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = getView();
      if (localView2 == null) {
        return null;
      }
      localView2 = localView2.findViewById(paramInt);
      this.p3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    return paramLayoutInflater.inflate(2131558927, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    paramView = new GuardModeAlarmVolumeAdapter(K0());
    paramBundle = (RecyclerView)P0(a.config_item_list);
    j.d(paramBundle, "config_item_list");
    paramBundle.setAdapter(paramView);
    paramBundle = p.a;
    this.p2 = paramView;
  }
  
  public static final class a {}
  
  static final class b<T>
    implements Observer<GuardModeConfigBean>
  {
    b(SetAlarmVolumeFragment paramSetAlarmVolumeFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      SetAlarmVolumeFragment.Q0(this.a).C(paramGuardModeConfigBean.getEnumAlarmVolume());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\SetAlarmVolumeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */