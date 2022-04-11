package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

class Chain
{
  private static final boolean DEBUG = false;
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt)
  {
    int i = 0;
    int j;
    ChainHead[] arrayOfChainHead;
    int k;
    if (paramInt == 0)
    {
      j = paramConstraintWidgetContainer.mHorizontalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mHorizontalChainsArray;
      k = 0;
    }
    else
    {
      k = 2;
      j = paramConstraintWidgetContainer.mVerticalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mVerticalChainsArray;
    }
    while (i < j)
    {
      ChainHead localChainHead = arrayOfChainHead[i];
      localChainHead.define();
      if (paramConstraintWidgetContainer.optimizeFor(4))
      {
        if (!Optimizer.applyChainOptimized(paramConstraintWidgetContainer, paramLinearSystem, paramInt, k, localChainHead)) {
          applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, k, localChainHead);
        }
      }
      else {
        applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, k, localChainHead);
      }
      i++;
    }
  }
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead)
  {
    ConstraintWidget localConstraintWidget1 = paramChainHead.mFirst;
    ConstraintWidget localConstraintWidget2 = paramChainHead.mLast;
    ConstraintWidget localConstraintWidget3 = paramChainHead.mFirstVisibleWidget;
    ConstraintWidget localConstraintWidget4 = paramChainHead.mLastVisibleWidget;
    Object localObject1 = paramChainHead.mHead;
    float f1 = paramChainHead.mTotalWeight;
    int i;
    if (paramConstraintWidgetContainer.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramInt1 == 0)
    {
      j = ((ConstraintWidget)localObject1).mHorizontalChainStyle;
      if (j == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (j == 1) {
        m = 1;
      } else {
        m = 0;
      }
      n = k;
      i1 = m;
      if (j != 2) {
        break label180;
      }
    }
    else
    {
      j = ((ConstraintWidget)localObject1).mVerticalChainStyle;
      if (j == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (j == 1) {
        m = 1;
      } else {
        m = 0;
      }
      n = k;
      i1 = m;
      if (j != 2) {
        break label180;
      }
    }
    int j = 1;
    int n = k;
    break label187;
    label180:
    j = 0;
    int m = i1;
    label187:
    Object localObject2 = localConstraintWidget1;
    int k = 0;
    int i1 = m;
    ConstraintAnchor[] arrayOfConstraintAnchor;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i3;
    for (;;)
    {
      arrayOfConstraintAnchor = null;
      localObject3 = null;
      if (k != 0) {
        break;
      }
      localObject4 = localObject2.mListAnchors[paramInt2];
      if ((i == 0) && (j == 0)) {
        m = 4;
      } else {
        m = 1;
      }
      int i2 = ((ConstraintAnchor)localObject4).getMargin();
      localObject5 = ((ConstraintAnchor)localObject4).mTarget;
      i3 = i2;
      if (localObject5 != null)
      {
        i3 = i2;
        if (localObject2 != localConstraintWidget1) {
          i3 = i2 + ((ConstraintAnchor)localObject5).getMargin();
        }
      }
      if ((j != 0) && (localObject2 != localConstraintWidget1) && (localObject2 != localConstraintWidget3)) {
        m = 6;
      } else if ((n != 0) && (i != 0)) {
        m = 4;
      }
      localObject5 = ((ConstraintAnchor)localObject4).mTarget;
      if (localObject5 != null)
      {
        if (localObject2 == localConstraintWidget3) {
          paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject4).mSolverVariable, ((ConstraintAnchor)localObject5).mSolverVariable, i3, 5);
        } else {
          paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject4).mSolverVariable, ((ConstraintAnchor)localObject5).mSolverVariable, i3, 6);
        }
        paramLinearSystem.addEquality(((ConstraintAnchor)localObject4).mSolverVariable, ((ConstraintAnchor)localObject4).mTarget.mSolverVariable, i3, m);
      }
      if (i != 0)
      {
        if ((((ConstraintWidget)localObject2).getVisibility() != 8) && (localObject2.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
        {
          localObject4 = ((ConstraintWidget)localObject2).mListAnchors;
          paramLinearSystem.addGreaterThan(localObject4[(paramInt2 + 1)].mSolverVariable, localObject4[paramInt2].mSolverVariable, 0, 5);
        }
        paramLinearSystem.addGreaterThan(localObject2.mListAnchors[paramInt2].mSolverVariable, paramConstraintWidgetContainer.mListAnchors[paramInt2].mSolverVariable, 0, 6);
      }
      localObject5 = localObject2.mListAnchors[(paramInt2 + 1)].mTarget;
      localObject4 = localObject3;
      if (localObject5 != null)
      {
        localObject5 = ((ConstraintAnchor)localObject5).mOwner;
        arrayOfConstraintAnchor = ((ConstraintWidget)localObject5).mListAnchors;
        localObject4 = localObject3;
        if (arrayOfConstraintAnchor[paramInt2].mTarget != null) {
          if (arrayOfConstraintAnchor[paramInt2].mTarget.mOwner != localObject2) {
            localObject4 = localObject3;
          } else {
            localObject4 = localObject5;
          }
        }
      }
      if (localObject4 != null) {
        localObject2 = localObject4;
      } else {
        k = 1;
      }
    }
    if (localConstraintWidget4 != null)
    {
      localObject4 = localConstraintWidget2.mListAnchors;
      k = paramInt2 + 1;
      if (localObject4[k].mTarget != null)
      {
        localObject2 = localConstraintWidget4.mListAnchors[k];
        paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject2).mSolverVariable, localObject4[k].mTarget.mSolverVariable, -((ConstraintAnchor)localObject2).getMargin(), 5);
      }
    }
    if (i != 0)
    {
      paramConstraintWidgetContainer = paramConstraintWidgetContainer.mListAnchors;
      k = paramInt2 + 1;
      paramConstraintWidgetContainer = paramConstraintWidgetContainer[k].mSolverVariable;
      localObject4 = localConstraintWidget2.mListAnchors;
      paramLinearSystem.addGreaterThan(paramConstraintWidgetContainer, localObject4[k].mSolverVariable, localObject4[k].getMargin(), 6);
    }
    paramConstraintWidgetContainer = paramChainHead.mWeightedMatchConstraintsWidgets;
    label891:
    Object localObject6;
    Object localObject7;
    if (paramConstraintWidgetContainer != null)
    {
      m = paramConstraintWidgetContainer.size();
      if (m > 1)
      {
        float f2;
        if ((paramChainHead.mHasUndefinedWeights) && (!paramChainHead.mHasComplexMatchWeights)) {
          f2 = paramChainHead.mWidgetsMatchCount;
        } else {
          f2 = f1;
        }
        localObject4 = null;
        k = 0;
        float f3 = 0.0F;
        while (k < m)
        {
          localObject2 = (ConstraintWidget)paramConstraintWidgetContainer.get(k);
          f1 = localObject2.mWeight[paramInt1];
          if (f1 < 0.0F)
          {
            if (paramChainHead.mHasComplexMatchWeights)
            {
              localObject2 = ((ConstraintWidget)localObject2).mListAnchors;
              paramLinearSystem.addEquality(localObject2[(paramInt2 + 1)].mSolverVariable, localObject2[paramInt2].mSolverVariable, 0, 4);
              break label891;
            }
            f1 = 1.0F;
          }
          if (f1 == 0.0F)
          {
            localObject2 = ((ConstraintWidget)localObject2).mListAnchors;
            paramLinearSystem.addEquality(localObject2[(paramInt2 + 1)].mSolverVariable, localObject2[paramInt2].mSolverVariable, 0, 6);
          }
          else
          {
            if (localObject4 != null)
            {
              localObject3 = ((ConstraintWidget)localObject4).mListAnchors;
              localObject4 = localObject3[paramInt2].mSolverVariable;
              i = paramInt2 + 1;
              localObject5 = localObject3[i].mSolverVariable;
              localObject6 = ((ConstraintWidget)localObject2).mListAnchors;
              localObject3 = localObject6[paramInt2].mSolverVariable;
              localObject6 = localObject6[i].mSolverVariable;
              localObject7 = paramLinearSystem.createRow();
              ((ArrayRow)localObject7).createRowEqualMatchDimensions(f3, f2, f1, (SolverVariable)localObject4, (SolverVariable)localObject5, (SolverVariable)localObject3, (SolverVariable)localObject6);
              paramLinearSystem.addConstraint((ArrayRow)localObject7);
            }
            localObject4 = localObject2;
            f3 = f1;
          }
          k++;
        }
      }
    }
    if ((localConstraintWidget3 != null) && ((localConstraintWidget3 == localConstraintWidget4) || (j != 0)))
    {
      paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors;
      localObject4 = paramConstraintWidgetContainer[paramInt2];
      paramChainHead = localConstraintWidget2.mListAnchors;
      k = paramInt2 + 1;
      localObject2 = paramChainHead[k];
      if (paramConstraintWidgetContainer[paramInt2].mTarget != null) {
        paramConstraintWidgetContainer = paramConstraintWidgetContainer[paramInt2].mTarget.mSolverVariable;
      } else {
        paramConstraintWidgetContainer = null;
      }
      if (paramChainHead[k].mTarget != null) {
        paramChainHead = paramChainHead[k].mTarget.mSolverVariable;
      } else {
        paramChainHead = null;
      }
      if (localConstraintWidget3 == localConstraintWidget4)
      {
        localObject2 = localConstraintWidget3.mListAnchors;
        localObject4 = localObject2[paramInt2];
        localObject2 = localObject2[k];
      }
      if ((paramConstraintWidgetContainer != null) && (paramChainHead != null))
      {
        if (paramInt1 == 0) {
          f1 = ((ConstraintWidget)localObject1).mHorizontalBiasPercent;
        } else {
          f1 = ((ConstraintWidget)localObject1).mVerticalBiasPercent;
        }
        paramInt1 = ((ConstraintAnchor)localObject4).getMargin();
        k = ((ConstraintAnchor)localObject2).getMargin();
        paramLinearSystem.addCentering(((ConstraintAnchor)localObject4).mSolverVariable, paramConstraintWidgetContainer, paramInt1, f1, paramChainHead, ((ConstraintAnchor)localObject2).mSolverVariable, k, 5);
      }
    }
    else
    {
      if ((n != 0) && (localConstraintWidget3 != null))
      {
        k = paramChainHead.mWidgetsMatchCount;
        if ((k > 0) && (paramChainHead.mWidgetsCount == k)) {
          i = 1;
        } else {
          i = 0;
        }
        paramChainHead = localConstraintWidget3;
        localObject2 = paramChainHead;
      }
      while (paramChainHead != null)
      {
        for (localObject4 = paramChainHead.mNextChainWidget[paramInt1]; (localObject4 != null) && (((ConstraintWidget)localObject4).getVisibility() == 8); localObject4 = localObject4.mNextChainWidget[paramInt1]) {}
        if ((localObject4 == null) && (paramChainHead != localConstraintWidget4)) {}
        for (;;)
        {
          break;
          localObject3 = paramChainHead.mListAnchors[paramInt2];
          localObject7 = ((ConstraintAnchor)localObject3).mSolverVariable;
          paramConstraintWidgetContainer = ((ConstraintAnchor)localObject3).mTarget;
          if (paramConstraintWidgetContainer != null) {
            localObject1 = paramConstraintWidgetContainer.mSolverVariable;
          } else {
            localObject1 = null;
          }
          if (localObject2 != paramChainHead)
          {
            paramConstraintWidgetContainer = localObject2.mListAnchors[(paramInt2 + 1)].mSolverVariable;
          }
          else
          {
            paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
            if (paramChainHead == localConstraintWidget3)
            {
              paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
              if (localObject2 == paramChainHead)
              {
                paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors;
                if (paramConstraintWidgetContainer[paramInt2].mTarget != null) {
                  paramConstraintWidgetContainer = paramConstraintWidgetContainer[paramInt2].mTarget.mSolverVariable;
                } else {
                  paramConstraintWidgetContainer = null;
                }
              }
            }
          }
          j = ((ConstraintAnchor)localObject3).getMargin();
          localObject1 = paramChainHead.mListAnchors;
          i3 = paramInt2 + 1;
          m = localObject1[i3].getMargin();
          if (localObject4 != null)
          {
            localObject1 = localObject4.mListAnchors[paramInt2];
            localObject5 = ((ConstraintAnchor)localObject1).mSolverVariable;
            localObject3 = paramChainHead.mListAnchors[i3].mSolverVariable;
          }
          else
          {
            localObject6 = localConstraintWidget2.mListAnchors[i3].mTarget;
            if (localObject6 != null) {
              localObject1 = ((ConstraintAnchor)localObject6).mSolverVariable;
            } else {
              localObject1 = null;
            }
            localObject3 = paramChainHead.mListAnchors[i3].mSolverVariable;
            localObject5 = localObject1;
            localObject1 = localObject6;
          }
          k = m;
          if (localObject1 != null) {
            k = m + ((ConstraintAnchor)localObject1).getMargin();
          }
          m = j;
          if (localObject2 != null) {
            m = j + localObject2.mListAnchors[i3].getMargin();
          }
          if ((localObject7 != null) && (paramConstraintWidgetContainer != null) && (localObject5 != null) && (localObject3 != null))
          {
            if (paramChainHead == localConstraintWidget3) {
              m = localConstraintWidget3.mListAnchors[paramInt2].getMargin();
            }
            if (paramChainHead == localConstraintWidget4) {
              k = localConstraintWidget4.mListAnchors[i3].getMargin();
            }
            if (i != 0) {
              j = 6;
            } else {
              j = 4;
            }
            paramLinearSystem.addCentering((SolverVariable)localObject7, paramConstraintWidgetContainer, m, 0.5F, (SolverVariable)localObject5, (SolverVariable)localObject3, k, j);
          }
        }
        if (paramChainHead.getVisibility() != 8) {
          localObject2 = paramChainHead;
        }
        paramChainHead = (ChainHead)localObject4;
        continue;
        if ((i1 != 0) && (localConstraintWidget3 != null))
        {
          k = paramChainHead.mWidgetsMatchCount;
          if ((k > 0) && (paramChainHead.mWidgetsCount == k)) {
            k = 1;
          } else {
            k = 0;
          }
          paramChainHead = localConstraintWidget3;
          localObject4 = paramChainHead;
          while (paramChainHead != null)
          {
            for (paramConstraintWidgetContainer = paramChainHead.mNextChainWidget[paramInt1]; (paramConstraintWidgetContainer != null) && (paramConstraintWidgetContainer.getVisibility() == 8); paramConstraintWidgetContainer = paramConstraintWidgetContainer.mNextChainWidget[paramInt1]) {}
            if ((paramChainHead != localConstraintWidget3) && (paramChainHead != localConstraintWidget4) && (paramConstraintWidgetContainer != null))
            {
              if (paramConstraintWidgetContainer == localConstraintWidget4) {
                paramConstraintWidgetContainer = null;
              }
              localObject1 = paramChainHead.mListAnchors[paramInt2];
              localObject6 = ((ConstraintAnchor)localObject1).mSolverVariable;
              localObject2 = ((ConstraintAnchor)localObject1).mTarget;
              if (localObject2 != null) {
                localObject2 = ((ConstraintAnchor)localObject2).mSolverVariable;
              }
              localObject2 = ((ConstraintWidget)localObject4).mListAnchors;
              i3 = paramInt2 + 1;
              localObject7 = localObject2[i3].mSolverVariable;
              j = ((ConstraintAnchor)localObject1).getMargin();
              i = paramChainHead.mListAnchors[i3].getMargin();
              if (paramConstraintWidgetContainer != null)
              {
                localObject2 = paramConstraintWidgetContainer.mListAnchors[paramInt2];
                localObject3 = ((ConstraintAnchor)localObject2).mSolverVariable;
                localObject1 = ((ConstraintAnchor)localObject2).mTarget;
                if (localObject1 != null) {
                  localObject1 = ((ConstraintAnchor)localObject1).mSolverVariable;
                } else {
                  localObject1 = null;
                }
              }
              else
              {
                localObject3 = paramChainHead.mListAnchors;
                localObject2 = localObject3[i3].mTarget;
                if (localObject2 != null) {
                  localObject1 = ((ConstraintAnchor)localObject2).mSolverVariable;
                } else {
                  localObject1 = null;
                }
                localObject5 = localObject3[i3].mSolverVariable;
                localObject3 = localObject1;
                localObject1 = localObject5;
              }
              m = i;
              if (localObject2 != null) {
                m = i + ((ConstraintAnchor)localObject2).getMargin();
              }
              i3 = localObject4.mListAnchors[i3].getMargin();
              if (k != 0) {
                i = 6;
              } else {
                i = 4;
              }
              if ((localObject6 != null) && (localObject7 != null) && (localObject3 != null) && (localObject1 != null)) {
                paramLinearSystem.addCentering((SolverVariable)localObject6, (SolverVariable)localObject7, i3 + j, 0.5F, (SolverVariable)localObject3, (SolverVariable)localObject1, m, i);
              }
            }
            if (paramChainHead.getVisibility() == 8) {
              paramChainHead = (ChainHead)localObject4;
            }
            localObject4 = paramChainHead;
            paramChainHead = paramConstraintWidgetContainer;
          }
          paramConstraintWidgetContainer = localConstraintWidget3.mListAnchors[paramInt2];
          paramChainHead = localConstraintWidget1.mListAnchors[paramInt2].mTarget;
          localObject4 = localConstraintWidget4.mListAnchors;
          paramInt1 = paramInt2 + 1;
          localObject4 = localObject4[paramInt1];
          localObject1 = localConstraintWidget2.mListAnchors[paramInt1].mTarget;
          if (paramChainHead != null) {
            if (localConstraintWidget3 != localConstraintWidget4) {
              paramLinearSystem.addEquality(paramConstraintWidgetContainer.mSolverVariable, paramChainHead.mSolverVariable, paramConstraintWidgetContainer.getMargin(), 5);
            } else if (localObject1 != null) {
              paramLinearSystem.addCentering(paramConstraintWidgetContainer.mSolverVariable, paramChainHead.mSolverVariable, paramConstraintWidgetContainer.getMargin(), 0.5F, ((ConstraintAnchor)localObject4).mSolverVariable, ((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject4).getMargin(), 5);
            }
          }
          if ((localObject1 != null) && (localConstraintWidget3 != localConstraintWidget4)) {
            paramLinearSystem.addEquality(((ConstraintAnchor)localObject4).mSolverVariable, ((ConstraintAnchor)localObject1).mSolverVariable, -((ConstraintAnchor)localObject4).getMargin(), 5);
          }
        }
      }
    }
    if (((n != 0) || (i1 != 0)) && (localConstraintWidget3 != null))
    {
      localObject2 = localConstraintWidget3.mListAnchors;
      localObject1 = localObject2[paramInt2];
      paramConstraintWidgetContainer = localConstraintWidget4.mListAnchors;
      paramInt1 = paramInt2 + 1;
      localObject4 = paramConstraintWidgetContainer[paramInt1];
      paramConstraintWidgetContainer = ((ConstraintAnchor)localObject1).mTarget;
      if (paramConstraintWidgetContainer != null) {
        paramChainHead = paramConstraintWidgetContainer.mSolverVariable;
      } else {
        paramChainHead = null;
      }
      paramConstraintWidgetContainer = ((ConstraintAnchor)localObject4).mTarget;
      if (paramConstraintWidgetContainer != null) {
        paramConstraintWidgetContainer = paramConstraintWidgetContainer.mSolverVariable;
      } else {
        paramConstraintWidgetContainer = null;
      }
      if (localConstraintWidget2 != localConstraintWidget4)
      {
        localObject3 = localConstraintWidget2.mListAnchors[paramInt1].mTarget;
        paramConstraintWidgetContainer = arrayOfConstraintAnchor;
        if (localObject3 != null) {
          paramConstraintWidgetContainer = ((ConstraintAnchor)localObject3).mSolverVariable;
        }
      }
      if (localConstraintWidget3 == localConstraintWidget4)
      {
        localObject1 = localObject2[paramInt2];
        localObject4 = localObject2[paramInt1];
      }
      if ((paramChainHead != null) && (paramConstraintWidgetContainer != null))
      {
        paramInt2 = ((ConstraintAnchor)localObject1).getMargin();
        paramInt1 = localConstraintWidget4.mListAnchors[paramInt1].getMargin();
        paramLinearSystem.addCentering(((ConstraintAnchor)localObject1).mSolverVariable, paramChainHead, paramInt2, 0.5F, paramConstraintWidgetContainer, ((ConstraintAnchor)localObject4).mSolverVariable, paramInt1, 5);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\Chain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */