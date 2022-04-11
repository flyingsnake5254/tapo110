package androidx.viewpager2.adapter;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public abstract interface StatefulAdapter
{
  public abstract void restoreState(@NonNull Parcelable paramParcelable);
  
  @NonNull
  public abstract Parcelable saveState();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\viewpager2\adapter\StatefulAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */