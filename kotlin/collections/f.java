package kotlin.collections;

class f
{
  public static final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex (");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") is greater than size (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(").");
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */