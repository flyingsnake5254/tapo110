package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewGroupOverlayApi18
  implements ViewGroupOverlayImpl
{
  private final ViewGroupOverlay viewGroupOverlay;
  
  ViewGroupOverlayApi18(@NonNull ViewGroup paramViewGroup)
  {
    this.viewGroupOverlay = paramViewGroup.getOverlay();
  }
  
  public void add(@NonNull Drawable paramDrawable)
  {
    this.viewGroupOverlay.add(paramDrawable);
  }
  
  public void add(@NonNull View paramView)
  {
    this.viewGroupOverlay.add(paramView);
  }
  
  public void remove(@NonNull Drawable paramDrawable)
  {
    this.viewGroupOverlay.remove(paramDrawable);
  }
  
  public void remove(@NonNull View paramView)
  {
    this.viewGroupOverlay.remove(paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ViewGroupOverlayApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */