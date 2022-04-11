package com.tplink.iot.view.smart.actionsetup.taskdevice.hub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.AlarmTimeItemType;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.a;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.b;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentGuardModeSetAlarmTimeBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.NumberPickerView.d;
import com.tplink.iot.widget.NumberPickerView.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.m;

public final class TaskHubAlarmTimeFragment
  extends IoTMVVMBaseFragment<FragmentGuardModeSetAlarmTimeBinding>
{
  private int H3 = -1;
  private TaskHubControlFragment I3;
  private final f J3 = h.b(new a(this));
  private HashMap K3;
  private GuardModeAlarmTimeAdapter p1;
  private int p2 = 300;
  private int p3 = -1;
  
  private final void e1()
  {
    Object localObject = GuardModeAlarmTimeAdapter.k;
    Integer localInteger = (Integer)kotlin.collections.l.z(((GuardModeAlarmTimeAdapter.b)localObject).a(), this.p3);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      localObject = (Integer)kotlin.collections.l.z(((GuardModeAlarmTimeAdapter.b)localObject).b(), this.H3);
      if ((localObject != null) && (i * 60 + ((Integer)localObject).intValue() < 5)) {
        k1(5);
      }
    }
  }
  
  private final int f1(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 5) {
      i = 5;
    }
    return i;
  }
  
  private final TaskHubControlViewModel g1()
  {
    return (TaskHubControlViewModel)this.J3.getValue();
  }
  
  private final void h1()
  {
    Object localObject = this.p1;
    if (localObject != null)
    {
      GuardModeAlarmTimeAdapter.a locala = (GuardModeAlarmTimeAdapter.a)((SingleCheckMarkAdapter)localObject).t();
      if (locala != null)
      {
        localObject = locala.a();
        int i = a.a[localObject.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              g1().u(EnumGuardModeAlarmTimeType.CUSTOM_TIME, locala.b());
            }
          }
          else {
            g1().u(EnumGuardModeAlarmTimeType.ALWAYS, 0);
          }
        }
        else
        {
          this.p2 = f1(this.p2);
          g1().u(EnumGuardModeAlarmTimeType.CUSTOM_TIME, this.p2);
        }
      }
    }
  }
  
  private final void i1(int paramInt)
  {
    Object localObject = Integer.valueOf(GuardModeAlarmTimeAdapter.k.a().indexOf(Integer.valueOf(paramInt)));
    paramInt = ((Number)localObject).intValue();
    int i = 0;
    if (paramInt != -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0) {
      localObject = null;
    }
    paramInt = i;
    if (localObject != null) {
      paramInt = ((Integer)localObject).intValue();
    }
    localObject = ((FragmentGuardModeSetAlarmTimeBinding)J0()).d;
    j.d(localObject, "mBinding.npvAlarmTimeMin");
    ((NumberPickerView)localObject).setValue(paramInt);
  }
  
  private final void j1(int paramInt)
  {
    Object localObject = Integer.valueOf(GuardModeAlarmTimeAdapter.k.b().indexOf(Integer.valueOf(paramInt)));
    paramInt = ((Number)localObject).intValue();
    int i = 1;
    if (paramInt != -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0) {
      localObject = null;
    }
    paramInt = i;
    if (localObject != null) {
      paramInt = ((Integer)localObject).intValue();
    }
    localObject = ((FragmentGuardModeSetAlarmTimeBinding)J0()).f;
    j.d(localObject, "mBinding.npvAlarmTimeSec");
    ((NumberPickerView)localObject).setValue(paramInt);
  }
  
  private final void k1(int paramInt)
  {
    i1(paramInt / 60);
    j1(paramInt % 60);
  }
  
  private final void l1()
  {
    Object localObject = ((FragmentGuardModeSetAlarmTimeBinding)J0()).d;
    j.d(localObject, "mBinding.npvAlarmTimeMin");
    localObject = ((NumberPickerView)localObject).getContentByCurrValue();
    j.d(localObject, "mBinding.npvAlarmTimeMin.contentByCurrValue");
    localObject = m.k((String)localObject);
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      localObject = ((FragmentGuardModeSetAlarmTimeBinding)J0()).f;
      j.d(localObject, "mBinding.npvAlarmTimeSec");
      localObject = ((NumberPickerView)localObject).getContentByCurrValue();
      j.d(localObject, "mBinding.npvAlarmTimeSec.contentByCurrValue");
      localObject = m.k((String)localObject);
      if (localObject != null)
      {
        int j = i * 60 + ((Integer)localObject).intValue();
        i = j;
        if (j < 5)
        {
          k1(5);
          i = 5;
        }
        this.p2 = i;
      }
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.K3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558928;
  }
  
  public void R0()
  {
    g1().i().observe(getViewLifecycleOwner(), new g(this));
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
    this.I3 = paramContext;
  }
  
  public void onDestroy()
  {
    h1();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = requireContext();
    j.d(paramView, "requireContext()");
    paramView = new GuardModeAlarmTimeAdapter(paramView);
    paramBundle = ((FragmentGuardModeSetAlarmTimeBinding)J0()).q;
    j.d(paramBundle, "mBinding.rvConfigAlarmTime");
    paramBundle.setAdapter(paramView);
    paramView.y(new b(this));
    paramBundle = p.a;
    this.p1 = paramView;
    paramView = ((FragmentGuardModeSetAlarmTimeBinding)J0()).d;
    Object localObject = GuardModeAlarmTimeAdapter.k.a();
    paramBundle = new ArrayList(kotlin.collections.l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBundle.add(String.valueOf(((Number)((Iterator)localObject).next()).intValue()));
    }
    paramBundle = paramBundle.toArray(new String[0]);
    Objects.requireNonNull(paramBundle, "null cannot be cast to non-null type kotlin.Array<T>");
    paramView.S((String[])paramBundle);
    paramView.setOnValueChangeListenerInScrolling(new c(this));
    paramView.setOnValueChangedListener(new d(this));
    paramView = ((FragmentGuardModeSetAlarmTimeBinding)J0()).f;
    localObject = GuardModeAlarmTimeAdapter.k.b();
    paramBundle = new ArrayList(kotlin.collections.l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBundle.add(String.valueOf(((Number)((Iterator)localObject).next()).intValue()));
    }
    paramBundle = paramBundle.toArray(new String[0]);
    Objects.requireNonNull(paramBundle, "null cannot be cast to non-null type kotlin.Array<T>");
    paramView.S((String[])paramBundle);
    paramView.setOnValueChangeListenerInScrolling(new e(this));
    paramView.setOnValueChangedListener(new f(this));
    k1(300);
    paramView = this.I3;
    if (paramView == null) {
      j.t("mParentFragment");
    }
    paramView.f1(2131952746);
    R0();
  }
  
  static final class a
    extends Lambda
    implements a<TaskHubControlViewModel>
  {
    a(TaskHubAlarmTimeFragment paramTaskHubAlarmTimeFragment)
    {
      super();
    }
    
    public final TaskHubControlViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(TaskHubAlarmTimeFragment.Y0(this.c), new IoTViewModelFactory(TaskHubAlarmTimeFragment.Y0(this.c), TaskHubAlarmTimeFragment.X0(this.c))).get(TaskHubControlViewModel.class);
      j.d(localViewModel, "ViewModelProvider(mParen…rolViewModel::class.java)");
      return (TaskHubControlViewModel)localViewModel;
    }
  }
  
  static final class b
    extends Lambda
    implements q<GuardModeAlarmTimeAdapter.a, Integer, Boolean, p>
  {
    b(TaskHubAlarmTimeFragment paramTaskHubAlarmTimeFragment)
    {
      super();
    }
    
    public final void a(GuardModeAlarmTimeAdapter.a parama, int paramInt, boolean paramBoolean)
    {
      j.e(parama, "alarmTime");
      LinearLayout localLinearLayout = TaskHubAlarmTimeFragment.V0(this.c).c;
      j.d(localLinearLayout, "mBinding.llTimePicker");
      parama = parama.a();
      GuardModeAlarmTimeAdapter.AlarmTimeItemType localAlarmTimeItemType = GuardModeAlarmTimeAdapter.AlarmTimeItemType.CUSTOM;
      int i = 0;
      if (parama == localAlarmTimeItemType) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        paramInt = i;
      } else {
        paramInt = 8;
      }
      localLinearLayout.setVisibility(paramInt);
    }
  }
  
  static final class c
    implements NumberPickerView.e
  {
    c(TaskHubAlarmTimeFragment paramTaskHubAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      TaskHubAlarmTimeFragment.b1(this.a, paramInt2);
      TaskHubAlarmTimeFragment.S0(this.a);
    }
  }
  
  static final class d
    implements NumberPickerView.d
  {
    d(TaskHubAlarmTimeFragment paramTaskHubAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      TaskHubAlarmTimeFragment.d1(this.c);
    }
  }
  
  static final class e
    implements NumberPickerView.e
  {
    e(TaskHubAlarmTimeFragment paramTaskHubAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      TaskHubAlarmTimeFragment.c1(this.a, paramInt2);
      TaskHubAlarmTimeFragment.S0(this.a);
    }
  }
  
  static final class f
    implements NumberPickerView.d
  {
    f(TaskHubAlarmTimeFragment paramTaskHubAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      TaskHubAlarmTimeFragment.d1(this.c);
    }
  }
  
  static final class g<T>
    implements Observer<GuardModeConfigBean>
  {
    g(TaskHubAlarmTimeFragment paramTaskHubAlarmTimeFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      if (paramGuardModeConfigBean == null) {
        return;
      }
      GuardModeAlarmTimeBean localGuardModeAlarmTimeBean = paramGuardModeConfigBean.getAlarmTime();
      if (localGuardModeAlarmTimeBean.getEnumType() == EnumGuardModeAlarmTimeType.ALWAYS)
      {
        paramGuardModeConfigBean = TaskHubAlarmTimeFragment.U0(this.a);
        if (paramGuardModeConfigBean != null) {
          paramGuardModeConfigBean.D(300, new a(this));
        }
      }
      else
      {
        paramGuardModeConfigBean = TaskHubAlarmTimeFragment.U0(this.a);
        if (paramGuardModeConfigBean != null) {
          paramGuardModeConfigBean.D(localGuardModeAlarmTimeBean.getTime(), new b(this));
        }
      }
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<Integer, p>
    {
      a(TaskHubAlarmTimeFragment.g paramg)
      {
        super();
      }
      
      public final void a(int paramInt)
      {
        TaskHubAlarmTimeFragment.a1(this.c.a, paramInt);
        TaskHubAlarmTimeFragment.Z0(this.c.a, paramInt);
      }
    }
    
    static final class b
      extends Lambda
      implements kotlin.jvm.b.l<Integer, p>
    {
      b(TaskHubAlarmTimeFragment.g paramg)
      {
        super();
      }
      
      public final void a(int paramInt)
      {
        TaskHubAlarmTimeFragment localTaskHubAlarmTimeFragment = this.c.a;
        TaskHubAlarmTimeFragment.a1(localTaskHubAlarmTimeFragment, TaskHubAlarmTimeFragment.T0(localTaskHubAlarmTimeFragment, paramInt));
        localTaskHubAlarmTimeFragment = this.c.a;
        TaskHubAlarmTimeFragment.Z0(localTaskHubAlarmTimeFragment, TaskHubAlarmTimeFragment.W0(localTaskHubAlarmTimeFragment));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\hub\TaskHubAlarmTimeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */