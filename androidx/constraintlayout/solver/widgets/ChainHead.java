package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

public class ChainHead
{
  private boolean mDefined;
  protected ConstraintWidget mFirst;
  protected ConstraintWidget mFirstMatchConstraintWidget;
  protected ConstraintWidget mFirstVisibleWidget;
  protected boolean mHasComplexMatchWeights;
  protected boolean mHasDefinedWeights;
  protected boolean mHasUndefinedWeights;
  protected ConstraintWidget mHead;
  private boolean mIsRtl = false;
  protected ConstraintWidget mLast;
  protected ConstraintWidget mLastMatchConstraintWidget;
  protected ConstraintWidget mLastVisibleWidget;
  private int mOrientation;
  protected float mTotalWeight = 0.0F;
  protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
  protected int mWidgetsCount;
  protected int mWidgetsMatchCount;
  
  public ChainHead(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean)
  {
    this.mFirst = paramConstraintWidget;
    this.mOrientation = paramInt;
    this.mIsRtl = paramBoolean;
  }
  
  private void defineChainProperties()
  {
    int i = this.mOrientation * 2;
    Object localObject1 = this.mFirst;
    boolean bool1 = false;
    Object localObject2 = localObject1;
    int j = 0;
    while (j == 0)
    {
      this.mWidgetsCount += 1;
      Object localObject3 = ((ConstraintWidget)localObject1).mNextChainWidget;
      int k = this.mOrientation;
      Object localObject4 = null;
      localObject3[k] = null;
      ((ConstraintWidget)localObject1).mListNextMatchConstraintsWidget[k] = null;
      if (((ConstraintWidget)localObject1).getVisibility() != 8)
      {
        if (this.mFirstVisibleWidget == null) {
          this.mFirstVisibleWidget = ((ConstraintWidget)localObject1);
        }
        this.mLastVisibleWidget = ((ConstraintWidget)localObject1);
        localObject3 = ((ConstraintWidget)localObject1).mListDimensionBehaviors;
        k = this.mOrientation;
        if (localObject3[k] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          localObject3 = ((ConstraintWidget)localObject1).mResolvedMatchConstraintDefault;
          if ((localObject3[k] == 0) || (localObject3[k] == 3) || (localObject3[k] == 2))
          {
            this.mWidgetsMatchCount += 1;
            localObject3 = ((ConstraintWidget)localObject1).mWeight;
            float f = localObject3[k];
            if (f > 0.0F) {
              this.mTotalWeight += localObject3[k];
            }
            if (isMatchConstraintEqualityCandidate((ConstraintWidget)localObject1, k))
            {
              if (f < 0.0F) {
                this.mHasUndefinedWeights = true;
              } else {
                this.mHasDefinedWeights = true;
              }
              if (this.mWeightedMatchConstraintsWidgets == null) {
                this.mWeightedMatchConstraintsWidgets = new ArrayList();
              }
              this.mWeightedMatchConstraintsWidgets.add(localObject1);
            }
            if (this.mFirstMatchConstraintWidget == null) {
              this.mFirstMatchConstraintWidget = ((ConstraintWidget)localObject1);
            }
            localObject3 = this.mLastMatchConstraintWidget;
            if (localObject3 != null) {
              ((ConstraintWidget)localObject3).mListNextMatchConstraintsWidget[this.mOrientation] = localObject1;
            }
            this.mLastMatchConstraintWidget = ((ConstraintWidget)localObject1);
          }
        }
      }
      if (localObject2 != localObject1) {
        ((ConstraintWidget)localObject2).mNextChainWidget[this.mOrientation] = localObject1;
      }
      localObject3 = localObject1.mListAnchors[(i + 1)].mTarget;
      localObject2 = localObject4;
      if (localObject3 != null)
      {
        localObject3 = ((ConstraintAnchor)localObject3).mOwner;
        ConstraintAnchor[] arrayOfConstraintAnchor = ((ConstraintWidget)localObject3).mListAnchors;
        localObject2 = localObject4;
        if (arrayOfConstraintAnchor[i].mTarget != null) {
          if (arrayOfConstraintAnchor[i].mTarget.mOwner != localObject1) {
            localObject2 = localObject4;
          } else {
            localObject2 = localObject3;
          }
        }
      }
      if (localObject2 == null)
      {
        localObject2 = localObject1;
        j = 1;
      }
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    this.mLast = ((ConstraintWidget)localObject1);
    if ((this.mOrientation == 0) && (this.mIsRtl)) {
      this.mHead = ((ConstraintWidget)localObject1);
    } else {
      this.mHead = this.mFirst;
    }
    boolean bool2 = bool1;
    if (this.mHasDefinedWeights)
    {
      bool2 = bool1;
      if (this.mHasUndefinedWeights) {
        bool2 = true;
      }
    }
    this.mHasComplexMatchWeights = bool2;
  }
  
  private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if ((paramConstraintWidget.getVisibility() != 8) && (paramConstraintWidget.mListDimensionBehaviors[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
    {
      paramConstraintWidget = paramConstraintWidget.mResolvedMatchConstraintDefault;
      if ((paramConstraintWidget[paramInt] == 0) || (paramConstraintWidget[paramInt] == 3)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void define()
  {
    if (!this.mDefined) {
      defineChainProperties();
    }
    this.mDefined = true;
  }
  
  public ConstraintWidget getFirst()
  {
    return this.mFirst;
  }
  
  public ConstraintWidget getFirstMatchConstraintWidget()
  {
    return this.mFirstMatchConstraintWidget;
  }
  
  public ConstraintWidget getFirstVisibleWidget()
  {
    return this.mFirstVisibleWidget;
  }
  
  public ConstraintWidget getHead()
  {
    return this.mHead;
  }
  
  public ConstraintWidget getLast()
  {
    return this.mLast;
  }
  
  public ConstraintWidget getLastMatchConstraintWidget()
  {
    return this.mLastMatchConstraintWidget;
  }
  
  public ConstraintWidget getLastVisibleWidget()
  {
    return this.mLastVisibleWidget;
  }
  
  public float getTotalWeight()
  {
    return this.mTotalWeight;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ChainHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */