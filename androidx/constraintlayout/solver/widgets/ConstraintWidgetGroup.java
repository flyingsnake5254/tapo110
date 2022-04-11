package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup
{
  public List<ConstraintWidget> mConstrainedGroup;
  public final int[] mGroupDimensions = { -1, -1 };
  int mGroupHeight = -1;
  int mGroupWidth = -1;
  public boolean mSkipSolver = false;
  List<ConstraintWidget> mStartHorizontalWidgets = new ArrayList();
  List<ConstraintWidget> mStartVerticalWidgets = new ArrayList();
  List<ConstraintWidget> mUnresolvedWidgets = new ArrayList();
  HashSet<ConstraintWidget> mWidgetsToSetHorizontal = new HashSet();
  HashSet<ConstraintWidget> mWidgetsToSetVertical = new HashSet();
  List<ConstraintWidget> mWidgetsToSolve = new ArrayList();
  
  ConstraintWidgetGroup(List<ConstraintWidget> paramList)
  {
    this.mConstrainedGroup = paramList;
  }
  
  ConstraintWidgetGroup(List<ConstraintWidget> paramList, boolean paramBoolean)
  {
    this.mConstrainedGroup = paramList;
    this.mSkipSolver = paramBoolean;
  }
  
  private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> paramArrayList, ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mGroupsToSolver) {
      return;
    }
    paramArrayList.add(paramConstraintWidget);
    paramConstraintWidget.mGroupsToSolver = true;
    if (paramConstraintWidget.isFullyResolved()) {
      return;
    }
    boolean bool = paramConstraintWidget instanceof Helper;
    int i = 0;
    Object localObject;
    if (bool)
    {
      localObject = (Helper)paramConstraintWidget;
      j = ((Helper)localObject).mWidgetsCount;
      for (k = 0; k < j; k++) {
        getWidgetsToSolveTraversal(paramArrayList, localObject.mWidgets[k]);
      }
    }
    int j = paramConstraintWidget.mListAnchors.length;
    for (int k = i; k < j; k++)
    {
      localObject = paramConstraintWidget.mListAnchors[k].mTarget;
      if (localObject != null)
      {
        localObject = ((ConstraintAnchor)localObject).mOwner;
        if (localObject != paramConstraintWidget.getParent()) {
          getWidgetsToSolveTraversal(paramArrayList, (ConstraintWidget)localObject);
        }
      }
    }
  }
  
  private void updateResolvedDimension(ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mOptimizerMeasurable)
    {
      if (paramConstraintWidget.isFullyResolved()) {
        return;
      }
      Object localObject1 = paramConstraintWidget.mRight.mTarget;
      int i = 0;
      if (localObject1 != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0) {
        localObject1 = paramConstraintWidget.mLeft.mTarget;
      }
      if (localObject1 != null)
      {
        localObject2 = ((ConstraintAnchor)localObject1).mOwner;
        if (!((ConstraintWidget)localObject2).mOptimizerMeasured) {
          updateResolvedDimension((ConstraintWidget)localObject2);
        }
        localObject2 = ((ConstraintAnchor)localObject1).mType;
        if (localObject2 == ConstraintAnchor.Type.RIGHT)
        {
          localObject1 = ((ConstraintAnchor)localObject1).mOwner;
          k = ((ConstraintWidget)localObject1).mX + ((ConstraintWidget)localObject1).getWidth();
          break label134;
        }
        if (localObject2 == ConstraintAnchor.Type.LEFT)
        {
          k = ((ConstraintAnchor)localObject1).mOwner.mX;
          break label134;
        }
      }
      int k = 0;
      label134:
      if (j != 0) {
        k -= paramConstraintWidget.mRight.getMargin();
      } else {
        k += paramConstraintWidget.mLeft.getMargin() + paramConstraintWidget.getWidth();
      }
      paramConstraintWidget.setHorizontalDimension(k - paramConstraintWidget.getWidth(), k);
      Object localObject2 = paramConstraintWidget.mBaseline.mTarget;
      if (localObject2 != null)
      {
        localObject1 = ((ConstraintAnchor)localObject2).mOwner;
        if (!((ConstraintWidget)localObject1).mOptimizerMeasured) {
          updateResolvedDimension((ConstraintWidget)localObject1);
        }
        localObject1 = ((ConstraintAnchor)localObject2).mOwner;
        k = ((ConstraintWidget)localObject1).mY + ((ConstraintWidget)localObject1).mBaselineDistance - paramConstraintWidget.mBaselineDistance;
        paramConstraintWidget.setVerticalDimension(k, paramConstraintWidget.mHeight + k);
        paramConstraintWidget.mOptimizerMeasured = true;
        return;
      }
      localObject1 = paramConstraintWidget.mBottom.mTarget;
      if (localObject1 != null) {
        i = 1;
      }
      if (i == 0) {
        localObject1 = paramConstraintWidget.mTop.mTarget;
      }
      int j = k;
      if (localObject1 != null)
      {
        localObject2 = ((ConstraintAnchor)localObject1).mOwner;
        if (!((ConstraintWidget)localObject2).mOptimizerMeasured) {
          updateResolvedDimension((ConstraintWidget)localObject2);
        }
        localObject2 = ((ConstraintAnchor)localObject1).mType;
        if (localObject2 == ConstraintAnchor.Type.BOTTOM)
        {
          localObject1 = ((ConstraintAnchor)localObject1).mOwner;
          j = ((ConstraintWidget)localObject1).mY + ((ConstraintWidget)localObject1).getHeight();
        }
        else
        {
          j = k;
          if (localObject2 == ConstraintAnchor.Type.TOP) {
            j = ((ConstraintAnchor)localObject1).mOwner.mY;
          }
        }
      }
      if (i != 0) {
        k = j - paramConstraintWidget.mBottom.getMargin();
      } else {
        k = j + (paramConstraintWidget.mTop.getMargin() + paramConstraintWidget.getHeight());
      }
      paramConstraintWidget.setVerticalDimension(k - paramConstraintWidget.getHeight(), k);
      paramConstraintWidget.mOptimizerMeasured = true;
    }
  }
  
  void addWidgetsToSet(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0) {
      this.mWidgetsToSetHorizontal.add(paramConstraintWidget);
    } else if (paramInt == 1) {
      this.mWidgetsToSetVertical.add(paramConstraintWidget);
    }
  }
  
  public List<ConstraintWidget> getStartWidgets(int paramInt)
  {
    if (paramInt == 0) {
      return this.mStartHorizontalWidgets;
    }
    if (paramInt == 1) {
      return this.mStartVerticalWidgets;
    }
    return null;
  }
  
  Set<ConstraintWidget> getWidgetsToSet(int paramInt)
  {
    if (paramInt == 0) {
      return this.mWidgetsToSetHorizontal;
    }
    if (paramInt == 1) {
      return this.mWidgetsToSetVertical;
    }
    return null;
  }
  
  List<ConstraintWidget> getWidgetsToSolve()
  {
    if (!this.mWidgetsToSolve.isEmpty()) {
      return this.mWidgetsToSolve;
    }
    int i = this.mConstrainedGroup.size();
    for (int j = 0; j < i; j++)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mConstrainedGroup.get(j);
      if (!localConstraintWidget.mOptimizerMeasurable) {
        getWidgetsToSolveTraversal((ArrayList)this.mWidgetsToSolve, localConstraintWidget);
      }
    }
    this.mUnresolvedWidgets.clear();
    this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
    this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
    return this.mWidgetsToSolve;
  }
  
  void updateUnresolvedWidgets()
  {
    int i = this.mUnresolvedWidgets.size();
    for (int j = 0; j < i; j++) {
      updateResolvedDimension((ConstraintWidget)this.mUnresolvedWidgets.get(j));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ConstraintWidgetGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */