package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class zad
  implements DeferredLifecycleHelper.zaa
{
  zad(DeferredLifecycleHelper paramDeferredLifecycleHelper, FrameLayout paramFrameLayout, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  public final int getState()
  {
    return 2;
  }
  
  public final void zaa(LifecycleDelegate paramLifecycleDelegate)
  {
    this.zarm.removeAllViews();
    this.zarm.addView(DeferredLifecycleHelper.zab(this.zarj).onCreateView(this.zarn, this.val$container, this.zarl));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamic\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */