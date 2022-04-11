package com.tplink.iot.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
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
import b.d.w.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.c;

public final class FragmentStateReceiver
  extends FragmentManager.FragmentLifecycleCallbacks
{
  private static WeakReference<Fragment> a = new WeakReference(null);
  private static final List<b> b = new ArrayList();
  private static final a c = new a();
  private static final boolean d = false;
  public static final FragmentStateReceiver e = new FragmentStateReceiver();
  
  private final boolean d(Fragment paramFragment)
  {
    boolean bool;
    if ((!paramFragment.isHidden()) && (paramFragment.getUserVisibleHint()) && (paramFragment.getView() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void e(Fragment paramFragment, boolean paramBoolean)
  {
    if ((!paramBoolean) && (a.get() != null) && (paramFragment != null) && (j.a((Fragment)a.get(), paramFragment))) {
      return;
    }
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.b(paramFragment);
      localb.a((Fragment)a.get(), paramFragment);
    }
    a = new WeakReference(paramFragment);
  }
  
  public static final void g()
  {
    h(c);
  }
  
  public static final void h(b paramb)
  {
    if (paramb != null)
    {
      List localList = b;
      if (!localList.contains(paramb)) {
        localList.add(paramb);
      }
    }
  }
  
  public static final void i(Activity paramActivity)
  {
    j.e(paramActivity, "activity");
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = (FragmentActivity)paramActivity;
      paramActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(e, true);
      c.a.b(paramActivity);
      paramActivity = paramActivity.getWindow();
      j.d(paramActivity, "activity.window");
      paramActivity = paramActivity.getDecorView().findViewById(16908290);
      if (paramActivity != null) {
        paramActivity.post(new f(paramActivity));
      }
    }
  }
  
  private final void j(String paramString)
  {
    if (d) {
      a.n("FragmentStateReceiver", paramString);
    }
  }
  
  public static final void k()
  {
    l(c);
  }
  
  public static final void l(b paramb)
  {
    if (paramb != null) {
      b.remove(paramb);
    }
  }
  
  public static final void m(Activity paramActivity)
  {
    j.e(paramActivity, "activity");
    if ((paramActivity instanceof FragmentActivity)) {
      ((FragmentActivity)paramActivity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(e);
    }
  }
  
  public void onFragmentCreated(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle)
  {
    j.e(paramFragmentManager, "fm");
    j.e(paramFragment, "f");
    paramFragmentManager = new StringBuilder();
    paramFragmentManager.append("Fragment State: ");
    paramFragmentManager.append(m.b(paramFragment.getClass()).b());
    paramFragmentManager.append(" Created!!!!!!!!!");
    j(paramFragmentManager.toString());
    c.a.a(paramFragment);
  }
  
  public void onFragmentDestroyed(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    j.e(paramFragmentManager, "fm");
    j.e(paramFragment, "f");
    paramFragmentManager = new StringBuilder();
    paramFragmentManager.append("Fragment State: ");
    paramFragmentManager.append(m.b(paramFragment.getClass()).b());
    paramFragmentManager.append(" Destroyed!!!!!!!!!");
    j(paramFragmentManager.toString());
  }
  
  public void onFragmentPaused(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    j.e(paramFragmentManager, "fm");
    j.e(paramFragment, "f");
    paramFragmentManager = new StringBuilder();
    paramFragmentManager.append("Fragment State: ");
    paramFragmentManager.append(m.b(paramFragment.getClass()).b());
    paramFragmentManager.append(" Paused!!!!!!!!!");
    j(paramFragmentManager.toString());
  }
  
  public void onFragmentResumed(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    j.e(paramFragmentManager, "fm");
    j.e(paramFragment, "f");
    paramFragmentManager = new StringBuilder();
    paramFragmentManager.append("Fragment State: ");
    paramFragmentManager.append(m.b(paramFragment.getClass()).b());
    paramFragmentManager.append(" Resumed!!!!!!!!!");
    j(paramFragmentManager.toString());
    for (paramFragmentManager = paramFragment; paramFragmentManager != null; paramFragmentManager = paramFragmentManager.getParentFragment()) {
      if (!d(paramFragmentManager))
      {
        i = 0;
        break label88;
      }
    }
    int i = 1;
    label88:
    if (i != 0)
    {
      paramFragmentManager = new StringBuilder();
      paramFragmentManager.append("Fragment State: ");
      paramFragmentManager.append(m.b(paramFragment.getClass()).b());
      paramFragmentManager.append(" Resumed & VISIBLE & UserVisibleHint");
      j(paramFragmentManager.toString());
      e(paramFragment, true);
    }
  }
  
  public void onFragmentStarted(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    j.e(paramFragmentManager, "fm");
    j.e(paramFragment, "f");
    paramFragmentManager = new StringBuilder();
    paramFragmentManager.append("Fragment State: ");
    paramFragmentManager.append(m.b(paramFragment.getClass()).b());
    paramFragmentManager.append(" Started!!!!!!!!!");
    j(paramFragmentManager.toString());
  }
  
  public void onFragmentViewCreated(FragmentManager paramFragmentManager, Fragment paramFragment, View paramView, Bundle paramBundle)
  {
    j.e(paramFragmentManager, "fm");
    j.e(paramFragment, "f");
    j.e(paramView, "v");
    d.c.a(paramFragment, paramView);
    e.c.a(paramView);
  }
  
  public static final class a
    implements FragmentStateReceiver.b
  {
    public void a(Fragment paramFragment1, Fragment paramFragment2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FragmentStateObserver onFragmentSwitched: ");
      Object localObject = null;
      if (paramFragment1 != null) {
        paramFragment1 = m.b(paramFragment1.getClass()).b();
      } else {
        paramFragment1 = null;
      }
      localStringBuilder.append(paramFragment1);
      localStringBuilder.append(" -> ");
      paramFragment1 = (Fragment)localObject;
      if (paramFragment2 != null) {
        paramFragment1 = m.b(paramFragment2.getClass()).b();
      }
      localStringBuilder.append(paramFragment1);
      a.e("FragmentStateReceiver", localStringBuilder.toString());
    }
    
    public void b(Fragment paramFragment)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FragmentStateObserver onFragmentForeground: ");
      if (paramFragment != null) {
        paramFragment = m.b(paramFragment.getClass()).b();
      } else {
        paramFragment = null;
      }
      localStringBuilder.append(paramFragment);
      a.e("FragmentStateReceiver", localStringBuilder.toString());
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Fragment paramFragment1, Fragment paramFragment2);
    
    public abstract void b(Fragment paramFragment);
  }
  
  private static final class c
    implements FragmentManager.OnBackStackChangedListener
  {
    public static final a a = new a(null);
    private final WeakReference<FragmentManager> b;
    
    private c(FragmentManager paramFragmentManager)
    {
      this.b = new WeakReference(paramFragmentManager);
    }
    
    public void onBackStackChanged()
    {
      Object localObject1 = (FragmentManager)this.b.get();
      if (localObject1 != null)
      {
        j.d(localObject1, "mFragmentManager.get() ?: return");
        Object localObject2 = FragmentStateReceiver.e;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onBackStackChanged: fragments number: ");
        ((StringBuilder)localObject3).append(((FragmentManager)localObject1).getFragments().size());
        FragmentStateReceiver.c((FragmentStateReceiver)localObject2, ((StringBuilder)localObject3).toString());
        localObject1 = ((FragmentManager)localObject1).getFragments();
        j.d(localObject1, "fm.fragments");
        localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
        while (((ListIterator)localObject3).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject3).previous();
          localObject2 = (Fragment)localObject1;
          j.d(localObject2, "it");
          int i;
          if (((Fragment)localObject2).getView() != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            break label139;
          }
        }
        localObject1 = null;
        label139:
        localObject3 = (Fragment)localObject1;
        if (localObject3 != null)
        {
          localObject2 = FragmentStateReceiver.e;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onBackStackChanged: ");
          ((StringBuilder)localObject1).append(m.b(localObject3.getClass()).b());
          ((StringBuilder)localObject1).append(" isVisibleActually: ");
          ((StringBuilder)localObject1).append(FragmentStateReceiver.b((FragmentStateReceiver)localObject2, (Fragment)localObject3));
          FragmentStateReceiver.c((FragmentStateReceiver)localObject2, ((StringBuilder)localObject1).toString());
          if (((true ^ j.a(localObject3, (Fragment)FragmentStateReceiver.a((FragmentStateReceiver)localObject2).get()))) && (FragmentStateReceiver.b((FragmentStateReceiver)localObject2, (Fragment)localObject3))) {
            FragmentStateReceiver.f((FragmentStateReceiver)localObject2, (Fragment)localObject3, false, 2, null);
          }
        }
      }
    }
    
    public static final class a
    {
      public final void a(Fragment paramFragment)
      {
        j.e(paramFragment, "fragment");
        paramFragment = paramFragment.getChildFragmentManager();
        j.d(paramFragment, "it");
        paramFragment.addOnBackStackChangedListener(new FragmentStateReceiver.c(paramFragment, null));
      }
      
      public final void b(FragmentActivity paramFragmentActivity)
      {
        j.e(paramFragmentActivity, "activity");
        paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
        j.d(paramFragmentActivity, "it");
        paramFragmentActivity.addOnBackStackChangedListener(new FragmentStateReceiver.c(paramFragmentActivity, null));
      }
    }
  }
  
  private static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public static final a c = new a(null);
    private final WeakReference<Fragment> d;
    private final WeakReference<View> f;
    private final String q;
    private int x;
    
    private d(View paramView, Fragment paramFragment)
    {
      this.d = new WeakReference(paramFragment);
      this.f = new WeakReference(paramView);
      paramFragment = m.b(paramFragment.getClass()).b();
      if (paramFragment == null) {
        paramFragment = "A Fragment";
      }
      this.q = paramFragment;
      this.x = paramView.getVisibility();
    }
    
    private final void a(Fragment paramFragment)
    {
      if (paramFragment != null)
      {
        paramFragment = paramFragment.getChildFragmentManager();
        j.d(paramFragment, "f.childFragmentManager");
        paramFragment = paramFragment.getFragments();
        j.d(paramFragment, "f.childFragmentManager.fragments");
        Iterator localIterator = paramFragment.iterator();
        while (localIterator.hasNext())
        {
          Fragment localFragment = (Fragment)localIterator.next();
          paramFragment = FragmentStateReceiver.e;
          j.d(localFragment, "it");
          if (FragmentStateReceiver.b(paramFragment, localFragment))
          {
            FragmentStateReceiver.f(paramFragment, localFragment, false, 2, null);
            a(localFragment);
          }
        }
      }
    }
    
    public void onGlobalLayout()
    {
      Object localObject = (View)this.f.get();
      if (localObject != null)
      {
        j.d(localObject, "it");
        if (((View)localObject).getVisibility() != this.x)
        {
          int i = ((View)localObject).getVisibility();
          this.x = i;
          if (i == 0)
          {
            FragmentStateReceiver.f(FragmentStateReceiver.e, (Fragment)this.d.get(), false, 2, null);
            a((Fragment)this.d.get());
          }
          if (this.x == 0) {
            localObject = "SHOW";
          } else {
            localObject = "HIDE";
          }
          FragmentStateReceiver localFragmentStateReceiver = FragmentStateReceiver.e;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Fragment State: ");
          localStringBuilder.append(this.q);
          localStringBuilder.append(' ');
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("!!!!!!!!");
          FragmentStateReceiver.c(localFragmentStateReceiver, localStringBuilder.toString());
        }
      }
    }
    
    public static final class a
    {
      public final void a(Fragment paramFragment, View paramView)
      {
        j.e(paramFragment, "f");
        j.e(paramView, "v");
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(new FragmentStateReceiver.d(paramView, paramFragment, null));
      }
    }
  }
  
  private static final class e
    implements ViewPager.OnPageChangeListener
  {
    public static final a c = new a(null);
    private final WeakReference<PagerAdapter> d;
    
    private e(PagerAdapter paramPagerAdapter)
    {
      this.d = new WeakReference(paramPagerAdapter);
    }
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      FragmentStateReceiver localFragmentStateReceiver = FragmentStateReceiver.e;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ViewPager onPageSelected: ");
      ((StringBuilder)localObject).append(paramInt);
      FragmentStateReceiver.c(localFragmentStateReceiver, ((StringBuilder)localObject).toString());
      localObject = (PagerAdapter)this.d.get();
      if ((localObject instanceof FragmentPagerAdapter)) {
        FragmentStateReceiver.f(localFragmentStateReceiver, ((FragmentPagerAdapter)localObject).getItem(paramInt), false, 2, null);
      } else if ((localObject instanceof FragmentStatePagerAdapter)) {
        FragmentStateReceiver.f(localFragmentStateReceiver, ((FragmentStatePagerAdapter)localObject).getItem(paramInt), false, 2, null);
      }
    }
    
    public static final class a
    {
      public final void a(View paramView)
      {
        j.e(paramView, "v");
        if ((paramView instanceof ViewGroup))
        {
          ViewGroup localViewGroup = (ViewGroup)paramView;
          int i = 0;
          int j = localViewGroup.getChildCount();
          while (i < j)
          {
            View localView = localViewGroup.getChildAt(i);
            j.b(localView, "getChildAt(index)");
            if ((localView instanceof ViewPager))
            {
              ViewPager localViewPager = (ViewPager)localView;
              if (((localViewPager.getAdapter() instanceof FragmentPagerAdapter)) || ((localViewPager.getAdapter() instanceof FragmentStatePagerAdapter)))
              {
                paramView = localViewPager.getAdapter();
                if (paramView != null)
                {
                  j.d(paramView, "pagerAdapter");
                  localViewPager.addOnPageChangeListener(new FragmentStateReceiver.e(paramView, null));
                }
              }
            }
            FragmentStateReceiver.e.c.a(localView);
            i++;
          }
        }
      }
    }
  }
  
  static final class f
    implements Runnable
  {
    f(View paramView) {}
    
    public final void run()
    {
      FragmentStateReceiver.e.c.a(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\core\FragmentStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */