package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import java.util.LinkedList;

@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate>
{
  private T zarf;
  private Bundle zarg;
  private LinkedList<zaa> zarh;
  private final OnDelegateCreatedListener<T> zari = new zaa(this);
  
  @KeepForSdk
  public static void showGooglePlayUnavailableMessage(FrameLayout paramFrameLayout)
  {
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    Context localContext = paramFrameLayout.getContext();
    int i = localGoogleApiAvailability.isGooglePlayServicesAvailable(localContext);
    Object localObject = ConnectionErrorMessages.getErrorMessage(localContext, i);
    String str = ConnectionErrorMessages.getErrorDialogButtonMessage(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText((CharSequence)localObject);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = localGoogleApiAvailability.getErrorResolutionIntent(localContext, i, null);
    if (paramFrameLayout != null)
    {
      localObject = new Button(localContext);
      ((Button)localObject).setId(16908313);
      ((Button)localObject).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      ((Button)localObject).setText(str);
      localLinearLayout.addView((View)localObject);
      ((Button)localObject).setOnClickListener(new zae(localContext, paramFrameLayout));
    }
  }
  
  private final void zaa(Bundle paramBundle, zaa paramzaa)
  {
    LifecycleDelegate localLifecycleDelegate = this.zarf;
    if (localLifecycleDelegate != null)
    {
      paramzaa.zaa(localLifecycleDelegate);
      return;
    }
    if (this.zarh == null) {
      this.zarh = new LinkedList();
    }
    this.zarh.add(paramzaa);
    if (paramBundle != null)
    {
      paramzaa = this.zarg;
      if (paramzaa == null) {
        this.zarg = ((Bundle)paramBundle.clone());
      } else {
        paramzaa.putAll(paramBundle);
      }
    }
    createDelegate(this.zari);
  }
  
  private final void zal(int paramInt)
  {
    while ((!this.zarh.isEmpty()) && (((zaa)this.zarh.getLast()).getState() >= paramInt)) {
      this.zarh.removeLast();
    }
  }
  
  @KeepForSdk
  protected abstract void createDelegate(OnDelegateCreatedListener<T> paramOnDelegateCreatedListener);
  
  @KeepForSdk
  public T getDelegate()
  {
    return this.zarf;
  }
  
  @KeepForSdk
  protected void handleGooglePlayUnavailable(FrameLayout paramFrameLayout)
  {
    showGooglePlayUnavailableMessage(paramFrameLayout);
  }
  
  @KeepForSdk
  public void onCreate(Bundle paramBundle)
  {
    zaa(paramBundle, new zac(this, paramBundle));
  }
  
  @KeepForSdk
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zaa(paramBundle, new zad(this, localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (this.zarf == null) {
      handleGooglePlayUnavailable(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  @KeepForSdk
  public void onDestroy()
  {
    LifecycleDelegate localLifecycleDelegate = this.zarf;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onDestroy();
      return;
    }
    zal(1);
  }
  
  @KeepForSdk
  public void onDestroyView()
  {
    LifecycleDelegate localLifecycleDelegate = this.zarf;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onDestroyView();
      return;
    }
    zal(2);
  }
  
  @KeepForSdk
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    zaa(paramBundle2, new zab(this, paramActivity, paramBundle1, paramBundle2));
  }
  
  @KeepForSdk
  public void onLowMemory()
  {
    LifecycleDelegate localLifecycleDelegate = this.zarf;
    if (localLifecycleDelegate != null) {
      localLifecycleDelegate.onLowMemory();
    }
  }
  
  @KeepForSdk
  public void onPause()
  {
    LifecycleDelegate localLifecycleDelegate = this.zarf;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onPause();
      return;
    }
    zal(5);
  }
  
  @KeepForSdk
  public void onResume()
  {
    zaa(null, new zag(this));
  }
  
  @KeepForSdk
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Object localObject = this.zarf;
    if (localObject != null)
    {
      ((LifecycleDelegate)localObject).onSaveInstanceState(paramBundle);
      return;
    }
    localObject = this.zarg;
    if (localObject != null) {
      paramBundle.putAll((Bundle)localObject);
    }
  }
  
  @KeepForSdk
  public void onStart()
  {
    zaa(null, new zaf(this));
  }
  
  @KeepForSdk
  public void onStop()
  {
    LifecycleDelegate localLifecycleDelegate = this.zarf;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onStop();
      return;
    }
    zal(4);
  }
  
  private static abstract interface zaa
  {
    public abstract int getState();
    
    public abstract void zaa(LifecycleDelegate paramLifecycleDelegate);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamic\DeferredLifecycleHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */