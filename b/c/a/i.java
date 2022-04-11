package b.c.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class i
  implements c
{
  private final int a;
  private final int b;
  private final boolean c;
  @NonNull
  private final e d;
  @Nullable
  private final String e;
  
  private i(@NonNull b paramb)
  {
    k.a(paramb);
    this.a = paramb.a;
    this.b = paramb.b;
    this.c = paramb.c;
    this.d = paramb.d;
    this.e = paramb.e;
  }
  
  @Nullable
  private String b(@Nullable String paramString)
  {
    if ((!k.d(paramString)) && (!k.b(this.e, paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append("-");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return this.e;
  }
  
  private String c(@NonNull String paramString)
  {
    k.a(paramString);
    return paramString.substring(paramString.lastIndexOf(".") + 1);
  }
  
  private int d(@NonNull StackTraceElement[] paramArrayOfStackTraceElement)
  {
    k.a(paramArrayOfStackTraceElement);
    for (int i = 5; i < paramArrayOfStackTraceElement.length; i++)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if ((!str.equals(h.class.getName())) && (!str.equals(g.class.getName()))) {
        return i - 1;
      }
    }
    return -1;
  }
  
  private void e(int paramInt, @Nullable String paramString)
  {
    f(paramInt, paramString, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
  }
  
  private void f(int paramInt, @Nullable String paramString1, @NonNull String paramString2)
  {
    k.a(paramString2);
    this.d.a(paramInt, paramString1, paramString2);
  }
  
  private void g(int paramInt, @Nullable String paramString1, @NonNull String paramString2)
  {
    k.a(paramString2);
    for (String str : paramString2.split(System.getProperty("line.separator")))
    {
      paramString2 = new StringBuilder();
      paramString2.append("│ ");
      paramString2.append(str);
      f(paramInt, paramString1, paramString2.toString());
    }
  }
  
  private void h(int paramInt, @Nullable String paramString)
  {
    f(paramInt, paramString, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
  }
  
  private void i(int paramInt1, @Nullable String paramString, int paramInt2)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (this.c)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("│ Thread: ");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      f(paramInt1, paramString, ((StringBuilder)localObject).toString());
      h(paramInt1, paramString);
    }
    int i = d(arrayOfStackTraceElement) + this.b;
    int j = paramInt2;
    if (paramInt2 + i > arrayOfStackTraceElement.length) {
      j = arrayOfStackTraceElement.length - i - 1;
    }
    Object localObject = "";
    while (j > 0)
    {
      paramInt2 = j + i;
      if (paramInt2 < arrayOfStackTraceElement.length)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append('│');
        localStringBuilder1.append(' ');
        localStringBuilder1.append((String)localObject);
        localStringBuilder1.append(c(arrayOfStackTraceElement[paramInt2].getClassName()));
        localStringBuilder1.append(".");
        localStringBuilder1.append(arrayOfStackTraceElement[paramInt2].getMethodName());
        localStringBuilder1.append(" ");
        localStringBuilder1.append(" (");
        localStringBuilder1.append(arrayOfStackTraceElement[paramInt2].getFileName());
        localStringBuilder1.append(":");
        localStringBuilder1.append(arrayOfStackTraceElement[paramInt2].getLineNumber());
        localStringBuilder1.append(")");
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)localObject);
        localStringBuilder2.append("   ");
        localObject = localStringBuilder2.toString();
        f(paramInt1, paramString, localStringBuilder1.toString());
      }
      j--;
    }
  }
  
  private void j(int paramInt, @Nullable String paramString)
  {
    f(paramInt, paramString, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
  }
  
  @NonNull
  public static b k()
  {
    return new b(null);
  }
  
  public void a(int paramInt, @Nullable String paramString1, @NonNull String paramString2)
  {
    k.a(paramString2);
    paramString1 = b(paramString1);
    j(paramInt, paramString1);
    i(paramInt, paramString1, this.a);
    byte[] arrayOfByte = paramString2.getBytes();
    int i = arrayOfByte.length;
    if (i <= 4000)
    {
      if (this.a > 0) {
        h(paramInt, paramString1);
      }
      g(paramInt, paramString1, paramString2);
      e(paramInt, paramString1);
      return;
    }
    if (this.a > 0) {
      h(paramInt, paramString1);
    }
    for (int j = 0; j < i; j += 4000) {
      g(paramInt, paramString1, new String(arrayOfByte, j, Math.min(i - j, 4000)));
    }
    e(paramInt, paramString1);
  }
  
  public static class b
  {
    int a = 2;
    int b = 0;
    boolean c = true;
    @Nullable
    e d;
    @Nullable
    String e = "PRETTY_LOGGER";
    
    @NonNull
    public i a()
    {
      if (this.d == null) {
        this.d = new f();
      }
      return new i(this, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\c\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */