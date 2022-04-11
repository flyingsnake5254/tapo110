package com.tplink.iot.view.iotsensor;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.LayoutSelectReportIntervalBinding;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.iotsensor.SensorSetReportIntervalViewModel;
import com.tplink.iot.widget.NumberPickerView;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.l;
import kotlin.collections.z;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.v.d;

public final class SelectReportIntervalFragment
  extends DialogFragment
{
  public static final a c = new a(null);
  private final List<Integer> d;
  private LayoutSelectReportIntervalBinding f;
  private String q;
  private final f x;
  private HashMap y;
  
  public SelectReportIntervalFragment()
  {
    Object localObject = new d(1, 15);
    ArrayList localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(((z)localObject).nextInt() * 4));
    }
    this.d = localArrayList;
    this.q = "";
    this.x = h.b(new b(this));
  }
  
  private final int J0()
  {
    int i = this.d.indexOf(Integer.valueOf(8));
    if (i == -1) {
      i = 1;
    }
    return i;
  }
  
  private final SensorSetReportIntervalViewModel K0()
  {
    return (SensorSetReportIntervalViewModel)this.x.getValue();
  }
  
  private final void L0(int paramInt)
  {
    paramInt = this.d.indexOf(Integer.valueOf(paramInt));
    Object localObject = this.f;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((LayoutSelectReportIntervalBinding)localObject).c;
    j.d(localObject, "mBinding.intervalPicker");
    if (paramInt == -1) {
      paramInt = J0();
    }
    ((NumberPickerView)localObject).setValue(paramInt);
  }
  
  private final void N0()
  {
    K0().f().observe(getViewLifecycleOwner(), new e(this));
  }
  
  private final void O0(int paramInt)
  {
    K0().g(paramInt).r(io.reactivex.d0.b.a.a()).l(new f(this)).i(new g(this)).j(new h(this)).y();
  }
  
  public void A0()
  {
    HashMap localHashMap = this.y;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onAttach(Context paramContext)
  {
    j.e(paramContext, "context");
    super.onAttach(paramContext);
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
    this.q = paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    paramLayoutInflater = DataBindingUtil.inflate(paramLayoutInflater, 2131559214, paramViewGroup, false);
    j.d(paramLayoutInflater, "DataBindingUtil.inflate(…terval, container, false)");
    paramLayoutInflater = (LayoutSelectReportIntervalBinding)paramLayoutInflater;
    this.f = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      j.t("mBinding");
    }
    paramLayoutInflater = paramLayoutInflater.getRoot();
    j.d(paramLayoutInflater, "mBinding.root");
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    e.c(this, false, false, false, 5, null);
    paramView = this.f;
    if (paramView == null) {
      j.t("mBinding");
    }
    paramView = paramView.c;
    Object localObject = this.d;
    paramBundle = new ArrayList(l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBundle.add(String.valueOf(((Number)((Iterator)localObject).next()).intValue()));
    }
    paramBundle = paramBundle.toArray(new String[0]);
    Objects.requireNonNull(paramBundle, "null cannot be cast to non-null type kotlin.Array<T>");
    paramView.setDisplayedValues((String[])paramBundle);
    paramView.setMinValue(0);
    paramView.setMaxValue(this.d.size() - 1);
    paramView.setValue(J0());
    paramView = this.f;
    if (paramView == null) {
      j.t("mBinding");
    }
    paramView.f.setOnClickListener(new c(this));
    paramView = this.f;
    if (paramView == null) {
      j.t("mBinding");
    }
    paramView.d.setOnClickListener(new d(this));
    setCancelable(true);
    paramView = this.f;
    if (paramView == null) {
      j.t("mBinding");
    }
    paramView = paramView.getRoot();
    paramBundle = AnimationUtils.loadAnimation(getContext(), 2130772038);
    paramBundle.setDuration(200L);
    localObject = p.a;
    paramView.startAnimation(paramBundle);
    N0();
  }
  
  public static final class a
  {
    public final SelectReportIntervalFragment a(String paramString)
    {
      j.e(paramString, "deviceIdMD5");
      SelectReportIntervalFragment localSelectReportIntervalFragment = new SelectReportIntervalFragment();
      Bundle localBundle = new Bundle();
      localBundle.putString("device_id_md5", paramString);
      paramString = p.a;
      localSelectReportIntervalFragment.setArguments(localBundle);
      return localSelectReportIntervalFragment;
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<SensorSetReportIntervalViewModel>
  {
    b(SelectReportIntervalFragment paramSelectReportIntervalFragment)
    {
      super();
    }
    
    public final SensorSetReportIntervalViewModel a()
    {
      FragmentActivity localFragmentActivity = this.c.requireActivity();
      SelectReportIntervalFragment localSelectReportIntervalFragment = this.c;
      return (SensorSetReportIntervalViewModel)new ViewModelProvider(localFragmentActivity, new IoTViewModelFactory(localSelectReportIntervalFragment, SelectReportIntervalFragment.C0(localSelectReportIntervalFragment))).get(SensorSetReportIntervalViewModel.class);
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(SelectReportIntervalFragment paramSelectReportIntervalFragment) {}
    
    public final void onClick(View paramView)
    {
      List localList = SelectReportIntervalFragment.G0(this.c);
      paramView = SelectReportIntervalFragment.B0(this.c).c;
      j.d(paramView, "mBinding.intervalPicker");
      paramView = (Integer)l.z(localList, paramView.getValue());
      if (paramView != null)
      {
        int i = paramView.intValue();
        SelectReportIntervalFragment.I0(this.c, i);
      }
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(SelectReportIntervalFragment paramSelectReportIntervalFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismissAllowingStateLoss();
    }
  }
  
  static final class e<T>
    implements Observer<Integer>
  {
    e(SelectReportIntervalFragment paramSelectReportIntervalFragment) {}
    
    public final void a(Integer paramInteger)
    {
      if (paramInteger != null)
      {
        int i = paramInteger.intValue();
        SelectReportIntervalFragment.H0(this.a, i);
      }
    }
  }
  
  static final class f<T>
    implements g<c>
  {
    f(SelectReportIntervalFragment paramSelectReportIntervalFragment) {}
    
    public final void a(c paramc)
    {
      s0.l(this.c.getActivity());
    }
  }
  
  static final class g
    implements io.reactivex.g0.a
  {
    g(SelectReportIntervalFragment paramSelectReportIntervalFragment) {}
    
    public final void run()
    {
      s0.g();
      this.a.dismissAllowingStateLoss();
    }
  }
  
  static final class h<T>
    implements g<Throwable>
  {
    h(SelectReportIntervalFragment paramSelectReportIntervalFragment) {}
    
    public final void a(Throwable paramThrowable)
    {
      s0.o(this.c.getActivity(), 2131952444, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\SelectReportIntervalFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */