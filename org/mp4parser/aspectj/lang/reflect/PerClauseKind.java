package org.mp4parser.aspectj.lang.reflect;

public enum PerClauseKind
{
  static
  {
    PerClauseKind localPerClauseKind1 = new PerClauseKind("SINGLETON", 0);
    SINGLETON = localPerClauseKind1;
    PerClauseKind localPerClauseKind2 = new PerClauseKind("PERTHIS", 1);
    PERTHIS = localPerClauseKind2;
    PerClauseKind localPerClauseKind3 = new PerClauseKind("PERTARGET", 2);
    PERTARGET = localPerClauseKind3;
    PerClauseKind localPerClauseKind4 = new PerClauseKind("PERCFLOW", 3);
    PERCFLOW = localPerClauseKind4;
    PerClauseKind localPerClauseKind5 = new PerClauseKind("PERCFLOWBELOW", 4);
    PERCFLOWBELOW = localPerClauseKind5;
    PerClauseKind localPerClauseKind6 = new PerClauseKind("PERTYPEWITHIN", 5);
    PERTYPEWITHIN = localPerClauseKind6;
    $VALUES = new PerClauseKind[] { localPerClauseKind1, localPerClauseKind2, localPerClauseKind3, localPerClauseKind4, localPerClauseKind5, localPerClauseKind6 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\mp4parser\aspectj\lang\reflect\PerClauseKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */