package com.tplink.iot.view.smart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import b.d.n.i.g;
import b.d.s.a.a;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.Utils.s;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.v;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.view.smart.myactions.ShortcutResortActivity;
import com.tplink.iot.view.smart.myactions.SmartActionFragment;
import com.tplink.iot.view.smart.template.SmartTemplateFragment;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.List;

public class SmartFragment
  extends BaseFragment
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private ArrayList<String> p0 = new ArrayList();
  private View q;
  private View x;
  private ViewPager y;
  private ArrayList<BaseFragment> z = new ArrayList();
  
  private void J0()
  {
    View localView = this.q.findViewById(2131364054);
    this.x = localView;
    localView.setOnClickListener(this);
    this.q.findViewById(2131364050).setOnClickListener(this);
    this.y = ((ViewPager)this.q.findViewById(2131364051));
    this.z.add(L0());
    this.z.add(K0());
    this.p0.add(getString(2131954074));
    this.p0.add(getString(2131954054));
    this.y.setAdapter(new a(getChildFragmentManager()));
    this.y.addOnPageChangeListener(this);
    ((TabLayout)this.q.findViewById(2131364055)).setupWithViewPager(this.y);
    int i = o.h0().X();
    int j = 1;
    if ((i != 1) || (!N0())) {
      j = 0;
    }
    this.y.setCurrentItem(j);
  }
  
  private BaseFragment K0()
  {
    Object localObject1 = getChildFragmentManager().findFragmentByTag(O0(this.y.getId(), 1L));
    if ((localObject1 instanceof SmartActionFragment)) {
      localObject1 = (SmartActionFragment)localObject1;
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SmartActionFragment();
    }
    return (BaseFragment)localObject2;
  }
  
  private BaseFragment L0()
  {
    Object localObject1 = getChildFragmentManager().findFragmentByTag(O0(this.y.getId(), 0L));
    if ((localObject1 instanceof SmartTemplateFragment)) {
      localObject1 = (SmartTemplateFragment)localObject1;
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SmartTemplateFragment();
    }
    return (BaseFragment)localObject2;
  }
  
  private boolean N0()
  {
    return s.b((List)((SmartRepository)b.d.b.f.b.a(a.f(), SmartRepository.class)).P().getValue()) ^ true;
  }
  
  private String O0(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android:switcher:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public void P0()
  {
    this.y.setCurrentItem(1);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364050)
    {
      if (i == 2131364054)
      {
        o.h0().k("new_smart_info", null);
        C0(ShortcutResortActivity.class);
      }
    }
    else
    {
      v.c();
      if (((ActionSetupViewModel)ViewModelProviders.of(this).get(ActionSetupViewModel.class)).o0())
      {
        s0.p(getActivity(), getString(2131953943, new Object[] { Integer.valueOf(64) }));
      }
      else
      {
        o.h0().k("new_smart_info", null);
        ActionDetailActivity.F1(getContext(), -1, 1);
      }
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558951, paramViewGroup, false);
    d.J(getActivity(), this.q.findViewById(2131364053));
    setHasOptionsMenu(true);
    J0();
    b.d.n.f.b.l().f("tapo_pageid_smart");
    return this.q;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    ViewPager localViewPager = this.y;
    if ((localViewPager != null) && (!paramBoolean) && (localViewPager.getCurrentItem() == 1)) {
      ((SmartActionFragment)this.z.get(1)).g1();
    } else {
      o.h0().k("new_smart_info", null);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    View localView = this.x;
    int i;
    if (paramInt == 0) {
      i = 4;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    o.h0().u0(paramInt);
  }
  
  public void onResume()
  {
    super.onResume();
    ViewPager localViewPager = this.y;
    if ((localViewPager != null) && (localViewPager.getCurrentItem() == 1)) {
      ((SmartActionFragment)this.z.get(1)).g1();
    }
  }
  
  private class a
    extends FragmentPagerAdapter
  {
    a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)SmartFragment.H0(SmartFragment.this).get(paramInt);
    }
    
    @Nullable
    public CharSequence getPageTitle(int paramInt)
    {
      return (CharSequence)SmartFragment.I0(SmartFragment.this).get(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\SmartFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */