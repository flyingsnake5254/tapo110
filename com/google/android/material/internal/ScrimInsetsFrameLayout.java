package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  private boolean drawBottomInsetForeground = true;
  private boolean drawTopInsetForeground = true;
  @Nullable
  Drawable insetForeground;
  Rect insets;
  private Rect tempRect = new Rect();
  
  public ScrimInsetsFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrimInsetsFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    this.insetForeground = paramContext.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, @NonNull WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if (paramAnonymousView.insets == null) {
          paramAnonymousView.insets = new Rect();
        }
        ScrimInsetsFrameLayout.this.insets.set(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
        ScrimInsetsFrameLayout.this.onInsetsChanged(paramAnonymousWindowInsetsCompat);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        boolean bool;
        if ((paramAnonymousWindowInsetsCompat.hasSystemWindowInsets()) && (ScrimInsetsFrameLayout.this.insetForeground != null)) {
          bool = false;
        } else {
          bool = true;
        }
        paramAnonymousView.setWillNotDraw(bool);
        ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
        return paramAnonymousWindowInsetsCompat.consumeSystemWindowInsets();
      }
    });
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.insets != null) && (this.insetForeground != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      if (this.drawTopInsetForeground)
      {
        this.tempRect.set(0, 0, i, this.insets.top);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(paramCanvas);
      }
      if (this.drawBottomInsetForeground)
      {
        this.tempRect.set(0, j - this.insets.bottom, i, j);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(paramCanvas);
      }
      Rect localRect1 = this.tempRect;
      Rect localRect2 = this.insets;
      localRect1.set(0, localRect2.top, localRect2.left, j - localRect2.bottom);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      localRect2 = this.tempRect;
      localRect1 = this.insets;
      localRect2.set(i - localRect1.right, localRect1.top, i, j - localRect1.bottom);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Drawable localDrawable = this.insetForeground;
    if (localDrawable != null) {
      localDrawable.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = this.insetForeground;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
  }
  
  protected void onInsetsChanged(WindowInsetsCompat paramWindowInsetsCompat) {}
  
  public void setDrawBottomInsetForeground(boolean paramBoolean)
  {
    this.drawBottomInsetForeground = paramBoolean;
  }
  
  public void setDrawTopInsetForeground(boolean paramBoolean)
  {
    this.drawTopInsetForeground = paramBoolean;
  }
  
  public void setScrimInsetForeground(@Nullable Drawable paramDrawable)
  {
    this.insetForeground = paramDrawable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ScrimInsetsFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */