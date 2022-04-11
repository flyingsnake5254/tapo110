package com.tplink.iot.view.iothub.guardmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.AlarmTimeItemType;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.a;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.b;
import com.tplink.iot.databinding.FragmentGuardModeSetAlarmTimeBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
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
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.m;

public class SetAlarmTimeFragment
  extends BaseGuardModeSettingFragment
{
  public static final a p0 = new a(null);
  private int H3 = 300;
  private int I3 = -1;
  private int J3 = -1;
  private HashMap K3;
  private final int p1 = 2131952746;
  private FragmentGuardModeSetAlarmTimeBinding p2;
  private GuardModeAlarmTimeAdapter p3;
  
  private final void Z0()
  {
    Object localObject = GuardModeAlarmTimeAdapter.k;
    Integer localInteger = (Integer)kotlin.collections.l.z(((GuardModeAlarmTimeAdapter.b)localObject).a(), this.I3);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      localObject = (Integer)kotlin.collections.l.z(((GuardModeAlarmTimeAdapter.b)localObject).b(), this.J3);
      if ((localObject != null) && (i * 60 + ((Integer)localObject).intValue() < 5)) {
        e1(5);
      }
    }
  }
  
  private final int a1(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 5) {
      i = 5;
    }
    return i;
  }
  
  private final FragmentGuardModeSetAlarmTimeBinding b1()
  {
    FragmentGuardModeSetAlarmTimeBinding localFragmentGuardModeSetAlarmTimeBinding = this.p2;
    j.c(localFragmentGuardModeSetAlarmTimeBinding);
    return localFragmentGuardModeSetAlarmTimeBinding;
  }
  
  private final void c1(int paramInt)
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
    localObject = b1().d;
    j.d(localObject, "mBinding.npvAlarmTimeMin");
    ((NumberPickerView)localObject).setValue(paramInt);
  }
  
  private final void d1(int paramInt)
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
    localObject = b1().f;
    j.d(localObject, "mBinding.npvAlarmTimeSec");
    ((NumberPickerView)localObject).setValue(paramInt);
  }
  
  private final void e1(int paramInt)
  {
    c1(paramInt / 60);
    d1(paramInt % 60);
  }
  
  private final void f1()
  {
    Object localObject = b1().d;
    j.d(localObject, "mBinding.npvAlarmTimeMin");
    localObject = ((NumberPickerView)localObject).getContentByCurrValue();
    j.d(localObject, "mBinding.npvAlarmTimeMin.contentByCurrValue");
    localObject = m.k((String)localObject);
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      localObject = b1().f;
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
          e1(5);
          i = 5;
        }
        this.H3 = i;
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
  
  protected int J0()
  {
    return this.p1;
  }
  
  protected void N0()
  {
    Object localObject = this.p3;
    if (localObject == null) {
      j.t("mAdapter");
    }
    localObject = (GuardModeAlarmTimeAdapter.a)((SingleCheckMarkAdapter)localObject).t();
    GuardModeAlarmTimeAdapter.AlarmTimeItemType localAlarmTimeItemType = ((GuardModeAlarmTimeAdapter.a)localObject).a();
    int i = c.a[localAlarmTimeItemType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          L0().t(EnumGuardModeAlarmTimeType.CUSTOM_TIME, ((GuardModeAlarmTimeAdapter.a)localObject).b());
        }
      }
      else {
        L0().t(EnumGuardModeAlarmTimeType.ALWAYS, 0);
      }
    }
    else
    {
      this.H3 = a1(this.H3);
      L0().t(EnumGuardModeAlarmTimeType.CUSTOM_TIME, this.H3);
    }
  }
  
  protected void O0()
  {
    L0().i().observe(getViewLifecycleOwner(), new g(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    this.p2 = ((FragmentGuardModeSetAlarmTimeBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558928, paramViewGroup, false));
    return b1().getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.p2 = null;
    H0();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    paramView = requireContext();
    j.d(paramView, "requireContext()");
    paramView = new GuardModeAlarmTimeAdapter(paramView);
    paramBundle = b1().q;
    j.d(paramBundle, "mBinding.rvConfigAlarmTime");
    paramBundle.setAdapter(paramView);
    paramView.y(new b(this));
    paramBundle = p.a;
    this.p3 = paramView;
    paramView = b1().d;
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
    paramView = b1().f;
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
    e1(300);
  }
  
  public static final class a {}
  
  static final class b
    extends Lambda
    implements q<GuardModeAlarmTimeAdapter.a, Integer, Boolean, p>
  {
    b(SetAlarmTimeFragment paramSetAlarmTimeFragment)
    {
      super();
    }
    
    public final void a(GuardModeAlarmTimeAdapter.a parama, int paramInt, boolean paramBoolean)
    {
      j.e(parama, "alarmTime");
      LinearLayout localLinearLayout = SetAlarmTimeFragment.S0(this.c).c;
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
    c(SetAlarmTimeFragment paramSetAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      SetAlarmTimeFragment.W0(this.a, paramInt2);
      SetAlarmTimeFragment.P0(this.a);
    }
  }
  
  static final class d
    implements NumberPickerView.d
  {
    d(SetAlarmTimeFragment paramSetAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      SetAlarmTimeFragment.Y0(this.c);
    }
  }
  
  static final class e
    implements NumberPickerView.e
  {
    e(SetAlarmTimeFragment paramSetAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      SetAlarmTimeFragment.X0(this.a, paramInt2);
      SetAlarmTimeFragment.P0(this.a);
    }
  }
  
  static final class f
    implements NumberPickerView.d
  {
    f(SetAlarmTimeFragment paramSetAlarmTimeFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      SetAlarmTimeFragment.Y0(this.c);
    }
  }
  
  static final class g<T>
    implements Observer<GuardModeConfigBean>
  {
    g(SetAlarmTimeFragment paramSetAlarmTimeFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      if (paramGuardModeConfigBean != null)
      {
        paramGuardModeConfigBean = paramGuardModeConfigBean.getAlarmTime();
        if (paramGuardModeConfigBean.getEnumType() == EnumGuardModeAlarmTimeType.ALWAYS) {
          SetAlarmTimeFragment.R0(this.a).D(300, new a(this));
        } else {
          SetAlarmTimeFragment.R0(this.a).D(paramGuardModeConfigBean.getTime(), new b(this));
        }
      }
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<Integer, p>
    {
      a(SetAlarmTimeFragment.g paramg)
      {
        super();
      }
      
      public final void a(int paramInt)
      {
        SetAlarmTimeFragment.V0(this.c.a, paramInt);
        SetAlarmTimeFragment.U0(this.c.a, paramInt);
      }
    }
    
    static final class b
      extends Lambda
      implements kotlin.jvm.b.l<Integer, p>
    {
      b(SetAlarmTimeFragment.g paramg)
      {
        super();
      }
      
      public final void a(int paramInt)
      {
        SetAlarmTimeFragment localSetAlarmTimeFragment = this.c.a;
        SetAlarmTimeFragment.V0(localSetAlarmTimeFragment, SetAlarmTimeFragment.Q0(localSetAlarmTimeFragment, paramInt));
        localSetAlarmTimeFragment = this.c.a;
        SetAlarmTimeFragment.U0(localSetAlarmTimeFragment, SetAlarmTimeFragment.T0(localSetAlarmTimeFragment));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\SetAlarmTimeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */