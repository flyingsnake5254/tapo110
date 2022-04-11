package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavController.OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
abstract class AbstractAppBarOnDestinationChangedListener
  implements NavController.OnDestinationChangedListener
{
  private ValueAnimator mAnimator;
  private DrawerArrowDrawable mArrowDrawable;
  private final Context mContext;
  @Nullable
  private final WeakReference<Openable> mOpenableLayoutWeakReference;
  private final Set<Integer> mTopLevelDestinations;
  
  AbstractAppBarOnDestinationChangedListener(@NonNull Context paramContext, @NonNull AppBarConfiguration paramAppBarConfiguration)
  {
    this.mContext = paramContext;
    this.mTopLevelDestinations = paramAppBarConfiguration.getTopLevelDestinations();
    paramContext = paramAppBarConfiguration.getOpenableLayout();
    if (paramContext != null) {
      this.mOpenableLayoutWeakReference = new WeakReference(paramContext);
    } else {
      this.mOpenableLayoutWeakReference = null;
    }
  }
  
  private void setActionBarUpIndicator(boolean paramBoolean)
  {
    int i;
    if (this.mArrowDrawable == null)
    {
      this.mArrowDrawable = new DrawerArrowDrawable(this.mContext);
      i = 0;
    }
    else
    {
      i = 1;
    }
    Object localObject = this.mArrowDrawable;
    int j;
    if (paramBoolean) {
      j = R.string.nav_app_bar_open_drawer_description;
    } else {
      j = R.string.nav_app_bar_navigate_up_description;
    }
    setNavigationIcon((Drawable)localObject, j);
    float f1;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    if (i != 0)
    {
      float f2 = this.mArrowDrawable.getProgress();
      localObject = this.mAnimator;
      if (localObject != null) {
        ((ValueAnimator)localObject).cancel();
      }
      localObject = ObjectAnimator.ofFloat(this.mArrowDrawable, "progress", new float[] { f2, f1 });
      this.mAnimator = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).start();
    }
    else
    {
      this.mArrowDrawable.setProgress(f1);
    }
  }
  
  public void onDestinationChanged(@NonNull NavController paramNavController, @NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle)
  {
    if ((paramNavDestination instanceof FloatingWindow)) {
      return;
    }
    Object localObject = this.mOpenableLayoutWeakReference;
    if (localObject != null) {
      localObject = (Openable)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((this.mOpenableLayoutWeakReference != null) && (localObject == null))
    {
      paramNavController.removeOnDestinationChangedListener(this);
      return;
    }
    paramNavController = paramNavDestination.getLabel();
    boolean bool1 = true;
    if (paramNavController != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Matcher localMatcher = Pattern.compile("\\{(.+?)\\}").matcher(paramNavController);
      while (localMatcher.find())
      {
        String str = localMatcher.group(1);
        if ((paramBundle != null) && (paramBundle.containsKey(str)))
        {
          localMatcher.appendReplacement(localStringBuffer, "");
          localStringBuffer.append(paramBundle.get(str).toString());
        }
        else
        {
          paramNavDestination = new StringBuilder();
          paramNavDestination.append("Could not find ");
          paramNavDestination.append(str);
          paramNavDestination.append(" in ");
          paramNavDestination.append(paramBundle);
          paramNavDestination.append(" to fill label ");
          paramNavDestination.append(paramNavController);
          throw new IllegalArgumentException(paramNavDestination.toString());
        }
      }
      localMatcher.appendTail(localStringBuffer);
      setTitle(localStringBuffer);
    }
    boolean bool2 = NavigationUI.matchDestinations(paramNavDestination, this.mTopLevelDestinations);
    if ((localObject == null) && (bool2))
    {
      setNavigationIcon(null, 0);
    }
    else
    {
      if ((localObject == null) || (!bool2)) {
        bool1 = false;
      }
      setActionBarUpIndicator(bool1);
    }
  }
  
  protected abstract void setNavigationIcon(Drawable paramDrawable, @StringRes int paramInt);
  
  protected abstract void setTitle(CharSequence paramCharSequence);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\AbstractAppBarOnDestinationChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */