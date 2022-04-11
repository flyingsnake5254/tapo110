package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class ConstraintWidget
{
  protected static final int ANCHOR_BASELINE = 4;
  protected static final int ANCHOR_BOTTOM = 3;
  protected static final int ANCHOR_LEFT = 0;
  protected static final int ANCHOR_RIGHT = 1;
  protected static final int ANCHOR_TOP = 2;
  private static final boolean AUTOTAG_CENTER = false;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  public static float DEFAULT_BIAS = 0.5F;
  static final int DIMENSION_HORIZONTAL = 0;
  static final int DIMENSION_VERTICAL = 1;
  protected static final int DIRECT = 2;
  public static final int GONE = 8;
  public static final int HORIZONTAL = 0;
  public static final int INVISIBLE = 4;
  public static final int MATCH_CONSTRAINT_PERCENT = 2;
  public static final int MATCH_CONSTRAINT_RATIO = 3;
  public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  protected static final int SOLVER = 1;
  public static final int UNKNOWN = -1;
  public static final int VERTICAL = 1;
  public static final int VISIBLE = 0;
  private static final int WRAP = -2;
  protected ArrayList<ConstraintAnchor> mAnchors;
  ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
  int mBaselineDistance;
  ConstraintWidgetGroup mBelongingGroup = null;
  ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
  boolean mBottomHasCentered;
  ConstraintAnchor mCenter;
  ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
  ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
  private float mCircleConstraintAngle = 0.0F;
  private Object mCompanionWidget;
  private int mContainerItemSkip;
  private String mDebugName;
  protected float mDimensionRatio;
  protected int mDimensionRatioSide;
  int mDistToBottom;
  int mDistToLeft;
  int mDistToRight;
  int mDistToTop;
  private int mDrawHeight;
  private int mDrawWidth;
  private int mDrawX;
  private int mDrawY;
  boolean mGroupsToSolver;
  int mHeight;
  float mHorizontalBiasPercent;
  boolean mHorizontalChainFixedPosition;
  int mHorizontalChainStyle;
  ConstraintWidget mHorizontalNextWidget;
  public int mHorizontalResolution = -1;
  boolean mHorizontalWrapVisited;
  boolean mIsHeightWrapContent;
  boolean mIsWidthWrapContent;
  ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
  boolean mLeftHasCentered;
  protected ConstraintAnchor[] mListAnchors;
  protected DimensionBehaviour[] mListDimensionBehaviors;
  protected ConstraintWidget[] mListNextMatchConstraintsWidget;
  int mMatchConstraintDefaultHeight = 0;
  int mMatchConstraintDefaultWidth = 0;
  int mMatchConstraintMaxHeight = 0;
  int mMatchConstraintMaxWidth = 0;
  int mMatchConstraintMinHeight = 0;
  int mMatchConstraintMinWidth = 0;
  float mMatchConstraintPercentHeight = 1.0F;
  float mMatchConstraintPercentWidth = 1.0F;
  private int[] mMaxDimension = { Integer.MAX_VALUE, Integer.MAX_VALUE };
  protected int mMinHeight;
  protected int mMinWidth;
  protected ConstraintWidget[] mNextChainWidget;
  protected int mOffsetX;
  protected int mOffsetY;
  boolean mOptimizerMeasurable;
  boolean mOptimizerMeasured;
  ConstraintWidget mParent;
  int mRelX;
  int mRelY;
  ResolutionDimension mResolutionHeight;
  ResolutionDimension mResolutionWidth;
  float mResolvedDimensionRatio = 1.0F;
  int mResolvedDimensionRatioSide = -1;
  int[] mResolvedMatchConstraintDefault = new int[2];
  ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
  boolean mRightHasCentered;
  ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
  boolean mTopHasCentered;
  private String mType;
  float mVerticalBiasPercent;
  boolean mVerticalChainFixedPosition;
  int mVerticalChainStyle;
  ConstraintWidget mVerticalNextWidget;
  public int mVerticalResolution = -1;
  boolean mVerticalWrapVisited;
  private int mVisibility;
  float[] mWeight;
  int mWidth;
  private int mWrapHeight;
  private int mWrapWidth;
  protected int mX;
  protected int mY;
  
  public ConstraintWidget()
  {
    Object localObject = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    this.mCenter = ((ConstraintAnchor)localObject);
    this.mListAnchors = new ConstraintAnchor[] { this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, localObject };
    this.mAnchors = new ArrayList();
    localObject = DimensionBehaviour.FIXED;
    this.mListDimensionBehaviors = new DimensionBehaviour[] { localObject, localObject };
    this.mParent = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mDimensionRatio = 0.0F;
    this.mDimensionRatioSide = -1;
    this.mX = 0;
    this.mY = 0;
    this.mRelX = 0;
    this.mRelY = 0;
    this.mDrawX = 0;
    this.mDrawY = 0;
    this.mDrawWidth = 0;
    this.mDrawHeight = 0;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mBaselineDistance = 0;
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mOptimizerMeasurable = false;
    this.mOptimizerMeasured = false;
    this.mGroupsToSolver = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mWeight = new float[] { -1.0F, -1.0F };
    this.mListNextMatchConstraintsWidget = new ConstraintWidget[] { null, null };
    this.mNextChainWidget = new ConstraintWidget[] { null, null };
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    addAnchors();
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2)
  {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    this.mCenter = ((ConstraintAnchor)localObject);
    this.mListAnchors = new ConstraintAnchor[] { this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, localObject };
    this.mAnchors = new ArrayList();
    localObject = DimensionBehaviour.FIXED;
    this.mListDimensionBehaviors = new DimensionBehaviour[] { localObject, localObject };
    this.mParent = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mDimensionRatio = 0.0F;
    this.mDimensionRatioSide = -1;
    this.mX = 0;
    this.mY = 0;
    this.mRelX = 0;
    this.mRelY = 0;
    this.mDrawX = 0;
    this.mDrawY = 0;
    this.mDrawWidth = 0;
    this.mDrawHeight = 0;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mBaselineDistance = 0;
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mOptimizerMeasurable = false;
    this.mOptimizerMeasured = false;
    this.mGroupsToSolver = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mWeight = new float[] { -1.0F, -1.0F };
    this.mListNextMatchConstraintsWidget = new ConstraintWidget[] { null, null };
    this.mNextChainWidget = new ConstraintWidget[] { null, null };
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    this.mX = paramInt1;
    this.mY = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    addAnchors();
    forceUpdateDrawPosition();
  }
  
  private void addAnchors()
  {
    this.mAnchors.add(this.mLeft);
    this.mAnchors.add(this.mTop);
    this.mAnchors.add(this.mRight);
    this.mAnchors.add(this.mBottom);
    this.mAnchors.add(this.mCenterX);
    this.mAnchors.add(this.mCenterY);
    this.mAnchors.add(this.mCenter);
    this.mAnchors.add(this.mBaseline);
  }
  
  private void applyConstraints(LinearSystem paramLinearSystem, boolean paramBoolean1, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, DimensionBehaviour paramDimensionBehaviour, boolean paramBoolean2, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, boolean paramBoolean5)
  {
    SolverVariable localSolverVariable1 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1);
    SolverVariable localSolverVariable2 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2);
    SolverVariable localSolverVariable3 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1.getTarget());
    Object localObject1 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2.getTarget());
    if ((paramLinearSystem.graphOptimizer) && (paramConstraintAnchor1.getResolutionNode().state == 1) && (paramConstraintAnchor2.getResolutionNode().state == 1))
    {
      if (LinearSystem.getMetrics() != null)
      {
        paramSolverVariable1 = LinearSystem.getMetrics();
        paramSolverVariable1.resolvedWidgets += 1L;
      }
      paramConstraintAnchor1.getResolutionNode().addResolvedValue(paramLinearSystem);
      paramConstraintAnchor2.getResolutionNode().addResolvedValue(paramLinearSystem);
      if ((!paramBoolean4) && (paramBoolean1)) {
        paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, 0, 6);
      }
      return;
    }
    if (LinearSystem.getMetrics() != null)
    {
      localObject2 = LinearSystem.getMetrics();
      ((Metrics)localObject2).nonresolvedWidgets += 1L;
    }
    int i = paramConstraintAnchor1.isConnected();
    boolean bool1 = paramConstraintAnchor2.isConnected();
    boolean bool2 = this.mCenter.isConnected();
    if (bool1) {
      j = i + 1;
    } else {
      j = i;
    }
    int k = j;
    if (bool2) {
      k = j + 1;
    }
    if (paramBoolean3) {
      paramInt5 = 3;
    }
    int j = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[paramDimensionBehaviour.ordinal()];
    if ((j == 1) || (j == 2) || (j == 3) || (j != 4)) {}
    while (paramInt5 == 4)
    {
      j = 0;
      break;
    }
    j = 1;
    if (this.mVisibility == 8)
    {
      paramInt2 = 0;
      j = 0;
    }
    if (paramBoolean5) {
      if ((i == 0) && (!bool1) && (!bool2)) {
        paramLinearSystem.addEquality(localSolverVariable1, paramInt1);
      } else if ((i != 0) && (!bool1)) {
        paramLinearSystem.addEquality(localSolverVariable1, localSolverVariable3, paramConstraintAnchor1.getMargin(), 6);
      }
    }
    if (j == 0)
    {
      if (paramBoolean2)
      {
        paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, 0, 3);
        if (paramInt3 > 0) {
          paramLinearSystem.addGreaterThan(localSolverVariable2, localSolverVariable1, paramInt3, 6);
        }
        if (paramInt4 < Integer.MAX_VALUE) {
          paramLinearSystem.addLowerThan(localSolverVariable2, localSolverVariable1, paramInt4, 6);
        }
      }
      else
      {
        paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt2, 6);
      }
      paramInt1 = paramInt5;
      paramInt4 = j;
      paramInt5 = paramInt7;
      paramInt2 = paramInt1;
    }
    else
    {
      paramInt1 = paramInt6;
      if (paramInt6 == -2) {
        paramInt1 = paramInt2;
      }
      paramInt4 = paramInt7;
      if (paramInt7 == -2) {
        paramInt4 = paramInt2;
      }
      paramInt6 = paramInt2;
      if (paramInt1 > 0)
      {
        paramLinearSystem.addGreaterThan(localSolverVariable2, localSolverVariable1, paramInt1, 6);
        paramInt6 = Math.max(paramInt2, paramInt1);
      }
      paramInt7 = paramInt6;
      if (paramInt4 > 0)
      {
        paramLinearSystem.addLowerThan(localSolverVariable2, localSolverVariable1, paramInt4, 6);
        paramInt7 = Math.min(paramInt6, paramInt4);
      }
      if (paramInt5 == 1)
      {
        if (paramBoolean1) {
          paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt7, 6);
        } else if (paramBoolean4) {
          paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt7, 4);
        } else {
          paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt7, 1);
        }
      }
      else if (paramInt5 == 2)
      {
        paramDimensionBehaviour = paramConstraintAnchor1.getType();
        localObject2 = ConstraintAnchor.Type.TOP;
        if ((paramDimensionBehaviour != localObject2) && (paramConstraintAnchor1.getType() != ConstraintAnchor.Type.BOTTOM))
        {
          localObject2 = paramLinearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
          paramDimensionBehaviour = paramLinearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
        }
        else
        {
          localObject2 = paramLinearSystem.createObjectVariable(this.mParent.getAnchor((ConstraintAnchor.Type)localObject2));
          paramDimensionBehaviour = paramLinearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
        }
        ArrayRow localArrayRow = paramLinearSystem.createRow();
        paramInt2 = paramInt5;
        paramLinearSystem.addConstraint(localArrayRow.createRowDimensionRatio(localSolverVariable2, localSolverVariable1, paramDimensionBehaviour, (SolverVariable)localObject2, paramFloat2));
        paramInt5 = 0;
        break label740;
      }
      paramInt2 = paramInt5;
      paramInt5 = j;
      label740:
      j = paramInt4;
      if ((paramInt5 != 0) && (k != 2) && (!paramBoolean3))
      {
        paramInt5 = Math.max(paramInt1, paramInt7);
        paramInt4 = paramInt5;
        if (j > 0) {
          paramInt4 = Math.min(j, paramInt5);
        }
        paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt4, 6);
        paramInt4 = 0;
        paramInt5 = j;
        paramInt6 = paramInt1;
      }
      else
      {
        paramInt4 = paramInt5;
        paramInt6 = paramInt1;
        paramInt5 = j;
      }
    }
    Object localObject2 = localSolverVariable3;
    paramDimensionBehaviour = (DimensionBehaviour)localObject1;
    if ((paramBoolean5) && (!paramBoolean4))
    {
      if ((i == 0) && (!bool1) && (!bool2))
      {
        if (paramBoolean1) {
          paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, 0, 5);
        }
      }
      else if ((i != 0) && (!bool1))
      {
        if (paramBoolean1) {
          paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, 0, 5);
        }
      }
      else if ((i == 0) && (bool1))
      {
        paramLinearSystem.addEquality(localSolverVariable2, paramDimensionBehaviour, -paramConstraintAnchor2.getMargin(), 6);
        if (paramBoolean1) {
          paramLinearSystem.addGreaterThan(localSolverVariable1, paramSolverVariable1, 0, 5);
        }
      }
      else if ((i != 0) && (bool1))
      {
        if (paramInt4 != 0)
        {
          localObject1 = paramDimensionBehaviour;
          if ((paramBoolean1) && (paramInt3 == 0)) {
            paramLinearSystem.addGreaterThan(localSolverVariable2, localSolverVariable1, 0, 6);
          }
          if (paramInt2 == 0)
          {
            if ((paramInt5 <= 0) && (paramInt6 <= 0))
            {
              paramInt2 = 6;
              paramInt1 = 0;
            }
            else
            {
              paramInt2 = 4;
              paramInt1 = 1;
            }
            paramLinearSystem.addEquality(localSolverVariable1, (SolverVariable)localObject2, paramConstraintAnchor1.getMargin(), paramInt2);
            paramLinearSystem.addEquality(localSolverVariable2, (SolverVariable)localObject1, -paramConstraintAnchor2.getMargin(), paramInt2);
            if ((paramInt5 <= 0) && (paramInt6 <= 0)) {
              paramInt3 = 0;
            } else {
              paramInt3 = 1;
            }
            paramInt5 = 5;
            paramInt2 = paramInt1;
            paramInt1 = paramInt5;
          }
          else
          {
            if (paramInt2 != 1) {
              break label1122;
            }
            paramInt3 = 1;
            paramInt2 = 1;
            paramInt1 = 6;
          }
          paramInt5 = paramInt3;
          paramInt3 = paramInt2;
          paramInt6 = paramInt1;
          break label1221;
          label1122:
          if (paramInt2 == 3)
          {
            if ((!paramBoolean3) && (this.mResolvedDimensionRatioSide != -1) && (paramInt5 <= 0)) {
              paramInt1 = 6;
            } else {
              paramInt1 = 4;
            }
            paramLinearSystem.addEquality(localSolverVariable1, (SolverVariable)localObject2, paramConstraintAnchor1.getMargin(), paramInt1);
            paramLinearSystem.addEquality(localSolverVariable2, (SolverVariable)localObject1, -paramConstraintAnchor2.getMargin(), paramInt1);
            paramInt1 = 1;
            paramInt2 = 1;
            break label1210;
          }
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = 1;
        }
        paramInt2 = 0;
        label1210:
        paramInt6 = 5;
        paramInt3 = paramInt2;
        paramInt5 = paramInt1;
        label1221:
        if (paramInt5 != 0)
        {
          paramLinearSystem.addCentering(localSolverVariable1, (SolverVariable)localObject2, paramConstraintAnchor1.getMargin(), paramFloat1, paramDimensionBehaviour, localSolverVariable2, paramConstraintAnchor2.getMargin(), paramInt6);
          paramBoolean2 = paramConstraintAnchor1.mTarget.mOwner instanceof Barrier;
          paramBoolean3 = paramConstraintAnchor2.mTarget.mOwner instanceof Barrier;
          if ((paramBoolean2) && (!paramBoolean3))
          {
            paramBoolean2 = paramBoolean1;
            paramInt1 = 6;
            paramInt2 = 5;
            paramBoolean3 = true;
            break label1343;
          }
          if ((!paramBoolean2) && (paramBoolean3))
          {
            paramBoolean3 = paramBoolean1;
            paramInt1 = 5;
            paramInt2 = 6;
            paramBoolean2 = true;
            break label1343;
          }
        }
        paramBoolean2 = paramBoolean1;
        paramBoolean3 = paramBoolean2;
        paramInt1 = 5;
        paramInt2 = 5;
        label1343:
        if (paramInt3 != 0)
        {
          paramInt1 = 6;
          paramInt2 = 6;
        }
        if (((paramInt4 == 0) && (paramBoolean2)) || (paramInt3 != 0)) {
          paramLinearSystem.addGreaterThan(localSolverVariable1, (SolverVariable)localObject2, paramConstraintAnchor1.getMargin(), paramInt2);
        }
        if (((paramInt4 == 0) && (paramBoolean3)) || (paramInt3 != 0)) {
          paramLinearSystem.addLowerThan(localSolverVariable2, paramDimensionBehaviour, -paramConstraintAnchor2.getMargin(), paramInt1);
        }
        if (paramBoolean1) {
          paramLinearSystem.addGreaterThan(localSolverVariable1, paramSolverVariable1, 0, 6);
        }
      }
      if (paramBoolean1) {
        paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, 0, 6);
      }
      return;
    }
    if ((k < 2) && (paramBoolean1))
    {
      paramLinearSystem.addGreaterThan(localSolverVariable1, paramSolverVariable1, 0, 6);
      paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, 0, 6);
    }
  }
  
  private boolean isChainHead(int paramInt)
  {
    paramInt *= 2;
    ConstraintAnchor[] arrayOfConstraintAnchor = this.mListAnchors;
    ConstraintAnchor localConstraintAnchor = arrayOfConstraintAnchor[paramInt].mTarget;
    boolean bool = true;
    if ((localConstraintAnchor != null) && (arrayOfConstraintAnchor[paramInt].mTarget.mTarget != arrayOfConstraintAnchor[paramInt]))
    {
      paramInt++;
      if ((arrayOfConstraintAnchor[paramInt].mTarget != null) && (arrayOfConstraintAnchor[paramInt].mTarget.mTarget == arrayOfConstraintAnchor[paramInt])) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    SolverVariable localSolverVariable1 = paramLinearSystem.createObjectVariable(this.mLeft);
    SolverVariable localSolverVariable2 = paramLinearSystem.createObjectVariable(this.mRight);
    Object localObject1 = paramLinearSystem.createObjectVariable(this.mTop);
    SolverVariable localSolverVariable3 = paramLinearSystem.createObjectVariable(this.mBottom);
    Object localObject2 = paramLinearSystem.createObjectVariable(this.mBaseline);
    Object localObject3 = this.mParent;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (localObject3 != null)
    {
      if ((localObject3 != null) && (localObject3.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((localObject3 != null) && (localObject3.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (isChainHead(0))
      {
        ((ConstraintWidgetContainer)this.mParent).addChain(this, 0);
        bool3 = true;
      }
      else
      {
        bool3 = isInHorizontalChain();
      }
      if (isChainHead(1))
      {
        ((ConstraintWidgetContainer)this.mParent).addChain(this, 1);
        bool4 = true;
      }
      else
      {
        bool4 = isInVerticalChain();
      }
      if ((bool1) && (this.mVisibility != 8) && (this.mLeft.mTarget == null) && (this.mRight.mTarget == null)) {
        paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(this.mParent.mRight), localSolverVariable2, 0, 1);
      }
      if ((bool2) && (this.mVisibility != 8) && (this.mTop.mTarget == null) && (this.mBottom.mTarget == null) && (this.mBaseline == null)) {
        paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(this.mParent.mBottom), localSolverVariable3, 0, 1);
      }
      bool5 = bool4;
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool3;
      bool3 = bool5;
    }
    else
    {
      bool4 = false;
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
    int i = this.mWidth;
    int j = this.mMinWidth;
    if (i >= j) {
      j = i;
    }
    int k = this.mHeight;
    int m = this.mMinHeight;
    if (k >= m) {
      m = k;
    }
    Object localObject4 = this.mListDimensionBehaviors;
    Object localObject5 = localObject4[0];
    localObject3 = DimensionBehaviour.MATCH_CONSTRAINT;
    if (localObject5 != localObject3) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool6;
    if (localObject4[1] != localObject3) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    int n = this.mDimensionRatioSide;
    this.mResolvedDimensionRatioSide = n;
    float f = this.mDimensionRatio;
    this.mResolvedDimensionRatio = f;
    int i1 = this.mMatchConstraintDefaultWidth;
    int i2 = this.mMatchConstraintDefaultHeight;
    if (f > 0.0F)
    {
      int i3 = this.mVisibility;
      i4 = m;
      if (i3 != 8)
      {
        m = i1;
        if (localObject4[0] == localObject3)
        {
          m = i1;
          if (i1 == 0) {
            m = 3;
          }
        }
        i1 = i2;
        if (localObject4[1] == localObject3)
        {
          i1 = i2;
          if (i2 == 0) {
            i1 = 3;
          }
        }
        if ((localObject4[0] == localObject3) && (localObject4[1] == localObject3) && (m == 3) && (i1 == 3))
        {
          setupDimensionRatio(bool4, bool1, bool5, bool6);
        }
        else
        {
          if ((localObject4[0] == localObject3) && (m == 3))
          {
            this.mResolvedDimensionRatioSide = 0;
            j = (int)(f * k);
            localObject5 = localObject4[1];
            if (localObject5 != localObject3)
            {
              i2 = i1;
              m = 0;
              i1 = 4;
              break label748;
            }
            break label727;
          }
          if ((localObject4[1] == localObject3) && (i1 == 3))
          {
            this.mResolvedDimensionRatioSide = 1;
            if (n == -1) {
              this.mResolvedDimensionRatio = (1.0F / f);
            }
            i4 = (int)(this.mResolvedDimensionRatio * i);
            localObject5 = localObject4[0];
            i = m;
            i2 = i4;
            if (localObject5 == localObject3) {
              break label723;
            }
            m = 0;
            i2 = 4;
            i1 = i;
            break label748;
          }
        }
        i2 = i4;
        label723:
        i4 = i2;
        label727:
        i2 = i1;
        i1 = m;
        m = 1;
        break label748;
      }
    }
    int i4 = m;
    m = 0;
    label748:
    localObject3 = this.mResolvedMatchConstraintDefault;
    localObject3[0] = i1;
    localObject3[1] = i2;
    if (m != 0)
    {
      i = this.mResolvedDimensionRatioSide;
      if ((i == 0) || (i == -1))
      {
        bool5 = true;
        break label797;
      }
    }
    boolean bool5 = false;
    label797:
    localObject3 = this.mListDimensionBehaviors[0];
    localObject4 = DimensionBehaviour.WRAP_CONTENT;
    if ((localObject3 == localObject4) && ((this instanceof ConstraintWidgetContainer))) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    boolean bool7 = this.mCenter.isConnected() ^ true;
    if (this.mHorizontalResolution != 2)
    {
      localObject3 = this.mParent;
      if (localObject3 != null) {
        localObject3 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject3).mRight);
      } else {
        localObject3 = null;
      }
      localObject5 = this.mParent;
      if (localObject5 != null) {
        localObject5 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mLeft);
      } else {
        localObject5 = null;
      }
      applyConstraints(paramLinearSystem, bool4, (SolverVariable)localObject5, (SolverVariable)localObject3, this.mListDimensionBehaviors[0], bool6, this.mLeft, this.mRight, this.mX, j, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, bool5, bool2, i1, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, bool7);
    }
    localObject3 = localObject1;
    if (this.mVerticalResolution == 2) {
      return;
    }
    if ((this.mListDimensionBehaviors[1] == localObject4) && ((this instanceof ConstraintWidgetContainer))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (m != 0)
    {
      j = this.mResolvedDimensionRatioSide;
      if ((j == 1) || (j == -1))
      {
        bool4 = true;
        break label1050;
      }
    }
    boolean bool4 = false;
    label1050:
    if (this.mBaselineDistance > 0) {
      if (this.mBaseline.getResolutionNode().state == 1)
      {
        this.mBaseline.getResolutionNode().addResolvedValue(paramLinearSystem);
      }
      else
      {
        localObject5 = paramLinearSystem;
        ((LinearSystem)localObject5).addEquality((SolverVariable)localObject2, (SolverVariable)localObject3, getBaselineDistance(), 6);
        localObject1 = this.mBaseline.mTarget;
        if (localObject1 != null)
        {
          ((LinearSystem)localObject5).addEquality((SolverVariable)localObject2, ((LinearSystem)localObject5).createObjectVariable(localObject1), 0, 6);
          bool5 = false;
          break label1146;
        }
      }
    }
    bool5 = bool7;
    label1146:
    localObject5 = paramLinearSystem;
    localObject2 = localObject3;
    localObject3 = this.mParent;
    if (localObject3 != null) {
      localObject3 = ((LinearSystem)localObject5).createObjectVariable(((ConstraintWidget)localObject3).mBottom);
    } else {
      localObject3 = null;
    }
    localObject1 = this.mParent;
    if (localObject1 != null) {
      localObject5 = ((LinearSystem)localObject5).createObjectVariable(((ConstraintWidget)localObject1).mTop);
    } else {
      localObject5 = null;
    }
    applyConstraints(paramLinearSystem, bool1, (SolverVariable)localObject5, (SolverVariable)localObject3, this.mListDimensionBehaviors[1], bool2, this.mTop, this.mBottom, this.mY, i4, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, bool4, bool3, i2, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, bool5);
    if (m != 0)
    {
      localObject3 = this;
      if (((ConstraintWidget)localObject3).mResolvedDimensionRatioSide == 1) {
        paramLinearSystem.addRatio(localSolverVariable3, (SolverVariable)localObject2, localSolverVariable2, localSolverVariable1, ((ConstraintWidget)localObject3).mResolvedDimensionRatio, 6);
      } else {
        paramLinearSystem.addRatio(localSolverVariable2, localSolverVariable1, localSolverVariable3, (SolverVariable)localObject2, ((ConstraintWidget)localObject3).mResolvedDimensionRatio, 6);
      }
    }
    localObject3 = this;
    if (((ConstraintWidget)localObject3).mCenter.isConnected()) {
      paramLinearSystem.addCenterPoint((ConstraintWidget)localObject3, ((ConstraintWidget)localObject3).mCenter.getTarget().getOwner(), (float)Math.toRadians(((ConstraintWidget)localObject3).mCircleConstraintAngle + 90.0F), ((ConstraintWidget)localObject3).mCenter.getMargin());
    }
  }
  
  public boolean allowedInBarrier()
  {
    boolean bool;
    if (this.mVisibility != 8) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void analyze(int paramInt)
  {
    Optimizer.analyze(paramInt, this);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2)
  {
    connect(paramType1, paramConstraintWidget, paramType2, 0, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt)
  {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt, ConstraintAnchor.Strength paramStrength)
  {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, paramStrength, 0);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2)
  {
    ConstraintAnchor.Type localType1 = ConstraintAnchor.Type.CENTER;
    int i = 0;
    ConstraintAnchor.Type localType3;
    Object localObject1;
    Object localObject2;
    if (paramType1 == localType1)
    {
      if (paramType2 == localType1)
      {
        ConstraintAnchor.Type localType2 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor localConstraintAnchor1 = getAnchor(localType2);
        localType3 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor localConstraintAnchor2 = getAnchor(localType3);
        localObject1 = ConstraintAnchor.Type.TOP;
        localObject2 = getAnchor((ConstraintAnchor.Type)localObject1);
        paramType1 = ConstraintAnchor.Type.BOTTOM;
        paramType2 = getAnchor(paramType1);
        i = 1;
        if (((localConstraintAnchor1 != null) && (localConstraintAnchor1.isConnected())) || ((localConstraintAnchor2 != null) && (localConstraintAnchor2.isConnected())))
        {
          paramInt1 = 0;
        }
        else
        {
          connect(localType2, paramConstraintWidget, localType2, 0, paramStrength, paramInt2);
          connect(localType3, paramConstraintWidget, localType3, 0, paramStrength, paramInt2);
          paramInt1 = 1;
        }
        if (((localObject2 != null) && (((ConstraintAnchor)localObject2).isConnected())) || ((paramType2 != null) && (paramType2.isConnected())))
        {
          i = 0;
        }
        else
        {
          connect((ConstraintAnchor.Type)localObject1, paramConstraintWidget, (ConstraintAnchor.Type)localObject1, 0, paramStrength, paramInt2);
          connect(paramType1, paramConstraintWidget, paramType1, 0, paramStrength, paramInt2);
        }
        if ((paramInt1 != 0) && (i != 0))
        {
          getAnchor(localType1).connect(paramConstraintWidget.getAnchor(localType1), 0, paramInt2);
          break label978;
        }
        if (paramInt1 != 0)
        {
          paramType1 = ConstraintAnchor.Type.CENTER_X;
          getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType1), 0, paramInt2);
          break label978;
        }
        if (i == 0) {
          break label978;
        }
        paramType1 = ConstraintAnchor.Type.CENTER_Y;
        getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType1), 0, paramInt2);
        break label978;
      }
      paramType1 = ConstraintAnchor.Type.LEFT;
      if ((paramType2 != paramType1) && (paramType2 != ConstraintAnchor.Type.RIGHT))
      {
        paramType1 = ConstraintAnchor.Type.TOP;
        if ((paramType2 != paramType1) && (paramType2 != ConstraintAnchor.Type.BOTTOM)) {
          break label978;
        }
        connect(paramType1, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
        connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
        getAnchor(localType1).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
        break label978;
      }
      connect(paramType1, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
      paramType1 = ConstraintAnchor.Type.RIGHT;
    }
    try
    {
      connect(paramType1, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
      getAnchor(localType1).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
      break label978;
      localObject2 = ConstraintAnchor.Type.CENTER_X;
      if (paramType1 == localObject2)
      {
        localObject1 = ConstraintAnchor.Type.LEFT;
        if ((paramType2 == localObject1) || (paramType2 == ConstraintAnchor.Type.RIGHT))
        {
          paramType1 = getAnchor((ConstraintAnchor.Type)localObject1);
          paramType2 = paramConstraintWidget.getAnchor(paramType2);
          paramConstraintWidget = getAnchor(ConstraintAnchor.Type.RIGHT);
          paramType1.connect(paramType2, 0, paramInt2);
          paramConstraintWidget.connect(paramType2, 0, paramInt2);
          getAnchor((ConstraintAnchor.Type)localObject2).connect(paramType2, 0, paramInt2);
          break label978;
        }
      }
      localType3 = ConstraintAnchor.Type.CENTER_Y;
      if (paramType1 == localType3)
      {
        localObject1 = ConstraintAnchor.Type.TOP;
        if ((paramType2 == localObject1) || (paramType2 == ConstraintAnchor.Type.BOTTOM))
        {
          paramType1 = paramConstraintWidget.getAnchor(paramType2);
          getAnchor((ConstraintAnchor.Type)localObject1).connect(paramType1, 0, paramInt2);
          getAnchor(ConstraintAnchor.Type.BOTTOM).connect(paramType1, 0, paramInt2);
          getAnchor(localType3).connect(paramType1, 0, paramInt2);
          break label978;
        }
      }
      if ((paramType1 == localObject2) && (paramType2 == localObject2))
      {
        paramType1 = ConstraintAnchor.Type.LEFT;
        getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType1), 0, paramInt2);
        paramType1 = ConstraintAnchor.Type.RIGHT;
        getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType1), 0, paramInt2);
        getAnchor((ConstraintAnchor.Type)localObject2).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
      }
      else if ((paramType1 == localType3) && (paramType2 == localType3))
      {
        paramType1 = ConstraintAnchor.Type.TOP;
        getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType1), 0, paramInt2);
        paramType1 = ConstraintAnchor.Type.BOTTOM;
        getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType1), 0, paramInt2);
        getAnchor(localType3).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
      }
      else
      {
        localObject1 = getAnchor(paramType1);
        paramConstraintWidget = paramConstraintWidget.getAnchor(paramType2);
        if (((ConstraintAnchor)localObject1).isValidConnection(paramConstraintWidget))
        {
          paramType2 = ConstraintAnchor.Type.BASELINE;
          if (paramType1 == paramType2)
          {
            paramType1 = getAnchor(ConstraintAnchor.Type.TOP);
            paramType2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            if (paramType1 != null) {
              paramType1.reset();
            }
            paramInt1 = i;
            if (paramType2 != null)
            {
              paramType2.reset();
              paramInt1 = i;
            }
          }
          for (;;)
          {
            break;
            if ((paramType1 != ConstraintAnchor.Type.TOP) && (paramType1 != ConstraintAnchor.Type.BOTTOM))
            {
              if ((paramType1 == ConstraintAnchor.Type.LEFT) || (paramType1 == ConstraintAnchor.Type.RIGHT))
              {
                paramType2 = getAnchor(localType1);
                if (paramType2.getTarget() != paramConstraintWidget) {
                  paramType2.reset();
                }
                paramType1 = getAnchor(paramType1).getOpposite();
                paramType2 = getAnchor((ConstraintAnchor.Type)localObject2);
                if (paramType2.isConnected())
                {
                  paramType1.reset();
                  paramType2.reset();
                }
              }
            }
            else
            {
              paramType2 = getAnchor(paramType2);
              if (paramType2 != null) {
                paramType2.reset();
              }
              paramType2 = getAnchor(localType1);
              if (paramType2.getTarget() != paramConstraintWidget) {
                paramType2.reset();
              }
              paramType1 = getAnchor(paramType1).getOpposite();
              paramType2 = getAnchor(localType3);
              if (paramType2.isConnected())
              {
                paramType1.reset();
                paramType2.reset();
              }
            }
          }
          ((ConstraintAnchor)localObject1).connect(paramConstraintWidget, paramInt1, paramStrength, paramInt2);
          paramConstraintWidget.getOwner().connectedTo(((ConstraintAnchor)localObject1).getOwner());
        }
      }
      label978:
      return;
    }
    finally {}
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt)
  {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt, ConstraintAnchor.Strength.STRONG, 0);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2)
  {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt1, ConstraintAnchor.Strength.STRONG, paramInt2);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2)
  {
    if (paramConstraintAnchor1.getOwner() == this) {
      connect(paramConstraintAnchor1.getType(), paramConstraintAnchor2.getOwner(), paramConstraintAnchor2.getType(), paramInt1, paramStrength, paramInt2);
    }
  }
  
  public void connectCircularConstraint(ConstraintWidget paramConstraintWidget, float paramFloat, int paramInt)
  {
    ConstraintAnchor.Type localType = ConstraintAnchor.Type.CENTER;
    immediateConnect(localType, paramConstraintWidget, localType, paramInt, 0);
    this.mCircleConstraintAngle = paramFloat;
  }
  
  public void connectedTo(ConstraintWidget paramConstraintWidget) {}
  
  public void createObjectVariables(LinearSystem paramLinearSystem)
  {
    paramLinearSystem.createObjectVariable(this.mLeft);
    paramLinearSystem.createObjectVariable(this.mTop);
    paramLinearSystem.createObjectVariable(this.mRight);
    paramLinearSystem.createObjectVariable(this.mBottom);
    if (this.mBaselineDistance > 0) {
      paramLinearSystem.createObjectVariable(this.mBaseline);
    }
  }
  
  public void disconnectUnlockedWidget(ConstraintWidget paramConstraintWidget)
  {
    ArrayList localArrayList = getAnchors();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)localArrayList.get(j);
      if ((localConstraintAnchor.isConnected()) && (localConstraintAnchor.getTarget().getOwner() == paramConstraintWidget) && (localConstraintAnchor.getConnectionCreator() == 2)) {
        localConstraintAnchor.reset();
      }
    }
  }
  
  public void disconnectWidget(ConstraintWidget paramConstraintWidget)
  {
    ArrayList localArrayList = getAnchors();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)localArrayList.get(j);
      if ((localConstraintAnchor.isConnected()) && (localConstraintAnchor.getTarget().getOwner() == paramConstraintWidget)) {
        localConstraintAnchor.reset();
      }
    }
  }
  
  public void forceUpdateDrawPosition()
  {
    int i = this.mX;
    int j = this.mY;
    int k = this.mWidth;
    int m = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = (k + i - i);
    this.mDrawHeight = (m + j - j);
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()])
    {
    default: 
      throw new AssertionError(paramType.name());
    case 9: 
      return null;
    case 8: 
      return this.mCenterY;
    case 7: 
      return this.mCenterX;
    case 6: 
      return this.mCenter;
    case 5: 
      return this.mBaseline;
    case 4: 
      return this.mBottom;
    case 3: 
      return this.mRight;
    case 2: 
      return this.mTop;
    }
    return this.mLeft;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return this.mAnchors;
  }
  
  public int getBaselineDistance()
  {
    return this.mBaselineDistance;
  }
  
  public float getBiasPercent(int paramInt)
  {
    if (paramInt == 0) {
      return this.mHorizontalBiasPercent;
    }
    if (paramInt == 1) {
      return this.mVerticalBiasPercent;
    }
    return -1.0F;
  }
  
  public int getBottom()
  {
    return getY() + this.mHeight;
  }
  
  public Object getCompanionWidget()
  {
    return this.mCompanionWidget;
  }
  
  public int getContainerItemSkip()
  {
    return this.mContainerItemSkip;
  }
  
  public String getDebugName()
  {
    return this.mDebugName;
  }
  
  public DimensionBehaviour getDimensionBehaviour(int paramInt)
  {
    if (paramInt == 0) {
      return getHorizontalDimensionBehaviour();
    }
    if (paramInt == 1) {
      return getVerticalDimensionBehaviour();
    }
    return null;
  }
  
  public float getDimensionRatio()
  {
    return this.mDimensionRatio;
  }
  
  public int getDimensionRatioSide()
  {
    return this.mDimensionRatioSide;
  }
  
  public int getDrawBottom()
  {
    return getDrawY() + this.mDrawHeight;
  }
  
  public int getDrawHeight()
  {
    return this.mDrawHeight;
  }
  
  public int getDrawRight()
  {
    return getDrawX() + this.mDrawWidth;
  }
  
  public int getDrawWidth()
  {
    return this.mDrawWidth;
  }
  
  public int getDrawX()
  {
    return this.mDrawX + this.mOffsetX;
  }
  
  public int getDrawY()
  {
    return this.mDrawY + this.mOffsetY;
  }
  
  public int getHeight()
  {
    if (this.mVisibility == 8) {
      return 0;
    }
    return this.mHeight;
  }
  
  public float getHorizontalBiasPercent()
  {
    return this.mHorizontalBiasPercent;
  }
  
  public ConstraintWidget getHorizontalChainControlWidget()
  {
    boolean bool = isInHorizontalChain();
    Object localObject1 = null;
    if (bool)
    {
      localObject1 = this;
      Object localObject2 = null;
      while ((localObject2 == null) && (localObject1 != null))
      {
        Object localObject3 = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.LEFT);
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getTarget();
        }
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getOwner();
        }
        if (localObject3 == getParent()) {
          return localObject1;
        }
        ConstraintAnchor localConstraintAnchor;
        if (localObject3 == null) {
          localConstraintAnchor = null;
        } else {
          localConstraintAnchor = ((ConstraintWidget)localObject3).getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        }
        if ((localConstraintAnchor != null) && (localConstraintAnchor.getOwner() != localObject1)) {
          localObject2 = localObject1;
        } else {
          localObject1 = localObject3;
        }
      }
      localObject1 = localObject2;
    }
    return (ConstraintWidget)localObject1;
  }
  
  public int getHorizontalChainStyle()
  {
    return this.mHorizontalChainStyle;
  }
  
  public DimensionBehaviour getHorizontalDimensionBehaviour()
  {
    return this.mListDimensionBehaviors[0];
  }
  
  public int getInternalDrawBottom()
  {
    return this.mDrawY + this.mDrawHeight;
  }
  
  public int getInternalDrawRight()
  {
    return this.mDrawX + this.mDrawWidth;
  }
  
  int getInternalDrawX()
  {
    return this.mDrawX;
  }
  
  int getInternalDrawY()
  {
    return this.mDrawY;
  }
  
  public int getLeft()
  {
    return getX();
  }
  
  public int getLength(int paramInt)
  {
    if (paramInt == 0) {
      return getWidth();
    }
    if (paramInt == 1) {
      return getHeight();
    }
    return 0;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxDimension[1];
  }
  
  public int getMaxWidth()
  {
    return this.mMaxDimension[0];
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public int getOptimizerWrapHeight()
  {
    int i = this.mHeight;
    int j = i;
    if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (this.mMatchConstraintDefaultHeight == 1)
      {
        i = Math.max(this.mMatchConstraintMinHeight, i);
      }
      else
      {
        i = this.mMatchConstraintMinHeight;
        if (i > 0) {
          this.mHeight = i;
        } else {
          i = 0;
        }
      }
      int k = this.mMatchConstraintMaxHeight;
      j = i;
      if (k > 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
    }
    return j;
  }
  
  public int getOptimizerWrapWidth()
  {
    int i = this.mWidth;
    int j = i;
    if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (this.mMatchConstraintDefaultWidth == 1)
      {
        i = Math.max(this.mMatchConstraintMinWidth, i);
      }
      else
      {
        i = this.mMatchConstraintMinWidth;
        if (i > 0) {
          this.mWidth = i;
        } else {
          i = 0;
        }
      }
      int k = this.mMatchConstraintMaxWidth;
      j = i;
      if (k > 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
    }
    return j;
  }
  
  public ConstraintWidget getParent()
  {
    return this.mParent;
  }
  
  int getRelativePositioning(int paramInt)
  {
    if (paramInt == 0) {
      return this.mRelX;
    }
    if (paramInt == 1) {
      return this.mRelY;
    }
    return 0;
  }
  
  public ResolutionDimension getResolutionHeight()
  {
    if (this.mResolutionHeight == null) {
      this.mResolutionHeight = new ResolutionDimension();
    }
    return this.mResolutionHeight;
  }
  
  public ResolutionDimension getResolutionWidth()
  {
    if (this.mResolutionWidth == null) {
      this.mResolutionWidth = new ResolutionDimension();
    }
    return this.mResolutionWidth;
  }
  
  public int getRight()
  {
    return getX() + this.mWidth;
  }
  
  public WidgetContainer getRootWidgetContainer()
  {
    for (ConstraintWidget localConstraintWidget = this; localConstraintWidget.getParent() != null; localConstraintWidget = localConstraintWidget.getParent()) {}
    if ((localConstraintWidget instanceof WidgetContainer)) {
      return (WidgetContainer)localConstraintWidget;
    }
    return null;
  }
  
  protected int getRootX()
  {
    return this.mX + this.mOffsetX;
  }
  
  protected int getRootY()
  {
    return this.mY + this.mOffsetY;
  }
  
  public int getTop()
  {
    return getY();
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public float getVerticalBiasPercent()
  {
    return this.mVerticalBiasPercent;
  }
  
  public ConstraintWidget getVerticalChainControlWidget()
  {
    boolean bool = isInVerticalChain();
    Object localObject1 = null;
    if (bool)
    {
      localObject1 = this;
      Object localObject2 = null;
      while ((localObject2 == null) && (localObject1 != null))
      {
        Object localObject3 = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.TOP);
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getTarget();
        }
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getOwner();
        }
        if (localObject3 == getParent()) {
          return localObject1;
        }
        ConstraintAnchor localConstraintAnchor;
        if (localObject3 == null) {
          localConstraintAnchor = null;
        } else {
          localConstraintAnchor = ((ConstraintWidget)localObject3).getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        }
        if ((localConstraintAnchor != null) && (localConstraintAnchor.getOwner() != localObject1)) {
          localObject2 = localObject1;
        } else {
          localObject1 = localObject3;
        }
      }
      localObject1 = localObject2;
    }
    return (ConstraintWidget)localObject1;
  }
  
  public int getVerticalChainStyle()
  {
    return this.mVerticalChainStyle;
  }
  
  public DimensionBehaviour getVerticalDimensionBehaviour()
  {
    return this.mListDimensionBehaviors[1];
  }
  
  public int getVisibility()
  {
    return this.mVisibility;
  }
  
  public int getWidth()
  {
    if (this.mVisibility == 8) {
      return 0;
    }
    return this.mWidth;
  }
  
  public int getWrapHeight()
  {
    return this.mWrapHeight;
  }
  
  public int getWrapWidth()
  {
    return this.mWrapWidth;
  }
  
  public int getX()
  {
    return this.mX;
  }
  
  public int getY()
  {
    return this.mY;
  }
  
  public boolean hasAncestor(ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget localConstraintWidget1 = getParent();
    if (localConstraintWidget1 == paramConstraintWidget) {
      return true;
    }
    ConstraintWidget localConstraintWidget2 = localConstraintWidget1;
    if (localConstraintWidget1 == paramConstraintWidget.getParent()) {
      return false;
    }
    while (localConstraintWidget2 != null)
    {
      if (localConstraintWidget2 == paramConstraintWidget) {
        return true;
      }
      if (localConstraintWidget2 == paramConstraintWidget.getParent()) {
        return true;
      }
      localConstraintWidget2 = localConstraintWidget2.getParent();
    }
    return false;
  }
  
  public boolean hasBaseline()
  {
    boolean bool;
    if (this.mBaselineDistance > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void immediateConnect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2)
  {
    getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType2), paramInt1, paramInt2, ConstraintAnchor.Strength.STRONG, 0, true);
  }
  
  public boolean isFullyResolved()
  {
    return (this.mLeft.getResolutionNode().state == 1) && (this.mRight.getResolutionNode().state == 1) && (this.mTop.getResolutionNode().state == 1) && (this.mBottom.getResolutionNode().state == 1);
  }
  
  public boolean isHeightWrapContent()
  {
    return this.mIsHeightWrapContent;
  }
  
  public boolean isInHorizontalChain()
  {
    ConstraintAnchor localConstraintAnchor1 = this.mLeft;
    ConstraintAnchor localConstraintAnchor2 = localConstraintAnchor1.mTarget;
    if ((localConstraintAnchor2 == null) || (localConstraintAnchor2.mTarget != localConstraintAnchor1))
    {
      localConstraintAnchor1 = this.mRight;
      localConstraintAnchor2 = localConstraintAnchor1.mTarget;
    }
    return (localConstraintAnchor2 != null) && (localConstraintAnchor2.mTarget == localConstraintAnchor1);
  }
  
  public boolean isInVerticalChain()
  {
    ConstraintAnchor localConstraintAnchor1 = this.mTop;
    ConstraintAnchor localConstraintAnchor2 = localConstraintAnchor1.mTarget;
    if ((localConstraintAnchor2 == null) || (localConstraintAnchor2.mTarget != localConstraintAnchor1))
    {
      localConstraintAnchor2 = this.mBottom;
      localConstraintAnchor1 = localConstraintAnchor2.mTarget;
    }
    return (localConstraintAnchor1 != null) && (localConstraintAnchor1.mTarget == localConstraintAnchor2);
  }
  
  public boolean isInsideConstraintLayout()
  {
    ConstraintWidget localConstraintWidget1 = getParent();
    ConstraintWidget localConstraintWidget2 = localConstraintWidget1;
    if (localConstraintWidget1 == null) {
      return false;
    }
    while (localConstraintWidget2 != null)
    {
      if ((localConstraintWidget2 instanceof ConstraintWidgetContainer)) {
        return true;
      }
      localConstraintWidget2 = localConstraintWidget2.getParent();
    }
    return false;
  }
  
  public boolean isRoot()
  {
    boolean bool;
    if (this.mParent == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isRootContainer()
  {
    if ((this instanceof ConstraintWidgetContainer))
    {
      ConstraintWidget localConstraintWidget = this.mParent;
      if ((localConstraintWidget == null) || (!(localConstraintWidget instanceof ConstraintWidgetContainer))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public boolean isSpreadHeight()
  {
    int i = this.mMatchConstraintDefaultHeight;
    boolean bool = true;
    if ((i != 0) || (this.mDimensionRatio != 0.0F) || (this.mMatchConstraintMinHeight != 0) || (this.mMatchConstraintMaxHeight != 0) || (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSpreadWidth()
  {
    int i = this.mMatchConstraintDefaultWidth;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i == 0)
    {
      bool2 = bool1;
      if (this.mDimensionRatio == 0.0F)
      {
        bool2 = bool1;
        if (this.mMatchConstraintMinWidth == 0)
        {
          bool2 = bool1;
          if (this.mMatchConstraintMaxWidth == 0)
          {
            bool2 = bool1;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean isWidthWrapContent()
  {
    return this.mIsWidthWrapContent;
  }
  
  public void reset()
  {
    this.mLeft.reset();
    this.mTop.reset();
    this.mRight.reset();
    this.mBottom.reset();
    this.mBaseline.reset();
    this.mCenterX.reset();
    this.mCenterY.reset();
    this.mCenter.reset();
    this.mParent = null;
    this.mCircleConstraintAngle = 0.0F;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mDimensionRatio = 0.0F;
    this.mDimensionRatioSide = -1;
    this.mX = 0;
    this.mY = 0;
    this.mDrawX = 0;
    this.mDrawY = 0;
    this.mDrawWidth = 0;
    this.mDrawHeight = 0;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mBaselineDistance = 0;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.mWrapWidth = 0;
    this.mWrapHeight = 0;
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    DimensionBehaviour[] arrayOfDimensionBehaviour = this.mListDimensionBehaviors;
    Object localObject = DimensionBehaviour.FIXED;
    arrayOfDimensionBehaviour[0] = localObject;
    arrayOfDimensionBehaviour[1] = localObject;
    this.mCompanionWidget = null;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mType = null;
    this.mHorizontalWrapVisited = false;
    this.mVerticalWrapVisited = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mHorizontalChainFixedPosition = false;
    this.mVerticalChainFixedPosition = false;
    localObject = this.mWeight;
    localObject[0] = -1.0F;
    localObject[1] = -1.0F;
    this.mHorizontalResolution = -1;
    this.mVerticalResolution = -1;
    localObject = this.mMaxDimension;
    localObject[0] = Integer.MAX_VALUE;
    localObject[1] = Integer.MAX_VALUE;
    this.mMatchConstraintDefaultWidth = 0;
    this.mMatchConstraintDefaultHeight = 0;
    this.mMatchConstraintPercentWidth = 1.0F;
    this.mMatchConstraintPercentHeight = 1.0F;
    this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
    this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
    this.mMatchConstraintMinWidth = 0;
    this.mMatchConstraintMinHeight = 0;
    this.mResolvedDimensionRatioSide = -1;
    this.mResolvedDimensionRatio = 1.0F;
    localObject = this.mResolutionWidth;
    if (localObject != null) {
      ((ResolutionDimension)localObject).reset();
    }
    localObject = this.mResolutionHeight;
    if (localObject != null) {
      ((ResolutionDimension)localObject).reset();
    }
    this.mBelongingGroup = null;
    this.mOptimizerMeasurable = false;
    this.mOptimizerMeasured = false;
    this.mGroupsToSolver = false;
  }
  
  public void resetAllConstraints()
  {
    resetAnchors();
    setVerticalBiasPercent(DEFAULT_BIAS);
    setHorizontalBiasPercent(DEFAULT_BIAS);
    if ((this instanceof ConstraintWidgetContainer)) {
      return;
    }
    DimensionBehaviour localDimensionBehaviour1 = getHorizontalDimensionBehaviour();
    DimensionBehaviour localDimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
    if (localDimensionBehaviour1 == localDimensionBehaviour2) {
      if (getWidth() == getWrapWidth()) {
        setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
      } else if (getWidth() > getMinWidth()) {
        setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
      }
    }
    if (getVerticalDimensionBehaviour() == localDimensionBehaviour2) {
      if (getHeight() == getWrapHeight()) {
        setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
      } else if (getHeight() > getMinHeight()) {
        setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
      }
    }
  }
  
  public void resetAnchor(ConstraintAnchor paramConstraintAnchor)
  {
    if ((getParent() != null) && ((getParent() instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    ConstraintAnchor localConstraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor localConstraintAnchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor localConstraintAnchor3 = getAnchor(ConstraintAnchor.Type.TOP);
    ConstraintAnchor localConstraintAnchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor localConstraintAnchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
    ConstraintAnchor localConstraintAnchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor localConstraintAnchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
    if (paramConstraintAnchor == localConstraintAnchor5)
    {
      if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor2.isConnected()) && (localConstraintAnchor1.getTarget() == localConstraintAnchor2.getTarget()))
      {
        localConstraintAnchor1.reset();
        localConstraintAnchor2.reset();
      }
      if ((localConstraintAnchor3.isConnected()) && (localConstraintAnchor4.isConnected()) && (localConstraintAnchor3.getTarget() == localConstraintAnchor4.getTarget()))
      {
        localConstraintAnchor3.reset();
        localConstraintAnchor4.reset();
      }
      this.mHorizontalBiasPercent = 0.5F;
      this.mVerticalBiasPercent = 0.5F;
    }
    else if (paramConstraintAnchor == localConstraintAnchor6)
    {
      if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor2.isConnected()) && (localConstraintAnchor1.getTarget().getOwner() == localConstraintAnchor2.getTarget().getOwner()))
      {
        localConstraintAnchor1.reset();
        localConstraintAnchor2.reset();
      }
      this.mHorizontalBiasPercent = 0.5F;
    }
    else if (paramConstraintAnchor == localConstraintAnchor7)
    {
      if ((localConstraintAnchor3.isConnected()) && (localConstraintAnchor4.isConnected()) && (localConstraintAnchor3.getTarget().getOwner() == localConstraintAnchor4.getTarget().getOwner()))
      {
        localConstraintAnchor3.reset();
        localConstraintAnchor4.reset();
      }
      this.mVerticalBiasPercent = 0.5F;
    }
    else if ((paramConstraintAnchor != localConstraintAnchor1) && (paramConstraintAnchor != localConstraintAnchor2))
    {
      if (((paramConstraintAnchor == localConstraintAnchor3) || (paramConstraintAnchor == localConstraintAnchor4)) && (localConstraintAnchor3.isConnected()) && (localConstraintAnchor3.getTarget() == localConstraintAnchor4.getTarget())) {
        localConstraintAnchor5.reset();
      }
    }
    else if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor1.getTarget() == localConstraintAnchor2.getTarget()))
    {
      localConstraintAnchor5.reset();
    }
    paramConstraintAnchor.reset();
  }
  
  public void resetAnchors()
  {
    ConstraintWidget localConstraintWidget = getParent();
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    int i = 0;
    int j = this.mAnchors.size();
    while (i < j)
    {
      ((ConstraintAnchor)this.mAnchors.get(i)).reset();
      i++;
    }
  }
  
  public void resetAnchors(int paramInt)
  {
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    int i = 0;
    int j = this.mAnchors.size();
    while (i < j)
    {
      localObject = (ConstraintAnchor)this.mAnchors.get(i);
      if (paramInt == ((ConstraintAnchor)localObject).getConnectionCreator())
      {
        if (((ConstraintAnchor)localObject).isVerticalAnchor()) {
          setVerticalBiasPercent(DEFAULT_BIAS);
        } else {
          setHorizontalBiasPercent(DEFAULT_BIAS);
        }
        ((ConstraintAnchor)localObject).reset();
      }
      i++;
    }
  }
  
  public void resetResolutionNodes()
  {
    for (int i = 0; i < 6; i++) {
      this.mListAnchors[i].getResolutionNode().reset();
    }
  }
  
  public void resetSolverVariables(Cache paramCache)
  {
    this.mLeft.resetSolverVariable(paramCache);
    this.mTop.resetSolverVariable(paramCache);
    this.mRight.resetSolverVariable(paramCache);
    this.mBottom.resetSolverVariable(paramCache);
    this.mBaseline.resetSolverVariable(paramCache);
    this.mCenter.resetSolverVariable(paramCache);
    this.mCenterX.resetSolverVariable(paramCache);
    this.mCenterY.resetSolverVariable(paramCache);
  }
  
  public void resolve() {}
  
  public void setBaselineDistance(int paramInt)
  {
    this.mBaselineDistance = paramInt;
  }
  
  public void setCompanionWidget(Object paramObject)
  {
    this.mCompanionWidget = paramObject;
  }
  
  public void setContainerItemSkip(int paramInt)
  {
    if (paramInt >= 0) {
      this.mContainerItemSkip = paramInt;
    } else {
      this.mContainerItemSkip = 0;
    }
  }
  
  public void setDebugName(String paramString)
  {
    this.mDebugName = paramString;
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString)
  {
    this.mDebugName = paramString;
    Object localObject1 = paramLinearSystem.createObjectVariable(this.mLeft);
    Object localObject2 = paramLinearSystem.createObjectVariable(this.mTop);
    Object localObject3 = paramLinearSystem.createObjectVariable(this.mRight);
    SolverVariable localSolverVariable = paramLinearSystem.createObjectVariable(this.mBottom);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".left");
    ((SolverVariable)localObject1).setName(localStringBuilder.toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".top");
    ((SolverVariable)localObject2).setName(((StringBuilder)localObject1).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".right");
    ((SolverVariable)localObject3).setName(((StringBuilder)localObject2).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(".bottom");
    localSolverVariable.setName(((StringBuilder)localObject3).toString());
    if (this.mBaselineDistance > 0)
    {
      localSolverVariable = paramLinearSystem.createObjectVariable(this.mBaseline);
      paramLinearSystem = new StringBuilder();
      paramLinearSystem.append(paramString);
      paramLinearSystem.append(".baseline");
      localSolverVariable.setName(paramLinearSystem.toString());
    }
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    int i = this.mMinWidth;
    if (paramInt1 < i) {
      this.mWidth = i;
    }
    this.mHeight = paramInt2;
    paramInt1 = this.mMinHeight;
    if (paramInt2 < paramInt1) {
      this.mHeight = paramInt1;
    }
  }
  
  public void setDimensionRatio(float paramFloat, int paramInt)
  {
    this.mDimensionRatio = paramFloat;
    this.mDimensionRatioSide = paramInt;
  }
  
  public void setDimensionRatio(String paramString)
  {
    int n;
    int i1;
    String str;
    if ((paramString != null) && (paramString.length() != 0))
    {
      int i = -1;
      int j = paramString.length();
      int k = paramString.indexOf(',');
      int m = 0;
      n = i;
      i1 = m;
      if (k > 0)
      {
        n = i;
        i1 = m;
        if (k < j - 1)
        {
          str = paramString.substring(0, k);
          if (str.equalsIgnoreCase("W"))
          {
            n = 0;
          }
          else
          {
            n = i;
            if (str.equalsIgnoreCase("H")) {
              n = 1;
            }
          }
          i1 = k + 1;
        }
      }
      i = paramString.indexOf(':');
      if ((i >= 0) && (i < j - 1))
      {
        str = paramString.substring(i1, i);
        paramString = paramString.substring(i + 1);
        if ((str.length() <= 0) || (paramString.length() <= 0)) {
          break label240;
        }
      }
    }
    try
    {
      f1 = Float.parseFloat(str);
      float f2 = Float.parseFloat(paramString);
      if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
        break label240;
      }
      if (n == 1) {
        f1 = Math.abs(f2 / f1);
      } else {
        f1 = Math.abs(f1 / f2);
      }
    }
    catch (NumberFormatException paramString)
    {
      float f1;
      for (;;) {}
    }
    paramString = paramString.substring(i1);
    if (paramString.length() > 0) {
      f1 = Float.parseFloat(paramString);
    } else {
      label240:
      f1 = 0.0F;
    }
    if (f1 > 0.0F)
    {
      this.mDimensionRatio = f1;
      this.mDimensionRatioSide = n;
    }
    return;
    this.mDimensionRatio = 0.0F;
  }
  
  public void setDrawHeight(int paramInt)
  {
    this.mDrawHeight = paramInt;
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    paramInt1 -= this.mOffsetX;
    this.mDrawX = paramInt1;
    paramInt2 -= this.mOffsetY;
    this.mDrawY = paramInt2;
    this.mX = paramInt1;
    this.mY = paramInt2;
  }
  
  public void setDrawWidth(int paramInt)
  {
    this.mDrawWidth = paramInt;
  }
  
  public void setDrawX(int paramInt)
  {
    paramInt -= this.mOffsetX;
    this.mDrawX = paramInt;
    this.mX = paramInt;
  }
  
  public void setDrawY(int paramInt)
  {
    paramInt -= this.mOffsetY;
    this.mDrawY = paramInt;
    this.mY = paramInt;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      setHorizontalDimension(paramInt1, paramInt2);
    } else if (paramInt3 == 1) {
      setVerticalDimension(paramInt1, paramInt2);
    }
    this.mOptimizerMeasured = true;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2;
    this.mX = paramInt1;
    this.mY = paramInt2;
    if (this.mVisibility == 8)
    {
      this.mWidth = 0;
      this.mHeight = 0;
      return;
    }
    DimensionBehaviour[] arrayOfDimensionBehaviour = this.mListDimensionBehaviors;
    DimensionBehaviour localDimensionBehaviour1 = arrayOfDimensionBehaviour[0];
    DimensionBehaviour localDimensionBehaviour2 = DimensionBehaviour.FIXED;
    paramInt1 = i;
    if (localDimensionBehaviour1 == localDimensionBehaviour2)
    {
      paramInt2 = this.mWidth;
      paramInt1 = i;
      if (i < paramInt2) {
        paramInt1 = paramInt2;
      }
    }
    paramInt2 = paramInt3;
    if (arrayOfDimensionBehaviour[1] == localDimensionBehaviour2)
    {
      paramInt4 = this.mHeight;
      paramInt2 = paramInt3;
      if (paramInt3 < paramInt4) {
        paramInt2 = paramInt4;
      }
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    paramInt3 = this.mMinHeight;
    if (paramInt2 < paramInt3) {
      this.mHeight = paramInt3;
    }
    paramInt2 = this.mMinWidth;
    if (paramInt1 < paramInt2) {
      this.mWidth = paramInt2;
    }
    this.mOptimizerMeasured = true;
  }
  
  public void setGoneMargin(ConstraintAnchor.Type paramType, int paramInt)
  {
    int i = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            this.mBottom.mGoneMargin = paramInt;
          }
        }
        else {
          this.mRight.mGoneMargin = paramInt;
        }
      }
      else {
        this.mTop.mGoneMargin = paramInt;
      }
    }
    else {
      this.mLeft.mGoneMargin = paramInt;
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
    int i = this.mMinHeight;
    if (paramInt < i) {
      this.mHeight = i;
    }
  }
  
  public void setHeightWrapContent(boolean paramBoolean)
  {
    this.mIsHeightWrapContent = paramBoolean;
  }
  
  public void setHorizontalBiasPercent(float paramFloat)
  {
    this.mHorizontalBiasPercent = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt)
  {
    this.mHorizontalChainStyle = paramInt;
  }
  
  public void setHorizontalDimension(int paramInt1, int paramInt2)
  {
    this.mX = paramInt1;
    paramInt1 = paramInt2 - paramInt1;
    this.mWidth = paramInt1;
    paramInt2 = this.mMinWidth;
    if (paramInt1 < paramInt2) {
      this.mWidth = paramInt2;
    }
  }
  
  public void setHorizontalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour)
  {
    this.mListDimensionBehaviors[0] = paramDimensionBehaviour;
    if (paramDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
      setWidth(this.mWrapWidth);
    }
  }
  
  public void setHorizontalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.mMatchConstraintDefaultWidth = paramInt1;
    this.mMatchConstraintMinWidth = paramInt2;
    this.mMatchConstraintMaxWidth = paramInt3;
    this.mMatchConstraintPercentWidth = paramFloat;
    if ((paramFloat < 1.0F) && (paramInt1 == 0)) {
      this.mMatchConstraintDefaultWidth = 2;
    }
  }
  
  public void setHorizontalWeight(float paramFloat)
  {
    this.mWeight[0] = paramFloat;
  }
  
  public void setLength(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      setWidth(paramInt1);
    } else if (paramInt2 == 1) {
      setHeight(paramInt1);
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxDimension[1] = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxDimension[0] = paramInt;
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt < 0) {
      this.mMinHeight = 0;
    } else {
      this.mMinHeight = paramInt;
    }
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt < 0) {
      this.mMinWidth = 0;
    } else {
      this.mMinWidth = paramInt;
    }
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
  }
  
  public void setOrigin(int paramInt1, int paramInt2)
  {
    this.mX = paramInt1;
    this.mY = paramInt2;
  }
  
  public void setParent(ConstraintWidget paramConstraintWidget)
  {
    this.mParent = paramConstraintWidget;
  }
  
  void setRelativePositioning(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      this.mRelX = paramInt1;
    } else if (paramInt2 == 1) {
      this.mRelY = paramInt1;
    }
  }
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  public void setVerticalBiasPercent(float paramFloat)
  {
    this.mVerticalBiasPercent = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt)
  {
    this.mVerticalChainStyle = paramInt;
  }
  
  public void setVerticalDimension(int paramInt1, int paramInt2)
  {
    this.mY = paramInt1;
    paramInt2 -= paramInt1;
    this.mHeight = paramInt2;
    paramInt1 = this.mMinHeight;
    if (paramInt2 < paramInt1) {
      this.mHeight = paramInt1;
    }
  }
  
  public void setVerticalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour)
  {
    this.mListDimensionBehaviors[1] = paramDimensionBehaviour;
    if (paramDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
      setHeight(this.mWrapHeight);
    }
  }
  
  public void setVerticalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.mMatchConstraintDefaultHeight = paramInt1;
    this.mMatchConstraintMinHeight = paramInt2;
    this.mMatchConstraintMaxHeight = paramInt3;
    this.mMatchConstraintPercentHeight = paramFloat;
    if ((paramFloat < 1.0F) && (paramInt1 == 0)) {
      this.mMatchConstraintDefaultHeight = 2;
    }
  }
  
  public void setVerticalWeight(float paramFloat)
  {
    this.mWeight[1] = paramFloat;
  }
  
  public void setVisibility(int paramInt)
  {
    this.mVisibility = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
    int i = this.mMinWidth;
    if (paramInt < i) {
      this.mWidth = i;
    }
  }
  
  public void setWidthWrapContent(boolean paramBoolean)
  {
    this.mIsWidthWrapContent = paramBoolean;
  }
  
  public void setWrapHeight(int paramInt)
  {
    this.mWrapHeight = paramInt;
  }
  
  public void setWrapWidth(int paramInt)
  {
    this.mWrapWidth = paramInt;
  }
  
  public void setX(int paramInt)
  {
    this.mX = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.mY = paramInt;
  }
  
  public void setupDimensionRatio(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.mResolvedDimensionRatioSide == -1) {
      if ((paramBoolean3) && (!paramBoolean4))
      {
        this.mResolvedDimensionRatioSide = 0;
      }
      else if ((!paramBoolean3) && (paramBoolean4))
      {
        this.mResolvedDimensionRatioSide = 1;
        if (this.mDimensionRatioSide == -1) {
          this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
        }
      }
    }
    if ((this.mResolvedDimensionRatioSide == 0) && ((!this.mTop.isConnected()) || (!this.mBottom.isConnected()))) {
      this.mResolvedDimensionRatioSide = 1;
    } else if ((this.mResolvedDimensionRatioSide == 1) && ((!this.mLeft.isConnected()) || (!this.mRight.isConnected()))) {
      this.mResolvedDimensionRatioSide = 0;
    }
    if ((this.mResolvedDimensionRatioSide == -1) && ((!this.mTop.isConnected()) || (!this.mBottom.isConnected()) || (!this.mLeft.isConnected()) || (!this.mRight.isConnected()))) {
      if ((this.mTop.isConnected()) && (this.mBottom.isConnected()))
      {
        this.mResolvedDimensionRatioSide = 0;
      }
      else if ((this.mLeft.isConnected()) && (this.mRight.isConnected()))
      {
        this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
        this.mResolvedDimensionRatioSide = 1;
      }
    }
    if (this.mResolvedDimensionRatioSide == -1) {
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.mResolvedDimensionRatioSide = 0;
      }
      else if ((!paramBoolean1) && (paramBoolean2))
      {
        this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
        this.mResolvedDimensionRatioSide = 1;
      }
    }
    if (this.mResolvedDimensionRatioSide == -1)
    {
      int i = this.mMatchConstraintMinWidth;
      if ((i > 0) && (this.mMatchConstraintMinHeight == 0))
      {
        this.mResolvedDimensionRatioSide = 0;
      }
      else if ((i == 0) && (this.mMatchConstraintMinHeight > 0))
      {
        this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
        this.mResolvedDimensionRatioSide = 1;
      }
    }
    if ((this.mResolvedDimensionRatioSide == -1) && (paramBoolean1) && (paramBoolean2))
    {
      this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
      this.mResolvedDimensionRatioSide = 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.mType;
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type: ");
      ((StringBuilder)localObject).append(this.mType);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (this.mDebugName != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id: ");
      ((StringBuilder)localObject).append(this.mDebugName);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("(");
    localStringBuilder.append(this.mX);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mY);
    localStringBuilder.append(") - (");
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append(" x ");
    localStringBuilder.append(this.mHeight);
    localStringBuilder.append(") wrap: (");
    localStringBuilder.append(this.mWrapWidth);
    localStringBuilder.append(" x ");
    localStringBuilder.append(this.mWrapHeight);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void updateDrawPosition()
  {
    int i = this.mX;
    int j = this.mY;
    int k = this.mWidth;
    int m = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = (k + i - i);
    this.mDrawHeight = (m + j - j);
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem)
  {
    int i = paramLinearSystem.getObjectVariableValue(this.mLeft);
    int j = paramLinearSystem.getObjectVariableValue(this.mTop);
    int k = paramLinearSystem.getObjectVariableValue(this.mRight);
    int m = paramLinearSystem.getObjectVariableValue(this.mBottom);
    int n;
    if ((k - i >= 0) && (m - j >= 0) && (i != Integer.MIN_VALUE) && (i != Integer.MAX_VALUE) && (j != Integer.MIN_VALUE) && (j != Integer.MAX_VALUE) && (k != Integer.MIN_VALUE) && (k != Integer.MAX_VALUE) && (m != Integer.MIN_VALUE))
    {
      n = m;
      if (m != Integer.MAX_VALUE) {}
    }
    else
    {
      n = 0;
      i = 0;
      j = 0;
      k = 0;
    }
    setFrame(i, j, k, n);
  }
  
  public void updateResolutionNodes()
  {
    for (int i = 0; i < 6; i++) {
      this.mListAnchors[i].getResolutionNode().update();
    }
  }
  
  public static enum ContentAlignment
  {
    static
    {
      ContentAlignment localContentAlignment1 = new ContentAlignment("BEGIN", 0);
      BEGIN = localContentAlignment1;
      ContentAlignment localContentAlignment2 = new ContentAlignment("MIDDLE", 1);
      MIDDLE = localContentAlignment2;
      ContentAlignment localContentAlignment3 = new ContentAlignment("END", 2);
      END = localContentAlignment3;
      ContentAlignment localContentAlignment4 = new ContentAlignment("TOP", 3);
      TOP = localContentAlignment4;
      ContentAlignment localContentAlignment5 = new ContentAlignment("VERTICAL_MIDDLE", 4);
      VERTICAL_MIDDLE = localContentAlignment5;
      ContentAlignment localContentAlignment6 = new ContentAlignment("BOTTOM", 5);
      BOTTOM = localContentAlignment6;
      ContentAlignment localContentAlignment7 = new ContentAlignment("LEFT", 6);
      LEFT = localContentAlignment7;
      ContentAlignment localContentAlignment8 = new ContentAlignment("RIGHT", 7);
      RIGHT = localContentAlignment8;
      $VALUES = new ContentAlignment[] { localContentAlignment1, localContentAlignment2, localContentAlignment3, localContentAlignment4, localContentAlignment5, localContentAlignment6, localContentAlignment7, localContentAlignment8 };
    }
  }
  
  public static enum DimensionBehaviour
  {
    static
    {
      DimensionBehaviour localDimensionBehaviour1 = new DimensionBehaviour("FIXED", 0);
      FIXED = localDimensionBehaviour1;
      DimensionBehaviour localDimensionBehaviour2 = new DimensionBehaviour("WRAP_CONTENT", 1);
      WRAP_CONTENT = localDimensionBehaviour2;
      DimensionBehaviour localDimensionBehaviour3 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
      MATCH_CONSTRAINT = localDimensionBehaviour3;
      DimensionBehaviour localDimensionBehaviour4 = new DimensionBehaviour("MATCH_PARENT", 3);
      MATCH_PARENT = localDimensionBehaviour4;
      $VALUES = new DimensionBehaviour[] { localDimensionBehaviour1, localDimensionBehaviour2, localDimensionBehaviour3, localDimensionBehaviour4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ConstraintWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */