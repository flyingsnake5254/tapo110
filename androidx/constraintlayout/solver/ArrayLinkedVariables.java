package androidx.constraintlayout.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables
{
  private static final boolean DEBUG = false;
  private static final boolean FULL_NEW_CHECK = false;
  private static final int NONE = -1;
  private int ROW_SIZE = 8;
  private SolverVariable candidate = null;
  int currentSize = 0;
  private int[] mArrayIndices = new int[8];
  private int[] mArrayNextIndices = new int[8];
  private float[] mArrayValues = new float[8];
  private final Cache mCache;
  private boolean mDidFillOnce = false;
  private int mHead = -1;
  private int mLast = -1;
  private final ArrayRow mRow;
  
  ArrayLinkedVariables(ArrayRow paramArrayRow, Cache paramCache)
  {
    this.mRow = paramArrayRow;
    this.mCache = paramCache;
  }
  
  private boolean isNew(SolverVariable paramSolverVariable, LinearSystem paramLinearSystem)
  {
    int i = paramSolverVariable.usageInRowCount;
    boolean bool = true;
    if (i > 1) {
      bool = false;
    }
    return bool;
  }
  
  final void add(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    int i = this.mHead;
    if (i == -1)
    {
      this.mHead = 0;
      this.mArrayValues[0] = paramFloat;
      this.mArrayIndices[0] = paramSolverVariable.id;
      this.mArrayNextIndices[0] = -1;
      paramSolverVariable.usageInRowCount += 1;
      paramSolverVariable.addToRow(this.mRow);
      this.currentSize += 1;
      if (!this.mDidFillOnce)
      {
        i = this.mLast + 1;
        this.mLast = i;
        paramSolverVariable = this.mArrayIndices;
        if (i >= paramSolverVariable.length)
        {
          this.mDidFillOnce = true;
          this.mLast = (paramSolverVariable.length - 1);
        }
      }
      return;
    }
    int j = 0;
    int k = -1;
    int n;
    while ((i != -1) && (j < this.currentSize))
    {
      localObject = this.mArrayIndices;
      int m = localObject[i];
      n = paramSolverVariable.id;
      if (m == n)
      {
        localObject = this.mArrayValues;
        localObject[i] += paramFloat;
        if (localObject[i] == 0.0F)
        {
          if (i == this.mHead)
          {
            this.mHead = this.mArrayNextIndices[i];
          }
          else
          {
            localObject = this.mArrayNextIndices;
            localObject[k] = localObject[i];
          }
          if (paramBoolean) {
            paramSolverVariable.removeFromRow(this.mRow);
          }
          if (this.mDidFillOnce) {
            this.mLast = i;
          }
          paramSolverVariable.usageInRowCount -= 1;
          this.currentSize -= 1;
        }
        return;
      }
      if (localObject[i] < n) {
        k = i;
      }
      i = this.mArrayNextIndices[i];
      j++;
    }
    i = this.mLast;
    if (this.mDidFillOnce)
    {
      localObject = this.mArrayIndices;
      if (localObject[i] != -1) {
        i = localObject.length;
      }
    }
    else
    {
      i++;
    }
    Object localObject = this.mArrayIndices;
    j = i;
    if (i >= localObject.length)
    {
      j = i;
      if (this.currentSize < localObject.length) {
        for (n = 0;; n++)
        {
          localObject = this.mArrayIndices;
          j = i;
          if (n >= localObject.length) {
            break;
          }
          if (localObject[n] == -1)
          {
            j = n;
            break;
          }
        }
      }
    }
    localObject = this.mArrayIndices;
    i = j;
    if (j >= localObject.length)
    {
      i = localObject.length;
      j = this.ROW_SIZE * 2;
      this.ROW_SIZE = j;
      this.mDidFillOnce = false;
      this.mLast = (i - 1);
      this.mArrayValues = Arrays.copyOf(this.mArrayValues, j);
      this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
      this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    }
    this.mArrayIndices[i] = paramSolverVariable.id;
    this.mArrayValues[i] = paramFloat;
    if (k != -1)
    {
      localObject = this.mArrayNextIndices;
      localObject[i] = localObject[k];
      localObject[k] = i;
    }
    else
    {
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
    paramSolverVariable.usageInRowCount += 1;
    paramSolverVariable.addToRow(this.mRow);
    this.currentSize += 1;
    if (!this.mDidFillOnce) {
      this.mLast += 1;
    }
    i = this.mLast;
    paramSolverVariable = this.mArrayIndices;
    if (i >= paramSolverVariable.length)
    {
      this.mDidFillOnce = true;
      this.mLast = (paramSolverVariable.length - 1);
    }
  }
  
  SolverVariable chooseSubject(LinearSystem paramLinearSystem)
  {
    int i = this.mHead;
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 0;
    boolean bool1 = false;
    int k = 0;
    float f1 = 0.0F;
    label132:
    float f5;
    for (float f2 = 0.0F; (i != -1) && (j < this.currentSize); f2 = f5)
    {
      Object localObject3 = this.mArrayValues;
      float f3 = localObject3[i];
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
      if (f3 < 0.0F)
      {
        f4 = f3;
        if (f3 <= -0.001F) {
          break label132;
        }
        localObject3[i] = 0.0F;
        localSolverVariable.removeFromRow(this.mRow);
      }
      else
      {
        f4 = f3;
        if (f3 >= 0.001F) {
          break label132;
        }
        localObject3[i] = 0.0F;
        localSolverVariable.removeFromRow(this.mRow);
      }
      float f4 = 0.0F;
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      boolean bool2 = bool1;
      int m = k;
      f3 = f1;
      f5 = f2;
      if (f4 != 0.0F) {
        if (localSolverVariable.mType == SolverVariable.Type.UNRESTRICTED)
        {
          if (localObject2 == null) {}
          for (bool2 = isNew(localSolverVariable, paramLinearSystem);; bool2 = isNew(localSolverVariable, paramLinearSystem))
          {
            localObject3 = localObject1;
            localObject4 = localSolverVariable;
            m = k;
            f3 = f4;
            f5 = f2;
            break label517;
            if (f1 <= f4) {
              break;
            }
          }
          localObject3 = localObject1;
          localObject4 = localObject2;
          bool2 = bool1;
          m = k;
          f3 = f1;
          f5 = f2;
          if (!bool1)
          {
            localObject3 = localObject1;
            localObject4 = localObject2;
            bool2 = bool1;
            m = k;
            f3 = f1;
            f5 = f2;
            if (isNew(localSolverVariable, paramLinearSystem))
            {
              bool2 = true;
              localObject3 = localObject1;
              localObject4 = localSolverVariable;
              m = k;
              f3 = f4;
              f5 = f2;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          bool2 = bool1;
          m = k;
          f3 = f1;
          f5 = f2;
          if (localObject2 == null)
          {
            localObject3 = localObject1;
            localObject4 = localObject2;
            bool2 = bool1;
            m = k;
            f3 = f1;
            f5 = f2;
            if (f4 < 0.0F)
            {
              if (localObject1 == null) {}
              for (bool2 = isNew(localSolverVariable, paramLinearSystem);; bool2 = isNew(localSolverVariable, paramLinearSystem))
              {
                m = bool2;
                localObject3 = localSolverVariable;
                localObject4 = localObject2;
                bool2 = bool1;
                f3 = f1;
                f5 = f4;
                break label517;
                if (f2 <= f4) {
                  break;
                }
              }
              localObject3 = localObject1;
              localObject4 = localObject2;
              bool2 = bool1;
              m = k;
              f3 = f1;
              f5 = f2;
              if (k == 0)
              {
                localObject3 = localObject1;
                localObject4 = localObject2;
                bool2 = bool1;
                m = k;
                f3 = f1;
                f5 = f2;
                if (isNew(localSolverVariable, paramLinearSystem))
                {
                  m = 1;
                  f5 = f4;
                  f3 = f1;
                  bool2 = bool1;
                  localObject4 = localObject2;
                  localObject3 = localSolverVariable;
                }
              }
            }
          }
        }
      }
      label517:
      i = this.mArrayNextIndices[i];
      j++;
      localObject1 = localObject3;
      localObject2 = localObject4;
      bool1 = bool2;
      k = m;
      f1 = f3;
    }
    if (localObject2 != null) {
      return (SolverVariable)localObject2;
    }
    return (SolverVariable)localObject1;
  }
  
  public final void clear()
  {
    int i = this.mHead;
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
      if (localSolverVariable != null) {
        localSolverVariable.removeFromRow(this.mRow);
      }
      i = this.mArrayNextIndices[i];
    }
    this.mHead = -1;
    this.mLast = -1;
    this.mDidFillOnce = false;
    this.currentSize = 0;
  }
  
  final boolean containsKey(SolverVariable paramSolverVariable)
  {
    int i = this.mHead;
    if (i == -1) {
      return false;
    }
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      if (this.mArrayIndices[i] == paramSolverVariable.id) {
        return true;
      }
      i = this.mArrayNextIndices[i];
    }
    return false;
  }
  
  public void display()
  {
    int i = this.currentSize;
    System.out.print("{ ");
    for (int j = 0; j < i; j++)
    {
      SolverVariable localSolverVariable = getVariable(j);
      if (localSolverVariable != null)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localSolverVariable);
        localStringBuilder.append(" = ");
        localStringBuilder.append(getVariableValue(j));
        localStringBuilder.append(" ");
        localPrintStream.print(localStringBuilder.toString());
      }
    }
    System.out.println(" }");
  }
  
  void divideByAmount(float paramFloat)
  {
    int i = this.mHead;
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[i] /= paramFloat;
      i = this.mArrayNextIndices[i];
    }
  }
  
  public final float get(SolverVariable paramSolverVariable)
  {
    int i = this.mHead;
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      if (this.mArrayIndices[i] == paramSolverVariable.id) {
        return this.mArrayValues[i];
      }
      i = this.mArrayNextIndices[i];
    }
    return 0.0F;
  }
  
  SolverVariable getPivotCandidate()
  {
    Object localObject1 = this.candidate;
    if (localObject1 == null)
    {
      int i = this.mHead;
      int j = 0;
      for (Object localObject2 = null; (i != -1) && (j < this.currentSize); localObject2 = localObject1)
      {
        localObject1 = localObject2;
        if (this.mArrayValues[i] < 0.0F)
        {
          SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((SolverVariable)localObject2).strength >= localSolverVariable.strength) {}
          }
          else
          {
            localObject1 = localSolverVariable;
          }
        }
        i = this.mArrayNextIndices[i];
        j++;
      }
      return (SolverVariable)localObject2;
    }
    return (SolverVariable)localObject1;
  }
  
  SolverVariable getPivotCandidate(boolean[] paramArrayOfBoolean, SolverVariable paramSolverVariable)
  {
    int i = this.mHead;
    int j = 0;
    Object localObject1 = null;
    float f2;
    for (float f1 = 0.0F; (i != -1) && (j < this.currentSize); f1 = f2)
    {
      float[] arrayOfFloat = this.mArrayValues;
      Object localObject2 = localObject1;
      f2 = f1;
      if (arrayOfFloat[i] < 0.0F)
      {
        SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
        if (paramArrayOfBoolean != null)
        {
          localObject2 = localObject1;
          f2 = f1;
          if (paramArrayOfBoolean[localSolverVariable.id] != 0) {}
        }
        else
        {
          localObject2 = localObject1;
          f2 = f1;
          if (localSolverVariable != paramSolverVariable)
          {
            SolverVariable.Type localType = localSolverVariable.mType;
            if (localType != SolverVariable.Type.SLACK)
            {
              localObject2 = localObject1;
              f2 = f1;
              if (localType != SolverVariable.Type.ERROR) {}
            }
            else
            {
              float f3 = arrayOfFloat[i];
              localObject2 = localObject1;
              f2 = f1;
              if (f3 < f1)
              {
                f2 = f3;
                localObject2 = localSolverVariable;
              }
            }
          }
        }
      }
      i = this.mArrayNextIndices[i];
      j++;
      localObject1 = localObject2;
    }
    return (SolverVariable)localObject1;
  }
  
  final SolverVariable getVariable(int paramInt)
  {
    int i = this.mHead;
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      if (j == paramInt) {
        return this.mCache.mIndexedVariables[this.mArrayIndices[i]];
      }
      i = this.mArrayNextIndices[i];
    }
    return null;
  }
  
  final float getVariableValue(int paramInt)
  {
    int i = this.mHead;
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      if (j == paramInt) {
        return this.mArrayValues[i];
      }
      i = this.mArrayNextIndices[i];
    }
    return 0.0F;
  }
  
  boolean hasAtLeastOnePositiveVariable()
  {
    int i = this.mHead;
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      if (this.mArrayValues[i] > 0.0F) {
        return true;
      }
      i = this.mArrayNextIndices[i];
    }
    return false;
  }
  
  void invert()
  {
    int i = this.mHead;
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[i] *= -1.0F;
      i = this.mArrayNextIndices[i];
    }
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      remove(paramSolverVariable, true);
      return;
    }
    int i = this.mHead;
    if (i == -1)
    {
      this.mHead = 0;
      this.mArrayValues[0] = paramFloat;
      this.mArrayIndices[0] = paramSolverVariable.id;
      this.mArrayNextIndices[0] = -1;
      paramSolverVariable.usageInRowCount += 1;
      paramSolverVariable.addToRow(this.mRow);
      this.currentSize += 1;
      if (!this.mDidFillOnce)
      {
        i = this.mLast + 1;
        this.mLast = i;
        paramSolverVariable = this.mArrayIndices;
        if (i >= paramSolverVariable.length)
        {
          this.mDidFillOnce = true;
          this.mLast = (paramSolverVariable.length - 1);
        }
      }
      return;
    }
    int j = 0;
    int k = -1;
    int n;
    while ((i != -1) && (j < this.currentSize))
    {
      arrayOfInt = this.mArrayIndices;
      int m = arrayOfInt[i];
      n = paramSolverVariable.id;
      if (m == n)
      {
        this.mArrayValues[i] = paramFloat;
        return;
      }
      if (arrayOfInt[i] < n) {
        k = i;
      }
      i = this.mArrayNextIndices[i];
      j++;
    }
    i = this.mLast;
    if (this.mDidFillOnce)
    {
      arrayOfInt = this.mArrayIndices;
      if (arrayOfInt[i] != -1) {
        i = arrayOfInt.length;
      }
    }
    else
    {
      i++;
    }
    int[] arrayOfInt = this.mArrayIndices;
    j = i;
    if (i >= arrayOfInt.length)
    {
      j = i;
      if (this.currentSize < arrayOfInt.length) {
        for (n = 0;; n++)
        {
          arrayOfInt = this.mArrayIndices;
          j = i;
          if (n >= arrayOfInt.length) {
            break;
          }
          if (arrayOfInt[n] == -1)
          {
            j = n;
            break;
          }
        }
      }
    }
    arrayOfInt = this.mArrayIndices;
    i = j;
    if (j >= arrayOfInt.length)
    {
      i = arrayOfInt.length;
      j = this.ROW_SIZE * 2;
      this.ROW_SIZE = j;
      this.mDidFillOnce = false;
      this.mLast = (i - 1);
      this.mArrayValues = Arrays.copyOf(this.mArrayValues, j);
      this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
      this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    }
    this.mArrayIndices[i] = paramSolverVariable.id;
    this.mArrayValues[i] = paramFloat;
    if (k != -1)
    {
      arrayOfInt = this.mArrayNextIndices;
      arrayOfInt[i] = arrayOfInt[k];
      arrayOfInt[k] = i;
    }
    else
    {
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
    paramSolverVariable.usageInRowCount += 1;
    paramSolverVariable.addToRow(this.mRow);
    i = this.currentSize + 1;
    this.currentSize = i;
    if (!this.mDidFillOnce) {
      this.mLast += 1;
    }
    paramSolverVariable = this.mArrayIndices;
    if (i >= paramSolverVariable.length) {
      this.mDidFillOnce = true;
    }
    if (this.mLast >= paramSolverVariable.length)
    {
      this.mDidFillOnce = true;
      this.mLast = (paramSolverVariable.length - 1);
    }
  }
  
  public final float remove(SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    if (this.candidate == paramSolverVariable) {
      this.candidate = null;
    }
    int i = this.mHead;
    if (i == -1) {
      return 0.0F;
    }
    int j = 0;
    int k = -1;
    while ((i != -1) && (j < this.currentSize))
    {
      if (this.mArrayIndices[i] == paramSolverVariable.id)
      {
        if (i == this.mHead)
        {
          this.mHead = this.mArrayNextIndices[i];
        }
        else
        {
          int[] arrayOfInt = this.mArrayNextIndices;
          arrayOfInt[k] = arrayOfInt[i];
        }
        if (paramBoolean) {
          paramSolverVariable.removeFromRow(this.mRow);
        }
        paramSolverVariable.usageInRowCount -= 1;
        this.currentSize -= 1;
        this.mArrayIndices[i] = -1;
        if (this.mDidFillOnce) {
          this.mLast = i;
        }
        return this.mArrayValues[i];
      }
      int m = this.mArrayNextIndices[i];
      j++;
      k = i;
      i = m;
    }
    return 0.0F;
  }
  
  int sizeInBytes()
  {
    return this.mArrayIndices.length * 4 * 3 + 0 + 36;
  }
  
  public String toString()
  {
    int i = this.mHead;
    Object localObject1 = "";
    for (int j = 0; (i != -1) && (j < this.currentSize); j++)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" -> ");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(this.mArrayValues[i]);
      ((StringBuilder)localObject1).append(" : ");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.mCache.mIndexedVariables[this.mArrayIndices[i]]);
      localObject1 = ((StringBuilder)localObject2).toString();
      i = this.mArrayNextIndices[i];
    }
    return (String)localObject1;
  }
  
  final void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2, boolean paramBoolean)
  {
    int i = this.mHead;
    for (int j = 0;; j++)
    {
      if ((i == -1) || (j >= this.currentSize)) {
        return;
      }
      int k = this.mArrayIndices[i];
      Object localObject = paramArrayRow2.variable;
      if (k == ((SolverVariable)localObject).id)
      {
        float f = this.mArrayValues[i];
        remove((SolverVariable)localObject, paramBoolean);
        localObject = paramArrayRow2.variables;
        j = ((ArrayLinkedVariables)localObject).mHead;
        for (i = 0; (j != -1) && (i < ((ArrayLinkedVariables)localObject).currentSize); i++)
        {
          add(this.mCache.mIndexedVariables[localObject.mArrayIndices[j]], localObject.mArrayValues[j] * f, paramBoolean);
          j = localObject.mArrayNextIndices[j];
        }
        paramArrayRow1.constantValue += paramArrayRow2.constantValue * f;
        if (paramBoolean) {
          paramArrayRow2.variable.removeFromRow(paramArrayRow1);
        }
        i = this.mHead;
        break;
      }
      i = this.mArrayNextIndices[i];
    }
  }
  
  void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow)
  {
    int i = this.mHead;
    for (int j = 0;; j++)
    {
      if ((i == -1) || (j >= this.currentSize)) {
        return;
      }
      Object localObject = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
      if (((SolverVariable)localObject).definitionId != -1)
      {
        float f = this.mArrayValues[i];
        remove((SolverVariable)localObject, true);
        localObject = paramArrayOfArrayRow[localObject.definitionId];
        if (!((ArrayRow)localObject).isSimpleDefinition)
        {
          ArrayLinkedVariables localArrayLinkedVariables = ((ArrayRow)localObject).variables;
          j = localArrayLinkedVariables.mHead;
          for (i = 0; (j != -1) && (i < localArrayLinkedVariables.currentSize); i++)
          {
            add(this.mCache.mIndexedVariables[localArrayLinkedVariables.mArrayIndices[j]], localArrayLinkedVariables.mArrayValues[j] * f, true);
            j = localArrayLinkedVariables.mArrayNextIndices[j];
          }
        }
        paramArrayRow.constantValue += ((ArrayRow)localObject).constantValue * f;
        ((ArrayRow)localObject).variable.removeFromRow(paramArrayRow);
        i = this.mHead;
        break;
      }
      i = this.mArrayNextIndices[i];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\ArrayLinkedVariables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */