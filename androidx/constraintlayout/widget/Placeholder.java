package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Placeholder
  extends View
{
  private View mContent = null;
  private int mContentId = -1;
  private int mEmptyVisibility = 4;
  
  public Placeholder(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    init(paramAttributeSet);
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    super.setVisibility(this.mEmptyVisibility);
    this.mContentId = -1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_placeholder);
      int i = paramAttributeSet.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = paramAttributeSet.getIndex(j);
        if (k == R.styleable.ConstraintLayout_placeholder_content) {
          this.mContentId = paramAttributeSet.getResourceId(k, this.mContentId);
        } else if (k == R.styleable.ConstraintLayout_placeholder_emptyVisibility) {
          this.mEmptyVisibility = paramAttributeSet.getInt(k, this.mEmptyVisibility);
        }
      }
    }
  }
  
  public View getContent()
  {
    return this.mContent;
  }
  
  public int getEmptyVisibility()
  {
    return this.mEmptyVisibility;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (isInEditMode())
    {
      paramCanvas.drawRGB(223, 223, 223);
      Paint localPaint = new Paint();
      localPaint.setARGB(255, 210, 210, 210);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect localRect = new Rect();
      paramCanvas.getClipBounds(localRect);
      localPaint.setTextSize(localRect.height());
      int i = localRect.height();
      int j = localRect.width();
      localPaint.setTextAlign(Paint.Align.LEFT);
      localPaint.getTextBounds("?", 0, 1, localRect);
      paramCanvas.drawText("?", j / 2.0F - localRect.width() / 2.0F - localRect.left, i / 2.0F + localRect.height() / 2.0F - localRect.bottom, localPaint);
    }
  }
  
  public void setContentId(int paramInt)
  {
    if (this.mContentId == paramInt) {
      return;
    }
    View localView = this.mContent;
    if (localView != null)
    {
      localView.setVisibility(0);
      ((ConstraintLayout.LayoutParams)this.mContent.getLayoutParams()).isInPlaceholder = false;
      this.mContent = null;
    }
    this.mContentId = paramInt;
    if (paramInt != -1)
    {
      localView = ((View)getParent()).findViewById(paramInt);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void setEmptyVisibility(int paramInt)
  {
    this.mEmptyVisibility = paramInt;
  }
  
  public void updatePostMeasure(ConstraintLayout paramConstraintLayout)
  {
    if (this.mContent == null) {
      return;
    }
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.mContent.getLayoutParams();
    localLayoutParams.widget.setVisibility(0);
    paramConstraintLayout.widget.setWidth(localLayoutParams.widget.getWidth());
    paramConstraintLayout.widget.setHeight(localLayoutParams.widget.getHeight());
    localLayoutParams.widget.setVisibility(8);
  }
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout)
  {
    if ((this.mContentId == -1) && (!isInEditMode())) {
      setVisibility(this.mEmptyVisibility);
    }
    paramConstraintLayout = paramConstraintLayout.findViewById(this.mContentId);
    this.mContent = paramConstraintLayout;
    if (paramConstraintLayout != null)
    {
      ((ConstraintLayout.LayoutParams)paramConstraintLayout.getLayoutParams()).isInPlaceholder = true;
      this.mContent.setVisibility(0);
      setVisibility(0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\widget\Placeholder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */