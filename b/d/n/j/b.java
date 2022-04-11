package b.d.n.j;

import java.io.File;

public class b
{
  public static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    if (!paramString.isDirectory()) {
      return;
    }
    paramString = paramString.listFiles();
    if ((paramString != null) && (paramString.length > 0))
    {
      int i = paramString.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject = paramString[j];
        if (((File)localObject).isFile()) {
          ((File)localObject).delete();
        }
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramString);
      boolean bool = localFile.exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */