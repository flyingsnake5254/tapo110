package com.hannesdorfmann.mosby3.mvi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.hannesdorfmann.mosby3.e;
import com.hannesdorfmann.mosby3.f;
import com.hannesdorfmann.mosby3.k.b;

public abstract class MviFragment<V extends b, P extends d<V, ?>>
  extends Fragment
  implements b, f<V, P>
{
  private boolean c = false;
  protected com.hannesdorfmann.mosby3.d<V, P> d;
  
  @NonNull
  public com.hannesdorfmann.mosby3.d<V, P> A0()
  {
    if (this.d == null) {
      this.d = new e(this, this);
    }
    return this.d;
  }
  
  @NonNull
  public V getMvpView()
  {
    return this;
  }
  
  @CallSuper
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    A0().f(paramBundle);
  }
  
  @CallSuper
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    A0().a(paramActivity);
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    A0().b(paramContext);
  }
  
  @CallSuper
  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    A0().c(paramFragment);
  }
  
  @CallSuper
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    A0().onConfigurationChanged(paramConfiguration);
  }
  
  @CallSuper
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    A0().onCreate(paramBundle);
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    A0().onDestroy();
  }
  
  @CallSuper
  public void onDestroyView()
  {
    super.onDestroyView();
    A0().onDestroyView();
  }
  
  @CallSuper
  public void onDetach()
  {
    super.onDetach();
    A0().d();
  }
  
  @CallSuper
  public void onPause()
  {
    super.onPause();
    A0().onPause();
  }
  
  @CallSuper
  public void onResume()
  {
    super.onResume();
    A0().onResume();
  }
  
  @CallSuper
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    A0().onSaveInstanceState(paramBundle);
  }
  
  @CallSuper
  public void onStart()
  {
    super.onStart();
    A0().onStart();
  }
  
  @CallSuper
  public void onStop()
  {
    super.onStop();
    A0().onStop();
  }
  
  @CallSuper
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    A0().e(paramView, paramBundle);
  }
  
  public void setRestoringViewState(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\mvi\MviFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */