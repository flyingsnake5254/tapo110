package androidx.constraintlayout.solver;

public class Cache
{
  Pools.Pool<ArrayRow> arrayRowPool = new Pools.SimplePool(256);
  SolverVariable[] mIndexedVariables = new SolverVariable[32];
  Pools.Pool<SolverVariable> solverVariablePool = new Pools.SimplePool(256);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */