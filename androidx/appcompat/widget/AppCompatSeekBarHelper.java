package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R.styleable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class AppCompatSeekBarHelper
  extends AppCompatProgressBarHelper
{
  private boolean mHasTickMarkTint = false;
  private boolean mHasTickMarkTintMode = false;
  private Drawable mTickMark;
  private ColorStateList mTickMarkTintList = null;
  private PorterDuff.Mode mTickMarkTintMode = null;
  private final SeekBar mView;
  
  AppCompatSeekBarHelper(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.mView = paramSeekBar;
  }
  
  private void applyTickMarkTint()
  {
    Drawable localDrawable = this.mTickMark;
    if ((localDrawable != null) && ((this.mHasTickMarkTint) || (this.mHasTickMarkTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable.mutate());
      this.mTickMark = localDrawable;
      if (this.mHasTickMarkTint) {
        DrawableCompat.setTintList(localDrawable, this.mTickMarkTintList);
      }
      if (this.mHasTickMarkTintMode) {
        DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
      }
      if (this.mTickMark.isStateful()) {
        this.mTickMark.setState(this.mView.getDrawableState());
      }
    }
  }
  
  void drawTickMarks(Canvas paramCanvas)
  {
    if (this.mTickMark != null)
    {
      int i = this.mView.getMax();
      int j = 1;
      if (i > 1)
      {
        int k = this.mTickMark.getIntrinsicWidth();
        int m = this.mTickMark.getIntrinsicHeight();
        if (k >= 0) {
          k /= 2;
        } else {
          k = 1;
        }
        if (m >= 0) {
          j = m / 2;
        }
        this.mTickMark.setBounds(-k, -j, k, j);
        float f = (this.mView.getWidth() - this.mView.getPaddingLeft() - this.mView.getPaddingRight()) / i;
        j = paramCanvas.save();
        paramCanvas.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
        for (k = 0; k <= i; k++)
        {
          this.mTickMark.draw(paramCanvas);
          paramCanvas.translate(f, 0.0F);
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  void drawableStateChanged()
  {
    Drawable localDrawable = this.mTickMark;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(this.mView.getDrawableState()))) {
      this.mView.invalidateDrawable(localDrawable);
    }
  }
  
  @Nullable
  Drawable getTickMark()
  {
    return this.mTickMark;
  }
  
  @Nullable
  ColorStateList getTickMarkTintList()
  {
    return this.mTickMarkTintList;
  }
  
  @Nullable
  PorterDuff.Mode getTickMarkTintMode()
  {
    return this.mTickMarkTintMode;
  }
  
  void jumpDrawablesToCurrentState()
  {
    Drawable localDrawable = this.mTickMark;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    Object localObject = this.mView.getContext();
    int[] arrayOfInt = R.styleable.AppCompatSeekBar;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    SeekBar localSeekBar = this.mView;
    ViewCompat.saveAttributeDataForStyleable(localSeekBar, localSeekBar.getContext(), arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getWrappedTypeArray(), paramInt, 0);
    paramAttributeSet = ((TintTypedArray)localObject).getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
    if (paramAttributeSet != null) {
      this.mView.setThumb(paramAttributeSet);
    }
    setTickMark(((TintTypedArray)localObject).getDrawable(R.styleable.AppCompatSeekBar_tickMark));
    paramInt = R.styleable.AppCompatSeekBar_tickMarkTintMode;
    if (((TintTypedArray)localObject).hasValue(paramInt))
    {
      this.mTickMarkTintMode = DrawableUtils.parseTintMode(((TintTypedArray)localObject).getInt(paramInt, -1), this.mTickMarkTintMode);
      this.mHasTickMarkTintMode = true;
    }
    paramInt = R.styleable.AppCompatSeekBar_tickMarkTint;
    if (((TintTypedArray)localObject).hasValue(paramInt))
    {
      this.mTickMarkTintList = ((TintTypedArray)localObject).getColorStateList(paramInt);
      this.mHasTickMarkTint = true;
    }
    ((TintTypedArray)localObject).recycle();
    applyTickMarkTint();
  }
  
  void setTickMark(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = this.mTickMark;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.mTickMark = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this.mView);
      DrawableCompat.setLayoutDirection(paramDrawable, ViewCompat.getLayoutDirection(this.mView));
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.mView.getDrawableState());
      }
      applyTickMarkTint();
    }
    this.mView.invalidate();
  }
  
  void setTickMarkTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.mTickMarkTintList = paramColorStateList;
    this.mHasTickMarkTint = true;
    applyTickMarkTint();
  }
  
  void setTickMarkTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mTickMarkTintMode = paramMode;
    this.mHasTickMarkTintMode = true;
    applyTickMarkTint();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatSeekBarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */