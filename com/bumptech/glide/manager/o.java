package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Deprecated
public class o
  extends Fragment
{
  private final a c;
  private final q d = new a();
  private final Set<o> f = new HashSet();
  @Nullable
  private i q;
  @Nullable
  private o x;
  @Nullable
  private Fragment y;
  
  public o()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  @VisibleForTesting
  o(@NonNull a parama)
  {
    this.c = parama;
  }
  
  private void a(o paramo)
  {
    this.f.add(paramo);
  }
  
  @TargetApi(17)
  @Nullable
  private Fragment d()
  {
    Fragment localFragment;
    if (Build.VERSION.SDK_INT >= 17) {
      localFragment = getParentFragment();
    } else {
      localFragment = null;
    }
    if (localFragment == null) {
      localFragment = this.y;
    }
    return localFragment;
  }
  
  @TargetApi(17)
  private boolean g(@NonNull Fragment paramFragment)
  {
    Fragment localFragment1 = getParentFragment();
    for (;;)
    {
      Fragment localFragment2 = paramFragment.getParentFragment();
      if (localFragment2 == null) {
        break;
      }
      if (localFragment2.equals(localFragment1)) {
        return true;
      }
      paramFragment = paramFragment.getParentFragment();
    }
    return false;
  }
  
  private void h(@NonNull Activity paramActivity)
  {
    l();
    paramActivity = c.c(paramActivity).k().q(paramActivity);
    this.x = paramActivity;
    if (!equals(paramActivity)) {
      this.x.a(this);
    }
  }
  
  private void i(o paramo)
  {
    this.f.remove(paramo);
  }
  
  private void l()
  {
    o localo = this.x;
    if (localo != null)
    {
      localo.i(this);
      this.x = null;
    }
  }
  
  @TargetApi(17)
  @NonNull
  Set<o> b()
  {
    if (equals(this.x)) {
      return Collections.unmodifiableSet(this.f);
    }
    if ((this.x != null) && (Build.VERSION.SDK_INT >= 17))
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.x.b().iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (g(localo.getParentFragment())) {
          localHashSet.add(localo);
        }
      }
      return Collections.unmodifiableSet(localHashSet);
    }
    return Collections.emptySet();
  }
  
  @NonNull
  a c()
  {
    return this.c;
  }
  
  @Nullable
  public i e()
  {
    return this.q;
  }
  
  @NonNull
  public q f()
  {
    return this.d;
  }
  
  void j(@Nullable Fragment paramFragment)
  {
    this.y = paramFragment;
    if ((paramFragment != null) && (paramFragment.getActivity() != null)) {
      h(paramFragment.getActivity());
    }
  }
  
  public void k(@Nullable i parami)
  {
    this.q = parami;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      h(paramActivity);
    }
    catch (IllegalStateException paramActivity)
    {
      if (Log.isLoggable("RMFragment", 5)) {
        Log.w("RMFragment", "Unable to register fragment with root", paramActivity);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.c();
    l();
  }
  
  public void onDetach()
  {
    super.onDetach();
    l();
  }
  
  public void onStart()
  {
    super.onStart();
    this.c.d();
  }
  
  public void onStop()
  {
    super.onStop();
    this.c.e();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{parent=");
    localStringBuilder.append(d());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private class a
    implements q
  {
    a() {}
    
    @NonNull
    public Set<i> a()
    {
      Object localObject = o.this.b();
      HashSet localHashSet = new HashSet(((Set)localObject).size());
      Iterator localIterator = ((Set)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (o)localIterator.next();
        if (((o)localObject).e() != null) {
          localHashSet.add(((o)localObject).e());
        }
      }
      return localHashSet;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("{fragment=");
      localStringBuilder.append(o.this);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */