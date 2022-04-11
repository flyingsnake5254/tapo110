package kotlin.text;

final class l
{
  public static final Regex a;
  public static final l b = new l();
  
  static
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[eE][+-]?");
    ((StringBuilder)localObject1).append("(\\p{Digit}+)");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("(0[xX]");
    ((StringBuilder)localObject2).append("(\\p{XDigit}+)");
    ((StringBuilder)localObject2).append("(\\.)?)|");
    ((StringBuilder)localObject2).append("(0[xX]");
    ((StringBuilder)localObject2).append("(\\p{XDigit}+)");
    ((StringBuilder)localObject2).append("?(\\.)");
    ((StringBuilder)localObject2).append("(\\p{XDigit}+)");
    ((StringBuilder)localObject2).append(')');
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append("(\\.)?(");
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append("?)(");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(")?)|");
    localStringBuilder.append("(\\.(");
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append(")(");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(")?)|");
    localStringBuilder.append("((");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(")[pP][+-]?");
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append(')');
    localObject2 = localStringBuilder.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(")[fFdD]?))[\\x00-\\x20]*");
    a = new Regex(((StringBuilder)localObject1).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */