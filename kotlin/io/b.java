package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.j;

public final class b
{
  private static final String b(File paramFile1, File paramFile2, String paramString)
  {
    paramFile1 = new StringBuilder(paramFile1.toString());
    if (paramFile2 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramFile2);
      paramFile1.append(localStringBuilder.toString());
    }
    if (paramString != null)
    {
      paramFile2 = new StringBuilder();
      paramFile2.append(": ");
      paramFile2.append(paramString);
      paramFile1.append(paramFile2.toString());
    }
    paramFile1 = paramFile1.toString();
    j.d(paramFile1, "sb.toString()");
    return paramFile1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\io\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */