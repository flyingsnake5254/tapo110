package com.tplink.iot.view.smart.actionsetup.taskdevice.hub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentGuardModeRecyclerviewListBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class TaskHubAlarmTypeFragment
  extends IoTMVVMBaseFragment<FragmentGuardModeRecyclerviewListBinding>
{
  private String H3;
  private HashMap I3;
  private TaskHubControlFragment p1;
  private final f p2 = h.b(new a(this));
  private GuardModeAlarmTypeAdapter p3;
  
  private final TaskHubControlViewModel Z0()
  {
    return (TaskHubControlViewModel)this.p2.getValue();
  }
  
  private final void a1()
  {
    TaskHubControlViewModel localTaskHubControlViewModel = Z0();
    Object localObject = this.p3;
    if (localObject != null)
    {
      localObject = (String)((SingleCheckMarkAdapter)localObject).u();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    localTaskHubControlViewModel.v((String)localObject);
  }
  
  private final void b1()
  {
    GuardModeAlarmTypeAdapter localGuardModeAlarmTypeAdapter = this.p3;
    if (localGuardModeAlarmTypeAdapter != null) {
      localGuardModeAlarmTypeAdapter.B(this.H3);
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.I3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558927;
  }
  
  public void R0()
  {
    Z0().i().observe(getViewLifecycleOwner(), new b(this));
    Z0().n().observe(getViewLifecycleOwner(), new c(this));
  }
  
  public void onAttach(Context paramContext)
  {
    j.e(paramContext, "context");
    super.onAttach(paramContext);
    Fragment localFragment = getParentFragment();
    paramContext = localFragment;
    if (!(localFragment instanceof TaskHubControlFragment)) {
      paramContext = null;
    }
    paramContext = (TaskHubControlFragment)paramContext;
    if (paramContext == null)
    {
      getParentFragmentManager().popBackStackImmediate();
      return;
    }
    this.p1 = paramContext;
  }
  
  public void onDestroy()
  {
    a1();
    Z0().t();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = this.p1;
    if (paramView == null) {
      j.t("mParentFragment");
    }
    paramView.f1(2131951863);
    R0();
    Z0().m();
  }
  
  static final class a
    extends Lambda
    implements a<TaskHubControlViewModel>
  {
    a(TaskHubAlarmTypeFragment paramTaskHubAlarmTypeFragment)
    {
      super();
    }
    
    public final TaskHubControlViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(TaskHubAlarmTypeFragment.U0(this.c), new IoTViewModelFactory(TaskHubAlarmTypeFragment.U0(this.c), TaskHubAlarmTypeFragment.T0(this.c))).get(TaskHubControlViewModel.class);
      j.d(localViewModel, "ViewModelProvider(mParen…rolViewModel::class.java)");
      return (TaskHubControlViewModel)localViewModel;
    }
  }
  
  static final class b<T>
    implements Observer<GuardModeConfigBean>
  {
    b(TaskHubAlarmTypeFragment paramTaskHubAlarmTypeFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      TaskHubAlarmTypeFragment localTaskHubAlarmTypeFragment = this.a;
      if (paramGuardModeConfigBean != null) {
        paramGuardModeConfigBean = paramGuardModeConfigBean.getAlarmType();
      } else {
        paramGuardModeConfigBean = null;
      }
      TaskHubAlarmTypeFragment.X0(localTaskHubAlarmTypeFragment, paramGuardModeConfigBean);
      TaskHubAlarmTypeFragment.Y0(this.a);
    }
  }
  
  static final class c<T>
    implements Observer<List<? extends String>>
  {
    c(TaskHubAlarmTypeFragment paramTaskHubAlarmTypeFragment) {}
    
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
      TaskHubAlarmTypeFragment localTaskHubAlarmTypeFragment = this.a;
      Object localObject = this.a.requireContext();
      j.d(localObject, "requireContext()");
      paramList = new GuardModeAlarmTypeAdapter(paramList, (Context)localObject);
      paramList.y(new a(this));
      paramList.x(true);
      localObject = TaskHubAlarmTypeFragment.S0(this.a).c;
      j.d(localObject, "mBinding.configItemList");
      ((RecyclerView)localObject).setAdapter(paramList);
      localObject = p.a;
      TaskHubAlarmTypeFragment.W0(localTaskHubAlarmTypeFragment, paramList);
      TaskHubAlarmTypeFragment.Y0(this.a);
    }
    
    static final class a
      extends Lambda
      implements q<String, Integer, Boolean, p>
    {
      a(TaskHubAlarmTypeFragment.c paramc)
      {
        super();
      }
      
      public final void a(String paramString, int paramInt, boolean paramBoolean)
      {
        j.e(paramString, "alarmType");
        if (paramBoolean) {
          TaskHubAlarmTypeFragment.V0(this.c.a).s(paramString, new a(this));
        }
      }
      
      static final class a
        extends Lambda
        implements a<p>
      {
        a(TaskHubAlarmTypeFragment.c.a parama)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\hub\TaskHubAlarmTypeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */