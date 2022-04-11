package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintTableLayout
  extends ConstraintWidgetContainer
{
  public static final int ALIGN_CENTER = 0;
  private static final int ALIGN_FULL = 3;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList();
  private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList();
  private int mNumCols = 0;
  private int mNumRows = 0;
  private int mPadding = 8;
  private boolean mVerticalGrowth = true;
  private ArrayList<Guideline> mVerticalGuidelines = new ArrayList();
  private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList();
  private LinearSystem system = null;
  
  public ConstraintTableLayout() {}
  
  public ConstraintTableLayout(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintTableLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void setChildrenConnections()
  {
    int i = this.mChildren.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      ConstraintWidget localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(j);
      k += localConstraintWidget1.getContainerItemSkip();
      int m = this.mNumCols;
      int n = k / m;
      Object localObject1 = (HorizontalSlice)this.mHorizontalSlices.get(n);
      Object localObject2 = (VerticalSlice)this.mVerticalSlices.get(k % m);
      Object localObject3 = ((VerticalSlice)localObject2).left;
      ConstraintWidget localConstraintWidget2 = ((VerticalSlice)localObject2).right;
      Object localObject4 = ((HorizontalSlice)localObject1).top;
      localObject1 = ((HorizontalSlice)localObject1).bottom;
      ConstraintAnchor.Type localType = ConstraintAnchor.Type.LEFT;
      localConstraintWidget1.getAnchor(localType).connect(((ConstraintWidget)localObject3).getAnchor(localType), this.mPadding);
      if ((localConstraintWidget2 instanceof Guideline))
      {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(localConstraintWidget2.getAnchor(localType), this.mPadding);
      }
      else
      {
        localObject3 = ConstraintAnchor.Type.RIGHT;
        localConstraintWidget1.getAnchor((ConstraintAnchor.Type)localObject3).connect(localConstraintWidget2.getAnchor((ConstraintAnchor.Type)localObject3), this.mPadding);
      }
      n = ((VerticalSlice)localObject2).alignment;
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3) {
            localConstraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
          }
        }
        else
        {
          localConstraintWidget1.getAnchor(localType).setStrength(ConstraintAnchor.Strength.WEAK);
          localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
        }
      }
      else
      {
        localConstraintWidget1.getAnchor(localType).setStrength(ConstraintAnchor.Strength.STRONG);
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
      }
      localObject2 = ConstraintAnchor.Type.TOP;
      localConstraintWidget1.getAnchor((ConstraintAnchor.Type)localObject2).connect(((ConstraintWidget)localObject4).getAnchor((ConstraintAnchor.Type)localObject2), this.mPadding);
      if ((localObject1 instanceof Guideline))
      {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(((ConstraintWidget)localObject1).getAnchor((ConstraintAnchor.Type)localObject2), this.mPadding);
      }
      else
      {
        localObject4 = ConstraintAnchor.Type.BOTTOM;
        localConstraintWidget1.getAnchor((ConstraintAnchor.Type)localObject4).connect(((ConstraintWidget)localObject1).getAnchor((ConstraintAnchor.Type)localObject4), this.mPadding);
      }
      k++;
      j++;
    }
  }
  
  private void setHorizontalSlices()
  {
    this.mHorizontalSlices.clear();
    float f1 = 100.0F / this.mNumRows;
    Object localObject = this;
    float f2 = f1;
    for (int i = 0; i < this.mNumRows; i++)
    {
      HorizontalSlice localHorizontalSlice = new HorizontalSlice();
      localHorizontalSlice.top = ((ConstraintWidget)localObject);
      if (i < this.mNumRows - 1)
      {
        localObject = new Guideline();
        ((Guideline)localObject).setOrientation(0);
        ((ConstraintWidget)localObject).setParent(this);
        ((Guideline)localObject).setGuidePercent((int)f2);
        f2 += f1;
        localHorizontalSlice.bottom = ((ConstraintWidget)localObject);
        this.mHorizontalGuidelines.add(localObject);
      }
      else
      {
        localHorizontalSlice.bottom = this;
      }
      localObject = localHorizontalSlice.bottom;
      this.mHorizontalSlices.add(localHorizontalSlice);
    }
    updateDebugSolverNames();
  }
  
  private void setVerticalSlices()
  {
    this.mVerticalSlices.clear();
    float f1 = 100.0F / this.mNumCols;
    int i = 0;
    Object localObject = this;
    float f2 = f1;
    while (i < this.mNumCols)
    {
      VerticalSlice localVerticalSlice = new VerticalSlice();
      localVerticalSlice.left = ((ConstraintWidget)localObject);
      if (i < this.mNumCols - 1)
      {
        localObject = new Guideline();
        ((Guideline)localObject).setOrientation(1);
        ((ConstraintWidget)localObject).setParent(this);
        ((Guideline)localObject).setGuidePercent((int)f2);
        f2 += f1;
        localVerticalSlice.right = ((ConstraintWidget)localObject);
        this.mVerticalGuidelines.add(localObject);
      }
      else
      {
        localVerticalSlice.right = this;
      }
      localObject = localVerticalSlice.right;
      this.mVerticalSlices.add(localVerticalSlice);
      i++;
    }
    updateDebugSolverNames();
  }
  
  private void updateDebugSolverNames()
  {
    if (this.system == null) {
      return;
    }
    int i = this.mVerticalGuidelines.size();
    int j = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    for (int k = 0; k < i; k++)
    {
      localObject1 = (Guideline)this.mVerticalGuidelines.get(k);
      localObject2 = this.system;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(getDebugName());
      ((StringBuilder)localObject3).append(".VG");
      ((StringBuilder)localObject3).append(k);
      ((ConstraintWidget)localObject1).setDebugSolverName((LinearSystem)localObject2, ((StringBuilder)localObject3).toString());
    }
    i = this.mHorizontalGuidelines.size();
    for (k = j; k < i; k++)
    {
      localObject2 = (Guideline)this.mHorizontalGuidelines.get(k);
      localObject3 = this.system;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getDebugName());
      ((StringBuilder)localObject1).append(".HG");
      ((StringBuilder)localObject1).append(k);
      ((ConstraintWidget)localObject2).setDebugSolverName((LinearSystem)localObject3, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    super.addToSolver(paramLinearSystem);
    int i = this.mChildren.size();
    if (i == 0) {
      return;
    }
    setTableDimensions();
    if (paramLinearSystem == this.mSystem)
    {
      int j = this.mVerticalGuidelines.size();
      int k = 0;
      boolean bool;
      Guideline localGuideline;
      for (int m = 0;; m++)
      {
        bool = true;
        if (m >= j) {
          break;
        }
        localGuideline = (Guideline)this.mVerticalGuidelines.get(m);
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          bool = false;
        }
        localGuideline.setPositionRelaxed(bool);
        localGuideline.addToSolver(paramLinearSystem);
      }
      int n = this.mHorizontalGuidelines.size();
      for (j = 0;; j++)
      {
        m = k;
        if (j >= n) {
          break;
        }
        localGuideline = (Guideline)this.mHorizontalGuidelines.get(j);
        if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          bool = true;
        } else {
          bool = false;
        }
        localGuideline.setPositionRelaxed(bool);
        localGuideline.addToSolver(paramLinearSystem);
      }
      while (m < i)
      {
        ((ConstraintWidget)this.mChildren.get(m)).addToSolver(paramLinearSystem);
        m++;
      }
    }
  }
  
  public void computeGuidelinesPercentPositions()
  {
    int i = this.mVerticalGuidelines.size();
    int j = 0;
    for (int k = 0; k < i; k++) {
      ((Guideline)this.mVerticalGuidelines.get(k)).inferRelativePercentPosition();
    }
    i = this.mHorizontalGuidelines.size();
    for (k = j; k < i; k++) {
      ((Guideline)this.mHorizontalGuidelines.get(k)).inferRelativePercentPosition();
    }
  }
  
  public void cycleColumnAlignment(int paramInt)
  {
    VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(paramInt);
    paramInt = localVerticalSlice.alignment;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          localVerticalSlice.alignment = 1;
        }
      }
      else {
        localVerticalSlice.alignment = 0;
      }
    }
    else {
      localVerticalSlice.alignment = 2;
    }
    setChildrenConnections();
  }
  
  public String getColumnAlignmentRepresentation(int paramInt)
  {
    paramInt = ((VerticalSlice)this.mVerticalSlices.get(paramInt)).alignment;
    if (paramInt == 1) {
      return "L";
    }
    if (paramInt == 0) {
      return "C";
    }
    if (paramInt == 3) {
      return "F";
    }
    if (paramInt == 2) {
      return "R";
    }
    return "!";
  }
  
  public String getColumnsAlignmentRepresentation()
  {
    int i = this.mVerticalSlices.size();
    Object localObject1 = "";
    int j = 0;
    while (j < i)
    {
      int k = ((VerticalSlice)this.mVerticalSlices.get(j)).alignment;
      Object localObject2;
      if (k == 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("L");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else if (k == 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("C");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else if (k == 3)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("F");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = localObject1;
        if (k == 2)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("R");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      j++;
      localObject1 = localObject2;
    }
    return (String)localObject1;
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    return this.mHorizontalGuidelines;
  }
  
  public int getNumCols()
  {
    return this.mNumCols;
  }
  
  public int getNumRows()
  {
    return this.mNumRows;
  }
  
  public int getPadding()
  {
    return this.mPadding;
  }
  
  public String getType()
  {
    return "ConstraintTableLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    return this.mVerticalGuidelines;
  }
  
  public boolean handlesInternalConstraints()
  {
    return true;
  }
  
  public boolean isVerticalGrowth()
  {
    return this.mVerticalGrowth;
  }
  
  public void setColumnAlignment(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.mVerticalSlices.size())
    {
      ((VerticalSlice)this.mVerticalSlices.get(paramInt1)).alignment = paramInt2;
      setChildrenConnections();
    }
  }
  
  public void setColumnAlignment(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      int k = paramString.charAt(j);
      if (k == 76) {
        setColumnAlignment(j, 1);
      } else if (k == 67) {
        setColumnAlignment(j, 0);
      } else if (k == 70) {
        setColumnAlignment(j, 3);
      } else if (k == 82) {
        setColumnAlignment(j, 2);
      } else {
        setColumnAlignment(j, 0);
      }
    }
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString)
  {
    this.system = paramLinearSystem;
    super.setDebugSolverName(paramLinearSystem, paramString);
    updateDebugSolverNames();
  }
  
  public void setNumCols(int paramInt)
  {
    if ((this.mVerticalGrowth) && (this.mNumCols != paramInt))
    {
      this.mNumCols = paramInt;
      setVerticalSlices();
      setTableDimensions();
    }
  }
  
  public void setNumRows(int paramInt)
  {
    if ((!this.mVerticalGrowth) && (this.mNumCols != paramInt))
    {
      this.mNumRows = paramInt;
      setHorizontalSlices();
      setTableDimensions();
    }
  }
  
  public void setPadding(int paramInt)
  {
    if (paramInt > 1) {
      this.mPadding = paramInt;
    }
  }
  
  public void setTableDimensions()
  {
    int i = this.mChildren.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((ConstraintWidget)this.mChildren.get(j)).getContainerItemSkip();
      j++;
    }
    i += k;
    int m;
    if (this.mVerticalGrowth)
    {
      if (this.mNumCols == 0) {
        setNumCols(1);
      }
      m = this.mNumCols;
      k = i / m;
      j = k;
      if (m * k < i) {
        j = k + 1;
      }
      if ((this.mNumRows == j) && (this.mVerticalGuidelines.size() == this.mNumCols - 1)) {
        return;
      }
      this.mNumRows = j;
      setHorizontalSlices();
    }
    else
    {
      if (this.mNumRows == 0) {
        setNumRows(1);
      }
      m = this.mNumRows;
      k = i / m;
      j = k;
      if (m * k < i) {
        j = k + 1;
      }
      if ((this.mNumCols == j) && (this.mHorizontalGuidelines.size() == this.mNumRows - 1)) {
        return;
      }
      this.mNumCols = j;
      setVerticalSlices();
    }
    setChildrenConnections();
  }
  
  public void setVerticalGrowth(boolean paramBoolean)
  {
    this.mVerticalGrowth = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem)
  {
    super.updateFromSolver(paramLinearSystem);
    if (paramLinearSystem == this.mSystem)
    {
      int i = this.mVerticalGuidelines.size();
      int j = 0;
      for (int k = 0; k < i; k++) {
        ((Guideline)this.mVerticalGuidelines.get(k)).updateFromSolver(paramLinearSystem);
      }
      i = this.mHorizontalGuidelines.size();
      for (k = j; k < i; k++) {
        ((Guideline)this.mHorizontalGuidelines.get(k)).updateFromSolver(paramLinearSystem);
      }
    }
  }
  
  class HorizontalSlice
  {
    ConstraintWidget bottom;
    int padding;
    ConstraintWidget top;
    
    HorizontalSlice() {}
  }
  
  class VerticalSlice
  {
    int alignment = 1;
    ConstraintWidget left;
    int padding;
    ConstraintWidget right;
    
    VerticalSlice() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ConstraintTableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */