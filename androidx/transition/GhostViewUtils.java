package androidx.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class GhostViewUtils
{
  @Nullable
  static GhostView addGhost(@NonNull View paramView, @NonNull ViewGroup paramViewGroup, @Nullable Matrix paramMatrix)
  {
    if (Build.VERSION.SDK_INT == 28) {
      return GhostViewPlatform.addGhost(paramView, paramViewGroup, paramMatrix);
    }
    return GhostViewPort.addGhost(paramView, paramViewGroup, paramMatrix);
  }
  
  static void removeGhost(View paramView)
  {
    if (Build.VERSION.SDK_INT == 28) {
      GhostViewPlatform.removeGhost(paramView);
    } else {
      GhostViewPort.removeGhost(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\GhostViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */