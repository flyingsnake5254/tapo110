package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hannesdorfmann.mosby3.mvi.d;
import java.util.Objects;
import java.util.UUID;

public class b<V extends com.hannesdorfmann.mosby3.k.b, P extends d<V, ?>>
  implements a
{
  public static boolean a = false;
  private String b = null;
  private f<V, P> c;
  private Activity d;
  private boolean e;
  private P f;
  
  public b(@NonNull Activity paramActivity, @NonNull f<V, P> paramf)
  {
    this(paramActivity, paramf, true);
  }
  
  public b(@NonNull Activity paramActivity, @NonNull f<V, P> paramf, boolean paramBoolean)
  {
    Objects.requireNonNull(paramActivity, "Activity is null");
    Objects.requireNonNull(paramf, "MvpDelegateCallback is null!");
    this.c = paramf;
    this.d = paramActivity;
    this.e = paramBoolean;
  }
  
  private P d()
  {
    Object localObject = this.c.D();
    if (localObject != null)
    {
      if (this.e)
      {
        String str = UUID.randomUUID().toString();
        this.b = str;
        g.g(this.d, str, (com.hannesdorfmann.mosby3.k.a)localObject);
      }
      return (P)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Presenter returned from createPresenter() is null. Activity is ");
    ((StringBuilder)localObject).append(this.d);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  static boolean e(boolean paramBoolean, Activity paramActivity)
  {
    if ((paramBoolean) && ((paramActivity.isChangingConfigurations()) || (!paramActivity.isFinishing()))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public Object a()
  {
    return null;
  }
  
  public void b(Bundle paramBundle) {}
  
  public void c() {}
  
  public void onContentChanged() {}
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    if ((this.e) && (paramBundle != null)) {
      this.b = paramBundle.getString("com.hannesdorfmann.mosby3.activity.mvi.id");
    }
    if (a)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("MosbyView ID = ");
      paramBundle.append(this.b);
      paramBundle.append(" for MvpView: ");
      paramBundle.append(this.c.getMvpView());
      Log.d("ActivityMviDelegateImpl", paramBundle.toString());
    }
  }
  
  public void onDestroy()
  {
    if ((this.f != null) && (!e(this.e, this.d)))
    {
      this.f.destroy();
      Object localObject = this.b;
      if (localObject != null) {
        g.h(this.d, (String)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Destroying Presenter permanently ");
      ((StringBuilder)localObject).append(this.f);
      Log.d("ActivityMviDelegateImpl", ((StringBuilder)localObject).toString());
    }
    this.f = null;
    this.d = null;
    this.c = null;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((this.e) && (paramBundle != null))
    {
      paramBundle.putString("com.hannesdorfmann.mosby3.activity.mvi.id", this.b);
      if (a)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Saving MosbyViewId into Bundle. ViewId: ");
        paramBundle.append(this.b);
        Log.d("ActivityMviDelegateImpl", paramBundle.toString());
      }
    }
  }
  
  public void onStart()
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      this.f = d();
      if (a)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new Presenter instance created: ");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" for ");
        ((StringBuilder)localObject).append(this.c.getMvpView());
        Log.d("ActivityMviDelegateImpl", ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = (d)g.f(this.d, (String)localObject);
      this.f = ((d)localObject);
      if (localObject != null) {
        break label155;
      }
      this.f = d();
      if (a)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: ");
        ((StringBuilder)localObject).append(this.f);
        Log.d("ActivityMviDelegateImpl", ((StringBuilder)localObject).toString());
      }
    }
    int i = 0;
    break label197;
    label155:
    if (a)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Presenter instance reused from internal cache: ");
      ((StringBuilder)localObject).append(this.f);
      Log.d("ActivityMviDelegateImpl", ((StringBuilder)localObject).toString());
    }
    i = 1;
    label197:
    com.hannesdorfmann.mosby3.k.b localb = this.c.getMvpView();
    if (localb != null)
    {
      if (i != 0) {
        this.c.setRestoringViewState(true);
      }
      this.f.a(localb);
      if (i != 0) {
        this.c.setRestoringViewState(false);
      }
      if (a)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MvpView attached to Presenter. MvpView: ");
        ((StringBuilder)localObject).append(localb);
        ((StringBuilder)localObject).append("   Presenter: ");
        ((StringBuilder)localObject).append(this.f);
        Log.d("ActivityMviDelegateImpl", ((StringBuilder)localObject).toString());
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MvpView returned from getMvpView() is null. Returned by ");
    ((StringBuilder)localObject).append(this.d);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  public void onStop()
  {
    this.f.b();
    if (a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detached MvpView from Presenter. MvpView ");
      localStringBuilder.append(this.c.getMvpView());
      localStringBuilder.append("   Presenter: ");
      localStringBuilder.append(this.f);
      Log.d("ActivityMviDelegateImpl", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */