package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;

public class Optimizer
{
  static final int FLAG_CHAIN_DANGLING = 1;
  static final int FLAG_RECOMPUTE_BOUNDS = 2;
  static final int FLAG_USE_OPTIMIZE = 0;
  public static final int OPTIMIZATION_BARRIER = 2;
  public static final int OPTIMIZATION_CHAIN = 4;
  public static final int OPTIMIZATION_DIMENSIONS = 8;
  public static final int OPTIMIZATION_DIRECT = 1;
  public static final int OPTIMIZATION_GROUPS = 32;
  public static final int OPTIMIZATION_NONE = 0;
  public static final int OPTIMIZATION_RATIO = 16;
  public static final int OPTIMIZATION_STANDARD = 7;
  static boolean[] flags = new boolean[3];
  
  static void analyze(int paramInt, ConstraintWidget paramConstraintWidget)
  {
    paramConstraintWidget.updateResolutionNodes();
    Object localObject1 = paramConstraintWidget.mLeft.getResolutionNode();
    ResolutionAnchor localResolutionAnchor1 = paramConstraintWidget.mTop.getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = paramConstraintWidget.mRight.getResolutionNode();
    Object localObject2 = paramConstraintWidget.mBottom.getResolutionNode();
    if ((paramInt & 0x8) == 8) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    Object localObject3 = paramConstraintWidget.mListDimensionBehaviors[0];
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    int i;
    if ((localObject3 == localDimensionBehaviour) && (optimizableMatchConstraint(paramConstraintWidget, 0))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((((ResolutionAnchor)localObject1).type != 4) && (localResolutionAnchor2.type != 4)) {
      if ((paramConstraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) && ((i == 0) || (paramConstraintWidget.getVisibility() != 8)))
      {
        if (i != 0)
        {
          i = paramConstraintWidget.getWidth();
          ((ResolutionAnchor)localObject1).setType(1);
          localResolutionAnchor2.setType(1);
          localObject3 = paramConstraintWidget.mLeft.mTarget;
          if ((localObject3 == null) && (paramConstraintWidget.mRight.mTarget == null))
          {
            if (paramInt != 0) {
              localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, 1, paramConstraintWidget.getResolutionWidth());
            } else {
              localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, i);
            }
          }
          else if ((localObject3 != null) && (paramConstraintWidget.mRight.mTarget == null))
          {
            if (paramInt != 0) {
              localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, 1, paramConstraintWidget.getResolutionWidth());
            } else {
              localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, i);
            }
          }
          else if ((localObject3 == null) && (paramConstraintWidget.mRight.mTarget != null))
          {
            if (paramInt != 0) {
              ((ResolutionAnchor)localObject1).dependsOn(localResolutionAnchor2, -1, paramConstraintWidget.getResolutionWidth());
            } else {
              ((ResolutionAnchor)localObject1).dependsOn(localResolutionAnchor2, -i);
            }
          }
          else if ((localObject3 != null) && (paramConstraintWidget.mRight.mTarget != null))
          {
            if (paramInt != 0)
            {
              paramConstraintWidget.getResolutionWidth().addDependent((ResolutionNode)localObject1);
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor2);
            }
            if (paramConstraintWidget.mDimensionRatio == 0.0F)
            {
              ((ResolutionAnchor)localObject1).setType(3);
              localResolutionAnchor2.setType(3);
              ((ResolutionAnchor)localObject1).setOpposite(localResolutionAnchor2, 0.0F);
              localResolutionAnchor2.setOpposite((ResolutionAnchor)localObject1, 0.0F);
            }
            else
            {
              ((ResolutionAnchor)localObject1).setType(2);
              localResolutionAnchor2.setType(2);
              ((ResolutionAnchor)localObject1).setOpposite(localResolutionAnchor2, -i);
              localResolutionAnchor2.setOpposite((ResolutionAnchor)localObject1, i);
              paramConstraintWidget.setWidth(i);
            }
          }
        }
      }
      else
      {
        localObject3 = paramConstraintWidget.mLeft.mTarget;
        if ((localObject3 == null) && (paramConstraintWidget.mRight.mTarget == null))
        {
          ((ResolutionAnchor)localObject1).setType(1);
          localResolutionAnchor2.setType(1);
          if (paramInt != 0) {
            localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, paramConstraintWidget.getWidth());
          }
        }
        else if ((localObject3 != null) && (paramConstraintWidget.mRight.mTarget == null))
        {
          ((ResolutionAnchor)localObject1).setType(1);
          localResolutionAnchor2.setType(1);
          if (paramInt != 0) {
            localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            localResolutionAnchor2.dependsOn((ResolutionAnchor)localObject1, paramConstraintWidget.getWidth());
          }
        }
        else if ((localObject3 == null) && (paramConstraintWidget.mRight.mTarget != null))
        {
          ((ResolutionAnchor)localObject1).setType(1);
          localResolutionAnchor2.setType(1);
          ((ResolutionAnchor)localObject1).dependsOn(localResolutionAnchor2, -paramConstraintWidget.getWidth());
          if (paramInt != 0) {
            ((ResolutionAnchor)localObject1).dependsOn(localResolutionAnchor2, -1, paramConstraintWidget.getResolutionWidth());
          } else {
            ((ResolutionAnchor)localObject1).dependsOn(localResolutionAnchor2, -paramConstraintWidget.getWidth());
          }
        }
        else if ((localObject3 != null) && (paramConstraintWidget.mRight.mTarget != null))
        {
          ((ResolutionAnchor)localObject1).setType(2);
          localResolutionAnchor2.setType(2);
          if (paramInt != 0)
          {
            paramConstraintWidget.getResolutionWidth().addDependent((ResolutionNode)localObject1);
            paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor2);
            ((ResolutionAnchor)localObject1).setOpposite(localResolutionAnchor2, -1, paramConstraintWidget.getResolutionWidth());
            localResolutionAnchor2.setOpposite((ResolutionAnchor)localObject1, 1, paramConstraintWidget.getResolutionWidth());
          }
          else
          {
            ((ResolutionAnchor)localObject1).setOpposite(localResolutionAnchor2, -paramConstraintWidget.getWidth());
            localResolutionAnchor2.setOpposite((ResolutionAnchor)localObject1, paramConstraintWidget.getWidth());
          }
        }
      }
    }
    if ((paramConstraintWidget.mListDimensionBehaviors[1] == localDimensionBehaviour) && (optimizableMatchConstraint(paramConstraintWidget, 1))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((localResolutionAnchor1.type != 4) && (((ResolutionAnchor)localObject2).type != 4)) {
      if ((paramConstraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) && ((i == 0) || (paramConstraintWidget.getVisibility() != 8)))
      {
        if (i != 0)
        {
          i = paramConstraintWidget.getHeight();
          localResolutionAnchor1.setType(1);
          ((ResolutionAnchor)localObject2).setType(1);
          localObject1 = paramConstraintWidget.mTop.mTarget;
          if ((localObject1 == null) && (paramConstraintWidget.mBottom.mTarget == null))
          {
            if (paramInt != 0) {
              ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionHeight());
            } else {
              ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, i);
            }
          }
          else if ((localObject1 != null) && (paramConstraintWidget.mBottom.mTarget == null))
          {
            if (paramInt != 0) {
              ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionHeight());
            } else {
              ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, i);
            }
          }
          else if ((localObject1 == null) && (paramConstraintWidget.mBottom.mTarget != null))
          {
            if (paramInt != 0) {
              localResolutionAnchor1.dependsOn((ResolutionAnchor)localObject2, -1, paramConstraintWidget.getResolutionHeight());
            } else {
              localResolutionAnchor1.dependsOn((ResolutionAnchor)localObject2, -i);
            }
          }
          else if ((localObject1 != null) && (paramConstraintWidget.mBottom.mTarget != null))
          {
            if (paramInt != 0)
            {
              paramConstraintWidget.getResolutionHeight().addDependent(localResolutionAnchor1);
              paramConstraintWidget.getResolutionWidth().addDependent((ResolutionNode)localObject2);
            }
            if (paramConstraintWidget.mDimensionRatio == 0.0F)
            {
              localResolutionAnchor1.setType(3);
              ((ResolutionAnchor)localObject2).setType(3);
              localResolutionAnchor1.setOpposite((ResolutionAnchor)localObject2, 0.0F);
              ((ResolutionAnchor)localObject2).setOpposite(localResolutionAnchor1, 0.0F);
            }
            else
            {
              localResolutionAnchor1.setType(2);
              ((ResolutionAnchor)localObject2).setType(2);
              localResolutionAnchor1.setOpposite((ResolutionAnchor)localObject2, -i);
              ((ResolutionAnchor)localObject2).setOpposite(localResolutionAnchor1, i);
              paramConstraintWidget.setHeight(i);
              if (paramConstraintWidget.mBaselineDistance > 0) {
                paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor1, paramConstraintWidget.mBaselineDistance);
              }
            }
          }
        }
      }
      else
      {
        localObject1 = paramConstraintWidget.mTop.mTarget;
        if ((localObject1 == null) && (paramConstraintWidget.mBottom.mTarget == null))
        {
          localResolutionAnchor1.setType(1);
          ((ResolutionAnchor)localObject2).setType(1);
          if (paramInt != 0) {
            ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, paramConstraintWidget.getHeight());
          }
          localObject2 = paramConstraintWidget.mBaseline;
          if (((ConstraintAnchor)localObject2).mTarget != null)
          {
            ((ConstraintAnchor)localObject2).getResolutionNode().setType(1);
            localResolutionAnchor1.dependsOn(1, paramConstraintWidget.mBaseline.getResolutionNode(), -paramConstraintWidget.mBaselineDistance);
          }
        }
        else if ((localObject1 != null) && (paramConstraintWidget.mBottom.mTarget == null))
        {
          localResolutionAnchor1.setType(1);
          ((ResolutionAnchor)localObject2).setType(1);
          if (paramInt != 0) {
            ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            ((ResolutionAnchor)localObject2).dependsOn(localResolutionAnchor1, paramConstraintWidget.getHeight());
          }
          if (paramConstraintWidget.mBaselineDistance > 0) {
            paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor1, paramConstraintWidget.mBaselineDistance);
          }
        }
        else if ((localObject1 == null) && (paramConstraintWidget.mBottom.mTarget != null))
        {
          localResolutionAnchor1.setType(1);
          ((ResolutionAnchor)localObject2).setType(1);
          if (paramInt != 0) {
            localResolutionAnchor1.dependsOn((ResolutionAnchor)localObject2, -1, paramConstraintWidget.getResolutionHeight());
          } else {
            localResolutionAnchor1.dependsOn((ResolutionAnchor)localObject2, -paramConstraintWidget.getHeight());
          }
          if (paramConstraintWidget.mBaselineDistance > 0) {
            paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor1, paramConstraintWidget.mBaselineDistance);
          }
        }
        else if ((localObject1 != null) && (paramConstraintWidget.mBottom.mTarget != null))
        {
          localResolutionAnchor1.setType(2);
          ((ResolutionAnchor)localObject2).setType(2);
          if (paramInt != 0)
          {
            localResolutionAnchor1.setOpposite((ResolutionAnchor)localObject2, -1, paramConstraintWidget.getResolutionHeight());
            ((ResolutionAnchor)localObject2).setOpposite(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionHeight());
            paramConstraintWidget.getResolutionHeight().addDependent(localResolutionAnchor1);
            paramConstraintWidget.getResolutionWidth().addDependent((ResolutionNode)localObject2);
          }
          else
          {
            localResolutionAnchor1.setOpposite((ResolutionAnchor)localObject2, -paramConstraintWidget.getHeight());
            ((ResolutionAnchor)localObject2).setOpposite(localResolutionAnchor1, paramConstraintWidget.getHeight());
          }
          if (paramConstraintWidget.mBaselineDistance > 0) {
            paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor1, paramConstraintWidget.mBaselineDistance);
          }
        }
      }
    }
  }
  
  static boolean applyChainOptimized(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead)
  {
    Object localObject1 = paramChainHead.mFirst;
    ConstraintWidget localConstraintWidget1 = paramChainHead.mLast;
    Object localObject2 = paramChainHead.mFirstVisibleWidget;
    ConstraintWidget localConstraintWidget2 = paramChainHead.mLastVisibleWidget;
    Object localObject3 = paramChainHead.mHead;
    float f1 = paramChainHead.mTotalWeight;
    paramConstraintWidgetContainer = paramConstraintWidgetContainer.mListDimensionBehaviors[paramInt1];
    paramConstraintWidgetContainer = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    int j;
    int k;
    int n;
    if (paramInt1 == 0)
    {
      i = ((ConstraintWidget)localObject3).mHorizontalChainStyle;
      if (i == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (i == 1) {
        k = 1;
      } else {
        k = 0;
      }
      m = j;
      n = k;
      if (i == 2)
      {
        n = k;
        m = j;
      }
    }
    for (;;)
    {
      j = 1;
      k = m;
      break;
      do
      {
        j = 0;
        k = m;
        break;
        i = ((ConstraintWidget)localObject3).mVerticalChainStyle;
        if (i == 0) {
          j = 1;
        } else {
          j = 0;
        }
        if (i == 1) {
          k = 1;
        } else {
          k = 0;
        }
        m = j;
        n = k;
      } while (i != 2);
      m = j;
      n = k;
    }
    paramChainHead = (ChainHead)localObject1;
    int i1 = 0;
    int i = 0;
    int m = 0;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4;
    float f5;
    while (i == 0)
    {
      int i2 = m;
      f4 = f2;
      f5 = f3;
      if (paramChainHead.getVisibility() != 8)
      {
        i2 = m + 1;
        if (paramInt1 == 0) {
          m = paramChainHead.getWidth();
        } else {
          m = paramChainHead.getHeight();
        }
        f4 = f2 + m;
        f5 = f4;
        if (paramChainHead != localObject2) {
          f5 = f4 + paramChainHead.mListAnchors[paramInt2].getMargin();
        }
        f4 = f5;
        if (paramChainHead != localConstraintWidget2) {
          f4 = f5 + paramChainHead.mListAnchors[(paramInt2 + 1)].getMargin();
        }
        f5 = f3 + paramChainHead.mListAnchors[paramInt2].getMargin() + paramChainHead.mListAnchors[(paramInt2 + 1)].getMargin();
      }
      paramConstraintWidgetContainer = paramChainHead.mListAnchors[paramInt2];
      m = i1;
      if (paramChainHead.getVisibility() != 8)
      {
        m = i1;
        if (paramChainHead.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          m = i1 + 1;
          if (paramInt1 == 0)
          {
            if (paramChainHead.mMatchConstraintDefaultWidth != 0) {
              return false;
            }
            if ((paramChainHead.mMatchConstraintMinWidth != 0) || (paramChainHead.mMatchConstraintMaxWidth != 0)) {
              return false;
            }
          }
          else
          {
            if (paramChainHead.mMatchConstraintDefaultHeight != 0) {
              return false;
            }
            if ((paramChainHead.mMatchConstraintMinHeight != 0) || (paramChainHead.mMatchConstraintMaxHeight != 0)) {
              break label479;
            }
          }
          if (paramChainHead.mDimensionRatio != 0.0F) {
            label479:
            return false;
          }
        }
      }
      paramConstraintWidgetContainer = paramChainHead.mListAnchors[(paramInt2 + 1)].mTarget;
      if (paramConstraintWidgetContainer != null)
      {
        paramConstraintWidgetContainer = paramConstraintWidgetContainer.mOwner;
        localObject3 = paramConstraintWidgetContainer.mListAnchors;
        if ((localObject3[paramInt2].mTarget != null) && (localObject3[paramInt2].mTarget.mOwner == paramChainHead)) {
          break label542;
        }
      }
      paramConstraintWidgetContainer = null;
      label542:
      if (paramConstraintWidgetContainer != null)
      {
        i1 = m;
        paramChainHead = paramConstraintWidgetContainer;
        m = i2;
        f2 = f4;
        f3 = f5;
      }
      else
      {
        i = 1;
        i1 = m;
        m = i2;
        f2 = f4;
        f3 = f5;
      }
    }
    localObject3 = localObject1.mListAnchors[paramInt2].getResolutionNode();
    paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors;
    i = paramInt2 + 1;
    paramConstraintWidgetContainer = paramConstraintWidgetContainer[i].getResolutionNode();
    ResolutionAnchor localResolutionAnchor1 = ((ResolutionAnchor)localObject3).target;
    if (localResolutionAnchor1 != null)
    {
      ResolutionAnchor localResolutionAnchor2 = paramConstraintWidgetContainer.target;
      if (localResolutionAnchor2 != null)
      {
        if ((localResolutionAnchor1.state == 1) && (localResolutionAnchor2.state == 1))
        {
          if ((i1 > 0) && (i1 != m)) {
            return false;
          }
          if ((j == 0) && (k == 0) && (n == 0))
          {
            f4 = 0.0F;
          }
          else
          {
            if (localObject2 != null) {
              f5 = localObject2.mListAnchors[paramInt2].getMargin();
            } else {
              f5 = 0.0F;
            }
            f4 = f5;
            if (localConstraintWidget2 != null) {
              f4 = f5 + localConstraintWidget2.mListAnchors[i].getMargin();
            }
          }
          float f6 = ((ResolutionAnchor)localObject3).target.resolvedOffset;
          f5 = paramConstraintWidgetContainer.target.resolvedOffset;
          if (f6 < f5) {
            f5 -= f6;
          } else {
            f5 = f6 - f5;
          }
          float f7 = f5 - f2;
          if ((i1 > 0) && (i1 == m))
          {
            if ((paramChainHead.getParent() != null) && (paramChainHead.getParent().mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
              return false;
            }
            f3 = f7 + f2 - f3;
            f5 = f6;
            for (paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1; paramConstraintWidgetContainer != null; paramConstraintWidgetContainer = paramChainHead)
            {
              paramChainHead = LinearSystem.sMetrics;
              if (paramChainHead != null)
              {
                paramChainHead.nonresolvedWidgets -= 1L;
                paramChainHead.resolvedWidgets += 1L;
                paramChainHead.chainConnectionResolved += 1L;
              }
              paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
              if ((paramChainHead == null) && (paramConstraintWidgetContainer != localConstraintWidget1)) {
                continue;
              }
              f4 = f3 / i1;
              if (f1 > 0.0F)
              {
                localObject1 = paramConstraintWidgetContainer.mWeight;
                if (localObject1[paramInt1] == -1.0F) {
                  f4 = 0.0F;
                } else {
                  f4 = localObject1[paramInt1] * f3 / f1;
                }
              }
              if (paramConstraintWidgetContainer.getVisibility() == 8) {
                f4 = 0.0F;
              }
              f5 += paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
              paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject3).resolvedTarget, f5);
              localObject1 = paramConstraintWidgetContainer.mListAnchors[i].getResolutionNode();
              localObject2 = ((ResolutionAnchor)localObject3).resolvedTarget;
              f4 = f5 + f4;
              ((ResolutionAnchor)localObject1).resolve((ResolutionAnchor)localObject2, f4);
              paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
              paramConstraintWidgetContainer.mListAnchors[i].getResolutionNode().addResolvedValue(paramLinearSystem);
              f5 = f4 + paramConstraintWidgetContainer.mListAnchors[i].getMargin();
            }
            return true;
          }
          if (f7 < 0.0F)
          {
            j = 1;
            k = 0;
            n = 0;
          }
          if (j != 0)
          {
            paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
            f4 = f6 + (f7 - f4) * paramConstraintWidgetContainer.getBiasPercent(paramInt1);
            for (;;)
            {
              paramChainHead = paramConstraintWidgetContainer;
              if (paramChainHead == null) {
                break;
              }
              paramConstraintWidgetContainer = LinearSystem.sMetrics;
              if (paramConstraintWidgetContainer != null)
              {
                paramConstraintWidgetContainer.nonresolvedWidgets -= 1L;
                paramConstraintWidgetContainer.resolvedWidgets += 1L;
                paramConstraintWidgetContainer.chainConnectionResolved += 1L;
              }
              localObject1 = paramChainHead.mNextChainWidget[paramInt1];
              if (localObject1 == null)
              {
                paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
                if (paramChainHead != localConstraintWidget1) {}
              }
              else
              {
                if (paramInt1 == 0) {
                  j = paramChainHead.getWidth();
                } else {
                  j = paramChainHead.getHeight();
                }
                f5 = j;
                f4 += paramChainHead.mListAnchors[paramInt2].getMargin();
                paramChainHead.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject3).resolvedTarget, f4);
                paramConstraintWidgetContainer = paramChainHead.mListAnchors[i].getResolutionNode();
                localObject2 = ((ResolutionAnchor)localObject3).resolvedTarget;
                f4 += f5;
                paramConstraintWidgetContainer.resolve((ResolutionAnchor)localObject2, f4);
                paramChainHead.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
                paramChainHead.mListAnchors[i].getResolutionNode().addResolvedValue(paramLinearSystem);
                f4 += paramChainHead.mListAnchors[i].getMargin();
                paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
              }
            }
          }
          if ((k == 0) && (n == 0)) {}
          for (;;)
          {
            break;
            if (k != 0) {}
            do
            {
              f5 = f7 - f4;
              break;
              f5 = f7;
            } while (n != 0);
            f3 = f5 / (m + 1);
            if (n != 0)
            {
              if (m > 1) {
                f4 = m - 1;
              } else {
                f4 = 2.0F;
              }
              f3 = f5 / f4;
            }
            if (((ConstraintWidget)localObject1).getVisibility() != 8) {
              f4 = f6 + f3;
            } else {
              f4 = f6;
            }
            f5 = f4;
            if (n != 0)
            {
              f5 = f4;
              if (m > 1) {
                f5 = localObject2.mListAnchors[paramInt2].getMargin() + f6;
              }
            }
            paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
            f4 = f5;
            if (k != 0)
            {
              paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
              f4 = f5;
              if (localObject2 != null)
              {
                f4 = f5 + localObject2.mListAnchors[paramInt2].getMargin();
                paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
              }
            }
            while (paramConstraintWidgetContainer != null)
            {
              paramChainHead = LinearSystem.sMetrics;
              if (paramChainHead != null)
              {
                paramChainHead.nonresolvedWidgets -= 1L;
                paramChainHead.resolvedWidgets += 1L;
                paramChainHead.chainConnectionResolved += 1L;
              }
              paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
              if (paramChainHead == null)
              {
                f5 = f4;
                if (paramConstraintWidgetContainer == localConstraintWidget1) {}
              }
              do
              {
                paramConstraintWidgetContainer = paramChainHead;
                f4 = f5;
                break;
                if (paramInt1 == 0) {
                  j = paramConstraintWidgetContainer.getWidth();
                } else {
                  j = paramConstraintWidgetContainer.getHeight();
                }
                f6 = j;
                f5 = f4;
                if (paramConstraintWidgetContainer != localObject2) {
                  f5 = f4 + paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
                }
                paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject3).resolvedTarget, f5);
                paramConstraintWidgetContainer.mListAnchors[i].getResolutionNode().resolve(((ResolutionAnchor)localObject3).resolvedTarget, f5 + f6);
                paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
                paramConstraintWidgetContainer.mListAnchors[i].getResolutionNode().addResolvedValue(paramLinearSystem);
                f6 = f5 + (f6 + paramConstraintWidgetContainer.mListAnchors[i].getMargin());
                f5 = f6;
              } while (paramChainHead == null);
              paramConstraintWidgetContainer = paramChainHead;
              f4 = f6;
              if (paramChainHead.getVisibility() != 8)
              {
                f4 = f6 + f3;
                paramConstraintWidgetContainer = paramChainHead;
              }
            }
          }
          return true;
        }
        return false;
      }
    }
    return false;
  }
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    Object localObject = paramConstraintWidgetContainer.mListDimensionBehaviors[0];
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    int i;
    int j;
    if ((localObject != localDimensionBehaviour) && (paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      localObject = paramConstraintWidget.mLeft;
      ((ConstraintAnchor)localObject).mSolverVariable = paramLinearSystem.createObjectVariable(localObject);
      localObject = paramConstraintWidget.mRight;
      ((ConstraintAnchor)localObject).mSolverVariable = paramLinearSystem.createObjectVariable(localObject);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
    }
    if ((paramConstraintWidgetContainer.mListDimensionBehaviors[1] != localDimensionBehaviour) && (paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      j = paramConstraintWidget.mTop.mMargin;
      i = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramConstraintWidgetContainer = paramConstraintWidget.mTop;
      paramConstraintWidgetContainer.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidgetContainer);
      paramConstraintWidgetContainer = paramConstraintWidget.mBottom;
      paramConstraintWidgetContainer.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidgetContainer);
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidgetContainer = paramConstraintWidget.mBaseline;
        paramConstraintWidgetContainer.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidgetContainer);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
      }
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(j, i);
    }
  }
  
  private static boolean optimizableMatchConstraint(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    ConstraintWidget.DimensionBehaviour[] arrayOfDimensionBehaviour = paramConstraintWidget.mListDimensionBehaviors;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = arrayOfDimensionBehaviour[paramInt];
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    if (localDimensionBehaviour1 != localDimensionBehaviour2) {
      return false;
    }
    float f = paramConstraintWidget.mDimensionRatio;
    int i = 1;
    if (f != 0.0F)
    {
      if (paramInt == 0) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      if (arrayOfDimensionBehaviour[paramInt] == localDimensionBehaviour2) {}
      return false;
    }
    if (paramInt == 0)
    {
      if (paramConstraintWidget.mMatchConstraintDefaultWidth != 0) {
        return false;
      }
      if ((paramConstraintWidget.mMatchConstraintMinWidth != 0) || (paramConstraintWidget.mMatchConstraintMaxWidth != 0)) {
        return false;
      }
    }
    else if (paramConstraintWidget.mMatchConstraintDefaultHeight != 0)
    {
      return false;
    }
    return (paramConstraintWidget.mMatchConstraintMinHeight == 0) && (paramConstraintWidget.mMatchConstraintMaxHeight == 0);
  }
  
  static void setOptimizedWidget(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * 2;
    int j = i + 1;
    paramConstraintWidget.mListAnchors[i].getResolutionNode().resolvedTarget = paramConstraintWidget.getParent().mLeft.getResolutionNode();
    paramConstraintWidget.mListAnchors[i].getResolutionNode().resolvedOffset = paramInt2;
    paramConstraintWidget.mListAnchors[i].getResolutionNode().state = 1;
    paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedTarget = paramConstraintWidget.mListAnchors[i].getResolutionNode();
    paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedOffset = paramConstraintWidget.getLength(paramInt1);
    paramConstraintWidget.mListAnchors[j].getResolutionNode().state = 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\Optimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */