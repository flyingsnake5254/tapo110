package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import java.lang.ref.WeakReference;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class ToolbarOnDestinationChangedListener
  extends AbstractAppBarOnDestinationChangedListener
{
  private final WeakReference<Toolbar> mToolbarWeakReference;
  
  ToolbarOnDestinationChangedListener(@NonNull Toolbar paramToolbar, @NonNull AppBarConfiguration paramAppBarConfiguration)
  {
    super(paramToolbar.getContext(), paramAppBarConfiguration);
    this.mToolbarWeakReference = new WeakReference(paramToolbar);
  }
  
  public void onDestinationChanged(@NonNull NavController paramNavController, @NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle)
  {
    if ((Toolbar)this.mToolbarWeakReference.get() == null)
    {
      paramNavController.removeOnDestinationChangedListener(this);
      return;
    }
    super.onDestinationChanged(paramNavController, paramNavDestination, paramBundle);
  }
  
  protected void setNavigationIcon(Drawable paramDrawable, @StringRes int paramInt)
  {
    Toolbar localToolbar = (Toolbar)this.mToolbarWeakReference.get();
    if (localToolbar != null)
    {
      int i;
      if ((paramDrawable == null) && (localToolbar.getNavigationIcon() != null)) {
        i = 1;
      } else {
        i = 0;
      }
      localToolbar.setNavigationIcon(paramDrawable);
      localToolbar.setNavigationContentDescription(paramInt);
      if (i != 0) {
        TransitionManager.beginDelayedTransition(localToolbar);
      }
    }
  }
  
  protected void setTitle(CharSequence paramCharSequence)
  {
    ((Toolbar)this.mToolbarWeakReference.get()).setTitle(paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\ToolbarOnDestinationChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */