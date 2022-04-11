package com.hannesdorfmann.mosby3.mvi;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.hannesdorfmann.mosby3.a;
import com.hannesdorfmann.mosby3.f;

public abstract class MviActivity<V extends com.hannesdorfmann.mosby3.k.b, P extends d<V, ?>>
  extends AppCompatActivity
  implements com.hannesdorfmann.mosby3.k.b, f<V, P>
{
  private boolean c = false;
  protected a<V, P> d;
  
  @NonNull
  protected a<V, P> P0()
  {
    if (this.d == null) {
      this.d = new com.hannesdorfmann.mosby3.b(this, this);
    }
    return this.d;
  }
  
  @NonNull
  public V getMvpView()
  {
    return this;
  }
  
  public void onContentChanged()
  {
    super.onContentChanged();
    P0().onContentChanged();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    P0().onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    P0().onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    P0().onPause();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    P0().b(paramBundle);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    P0().c();
  }
  
  protected void onResume()
  {
    super.onResume();
    P0().onResume();
  }
  
  public final Object onRetainCustomNonConfigurationInstance()
  {
    return P0().a();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    P0().onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    P0().onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    P0().onStop();
  }
  
  public void setRestoringViewState(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\mvi\MviActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */