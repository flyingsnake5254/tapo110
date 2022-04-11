package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.BackstackAccessor;
import androidx.fragment.app.Fragment;
import com.hannesdorfmann.mosby3.k.a;
import com.hannesdorfmann.mosby3.k.b;
import java.util.Objects;
import java.util.UUID;

public class e<V extends b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>>
  implements d<V, P>
{
  public static boolean a = false;
  private String b = null;
  private f<V, P> c;
  private Fragment d;
  private boolean e = false;
  private final boolean f;
  private final boolean g;
  private P h;
  private boolean i;
  
  public e(@NonNull f<V, P> paramf, @NonNull Fragment paramFragment)
  {
    this(paramf, paramFragment, true, true);
  }
  
  public e(@NonNull f<V, P> paramf, @NonNull Fragment paramFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    Objects.requireNonNull(paramf, "delegateCallback == null");
    Objects.requireNonNull(paramFragment, "fragment == null");
    if ((!paramBoolean1) && (paramBoolean2)) {
      throw new IllegalArgumentException("It is not possible to keep the presenter on backstack, but NOT keep presenter through screen orientation changes. Keep presenter on backstack also requires keep presenter through screen orientation changes to be enabled");
    }
    this.c = paramf;
    this.d = paramFragment;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
  }
  
  private P g()
  {
    com.hannesdorfmann.mosby3.mvi.d locald = this.c.D();
    if (locald != null)
    {
      if ((this.f) || (this.g))
      {
        localObject = h();
        String str = UUID.randomUUID().toString();
        this.b = str;
        g.g((Activity)localObject, str, locald);
      }
      return locald;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Presenter returned from createPresenter() is null. Fragment is ");
    ((StringBuilder)localObject).append(this.d);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  private Activity h()
  {
    Object localObject = this.d.getActivity();
    if (localObject != null) {
      return (Activity)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Activity returned by Fragment.getActivity() is null. Fragment is ");
    ((StringBuilder)localObject).append(this.d);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  private boolean i(boolean paramBoolean, Activity paramActivity, Fragment paramFragment)
  {
    if (paramActivity.isChangingConfigurations()) {
      return this.f;
    }
    if (paramActivity.isFinishing()) {
      return false;
    }
    if ((paramBoolean) && (BackstackAccessor.isFragmentOnBackStack(paramFragment))) {
      return true;
    }
    return paramFragment.isRemoving() ^ true;
  }
  
  public void a(Activity paramActivity) {}
  
  public void b(Context paramContext) {}
  
  public void c(Fragment paramFragment) {}
  
  public void d() {}
  
  public void e(View paramView, @Nullable Bundle paramBundle)
  {
    this.e = true;
  }
  
  public void f(Bundle paramBundle)
  {
    if (this.e) {
      return;
    }
    throw new IllegalStateException("It seems that onCreateView() has never been called (or has returned null). This means that your fragment is headless (no UI). That is not allowed because it doesn't make sense to use Mosby with a Fragment without View.");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    if (((this.f) || (this.g)) && (paramBundle != null)) {
      this.b = paramBundle.getString("com.hannesdorfmann.mosby3.fragment.mvi.id");
    }
    if (a)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("MosbyView ID = ");
      paramBundle.append(this.b);
      paramBundle.append(" for MvpView: ");
      paramBundle.append(this.c.getMvpView());
      Log.d("FragmentMviDelegateImpl", paramBundle.toString());
    }
    if (this.b == null)
    {
      this.h = g();
      this.i = false;
      if (a)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("new Presenter instance created: ");
        paramBundle.append(this.h);
        Log.d("FragmentMviDelegateImpl", paramBundle.toString());
      }
    }
    else
    {
      paramBundle = (com.hannesdorfmann.mosby3.mvi.d)g.f(h(), this.b);
      this.h = paramBundle;
      if (paramBundle == null)
      {
        this.h = g();
        this.i = false;
        if (a)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: ");
          paramBundle.append(this.h);
          Log.d("FragmentMviDelegateImpl", paramBundle.toString());
        }
      }
      else
      {
        this.i = true;
        if (a)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("Presenter instance reused from internal cache: ");
          paramBundle.append(this.h);
          Log.d("FragmentMviDelegateImpl", paramBundle.toString());
        }
      }
    }
    if (this.h != null) {
      return;
    }
    throw new IllegalStateException("Oops, Presenter is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
  }
  
  public void onDestroy()
  {
    Activity localActivity = h();
    boolean bool = i(this.g, localActivity, this.d);
    Object localObject;
    if (!bool)
    {
      this.h.destroy();
      localObject = this.b;
      if (localObject != null) {
        g.h(localActivity, (String)localObject);
      }
      if (a) {
        Log.d("FragmentMviDelegateImpl", "Presenter destroyed");
      }
    }
    else if (a)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Retaining presenter instance: ");
      ((StringBuilder)localObject).append(Boolean.toString(bool));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.h);
      Log.d("FragmentMviDelegateImpl", ((StringBuilder)localObject).toString());
    }
    this.h = null;
    this.c = null;
    this.d = null;
  }
  
  public void onDestroyView()
  {
    this.e = false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (((this.f) || (this.g)) && (paramBundle != null))
    {
      paramBundle.putString("com.hannesdorfmann.mosby3.fragment.mvi.id", this.b);
      i(this.g, h(), this.d);
      if (a)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Saving MosbyViewId into Bundle. ViewId: ");
        paramBundle.append(this.b);
        Log.d("FragmentMviDelegateImpl", paramBundle.toString());
      }
    }
  }
  
  public void onStart()
  {
    Object localObject = this.c.getMvpView();
    if (localObject != null)
    {
      if (this.h != null)
      {
        if (this.i) {
          this.c.setRestoringViewState(true);
        }
        this.h.a((b)localObject);
        if (this.i) {
          this.c.setRestoringViewState(false);
        }
        if (a)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MvpView attached to Presenter. MvpView: ");
          localStringBuilder.append(localObject);
          localStringBuilder.append("   Presenter: ");
          localStringBuilder.append(this.h);
          Log.d("FragmentMviDelegateImpl", localStringBuilder.toString());
        }
        return;
      }
      throw new IllegalStateException("Oops, Presenter is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MvpView returned from getMvpView() is null. Returned by ");
    ((StringBuilder)localObject).append(this.d);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  public void onStop()
  {
    this.h.b();
    this.i = true;
    if (a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detached MvpView from Presenter. MvpView ");
      localStringBuilder.append(this.c.getMvpView());
      localStringBuilder.append("   Presenter: ");
      localStringBuilder.append(this.h);
      Log.d("FragmentMviDelegateImpl", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */