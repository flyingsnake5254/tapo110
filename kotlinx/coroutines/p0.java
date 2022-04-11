package kotlinx.coroutines;

final class p0
  implements y0
{
  private final boolean c;
  
  public p0(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public n1 d()
  {
    return null;
  }
  
  public boolean isActive()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty{");
    String str;
    if (isActive()) {
      str = "Active";
    } else {
      str = "New";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */