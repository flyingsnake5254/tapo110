package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle.Delegate;
import androidx.appcompat.app.AppCompatActivity;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class ActionBarOnDestinationChangedListener
  extends AbstractAppBarOnDestinationChangedListener
{
  private final AppCompatActivity mActivity;
  
  ActionBarOnDestinationChangedListener(@NonNull AppCompatActivity paramAppCompatActivity, @NonNull AppBarConfiguration paramAppBarConfiguration)
  {
    super(paramAppCompatActivity.getDrawerToggleDelegate().getActionBarThemedContext(), paramAppBarConfiguration);
    this.mActivity = paramAppCompatActivity;
  }
  
  protected void setNavigationIcon(Drawable paramDrawable, @StringRes int paramInt)
  {
    ActionBar localActionBar = this.mActivity.getSupportActionBar();
    if (paramDrawable == null)
    {
      localActionBar.setDisplayHomeAsUpEnabled(false);
    }
    else
    {
      localActionBar.setDisplayHomeAsUpEnabled(true);
      this.mActivity.getDrawerToggleDelegate().setActionBarUpIndicator(paramDrawable, paramInt);
    }
  }
  
  protected void setTitle(CharSequence paramCharSequence)
  {
    this.mActivity.getSupportActionBar().setTitle(paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\ActionBarOnDestinationChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */