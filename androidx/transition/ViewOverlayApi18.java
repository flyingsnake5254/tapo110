package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewOverlayApi18
  implements ViewOverlayImpl
{
  private final ViewOverlay mViewOverlay;
  
  ViewOverlayApi18(@NonNull View paramView)
  {
    this.mViewOverlay = paramView.getOverlay();
  }
  
  public void add(@NonNull Drawable paramDrawable)
  {
    this.mViewOverlay.add(paramDrawable);
  }
  
  public void remove(@NonNull Drawable paramDrawable)
  {
    this.mViewOverlay.remove(paramDrawable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewOverlayApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */