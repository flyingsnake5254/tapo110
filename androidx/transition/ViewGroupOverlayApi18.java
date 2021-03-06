package androidx.transition;

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
  private final ViewGroupOverlay mViewGroupOverlay;
  
  ViewGroupOverlayApi18(@NonNull ViewGroup paramViewGroup)
  {
    this.mViewGroupOverlay = paramViewGroup.getOverlay();
  }
  
  public void add(@NonNull Drawable paramDrawable)
  {
    this.mViewGroupOverlay.add(paramDrawable);
  }
  
  public void add(@NonNull View paramView)
  {
    this.mViewGroupOverlay.add(paramView);
  }
  
  public void remove(@NonNull Drawable paramDrawable)
  {
    this.mViewGroupOverlay.remove(paramDrawable);
  }
  
  public void remove(@NonNull View paramView)
  {
    this.mViewGroupOverlay.remove(paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewGroupOverlayApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */