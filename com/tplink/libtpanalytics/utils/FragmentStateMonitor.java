package com.tplink.libtpanalytics.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks;
import androidx.fragment.app.FragmentManager.OnBackStackChangedListener;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FragmentStateMonitor
  extends FragmentManager.FragmentLifecycleCallbacks
{
  private static FragmentStateMonitor a;
  private static final b b = new a();
  private WeakReference<Fragment> c = new WeakReference(null);
  private final ArrayList<b> d = new ArrayList();
  
  private void d(Fragment paramFragment, View paramView)
  {
    if ((paramFragment != null) && (paramView != null)) {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new d(paramView, paramFragment));
    }
  }
  
  private void e(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    paramFragment.getChildFragmentManager().addOnBackStackChangedListener(new c(paramFragment.getChildFragmentManager()));
  }
  
  private void f(FragmentActivity paramFragmentActivity)
  {
    if (paramFragmentActivity == null) {
      return;
    }
    paramFragmentActivity.getSupportFragmentManager().addOnBackStackChangedListener(new c(paramFragmentActivity.getSupportFragmentManager()));
  }
  
  private void g(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = localViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
      {
        paramView = localViewGroup.getChildAt(j);
        if (paramView == null) {
          return;
        }
        if ((paramView instanceof ViewPager))
        {
          ViewPager localViewPager = (ViewPager)paramView;
          if ((((localViewPager.getAdapter() instanceof FragmentPagerAdapter)) || ((localViewPager.getAdapter() instanceof FragmentStatePagerAdapter))) && (localViewPager.getAdapter() != null)) {
            localViewPager.addOnPageChangeListener(new e(localViewPager.getAdapter()));
          }
        }
        g(paramView);
      }
    }
  }
  
  public static FragmentStateMonitor h()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          FragmentStateMonitor localFragmentStateMonitor = new com/tplink/libtpanalytics/utils/FragmentStateMonitor;
          localFragmentStateMonitor.<init>();
          a = localFragmentStateMonitor;
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean i(Fragment paramFragment)
  {
    boolean bool1 = false;
    if (paramFragment == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (!paramFragment.isHidden())
    {
      bool2 = bool1;
      if (paramFragment.getUserVisibleHint())
      {
        bool2 = bool1;
        if (paramFragment.getView() != null) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private void l(Fragment paramFragment, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.c.get() != null) && (paramFragment != null) && (this.c.get() == paramFragment)) {
      return;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.b(paramFragment);
      localb.a((Fragment)this.c.get(), paramFragment);
    }
    this.c = new WeakReference(paramFragment);
  }
  
  public void m(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if ((paramActivity instanceof FragmentActivity))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)paramActivity;
      localFragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(this, true);
      f(localFragmentActivity);
      if (paramActivity.getWindow() == null) {
        return;
      }
      paramActivity = paramActivity.getWindow().getDecorView().findViewById(16908290);
      if (paramActivity != null) {
        paramActivity.post(new a(this, paramActivity));
      }
    }
  }
  
  public void n(b paramb)
  {
    if ((paramb != null) && (!this.d.contains(paramb))) {
      this.d.add(paramb);
    }
  }
  
  public void o(Activity paramActivity)
  {
    if ((paramActivity instanceof FragmentActivity)) {
      ((FragmentActivity)paramActivity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this);
    }
  }
  
  public void onFragmentCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @Nullable Bundle paramBundle)
  {
    e(paramFragment);
  }
  
  public void onFragmentResumed(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment)
  {
    for (paramFragmentManager = paramFragment; paramFragmentManager != null; paramFragmentManager = paramFragmentManager.getParentFragment()) {
      if (!i(paramFragmentManager))
      {
        i = 0;
        break label29;
      }
    }
    int i = 1;
    label29:
    if (i != 0) {
      l(paramFragment, false);
    }
  }
  
  public void onFragmentViewCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull View paramView, @Nullable Bundle paramBundle)
  {
    g(paramView);
    d(paramFragment, paramView);
  }
  
  public void p(b paramb)
  {
    if (paramb != null) {
      this.d.remove(paramb);
    }
  }
  
  class a
    implements FragmentStateMonitor.b
  {
    public void a(Fragment paramFragment1, Fragment paramFragment2)
    {
      String str = "";
      if (paramFragment1 != null) {
        paramFragment1 = paramFragment1.getClass().getSimpleName();
      } else {
        paramFragment1 = "";
      }
      if (paramFragment2 != null) {
        str = paramFragment2.getClass().getSimpleName();
      }
      paramFragment2 = new StringBuilder();
      paramFragment2.append("last Fragment:");
      paramFragment2.append(paramFragment1);
      paramFragment2.append("  current Fragment:");
      paramFragment2.append(str);
      i.c(paramFragment2.toString());
    }
    
    public void b(Fragment paramFragment) {}
  }
  
  public static abstract interface b
  {
    public abstract void a(Fragment paramFragment1, Fragment paramFragment2);
    
    public abstract void b(Fragment paramFragment);
  }
  
  private class c
    implements FragmentManager.OnBackStackChangedListener
  {
    private WeakReference<FragmentManager> a;
    
    public c(FragmentManager paramFragmentManager)
    {
      this.a = new WeakReference(paramFragmentManager);
    }
    
    public void onBackStackChanged()
    {
      if (this.a.get() != null)
      {
        FragmentManager localFragmentManager = (FragmentManager)this.a.get();
        Object localObject1 = null;
        Object localObject2;
        for (int i = localFragmentManager.getFragments().size() - 1;; i--)
        {
          localObject2 = localObject1;
          if (i < 0) {
            break;
          }
          if ((localFragmentManager.getFragments().get(i) != null) && (((Fragment)localFragmentManager.getFragments().get(i)).getView() != null))
          {
            localObject2 = (Fragment)localFragmentManager.getFragments().get(i);
            break;
          }
        }
        if (localObject2 == null) {
          return;
        }
        if ((localObject2 != FragmentStateMonitor.a(FragmentStateMonitor.this).get()) && (FragmentStateMonitor.b(FragmentStateMonitor.this, (Fragment)localObject2))) {
          FragmentStateMonitor.c(FragmentStateMonitor.this, (Fragment)localObject2, false);
        }
      }
    }
  }
  
  private class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private WeakReference<Fragment> c;
    private WeakReference<View> d;
    private int f;
    
    public d(View paramView, Fragment paramFragment)
    {
      this.c = new WeakReference(paramFragment);
      this.d = new WeakReference(paramView);
      this.f = paramView.getVisibility();
    }
    
    private void a(Fragment paramFragment)
    {
      if (paramFragment == null) {
        return;
      }
      paramFragment = paramFragment.getChildFragmentManager().getFragments().iterator();
      while (paramFragment.hasNext())
      {
        Fragment localFragment = (Fragment)paramFragment.next();
        if (FragmentStateMonitor.b(FragmentStateMonitor.this, localFragment))
        {
          FragmentStateMonitor.c(FragmentStateMonitor.this, localFragment, false);
          a(localFragment);
        }
      }
    }
    
    public void onGlobalLayout()
    {
      if ((this.d.get() != null) && (((View)this.d.get()).getVisibility() != this.f))
      {
        int i = ((View)this.d.get()).getVisibility();
        this.f = i;
        if (i == 0)
        {
          FragmentStateMonitor.c(FragmentStateMonitor.this, (Fragment)this.c.get(), false);
          a((Fragment)this.c.get());
        }
      }
    }
  }
  
  private class e
    implements ViewPager.OnPageChangeListener
  {
    private WeakReference<PagerAdapter> c;
    
    public e(PagerAdapter paramPagerAdapter)
    {
      this.c = new WeakReference(paramPagerAdapter);
    }
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      PagerAdapter localPagerAdapter = (PagerAdapter)this.c.get();
      if (localPagerAdapter != null)
      {
        if (paramInt >= localPagerAdapter.getCount()) {
          return;
        }
        if ((localPagerAdapter instanceof FragmentPagerAdapter)) {
          FragmentStateMonitor.c(FragmentStateMonitor.this, ((FragmentPagerAdapter)localPagerAdapter).getItem(paramInt), false);
        } else if ((localPagerAdapter instanceof FragmentStatePagerAdapter)) {
          FragmentStateMonitor.c(FragmentStateMonitor.this, ((FragmentStatePagerAdapter)localPagerAdapter).getItem(paramInt), false);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\FragmentStateMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */