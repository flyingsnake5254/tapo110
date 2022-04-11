package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class WindowIdApi18
  implements WindowIdImpl
{
  private final WindowId mWindowId;
  
  WindowIdApi18(@NonNull View paramView)
  {
    this.mWindowId = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof WindowIdApi18)) && (((WindowIdApi18)paramObject).mWindowId.equals(this.mWindowId))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.mWindowId.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\WindowIdApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */