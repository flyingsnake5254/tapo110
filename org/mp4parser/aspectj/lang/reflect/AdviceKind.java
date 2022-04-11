package org.mp4parser.aspectj.lang.reflect;

public enum AdviceKind
{
  static
  {
    AdviceKind localAdviceKind1 = new AdviceKind("BEFORE", 0);
    BEFORE = localAdviceKind1;
    AdviceKind localAdviceKind2 = new AdviceKind("AFTER", 1);
    AFTER = localAdviceKind2;
    AdviceKind localAdviceKind3 = new AdviceKind("AFTER_RETURNING", 2);
    AFTER_RETURNING = localAdviceKind3;
    AdviceKind localAdviceKind4 = new AdviceKind("AFTER_THROWING", 3);
    AFTER_THROWING = localAdviceKind4;
    AdviceKind localAdviceKind5 = new AdviceKind("AROUND", 4);
    AROUND = localAdviceKind5;
    $VALUES = new AdviceKind[] { localAdviceKind1, localAdviceKind2, localAdviceKind3, localAdviceKind4, localAdviceKind5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\mp4parser\aspectj\lang\reflect\AdviceKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */