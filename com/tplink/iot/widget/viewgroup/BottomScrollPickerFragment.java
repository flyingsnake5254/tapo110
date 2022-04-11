package com.tplink.iot.widget.viewgroup;

import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.FragmentBottomScrollPickerBinding;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.NumberPickerView.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class BottomScrollPickerFragment
  extends BottomSheetDialogFragment
{
  public static final a c = new a(null);
  private c d;
  private Integer f;
  private FragmentBottomScrollPickerBinding q;
  private HashMap x;
  
  private final FragmentBottomScrollPickerBinding I0()
  {
    FragmentBottomScrollPickerBinding localFragmentBottomScrollPickerBinding = this.q;
    j.c(localFragmentBottomScrollPickerBinding);
    return localFragmentBottomScrollPickerBinding;
  }
  
  private final int J0()
  {
    List localList = K0();
    c localc = this.d;
    if (localc == null) {
      j.t("mAdapter");
    }
    return N0(this, localList, localc.g(), 0, 2, null);
  }
  
  private final List<Integer> K0()
  {
    c localc = this.d;
    if (localc == null) {
      j.t("mAdapter");
    }
    return localc.h();
  }
  
  private final int L0(List<Integer> paramList, int paramInt1, int paramInt2)
  {
    paramList = Integer.valueOf(paramList.indexOf(Integer.valueOf(paramInt1)));
    if (paramList.intValue() != -1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0) {
      paramList = null;
    }
    if (paramList != null) {
      paramInt2 = paramList.intValue();
    }
    return paramInt2;
  }
  
  public void A0()
  {
    HashMap localHashMap = this.x;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void O0(FragmentManager paramFragmentManager)
  {
    j.e(paramFragmentManager, "fm");
    Fragment localFragment = paramFragmentManager.findFragmentByTag("BottomScrollPickerFragment");
    if (localFragment != null) {
      paramFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    if (isVisible()) {
      return;
    }
    show(paramFragmentManager, "BottomScrollPickerFragment");
  }
  
  public int getTheme()
  {
    return 2132017410;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {
      paramBundle = Integer.valueOf(paramBundle.getInt("InitValueArg"));
    } else {
      paramBundle = null;
    }
    this.f = paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    this.q = ((FragmentBottomScrollPickerBinding)DataBindingUtil.inflate(LayoutInflater.from(requireContext()), 2131558857, null, false));
    paramViewGroup = I0();
    paramLayoutInflater = paramViewGroup.d;
    paramBundle = this.d;
    if (paramBundle == null) {
      j.t("mAdapter");
    }
    paramLayoutInflater.setTextColor(paramBundle.a());
    paramViewGroup.d.setOnClickListener(new d(this));
    paramBundle = paramViewGroup.f;
    paramLayoutInflater = this.d;
    if (paramLayoutInflater == null) {
      j.t("mAdapter");
    }
    paramBundle.setTextColor(paramLayoutInflater.c());
    paramBundle = paramViewGroup.f;
    j.d(paramBundle, "tvDone");
    paramLayoutInflater = this.d;
    if (paramLayoutInflater == null) {
      j.t("mAdapter");
    }
    paramLayoutInflater = paramLayoutInflater.f();
    if (paramLayoutInflater == null) {
      paramLayoutInflater = getString(2131952405);
    }
    paramBundle.setText(paramLayoutInflater);
    paramViewGroup.f.setOnClickListener(new e(this));
    paramViewGroup = paramViewGroup.c;
    paramBundle = K0();
    paramLayoutInflater = new ArrayList(l.l(paramBundle, 10));
    paramBundle = paramBundle.iterator();
    int i;
    while (paramBundle.hasNext())
    {
      i = ((Number)paramBundle.next()).intValue();
      c localc = this.d;
      if (localc == null) {
        j.t("mAdapter");
      }
      paramLayoutInflater.add(localc.k(i));
    }
    paramLayoutInflater = paramLayoutInflater.toArray(new String[0]);
    Objects.requireNonNull(paramLayoutInflater, "null cannot be cast to non-null type kotlin.Array<T>");
    paramViewGroup.S((String[])paramLayoutInflater);
    paramLayoutInflater = this.d;
    if (paramLayoutInflater == null) {
      j.t("mAdapter");
    }
    paramLayoutInflater = paramLayoutInflater.e();
    if (paramLayoutInflater == null) {
      paramLayoutInflater = "";
    }
    paramViewGroup.setHintText(paramLayoutInflater);
    paramLayoutInflater = this.d;
    if (paramLayoutInflater == null) {
      j.t("mAdapter");
    }
    paramViewGroup.setWrapSelectorWheel(paramLayoutInflater.d());
    paramLayoutInflater = this.f;
    if (paramLayoutInflater == null) {
      i = J0();
    } else {
      i = L0(K0(), paramLayoutInflater.intValue(), J0());
    }
    paramViewGroup.setValue(i);
    paramViewGroup.setOnValueChangedListener(new f(this));
    paramLayoutInflater = I0().getRoot();
    j.d(paramLayoutInflater, "mBinding.root");
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.q = null;
    A0();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    setCancelable(false);
  }
  
  public static final class a
  {
    public final BottomScrollPickerFragment a(BottomScrollPickerFragment.c paramc, Integer paramInteger)
    {
      j.e(paramc, "adapter");
      if (paramInteger != null)
      {
        int i = paramInteger.intValue();
        paramInteger = new Bundle();
        paramInteger.putInt("InitValueArg", i);
      }
      else
      {
        paramInteger = null;
      }
      BottomScrollPickerFragment localBottomScrollPickerFragment = new BottomScrollPickerFragment();
      BottomScrollPickerFragment.H0(localBottomScrollPickerFragment, paramc);
      localBottomScrollPickerFragment.setArguments(paramInteger);
      return localBottomScrollPickerFragment;
    }
  }
  
  public static abstract class b
    implements BottomScrollPickerFragment.c
  {
    private final Resources a;
    
    public b()
    {
      AppContext localAppContext = AppContext.c;
      j.d(localAppContext, "AppContext.instance");
      this.a = localAppContext.getResources();
    }
    
    public int a()
    {
      return this.a.getColor(2131099808);
    }
    
    public boolean b()
    {
      return true;
    }
    
    public int c()
    {
      return this.a.getColor(2131099808);
    }
    
    public boolean d()
    {
      return BottomScrollPickerFragment.c.a.a(this);
    }
    
    public String f()
    {
      return this.a.getString(2131952405);
    }
    
    public void i(int paramInt)
    {
      BottomScrollPickerFragment.c.a.b(this, paramInt);
    }
    
    public String k(int paramInt)
    {
      return BottomScrollPickerFragment.c.a.c(this, paramInt);
    }
    
    public void onCancel() {}
  }
  
  public static abstract interface c
  {
    @ColorInt
    public abstract int a();
    
    public abstract boolean b();
    
    @ColorInt
    public abstract int c();
    
    public abstract boolean d();
    
    public abstract String e();
    
    public abstract String f();
    
    public abstract int g();
    
    public abstract List<Integer> h();
    
    public abstract void i(int paramInt);
    
    public abstract void j(int paramInt);
    
    public abstract String k(int paramInt);
    
    public abstract void onCancel();
    
    public static final class a
    {
      public static boolean a(BottomScrollPickerFragment.c paramc)
      {
        return false;
      }
      
      public static void b(BottomScrollPickerFragment.c paramc, int paramInt) {}
      
      public static String c(BottomScrollPickerFragment.c paramc, int paramInt)
      {
        return String.valueOf(paramInt);
      }
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(BottomScrollPickerFragment paramBottomScrollPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      BottomScrollPickerFragment.B0(this.c).onCancel();
      this.c.dismissAllowingStateLoss();
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(BottomScrollPickerFragment paramBottomScrollPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      BottomScrollPickerFragment.c localc = BottomScrollPickerFragment.B0(this.c);
      paramView = BottomScrollPickerFragment.G0(this.c);
      NumberPickerView localNumberPickerView = BottomScrollPickerFragment.C0(this.c).c;
      j.d(localNumberPickerView, "mBinding.pickerView");
      localc.j(((Number)paramView.get(localNumberPickerView.getValue())).intValue());
      if (BottomScrollPickerFragment.B0(this.c).b()) {
        this.c.dismissAllowingStateLoss();
      }
    }
  }
  
  static final class f
    implements NumberPickerView.d
  {
    f(BottomScrollPickerFragment paramBottomScrollPickerFragment) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      BottomScrollPickerFragment.B0(this.c).i(((Number)BottomScrollPickerFragment.G0(this.c).get(paramInt2)).intValue());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\BottomScrollPickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */