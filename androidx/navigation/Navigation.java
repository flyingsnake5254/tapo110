package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;

public final class Navigation
{
  @NonNull
  public static View.OnClickListener createNavigateOnClickListener(@IdRes int paramInt)
  {
    return createNavigateOnClickListener(paramInt, null);
  }
  
  @NonNull
  public static View.OnClickListener createNavigateOnClickListener(@IdRes int paramInt, @Nullable final Bundle paramBundle)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Navigation.findNavController(paramAnonymousView).navigate(this.val$resId, paramBundle);
      }
    };
  }
  
  @NonNull
  public static View.OnClickListener createNavigateOnClickListener(@NonNull NavDirections paramNavDirections)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Navigation.findNavController(paramAnonymousView).navigate(Navigation.this);
      }
    };
  }
  
  @NonNull
  public static NavController findNavController(@NonNull Activity paramActivity, @IdRes int paramInt)
  {
    Object localObject = findViewNavController(ActivityCompat.requireViewById(paramActivity, paramInt));
    if (localObject != null) {
      return (NavController)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Activity ");
    ((StringBuilder)localObject).append(paramActivity);
    ((StringBuilder)localObject).append(" does not have a NavController set on ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  public static NavController findNavController(@NonNull View paramView)
  {
    Object localObject = findViewNavController(paramView);
    if (localObject != null) {
      return (NavController)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" does not have a NavController set");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @Nullable
  private static NavController findViewNavController(@NonNull View paramView)
  {
    while (paramView != null)
    {
      NavController localNavController = getViewNavController(paramView);
      if (localNavController != null) {
        return localNavController;
      }
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        paramView = (View)paramView;
      } else {
        paramView = null;
      }
    }
    return null;
  }
  
  @Nullable
  private static NavController getViewNavController(@NonNull View paramView)
  {
    paramView = paramView.getTag(R.id.nav_controller_view_tag);
    if ((paramView instanceof WeakReference)) {
      paramView = (NavController)((WeakReference)paramView).get();
    } else if ((paramView instanceof NavController)) {
      paramView = (NavController)paramView;
    } else {
      paramView = null;
    }
    return paramView;
  }
  
  public static void setViewNavController(@NonNull View paramView, @Nullable NavController paramNavController)
  {
    paramView.setTag(R.id.nav_controller_view_tag, paramNavController);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\Navigation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */