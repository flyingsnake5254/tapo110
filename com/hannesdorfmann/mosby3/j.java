package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;
import com.hannesdorfmann.mosby3.k.a;
import com.hannesdorfmann.mosby3.mvi.d;
import java.util.Objects;
import java.util.UUID;

public class j<V extends com.hannesdorfmann.mosby3.k.b, P extends d<V, ?>>
  implements h<V, P>, Application.ActivityLifecycleCallbacks
{
  public static boolean c = false;
  private i<V, P> d;
  private String f;
  private boolean p0 = false;
  private boolean p1 = false;
  private boolean p2 = false;
  private final boolean q;
  private final boolean x;
  private P y;
  private final Activity z;
  
  public j(@NonNull View paramView, @NonNull i<V, P> parami, boolean paramBoolean)
  {
    Objects.requireNonNull(paramView, "View is null!");
    Objects.requireNonNull(parami, "MvpDelegateCallback is null!");
    this.d = parami;
    this.q = paramBoolean;
    paramBoolean = paramView.isInEditMode();
    this.x = paramBoolean;
    if (!paramBoolean)
    {
      paramView = g.c(parami.getContext());
      this.z = paramView;
      paramView.getApplication().registerActivityLifecycleCallbacks(this);
    }
    else
    {
      this.z = null;
    }
  }
  
  private P a()
  {
    d locald = this.d.D();
    Objects.requireNonNull(locald, "Presenter returned from createPresenter() is null.");
    if (this.q)
    {
      Context localContext = this.d.getContext();
      this.f = UUID.randomUUID().toString();
      g.g(g.c(localContext), this.f, locald);
    }
    return locald;
  }
  
  private void b()
  {
    if (!this.p2)
    {
      this.y.destroy();
      this.p2 = true;
      if (c)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Presenter destroyed: ");
        ((StringBuilder)localObject).append(this.y);
        Log.d("ViewGroupMviDelegateImp", ((StringBuilder)localObject).toString());
      }
      Object localObject = this.f;
      if (localObject != null) {
        g.h(this.z, (String)localObject);
      }
      this.f = null;
    }
  }
  
  private void c()
  {
    if (!this.p1)
    {
      this.y.b();
      this.p1 = true;
      if (c)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("view ");
        localStringBuilder.append(this.d.getMvpView());
        localStringBuilder.append(" detached from Presenter ");
        localStringBuilder.append(this.y);
        Log.d("ViewGroupMviDelegateImp", localStringBuilder.toString());
      }
    }
  }
  
  @NonNull
  private Context d()
  {
    Object localObject = this.d.getContext();
    if (localObject != null) {
      return (Context)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Context returned from ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" is null");
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  private void e(MosbySavedState paramMosbySavedState)
  {
    this.f = paramMosbySavedState.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == this.z)
    {
      paramActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
      this.p0 = true;
      if ((b.e(this.q, paramActivity) ^ true))
      {
        c();
        b();
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onAttachedToWindow()
  {
    if (this.x) {
      return;
    }
    if (this.f == null)
    {
      this.y = a();
      if (c)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new Presenter instance created: ");
        ((StringBuilder)localObject).append(this.y);
        Log.d("ViewGroupMviDelegateImp", ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      d();
      localObject = (d)g.f(this.z, this.f);
      this.y = ((d)localObject);
      if (localObject != null) {
        break label148;
      }
      this.y = a();
      if (c)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: ");
        ((StringBuilder)localObject).append(this.y);
        Log.d("ViewGroupMviDelegateImp", ((StringBuilder)localObject).toString());
      }
    }
    int i = 0;
    break label190;
    label148:
    if (c)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Presenter instance reused from internal cache: ");
      ((StringBuilder)localObject).append(this.y);
      Log.d("ViewGroupMviDelegateImp", ((StringBuilder)localObject).toString());
    }
    i = 1;
    label190:
    com.hannesdorfmann.mosby3.k.b localb = this.d.getMvpView();
    if (localb != null)
    {
      if (i != 0) {
        this.d.setRestoringViewState(true);
      }
      this.y.a(localb);
      if (i != 0) {
        this.d.setRestoringViewState(false);
      }
      if (c)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MvpView attached to Presenter. MvpView: ");
        ((StringBuilder)localObject).append(localb);
        ((StringBuilder)localObject).append("   Presenter: ");
        ((StringBuilder)localObject).append(this.y);
        Log.d("ViewGroupMviDelegateImp", ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MvpView returned from getMvpView() is null. Returned by ");
    ((StringBuilder)localObject).append(this.d);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  public void onDetachedFromWindow()
  {
    if (this.x) {
      return;
    }
    c();
    if (!this.p0) {
      if ((b.e(this.q, this.z) ^ true)) {
        b();
      } else if (!this.z.isFinishing()) {
        b();
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (this.x) {
      return;
    }
    if (!(paramParcelable instanceof MosbySavedState))
    {
      this.d.n0(paramParcelable);
      return;
    }
    paramParcelable = (MosbySavedState)paramParcelable;
    e(paramParcelable);
    this.d.n0(paramParcelable.getSuperState());
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.x) {
      return null;
    }
    Parcelable localParcelable = this.d.r();
    if (this.q) {
      return new MosbySavedState(localParcelable, this.f);
    }
    return localParcelable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */