package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.solver.widgets.Helper;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class ConstraintHelper
  extends View
{
  protected int mCount;
  protected Helper mHelperWidget;
  protected int[] mIds = new int[32];
  private String mReferenceIds;
  protected boolean mUseViewMeasure = false;
  protected Context myContext;
  
  public ConstraintHelper(Context paramContext)
  {
    super(paramContext);
    this.myContext = paramContext;
    init(null);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.myContext = paramContext;
    init(paramAttributeSet);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.myContext = paramContext;
    init(paramAttributeSet);
  }
  
  private void addID(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (this.myContext == null) {
      return;
    }
    paramString = paramString.trim();
    try
    {
      i = R.id.class.getField(paramString).getInt(null);
    }
    catch (Exception localException)
    {
      i = 0;
    }
    int j = i;
    if (i == 0) {
      j = this.myContext.getResources().getIdentifier(paramString, "id", this.myContext.getPackageName());
    }
    int i = j;
    Object localObject;
    if (j == 0)
    {
      i = j;
      if (isInEditMode())
      {
        i = j;
        if ((getParent() instanceof ConstraintLayout))
        {
          localObject = ((ConstraintLayout)getParent()).getDesignInformation(0, paramString);
          i = j;
          if (localObject != null)
          {
            i = j;
            if ((localObject instanceof Integer)) {
              i = ((Integer)localObject).intValue();
            }
          }
        }
      }
    }
    if (i != 0)
    {
      setTag(i, null);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find id of \"");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\"");
      Log.w("ConstraintHelper", ((StringBuilder)localObject).toString());
    }
  }
  
  private void setIds(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int j;
    for (int i = 0;; i = j + 1)
    {
      j = paramString.indexOf(',', i);
      if (j == -1)
      {
        addID(paramString.substring(i));
        return;
      }
      addID(paramString.substring(i, j));
    }
  }
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(this.mIds, this.mCount);
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = localTypedArray.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = localTypedArray.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids)
        {
          paramAttributeSet = localTypedArray.getString(k);
          this.mReferenceIds = paramAttributeSet;
          setIds(paramAttributeSet);
        }
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mUseViewMeasure) {
      super.onMeasure(paramInt1, paramInt2);
    } else {
      setMeasuredDimension(0, 0);
    }
  }
  
  public void setReferencedIds(int[] paramArrayOfInt)
  {
    int i = 0;
    this.mCount = 0;
    while (i < paramArrayOfInt.length)
    {
      setTag(paramArrayOfInt[i], null);
      i++;
    }
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    int i = this.mCount;
    paramObject = this.mIds;
    if (i + 1 > paramObject.length) {
      this.mIds = Arrays.copyOf((int[])paramObject, paramObject.length * 2);
    }
    paramObject = this.mIds;
    i = this.mCount;
    paramObject[i] = paramInt;
    this.mCount = (i + 1);
  }
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePostMeasure(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(this.mReferenceIds);
    }
    Object localObject = this.mHelperWidget;
    if (localObject == null) {
      return;
    }
    ((Helper)localObject).removeAllIds();
    for (int i = 0; i < this.mCount; i++)
    {
      localObject = paramConstraintLayout.getViewById(this.mIds[i]);
      if (localObject != null) {
        this.mHelperWidget.add(paramConstraintLayout.getViewWidget((View)localObject));
      }
    }
  }
  
  public void validateParams()
  {
    if (this.mHelperWidget == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localLayoutParams instanceof ConstraintLayout.LayoutParams)) {
      ((ConstraintLayout.LayoutParams)localLayoutParams).widget = this.mHelperWidget;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\widget\ConstraintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */