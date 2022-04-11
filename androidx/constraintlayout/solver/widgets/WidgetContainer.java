package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer
  extends ConstraintWidget
{
  protected ArrayList<ConstraintWidget> mChildren = new ArrayList();
  
  public WidgetContainer() {}
  
  public WidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public WidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static Rectangle getBounds(ArrayList<ConstraintWidget> paramArrayList)
  {
    Rectangle localRectangle = new Rectangle();
    if (paramArrayList.size() == 0) {
      return localRectangle;
    }
    int i = paramArrayList.size();
    int j = Integer.MAX_VALUE;
    int k = Integer.MAX_VALUE;
    int m = 0;
    int n = 0;
    int i5;
    for (int i1 = 0; m < i; i1 = i5)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramArrayList.get(m);
      int i2 = j;
      if (localConstraintWidget.getX() < j) {
        i2 = localConstraintWidget.getX();
      }
      int i3 = k;
      if (localConstraintWidget.getY() < k) {
        i3 = localConstraintWidget.getY();
      }
      int i4 = n;
      if (localConstraintWidget.getRight() > n) {
        i4 = localConstraintWidget.getRight();
      }
      i5 = i1;
      if (localConstraintWidget.getBottom() > i1) {
        i5 = localConstraintWidget.getBottom();
      }
      m++;
      j = i2;
      k = i3;
      n = i4;
    }
    localRectangle.setBounds(j, k, n - j, i1 - k);
    return localRectangle;
  }
  
  public void add(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.add(paramConstraintWidget);
    if (paramConstraintWidget.getParent() != null) {
      ((WidgetContainer)paramConstraintWidget.getParent()).remove(paramConstraintWidget);
    }
    paramConstraintWidget.setParent(this);
  }
  
  public void add(ConstraintWidget... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      add(paramVarArgs[j]);
    }
  }
  
  public ConstraintWidget findWidget(float paramFloat1, float paramFloat2)
  {
    int i = getDrawX();
    int j = getDrawY();
    int k = getWidth();
    int m = getHeight();
    Object localObject1;
    if ((paramFloat1 >= i) && (paramFloat1 <= k + i) && (paramFloat2 >= j) && (paramFloat2 <= m + j)) {
      localObject1 = this;
    } else {
      localObject1 = null;
    }
    i = 0;
    k = this.mChildren.size();
    for (Object localObject2 = localObject1; i < k; localObject2 = localObject1)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof WidgetContainer))
      {
        localConstraintWidget = ((WidgetContainer)localConstraintWidget).findWidget(paramFloat1, paramFloat2);
        localObject1 = localObject2;
        if (localConstraintWidget != null) {
          localObject1 = localConstraintWidget;
        }
      }
      else
      {
        j = localConstraintWidget.getDrawX();
        int n = localConstraintWidget.getDrawY();
        int i1 = localConstraintWidget.getWidth();
        m = localConstraintWidget.getHeight();
        localObject1 = localObject2;
        if (paramFloat1 >= j)
        {
          localObject1 = localObject2;
          if (paramFloat1 <= i1 + j)
          {
            localObject1 = localObject2;
            if (paramFloat2 >= n)
            {
              localObject1 = localObject2;
              if (paramFloat2 <= m + n) {
                localObject1 = localConstraintWidget;
              }
            }
          }
        }
      }
      i++;
    }
    return (ConstraintWidget)localObject2;
  }
  
  public ArrayList<ConstraintWidget> findWidgets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    Rectangle localRectangle1 = new Rectangle();
    localRectangle1.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.mChildren.size();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(paramInt1);
      Rectangle localRectangle2 = new Rectangle();
      localRectangle2.setBounds(localConstraintWidget.getDrawX(), localConstraintWidget.getDrawY(), localConstraintWidget.getWidth(), localConstraintWidget.getHeight());
      if (localRectangle1.intersects(localRectangle2)) {
        localArrayList.add(localConstraintWidget);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<ConstraintWidget> getChildren()
  {
    return this.mChildren;
  }
  
  public ConstraintWidgetContainer getRootConstraintContainer()
  {
    Object localObject = getParent();
    ConstraintWidgetContainer localConstraintWidgetContainer;
    if ((this instanceof ConstraintWidgetContainer)) {
      localConstraintWidgetContainer = (ConstraintWidgetContainer)this;
    } else {
      localConstraintWidgetContainer = null;
    }
    while (localObject != null)
    {
      ConstraintWidget localConstraintWidget = ((ConstraintWidget)localObject).getParent();
      if ((localObject instanceof ConstraintWidgetContainer)) {
        localConstraintWidgetContainer = (ConstraintWidgetContainer)localObject;
      }
      localObject = localConstraintWidget;
    }
    return localConstraintWidgetContainer;
  }
  
  public void layout()
  {
    updateDrawPosition();
    Object localObject = this.mChildren;
    if (localObject == null) {
      return;
    }
    int i = ((ArrayList)localObject).size();
    for (int j = 0; j < i; j++)
    {
      localObject = (ConstraintWidget)this.mChildren.get(j);
      if ((localObject instanceof WidgetContainer)) {
        ((WidgetContainer)localObject).layout();
      }
    }
  }
  
  public void remove(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.remove(paramConstraintWidget);
    paramConstraintWidget.setParent(null);
  }
  
  public void removeAllChildren()
  {
    this.mChildren.clear();
  }
  
  public void reset()
  {
    this.mChildren.clear();
    super.reset();
  }
  
  public void resetSolverVariables(Cache paramCache)
  {
    super.resetSolverVariables(paramCache);
    int i = this.mChildren.size();
    for (int j = 0; j < i; j++) {
      ((ConstraintWidget)this.mChildren.get(j)).resetSolverVariables(paramCache);
    }
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    super.setOffset(paramInt1, paramInt2);
    paramInt2 = this.mChildren.size();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      ((ConstraintWidget)this.mChildren.get(paramInt1)).setOffset(getRootX(), getRootY());
    }
  }
  
  public void updateDrawPosition()
  {
    super.updateDrawPosition();
    Object localObject = this.mChildren;
    if (localObject == null) {
      return;
    }
    int i = ((ArrayList)localObject).size();
    for (int j = 0; j < i; j++)
    {
      localObject = (ConstraintWidget)this.mChildren.get(j);
      ((ConstraintWidget)localObject).setOffset(getDrawX(), getDrawY());
      if (!(localObject instanceof ConstraintWidgetContainer)) {
        ((ConstraintWidget)localObject).updateDrawPosition();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\WidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */