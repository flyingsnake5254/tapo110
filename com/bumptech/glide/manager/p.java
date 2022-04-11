package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.c;
import com.bumptech.glide.d.e;
import com.bumptech.glide.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class p
  implements Handler.Callback
{
  private static final b c = new a();
  private volatile com.bumptech.glide.i d;
  @VisibleForTesting
  final Map<android.app.FragmentManager, o> f = new HashMap();
  private final ArrayMap<View, android.app.Fragment> p0 = new ArrayMap();
  private final Bundle p1 = new Bundle();
  private final k p2;
  @VisibleForTesting
  final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> q = new HashMap();
  private final Handler x;
  private final b y;
  private final ArrayMap<View, androidx.fragment.app.Fragment> z = new ArrayMap();
  
  public p(@Nullable b paramb, f paramf)
  {
    if (paramb == null) {
      paramb = c;
    }
    this.y = paramb;
    this.x = new Handler(Looper.getMainLooper(), this);
    this.p2 = b(paramf);
  }
  
  @TargetApi(17)
  private static void a(@NonNull Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())) {
      throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }
  }
  
  private static k b(f paramf)
  {
    if ((com.bumptech.glide.load.resource.bitmap.p.b) && (com.bumptech.glide.load.resource.bitmap.p.a))
    {
      if (paramf.a(d.e.class)) {
        paramf = new i();
      } else {
        paramf = new j();
      }
      return paramf;
    }
    return new g();
  }
  
  @Nullable
  private static Activity c(@NonNull Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return c(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  @Deprecated
  @TargetApi(26)
  private void d(@NonNull android.app.FragmentManager paramFragmentManager, @NonNull ArrayMap<View, android.app.Fragment> paramArrayMap)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramFragmentManager = paramFragmentManager.getFragments().iterator();
      while (paramFragmentManager.hasNext())
      {
        android.app.Fragment localFragment = (android.app.Fragment)paramFragmentManager.next();
        if (localFragment.getView() != null)
        {
          paramArrayMap.put(localFragment.getView(), localFragment);
          d(localFragment.getChildFragmentManager(), paramArrayMap);
        }
      }
    }
    e(paramFragmentManager, paramArrayMap);
  }
  
  @Deprecated
  private void e(@NonNull android.app.FragmentManager paramFragmentManager, @NonNull ArrayMap<View, android.app.Fragment> paramArrayMap)
  {
    for (int i = 0;; i++)
    {
      this.p1.putInt("key", i);
      Object localObject = null;
      try
      {
        android.app.Fragment localFragment = paramFragmentManager.getFragment(this.p1, "key");
        localObject = localFragment;
      }
      catch (Exception localException) {}
      if (localObject == null) {
        return;
      }
      if (((android.app.Fragment)localObject).getView() != null)
      {
        paramArrayMap.put(((android.app.Fragment)localObject).getView(), localObject);
        if (Build.VERSION.SDK_INT >= 17) {
          d(((android.app.Fragment)localObject).getChildFragmentManager(), paramArrayMap);
        }
      }
    }
  }
  
  private static void f(@Nullable Collection<androidx.fragment.app.Fragment> paramCollection, @NonNull Map<View, androidx.fragment.app.Fragment> paramMap)
  {
    if (paramCollection == null) {
      return;
    }
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      paramCollection = (androidx.fragment.app.Fragment)localIterator.next();
      if ((paramCollection != null) && (paramCollection.getView() != null))
      {
        paramMap.put(paramCollection.getView(), paramCollection);
        f(paramCollection.getChildFragmentManager().getFragments(), paramMap);
      }
    }
  }
  
  @Deprecated
  @Nullable
  private android.app.Fragment g(@NonNull View paramView, @NonNull Activity paramActivity)
  {
    this.p0.clear();
    d(paramActivity.getFragmentManager(), this.p0);
    View localView1 = paramActivity.findViewById(16908290);
    View localView2 = null;
    paramActivity = paramView;
    paramView = localView2;
    for (;;)
    {
      localView2 = paramView;
      if (paramActivity.equals(localView1)) {
        break;
      }
      paramView = (android.app.Fragment)this.p0.get(paramActivity);
      if (paramView != null)
      {
        localView2 = paramView;
        break;
      }
      localView2 = paramView;
      if (!(paramActivity.getParent() instanceof View)) {
        break;
      }
      paramActivity = (View)paramActivity.getParent();
    }
    this.p0.clear();
    return localView2;
  }
  
  @Nullable
  private androidx.fragment.app.Fragment h(@NonNull View paramView, @NonNull FragmentActivity paramFragmentActivity)
  {
    this.z.clear();
    f(paramFragmentActivity.getSupportFragmentManager().getFragments(), this.z);
    View localView1 = paramFragmentActivity.findViewById(16908290);
    View localView2 = null;
    paramFragmentActivity = paramView;
    paramView = localView2;
    for (;;)
    {
      localView2 = paramView;
      if (paramFragmentActivity.equals(localView1)) {
        break;
      }
      paramView = (androidx.fragment.app.Fragment)this.z.get(paramFragmentActivity);
      if (paramView != null)
      {
        localView2 = paramView;
        break;
      }
      localView2 = paramView;
      if (!(paramFragmentActivity.getParent() instanceof View)) {
        break;
      }
      paramFragmentActivity = (View)paramFragmentActivity.getParent();
    }
    this.z.clear();
    return localView2;
  }
  
  @Deprecated
  @NonNull
  private com.bumptech.glide.i i(@NonNull Context paramContext, @NonNull android.app.FragmentManager paramFragmentManager, @Nullable android.app.Fragment paramFragment, boolean paramBoolean)
  {
    o localo = r(paramFragmentManager, paramFragment);
    paramFragment = localo.e();
    paramFragmentManager = paramFragment;
    if (paramFragment == null)
    {
      paramFragmentManager = c.c(paramContext);
      paramFragmentManager = this.y.a(paramFragmentManager, localo.c(), localo.f(), paramContext);
      if (paramBoolean) {
        paramFragmentManager.onStart();
      }
      localo.k(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  @NonNull
  private com.bumptech.glide.i p(@NonNull Context paramContext)
  {
    if (this.d == null) {
      try
      {
        if (this.d == null)
        {
          c localc = c.c(paramContext.getApplicationContext());
          b localb = this.y;
          b localb1 = new com/bumptech/glide/manager/b;
          localb1.<init>();
          h localh = new com/bumptech/glide/manager/h;
          localh.<init>();
          this.d = localb.a(localc, localb1, localh, paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return this.d;
  }
  
  @NonNull
  private o r(@NonNull android.app.FragmentManager paramFragmentManager, @Nullable android.app.Fragment paramFragment)
  {
    o localo1 = (o)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    o localo2 = localo1;
    if (localo1 == null)
    {
      localo1 = (o)this.f.get(paramFragmentManager);
      localo2 = localo1;
      if (localo1 == null)
      {
        localo2 = new o();
        localo2.j(paramFragment);
        this.f.put(paramFragmentManager, localo2);
        paramFragmentManager.beginTransaction().add(localo2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.x.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    return localo2;
  }
  
  @NonNull
  private SupportRequestManagerFragment t(@NonNull androidx.fragment.app.FragmentManager paramFragmentManager, @Nullable androidx.fragment.app.Fragment paramFragment)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment1 = (SupportRequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    SupportRequestManagerFragment localSupportRequestManagerFragment2 = localSupportRequestManagerFragment1;
    if (localSupportRequestManagerFragment1 == null)
    {
      localSupportRequestManagerFragment1 = (SupportRequestManagerFragment)this.q.get(paramFragmentManager);
      localSupportRequestManagerFragment2 = localSupportRequestManagerFragment1;
      if (localSupportRequestManagerFragment1 == null)
      {
        localSupportRequestManagerFragment2 = new SupportRequestManagerFragment();
        localSupportRequestManagerFragment2.O0(paramFragment);
        this.q.put(paramFragmentManager, localSupportRequestManagerFragment2);
        paramFragmentManager.beginTransaction().add(localSupportRequestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.x.obtainMessage(2, paramFragmentManager).sendToTarget();
      }
    }
    return localSupportRequestManagerFragment2;
  }
  
  private static boolean u(Context paramContext)
  {
    paramContext = c(paramContext);
    boolean bool;
    if ((paramContext != null) && (paramContext.isFinishing())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @NonNull
  private com.bumptech.glide.i v(@NonNull Context paramContext, @NonNull androidx.fragment.app.FragmentManager paramFragmentManager, @Nullable androidx.fragment.app.Fragment paramFragment, boolean paramBoolean)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment = t(paramFragmentManager, paramFragment);
    paramFragment = localSupportRequestManagerFragment.H0();
    paramFragmentManager = paramFragment;
    if (paramFragment == null)
    {
      paramFragmentManager = c.c(paramContext);
      paramFragmentManager = this.y.a(paramFragmentManager, localSupportRequestManagerFragment.C0(), localSupportRequestManagerFragment.I0(), paramContext);
      if (paramBoolean) {
        paramFragmentManager.onStart();
      }
      localSupportRequestManagerFragment.P0(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject = null;
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        bool = false;
        paramMessage = null;
      }
      else
      {
        paramMessage = (androidx.fragment.app.FragmentManager)paramMessage.obj;
        localObject = this.q.remove(paramMessage);
      }
    }
    else
    {
      paramMessage = (android.app.FragmentManager)paramMessage.obj;
      localObject = this.f.remove(paramMessage);
    }
    if ((bool) && (localObject == null) && (Log.isLoggable("RMRetriever", 5)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to remove expected request manager fragment, manager: ");
      ((StringBuilder)localObject).append(paramMessage);
      Log.w("RMRetriever", ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  @NonNull
  public com.bumptech.glide.i j(@NonNull Activity paramActivity)
  {
    if (com.bumptech.glide.util.j.r()) {
      return l(paramActivity.getApplicationContext());
    }
    if ((paramActivity instanceof FragmentActivity)) {
      return o((FragmentActivity)paramActivity);
    }
    a(paramActivity);
    this.p2.a(paramActivity);
    return i(paramActivity, paramActivity.getFragmentManager(), null, u(paramActivity));
  }
  
  @Deprecated
  @TargetApi(17)
  @NonNull
  public com.bumptech.glide.i k(@NonNull android.app.Fragment paramFragment)
  {
    if (paramFragment.getActivity() != null)
    {
      if ((!com.bumptech.glide.util.j.r()) && (Build.VERSION.SDK_INT >= 17))
      {
        if (paramFragment.getActivity() != null) {
          this.p2.a(paramFragment.getActivity());
        }
        android.app.FragmentManager localFragmentManager = paramFragment.getChildFragmentManager();
        return i(paramFragment.getActivity(), localFragmentManager, paramFragment, paramFragment.isVisible());
      }
      return l(paramFragment.getActivity().getApplicationContext());
    }
    throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
  }
  
  @NonNull
  public com.bumptech.glide.i l(@NonNull Context paramContext)
  {
    if (paramContext != null)
    {
      if ((com.bumptech.glide.util.j.s()) && (!(paramContext instanceof Application)))
      {
        if ((paramContext instanceof FragmentActivity)) {
          return o((FragmentActivity)paramContext);
        }
        if ((paramContext instanceof Activity)) {
          return j((Activity)paramContext);
        }
        if ((paramContext instanceof ContextWrapper))
        {
          ContextWrapper localContextWrapper = (ContextWrapper)paramContext;
          if (localContextWrapper.getBaseContext().getApplicationContext() != null) {
            return l(localContextWrapper.getBaseContext());
          }
        }
      }
      return p(paramContext);
    }
    throw new IllegalArgumentException("You cannot start a load on a null Context");
  }
  
  @NonNull
  public com.bumptech.glide.i m(@NonNull View paramView)
  {
    if (com.bumptech.glide.util.j.r()) {
      return l(paramView.getContext().getApplicationContext());
    }
    com.bumptech.glide.util.i.d(paramView);
    com.bumptech.glide.util.i.e(paramView.getContext(), "Unable to obtain a request manager for a view without a Context");
    Object localObject = c(paramView.getContext());
    if (localObject == null) {
      return l(paramView.getContext().getApplicationContext());
    }
    if ((localObject instanceof FragmentActivity))
    {
      localObject = (FragmentActivity)localObject;
      paramView = h(paramView, (FragmentActivity)localObject);
      if (paramView != null) {
        paramView = n(paramView);
      } else {
        paramView = o((FragmentActivity)localObject);
      }
      return paramView;
    }
    paramView = g(paramView, (Activity)localObject);
    if (paramView == null) {
      return j((Activity)localObject);
    }
    return k(paramView);
  }
  
  @NonNull
  public com.bumptech.glide.i n(@NonNull androidx.fragment.app.Fragment paramFragment)
  {
    com.bumptech.glide.util.i.e(paramFragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
    if (com.bumptech.glide.util.j.r()) {
      return l(paramFragment.getContext().getApplicationContext());
    }
    if (paramFragment.getActivity() != null) {
      this.p2.a(paramFragment.getActivity());
    }
    androidx.fragment.app.FragmentManager localFragmentManager = paramFragment.getChildFragmentManager();
    return v(paramFragment.getContext(), localFragmentManager, paramFragment, paramFragment.isVisible());
  }
  
  @NonNull
  public com.bumptech.glide.i o(@NonNull FragmentActivity paramFragmentActivity)
  {
    if (com.bumptech.glide.util.j.r()) {
      return l(paramFragmentActivity.getApplicationContext());
    }
    a(paramFragmentActivity);
    this.p2.a(paramFragmentActivity);
    return v(paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager(), null, u(paramFragmentActivity));
  }
  
  @Deprecated
  @NonNull
  o q(Activity paramActivity)
  {
    return r(paramActivity.getFragmentManager(), null);
  }
  
  @NonNull
  SupportRequestManagerFragment s(androidx.fragment.app.FragmentManager paramFragmentManager)
  {
    return t(paramFragmentManager, null);
  }
  
  class a
    implements p.b
  {
    @NonNull
    public com.bumptech.glide.i a(@NonNull c paramc, @NonNull l paraml, @NonNull q paramq, @NonNull Context paramContext)
    {
      return new com.bumptech.glide.i(paramc, paraml, paramq, paramContext);
    }
  }
  
  public static abstract interface b
  {
    @NonNull
    public abstract com.bumptech.glide.i a(@NonNull c paramc, @NonNull l paraml, @NonNull q paramq, @NonNull Context paramContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */