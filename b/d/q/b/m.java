package b.d.q.b;

public class m
{
  public static String a(long paramLong)
  {
    int i = (int)(paramLong % 60L);
    Object localObject1;
    if (i < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = String.valueOf(i);
    }
    i = (int)(paramLong / 60L % 60L);
    Object localObject2;
    if (i < 10)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = String.valueOf(i);
    }
    i = (int)(paramLong / 3600L);
    Object localObject3;
    if (i < 10)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("0");
      ((StringBuilder)localObject3).append(i);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject3 = String.valueOf(i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */