package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;

abstract interface ViewGroupOverlayImpl
  extends ViewOverlayImpl
{
  public abstract void add(@NonNull View paramView);
  
  public abstract void remove(@NonNull View paramView);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewGroupOverlayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */