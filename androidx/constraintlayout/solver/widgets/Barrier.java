package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class Barrier
  extends Helper
{
  public static final int BOTTOM = 3;
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int TOP = 2;
  private boolean mAllowsGoneWidget = true;
  private int mBarrierType = 0;
  private ArrayList<ResolutionAnchor> mNodes = new ArrayList(4);
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    Object localObject1 = this.mListAnchors;
    localObject1[0] = this.mLeft;
    localObject1[2] = this.mTop;
    localObject1[1] = this.mRight;
    localObject1[3] = this.mBottom;
    for (int i = 0;; i++)
    {
      localObject1 = this.mListAnchors;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i].mSolverVariable = paramLinearSystem.createObjectVariable(localObject1[i]);
    }
    i = this.mBarrierType;
    if ((i >= 0) && (i < 4))
    {
      localObject1 = localObject1[i];
      Object localObject2;
      int j;
      for (i = 0; i < this.mWidgetsCount; i++)
      {
        localObject2 = this.mWidgets[i];
        if ((this.mAllowsGoneWidget) || (((ConstraintWidget)localObject2).allowedInBarrier()))
        {
          j = this.mBarrierType;
          if (((j == 0) || (j == 1)) && (((ConstraintWidget)localObject2).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {}
          do
          {
            bool = true;
            break;
            j = this.mBarrierType;
          } while (((j == 2) || (j == 3)) && (((ConstraintWidget)localObject2).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT));
        }
      }
      boolean bool = false;
      i = this.mBarrierType;
      if ((i != 0) && (i != 1) ? getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        bool = false;
      }
      for (i = 0; i < this.mWidgetsCount; i++)
      {
        Object localObject3 = this.mWidgets[i];
        if ((this.mAllowsGoneWidget) || (((ConstraintWidget)localObject3).allowedInBarrier()))
        {
          localObject2 = paramLinearSystem.createObjectVariable(localObject3.mListAnchors[this.mBarrierType]);
          localObject3 = ((ConstraintWidget)localObject3).mListAnchors;
          j = this.mBarrierType;
          localObject3[j].mSolverVariable = ((SolverVariable)localObject2);
          if ((j != 0) && (j != 2)) {
            paramLinearSystem.addGreaterBarrier(((ConstraintAnchor)localObject1).mSolverVariable, (SolverVariable)localObject2, bool);
          } else {
            paramLinearSystem.addLowerBarrier(((ConstraintAnchor)localObject1).mSolverVariable, (SolverVariable)localObject2, bool);
          }
        }
      }
      i = this.mBarrierType;
      if (i == 0)
      {
        paramLinearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 5);
        }
      }
      else if (i == 1)
      {
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 5);
        }
      }
      else if (i == 2)
      {
        paramLinearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 5);
        }
      }
      else if (i == 3)
      {
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 5);
        }
      }
    }
  }
  
  public boolean allowedInBarrier()
  {
    return true;
  }
  
  public boolean allowsGoneWidget()
  {
    return this.mAllowsGoneWidget;
  }
  
  public void analyze(int paramInt)
  {
    Object localObject = this.mParent;
    if (localObject == null) {
      return;
    }
    if (!((ConstraintWidgetContainer)localObject).optimizeFor(2)) {
      return;
    }
    paramInt = this.mBarrierType;
    ResolutionAnchor localResolutionAnchor;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          localResolutionAnchor = this.mBottom.getResolutionNode();
        }
        else
        {
          localResolutionAnchor = this.mTop.getResolutionNode();
        }
      }
      else {
        localResolutionAnchor = this.mRight.getResolutionNode();
      }
    }
    else {
      localResolutionAnchor = this.mLeft.getResolutionNode();
    }
    localResolutionAnchor.setType(5);
    paramInt = this.mBarrierType;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.mLeft.getResolutionNode().resolve(null, 0.0F);
      this.mRight.getResolutionNode().resolve(null, 0.0F);
    }
    else
    {
      this.mTop.getResolutionNode().resolve(null, 0.0F);
      this.mBottom.getResolutionNode().resolve(null, 0.0F);
    }
    this.mNodes.clear();
    for (paramInt = 0; paramInt < this.mWidgetsCount; paramInt++)
    {
      localObject = this.mWidgets[paramInt];
      if ((this.mAllowsGoneWidget) || (((ConstraintWidget)localObject).allowedInBarrier()))
      {
        int i = this.mBarrierType;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                localObject = null;
              } else {
                localObject = ((ConstraintWidget)localObject).mBottom.getResolutionNode();
              }
            }
            else {
              localObject = ((ConstraintWidget)localObject).mTop.getResolutionNode();
            }
          }
          else {
            localObject = ((ConstraintWidget)localObject).mRight.getResolutionNode();
          }
        }
        else {
          localObject = ((ConstraintWidget)localObject).mLeft.getResolutionNode();
        }
        if (localObject != null)
        {
          this.mNodes.add(localObject);
          ((ResolutionNode)localObject).addDependent(localResolutionAnchor);
        }
      }
    }
  }
  
  public void resetResolutionNodes()
  {
    super.resetResolutionNodes();
    this.mNodes.clear();
  }
  
  public void resolve()
  {
    int i = this.mBarrierType;
    float f1 = Float.MAX_VALUE;
    ResolutionAnchor localResolutionAnchor1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          localResolutionAnchor1 = this.mBottom.getResolutionNode();
        }
        else
        {
          localResolutionAnchor1 = this.mTop.getResolutionNode();
          break label71;
        }
      }
      else {
        localResolutionAnchor1 = this.mRight.getResolutionNode();
      }
      f1 = 0.0F;
    }
    else
    {
      localResolutionAnchor1 = this.mLeft.getResolutionNode();
    }
    label71:
    int j = this.mNodes.size();
    ResolutionAnchor localResolutionAnchor2 = null;
    i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = (ResolutionAnchor)this.mNodes.get(i);
      if (((ResolutionNode)localObject).state != 1) {
        return;
      }
      int k = this.mBarrierType;
      float f2;
      if ((k != 0) && (k != 2))
      {
        f2 = ((ResolutionAnchor)localObject).resolvedOffset;
        f3 = f1;
        if (f2 <= f1) {
          break label194;
        }
        localResolutionAnchor2 = ((ResolutionAnchor)localObject).resolvedTarget;
        f1 = f2;
      }
      else
      {
        f2 = ((ResolutionAnchor)localObject).resolvedOffset;
        f3 = f1;
        if (f2 >= f1) {
          break label194;
        }
        localResolutionAnchor2 = ((ResolutionAnchor)localObject).resolvedTarget;
        f1 = f2;
      }
      float f3 = f1;
      label194:
      i++;
      f1 = f3;
    }
    if (LinearSystem.getMetrics() != null)
    {
      localObject = LinearSystem.getMetrics();
      ((Metrics)localObject).barrierConnectionResolved += 1L;
    }
    localResolutionAnchor1.resolvedTarget = localResolutionAnchor2;
    localResolutionAnchor1.resolvedOffset = f1;
    localResolutionAnchor1.didResolve();
    i = this.mBarrierType;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          this.mTop.getResolutionNode().resolve(localResolutionAnchor2, f1);
        }
        else
        {
          this.mBottom.getResolutionNode().resolve(localResolutionAnchor2, f1);
        }
      }
      else {
        this.mLeft.getResolutionNode().resolve(localResolutionAnchor2, f1);
      }
    }
    else {
      this.mRight.getResolutionNode().resolve(localResolutionAnchor2, f1);
    }
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.mAllowsGoneWidget = paramBoolean;
  }
  
  public void setBarrierType(int paramInt)
  {
    this.mBarrierType = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\Barrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */