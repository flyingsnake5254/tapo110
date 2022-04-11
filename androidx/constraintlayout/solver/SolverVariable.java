package androidx.constraintlayout.solver;

import java.util.Arrays;

public class SolverVariable
{
  private static final boolean INTERNAL_DEBUG = false;
  static final int MAX_STRENGTH = 7;
  public static final int STRENGTH_BARRIER = 7;
  public static final int STRENGTH_EQUALITY = 5;
  public static final int STRENGTH_FIXED = 6;
  public static final int STRENGTH_HIGH = 3;
  public static final int STRENGTH_HIGHEST = 4;
  public static final int STRENGTH_LOW = 1;
  public static final int STRENGTH_MEDIUM = 2;
  public static final int STRENGTH_NONE = 0;
  private static int uniqueConstantId = 1;
  private static int uniqueErrorId = 1;
  private static int uniqueId = 1;
  private static int uniqueSlackId = 1;
  private static int uniqueUnrestrictedId = 1;
  public float computedValue;
  int definitionId = -1;
  public int id = -1;
  ArrayRow[] mClientEquations = new ArrayRow[8];
  int mClientEquationsCount = 0;
  private String mName;
  Type mType;
  public int strength = 0;
  float[] strengthVector = new float[7];
  public int usageInRowCount = 0;
  
  public SolverVariable(Type paramType, String paramString)
  {
    this.mType = paramType;
  }
  
  public SolverVariable(String paramString, Type paramType)
  {
    this.mName = paramString;
    this.mType = paramType;
  }
  
  private static String getUniqueName(Type paramType, String paramString)
  {
    if (paramString != null)
    {
      paramType = new StringBuilder();
      paramType.append(paramString);
      paramType.append(uniqueErrorId);
      return paramType.toString();
    }
    int i = 1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5)
            {
              paramType = new StringBuilder();
              paramType.append("V");
              i = uniqueId + 1;
              uniqueId = i;
              paramType.append(i);
              return paramType.toString();
            }
            throw new AssertionError(paramType.name());
          }
          paramType = new StringBuilder();
          paramType.append("e");
          i = uniqueErrorId + 1;
          uniqueErrorId = i;
          paramType.append(i);
          return paramType.toString();
        }
        paramType = new StringBuilder();
        paramType.append("S");
        i = uniqueSlackId + 1;
        uniqueSlackId = i;
        paramType.append(i);
        return paramType.toString();
      }
      paramType = new StringBuilder();
      paramType.append("C");
      i = uniqueConstantId + 1;
      uniqueConstantId = i;
      paramType.append(i);
      return paramType.toString();
    }
    paramType = new StringBuilder();
    paramType.append("U");
    i = uniqueUnrestrictedId + 1;
    uniqueUnrestrictedId = i;
    paramType.append(i);
    return paramType.toString();
  }
  
  static void increaseErrorId()
  {
    uniqueErrorId += 1;
  }
  
  public final void addToRow(ArrayRow paramArrayRow)
  {
    int j;
    for (int i = 0;; i++)
    {
      j = this.mClientEquationsCount;
      if (i >= j) {
        break;
      }
      if (this.mClientEquations[i] == paramArrayRow) {
        return;
      }
    }
    ArrayRow[] arrayOfArrayRow = this.mClientEquations;
    if (j >= arrayOfArrayRow.length) {
      this.mClientEquations = ((ArrayRow[])Arrays.copyOf(arrayOfArrayRow, arrayOfArrayRow.length * 2));
    }
    arrayOfArrayRow = this.mClientEquations;
    i = this.mClientEquationsCount;
    arrayOfArrayRow[i] = paramArrayRow;
    this.mClientEquationsCount = (i + 1);
  }
  
  void clearStrengths()
  {
    for (int i = 0; i < 7; i++) {
      this.strengthVector[i] = 0.0F;
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public final void removeFromRow(ArrayRow paramArrayRow)
  {
    int i = this.mClientEquationsCount;
    int j = 0;
    for (int k = 0; k < i; k++) {
      if (this.mClientEquations[k] == paramArrayRow)
      {
        while (j < i - k - 1)
        {
          paramArrayRow = this.mClientEquations;
          int m = k + j;
          paramArrayRow[m] = paramArrayRow[(m + 1)];
          j++;
        }
        this.mClientEquationsCount -= 1;
        return;
      }
    }
  }
  
  public void reset()
  {
    this.mName = null;
    this.mType = Type.UNKNOWN;
    this.strength = 0;
    this.id = -1;
    this.definitionId = -1;
    this.computedValue = 0.0F;
    this.mClientEquationsCount = 0;
    this.usageInRowCount = 0;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setType(Type paramType, String paramString)
  {
    this.mType = paramType;
  }
  
  String strengthsToString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this);
    ((StringBuilder)localObject1).append("[");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    int i = 0;
    int j = 0;
    int k = 1;
    while (i < this.strengthVector.length)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(this.strengthVector[i]);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = this.strengthVector;
      if (localObject2[i] > 0.0F) {
        j = 0;
      } else if (localObject2[i] < 0.0F) {
        j = 1;
      }
      if (localObject2[i] != 0.0F) {
        k = 0;
      }
      if (i < localObject2.length - 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("] ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      i++;
    }
    localObject1 = localObject2;
    if (j != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" (-)");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (k != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" (*)");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.mName);
    return localStringBuilder.toString();
  }
  
  public final void updateReferencesWithNewDefinition(ArrayRow paramArrayRow)
  {
    int i = this.mClientEquationsCount;
    for (int j = 0; j < i; j++)
    {
      ArrayRow[] arrayOfArrayRow = this.mClientEquations;
      arrayOfArrayRow[j].variables.updateFromRow(arrayOfArrayRow[j], paramArrayRow, false);
    }
    this.mClientEquationsCount = 0;
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("UNRESTRICTED", 0);
      UNRESTRICTED = localType1;
      Type localType2 = new Type("CONSTANT", 1);
      CONSTANT = localType2;
      Type localType3 = new Type("SLACK", 2);
      SLACK = localType3;
      Type localType4 = new Type("ERROR", 3);
      ERROR = localType4;
      Type localType5 = new Type("UNKNOWN", 4);
      UNKNOWN = localType5;
      $VALUES = new Type[] { localType1, localType2, localType3, localType4, localType5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\SolverVariable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */