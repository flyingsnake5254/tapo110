package com.tplink.iot.view.smart.actionsetup.taskdevice.hub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter.a;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentGuardModeRecyclerviewListBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import java.util.HashMap;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class TaskHubAlarmVolumeFragment
  extends IoTMVVMBaseFragment<FragmentGuardModeRecyclerviewListBinding>
{
  private HashMap H3;
  private TaskHubControlFragment p1;
  private final f p2 = h.b(new a(this));
  private GuardModeAlarmVolumeAdapter p3;
  
  private final TaskHubControlViewModel V0()
  {
    return (TaskHubControlViewModel)this.p2.getValue();
  }
  
  private final void W0()
  {
    Object localObject = this.p3;
    if (localObject != null)
    {
      localObject = (GuardModeAlarmVolumeAdapter.a)((SingleCheckMarkAdapter)localObject).t();
      if (localObject != null) {
        V0().w(((GuardModeAlarmVolumeAdapter.a)localObject).b());
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
  
  public int I0()
  {
    return 2131558927;
  }
  
  public void R0()
  {
    V0().i().observe(getViewLifecycleOwner(), new b(this));
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
    W0();
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
    paramView.f1(2131952747);
    paramView = requireContext();
    j.d(paramView, "requireContext()");
    paramView = new GuardModeAlarmVolumeAdapter(paramView);
    paramBundle = ((FragmentGuardModeRecyclerviewListBinding)J0()).c;
    j.d(paramBundle, "mBinding.configItemList");
    paramBundle.setAdapter(paramView);
    paramBundle = p.a;
    this.p3 = paramView;
    R0();
  }
  
  static final class a
    extends Lambda
    implements a<TaskHubControlViewModel>
  {
    a(TaskHubAlarmVolumeFragment paramTaskHubAlarmVolumeFragment)
    {
      super();
    }
    
    public final TaskHubControlViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(TaskHubAlarmVolumeFragment.U0(this.c), new IoTViewModelFactory(TaskHubAlarmVolumeFragment.U0(this.c), TaskHubAlarmVolumeFragment.T0(this.c))).get(TaskHubControlViewModel.class);
      j.d(localViewModel, "ViewModelProvider(mParen…rolViewModel::class.java)");
      return (TaskHubControlViewModel)localViewModel;
    }
  }
  
  static final class b<T>
    implements Observer<GuardModeConfigBean>
  {
    b(TaskHubAlarmVolumeFragment paramTaskHubAlarmVolumeFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      if (paramGuardModeConfigBean != null)
      {
        GuardModeAlarmVolumeAdapter localGuardModeAlarmVolumeAdapter = TaskHubAlarmVolumeFragment.S0(this.a);
        if (localGuardModeAlarmVolumeAdapter != null) {
          localGuardModeAlarmVolumeAdapter.C(paramGuardModeConfigBean.getEnumAlarmVolume());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\hub\TaskHubAlarmVolumeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */