package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class ContentFrameLayout
  extends FrameLayout
{
  private OnAttachListener mAttachListener;
  private final Rect mDecorPadding = new Rect();
  private TypedValue mFixedHeightMajor;
  private TypedValue mFixedHeightMinor;
  private TypedValue mFixedWidthMajor;
  private TypedValue mFixedWidthMinor;
  private TypedValue mMinWidthMajor;
  private TypedValue mMinWidthMinor;
  
  public ContentFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void dispatchFitSystemWindows(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    if (this.mFixedHeightMajor == null) {
      this.mFixedHeightMajor = new TypedValue();
    }
    return this.mFixedHeightMajor;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (this.mFixedHeightMinor == null) {
      this.mFixedHeightMinor = new TypedValue();
    }
    return this.mFixedHeightMinor;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (this.mFixedWidthMajor == null) {
      this.mFixedWidthMajor = new TypedValue();
    }
    return this.mFixedWidthMajor;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (this.mFixedWidthMinor == null) {
      this.mFixedWidthMinor = new TypedValue();
    }
    return this.mFixedWidthMinor;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (this.mMinWidthMajor == null) {
      this.mMinWidthMajor = new TypedValue();
    }
    return this.mMinWidthMajor;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (this.mMinWidthMinor == null) {
      this.mMinWidthMinor = new TypedValue();
    }
    return this.mMinWidthMinor;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    OnAttachListener localOnAttachListener = this.mAttachListener;
    if (localOnAttachListener != null) {
      localOnAttachListener.onAttachedFromWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    OnAttachListener localOnAttachListener = this.mAttachListener;
    if (localOnAttachListener != null) {
      localOnAttachListener.onDetachedFromWindow();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    int k = 1;
    if (i < j) {
      i = 1;
    } else {
      i = 0;
    }
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    Object localObject;
    float f;
    if (m == Integer.MIN_VALUE)
    {
      if (i != 0) {
        localObject = this.mFixedWidthMinor;
      } else {
        localObject = this.mFixedWidthMajor;
      }
      if (localObject != null)
      {
        j = ((TypedValue)localObject).type;
        if (j != 0)
        {
          if (j == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(j, j))
          {
            j = (int)f;
            break label152;
            if (j != 6) {
              break;
            }
            j = localDisplayMetrics.widthPixels;
          }
          j = 0;
          label152:
          if (j > 0)
          {
            localObject = this.mDecorPadding;
            i1 = View.MeasureSpec.makeMeasureSpec(Math.min(j - (((Rect)localObject).left + ((Rect)localObject).right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
            paramInt1 = 1;
            break label205;
          }
        }
      }
    }
    j = 0;
    int i1 = paramInt1;
    paramInt1 = j;
    label205:
    j = paramInt2;
    if (n == Integer.MIN_VALUE)
    {
      if (i != 0) {
        localObject = this.mFixedHeightMajor;
      } else {
        localObject = this.mFixedHeightMinor;
      }
      j = paramInt2;
      if (localObject != null)
      {
        n = ((TypedValue)localObject).type;
        j = paramInt2;
        if (n != 0)
        {
          if (n == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(j, j))
          {
            n = (int)f;
            break label312;
            if (n != 6) {
              break;
            }
            j = localDisplayMetrics.heightPixels;
          }
          n = 0;
          label312:
          j = paramInt2;
          if (n > 0)
          {
            localObject = this.mDecorPadding;
            j = View.MeasureSpec.makeMeasureSpec(Math.min(n - (((Rect)localObject).top + ((Rect)localObject).bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
        }
      }
    }
    super.onMeasure(i1, j);
    n = getMeasuredWidth();
    i1 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
    if ((paramInt1 == 0) && (m == Integer.MIN_VALUE))
    {
      if (i != 0) {
        localObject = this.mMinWidthMinor;
      } else {
        localObject = this.mMinWidthMajor;
      }
      if (localObject != null)
      {
        paramInt1 = ((TypedValue)localObject).type;
        if (paramInt1 != 0)
        {
          if (paramInt1 == 5) {}
          for (f = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f = ((TypedValue)localObject).getFraction(paramInt1, paramInt1))
          {
            paramInt1 = (int)f;
            break label470;
            if (paramInt1 != 6) {
              break;
            }
            paramInt1 = localDisplayMetrics.widthPixels;
          }
          paramInt1 = 0;
          label470:
          paramInt2 = paramInt1;
          if (paramInt1 > 0)
          {
            localObject = this.mDecorPadding;
            paramInt2 = paramInt1 - (((Rect)localObject).left + ((Rect)localObject).right);
          }
          if (n < paramInt2)
          {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            paramInt2 = k;
            break label520;
          }
        }
      }
    }
    paramInt2 = 0;
    paramInt1 = i1;
    label520:
    if (paramInt2 != 0) {
      super.onMeasure(paramInt1, j);
    }
  }
  
  public void setAttachListener(OnAttachListener paramOnAttachListener)
  {
    this.mAttachListener = paramOnAttachListener;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setDecorPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDecorPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (ViewCompat.isLaidOut(this)) {
      requestLayout();
    }
  }
  
  public static abstract interface OnAttachListener
  {
    public abstract void onAttachedFromWindow();
    
    public abstract void onDetachedFromWindow();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ContentFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */