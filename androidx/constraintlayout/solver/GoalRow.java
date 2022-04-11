package androidx.constraintlayout.solver;

public class GoalRow
  extends ArrayRow
{
  public GoalRow(Cache paramCache)
  {
    super(paramCache);
  }
  
  public void addError(SolverVariable paramSolverVariable)
  {
    super.addError(paramSolverVariable);
    paramSolverVariable.usageInRowCount -= 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\GoalRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */