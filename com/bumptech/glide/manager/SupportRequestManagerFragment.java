package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SupportRequestManagerFragment
  extends Fragment
{
  private final a c;
  private final q d = new a();
  private final Set<SupportRequestManagerFragment> f = new HashSet();
  @Nullable
  private SupportRequestManagerFragment q;
  @Nullable
  private i x;
  @Nullable
  private Fragment y;
  
  public SupportRequestManagerFragment()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  @VisibleForTesting
  public SupportRequestManagerFragment(@NonNull a parama)
  {
    this.c = parama;
  }
  
  private void A0(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.f.add(paramSupportRequestManagerFragment);
  }
  
  @Nullable
  private Fragment G0()
  {
    Fragment localFragment = getParentFragment();
    if (localFragment == null) {
      localFragment = this.y;
    }
    return localFragment;
  }
  
  @Nullable
  private static FragmentManager J0(@NonNull Fragment paramFragment)
  {
    while (paramFragment.getParentFragment() != null) {
      paramFragment = paramFragment.getParentFragment();
    }
    return paramFragment.getFragmentManager();
  }
  
  private boolean K0(@NonNull Fragment paramFragment)
  {
    Fragment localFragment1 = G0();
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
  
  private void L0(@NonNull Context paramContext, @NonNull FragmentManager paramFragmentManager)
  {
    Q0();
    paramContext = c.c(paramContext).k().s(paramFragmentManager);
    this.q = paramContext;
    if (!equals(paramContext)) {
      this.q.A0(this);
    }
  }
  
  private void N0(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.f.remove(paramSupportRequestManagerFragment);
  }
  
  private void Q0()
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment = this.q;
    if (localSupportRequestManagerFragment != null)
    {
      localSupportRequestManagerFragment.N0(this);
      this.q = null;
    }
  }
  
  @NonNull
  Set<SupportRequestManagerFragment> B0()
  {
    Object localObject = this.q;
    if (localObject == null) {
      return Collections.emptySet();
    }
    if (equals(localObject)) {
      return Collections.unmodifiableSet(this.f);
    }
    HashSet localHashSet = new HashSet();
    localObject = this.q.B0().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SupportRequestManagerFragment localSupportRequestManagerFragment = (SupportRequestManagerFragment)((Iterator)localObject).next();
      if (K0(localSupportRequestManagerFragment.G0())) {
        localHashSet.add(localSupportRequestManagerFragment);
      }
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  @NonNull
  a C0()
  {
    return this.c;
  }
  
  @Nullable
  public i H0()
  {
    return this.x;
  }
  
  @NonNull
  public q I0()
  {
    return this.d;
  }
  
  void O0(@Nullable Fragment paramFragment)
  {
    this.y = paramFragment;
    if ((paramFragment != null) && (paramFragment.getContext() != null))
    {
      FragmentManager localFragmentManager = J0(paramFragment);
      if (localFragmentManager == null) {
        return;
      }
      L0(paramFragment.getContext(), localFragmentManager);
    }
  }
  
  public void P0(@Nullable i parami)
  {
    this.x = parami;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = J0(this);
    if (paramContext == null)
    {
      if (Log.isLoggable("SupportRMFragment", 5)) {
        Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
      }
      return;
    }
    try
    {
      L0(getContext(), paramContext);
    }
    catch (IllegalStateException paramContext)
    {
      if (Log.isLoggable("SupportRMFragment", 5)) {
        Log.w("SupportRMFragment", "Unable to register fragment with root", paramContext);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.c();
    Q0();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.y = null;
    Q0();
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
    localStringBuilder.append(G0());
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
      Object localObject = SupportRequestManagerFragment.this.B0();
      HashSet localHashSet = new HashSet(((Set)localObject).size());
      Iterator localIterator = ((Set)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (SupportRequestManagerFragment)localIterator.next();
        if (((SupportRequestManagerFragment)localObject).H0() != null) {
          localHashSet.add(((SupportRequestManagerFragment)localObject).H0());
        }
      }
      return localHashSet;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("{fragment=");
      localStringBuilder.append(SupportRequestManagerFragment.this);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\SupportRequestManagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */