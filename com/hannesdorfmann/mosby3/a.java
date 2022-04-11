package com.hannesdorfmann.mosby3;

import android.os.Bundle;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;

public abstract interface a<V extends b, P extends d<V, ?>>
{
  public abstract Object a();
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void c();
  
  public abstract void onContentChanged();
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */