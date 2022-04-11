package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  private static final boolean DEBUG = false;
  static final boolean DEBUG_GRAPH = false;
  private static final boolean DEBUG_LAYOUT = false;
  private static final int MAX_ITERATIONS = 8;
  private static final boolean USE_SNAPSHOT = true;
  int mDebugSolverPassCount = 0;
  public boolean mGroupsWrapOptimized = false;
  private boolean mHeightMeasuredTooSmall = false;
  ChainHead[] mHorizontalChainsArray = new ChainHead[4];
  int mHorizontalChainsSize = 0;
  public boolean mHorizontalWrapOptimized = false;
  private boolean mIsRtl = false;
  private int mOptimizationLevel = 7;
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  public boolean mSkipSolver = false;
  private Snapshot mSnapshot;
  protected LinearSystem mSystem = new LinearSystem();
  ChainHead[] mVerticalChainsArray = new ChainHead[4];
  int mVerticalChainsSize = 0;
  public boolean mVerticalWrapOptimized = false;
  public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
  private boolean mWidthMeasuredTooSmall = false;
  public int mWrapFixedHeight = 0;
  public int mWrapFixedWidth = 0;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = this.mHorizontalChainsSize;
    ChainHead[] arrayOfChainHead = this.mHorizontalChainsArray;
    if (i + 1 >= arrayOfChainHead.length) {
      this.mHorizontalChainsArray = ((ChainHead[])Arrays.copyOf(arrayOfChainHead, arrayOfChainHead.length * 2));
    }
    this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(paramConstraintWidget, 0, isRtl());
    this.mHorizontalChainsSize += 1;
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = this.mVerticalChainsSize;
    ChainHead[] arrayOfChainHead = this.mVerticalChainsArray;
    if (i + 1 >= arrayOfChainHead.length) {
      this.mVerticalChainsArray = ((ChainHead[])Arrays.copyOf(arrayOfChainHead, arrayOfChainHead.length * 2));
    }
    this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(paramConstraintWidget, 1, isRtl());
    this.mVerticalChainsSize += 1;
  }
  
  private void resetChains()
  {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0) {
      addHorizontalChain(paramConstraintWidget);
    } else if (paramInt == 1) {
      addVerticalChain(paramConstraintWidget);
    }
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem)
  {
    addToSolver(paramLinearSystem);
    int i = this.mChildren.size();
    for (int j = 0; j < i; j++)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(j);
      if ((localConstraintWidget instanceof ConstraintWidgetContainer))
      {
        Object localObject = localConstraintWidget.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localObject[0];
        localObject = localObject[1];
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (localDimensionBehaviour1 == localDimensionBehaviour2) {
          localConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localObject == localDimensionBehaviour2) {
          localConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        localConstraintWidget.addToSolver(paramLinearSystem);
        if (localDimensionBehaviour1 == localDimensionBehaviour2) {
          localConstraintWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
        }
        if (localObject == localDimensionBehaviour2) {
          localConstraintWidget.setVerticalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)localObject);
        }
      }
      else
      {
        Optimizer.checkMatchParent(this, paramLinearSystem, localConstraintWidget);
        localConstraintWidget.addToSolver(paramLinearSystem);
      }
    }
    if (this.mHorizontalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 0);
    }
    if (this.mVerticalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 1);
    }
    return true;
  }
  
  public void analyze(int paramInt)
  {
    super.analyze(paramInt);
    int i = this.mChildren.size();
    for (int j = 0; j < i; j++) {
      ((ConstraintWidget)this.mChildren.get(j)).analyze(paramInt);
    }
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mSystem.fillMetrics(paramMetrics);
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.mChildren.size();
    for (int j = 0; j < i; j++)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(j);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 0) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public int getOptimizationLevel()
  {
    return this.mOptimizationLevel;
  }
  
  public LinearSystem getSystem()
  {
    return this.mSystem;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.mChildren.size();
    for (int j = 0; j < i; j++)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(j);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 1) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List<ConstraintWidgetGroup> getWidgetGroups()
  {
    return this.mWidgetGroups;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall()
  {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isRtl()
  {
    return this.mIsRtl;
  }
  
  public boolean isWidthMeasuredTooSmall()
  {
    return this.mWidthMeasuredTooSmall;
  }
  
  public void layout()
  {
    int i = this.mX;
    int j = this.mY;
    int k = Math.max(0, getWidth());
    int m = Math.max(0, getHeight());
    this.mWidthMeasuredTooSmall = false;
    this.mHeightMeasuredTooSmall = false;
    if (this.mParent != null)
    {
      if (this.mSnapshot == null) {
        this.mSnapshot = new Snapshot(this);
      }
      this.mSnapshot.updateFrom(this);
      setX(this.mPaddingLeft);
      setY(this.mPaddingTop);
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
    }
    else
    {
      this.mX = 0;
      this.mY = 0;
    }
    if (this.mOptimizationLevel != 0)
    {
      if (!optimizeFor(8)) {
        optimizeReset();
      }
      if (!optimizeFor(32)) {
        optimize();
      }
      this.mSystem.graphOptimizer = true;
    }
    else
    {
      this.mSystem.graphOptimizer = false;
    }
    Object localObject1 = this.mListDimensionBehaviors;
    Object localObject3 = localObject1[1];
    Object localObject4 = localObject1[0];
    resetChains();
    if (this.mWidgetGroups.size() == 0)
    {
      this.mWidgetGroups.clear();
      this.mWidgetGroups.add(0, new ConstraintWidgetGroup(this.mChildren));
    }
    int n = this.mWidgetGroups.size();
    ArrayList localArrayList = this.mChildren;
    Object localObject5 = getHorizontalDimensionBehaviour();
    localObject1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    int i1;
    if ((localObject5 != localObject1) && (getVerticalDimensionBehaviour() != localObject1)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int i2 = 0;
    label637:
    Object localObject2;
    for (int i3 = 0; (i3 < n) && (!this.mSkipSolver); i3++) {
      if (!((ConstraintWidgetGroup)this.mWidgetGroups.get(i3)).mSkipSolver)
      {
        if (optimizeFor(32))
        {
          localObject1 = getHorizontalDimensionBehaviour();
          localObject5 = ConstraintWidget.DimensionBehaviour.FIXED;
          if ((localObject1 == localObject5) && (getVerticalDimensionBehaviour() == localObject5)) {
            this.mChildren = ((ArrayList)((ConstraintWidgetGroup)this.mWidgetGroups.get(i3)).getWidgetsToSolve());
          } else {
            this.mChildren = ((ArrayList)((ConstraintWidgetGroup)this.mWidgetGroups.get(i3)).mConstrainedGroup);
          }
        }
        resetChains();
        int i4 = this.mChildren.size();
        for (int i5 = 0; i5 < i4; i5++)
        {
          localObject1 = (ConstraintWidget)this.mChildren.get(i5);
          if ((localObject1 instanceof WidgetContainer)) {
            ((WidgetContainer)localObject1).layout();
          }
        }
        i5 = i2;
        int i6 = 0;
        boolean bool1 = true;
        i2 = n;
        n = i5;
        i5 = i6;
        while (bool1)
        {
          int i7 = i5 + 1;
          boolean bool2 = bool1;
          try
          {
            this.mSystem.reset();
            bool2 = bool1;
            resetChains();
            bool2 = bool1;
            createObjectVariables(this.mSystem);
            i5 = 0;
            for (;;)
            {
              if (i5 < i4)
              {
                bool2 = bool1;
                localObject1 = (ConstraintWidget)this.mChildren.get(i5);
              }
              try
              {
                ((ConstraintWidget)localObject1).createObjectVariables(this.mSystem);
                i5++;
              }
              catch (Exception localException2)
              {
                break label637;
              }
            }
            bool2 = addChildrenToSolver(this.mSystem);
            if (bool2) {
              try
              {
                this.mSystem.minimize();
              }
              catch (Exception localException1)
              {
                bool1 = bool2;
                break label637;
              }
            }
            bool1 = bool2;
          }
          catch (Exception localException3)
          {
            bool1 = bool2;
          }
          localException3.printStackTrace();
          localObject5 = System.out;
          Object localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("EXCEPTION : ");
          ((StringBuilder)localObject6).append(localException3);
          ((PrintStream)localObject5).println(((StringBuilder)localObject6).toString());
          int i8;
          if (bool1)
          {
            updateChildrenFromSolver(this.mSystem, Optimizer.flags);
            i5 = j;
            j = i5;
          }
          else
          {
            updateFromSolver(this.mSystem);
            for (i6 = 0;; i6++)
            {
              i5 = j;
              if (i6 >= i4) {
                break;
              }
              localObject6 = (ConstraintWidget)this.mChildren.get(i6);
              localObject5 = localObject6.mListDimensionBehaviors[0];
              localObject2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
              if (localObject5 == localObject2)
              {
                i8 = ((ConstraintWidget)localObject6).getWidth();
                i5 = j;
                if (i8 < ((ConstraintWidget)localObject6).getWrapWidth())
                {
                  Optimizer.flags[2] = true;
                  j = i5;
                  break label836;
                }
              }
              if ((localObject6.mListDimensionBehaviors[1] == localObject2) && (((ConstraintWidget)localObject6).getHeight() < ((ConstraintWidget)localObject6).getWrapHeight()))
              {
                Optimizer.flags[2] = true;
                break label836;
              }
            }
          }
          label836:
          if ((i1 != 0) && (i7 < 8) && (Optimizer.flags[2] != 0))
          {
            i6 = 0;
            i8 = 0;
            i5 = 0;
            while (i6 < i4)
            {
              localObject2 = (ConstraintWidget)this.mChildren.get(i6);
              i8 = Math.max(i8, ((ConstraintWidget)localObject2).mX + ((ConstraintWidget)localObject2).getWidth());
              i5 = Math.max(i5, ((ConstraintWidget)localObject2).mY + ((ConstraintWidget)localObject2).getHeight());
              i6++;
            }
            i8 = Math.max(this.mMinWidth, i8);
            i6 = Math.max(this.mMinHeight, i5);
            localObject2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if ((localObject4 == localObject2) && (getWidth() < i8))
            {
              setWidth(i8);
              this.mListDimensionBehaviors[0] = localObject2;
              bool2 = true;
              i5 = 1;
            }
            else
            {
              bool2 = false;
              i5 = n;
            }
            bool1 = bool2;
            n = i5;
            if (localObject3 == localObject2)
            {
              bool1 = bool2;
              n = i5;
              if (getHeight() < i6)
              {
                setHeight(i6);
                this.mListDimensionBehaviors[1] = localObject2;
                bool1 = true;
                n = 1;
              }
            }
          }
          else
          {
            bool1 = false;
          }
          i5 = Math.max(this.mMinWidth, getWidth());
          if (i5 > getWidth())
          {
            setWidth(i5);
            this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
            bool1 = true;
            n = 1;
          }
          i5 = Math.max(this.mMinHeight, getHeight());
          if (i5 > getHeight())
          {
            setHeight(i5);
            this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
            bool1 = true;
            n = 1;
          }
          bool2 = bool1;
          i6 = n;
          if (n == 0)
          {
            localObject2 = this.mListDimensionBehaviors[0];
            localObject5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean bool3 = bool1;
            i5 = n;
            if (localObject2 == localObject5)
            {
              bool3 = bool1;
              i5 = n;
              if (k > 0)
              {
                bool3 = bool1;
                i5 = n;
                if (getWidth() > k)
                {
                  this.mWidthMeasuredTooSmall = true;
                  this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                  setWidth(k);
                  bool3 = true;
                  i5 = 1;
                }
              }
            }
            bool2 = bool3;
            i6 = i5;
            if (this.mListDimensionBehaviors[1] == localObject5)
            {
              bool2 = bool3;
              i6 = i5;
              if (m > 0)
              {
                bool2 = bool3;
                i6 = i5;
                if (getHeight() > m)
                {
                  this.mHeightMeasuredTooSmall = true;
                  this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                  setHeight(m);
                  bool1 = true;
                  i6 = 1;
                  break label1324;
                }
              }
            }
          }
          bool1 = bool2;
          label1324:
          i5 = i7;
          n = i6;
        }
        ((ConstraintWidgetGroup)this.mWidgetGroups.get(i3)).updateUnresolvedWidgets();
        i5 = n;
        n = i2;
        i2 = i5;
      }
    }
    this.mChildren = localArrayList;
    if (this.mParent != null)
    {
      j = Math.max(this.mMinWidth, getWidth());
      n = Math.max(this.mMinHeight, getHeight());
      this.mSnapshot.applyTo(this);
      setWidth(j + this.mPaddingLeft + this.mPaddingRight);
      setHeight(n + this.mPaddingTop + this.mPaddingBottom);
    }
    else
    {
      this.mX = i;
      this.mY = j;
    }
    if (i2 != 0)
    {
      localObject2 = this.mListDimensionBehaviors;
      localObject2[0] = localObject4;
      localObject2[1] = localObject3;
    }
    resetSolverVariables(this.mSystem.getCache());
    if (this == getRootConstraintContainer()) {
      updateDrawPosition();
    }
  }
  
  public void optimize()
  {
    if (!optimizeFor(8)) {
      analyze(this.mOptimizationLevel);
    }
    solveGraph();
  }
  
  public boolean optimizeFor(int paramInt)
  {
    boolean bool;
    if ((this.mOptimizationLevel & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void optimizeForDimensions(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mListDimensionBehaviors[0];
    Object localObject2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    if (localObject1 != localObject2)
    {
      localObject1 = this.mResolutionWidth;
      if (localObject1 != null) {
        ((ResolutionDimension)localObject1).resolve(paramInt1);
      }
    }
    if (this.mListDimensionBehaviors[1] != localObject2)
    {
      localObject2 = this.mResolutionHeight;
      if (localObject2 != null) {
        ((ResolutionDimension)localObject2).resolve(paramInt2);
      }
    }
  }
  
  public void optimizeReset()
  {
    int i = this.mChildren.size();
    resetResolutionNodes();
    for (int j = 0; j < i; j++) {
      ((ConstraintWidget)this.mChildren.get(j)).resetResolutionNodes();
    }
  }
  
  public void preOptimize()
  {
    optimizeReset();
    analyze(this.mOptimizationLevel);
  }
  
  public void reset()
  {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    this.mWidgetGroups.clear();
    this.mSkipSolver = false;
    super.reset();
  }
  
  public void resetGraph()
  {
    ResolutionAnchor localResolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    localResolutionAnchor1.invalidateAnchors();
    localResolutionAnchor2.invalidateAnchors();
    localResolutionAnchor1.resolve(null, 0.0F);
    localResolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mOptimizationLevel = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void setRtl(boolean paramBoolean)
  {
    this.mIsRtl = paramBoolean;
  }
  
  public void solveGraph()
  {
    ResolutionAnchor localResolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    localResolutionAnchor1.resolve(null, 0.0F);
    localResolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[2] = false;
    updateFromSolver(paramLinearSystem);
    int i = this.mChildren.size();
    for (int j = 0; j < i; j++)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(j);
      localConstraintWidget.updateFromSolver(paramLinearSystem);
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localConstraintWidget.mListDimensionBehaviors[0];
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
      if ((localDimensionBehaviour1 == localDimensionBehaviour2) && (localConstraintWidget.getWidth() < localConstraintWidget.getWrapWidth())) {
        paramArrayOfBoolean[2] = true;
      }
      if ((localConstraintWidget.mListDimensionBehaviors[1] == localDimensionBehaviour2) && (localConstraintWidget.getHeight() < localConstraintWidget.getWrapHeight())) {
        paramArrayOfBoolean[2] = true;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ConstraintWidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */