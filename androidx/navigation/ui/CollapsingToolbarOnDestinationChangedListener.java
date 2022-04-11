package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class CollapsingToolbarOnDestinationChangedListener
  extends AbstractAppBarOnDestinationChangedListener
{
  private final WeakReference<CollapsingToolbarLayout> mCollapsingToolbarLayoutWeakReference;
  private final WeakReference<Toolbar> mToolbarWeakReference;
  
  CollapsingToolbarOnDestinationChangedListener(@NonNull CollapsingToolbarLayout paramCollapsingToolbarLayout, @NonNull Toolbar paramToolbar, @NonNull AppBarConfiguration paramAppBarConfiguration)
  {
    super(paramCollapsingToolbarLayout.getContext(), paramAppBarConfiguration);
    this.mCollapsingToolbarLayoutWeakReference = new WeakReference(paramCollapsingToolbarLayout);
    this.mToolbarWeakReference = new WeakReference(paramToolbar);
  }
  
  public void onDestinationChanged(@NonNull NavController paramNavController, @NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle)
  {
    CollapsingToolbarLayout localCollapsingToolbarLayout = (CollapsingToolbarLayout)this.mCollapsingToolbarLayoutWeakReference.get();
    Toolbar localToolbar = (Toolbar)this.mToolbarWeakReference.get();
    if ((localCollapsingToolbarLayout != null) && (localToolbar != null))
    {
      super.onDestinationChanged(paramNavController, paramNavDestination, paramBundle);
      return;
    }
    paramNavController.removeOnDestinationChangedListener(this);
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
    CollapsingToolbarLayout localCollapsingToolbarLayout = (CollapsingToolbarLayout)this.mCollapsingToolbarLayoutWeakReference.get();
    if (localCollapsingToolbarLayout != null) {
      localCollapsingToolbarLayout.setTitle(paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\CollapsingToolbarOnDestinationChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */