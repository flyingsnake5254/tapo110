package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int DEF_STYLE_RES = R.style.Widget_Design_NavigationView;
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
  OnNavigationItemSelectedListener listener;
  private final int maxWidth;
  @NonNull
  private final NavigationMenu menu;
  private MenuInflater menuInflater;
  private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
  private final NavigationMenuPresenter presenter;
  private final int[] tmpLocation;
  
  public NavigationView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, com.google.android.material.R.attr.navigationViewStyle);
  }
  
  public NavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    NavigationMenuPresenter localNavigationMenuPresenter = new NavigationMenuPresenter();
    this.presenter = localNavigationMenuPresenter;
    this.tmpLocation = new int[2];
    Context localContext = getContext();
    NavigationMenu localNavigationMenu = new NavigationMenu(localContext);
    this.menu = localNavigationMenu;
    TintTypedArray localTintTypedArray = ThemeEnforcement.obtainTintedStyledAttributes(localContext, paramAttributeSet, R.styleable.NavigationView, paramInt, i, new int[0]);
    paramInt = R.styleable.NavigationView_android_background;
    if (localTintTypedArray.hasValue(paramInt)) {
      ViewCompat.setBackground(this, localTintTypedArray.getDrawable(paramInt));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable)))
    {
      paramAttributeSet = getBackground();
      paramContext = new MaterialShapeDrawable();
      if ((paramAttributeSet instanceof ColorDrawable)) {
        paramContext.setFillColor(ColorStateList.valueOf(((ColorDrawable)paramAttributeSet).getColor()));
      }
      paramContext.initializeElevationOverlay(localContext);
      ViewCompat.setBackground(this, paramContext);
    }
    paramInt = R.styleable.NavigationView_elevation;
    if (localTintTypedArray.hasValue(paramInt)) {
      setElevation(localTintTypedArray.getDimensionPixelSize(paramInt, 0));
    }
    setFitsSystemWindows(localTintTypedArray.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
    this.maxWidth = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
    paramInt = R.styleable.NavigationView_itemIconTint;
    if (localTintTypedArray.hasValue(paramInt)) {
      paramAttributeSet = localTintTypedArray.getColorStateList(paramInt);
    } else {
      paramAttributeSet = createDefaultColorStateList(16842808);
    }
    paramInt = R.styleable.NavigationView_itemTextAppearance;
    if (localTintTypedArray.hasValue(paramInt))
    {
      paramInt = localTintTypedArray.getResourceId(paramInt, 0);
      i = 1;
    }
    else
    {
      paramInt = 0;
      i = 0;
    }
    int j = R.styleable.NavigationView_itemIconSize;
    if (localTintTypedArray.hasValue(j)) {
      setItemIconSize(localTintTypedArray.getDimensionPixelSize(j, 0));
    }
    paramContext = null;
    j = R.styleable.NavigationView_itemTextColor;
    if (localTintTypedArray.hasValue(j)) {
      paramContext = localTintTypedArray.getColorStateList(j);
    }
    Object localObject = paramContext;
    if (i == 0)
    {
      localObject = paramContext;
      if (paramContext == null) {
        localObject = createDefaultColorStateList(16842806);
      }
    }
    Drawable localDrawable = localTintTypedArray.getDrawable(R.styleable.NavigationView_itemBackground);
    paramContext = localDrawable;
    if (localDrawable == null)
    {
      paramContext = localDrawable;
      if (hasShapeAppearance(localTintTypedArray)) {
        paramContext = createDefaultItemBackground(localTintTypedArray);
      }
    }
    j = R.styleable.NavigationView_itemHorizontalPadding;
    if (localTintTypedArray.hasValue(j)) {
      localNavigationMenuPresenter.setItemHorizontalPadding(localTintTypedArray.getDimensionPixelSize(j, 0));
    }
    j = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemIconPadding, 0);
    setItemMaxLines(localTintTypedArray.getInt(R.styleable.NavigationView_itemMaxLines, 1));
    localNavigationMenu.setCallback(new MenuBuilder.Callback()
    {
      public boolean onMenuItemSelected(MenuBuilder paramAnonymousMenuBuilder, MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuBuilder = NavigationView.this.listener;
        boolean bool;
        if ((paramAnonymousMenuBuilder != null) && (paramAnonymousMenuBuilder.onNavigationItemSelected(paramAnonymousMenuItem))) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public void onMenuModeChange(MenuBuilder paramAnonymousMenuBuilder) {}
    });
    localNavigationMenuPresenter.setId(1);
    localNavigationMenuPresenter.initForMenu(localContext, localNavigationMenu);
    localNavigationMenuPresenter.setItemIconTintList(paramAttributeSet);
    localNavigationMenuPresenter.setOverScrollMode(getOverScrollMode());
    if (i != 0) {
      localNavigationMenuPresenter.setItemTextAppearance(paramInt);
    }
    localNavigationMenuPresenter.setItemTextColor((ColorStateList)localObject);
    localNavigationMenuPresenter.setItemBackground(paramContext);
    localNavigationMenuPresenter.setItemIconPadding(j);
    localNavigationMenu.addMenuPresenter(localNavigationMenuPresenter);
    addView((View)localNavigationMenuPresenter.getMenuView(this));
    paramInt = R.styleable.NavigationView_menu;
    if (localTintTypedArray.hasValue(paramInt)) {
      inflateMenu(localTintTypedArray.getResourceId(paramInt, 0));
    }
    paramInt = R.styleable.NavigationView_headerLayout;
    if (localTintTypedArray.hasValue(paramInt)) {
      inflateHeaderView(localTintTypedArray.getResourceId(paramInt, 0));
    }
    localTintTypedArray.recycle();
    setupInsetScrimsListener();
  }
  
  @Nullable
  private ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    int[] arrayOfInt1 = DISABLED_STATE_SET;
    localObject = CHECKED_STATE_SET;
    int[] arrayOfInt2 = FrameLayout.EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(arrayOfInt1, i);
    return new ColorStateList(new int[][] { arrayOfInt1, localObject, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  @NonNull
  private final Drawable createDefaultItemBackground(@NonNull TintTypedArray paramTintTypedArray)
  {
    int i = paramTintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0);
    int j = paramTintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), i, j).build());
    localMaterialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), paramTintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
    return new InsetDrawable(localMaterialShapeDrawable, paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.menuInflater == null) {
      this.menuInflater = new SupportMenuInflater(getContext());
    }
    return this.menuInflater;
  }
  
  private boolean hasShapeAppearance(@NonNull TintTypedArray paramTintTypedArray)
  {
    boolean bool;
    if ((!paramTintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance)) && (!paramTintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void setupInsetScrimsListener()
  {
    this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Object localObject = NavigationView.this;
        ((FrameLayout)localObject).getLocationOnScreen(((NavigationView)localObject).tmpLocation);
        localObject = NavigationView.this.tmpLocation;
        boolean bool1 = true;
        boolean bool2;
        if (localObject[1] == 0) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        NavigationView.this.presenter.setBehindStatusBar(bool2);
        NavigationView.this.setDrawTopInsetForeground(bool2);
        localObject = ContextUtils.getActivity(NavigationView.this.getContext());
        if ((localObject != null) && (Build.VERSION.SDK_INT >= 21))
        {
          int i;
          if (((Activity)localObject).findViewById(16908290).getHeight() == NavigationView.this.getHeight()) {
            i = 1;
          } else {
            i = 0;
          }
          int j;
          if (Color.alpha(((Activity)localObject).getWindow().getNavigationBarColor()) != 0) {
            j = 1;
          } else {
            j = 0;
          }
          localObject = NavigationView.this;
          if ((i != 0) && (j != 0)) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
          ((ScrimInsetsFrameLayout)localObject).setDrawBottomInsetForeground(bool2);
        }
      }
    };
    getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
  }
  
  public void addHeaderView(@NonNull View paramView)
  {
    this.presenter.addHeaderView(paramView);
  }
  
  @Nullable
  public MenuItem getCheckedItem()
  {
    return this.presenter.getCheckedItem();
  }
  
  public int getHeaderCount()
  {
    return this.presenter.getHeaderCount();
  }
  
  public View getHeaderView(int paramInt)
  {
    return this.presenter.getHeaderView(paramInt);
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.presenter.getItemBackground();
  }
  
  @Dimension
  public int getItemHorizontalPadding()
  {
    return this.presenter.getItemHorizontalPadding();
  }
  
  @Dimension
  public int getItemIconPadding()
  {
    return this.presenter.getItemIconPadding();
  }
  
  @Nullable
  public ColorStateList getItemIconTintList()
  {
    return this.presenter.getItemTintList();
  }
  
  public int getItemMaxLines()
  {
    return this.presenter.getItemMaxLines();
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.presenter.getItemTextColor();
  }
  
  @NonNull
  public Menu getMenu()
  {
    return this.menu;
  }
  
  public View inflateHeaderView(@LayoutRes int paramInt)
  {
    return this.presenter.inflateHeaderView(paramInt);
  }
  
  public void inflateMenu(int paramInt)
  {
    this.presenter.setUpdateSuspended(true);
    getMenuInflater().inflate(paramInt, this.menu);
    this.presenter.setUpdateSuspended(false);
    this.presenter.updateMenuView(false);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.setParentAbsoluteElevation(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (Build.VERSION.SDK_INT < 16) {
      getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
    } else {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void onInsetsChanged(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.presenter.dispatchApplyWindowInsets(paramWindowInsetsCompat);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    if (i != Integer.MIN_VALUE)
    {
      if (i == 0) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
      }
    }
    else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.maxWidth), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.menu.restorePresenterStates(paramParcelable.menuState);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Bundle localBundle = new Bundle();
    localSavedState.menuState = localBundle;
    this.menu.savePresenterStates(localBundle);
    return localSavedState;
  }
  
  public void removeHeaderView(@NonNull View paramView)
  {
    this.presenter.removeHeaderView(paramView);
  }
  
  public void setCheckedItem(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.menu.findItem(paramInt);
    if (localMenuItem != null) {
      this.presenter.setCheckedItem((MenuItemImpl)localMenuItem);
    }
  }
  
  public void setCheckedItem(@NonNull MenuItem paramMenuItem)
  {
    paramMenuItem = this.menu.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.presenter.setCheckedItem((MenuItemImpl)paramMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.setElevation(paramFloat);
    }
    MaterialShapeUtils.setElevation(this, paramFloat);
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.presenter.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    setItemBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(@Dimension int paramInt)
  {
    this.presenter.setItemHorizontalPadding(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(@DimenRes int paramInt)
  {
    this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(@Dimension int paramInt)
  {
    this.presenter.setItemIconPadding(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.presenter.setItemIconSize(paramInt);
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.presenter.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemMaxLines(int paramInt)
  {
    this.presenter.setItemMaxLines(paramInt);
  }
  
  public void setItemTextAppearance(@StyleRes int paramInt)
  {
    this.presenter.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.presenter.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.listener = paramOnNavigationItemSelectedListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(paramInt);
    NavigationMenuPresenter localNavigationMenuPresenter = this.presenter;
    if (localNavigationMenuPresenter != null) {
      localNavigationMenuPresenter.setOverScrollMode(paramInt);
    }
  }
  
  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(@NonNull MenuItem paramMenuItem);
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      @Nullable
      public NavigationView.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel)
      {
        return new NavigationView.SavedState(paramAnonymousParcel, null);
      }
      
      @NonNull
      public NavigationView.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new NavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      @NonNull
      public NavigationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new NavigationView.SavedState[paramAnonymousInt];
      }
    };
    @Nullable
    public Bundle menuState;
    
    public SavedState(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.menuState = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.menuState);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\navigation\NavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */