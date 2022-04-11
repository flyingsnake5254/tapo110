package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private static final int FULL_UNDERLINE_HEIGHT = 1;
  private static final int INDICATOR_HEIGHT = 3;
  private static final int MIN_PADDING_BOTTOM = 6;
  private static final int MIN_STRIP_HEIGHT = 32;
  private static final int MIN_TEXT_SPACING = 64;
  private static final int TAB_PADDING = 16;
  private static final int TAB_SPACING = 32;
  private static final String TAG = "PagerTabStrip";
  private boolean mDrawFullUnderline;
  private boolean mDrawFullUnderlineSet;
  private int mFullUnderlineHeight;
  private boolean mIgnoreTap;
  private int mIndicatorColor;
  private int mIndicatorHeight;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private int mMinPaddingBottom;
  private int mMinStripHeight;
  private int mMinTextSpacing;
  private int mTabAlpha;
  private int mTabPadding;
  private final Paint mTabPaint;
  private final Rect mTempRect;
  private int mTouchSlop;
  
  public PagerTabStrip(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTabStrip(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = new Paint();
    this.mTabPaint = paramAttributeSet;
    this.mTempRect = new Rect();
    this.mTabAlpha = 255;
    this.mDrawFullUnderline = false;
    this.mDrawFullUnderlineSet = false;
    int i = this.mTextColor;
    this.mIndicatorColor = i;
    paramAttributeSet.setColor(i);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mIndicatorHeight = ((int)(3.0F * f + 0.5F));
    this.mMinPaddingBottom = ((int)(6.0F * f + 0.5F));
    this.mMinTextSpacing = ((int)(64.0F * f));
    this.mTabPadding = ((int)(16.0F * f + 0.5F));
    this.mFullUnderlineHeight = ((int)(1.0F * f + 0.5F));
    this.mMinStripHeight = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.mPrevText.setFocusable(true);
    this.mPrevText.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = PagerTabStrip.this.mPager;
        paramAnonymousView.setCurrentItem(paramAnonymousView.getCurrentItem() - 1);
      }
    });
    this.mNextText.setFocusable(true);
    this.mNextText.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = PagerTabStrip.this.mPager;
        paramAnonymousView.setCurrentItem(paramAnonymousView.getCurrentItem() + 1);
      }
    });
    if (getBackground() == null) {
      this.mDrawFullUnderline = true;
    }
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.mDrawFullUnderline;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.mMinStripHeight);
  }
  
  @ColorInt
  public int getTabIndicatorColor()
  {
    return this.mIndicatorColor;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.mCurrText.getLeft();
    int k = this.mTabPadding;
    int m = this.mCurrText.getRight();
    int n = this.mTabPadding;
    int i1 = this.mIndicatorHeight;
    this.mTabPaint.setColor(this.mTabAlpha << 24 | this.mIndicatorColor & 0xFFFFFF);
    float f1 = j - k;
    float f2 = i - i1;
    float f3 = m + n;
    float f4 = i;
    paramCanvas.drawRect(f1, f2, f3, f4, this.mTabPaint);
    if (this.mDrawFullUnderline)
    {
      this.mTabPaint.setColor(0xFF000000 | this.mIndicatorColor & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), f4, this.mTabPaint);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.mIgnoreTap)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i == 2) && ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))) {
          this.mIgnoreTap = true;
        }
      }
      else if (f1 < this.mCurrText.getLeft() - this.mTabPadding)
      {
        paramMotionEvent = this.mPager;
        paramMotionEvent.setCurrentItem(paramMotionEvent.getCurrentItem() - 1);
      }
      else if (f1 > this.mCurrText.getRight() + this.mTabPadding)
      {
        paramMotionEvent = this.mPager;
        paramMotionEvent.setCurrentItem(paramMotionEvent.getCurrentItem() + 1);
      }
    }
    else
    {
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.mIgnoreTap = false;
    }
    return true;
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.mDrawFullUnderlineSet)
    {
      boolean bool;
      if ((paramInt & 0xFF000000) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.mDrawFullUnderline = bool;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.mDrawFullUnderlineSet)
    {
      boolean bool;
      if (paramDrawable == null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mDrawFullUnderline = bool;
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.mDrawFullUnderlineSet)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.mDrawFullUnderline = bool;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.mDrawFullUnderline = paramBoolean;
    this.mDrawFullUnderlineSet = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mMinPaddingBottom;
    int j = paramInt4;
    if (paramInt4 < i) {
      j = i;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, j);
  }
  
  public void setTabIndicatorColor(@ColorInt int paramInt)
  {
    this.mIndicatorColor = paramInt;
    this.mTabPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(@ColorRes int paramInt)
  {
    setTabIndicatorColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = this.mMinTextSpacing;
    int j = paramInt;
    if (paramInt < i) {
      j = i;
    }
    super.setTextSpacing(j);
  }
  
  void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.mCurrText.getLeft();
    int k = this.mTabPadding;
    int m = this.mCurrText.getRight();
    int n = this.mTabPadding;
    int i1 = i - this.mIndicatorHeight;
    localRect.set(j - k, i1, m + n, i);
    super.updateTextPositions(paramInt, paramFloat, paramBoolean);
    this.mTabAlpha = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.mCurrText.getLeft() - this.mTabPadding, i1, this.mCurrText.getRight() + this.mTabPadding, i);
    invalidate(localRect);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\viewpager\widget\PagerTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */