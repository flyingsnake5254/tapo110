package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout
  extends LinearLayout
  implements ContentViewCallback
{
  private Button actionView;
  private int maxInlineActionWidth;
  private int maxWidth;
  private TextView messageView;
  
  public SnackbarContentLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    this.maxWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
    this.maxInlineActionWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
  }
  
  private static void updateTopBottomPadding(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.isPaddingRelative(paramView)) {
      ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
    } else {
      paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
    }
  }
  
  private boolean updateViewsWithinLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getOrientation();
    boolean bool1 = true;
    if (paramInt1 != i)
    {
      setOrientation(paramInt1);
      bool2 = true;
    }
    else
    {
      bool2 = false;
    }
    if ((this.messageView.getPaddingTop() == paramInt2) && (this.messageView.getPaddingBottom() == paramInt3)) {
      break label70;
    }
    updateTopBottomPadding(this.messageView, paramInt2, paramInt3);
    boolean bool2 = bool1;
    label70:
    return bool2;
  }
  
  public void animateContentIn(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.messageView.animate().alpha(1.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(0.0F);
      this.actionView.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public void animateContentOut(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.messageView.animate().alpha(0.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(1.0F);
      this.actionView.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public Button getActionView()
  {
    return this.actionView;
  }
  
  public TextView getMessageView()
  {
    return this.messageView;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.messageView = ((TextView)findViewById(R.id.snackbar_text));
    this.actionView = ((Button)findViewById(R.id.snackbar_action));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.maxWidth > 0)
    {
      j = getMeasuredWidth();
      k = this.maxWidth;
      i = paramInt1;
      if (j > k)
      {
        i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int k = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    int m = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    paramInt1 = this.messageView.getLayout().getLineCount();
    int j = 0;
    if (paramInt1 > 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (this.maxInlineActionWidth > 0) && (this.actionView.getMeasuredWidth() > this.maxInlineActionWidth))
    {
      paramInt1 = j;
      if (!updateViewsWithinLayout(1, k, k - m)) {
        break label174;
      }
    }
    else
    {
      if (paramInt1 == 0) {
        k = m;
      }
      paramInt1 = j;
      if (!updateViewsWithinLayout(0, k, k)) {
        break label174;
      }
    }
    paramInt1 = 1;
    label174:
    if (paramInt1 != 0) {
      super.onMeasure(i, paramInt2);
    }
  }
  
  public void setMaxInlineActionWidth(int paramInt)
  {
    this.maxInlineActionWidth = paramInt;
  }
  
  void updateActionTextColorAlphaIfNeeded(float paramFloat)
  {
    if (paramFloat != 1.0F)
    {
      int i = this.actionView.getCurrentTextColor();
      i = MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), i, paramFloat);
      this.actionView.setTextColor(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\snackbar\SnackbarContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */