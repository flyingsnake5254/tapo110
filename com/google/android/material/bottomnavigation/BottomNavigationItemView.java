package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationItemView
  extends FrameLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  public static final int INVALID_ITEM_POSITION = -1;
  @Nullable
  private BadgeDrawable badgeDrawable;
  private final int defaultMargin;
  private ImageView icon;
  @Nullable
  private ColorStateList iconTint;
  private boolean isShifting;
  @Nullable
  private MenuItemImpl itemData;
  private int itemPosition = -1;
  private int labelVisibilityMode;
  private final TextView largeLabel;
  @Nullable
  private Drawable originalIconDrawable;
  private float scaleDownFactor;
  private float scaleUpFactor;
  private float shiftAmount;
  private final TextView smallLabel;
  @Nullable
  private Drawable wrappedIconDrawable;
  
  public BottomNavigationItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(R.layout.design_bottom_navigation_item, this, true);
    setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
    this.defaultMargin = paramAttributeSet.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
    this.icon = ((ImageView)findViewById(R.id.icon));
    paramContext = (TextView)findViewById(R.id.smallLabel);
    this.smallLabel = paramContext;
    paramAttributeSet = (TextView)findViewById(R.id.largeLabel);
    this.largeLabel = paramAttributeSet;
    ViewCompat.setImportantForAccessibility(paramContext, 2);
    ViewCompat.setImportantForAccessibility(paramAttributeSet, 2);
    setFocusable(true);
    calculateTextScaleFactors(paramContext.getTextSize(), paramAttributeSet.getTextSize());
    paramContext = this.icon;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          if (BottomNavigationItemView.this.icon.getVisibility() == 0)
          {
            paramAnonymousView = BottomNavigationItemView.this;
            paramAnonymousView.tryUpdateBadgeBounds(paramAnonymousView.icon);
          }
        }
      });
    }
  }
  
  private void calculateTextScaleFactors(float paramFloat1, float paramFloat2)
  {
    this.shiftAmount = (paramFloat1 - paramFloat2);
    this.scaleUpFactor = (paramFloat2 * 1.0F / paramFloat1);
    this.scaleDownFactor = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  @Nullable
  private FrameLayout getCustomParentForBadge(View paramView)
  {
    ImageView localImageView = this.icon;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramView == localImageView)
    {
      localObject2 = localObject1;
      if (BadgeUtils.USE_COMPAT_PARENT) {
        localObject2 = (FrameLayout)localImageView.getParent();
      }
    }
    return (FrameLayout)localObject2;
  }
  
  private boolean hasBadge()
  {
    boolean bool;
    if (this.badgeDrawable != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void setViewLayoutParams(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void setViewValues(@NonNull View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  private void tryAttachBadgeToAnchor(@Nullable View paramView)
  {
    if (!hasBadge()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(false);
      setClipToPadding(false);
      BadgeUtils.attachBadgeDrawable(this.badgeDrawable, paramView, getCustomParentForBadge(paramView));
    }
  }
  
  private void tryRemoveBadgeFromAnchor(@Nullable View paramView)
  {
    if (!hasBadge()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(true);
      setClipToPadding(true);
      BadgeUtils.detachBadgeDrawable(this.badgeDrawable, paramView, getCustomParentForBadge(paramView));
    }
    this.badgeDrawable = null;
  }
  
  private void tryUpdateBadgeBounds(View paramView)
  {
    if (!hasBadge()) {
      return;
    }
    BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, paramView, getCustomParentForBadge(paramView));
  }
  
  @Nullable
  BadgeDrawable getBadge()
  {
    return this.badgeDrawable;
  }
  
  public MenuItemImpl getItemData()
  {
    return this.itemData;
  }
  
  public int getItemPosition()
  {
    return this.itemPosition;
  }
  
  public void initialize(@NonNull MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.itemData = paramMenuItemImpl;
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitle());
    setId(paramMenuItemImpl.getItemId());
    if (!TextUtils.isEmpty(paramMenuItemImpl.getContentDescription())) {
      setContentDescription(paramMenuItemImpl.getContentDescription());
    }
    CharSequence localCharSequence;
    if (!TextUtils.isEmpty(paramMenuItemImpl.getTooltipText())) {
      localCharSequence = paramMenuItemImpl.getTooltipText();
    } else {
      localCharSequence = paramMenuItemImpl.getTitle();
    }
    TooltipCompat.setTooltipText(this, localCharSequence);
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl localMenuItemImpl = this.itemData;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (this.itemData.isChecked())) {
      FrameLayout.mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = this.badgeDrawable;
    if ((localObject != null) && (((Drawable)localObject).isVisible()))
    {
      localObject = this.itemData.getTitle();
      if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
        localObject = this.itemData.getContentDescription();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.badgeDrawable.getContentDescription());
      paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemPosition(), 1, false, isSelected()));
    if (isSelected())
    {
      paramAccessibilityNodeInfo.setClickable(false);
      paramAccessibilityNodeInfo.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    }
    paramAccessibilityNodeInfo.setRoleDescription(getResources().getString(R.string.item_view_role_description));
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  void removeBadge()
  {
    tryRemoveBadgeFromAnchor(this.icon);
  }
  
  void setBadge(@NonNull BadgeDrawable paramBadgeDrawable)
  {
    this.badgeDrawable = paramBadgeDrawable;
    paramBadgeDrawable = this.icon;
    if (paramBadgeDrawable != null) {
      tryAttachBadgeToAnchor(paramBadgeDrawable);
    }
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    TextView localTextView = this.largeLabel;
    localTextView.setPivotX(localTextView.getWidth() / 2);
    localTextView = this.largeLabel;
    localTextView.setPivotY(localTextView.getBaseline());
    localTextView = this.smallLabel;
    localTextView.setPivotX(localTextView.getWidth() / 2);
    localTextView = this.smallLabel;
    localTextView.setPivotY(localTextView.getBaseline());
    int i = this.labelVisibilityMode;
    float f;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            setViewLayoutParams(this.icon, this.defaultMargin, 17);
            this.largeLabel.setVisibility(8);
            this.smallLabel.setVisibility(8);
          }
        }
        else if (paramBoolean)
        {
          setViewLayoutParams(this.icon, (int)(this.defaultMargin + this.shiftAmount), 49);
          setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
          localTextView = this.smallLabel;
          f = this.scaleUpFactor;
          setViewValues(localTextView, f, f, 4);
        }
        else
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 49);
          localTextView = this.largeLabel;
          f = this.scaleDownFactor;
          setViewValues(localTextView, f, f, 4);
          setViewValues(this.smallLabel, 1.0F, 1.0F, 0);
        }
      }
      else
      {
        if (paramBoolean)
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 49);
          setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
        }
        else
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 17);
          setViewValues(this.largeLabel, 0.5F, 0.5F, 4);
        }
        this.smallLabel.setVisibility(4);
      }
    }
    else if (this.isShifting)
    {
      if (paramBoolean)
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
      }
      else
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        setViewValues(this.largeLabel, 0.5F, 0.5F, 4);
      }
      this.smallLabel.setVisibility(4);
    }
    else if (paramBoolean)
    {
      setViewLayoutParams(this.icon, (int)(this.defaultMargin + this.shiftAmount), 49);
      setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
      localTextView = this.smallLabel;
      f = this.scaleUpFactor;
      setViewValues(localTextView, f, f, 4);
    }
    else
    {
      setViewLayoutParams(this.icon, this.defaultMargin, 49);
      localTextView = this.largeLabel;
      f = this.scaleDownFactor;
      setViewValues(localTextView, f, f, 4);
      setViewValues(this.smallLabel, 1.0F, 1.0F, 0);
    }
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.smallLabel.setEnabled(paramBoolean);
    this.largeLabel.setEnabled(paramBoolean);
    this.icon.setEnabled(paramBoolean);
    if (paramBoolean) {
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
    } else {
      ViewCompat.setPointerIcon(this, null);
    }
  }
  
  public void setIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == this.originalIconDrawable) {
      return;
    }
    this.originalIconDrawable = paramDrawable;
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      this.wrappedIconDrawable = paramDrawable;
      ColorStateList localColorStateList = this.iconTint;
      localObject = paramDrawable;
      if (localColorStateList != null)
      {
        DrawableCompat.setTintList(paramDrawable, localColorStateList);
        localObject = paramDrawable;
      }
    }
    this.icon.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.icon.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.icon.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.iconTint = paramColorStateList;
    if (this.itemData != null)
    {
      Drawable localDrawable = this.wrappedIconDrawable;
      if (localDrawable != null)
      {
        DrawableCompat.setTintList(localDrawable, paramColorStateList);
        this.wrappedIconDrawable.invalidateSelf();
      }
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    }
    setItemBackground(localDrawable);
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (paramDrawable.getConstantState() != null) {
        localDrawable = paramDrawable.getConstantState().newDrawable().mutate();
      }
    }
    ViewCompat.setBackground(this, localDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.itemPosition = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.labelVisibilityMode != paramInt)
    {
      this.labelVisibilityMode = paramInt;
      MenuItemImpl localMenuItemImpl = this.itemData;
      if (localMenuItemImpl != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        setChecked(localMenuItemImpl.isChecked());
      }
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.isShifting != paramBoolean)
    {
      this.isShifting = paramBoolean;
      MenuItemImpl localMenuItemImpl = this.itemData;
      int i;
      if (localMenuItemImpl != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        setChecked(localMenuItemImpl.isChecked());
      }
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearanceActive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.largeLabel, paramInt);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  public void setTextAppearanceInactive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.smallLabel, paramInt);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  public void setTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.smallLabel.setTextColor(paramColorStateList);
      this.largeLabel.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.smallLabel.setText(paramCharSequence);
    this.largeLabel.setText(paramCharSequence);
    Object localObject = this.itemData;
    if ((localObject == null) || (TextUtils.isEmpty(((MenuItemImpl)localObject).getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
    MenuItemImpl localMenuItemImpl = this.itemData;
    localObject = paramCharSequence;
    if (localMenuItemImpl != null) {
      if (TextUtils.isEmpty(localMenuItemImpl.getTooltipText())) {
        localObject = paramCharSequence;
      } else {
        localObject = this.itemData.getTooltipText();
      }
    }
    TooltipCompat.setTooltipText(this, (CharSequence)localObject);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\bottomnavigation\BottomNavigationItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */