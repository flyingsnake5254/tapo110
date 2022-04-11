package b.d.d.m;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

public class d
{
  private static String a;
  
  public static String a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        File localFile = new java/io/File;
        localFile.<init>(paramContext.getFilesDir(), "INSTALLATION");
        try
        {
          if (!localFile.exists()) {
            c(localFile);
          }
          a = b(localFile);
        }
        catch (Exception localException)
        {
          paramContext = new java/lang/RuntimeException;
          paramContext.<init>(localException);
          throw paramContext;
        }
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static String b(File paramFile)
    throws IOException
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    paramFile = new byte[(int)localRandomAccessFile.length()];
    localRandomAccessFile.readFully(paramFile);
    localRandomAccessFile.close();
    paramFile = new String(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return "UnKnownUUID";
    }
    return paramFile;
  }
  
  private static void c(File paramFile)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(UUID.randomUUID().toString().getBytes());
    paramFile.close();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\m\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */