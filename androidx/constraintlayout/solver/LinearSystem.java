package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem
{
  private static final boolean DEBUG = false;
  public static final boolean FULL_DEBUG = false;
  private static int POOL_SIZE = 1000;
  public static Metrics sMetrics;
  private int TABLE_SIZE = 32;
  public boolean graphOptimizer = false;
  private boolean[] mAlreadyTestedCandidates = new boolean[32];
  final Cache mCache;
  private Row mGoal;
  private int mMaxColumns = 32;
  private int mMaxRows = 32;
  int mNumColumns = 1;
  int mNumRows = 0;
  private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
  private int mPoolVariablesCount = 0;
  ArrayRow[] mRows = null;
  private final Row mTempGoal;
  private HashMap<String, SolverVariable> mVariables = null;
  int mVariablesID = 0;
  private ArrayRow[] tempClientsCopy = new ArrayRow[32];
  
  public LinearSystem()
  {
    releaseRows();
    Cache localCache = new Cache();
    this.mCache = localCache;
    this.mGoal = new GoalRow(localCache);
    this.mTempGoal = new ArrayRow(localCache);
  }
  
  private SolverVariable acquireSolverVariable(SolverVariable.Type paramType, String paramString)
  {
    SolverVariable localSolverVariable = (SolverVariable)this.mCache.solverVariablePool.acquire();
    if (localSolverVariable == null)
    {
      localSolverVariable = new SolverVariable(paramType, paramString);
      localSolverVariable.setType(paramType, paramString);
      paramType = localSolverVariable;
    }
    else
    {
      localSolverVariable.reset();
      localSolverVariable.setType(paramType, paramString);
      paramType = localSolverVariable;
    }
    int i = this.mPoolVariablesCount;
    int j = POOL_SIZE;
    if (i >= j)
    {
      j *= 2;
      POOL_SIZE = j;
      this.mPoolVariables = ((SolverVariable[])Arrays.copyOf(this.mPoolVariables, j));
    }
    paramString = this.mPoolVariables;
    j = this.mPoolVariablesCount;
    this.mPoolVariablesCount = (j + 1);
    paramString[j] = paramType;
    return paramType;
  }
  
  private void addError(ArrayRow paramArrayRow)
  {
    paramArrayRow.addError(this, 0);
  }
  
  private final void addRow(ArrayRow paramArrayRow)
  {
    Object localObject = this.mRows;
    int i = this.mNumRows;
    if (localObject[i] != null) {
      this.mCache.arrayRowPool.release(localObject[i]);
    }
    localObject = this.mRows;
    i = this.mNumRows;
    localObject[i] = paramArrayRow;
    localObject = paramArrayRow.variable;
    ((SolverVariable)localObject).definitionId = i;
    this.mNumRows = (i + 1);
    ((SolverVariable)localObject).updateReferencesWithNewDefinition(paramArrayRow);
  }
  
  private void addSingleError(ArrayRow paramArrayRow, int paramInt)
  {
    addSingleError(paramArrayRow, paramInt, 0);
  }
  
  private void computeValues()
  {
    for (int i = 0; i < this.mNumRows; i++)
    {
      ArrayRow localArrayRow = this.mRows[i];
      localArrayRow.variable.computedValue = localArrayRow.constantValue;
    }
  }
  
  public static ArrayRow createRowCentering(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramBoolean) {
      localArrayRow.addError(paramLinearSystem, 4);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowDimensionPercent(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    if (paramBoolean) {
      paramLinearSystem.addError(localArrayRow);
    }
    return localArrayRow.createRowDimensionPercent(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramFloat);
  }
  
  public static ArrayRow createRowEquals(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, 1);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowGreaterThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowLowerThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  private SolverVariable createVariable(String paramString, SolverVariable.Type paramType)
  {
    Metrics localMetrics = sMetrics;
    if (localMetrics != null) {
      localMetrics.variables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramType = acquireSolverVariable(paramType, null);
    paramType.setName(paramString);
    int i = this.mVariablesID + 1;
    this.mVariablesID = i;
    this.mNumColumns += 1;
    paramType.id = i;
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    this.mVariables.put(paramString, paramType);
    this.mCache.mIndexedVariables[this.mVariablesID] = paramType;
    return paramType;
  }
  
  private void displayRows()
  {
    displaySolverVariables();
    String str = "";
    for (int i = 0; i < this.mNumRows; i++)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.mRows[i]);
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.mGoal);
    localStringBuilder.append("\n");
    str = localStringBuilder.toString();
    System.out.println(str);
  }
  
  private void displaySolverVariables()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Display Rows (");
    ((StringBuilder)localObject).append(this.mNumRows);
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(this.mNumColumns);
    ((StringBuilder)localObject).append(")\n");
    localObject = ((StringBuilder)localObject).toString();
    System.out.println((String)localObject);
  }
  
  private int enforceBFS(Row paramRow)
    throws Exception
  {
    for (int i = 0; i < this.mNumRows; i++)
    {
      paramRow = this.mRows;
      if ((paramRow[i].variable.mType != SolverVariable.Type.UNRESTRICTED) && (paramRow[i].constantValue < 0.0F))
      {
        i = 1;
        break label57;
      }
    }
    i = 0;
    label57:
    if (i != 0)
    {
      int j = 0;
      int k;
      for (i = 0; j == 0; i = k)
      {
        paramRow = sMetrics;
        if (paramRow != null) {
          paramRow.bfs += 1L;
        }
        k = i + 1;
        float f1 = Float.MAX_VALUE;
        int m = 0;
        int n = -1;
        i = -1;
        Object localObject;
        int i4;
        for (int i1 = 0; m < this.mNumRows; i1 = i4)
        {
          localObject = this.mRows[m];
          float f2;
          int i2;
          int i3;
          if (((ArrayRow)localObject).variable.mType == SolverVariable.Type.UNRESTRICTED)
          {
            f2 = f1;
            i2 = n;
            i3 = i;
            i4 = i1;
          }
          else if (((ArrayRow)localObject).isSimpleDefinition)
          {
            f2 = f1;
            i2 = n;
            i3 = i;
            i4 = i1;
          }
          else
          {
            f2 = f1;
            i2 = n;
            i3 = i;
            i4 = i1;
            if (((ArrayRow)localObject).constantValue < 0.0F)
            {
              int i5 = 1;
              for (;;)
              {
                f2 = f1;
                i2 = n;
                i3 = i;
                i4 = i1;
                if (i5 >= this.mNumColumns) {
                  break;
                }
                paramRow = this.mCache.mIndexedVariables[i5];
                float f3 = ((ArrayRow)localObject).variables.get(paramRow);
                int i6;
                if (f3 <= 0.0F)
                {
                  f2 = f1;
                  i4 = n;
                  i6 = i;
                  i3 = i1;
                }
                else
                {
                  i4 = 0;
                  i2 = i;
                  i = i4;
                  for (;;)
                  {
                    f2 = f1;
                    i4 = n;
                    i6 = i2;
                    i3 = i1;
                    if (i >= 7) {
                      break;
                    }
                    f2 = paramRow.strengthVector[i] / f3;
                    if ((f2 >= f1) || (i != i1))
                    {
                      i4 = i1;
                      if (i <= i1) {}
                    }
                    else
                    {
                      i2 = i5;
                      i4 = i;
                      f1 = f2;
                      n = m;
                    }
                    i++;
                    i1 = i4;
                  }
                }
                i5++;
                f1 = f2;
                n = i4;
                i = i6;
                i1 = i3;
              }
            }
          }
          m++;
          f1 = f2;
          n = i2;
          i = i3;
        }
        if (n != -1)
        {
          paramRow = this.mRows[n];
          paramRow.variable.definitionId = -1;
          localObject = sMetrics;
          if (localObject != null) {
            ((Metrics)localObject).pivots += 1L;
          }
          paramRow.pivot(this.mCache.mIndexedVariables[i]);
          localObject = paramRow.variable;
          ((SolverVariable)localObject).definitionId = n;
          ((SolverVariable)localObject).updateReferencesWithNewDefinition(paramRow);
        }
        else
        {
          j = 1;
        }
        if (k > this.mNumColumns / 2) {
          j = 1;
        }
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  private String getDisplaySize(int paramInt)
  {
    paramInt *= 4;
    int i = paramInt / 1024;
    int j = i / 1024;
    if (j > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(j);
      localStringBuilder.append(" Mb");
      return localStringBuilder.toString();
    }
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      localStringBuilder.append(" Kb");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes");
    return localStringBuilder.toString();
  }
  
  private String getDisplayStrength(int paramInt)
  {
    if (paramInt == 1) {
      return "LOW";
    }
    if (paramInt == 2) {
      return "MEDIUM";
    }
    if (paramInt == 3) {
      return "HIGH";
    }
    if (paramInt == 4) {
      return "HIGHEST";
    }
    if (paramInt == 5) {
      return "EQUALITY";
    }
    if (paramInt == 6) {
      return "FIXED";
    }
    return "NONE";
  }
  
  public static Metrics getMetrics()
  {
    return sMetrics;
  }
  
  private void increaseTableSize()
  {
    int i = this.TABLE_SIZE * 2;
    this.TABLE_SIZE = i;
    this.mRows = ((ArrayRow[])Arrays.copyOf(this.mRows, i));
    Object localObject = this.mCache;
    ((Cache)localObject).mIndexedVariables = ((SolverVariable[])Arrays.copyOf(((Cache)localObject).mIndexedVariables, this.TABLE_SIZE));
    i = this.TABLE_SIZE;
    this.mAlreadyTestedCandidates = new boolean[i];
    this.mMaxColumns = i;
    this.mMaxRows = i;
    localObject = sMetrics;
    if (localObject != null)
    {
      ((Metrics)localObject).tableSizeIncrease += 1L;
      ((Metrics)localObject).maxTableSize = Math.max(((Metrics)localObject).maxTableSize, i);
      localObject = sMetrics;
      ((Metrics)localObject).lastTableSize = ((Metrics)localObject).maxTableSize;
    }
  }
  
  private final int optimize(Row paramRow, boolean paramBoolean)
  {
    Object localObject1 = sMetrics;
    if (localObject1 != null) {
      ((Metrics)localObject1).optimize += 1L;
    }
    for (int i = 0; i < this.mNumColumns; i++) {
      this.mAlreadyTestedCandidates[i] = false;
    }
    int j = 0;
    i = 0;
    while (j == 0)
    {
      localObject1 = sMetrics;
      if (localObject1 != null) {
        ((Metrics)localObject1).iterations += 1L;
      }
      int k = i + 1;
      if (k >= this.mNumColumns * 2) {
        return k;
      }
      if (paramRow.getKey() != null) {
        this.mAlreadyTestedCandidates[paramRow.getKey().id] = true;
      }
      localObject1 = paramRow.getPivotCandidate(this, this.mAlreadyTestedCandidates);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = this.mAlreadyTestedCandidates;
        i = ((SolverVariable)localObject1).id;
        if (localObject2[i] != 0) {
          return k;
        }
        localObject2[i] = 1;
      }
      if (localObject1 != null)
      {
        float f1 = Float.MAX_VALUE;
        i = 0;
        int n;
        for (int m = -1; i < this.mNumRows; m = n)
        {
          localObject2 = this.mRows[i];
          float f2;
          if (((ArrayRow)localObject2).variable.mType == SolverVariable.Type.UNRESTRICTED)
          {
            f2 = f1;
            n = m;
          }
          else if (((ArrayRow)localObject2).isSimpleDefinition)
          {
            f2 = f1;
            n = m;
          }
          else
          {
            f2 = f1;
            n = m;
            if (((ArrayRow)localObject2).hasVariable((SolverVariable)localObject1))
            {
              float f3 = ((ArrayRow)localObject2).variables.get((SolverVariable)localObject1);
              f2 = f1;
              n = m;
              if (f3 < 0.0F)
              {
                f3 = -((ArrayRow)localObject2).constantValue / f3;
                f2 = f1;
                n = m;
                if (f3 < f1)
                {
                  n = i;
                  f2 = f3;
                }
              }
            }
          }
          i++;
          f1 = f2;
        }
        if (m > -1)
        {
          localObject2 = this.mRows[m];
          ((ArrayRow)localObject2).variable.definitionId = -1;
          Metrics localMetrics = sMetrics;
          if (localMetrics != null) {
            localMetrics.pivots += 1L;
          }
          ((ArrayRow)localObject2).pivot((SolverVariable)localObject1);
          localObject1 = ((ArrayRow)localObject2).variable;
          ((SolverVariable)localObject1).definitionId = m;
          ((SolverVariable)localObject1).updateReferencesWithNewDefinition((ArrayRow)localObject2);
          i = k;
          continue;
        }
      }
      j = 1;
      i = k;
    }
    return i;
  }
  
  private void releaseRows()
  {
    for (int i = 0;; i++)
    {
      Object localObject = this.mRows;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        this.mCache.arrayRowPool.release(localObject);
      }
      this.mRows[i] = null;
    }
  }
  
  private final void updateRowFromVariables(ArrayRow paramArrayRow)
  {
    if (this.mNumRows > 0)
    {
      paramArrayRow.variables.updateFromSystem(paramArrayRow, this.mRows);
      if (paramArrayRow.variables.currentSize == 0) {
        paramArrayRow.isSimpleDefinition = true;
      }
    }
  }
  
  public void addCenterPoint(ConstraintWidget paramConstraintWidget1, ConstraintWidget paramConstraintWidget2, float paramFloat, int paramInt)
  {
    Object localObject1 = ConstraintAnchor.Type.LEFT;
    SolverVariable localSolverVariable1 = createObjectVariable(paramConstraintWidget1.getAnchor((ConstraintAnchor.Type)localObject1));
    Object localObject2 = ConstraintAnchor.Type.TOP;
    SolverVariable localSolverVariable2 = createObjectVariable(paramConstraintWidget1.getAnchor((ConstraintAnchor.Type)localObject2));
    Object localObject3 = ConstraintAnchor.Type.RIGHT;
    SolverVariable localSolverVariable3 = createObjectVariable(paramConstraintWidget1.getAnchor((ConstraintAnchor.Type)localObject3));
    Object localObject4 = ConstraintAnchor.Type.BOTTOM;
    paramConstraintWidget1 = createObjectVariable(paramConstraintWidget1.getAnchor((ConstraintAnchor.Type)localObject4));
    localObject1 = createObjectVariable(paramConstraintWidget2.getAnchor((ConstraintAnchor.Type)localObject1));
    localObject2 = createObjectVariable(paramConstraintWidget2.getAnchor((ConstraintAnchor.Type)localObject2));
    localObject3 = createObjectVariable(paramConstraintWidget2.getAnchor((ConstraintAnchor.Type)localObject3));
    paramConstraintWidget2 = createObjectVariable(paramConstraintWidget2.getAnchor((ConstraintAnchor.Type)localObject4));
    localObject4 = createRow();
    double d1 = paramFloat;
    double d2 = Math.sin(d1);
    double d3 = paramInt;
    ((ArrayRow)localObject4).createRowWithAngle(localSolverVariable2, paramConstraintWidget1, (SolverVariable)localObject2, paramConstraintWidget2, (float)(d2 * d3));
    addConstraint((ArrayRow)localObject4);
    paramConstraintWidget1 = createRow();
    paramConstraintWidget1.createRowWithAngle(localSolverVariable1, localSolverVariable3, (SolverVariable)localObject1, (SolverVariable)localObject3, (float)(Math.cos(d1) * d3));
    addConstraint(paramConstraintWidget1);
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramInt3 != 6) {
      localArrayRow.addError(this, paramInt3);
    }
    addConstraint(localArrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow)
  {
    if (paramArrayRow == null) {
      return;
    }
    Object localObject = sMetrics;
    if (localObject != null)
    {
      ((Metrics)localObject).constraints += 1L;
      if (paramArrayRow.isSimpleDefinition) {
        ((Metrics)localObject).simpleconstraints += 1L;
      }
    }
    int i = this.mNumRows;
    int j = 1;
    if ((i + 1 >= this.mMaxRows) || (this.mNumColumns + 1 >= this.mMaxColumns)) {
      increaseTableSize();
    }
    i = 0;
    if (!paramArrayRow.isSimpleDefinition)
    {
      updateRowFromVariables(paramArrayRow);
      if (paramArrayRow.isEmpty()) {
        return;
      }
      paramArrayRow.ensurePositiveConstant();
      if (paramArrayRow.chooseSubject(this))
      {
        localObject = createExtraVariable();
        paramArrayRow.variable = ((SolverVariable)localObject);
        addRow(paramArrayRow);
        this.mTempGoal.initFromRow(paramArrayRow);
        optimize(this.mTempGoal, true);
        i = j;
        if (((SolverVariable)localObject).definitionId == -1)
        {
          if (paramArrayRow.variable == localObject)
          {
            SolverVariable localSolverVariable = paramArrayRow.pickPivot((SolverVariable)localObject);
            if (localSolverVariable != null)
            {
              localObject = sMetrics;
              if (localObject != null) {
                ((Metrics)localObject).pivots += 1L;
              }
              paramArrayRow.pivot(localSolverVariable);
            }
          }
          if (!paramArrayRow.isSimpleDefinition) {
            paramArrayRow.variable.updateReferencesWithNewDefinition(paramArrayRow);
          }
          this.mNumRows -= 1;
          i = j;
        }
      }
      else
      {
        i = 0;
      }
      if (!paramArrayRow.hasKeyVariable()) {
        return;
      }
    }
    if (i == 0) {
      addRow(paramArrayRow);
    }
  }
  
  public ArrayRow addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    if (paramInt2 != 6) {
      localArrayRow.addError(this, paramInt2);
    }
    addConstraint(localArrayRow);
    return localArrayRow;
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt)
  {
    int i = paramSolverVariable.definitionId;
    ArrayRow localArrayRow;
    if (i != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt;
      }
      else if (localArrayRow.variables.currentSize == 0)
      {
        localArrayRow.isSimpleDefinition = true;
        localArrayRow.constantValue = paramInt;
      }
      else
      {
        localArrayRow = createRow();
        localArrayRow.createRowEquals(paramSolverVariable, paramInt);
        addConstraint(localArrayRow);
      }
    }
    else
    {
      localArrayRow = createRow();
      localArrayRow.createRowDefinition(paramSolverVariable, paramInt);
      addConstraint(localArrayRow);
    }
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt1, int paramInt2)
  {
    int i = paramSolverVariable.definitionId;
    ArrayRow localArrayRow;
    if (i != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt1;
      }
      else
      {
        localArrayRow = createRow();
        localArrayRow.createRowEquals(paramSolverVariable, paramInt1);
        localArrayRow.addError(this, paramInt2);
        addConstraint(localArrayRow);
      }
    }
    else
    {
      localArrayRow = createRow();
      localArrayRow.createRowDefinition(paramSolverVariable, paramInt1);
      localArrayRow.addError(this, paramInt2);
      addConstraint(localArrayRow);
    }
  }
  
  public void addGreaterBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, 0);
    if (paramBoolean) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), 1);
    }
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable, int paramInt)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable, paramInt, localSolverVariable);
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 6) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), paramInt2);
    }
    addConstraint(localArrayRow);
  }
  
  public void addLowerBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, 0);
    if (paramBoolean) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), 1);
    }
    addConstraint(localArrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 6) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), paramInt2);
    }
    addConstraint(localArrayRow);
  }
  
  public void addRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat, int paramInt)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDimensionRatio(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramSolverVariable4, paramFloat);
    if (paramInt != 6) {
      localArrayRow.addError(this, paramInt);
    }
    addConstraint(localArrayRow);
  }
  
  void addSingleError(ArrayRow paramArrayRow, int paramInt1, int paramInt2)
  {
    paramArrayRow.addSingleError(createErrorVariable(paramInt2, null), paramInt1);
  }
  
  public SolverVariable createErrorVariable(int paramInt, String paramString)
  {
    Metrics localMetrics = sMetrics;
    if (localMetrics != null) {
      localMetrics.errors += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramString = acquireSolverVariable(SolverVariable.Type.ERROR, paramString);
    int i = this.mVariablesID + 1;
    this.mVariablesID = i;
    this.mNumColumns += 1;
    paramString.id = i;
    paramString.strength = paramInt;
    this.mCache.mIndexedVariables[i] = paramString;
    this.mGoal.addError(paramString);
    return paramString;
  }
  
  public SolverVariable createExtraVariable()
  {
    Object localObject = sMetrics;
    if (localObject != null) {
      ((Metrics)localObject).extravariables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    localObject = acquireSolverVariable(SolverVariable.Type.SLACK, null);
    int i = this.mVariablesID + 1;
    this.mVariablesID = i;
    this.mNumColumns += 1;
    ((SolverVariable)localObject).id = i;
    this.mCache.mIndexedVariables[i] = localObject;
    return (SolverVariable)localObject;
  }
  
  public SolverVariable createObjectVariable(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return null;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    if ((paramObject instanceof ConstraintAnchor))
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)paramObject;
      localObject = localConstraintAnchor.getSolverVariable();
      paramObject = localObject;
      if (localObject == null)
      {
        localConstraintAnchor.resetSolverVariable(this.mCache);
        paramObject = localConstraintAnchor.getSolverVariable();
      }
      int i = ((SolverVariable)paramObject).id;
      if ((i != -1) && (i <= this.mVariablesID))
      {
        localObject = paramObject;
        if (this.mCache.mIndexedVariables[i] != null) {}
      }
      else
      {
        if (i != -1) {
          ((SolverVariable)paramObject).reset();
        }
        i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns += 1;
        ((SolverVariable)paramObject).id = i;
        ((SolverVariable)paramObject).mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[i] = paramObject;
        localObject = paramObject;
      }
    }
    return (SolverVariable)localObject;
  }
  
  public ArrayRow createRow()
  {
    ArrayRow localArrayRow = (ArrayRow)this.mCache.arrayRowPool.acquire();
    if (localArrayRow == null) {
      localArrayRow = new ArrayRow(this.mCache);
    } else {
      localArrayRow.reset();
    }
    SolverVariable.increaseErrorId();
    return localArrayRow;
  }
  
  public SolverVariable createSlackVariable()
  {
    Object localObject = sMetrics;
    if (localObject != null) {
      ((Metrics)localObject).slackvariables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    localObject = acquireSolverVariable(SolverVariable.Type.SLACK, null);
    int i = this.mVariablesID + 1;
    this.mVariablesID = i;
    this.mNumColumns += 1;
    ((SolverVariable)localObject).id = i;
    this.mCache.mIndexedVariables[i] = localObject;
    return (SolverVariable)localObject;
  }
  
  void displayReadableRows()
  {
    displaySolverVariables();
    String str = " #  ";
    for (int i = 0; i < this.mNumRows; i++)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mRows[i].toReadableString());
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\n #  ");
      str = ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (this.mGoal != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mGoal);
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    System.out.println((String)localObject);
  }
  
  void displaySystemInformations()
  {
    int i = 0;
    for (int j = 0; i < this.TABLE_SIZE; j = k)
    {
      localObject = this.mRows;
      k = j;
      if (localObject[i] != null) {
        k = j + localObject[i].sizeInBytes();
      }
      i++;
    }
    int m = 0;
    for (int k = 0; m < this.mNumRows; k = i)
    {
      localObject = this.mRows;
      i = k;
      if (localObject[m] != null) {
        i = k + localObject[m].sizeInBytes();
      }
      m++;
    }
    Object localObject = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Linear System -> Table size: ");
    localStringBuilder.append(this.TABLE_SIZE);
    localStringBuilder.append(" (");
    i = this.TABLE_SIZE;
    localStringBuilder.append(getDisplaySize(i * i));
    localStringBuilder.append(") -- row sizes: ");
    localStringBuilder.append(getDisplaySize(j));
    localStringBuilder.append(", actual size: ");
    localStringBuilder.append(getDisplaySize(k));
    localStringBuilder.append(" rows: ");
    localStringBuilder.append(this.mNumRows);
    localStringBuilder.append("/");
    localStringBuilder.append(this.mMaxRows);
    localStringBuilder.append(" cols: ");
    localStringBuilder.append(this.mNumColumns);
    localStringBuilder.append("/");
    localStringBuilder.append(this.mMaxColumns);
    localStringBuilder.append(" ");
    localStringBuilder.append(0);
    localStringBuilder.append(" occupied cells, ");
    localStringBuilder.append(getDisplaySize(0));
    ((PrintStream)localObject).println(localStringBuilder.toString());
  }
  
  public void displayVariablesReadableRows()
  {
    displaySolverVariables();
    Object localObject1 = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      localObject2 = localObject1;
      if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.mRows[i].toReadableString());
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("\n");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      i++;
      localObject1 = localObject2;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.mGoal);
    ((StringBuilder)localObject2).append("\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    System.out.println((String)localObject1);
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    sMetrics = paramMetrics;
  }
  
  public Cache getCache()
  {
    return this.mCache;
  }
  
  Row getGoal()
  {
    return this.mGoal;
  }
  
  public int getMemoryUsed()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.mNumRows; j = k)
    {
      ArrayRow[] arrayOfArrayRow = this.mRows;
      k = j;
      if (arrayOfArrayRow[i] != null) {
        k = j + arrayOfArrayRow[i].sizeInBytes();
      }
      i++;
    }
    return j;
  }
  
  public int getNumEquations()
  {
    return this.mNumRows;
  }
  
  public int getNumVariables()
  {
    return this.mVariablesID;
  }
  
  public int getObjectVariableValue(Object paramObject)
  {
    paramObject = ((ConstraintAnchor)paramObject).getSolverVariable();
    if (paramObject != null) {
      return (int)(((SolverVariable)paramObject).computedValue + 0.5F);
    }
    return 0;
  }
  
  ArrayRow getRow(int paramInt)
  {
    return this.mRows[paramInt];
  }
  
  float getValueFor(String paramString)
  {
    paramString = getVariable(paramString, SolverVariable.Type.UNRESTRICTED);
    if (paramString == null) {
      return 0.0F;
    }
    return paramString.computedValue;
  }
  
  SolverVariable getVariable(String paramString, SolverVariable.Type paramType)
  {
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    SolverVariable localSolverVariable1 = (SolverVariable)this.mVariables.get(paramString);
    SolverVariable localSolverVariable2 = localSolverVariable1;
    if (localSolverVariable1 == null) {
      localSolverVariable2 = createVariable(paramString, paramType);
    }
    return localSolverVariable2;
  }
  
  public void minimize()
    throws Exception
  {
    Metrics localMetrics = sMetrics;
    if (localMetrics != null) {
      localMetrics.minimize += 1L;
    }
    if (this.graphOptimizer)
    {
      if (localMetrics != null) {
        localMetrics.graphOptimizer += 1L;
      }
      int i = 0;
      for (int j = 0; j < this.mNumRows; j++) {
        if (!this.mRows[j].isSimpleDefinition)
        {
          j = i;
          break label76;
        }
      }
      j = 1;
      label76:
      if (j == 0)
      {
        minimizeGoal(this.mGoal);
      }
      else
      {
        localMetrics = sMetrics;
        if (localMetrics != null) {
          localMetrics.fullySolved += 1L;
        }
        computeValues();
      }
    }
    else
    {
      minimizeGoal(this.mGoal);
    }
  }
  
  void minimizeGoal(Row paramRow)
    throws Exception
  {
    Metrics localMetrics = sMetrics;
    if (localMetrics != null)
    {
      localMetrics.minimizeGoal += 1L;
      localMetrics.maxVariables = Math.max(localMetrics.maxVariables, this.mNumColumns);
      localMetrics = sMetrics;
      localMetrics.maxRows = Math.max(localMetrics.maxRows, this.mNumRows);
    }
    updateRowFromVariables((ArrayRow)paramRow);
    enforceBFS(paramRow);
    optimize(paramRow, false);
    computeValues();
  }
  
  public void reset()
  {
    Cache localCache;
    for (int i = 0;; i++)
    {
      localCache = this.mCache;
      localObject = localCache.mIndexedVariables;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null) {
        ((SolverVariable)localObject).reset();
      }
    }
    localCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
    this.mPoolVariablesCount = 0;
    Arrays.fill(this.mCache.mIndexedVariables, null);
    Object localObject = this.mVariables;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.mVariablesID = 0;
    this.mGoal.clear();
    this.mNumColumns = 1;
    for (i = 0; i < this.mNumRows; i++) {
      this.mRows[i].used = false;
    }
    releaseRows();
    this.mNumRows = 0;
  }
  
  static abstract interface Row
  {
    public abstract void addError(SolverVariable paramSolverVariable);
    
    public abstract void clear();
    
    public abstract SolverVariable getKey();
    
    public abstract SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean);
    
    public abstract void initFromRow(Row paramRow);
    
    public abstract boolean isEmpty();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\LinearSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */