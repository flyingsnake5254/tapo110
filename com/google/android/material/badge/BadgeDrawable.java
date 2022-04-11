package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.plurals;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BadgeDrawable
  extends Drawable
  implements TextDrawableHelper.TextDrawableDelegate
{
  private static final int BADGE_NUMBER_NONE = -1;
  public static final int BOTTOM_END = 8388693;
  public static final int BOTTOM_START = 8388691;
  static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
  private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
  @StyleRes
  private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
  @AttrRes
  private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
  private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
  public static final int TOP_END = 8388661;
  public static final int TOP_START = 8388659;
  @Nullable
  private WeakReference<View> anchorViewRef;
  @NonNull
  private final Rect badgeBounds;
  private float badgeCenterX;
  private float badgeCenterY;
  private final float badgeRadius;
  private final float badgeWidePadding;
  private final float badgeWithTextRadius;
  @NonNull
  private final WeakReference<Context> contextRef;
  private float cornerRadius;
  @Nullable
  private WeakReference<ViewGroup> customBadgeParentRef;
  private float halfBadgeHeight;
  private float halfBadgeWidth;
  private int maxBadgeNumber;
  @NonNull
  private final SavedState savedState;
  @NonNull
  private final MaterialShapeDrawable shapeDrawable;
  @NonNull
  private final TextDrawableHelper textDrawableHelper;
  
  private BadgeDrawable(@NonNull Context paramContext)
  {
    this.contextRef = new WeakReference(paramContext);
    ThemeEnforcement.checkMaterialTheme(paramContext);
    Object localObject = paramContext.getResources();
    this.badgeBounds = new Rect();
    this.shapeDrawable = new MaterialShapeDrawable();
    this.badgeRadius = ((Resources)localObject).getDimensionPixelSize(R.dimen.mtrl_badge_radius);
    this.badgeWidePadding = ((Resources)localObject).getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
    this.badgeWithTextRadius = ((Resources)localObject).getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
    localObject = new TextDrawableHelper(this);
    this.textDrawableHelper = ((TextDrawableHelper)localObject);
    ((TextDrawableHelper)localObject).getTextPaint().setTextAlign(Paint.Align.CENTER);
    this.savedState = new SavedState(paramContext);
    setTextAppearanceResource(R.style.TextAppearance_MaterialComponents_Badge);
  }
  
  private void calculateCenterAndBounds(@NonNull Context paramContext, @NonNull Rect paramRect, @NonNull View paramView)
  {
    int i = this.savedState.badgeGravity;
    if ((i != 8388691) && (i != 8388693)) {
      this.badgeCenterY = (paramRect.top + this.savedState.verticalOffset);
    } else {
      this.badgeCenterY = (paramRect.bottom - this.savedState.verticalOffset);
    }
    float f;
    if (getNumber() <= 9)
    {
      if (!hasNumber()) {
        f = this.badgeRadius;
      } else {
        f = this.badgeWithTextRadius;
      }
      this.cornerRadius = f;
      this.halfBadgeHeight = f;
      this.halfBadgeWidth = f;
    }
    else
    {
      f = this.badgeWithTextRadius;
      this.cornerRadius = f;
      this.halfBadgeHeight = f;
      String str = getBadgeText();
      this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(str) / 2.0F + this.badgeWidePadding);
    }
    paramContext = paramContext.getResources();
    if (hasNumber()) {
      i = R.dimen.mtrl_badge_text_horizontal_edge_offset;
    } else {
      i = R.dimen.mtrl_badge_horizontal_edge_offset;
    }
    i = paramContext.getDimensionPixelSize(i);
    int j = this.savedState.badgeGravity;
    if ((j != 8388659) && (j != 8388691))
    {
      if (ViewCompat.getLayoutDirection(paramView) == 0) {
        f = paramRect.right + this.halfBadgeWidth - i - this.savedState.horizontalOffset;
      } else {
        f = paramRect.left - this.halfBadgeWidth + i + this.savedState.horizontalOffset;
      }
      this.badgeCenterX = f;
    }
    else
    {
      if (ViewCompat.getLayoutDirection(paramView) == 0) {
        f = paramRect.left - this.halfBadgeWidth + i + this.savedState.horizontalOffset;
      } else {
        f = paramRect.right + this.halfBadgeWidth - i - this.savedState.horizontalOffset;
      }
      this.badgeCenterX = f;
    }
  }
  
  @NonNull
  public static BadgeDrawable create(@NonNull Context paramContext)
  {
    return createFromAttributes(paramContext, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
  }
  
  @NonNull
  private static BadgeDrawable createFromAttributes(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    BadgeDrawable localBadgeDrawable = new BadgeDrawable(paramContext);
    localBadgeDrawable.loadDefaultStateFromAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    return localBadgeDrawable;
  }
  
  @NonNull
  public static BadgeDrawable createFromResource(@NonNull Context paramContext, @XmlRes int paramInt)
  {
    AttributeSet localAttributeSet = DrawableUtils.parseDrawableXml(paramContext, paramInt, "badge");
    int i = localAttributeSet.getStyleAttribute();
    paramInt = i;
    if (i == 0) {
      paramInt = DEFAULT_STYLE;
    }
    return createFromAttributes(paramContext, localAttributeSet, DEFAULT_THEME_ATTR, paramInt);
  }
  
  @NonNull
  static BadgeDrawable createFromSavedState(@NonNull Context paramContext, @NonNull SavedState paramSavedState)
  {
    paramContext = new BadgeDrawable(paramContext);
    paramContext.restoreFromSavedState(paramSavedState);
    return paramContext;
  }
  
  private void drawText(Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    String str = getBadgeText();
    this.textDrawableHelper.getTextPaint().getTextBounds(str, 0, str.length(), localRect);
    paramCanvas.drawText(str, this.badgeCenterX, this.badgeCenterY + localRect.height() / 2, this.textDrawableHelper.getTextPaint());
  }
  
  @NonNull
  private String getBadgeText()
  {
    if (getNumber() <= this.maxBadgeNumber) {
      return Integer.toString(getNumber());
    }
    Context localContext = (Context)this.contextRef.get();
    if (localContext == null) {
      return "";
    }
    return localContext.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[] { Integer.valueOf(this.maxBadgeNumber), "+" });
  }
  
  private void loadDefaultStateFromAttributes(Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.Badge, paramInt1, paramInt2, new int[0]);
    setMaxCharacterCount(paramAttributeSet.getInt(R.styleable.Badge_maxCharacterCount, 4));
    paramInt1 = R.styleable.Badge_number;
    if (paramAttributeSet.hasValue(paramInt1)) {
      setNumber(paramAttributeSet.getInt(paramInt1, 0));
    }
    setBackgroundColor(readColorFromAttributes(paramContext, paramAttributeSet, R.styleable.Badge_backgroundColor));
    paramInt1 = R.styleable.Badge_badgeTextColor;
    if (paramAttributeSet.hasValue(paramInt1)) {
      setBadgeTextColor(readColorFromAttributes(paramContext, paramAttributeSet, paramInt1));
    }
    setBadgeGravity(paramAttributeSet.getInt(R.styleable.Badge_badgeGravity, 8388661));
    setHorizontalOffset(paramAttributeSet.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
    setVerticalOffset(paramAttributeSet.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
    paramAttributeSet.recycle();
  }
  
  private static int readColorFromAttributes(Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    return MaterialResources.getColorStateList(paramContext, paramTypedArray, paramInt).getDefaultColor();
  }
  
  private void restoreFromSavedState(@NonNull SavedState paramSavedState)
  {
    setMaxCharacterCount(paramSavedState.maxCharacterCount);
    if (paramSavedState.number != -1) {
      setNumber(paramSavedState.number);
    }
    setBackgroundColor(paramSavedState.backgroundColor);
    setBadgeTextColor(paramSavedState.badgeTextColor);
    setBadgeGravity(paramSavedState.badgeGravity);
    setHorizontalOffset(paramSavedState.horizontalOffset);
    setVerticalOffset(paramSavedState.verticalOffset);
  }
  
  private void setTextAppearance(@Nullable TextAppearance paramTextAppearance)
  {
    if (this.textDrawableHelper.getTextAppearance() == paramTextAppearance) {
      return;
    }
    Context localContext = (Context)this.contextRef.get();
    if (localContext == null) {
      return;
    }
    this.textDrawableHelper.setTextAppearance(paramTextAppearance, localContext);
    updateCenterAndBounds();
  }
  
  private void setTextAppearanceResource(@StyleRes int paramInt)
  {
    Context localContext = (Context)this.contextRef.get();
    if (localContext == null) {
      return;
    }
    setTextAppearance(new TextAppearance(localContext, paramInt));
  }
  
  private void updateCenterAndBounds()
  {
    Context localContext = (Context)this.contextRef.get();
    Object localObject1 = this.anchorViewRef;
    ViewGroup localViewGroup = null;
    if (localObject1 != null) {
      localObject1 = (View)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if ((localContext != null) && (localObject1 != null))
    {
      Rect localRect1 = new Rect();
      localRect1.set(this.badgeBounds);
      Rect localRect2 = new Rect();
      ((View)localObject1).getDrawingRect(localRect2);
      Object localObject2 = this.customBadgeParentRef;
      if (localObject2 != null) {
        localViewGroup = (ViewGroup)((WeakReference)localObject2).get();
      }
      if ((localViewGroup != null) || (BadgeUtils.USE_COMPAT_PARENT))
      {
        localObject2 = localViewGroup;
        if (localViewGroup == null) {
          localObject2 = (ViewGroup)((View)localObject1).getParent();
        }
        ((ViewGroup)localObject2).offsetDescendantRectToMyCoords((View)localObject1, localRect2);
      }
      calculateCenterAndBounds(localContext, localRect2, (View)localObject1);
      BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
      this.shapeDrawable.setCornerSize(this.cornerRadius);
      if (!localRect1.equals(this.badgeBounds)) {
        this.shapeDrawable.setBounds(this.badgeBounds);
      }
    }
  }
  
  private void updateMaxBadgeNumber()
  {
    this.maxBadgeNumber = ((int)Math.pow(10.0D, getMaxCharacterCount() - 1.0D) - 1);
  }
  
  public void clearNumber()
  {
    SavedState.access$102(this.savedState, -1);
    invalidateSelf();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if ((!getBounds().isEmpty()) && (getAlpha() != 0) && (isVisible()))
    {
      this.shapeDrawable.draw(paramCanvas);
      if (hasNumber()) {
        drawText(paramCanvas);
      }
    }
  }
  
  public int getAlpha()
  {
    return this.savedState.alpha;
  }
  
  @ColorInt
  public int getBackgroundColor()
  {
    return this.shapeDrawable.getFillColor().getDefaultColor();
  }
  
  public int getBadgeGravity()
  {
    return this.savedState.badgeGravity;
  }
  
  @ColorInt
  public int getBadgeTextColor()
  {
    return this.textDrawableHelper.getTextPaint().getColor();
  }
  
  @Nullable
  public CharSequence getContentDescription()
  {
    if (!isVisible()) {
      return null;
    }
    if (hasNumber())
    {
      if (this.savedState.contentDescriptionQuantityStrings > 0)
      {
        Context localContext = (Context)this.contextRef.get();
        if (localContext == null) {
          return null;
        }
        if (getNumber() <= this.maxBadgeNumber) {
          return localContext.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), new Object[] { Integer.valueOf(getNumber()) });
        }
        return localContext.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, new Object[] { Integer.valueOf(this.maxBadgeNumber) });
      }
      return null;
    }
    return this.savedState.contentDescriptionNumberless;
  }
  
  public int getHorizontalOffset()
  {
    return this.savedState.horizontalOffset;
  }
  
  public int getIntrinsicHeight()
  {
    return this.badgeBounds.height();
  }
  
  public int getIntrinsicWidth()
  {
    return this.badgeBounds.width();
  }
  
  public int getMaxCharacterCount()
  {
    return this.savedState.maxCharacterCount;
  }
  
  public int getNumber()
  {
    if (!hasNumber()) {
      return 0;
    }
    return this.savedState.number;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @NonNull
  public SavedState getSavedState()
  {
    return this.savedState;
  }
  
  public int getVerticalOffset()
  {
    return this.savedState.verticalOffset;
  }
  
  public boolean hasNumber()
  {
    boolean bool;
    if (this.savedState.number != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isStateful()
  {
    return false;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void onTextSizeChange()
  {
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    SavedState.access$702(this.savedState, paramInt);
    this.textDrawableHelper.getTextPaint().setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    SavedState.access$202(this.savedState, paramInt);
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    if (this.shapeDrawable.getFillColor() != localColorStateList)
    {
      this.shapeDrawable.setFillColor(localColorStateList);
      invalidateSelf();
    }
  }
  
  public void setBadgeGravity(int paramInt)
  {
    if (this.savedState.badgeGravity != paramInt)
    {
      SavedState.access$402(this.savedState, paramInt);
      Object localObject = this.anchorViewRef;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        View localView = (View)this.anchorViewRef.get();
        localObject = this.customBadgeParentRef;
        if (localObject != null) {
          localObject = (ViewGroup)((WeakReference)localObject).get();
        } else {
          localObject = null;
        }
        updateBadgeCoordinates(localView, (ViewGroup)localObject);
      }
    }
  }
  
  public void setBadgeTextColor(@ColorInt int paramInt)
  {
    SavedState.access$302(this.savedState, paramInt);
    if (this.textDrawableHelper.getTextPaint().getColor() != paramInt)
    {
      this.textDrawableHelper.getTextPaint().setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int paramInt)
  {
    SavedState.access$1002(this.savedState, paramInt);
  }
  
  public void setContentDescriptionNumberless(CharSequence paramCharSequence)
  {
    SavedState.access$802(this.savedState, paramCharSequence);
  }
  
  public void setContentDescriptionQuantityStringsResource(@StringRes int paramInt)
  {
    SavedState.access$902(this.savedState, paramInt);
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    SavedState.access$502(this.savedState, paramInt);
    updateCenterAndBounds();
  }
  
  public void setMaxCharacterCount(int paramInt)
  {
    if (this.savedState.maxCharacterCount != paramInt)
    {
      SavedState.access$002(this.savedState, paramInt);
      updateMaxBadgeNumber();
      this.textDrawableHelper.setTextWidthDirty(true);
      updateCenterAndBounds();
      invalidateSelf();
    }
  }
  
  public void setNumber(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    if (this.savedState.number != paramInt)
    {
      SavedState.access$102(this.savedState, paramInt);
      this.textDrawableHelper.setTextWidthDirty(true);
      updateCenterAndBounds();
      invalidateSelf();
    }
  }
  
  public void setVerticalOffset(int paramInt)
  {
    SavedState.access$602(this.savedState, paramInt);
    updateCenterAndBounds();
  }
  
  public void setVisible(boolean paramBoolean)
  {
    setVisible(paramBoolean, false);
  }
  
  public void updateBadgeCoordinates(@NonNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    this.anchorViewRef = new WeakReference(paramView);
    this.customBadgeParentRef = new WeakReference(paramViewGroup);
    updateCenterAndBounds();
    invalidateSelf();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BadgeGravity {}
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      @NonNull
      public BadgeDrawable.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel)
      {
        return new BadgeDrawable.SavedState(paramAnonymousParcel);
      }
      
      @NonNull
      public BadgeDrawable.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BadgeDrawable.SavedState[paramAnonymousInt];
      }
    };
    private int alpha = 255;
    @ColorInt
    private int backgroundColor;
    private int badgeGravity;
    @ColorInt
    private int badgeTextColor;
    @StringRes
    private int contentDescriptionExceedsMaxBadgeNumberRes;
    @Nullable
    private CharSequence contentDescriptionNumberless;
    @PluralsRes
    private int contentDescriptionQuantityStrings;
    @Dimension(unit=1)
    private int horizontalOffset;
    private int maxCharacterCount;
    private int number = -1;
    @Dimension(unit=1)
    private int verticalOffset;
    
    public SavedState(@NonNull Context paramContext)
    {
      this.badgeTextColor = new TextAppearance(paramContext, R.style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
      this.contentDescriptionNumberless = paramContext.getString(R.string.mtrl_badge_numberless_content_description);
      this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
      this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
    }
    
    protected SavedState(@NonNull Parcel paramParcel)
    {
      this.backgroundColor = paramParcel.readInt();
      this.badgeTextColor = paramParcel.readInt();
      this.alpha = paramParcel.readInt();
      this.number = paramParcel.readInt();
      this.maxCharacterCount = paramParcel.readInt();
      this.contentDescriptionNumberless = paramParcel.readString();
      this.contentDescriptionQuantityStrings = paramParcel.readInt();
      this.badgeGravity = paramParcel.readInt();
      this.horizontalOffset = paramParcel.readInt();
      this.verticalOffset = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.backgroundColor);
      paramParcel.writeInt(this.badgeTextColor);
      paramParcel.writeInt(this.alpha);
      paramParcel.writeInt(this.number);
      paramParcel.writeInt(this.maxCharacterCount);
      paramParcel.writeString(this.contentDescriptionNumberless.toString());
      paramParcel.writeInt(this.contentDescriptionQuantityStrings);
      paramParcel.writeInt(this.badgeGravity);
      paramParcel.writeInt(this.horizontalOffset);
      paramParcel.writeInt(this.verticalOffset);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\badge\BadgeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */