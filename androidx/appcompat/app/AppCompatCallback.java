package androidx.appcompat.app;

import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;

public abstract interface AppCompatCallback
{
  public abstract void onSupportActionModeFinished(ActionMode paramActionMode);
  
  public abstract void onSupportActionModeStarted(ActionMode paramActionMode);
  
  @Nullable
  public abstract ActionMode onWindowStartingSupportActionMode(ActionMode.Callback paramCallback);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\app\AppCompatCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */