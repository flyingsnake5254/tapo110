package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

final class CalendarItemStyle
{
  private final ColorStateList backgroundColor;
  @NonNull
  private final Rect insets;
  private final ShapeAppearanceModel itemShape;
  private final ColorStateList strokeColor;
  private final int strokeWidth;
  private final ColorStateList textColor;
  
  private CalendarItemStyle(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, ColorStateList paramColorStateList3, int paramInt, ShapeAppearanceModel paramShapeAppearanceModel, @NonNull Rect paramRect)
  {
    Preconditions.checkArgumentNonnegative(paramRect.left);
    Preconditions.checkArgumentNonnegative(paramRect.top);
    Preconditions.checkArgumentNonnegative(paramRect.right);
    Preconditions.checkArgumentNonnegative(paramRect.bottom);
    this.insets = paramRect;
    this.textColor = paramColorStateList2;
    this.backgroundColor = paramColorStateList1;
    this.strokeColor = paramColorStateList3;
    this.strokeWidth = paramInt;
    this.itemShape = paramShapeAppearanceModel;
  }
  
  @NonNull
  static CalendarItemStyle create(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Cannot create a CalendarItemStyle with a styleResId of 0");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.MaterialCalendarItem);
    Rect localRect = new Rect(localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
    ColorStateList localColorStateList1 = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.MaterialCalendarItem_itemFillColor);
    ColorStateList localColorStateList2 = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.MaterialCalendarItem_itemTextColor);
    ColorStateList localColorStateList3 = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.MaterialCalendarItem_itemStrokeColor);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
    paramContext = ShapeAppearanceModel.builder(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), localTypedArray.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
    localTypedArray.recycle();
    return new CalendarItemStyle(localColorStateList1, localColorStateList2, localColorStateList3, paramInt, paramContext, localRect);
  }
  
  int getBottomInset()
  {
    return this.insets.bottom;
  }
  
  int getLeftInset()
  {
    return this.insets.left;
  }
  
  int getRightInset()
  {
    return this.insets.right;
  }
  
  int getTopInset()
  {
    return this.insets.top;
  }
  
  void styleItem(@NonNull TextView paramTextView)
  {
    Object localObject1 = new MaterialShapeDrawable();
    Object localObject2 = new MaterialShapeDrawable();
    ((MaterialShapeDrawable)localObject1).setShapeAppearanceModel(this.itemShape);
    ((MaterialShapeDrawable)localObject2).setShapeAppearanceModel(this.itemShape);
    ((MaterialShapeDrawable)localObject1).setFillColor(this.backgroundColor);
    ((MaterialShapeDrawable)localObject1).setStroke(this.strokeWidth, this.strokeColor);
    paramTextView.setTextColor(this.textColor);
    if (Build.VERSION.SDK_INT >= 21) {
      localObject1 = new RippleDrawable(this.textColor.withAlpha(30), (Drawable)localObject1, (Drawable)localObject2);
    }
    localObject2 = this.insets;
    ViewCompat.setBackground(paramTextView, new InsetDrawable((Drawable)localObject1, ((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\CalendarItemStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */