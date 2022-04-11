package kotlin.contracts;

public enum InvocationKind
{
  static
  {
    InvocationKind localInvocationKind1 = new InvocationKind("AT_MOST_ONCE", 0);
    AT_MOST_ONCE = localInvocationKind1;
    InvocationKind localInvocationKind2 = new InvocationKind("AT_LEAST_ONCE", 1);
    AT_LEAST_ONCE = localInvocationKind2;
    InvocationKind localInvocationKind3 = new InvocationKind("EXACTLY_ONCE", 2);
    EXACTLY_ONCE = localInvocationKind3;
    InvocationKind localInvocationKind4 = new InvocationKind("UNKNOWN", 3);
    UNKNOWN = localInvocationKind4;
    $VALUES = new InvocationKind[] { localInvocationKind1, localInvocationKind2, localInvocationKind3, localInvocationKind4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\contracts\InvocationKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */