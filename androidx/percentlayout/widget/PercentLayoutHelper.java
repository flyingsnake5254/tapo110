package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.percentlayout.R.styleable;

@Deprecated
public class PercentLayoutHelper
{
  private static final boolean DEBUG = false;
  private static final String TAG = "PercentLayout";
  private static final boolean VERBOSE = false;
  private final ViewGroup mHost;
  
  public PercentLayoutHelper(@NonNull ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      this.mHost = paramViewGroup;
      return;
    }
    throw new IllegalArgumentException("host must be non-null");
  }
  
  public static void fetchWidthAndHeight(ViewGroup.LayoutParams paramLayoutParams, TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    paramLayoutParams.width = paramTypedArray.getLayoutDimension(paramInt1, 0);
    paramLayoutParams.height = paramTypedArray.getLayoutDimension(paramInt2, 0);
  }
  
  public static PercentLayoutInfo getPercentLayoutInfo(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PercentLayout_Layout);
    float f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0F);
    if (f != -1.0F)
    {
      paramAttributeSet = new PercentLayoutInfo();
      paramAttributeSet.widthPercent = f;
    }
    else
    {
      paramAttributeSet = null;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0F);
    paramContext = paramAttributeSet;
    if (f != -1.0F)
    {
      if (paramAttributeSet != null) {
        paramContext = paramAttributeSet;
      } else {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.heightPercent = f;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0F);
    paramAttributeSet = paramContext;
    if (f != -1.0F)
    {
      if (paramContext == null) {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.leftMarginPercent = f;
      paramContext.topMarginPercent = f;
      paramContext.rightMarginPercent = f;
      paramContext.bottomMarginPercent = f;
      paramAttributeSet = paramContext;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0F);
    paramContext = paramAttributeSet;
    if (f != -1.0F)
    {
      if (paramAttributeSet != null) {
        paramContext = paramAttributeSet;
      } else {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.leftMarginPercent = f;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0F);
    paramAttributeSet = paramContext;
    if (f != -1.0F)
    {
      if (paramContext == null) {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.topMarginPercent = f;
      paramAttributeSet = paramContext;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0F);
    paramContext = paramAttributeSet;
    if (f != -1.0F)
    {
      if (paramAttributeSet != null) {
        paramContext = paramAttributeSet;
      } else {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.rightMarginPercent = f;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0F);
    paramAttributeSet = paramContext;
    if (f != -1.0F)
    {
      if (paramContext == null) {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.bottomMarginPercent = f;
      paramAttributeSet = paramContext;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0F);
    paramContext = paramAttributeSet;
    if (f != -1.0F)
    {
      if (paramAttributeSet != null) {
        paramContext = paramAttributeSet;
      } else {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.startMarginPercent = f;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0F);
    paramAttributeSet = paramContext;
    if (f != -1.0F)
    {
      if (paramContext == null) {
        paramContext = new PercentLayoutInfo();
      }
      paramContext.endMarginPercent = f;
      paramAttributeSet = paramContext;
    }
    f = localTypedArray.getFraction(R.styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0F);
    paramContext = paramAttributeSet;
    if (f != -1.0F)
    {
      if (paramAttributeSet == null) {
        paramAttributeSet = new PercentLayoutInfo();
      }
      paramAttributeSet.aspectRatio = f;
      paramContext = paramAttributeSet;
    }
    localTypedArray.recycle();
    return paramContext;
  }
  
  private static boolean shouldHandleMeasuredHeightTooSmall(View paramView, PercentLayoutInfo paramPercentLayoutInfo)
  {
    boolean bool;
    if (((paramView.getMeasuredHeightAndState() & 0xFF000000) == 16777216) && (paramPercentLayoutInfo.heightPercent >= 0.0F) && (paramPercentLayoutInfo.mPreservedParams.height == -2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean shouldHandleMeasuredWidthTooSmall(View paramView, PercentLayoutInfo paramPercentLayoutInfo)
  {
    boolean bool;
    if (((paramView.getMeasuredWidthAndState() & 0xFF000000) == 16777216) && (paramPercentLayoutInfo.widthPercent >= 0.0F) && (paramPercentLayoutInfo.mPreservedParams.width == -2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void adjustChildren(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1) - this.mHost.getPaddingLeft() - this.mHost.getPaddingRight();
    int j = View.MeasureSpec.getSize(paramInt2) - this.mHost.getPaddingTop() - this.mHost.getPaddingBottom();
    paramInt2 = this.mHost.getChildCount();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
    {
      View localView = this.mHost.getChildAt(paramInt1);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if ((localLayoutParams instanceof PercentLayoutParams))
      {
        PercentLayoutInfo localPercentLayoutInfo = ((PercentLayoutParams)localLayoutParams).getPercentLayoutInfo();
        if (localPercentLayoutInfo != null) {
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            localPercentLayoutInfo.fillMarginLayoutParams(localView, (ViewGroup.MarginLayoutParams)localLayoutParams, i, j);
          } else {
            localPercentLayoutInfo.fillLayoutParams(localLayoutParams, i, j);
          }
        }
      }
    }
  }
  
  public boolean handleMeasuredStateTooSmall()
  {
    int i = this.mHost.getChildCount();
    int j = 0;
    boolean bool2;
    for (boolean bool1 = false; j < i; bool1 = bool2)
    {
      View localView = this.mHost.getChildAt(j);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      bool2 = bool1;
      if ((localLayoutParams instanceof PercentLayoutParams))
      {
        PercentLayoutInfo localPercentLayoutInfo = ((PercentLayoutParams)localLayoutParams).getPercentLayoutInfo();
        bool2 = bool1;
        if (localPercentLayoutInfo != null)
        {
          bool2 = bool1;
          if (shouldHandleMeasuredWidthTooSmall(localView, localPercentLayoutInfo))
          {
            localLayoutParams.width = -2;
            bool2 = true;
          }
          if (shouldHandleMeasuredHeightTooSmall(localView, localPercentLayoutInfo))
          {
            localLayoutParams.height = -2;
            bool2 = true;
          }
        }
      }
      j++;
    }
    return bool1;
  }
  
  public void restoreOriginalParams()
  {
    int i = this.mHost.getChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewGroup.LayoutParams localLayoutParams = this.mHost.getChildAt(j).getLayoutParams();
      if ((localLayoutParams instanceof PercentLayoutParams))
      {
        PercentLayoutInfo localPercentLayoutInfo = ((PercentLayoutParams)localLayoutParams).getPercentLayoutInfo();
        if (localPercentLayoutInfo != null) {
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            localPercentLayoutInfo.restoreMarginLayoutParams((ViewGroup.MarginLayoutParams)localLayoutParams);
          } else {
            localPercentLayoutInfo.restoreLayoutParams(localLayoutParams);
          }
        }
      }
    }
  }
  
  @Deprecated
  public static class PercentLayoutInfo
  {
    public float aspectRatio;
    public float bottomMarginPercent = -1.0F;
    public float endMarginPercent = -1.0F;
    public float heightPercent = -1.0F;
    public float leftMarginPercent = -1.0F;
    final PercentLayoutHelper.PercentMarginLayoutParams mPreservedParams = new PercentLayoutHelper.PercentMarginLayoutParams(0, 0);
    public float rightMarginPercent = -1.0F;
    public float startMarginPercent = -1.0F;
    public float topMarginPercent = -1.0F;
    public float widthPercent = -1.0F;
    
    public void fillLayoutParams(ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
    {
      PercentLayoutHelper.PercentMarginLayoutParams localPercentMarginLayoutParams = this.mPreservedParams;
      int i = paramLayoutParams.width;
      localPercentMarginLayoutParams.width = i;
      int j = paramLayoutParams.height;
      localPercentMarginLayoutParams.height = j;
      boolean bool = localPercentMarginLayoutParams.mIsWidthComputedFromAspectRatio;
      int k = 0;
      if (((bool) || (i == 0)) && (this.widthPercent < 0.0F)) {
        i = 1;
      } else {
        i = 0;
      }
      int m;
      if (!localPercentMarginLayoutParams.mIsHeightComputedFromAspectRatio)
      {
        m = k;
        if (j != 0) {}
      }
      else
      {
        m = k;
        if (this.heightPercent < 0.0F) {
          m = 1;
        }
      }
      float f = this.widthPercent;
      if (f >= 0.0F) {
        paramLayoutParams.width = Math.round(paramInt1 * f);
      }
      f = this.heightPercent;
      if (f >= 0.0F) {
        paramLayoutParams.height = Math.round(paramInt2 * f);
      }
      f = this.aspectRatio;
      if (f >= 0.0F)
      {
        if (i != 0)
        {
          paramLayoutParams.width = Math.round(paramLayoutParams.height * f);
          this.mPreservedParams.mIsWidthComputedFromAspectRatio = true;
        }
        if (m != 0)
        {
          paramLayoutParams.height = Math.round(paramLayoutParams.width / this.aspectRatio);
          this.mPreservedParams.mIsHeightComputedFromAspectRatio = true;
        }
      }
    }
    
    public void fillMarginLayoutParams(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt1, int paramInt2)
    {
      fillLayoutParams(paramMarginLayoutParams, paramInt1, paramInt2);
      PercentLayoutHelper.PercentMarginLayoutParams localPercentMarginLayoutParams = this.mPreservedParams;
      localPercentMarginLayoutParams.leftMargin = paramMarginLayoutParams.leftMargin;
      localPercentMarginLayoutParams.topMargin = paramMarginLayoutParams.topMargin;
      localPercentMarginLayoutParams.rightMargin = paramMarginLayoutParams.rightMargin;
      localPercentMarginLayoutParams.bottomMargin = paramMarginLayoutParams.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(localPercentMarginLayoutParams, MarginLayoutParamsCompat.getMarginStart(paramMarginLayoutParams));
      MarginLayoutParamsCompat.setMarginEnd(this.mPreservedParams, MarginLayoutParamsCompat.getMarginEnd(paramMarginLayoutParams));
      float f = this.leftMarginPercent;
      if (f >= 0.0F) {
        paramMarginLayoutParams.leftMargin = Math.round(paramInt1 * f);
      }
      f = this.topMarginPercent;
      if (f >= 0.0F) {
        paramMarginLayoutParams.topMargin = Math.round(paramInt2 * f);
      }
      f = this.rightMarginPercent;
      if (f >= 0.0F) {
        paramMarginLayoutParams.rightMargin = Math.round(paramInt1 * f);
      }
      f = this.bottomMarginPercent;
      if (f >= 0.0F) {
        paramMarginLayoutParams.bottomMargin = Math.round(paramInt2 * f);
      }
      paramInt2 = 0;
      f = this.startMarginPercent;
      int i = 1;
      if (f >= 0.0F)
      {
        MarginLayoutParamsCompat.setMarginStart(paramMarginLayoutParams, Math.round(paramInt1 * f));
        paramInt2 = 1;
      }
      f = this.endMarginPercent;
      if (f >= 0.0F)
      {
        MarginLayoutParamsCompat.setMarginEnd(paramMarginLayoutParams, Math.round(paramInt1 * f));
        paramInt2 = i;
      }
      if ((paramInt2 != 0) && (paramView != null)) {
        MarginLayoutParamsCompat.resolveLayoutDirection(paramMarginLayoutParams, ViewCompat.getLayoutDirection(paramView));
      }
    }
    
    @Deprecated
    public void fillMarginLayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt1, int paramInt2)
    {
      fillMarginLayoutParams(null, paramMarginLayoutParams, paramInt1, paramInt2);
    }
    
    public void restoreLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      PercentLayoutHelper.PercentMarginLayoutParams localPercentMarginLayoutParams = this.mPreservedParams;
      if (!localPercentMarginLayoutParams.mIsWidthComputedFromAspectRatio) {
        paramLayoutParams.width = localPercentMarginLayoutParams.width;
      }
      if (!localPercentMarginLayoutParams.mIsHeightComputedFromAspectRatio) {
        paramLayoutParams.height = localPercentMarginLayoutParams.height;
      }
      localPercentMarginLayoutParams.mIsWidthComputedFromAspectRatio = false;
      localPercentMarginLayoutParams.mIsHeightComputedFromAspectRatio = false;
    }
    
    public void restoreMarginLayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      restoreLayoutParams(paramMarginLayoutParams);
      PercentLayoutHelper.PercentMarginLayoutParams localPercentMarginLayoutParams = this.mPreservedParams;
      paramMarginLayoutParams.leftMargin = localPercentMarginLayoutParams.leftMargin;
      paramMarginLayoutParams.topMargin = localPercentMarginLayoutParams.topMargin;
      paramMarginLayoutParams.rightMargin = localPercentMarginLayoutParams.rightMargin;
      paramMarginLayoutParams.bottomMargin = localPercentMarginLayoutParams.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(paramMarginLayoutParams, MarginLayoutParamsCompat.getMarginStart(localPercentMarginLayoutParams));
      MarginLayoutParamsCompat.setMarginEnd(paramMarginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.mPreservedParams));
    }
    
    public String toString()
    {
      return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[] { Float.valueOf(this.widthPercent), Float.valueOf(this.heightPercent), Float.valueOf(this.leftMarginPercent), Float.valueOf(this.topMarginPercent), Float.valueOf(this.rightMarginPercent), Float.valueOf(this.bottomMarginPercent), Float.valueOf(this.startMarginPercent), Float.valueOf(this.endMarginPercent) });
    }
  }
  
  @Deprecated
  public static abstract interface PercentLayoutParams
  {
    public abstract PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo();
  }
  
  static class PercentMarginLayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    boolean mIsHeightComputedFromAspectRatio;
    boolean mIsWidthComputedFromAspectRatio;
    
    public PercentMarginLayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\percentlayout\widget\PercentLayoutHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */