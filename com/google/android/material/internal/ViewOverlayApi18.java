package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewOverlayApi18
  implements ViewOverlayImpl
{
  private final ViewOverlay viewOverlay;
  
  ViewOverlayApi18(@NonNull View paramView)
  {
    this.viewOverlay = paramView.getOverlay();
  }
  
  public void add(@NonNull Drawable paramDrawable)
  {
    this.viewOverlay.add(paramDrawable);
  }
  
  public void remove(@NonNull Drawable paramDrawable)
  {
    this.viewOverlay.remove(paramDrawable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ViewOverlayApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */