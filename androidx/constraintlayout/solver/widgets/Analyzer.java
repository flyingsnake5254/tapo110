package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Analyzer
{
  public static void determineGroups(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    if ((paramConstraintWidgetContainer.getOptimizationLevel() & 0x20) != 32)
    {
      singleGroup(paramConstraintWidgetContainer);
      return;
    }
    paramConstraintWidgetContainer.mSkipSolver = true;
    paramConstraintWidgetContainer.mGroupsWrapOptimized = false;
    paramConstraintWidgetContainer.mHorizontalWrapOptimized = false;
    paramConstraintWidgetContainer.mVerticalWrapOptimized = false;
    Object localObject1 = paramConstraintWidgetContainer.mChildren;
    List localList = paramConstraintWidgetContainer.mWidgetGroups;
    Object localObject2 = paramConstraintWidgetContainer.getHorizontalDimensionBehaviour();
    Object localObject3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    int i;
    if (localObject2 == localObject3) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramConstraintWidgetContainer.getVerticalDimensionBehaviour() == localObject3) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool;
    if ((i == 0) && (j == 0)) {
      bool = false;
    } else {
      bool = true;
    }
    localList.clear();
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ConstraintWidget)((Iterator)localObject2).next();
      ((ConstraintWidget)localObject3).mBelongingGroup = null;
      ((ConstraintWidget)localObject3).mGroupsToSolver = false;
      ((ConstraintWidget)localObject3).resetResolutionNodes();
    }
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (ConstraintWidget)((Iterator)localObject2).next();
      if ((((ConstraintWidget)localObject1).mBelongingGroup == null) && (!determineGroups((ConstraintWidget)localObject1, localList, bool)))
      {
        singleGroup(paramConstraintWidgetContainer);
        paramConstraintWidgetContainer.mSkipSolver = false;
        return;
      }
    }
    localObject2 = localList.iterator();
    int k = 0;
    for (int m = 0; ((Iterator)localObject2).hasNext(); m = Math.max(m, getMaxDimension((ConstraintWidgetGroup)localObject1, 1)))
    {
      localObject1 = (ConstraintWidgetGroup)((Iterator)localObject2).next();
      k = Math.max(k, getMaxDimension((ConstraintWidgetGroup)localObject1, 0));
    }
    if (i != 0)
    {
      paramConstraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setWidth(k);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mHorizontalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedWidth = k;
    }
    if (j != 0)
    {
      paramConstraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setHeight(m);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mVerticalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedHeight = m;
    }
    setPosition(localList, 0, paramConstraintWidgetContainer.getWidth());
    setPosition(localList, 1, paramConstraintWidgetContainer.getHeight());
  }
  
  private static boolean determineGroups(ConstraintWidget paramConstraintWidget, List<ConstraintWidgetGroup> paramList, boolean paramBoolean)
  {
    ConstraintWidgetGroup localConstraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
    paramList.add(localConstraintWidgetGroup);
    return traverse(paramConstraintWidget, localConstraintWidgetGroup, paramList, paramBoolean);
  }
  
  private static int getMaxDimension(ConstraintWidgetGroup paramConstraintWidgetGroup, int paramInt)
  {
    int i = paramInt * 2;
    List localList = paramConstraintWidgetGroup.getStartWidgets(paramInt);
    int j = localList.size();
    int k = 0;
    int m = 0;
    while (k < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localList.get(k);
      ConstraintAnchor[] arrayOfConstraintAnchor = localConstraintWidget.mListAnchors;
      int n = i + 1;
      boolean bool;
      if ((arrayOfConstraintAnchor[n].mTarget != null) && ((arrayOfConstraintAnchor[i].mTarget == null) || (arrayOfConstraintAnchor[n].mTarget == null))) {
        bool = false;
      } else {
        bool = true;
      }
      m = Math.max(m, getMaxDimensionTraversal(localConstraintWidget, paramInt, bool, 0));
      k++;
    }
    paramConstraintWidgetGroup.mGroupDimensions[paramInt] = m;
    return m;
  }
  
  private static int getMaxDimensionTraversal(ConstraintWidget paramConstraintWidget, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = paramConstraintWidget.mOptimizerMeasurable;
    int i = 0;
    if (!bool) {
      return 0;
    }
    if ((paramConstraintWidget.mBaseline.mTarget != null) && (paramInt1 == 1)) {
      j = 1;
    } else {
      j = 0;
    }
    int n;
    int i1;
    if (paramBoolean)
    {
      k = paramConstraintWidget.getBaselineDistance();
      m = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      n = paramInt1 * 2;
      i1 = n + 1;
    }
    else
    {
      k = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      m = paramConstraintWidget.getBaselineDistance();
      i1 = paramInt1 * 2;
      n = i1 + 1;
    }
    Object localObject1 = paramConstraintWidget.mListAnchors;
    int i3;
    if ((localObject1[i1].mTarget != null) && (localObject1[n].mTarget == null))
    {
      i2 = -1;
      i3 = n;
      n = i1;
      i1 = i3;
      i3 = i2;
    }
    else
    {
      i3 = 1;
    }
    if (j != 0) {
      paramInt2 -= k;
    }
    int i4 = localObject1[n].getMargin() * i3 + getParentBiasOffset(paramConstraintWidget, paramInt1);
    int i2 = paramInt2 + i4;
    if (paramInt1 == 0) {
      paramInt2 = paramConstraintWidget.getWidth();
    } else {
      paramInt2 = paramConstraintWidget.getHeight();
    }
    int i5 = paramInt2 * i3;
    localObject1 = paramConstraintWidget.mListAnchors[n].getResolutionNode().dependents.iterator();
    for (paramInt2 = i; ((Iterator)localObject1).hasNext(); paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(((ResolutionAnchor)((Iterator)localObject1).next()).myAnchor.mOwner, paramInt1, paramBoolean, i2))) {}
    localObject1 = paramConstraintWidget.mListAnchors[i1].getResolutionNode().dependents.iterator();
    for (i = 0; ((Iterator)localObject1).hasNext(); i = Math.max(i, getMaxDimensionTraversal(((ResolutionAnchor)((Iterator)localObject1).next()).myAnchor.mOwner, paramInt1, paramBoolean, i5 + i2))) {}
    int i6;
    if (j != 0)
    {
      i6 = paramInt2 - k;
      i += m;
    }
    for (;;)
    {
      break;
      if (paramInt1 == 0) {
        i6 = paramConstraintWidget.getWidth();
      } else {
        i6 = paramConstraintWidget.getHeight();
      }
      i += i6 * i3;
      i6 = paramInt2;
    }
    Object localObject2;
    if (paramInt1 == 1)
    {
      localObject1 = paramConstraintWidget.mBaseline.getResolutionNode().dependents.iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolutionAnchor)((Iterator)localObject1).next();
        if (i3 == 1) {
          paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(((ResolutionAnchor)localObject2).myAnchor.mOwner, paramInt1, paramBoolean, k + i2));
        } else {
          paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(((ResolutionAnchor)localObject2).myAnchor.mOwner, paramInt1, paramBoolean, m * i3 + i2));
        }
      }
      if ((paramConstraintWidget.mBaseline.getResolutionNode().dependents.size() > 0) && (j == 0)) {
        if (i3 == 1) {
          paramInt2 += k;
        } else {
          paramInt2 -= m;
        }
      }
    }
    else
    {
      paramInt2 = 0;
    }
    int k = Math.max(i6, Math.max(i, paramInt2));
    paramInt2 = i5 + i2;
    int m = i2;
    int j = paramInt2;
    if (i3 == -1)
    {
      j = i2;
      m = paramInt2;
    }
    if (paramBoolean)
    {
      Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, m);
      paramConstraintWidget.setFrame(m, j, paramInt1);
    }
    else
    {
      paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
      paramConstraintWidget.setRelativePositioning(m, paramInt1);
    }
    if ((paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio != 0.0F)) {
      paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
    }
    localObject1 = paramConstraintWidget.mListAnchors;
    if ((localObject1[n].mTarget != null) && (localObject1[i1].mTarget != null))
    {
      localObject1 = paramConstraintWidget.getParent();
      localObject2 = paramConstraintWidget.mListAnchors;
      if ((localObject2[n].mTarget.mOwner == localObject1) && (localObject2[i1].mTarget.mOwner == localObject1)) {
        paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
      }
    }
    return i4 + k;
  }
  
  private static int getParentBiasOffset(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    int i = paramInt * 2;
    Object localObject1 = paramConstraintWidget.mListAnchors;
    Object localObject2 = localObject1[i];
    localObject1 = localObject1[(i + 1)];
    Object localObject3 = ((ConstraintAnchor)localObject2).mTarget;
    if (localObject3 != null)
    {
      Object localObject4 = ((ConstraintAnchor)localObject3).mOwner;
      localObject3 = paramConstraintWidget.mParent;
      if (localObject4 == localObject3)
      {
        localObject4 = ((ConstraintAnchor)localObject1).mTarget;
        if ((localObject4 != null) && (((ConstraintAnchor)localObject4).mOwner == localObject3))
        {
          i = ((ConstraintWidget)localObject3).getLength(paramInt);
          float f;
          if (paramInt == 0) {
            f = paramConstraintWidget.mHorizontalBiasPercent;
          } else {
            f = paramConstraintWidget.mVerticalBiasPercent;
          }
          paramInt = paramConstraintWidget.getLength(paramInt);
          return (int)((i - ((ConstraintAnchor)localObject2).getMargin() - ((ConstraintAnchor)localObject1).getMargin() - paramInt) * f);
        }
      }
    }
    return 0;
  }
  
  private static void invalidate(ConstraintWidgetContainer paramConstraintWidgetContainer, ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup)
  {
    paramConstraintWidgetGroup.mSkipSolver = false;
    paramConstraintWidgetContainer.mSkipSolver = false;
    paramConstraintWidget.mOptimizerMeasurable = false;
  }
  
  private static int resolveDimensionRatio(ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = paramConstraintWidget.getHorizontalDimensionBehaviour();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    float f;
    int i;
    if (localDimensionBehaviour1 == localDimensionBehaviour2)
    {
      if (paramConstraintWidget.mDimensionRatioSide == 0) {
        f = paramConstraintWidget.getHeight() * paramConstraintWidget.mDimensionRatio;
      } else {
        f = paramConstraintWidget.getHeight() / paramConstraintWidget.mDimensionRatio;
      }
      i = (int)f;
      paramConstraintWidget.setWidth(i);
    }
    else if (paramConstraintWidget.getVerticalDimensionBehaviour() == localDimensionBehaviour2)
    {
      if (paramConstraintWidget.mDimensionRatioSide == 1) {
        f = paramConstraintWidget.getWidth() * paramConstraintWidget.mDimensionRatio;
      } else {
        f = paramConstraintWidget.getWidth() / paramConstraintWidget.mDimensionRatio;
      }
      i = (int)f;
      paramConstraintWidget.setHeight(i);
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  private static void setConnection(ConstraintAnchor paramConstraintAnchor)
  {
    ResolutionAnchor localResolutionAnchor = paramConstraintAnchor.getResolutionNode();
    ConstraintAnchor localConstraintAnchor = paramConstraintAnchor.mTarget;
    if ((localConstraintAnchor != null) && (localConstraintAnchor.mTarget != paramConstraintAnchor)) {
      localConstraintAnchor.getResolutionNode().addDependent(localResolutionAnchor);
    }
  }
  
  public static void setPosition(List<ConstraintWidgetGroup> paramList, int paramInt1, int paramInt2)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      Iterator localIterator = ((ConstraintWidgetGroup)paramList.get(j)).getWidgetsToSet(paramInt1).iterator();
      while (localIterator.hasNext())
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
        if (localConstraintWidget.mOptimizerMeasurable) {
          updateSizeDependentWidgets(localConstraintWidget, paramInt1, paramInt2);
        }
      }
    }
  }
  
  private static void singleGroup(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    paramConstraintWidgetContainer.mWidgetGroups.clear();
    paramConstraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(paramConstraintWidgetContainer.mChildren));
  }
  
  private static boolean traverse(ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup, List<ConstraintWidgetGroup> paramList, boolean paramBoolean)
  {
    if (paramConstraintWidget == null) {
      return true;
    }
    paramConstraintWidget.mOptimizerMeasured = false;
    Object localObject1 = (ConstraintWidgetContainer)paramConstraintWidget.getParent();
    Object localObject2 = paramConstraintWidget.mBelongingGroup;
    if (localObject2 == null)
    {
      paramConstraintWidget.mOptimizerMeasurable = true;
      paramConstraintWidgetGroup.mConstrainedGroup.add(paramConstraintWidget);
      paramConstraintWidget.mBelongingGroup = paramConstraintWidgetGroup;
      if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget == null) && (paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget == null) && (paramConstraintWidget.mBaseline.mTarget == null) && (paramConstraintWidget.mCenter.mTarget == null))
      {
        invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean) {
          return false;
        }
      }
      if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
      {
        ((ConstraintWidget)localObject1).getVerticalDimensionBehaviour();
        localObject2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean)
        {
          invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        }
        if ((paramConstraintWidget.mTop.mTarget.mOwner != paramConstraintWidget.getParent()) || (paramConstraintWidget.mBottom.mTarget.mOwner != paramConstraintWidget.getParent())) {
          invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
        }
      }
      if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget != null))
      {
        ((ConstraintWidget)localObject1).getHorizontalDimensionBehaviour();
        localObject2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean)
        {
          invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        }
        if ((paramConstraintWidget.mLeft.mTarget.mOwner != paramConstraintWidget.getParent()) || (paramConstraintWidget.mRight.mTarget.mOwner != paramConstraintWidget.getParent())) {
          invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
        }
      }
      Object localObject3 = paramConstraintWidget.getHorizontalDimensionBehaviour();
      localObject2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
      if (localObject3 == localObject2) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramConstraintWidget.getVerticalDimensionBehaviour() == localObject2) {
        j = 1;
      } else {
        j = 0;
      }
      if (((i ^ j) != 0) && (paramConstraintWidget.mDimensionRatio != 0.0F))
      {
        resolveDimensionRatio(paramConstraintWidget);
      }
      else if ((paramConstraintWidget.getHorizontalDimensionBehaviour() == localObject2) || (paramConstraintWidget.getVerticalDimensionBehaviour() == localObject2))
      {
        invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean) {
          return false;
        }
      }
      localObject3 = paramConstraintWidget.mLeft.mTarget;
      ConstraintWidget localConstraintWidget;
      if (((localObject3 != null) || (paramConstraintWidget.mRight.mTarget != null)) && ((localObject3 == null) || (((ConstraintAnchor)localObject3).mOwner != paramConstraintWidget.mParent) || (paramConstraintWidget.mRight.mTarget != null)))
      {
        localObject2 = paramConstraintWidget.mRight.mTarget;
        if ((localObject2 == null) || (((ConstraintAnchor)localObject2).mOwner != paramConstraintWidget.mParent) || (localObject3 != null))
        {
          if (localObject3 == null) {
            break label553;
          }
          localConstraintWidget = ((ConstraintAnchor)localObject3).mOwner;
          localObject3 = paramConstraintWidget.mParent;
          if ((localConstraintWidget != localObject3) || (localObject2 == null) || (((ConstraintAnchor)localObject2).mOwner != localObject3)) {
            break label553;
          }
        }
      }
      if ((paramConstraintWidget.mCenter.mTarget == null) && (!(paramConstraintWidget instanceof Guideline)) && (!(paramConstraintWidget instanceof Helper))) {
        paramConstraintWidgetGroup.mStartHorizontalWidgets.add(paramConstraintWidget);
      }
      label553:
      localObject3 = paramConstraintWidget.mTop.mTarget;
      if (((localObject3 != null) || (paramConstraintWidget.mBottom.mTarget != null)) && ((localObject3 == null) || (((ConstraintAnchor)localObject3).mOwner != paramConstraintWidget.mParent) || (paramConstraintWidget.mBottom.mTarget != null)))
      {
        localObject2 = paramConstraintWidget.mBottom.mTarget;
        if ((localObject2 == null) || (((ConstraintAnchor)localObject2).mOwner != paramConstraintWidget.mParent) || (localObject3 != null))
        {
          if (localObject3 == null) {
            break label720;
          }
          localConstraintWidget = ((ConstraintAnchor)localObject3).mOwner;
          localObject3 = paramConstraintWidget.mParent;
          if ((localConstraintWidget != localObject3) || (localObject2 == null) || (((ConstraintAnchor)localObject2).mOwner != localObject3)) {
            break label720;
          }
        }
      }
      if ((paramConstraintWidget.mCenter.mTarget == null) && (paramConstraintWidget.mBaseline.mTarget == null) && (!(paramConstraintWidget instanceof Guideline)) && (!(paramConstraintWidget instanceof Helper))) {
        paramConstraintWidgetGroup.mStartVerticalWidgets.add(paramConstraintWidget);
      }
      label720:
      if ((paramConstraintWidget instanceof Helper))
      {
        invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean) {
          return false;
        }
        localObject2 = (Helper)paramConstraintWidget;
        for (i = 0; i < ((Helper)localObject2).mWidgetsCount; i++) {
          if (!traverse(localObject2.mWidgets[i], paramConstraintWidgetGroup, paramList, paramBoolean)) {
            return false;
          }
        }
      }
      int j = paramConstraintWidget.mListAnchors.length;
      for (int i = 0; i < j; i++)
      {
        localObject2 = paramConstraintWidget.mListAnchors[i];
        localObject3 = ((ConstraintAnchor)localObject2).mTarget;
        if ((localObject3 != null) && (((ConstraintAnchor)localObject3).mOwner != paramConstraintWidget.getParent()))
        {
          if (((ConstraintAnchor)localObject2).mType == ConstraintAnchor.Type.CENTER)
          {
            invalidate((ConstraintWidgetContainer)localObject1, paramConstraintWidget, paramConstraintWidgetGroup);
            if (paramBoolean) {
              return false;
            }
          }
          else
          {
            setConnection((ConstraintAnchor)localObject2);
          }
          if (!traverse(((ConstraintAnchor)localObject2).mTarget.mOwner, paramConstraintWidgetGroup, paramList, paramBoolean)) {
            return false;
          }
        }
      }
      return true;
    }
    if (localObject2 != paramConstraintWidgetGroup)
    {
      paramConstraintWidgetGroup.mConstrainedGroup.addAll(((ConstraintWidgetGroup)localObject2).mConstrainedGroup);
      paramConstraintWidgetGroup.mStartHorizontalWidgets.addAll(paramConstraintWidget.mBelongingGroup.mStartHorizontalWidgets);
      paramConstraintWidgetGroup.mStartVerticalWidgets.addAll(paramConstraintWidget.mBelongingGroup.mStartVerticalWidgets);
      localObject1 = paramConstraintWidget.mBelongingGroup;
      if (!((ConstraintWidgetGroup)localObject1).mSkipSolver) {
        paramConstraintWidgetGroup.mSkipSolver = false;
      }
      paramList.remove(localObject1);
      paramConstraintWidget = paramConstraintWidget.mBelongingGroup.mConstrainedGroup.iterator();
      while (paramConstraintWidget.hasNext()) {
        ((ConstraintWidget)paramConstraintWidget.next()).mBelongingGroup = paramConstraintWidgetGroup;
      }
    }
    return true;
  }
  
  private static void updateSizeDependentWidgets(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * 2;
    Object localObject1 = paramConstraintWidget.mListAnchors;
    Object localObject2 = localObject1[i];
    localObject1 = localObject1[(i + 1)];
    if ((((ConstraintAnchor)localObject2).mTarget != null) && (((ConstraintAnchor)localObject1).mTarget != null)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, getParentBiasOffset(paramConstraintWidget, paramInt1) + ((ConstraintAnchor)localObject2).getMargin());
      return;
    }
    if ((paramConstraintWidget.mDimensionRatio != 0.0F) && (paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
    {
      paramInt2 = resolveDimensionRatio(paramConstraintWidget);
      j = (int)paramConstraintWidget.mListAnchors[i].getResolutionNode().resolvedOffset;
      ((ConstraintAnchor)localObject1).getResolutionNode().resolvedTarget = ((ConstraintAnchor)localObject2).getResolutionNode();
      ((ConstraintAnchor)localObject1).getResolutionNode().resolvedOffset = paramInt2;
      ((ConstraintAnchor)localObject1).getResolutionNode().state = 1;
      paramConstraintWidget.setFrame(j, j + paramInt2, paramInt1);
      return;
    }
    int j = paramInt2 - paramConstraintWidget.getRelativePositioning(paramInt1);
    paramInt2 = j - paramConstraintWidget.getLength(paramInt1);
    paramConstraintWidget.setFrame(paramInt2, j, paramInt1);
    Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\Analyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */