package com.scwang.smart.refresh.layout.a;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.constant.RefreshState;

public abstract interface e
{
  public abstract e a();
  
  public abstract ValueAnimator b(int paramInt);
  
  public abstract e c(int paramInt, boolean paramBoolean);
  
  @NonNull
  public abstract f d();
  
  public abstract e e(@NonNull a parama, int paramInt);
  
  public abstract e f(@NonNull RefreshState paramRefreshState);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */