package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils.RelativePadding;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class BottomNavigationView
  extends FrameLayout
{
  private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomNavigationView;
  private static final int MENU_PRESENTER_ID = 1;
  @Nullable
  private ColorStateList itemRippleColor;
  @NonNull
  private final MenuBuilder menu;
  private MenuInflater menuInflater;
  @NonNull
  @VisibleForTesting
  final BottomNavigationMenuView menuView;
  private final BottomNavigationPresenter presenter;
  private OnNavigationItemReselectedListener reselectedListener;
  private OnNavigationItemSelectedListener selectedListener;
  
  public BottomNavigationView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.bottomNavigationStyle);
  }
  
  public BottomNavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, DEF_STYLE_RES), paramAttributeSet, paramInt);
    Object localObject = new BottomNavigationPresenter();
    this.presenter = ((BottomNavigationPresenter)localObject);
    Context localContext = getContext();
    paramContext = new BottomNavigationMenu(localContext);
    this.menu = paramContext;
    BottomNavigationMenuView localBottomNavigationMenuView = new BottomNavigationMenuView(localContext);
    this.menuView = localBottomNavigationMenuView;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localBottomNavigationMenuView.setLayoutParams(localLayoutParams);
    ((BottomNavigationPresenter)localObject).setBottomNavigationMenuView(localBottomNavigationMenuView);
    ((BottomNavigationPresenter)localObject).setId(1);
    localBottomNavigationMenuView.setPresenter((BottomNavigationPresenter)localObject);
    paramContext.addMenuPresenter((MenuPresenter)localObject);
    ((BottomNavigationPresenter)localObject).initForMenu(getContext(), paramContext);
    localObject = R.styleable.BottomNavigationView;
    int i = R.style.Widget_Design_BottomNavigationView;
    int j = R.styleable.BottomNavigationView_itemTextAppearanceInactive;
    int k = R.styleable.BottomNavigationView_itemTextAppearanceActive;
    paramAttributeSet = ThemeEnforcement.obtainTintedStyledAttributes(localContext, paramAttributeSet, (int[])localObject, paramInt, i, new int[] { j, k });
    paramInt = R.styleable.BottomNavigationView_itemIconTint;
    if (paramAttributeSet.hasValue(paramInt)) {
      localBottomNavigationMenuView.setIconTintList(paramAttributeSet.getColorStateList(paramInt));
    } else {
      localBottomNavigationMenuView.setIconTintList(localBottomNavigationMenuView.createDefaultColorStateList(16842808));
    }
    setItemIconSize(paramAttributeSet.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
    if (paramAttributeSet.hasValue(j)) {
      setItemTextAppearanceInactive(paramAttributeSet.getResourceId(j, 0));
    }
    if (paramAttributeSet.hasValue(k)) {
      setItemTextAppearanceActive(paramAttributeSet.getResourceId(k, 0));
    }
    paramInt = R.styleable.BottomNavigationView_itemTextColor;
    if (paramAttributeSet.hasValue(paramInt)) {
      setItemTextColor(paramAttributeSet.getColorStateList(paramInt));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable))) {
      ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(localContext));
    }
    paramInt = R.styleable.BottomNavigationView_elevation;
    if (paramAttributeSet.hasValue(paramInt)) {
      ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(paramInt, 0));
    }
    localObject = MaterialResources.getColorStateList(localContext, paramAttributeSet, R.styleable.BottomNavigationView_backgroundTint);
    DrawableCompat.setTintList(getBackground().mutate(), (ColorStateList)localObject);
    setLabelVisibilityMode(paramAttributeSet.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
    setItemHorizontalTranslationEnabled(paramAttributeSet.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
    paramInt = paramAttributeSet.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
    if (paramInt != 0) {
      localBottomNavigationMenuView.setItemBackgroundRes(paramInt);
    } else {
      setItemRippleColor(MaterialResources.getColorStateList(localContext, paramAttributeSet, R.styleable.BottomNavigationView_itemRippleColor));
    }
    paramInt = R.styleable.BottomNavigationView_menu;
    if (paramAttributeSet.hasValue(paramInt)) {
      inflateMenu(paramAttributeSet.getResourceId(paramInt, 0));
    }
    paramAttributeSet.recycle();
    addView(localBottomNavigationMenuView, localLayoutParams);
    if (Build.VERSION.SDK_INT < 21) {
      addCompatibilityTopDivider(localContext);
    }
    paramContext.setCallback(new MenuBuilder.Callback()
    {
      public boolean onMenuItemSelected(MenuBuilder paramAnonymousMenuBuilder, @NonNull MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuBuilder = BottomNavigationView.this.reselectedListener;
        boolean bool = true;
        if ((paramAnonymousMenuBuilder != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()))
        {
          BottomNavigationView.this.reselectedListener.onNavigationItemReselected(paramAnonymousMenuItem);
          return true;
        }
        if ((BottomNavigationView.this.selectedListener == null) || (BottomNavigationView.this.selectedListener.onNavigationItemSelected(paramAnonymousMenuItem))) {
          bool = false;
        }
        return bool;
      }
      
      public void onMenuModeChange(MenuBuilder paramAnonymousMenuBuilder) {}
    });
    applyWindowInsets();
  }
  
  private void addCompatibilityTopDivider(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(ContextCompat.getColor(paramContext, R.color.design_bottom_navigation_shadow_color));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
    addView(localView);
  }
  
  private void applyWindowInsets()
  {
    ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener()
    {
      @NonNull
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, @NonNull WindowInsetsCompat paramAnonymousWindowInsetsCompat, @NonNull ViewUtils.RelativePadding paramAnonymousRelativePadding)
      {
        paramAnonymousRelativePadding.bottom += paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom();
        paramAnonymousRelativePadding.applyToView(paramAnonymousView);
        return paramAnonymousWindowInsetsCompat;
      }
    });
  }
  
  @NonNull
  private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context paramContext)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof ColorDrawable)) {
      localMaterialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable)localDrawable).getColor()));
    }
    localMaterialShapeDrawable.initializeElevationOverlay(paramContext);
    return localMaterialShapeDrawable;
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.menuInflater == null) {
      this.menuInflater = new SupportMenuInflater(getContext());
    }
    return this.menuInflater;
  }
  
  @Nullable
  public BadgeDrawable getBadge(int paramInt)
  {
    return this.menuView.getBadge(paramInt);
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.menuView.getItemBackground();
  }
  
  @Deprecated
  @DrawableRes
  public int getItemBackgroundResource()
  {
    return this.menuView.getItemBackgroundRes();
  }
  
  @Dimension
  public int getItemIconSize()
  {
    return this.menuView.getItemIconSize();
  }
  
  @Nullable
  public ColorStateList getItemIconTintList()
  {
    return this.menuView.getIconTintList();
  }
  
  @Nullable
  public ColorStateList getItemRippleColor()
  {
    return this.itemRippleColor;
  }
  
  @StyleRes
  public int getItemTextAppearanceActive()
  {
    return this.menuView.getItemTextAppearanceActive();
  }
  
  @StyleRes
  public int getItemTextAppearanceInactive()
  {
    return this.menuView.getItemTextAppearanceInactive();
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.menuView.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.menuView.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  @NonNull
  public Menu getMenu()
  {
    return this.menu;
  }
  
  public BadgeDrawable getOrCreateBadge(int paramInt)
  {
    return this.menuView.getOrCreateBadge(paramInt);
  }
  
  @IdRes
  public int getSelectedItemId()
  {
    return this.menuView.getSelectedItemId();
  }
  
  public void inflateMenu(int paramInt)
  {
    this.presenter.setUpdateSuspended(true);
    getMenuInflater().inflate(paramInt, this.menu);
    this.presenter.setUpdateSuspended(false);
    this.presenter.updateMenuView(true);
  }
  
  public boolean isItemHorizontalTranslationEnabled()
  {
    return this.menuView.isItemHorizontalTranslationEnabled();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.setParentAbsoluteElevation(this);
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
    this.menu.restorePresenterStates(paramParcelable.menuPresenterState);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Bundle localBundle = new Bundle();
    localSavedState.menuPresenterState = localBundle;
    this.menu.savePresenterStates(localBundle);
    return localSavedState;
  }
  
  public void removeBadge(int paramInt)
  {
    this.menuView.removeBadge(paramInt);
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    MaterialShapeUtils.setElevation(this, paramFloat);
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.menuView.setItemBackground(paramDrawable);
    this.itemRippleColor = null;
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    this.menuView.setItemBackgroundRes(paramInt);
    this.itemRippleColor = null;
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.menuView.isItemHorizontalTranslationEnabled() != paramBoolean)
    {
      this.menuView.setItemHorizontalTranslationEnabled(paramBoolean);
      this.presenter.updateMenuView(false);
    }
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.menuView.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(@DimenRes int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.menuView.setIconTintList(paramColorStateList);
  }
  
  public void setItemRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.itemRippleColor == paramColorStateList)
    {
      if ((paramColorStateList == null) && (this.menuView.getItemBackground() != null)) {
        this.menuView.setItemBackground(null);
      }
      return;
    }
    this.itemRippleColor = paramColorStateList;
    if (paramColorStateList == null)
    {
      this.menuView.setItemBackground(null);
    }
    else
    {
      paramColorStateList = RippleUtils.convertToRippleDrawableColor(paramColorStateList);
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.menuView.setItemBackground(new RippleDrawable(paramColorStateList, null, null));
      }
      else
      {
        Object localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(1.0E-5F);
        localObject = DrawableCompat.wrap((Drawable)localObject);
        DrawableCompat.setTintList((Drawable)localObject, paramColorStateList);
        this.menuView.setItemBackground((Drawable)localObject);
      }
    }
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.menuView.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.menuView.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.menuView.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.menuView.getLabelVisibilityMode() != paramInt)
    {
      this.menuView.setLabelVisibilityMode(paramInt);
      this.presenter.updateMenuView(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener paramOnNavigationItemReselectedListener)
  {
    this.reselectedListener = paramOnNavigationItemReselectedListener;
  }
  
  public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.selectedListener = paramOnNavigationItemSelectedListener;
  }
  
  public void setSelectedItemId(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.menu.findItem(paramInt);
    if ((localMenuItem != null) && (!this.menu.performItemAction(localMenuItem, this.presenter, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  public static abstract interface OnNavigationItemReselectedListener
  {
    public abstract void onNavigationItemReselected(@NonNull MenuItem paramMenuItem);
  }
  
  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(@NonNull MenuItem paramMenuItem);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      @Nullable
      public BottomNavigationView.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel)
      {
        return new BottomNavigationView.SavedState(paramAnonymousParcel, null);
      }
      
      @NonNull
      public BottomNavigationView.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomNavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      @NonNull
      public BottomNavigationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomNavigationView.SavedState[paramAnonymousInt];
      }
    };
    @Nullable
    Bundle menuPresenterState;
    
    public SavedState(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      readFromParcel(paramParcel, localClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void readFromParcel(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.menuPresenterState = paramParcel.readBundle(paramClassLoader);
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.menuPresenterState);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\bottomnavigation\BottomNavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */