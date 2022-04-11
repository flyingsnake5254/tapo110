package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class Guideline
  extends ConstraintWidget
{
  public static final int HORIZONTAL = 0;
  public static final int RELATIVE_BEGIN = 1;
  public static final int RELATIVE_END = 2;
  public static final int RELATIVE_PERCENT = 0;
  public static final int RELATIVE_UNKNWON = -1;
  public static final int VERTICAL = 1;
  private ConstraintAnchor mAnchor = this.mTop;
  private Rectangle mHead;
  private int mHeadSize;
  private boolean mIsPositionRelaxed;
  private int mMinimumPosition;
  private int mOrientation;
  protected int mRelativeBegin = -1;
  protected int mRelativeEnd = -1;
  protected float mRelativePercent = -1.0F;
  
  public Guideline()
  {
    int i = 0;
    this.mOrientation = 0;
    this.mIsPositionRelaxed = false;
    this.mMinimumPosition = 0;
    this.mHead = new Rectangle();
    this.mHeadSize = 8;
    this.mAnchors.clear();
    this.mAnchors.add(this.mAnchor);
    int j = this.mListAnchors.length;
    while (i < j)
    {
      this.mListAnchors[i] = this.mAnchor;
      i++;
    }
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    Object localObject1 = (ConstraintWidgetContainer)getParent();
    if (localObject1 == null) {
      return;
    }
    ConstraintAnchor localConstraintAnchor = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.LEFT);
    Object localObject2 = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.RIGHT);
    ConstraintWidget localConstraintWidget = this.mParent;
    int i = 1;
    int j;
    if ((localConstraintWidget != null) && (localConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
      j = 1;
    } else {
      j = 0;
    }
    if (this.mOrientation == 0)
    {
      localConstraintAnchor = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.TOP);
      localObject2 = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.BOTTOM);
      localObject1 = this.mParent;
      if ((localObject1 != null) && (localObject1.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
        j = i;
      } else {
        j = 0;
      }
    }
    if (this.mRelativeBegin != -1)
    {
      localObject1 = paramLinearSystem.createObjectVariable(this.mAnchor);
      paramLinearSystem.addEquality((SolverVariable)localObject1, paramLinearSystem.createObjectVariable(localConstraintAnchor), this.mRelativeBegin, 6);
      if (j != 0) {
        paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(localObject2), (SolverVariable)localObject1, 0, 5);
      }
    }
    else if (this.mRelativeEnd != -1)
    {
      localObject1 = paramLinearSystem.createObjectVariable(this.mAnchor);
      localObject2 = paramLinearSystem.createObjectVariable(localObject2);
      paramLinearSystem.addEquality((SolverVariable)localObject1, (SolverVariable)localObject2, -this.mRelativeEnd, 6);
      if (j != 0)
      {
        paramLinearSystem.addGreaterThan((SolverVariable)localObject1, paramLinearSystem.createObjectVariable(localConstraintAnchor), 0, 5);
        paramLinearSystem.addGreaterThan((SolverVariable)localObject2, (SolverVariable)localObject1, 0, 5);
      }
    }
    else if (this.mRelativePercent != -1.0F)
    {
      paramLinearSystem.addConstraint(LinearSystem.createRowDimensionPercent(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor), paramLinearSystem.createObjectVariable(localObject2), this.mRelativePercent, this.mIsPositionRelaxed));
    }
  }
  
  public boolean allowedInBarrier()
  {
    return true;
  }
  
  public void analyze(int paramInt)
  {
    ConstraintWidget localConstraintWidget = getParent();
    if (localConstraintWidget == null) {
      return;
    }
    if (getOrientation() == 1)
    {
      this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), 0);
      this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), 0);
      if (this.mRelativeBegin != -1)
      {
        this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), this.mRelativeBegin);
        this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), this.mRelativeBegin);
      }
      else if (this.mRelativeEnd != -1)
      {
        this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mRight.getResolutionNode(), -this.mRelativeEnd);
        this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mRight.getResolutionNode(), -this.mRelativeEnd);
      }
      else if ((this.mRelativePercent != -1.0F) && (localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED))
      {
        paramInt = (int)(localConstraintWidget.mWidth * this.mRelativePercent);
        this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), paramInt);
        this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), paramInt);
      }
    }
    else
    {
      this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), 0);
      this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), 0);
      if (this.mRelativeBegin != -1)
      {
        this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), this.mRelativeBegin);
        this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), this.mRelativeBegin);
      }
      else if (this.mRelativeEnd != -1)
      {
        this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mBottom.getResolutionNode(), -this.mRelativeEnd);
        this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mBottom.getResolutionNode(), -this.mRelativeEnd);
      }
      else if ((this.mRelativePercent != -1.0F) && (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED))
      {
        paramInt = (int)(localConstraintWidget.mHeight * this.mRelativePercent);
        this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), paramInt);
        this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), paramInt);
      }
    }
  }
  
  public void cyclePosition()
  {
    if (this.mRelativeBegin != -1) {
      inferRelativePercentPosition();
    } else if (this.mRelativePercent != -1.0F) {
      inferRelativeEndPosition();
    } else if (this.mRelativeEnd != -1) {
      inferRelativeBeginPosition();
    }
  }
  
  public ConstraintAnchor getAnchor()
  {
    return this.mAnchor;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()])
    {
    default: 
      break;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return null;
    case 3: 
    case 4: 
      if (this.mOrientation == 0) {
        return this.mAnchor;
      }
      break;
    case 1: 
    case 2: 
      if (this.mOrientation == 1) {
        return this.mAnchor;
      }
      break;
    }
    throw new AssertionError(paramType.name());
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return this.mAnchors;
  }
  
  public Rectangle getHead()
  {
    Rectangle localRectangle = this.mHead;
    int i = getDrawX();
    int j = this.mHeadSize;
    int k = getDrawY();
    int m = this.mHeadSize;
    localRectangle.setBounds(i - j, k - m * 2, m * 2, m * 2);
    if (getOrientation() == 0)
    {
      localRectangle = this.mHead;
      k = getDrawX();
      m = this.mHeadSize;
      i = getDrawY();
      j = this.mHeadSize;
      localRectangle.setBounds(k - m * 2, i - j, j * 2, j * 2);
    }
    return this.mHead;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getRelativeBegin()
  {
    return this.mRelativeBegin;
  }
  
  public int getRelativeBehaviour()
  {
    if (this.mRelativePercent != -1.0F) {
      return 0;
    }
    if (this.mRelativeBegin != -1) {
      return 1;
    }
    if (this.mRelativeEnd != -1) {
      return 2;
    }
    return -1;
  }
  
  public int getRelativeEnd()
  {
    return this.mRelativeEnd;
  }
  
  public float getRelativePercent()
  {
    return this.mRelativePercent;
  }
  
  public String getType()
  {
    return "Guideline";
  }
  
  void inferRelativeBeginPosition()
  {
    int i = getX();
    if (this.mOrientation == 0) {
      i = getY();
    }
    setGuideBegin(i);
  }
  
  void inferRelativeEndPosition()
  {
    int i = getParent().getWidth() - getX();
    if (this.mOrientation == 0) {
      i = getParent().getHeight() - getY();
    }
    setGuideEnd(i);
  }
  
  void inferRelativePercentPosition()
  {
    float f = getX() / getParent().getWidth();
    if (this.mOrientation == 0) {
      f = getY() / getParent().getHeight();
    }
    setGuidePercent(f);
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      paramInt1 -= this.mOffsetX;
      if (this.mRelativeBegin != -1) {
        setGuideBegin(paramInt1);
      } else if (this.mRelativeEnd != -1) {
        setGuideEnd(getParent().getWidth() - paramInt1);
      } else if (this.mRelativePercent != -1.0F) {
        setGuidePercent(paramInt1 / getParent().getWidth());
      }
    }
    else
    {
      paramInt1 = paramInt2 - this.mOffsetY;
      if (this.mRelativeBegin != -1) {
        setGuideBegin(paramInt1);
      } else if (this.mRelativeEnd != -1) {
        setGuideEnd(getParent().getHeight() - paramInt1);
      } else if (this.mRelativePercent != -1.0F) {
        setGuidePercent(paramInt1 / getParent().getHeight());
      }
    }
  }
  
  public void setGuideBegin(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = paramInt;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuideEnd(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = paramInt;
    }
  }
  
  public void setGuidePercent(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.mRelativePercent = paramFloat;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuidePercent(int paramInt)
  {
    setGuidePercent(paramInt / 100.0F);
  }
  
  public void setMinimumPosition(int paramInt)
  {
    this.mMinimumPosition = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation == paramInt) {
      return;
    }
    this.mOrientation = paramInt;
    this.mAnchors.clear();
    if (this.mOrientation == 1) {
      this.mAnchor = this.mLeft;
    } else {
      this.mAnchor = this.mTop;
    }
    this.mAnchors.add(this.mAnchor);
    int i = this.mListAnchors.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      this.mListAnchors[paramInt] = this.mAnchor;
    }
  }
  
  public void setPositionRelaxed(boolean paramBoolean)
  {
    if (this.mIsPositionRelaxed == paramBoolean) {
      return;
    }
    this.mIsPositionRelaxed = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem)
  {
    if (getParent() == null) {
      return;
    }
    int i = paramLinearSystem.getObjectVariableValue(this.mAnchor);
    if (this.mOrientation == 1)
    {
      setX(i);
      setY(0);
      setHeight(getParent().getHeight());
      setWidth(0);
    }
    else
    {
      setX(0);
      setY(i);
      setWidth(getParent().getWidth());
      setHeight(0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\Guideline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */