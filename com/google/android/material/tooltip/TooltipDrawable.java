package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TooltipDrawable
  extends MaterialShapeDrawable
  implements TextDrawableHelper.TextDrawableDelegate
{
  @StyleRes
  private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Tooltip;
  @AttrRes
  private static final int DEFAULT_THEME_ATTR = R.attr.tooltipStyle;
  private int arrowSize;
  @NonNull
  private final View.OnLayoutChangeListener attachedViewLayoutChangeListener;
  @NonNull
  private final Context context;
  @NonNull
  private final Rect displayFrame;
  @Nullable
  private final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
  private int layoutMargin;
  private int locationOnScreenX;
  private int minHeight;
  private int minWidth;
  private int padding;
  @Nullable
  private CharSequence text;
  @NonNull
  private final TextDrawableHelper textDrawableHelper;
  
  private TooltipDrawable(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramAttributeSet = new TextDrawableHelper(this);
    this.textDrawableHelper = paramAttributeSet;
    this.attachedViewLayoutChangeListener = new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        TooltipDrawable.this.updateLocationOnScreen(paramAnonymousView);
      }
    };
    this.displayFrame = new Rect();
    this.context = paramContext;
    paramAttributeSet.getTextPaint().density = paramContext.getResources().getDisplayMetrics().density;
    paramAttributeSet.getTextPaint().setTextAlign(Paint.Align.CENTER);
  }
  
  private float calculatePointerOffset()
  {
    if (this.displayFrame.right - getBounds().right - this.locationOnScreenX - this.layoutMargin < 0) {}
    for (int i = this.displayFrame.right - getBounds().right - this.locationOnScreenX - this.layoutMargin;; i = this.displayFrame.left - getBounds().left - this.locationOnScreenX + this.layoutMargin)
    {
      f = i;
      return f;
      if (this.displayFrame.left - getBounds().left - this.locationOnScreenX + this.layoutMargin <= 0) {
        break;
      }
    }
    float f = 0.0F;
    return f;
  }
  
  private float calculateTextCenterFromBaseline()
  {
    this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
    Paint.FontMetrics localFontMetrics = this.fontMetrics;
    return (localFontMetrics.descent + localFontMetrics.ascent) / 2.0F;
  }
  
  private float calculateTextOriginAndAlignment(@NonNull Rect paramRect)
  {
    return paramRect.centerY() - calculateTextCenterFromBaseline();
  }
  
  @NonNull
  public static TooltipDrawable create(@NonNull Context paramContext)
  {
    return createFromAttributes(paramContext, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
  }
  
  @NonNull
  public static TooltipDrawable createFromAttributes(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return createFromAttributes(paramContext, paramAttributeSet, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
  }
  
  @NonNull
  public static TooltipDrawable createFromAttributes(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramContext = new TooltipDrawable(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext.loadFromAttributes(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  private EdgeTreatment createMarkerEdge()
  {
    float f1 = -calculatePointerOffset();
    float f2 = (float)(getBounds().width() - this.arrowSize * Math.sqrt(2.0D)) / 2.0F;
    f2 = Math.min(Math.max(f1, -f2), f2);
    return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.arrowSize), f2);
  }
  
  private void drawText(@NonNull Canvas paramCanvas)
  {
    if (this.text == null) {
      return;
    }
    Rect localRect = getBounds();
    int i = (int)calculateTextOriginAndAlignment(localRect);
    if (this.textDrawableHelper.getTextAppearance() != null)
    {
      this.textDrawableHelper.getTextPaint().drawableState = getState();
      this.textDrawableHelper.updateTextPaintDrawState(this.context);
    }
    CharSequence localCharSequence = this.text;
    paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect.centerX(), i, this.textDrawableHelper.getTextPaint());
  }
  
  private float getTextWidth()
  {
    CharSequence localCharSequence = this.text;
    if (localCharSequence == null) {
      return 0.0F;
    }
    return this.textDrawableHelper.getTextWidth(localCharSequence.toString());
  }
  
  private void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = ThemeEnforcement.obtainStyledAttributes(this.context, paramAttributeSet, R.styleable.Tooltip, paramInt1, paramInt2, new int[0]);
    this.arrowSize = this.context.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
    setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
    setText(paramAttributeSet.getText(R.styleable.Tooltip_android_text));
    setTextAppearance(MaterialResources.getTextAppearance(this.context, paramAttributeSet, R.styleable.Tooltip_android_textAppearance));
    paramInt1 = MaterialColors.getColor(this.context, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName());
    paramInt1 = MaterialColors.layer(ColorUtils.setAlphaComponent(MaterialColors.getColor(this.context, 16842801, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(paramInt1, 153));
    setFillColor(ColorStateList.valueOf(paramAttributeSet.getColor(R.styleable.Tooltip_backgroundTint, paramInt1)));
    setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.context, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
    this.padding = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
    this.minWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
    this.minHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
    this.layoutMargin = paramAttributeSet.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
    paramAttributeSet.recycle();
  }
  
  private void updateLocationOnScreen(@NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.locationOnScreenX = arrayOfInt[0];
    paramView.getWindowVisibleDisplayFrame(this.displayFrame);
  }
  
  public void detachView(@Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(calculatePointerOffset(), (float)-(this.arrowSize * Math.sqrt(2.0D) - this.arrowSize));
    super.draw(paramCanvas);
    drawText(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), this.minHeight);
  }
  
  public int getIntrinsicWidth()
  {
    return (int)Math.max(this.padding * 2 + getTextWidth(), this.minWidth);
  }
  
  public int getLayoutMargin()
  {
    return this.layoutMargin;
  }
  
  public int getMinHeight()
  {
    return this.minHeight;
  }
  
  public int getMinWidth()
  {
    return this.minWidth;
  }
  
  @Nullable
  public CharSequence getText()
  {
    return this.text;
  }
  
  @Nullable
  public TextAppearance getTextAppearance()
  {
    return this.textDrawableHelper.getTextAppearance();
  }
  
  public int getTextPadding()
  {
    return this.padding;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void onTextSizeChange()
  {
    invalidateSelf();
  }
  
  public void setLayoutMargin(@Px int paramInt)
  {
    this.layoutMargin = paramInt;
    invalidateSelf();
  }
  
  public void setMinHeight(@Px int paramInt)
  {
    this.minHeight = paramInt;
    invalidateSelf();
  }
  
  public void setMinWidth(@Px int paramInt)
  {
    this.minWidth = paramInt;
    invalidateSelf();
  }
  
  public void setRelativeToView(@Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    updateLocationOnScreen(paramView);
    paramView.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
  }
  
  public void setText(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(this.text, paramCharSequence))
    {
      this.text = paramCharSequence;
      this.textDrawableHelper.setTextWidthDirty(true);
      invalidateSelf();
    }
  }
  
  public void setTextAppearance(@Nullable TextAppearance paramTextAppearance)
  {
    this.textDrawableHelper.setTextAppearance(paramTextAppearance, this.context);
  }
  
  public void setTextAppearanceResource(@StyleRes int paramInt)
  {
    setTextAppearance(new TextAppearance(this.context, paramInt));
  }
  
  public void setTextPadding(@Px int paramInt)
  {
    this.padding = paramInt;
    invalidateSelf();
  }
  
  public void setTextResource(@StringRes int paramInt)
  {
    setText(this.context.getResources().getString(paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\tooltip\TooltipDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */