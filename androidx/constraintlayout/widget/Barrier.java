package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

public class Barrier
  extends ConstraintHelper
{
  public static final int BOTTOM = 3;
  public static final int END = 6;
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int START = 5;
  public static final int TOP = 2;
  private androidx.constraintlayout.solver.widgets.Barrier mBarrier;
  private int mIndicatedType;
  private int mResolvedType;
  
  public Barrier(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setVisibility(8);
  }
  
  public boolean allowsGoneWidget()
  {
    return this.mBarrier.allowsGoneWidget();
  }
  
  public int getType()
  {
    return this.mIndicatedType;
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    this.mBarrier = new androidx.constraintlayout.solver.widgets.Barrier();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = paramAttributeSet.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = paramAttributeSet.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_barrierDirection) {
          setType(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
          this.mBarrier.setAllowsGoneWidget(paramAttributeSet.getBoolean(k, true));
        }
      }
    }
    this.mHelperWidget = this.mBarrier;
    validateParams();
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.mBarrier.setAllowsGoneWidget(paramBoolean);
  }
  
  public void setType(int paramInt)
  {
    this.mIndicatedType = paramInt;
    this.mResolvedType = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      if (paramInt == 5) {
        this.mResolvedType = 0;
      } else if (paramInt == 6) {
        this.mResolvedType = 1;
      }
    }
    else
    {
      if (1 == getResources().getConfiguration().getLayoutDirection()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        paramInt = this.mIndicatedType;
        if (paramInt == 5) {
          this.mResolvedType = 1;
        } else if (paramInt == 6) {
          this.mResolvedType = 0;
        }
      }
      else
      {
        paramInt = this.mIndicatedType;
        if (paramInt == 5) {
          this.mResolvedType = 0;
        } else if (paramInt == 6) {
          this.mResolvedType = 1;
        }
      }
    }
    this.mBarrier.setBarrierType(this.mResolvedType);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\widget\Barrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */