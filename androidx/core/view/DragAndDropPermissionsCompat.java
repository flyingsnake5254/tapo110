package androidx.core.view;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public final class DragAndDropPermissionsCompat
{
  private Object mDragAndDropPermissions;
  
  private DragAndDropPermissionsCompat(Object paramObject)
  {
    this.mDragAndDropPermissions = paramObject;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static DragAndDropPermissionsCompat request(Activity paramActivity, DragEvent paramDragEvent)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramActivity = paramActivity.requestDragAndDropPermissions(paramDragEvent);
      if (paramActivity != null) {
        return new DragAndDropPermissionsCompat(paramActivity);
      }
    }
    return null;
  }
  
  public void release()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      ((DragAndDropPermissions)this.mDragAndDropPermissions).release();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\DragAndDropPermissionsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */