package com.tplink.iot.view.iothub.guardmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SetAlarmTypeFragment
  extends BaseGuardModeSettingFragment
{
  public static final a p0 = new a(null);
  private HashMap H3;
  private final int p1 = 2131951863;
  private GuardModeAlarmTypeAdapter p2;
  private String p3;
  
  private final void T0()
  {
    String str = this.p3;
    if (str != null)
    {
      GuardModeAlarmTypeAdapter localGuardModeAlarmTypeAdapter = this.p2;
      if (localGuardModeAlarmTypeAdapter != null) {
        localGuardModeAlarmTypeAdapter.B(str);
      }
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.H3;
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
    if (localObject != null)
    {
      localObject = (String)((SingleCheckMarkAdapter)localObject).u();
      if (localObject != null) {
        L0().u((String)localObject);
      }
    }
  }
  
  protected void O0()
  {
    L0().i().observe(getViewLifecycleOwner(), new b(this));
    L0().k().observe(getViewLifecycleOwner(), new c(this));
  }
  
  public View P0(int paramInt)
  {
    if (this.H3 == null) {
      this.H3 = new HashMap();
    }
    View localView1 = (View)this.H3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = getView();
      if (localView2 == null) {
        return null;
      }
      localView2 = localView2.findViewById(paramInt);
      this.H3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    return paramLayoutInflater.inflate(2131558927, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    L0().y();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    L0().j();
  }
  
  public static final class a {}
  
  static final class b<T>
    implements Observer<GuardModeConfigBean>
  {
    b(SetAlarmTypeFragment paramSetAlarmTypeFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      SetAlarmTypeFragment.R0(this.a, paramGuardModeConfigBean.getAlarmType());
      SetAlarmTypeFragment.S0(this.a);
    }
  }
  
  static final class c<T>
    implements Observer<List<? extends String>>
  {
    c(SetAlarmTypeFragment paramSetAlarmTypeFragment) {}
    
    public final void a(List<String> paramList)
    {
      int i;
      if ((paramList != null) && (!paramList.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return;
      }
      SetAlarmTypeFragment localSetAlarmTypeFragment = this.a;
      paramList = new GuardModeAlarmTypeAdapter(paramList, this.a.K0());
      paramList.y(new a(this));
      paramList.x(true);
      Object localObject = (RecyclerView)this.a.P0(com.tplink.iot.a.config_item_list);
      j.d(localObject, "config_item_list");
      ((RecyclerView)localObject).setAdapter(paramList);
      localObject = p.a;
      SetAlarmTypeFragment.Q0(localSetAlarmTypeFragment, paramList);
      SetAlarmTypeFragment.S0(this.a);
    }
    
    static final class a
      extends Lambda
      implements q<String, Integer, Boolean, p>
    {
      a(SetAlarmTypeFragment.c paramc)
      {
        super();
      }
      
      public final void a(String paramString, int paramInt, boolean paramBoolean)
      {
        j.e(paramString, "alarmType");
        if (paramBoolean) {
          this.c.a.L0().n(paramString, new a(this));
        }
      }
      
      static final class a
        extends Lambda
        implements kotlin.jvm.b.a<p>
      {
        a(SetAlarmTypeFragment.c.a parama)
        {
          super();
        }
        
        public final void a()
        {
          FragmentActivity localFragmentActivity = this.c.c.a.getActivity();
          if (localFragmentActivity != null) {
            e.e(localFragmentActivity, null, 1, null);
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\SetAlarmTypeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */