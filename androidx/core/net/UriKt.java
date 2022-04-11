package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.j;

public final class UriKt
{
  public static final File toFile(Uri paramUri)
  {
    j.f(paramUri, "$this$toFile");
    if (j.a(paramUri.getScheme(), "file"))
    {
      localObject = paramUri.getPath();
      if (localObject != null) {
        return new File((String)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Uri path is null: ");
      ((StringBuilder)localObject).append(paramUri);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Uri lacks 'file' scheme: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
  }
  
  public static final Uri toUri(File paramFile)
  {
    j.f(paramFile, "$this$toUri");
    paramFile = Uri.fromFile(paramFile);
    j.b(paramFile, "Uri.fromFile(this)");
    return paramFile;
  }
  
  public static final Uri toUri(String paramString)
  {
    j.f(paramString, "$this$toUri");
    paramString = Uri.parse(paramString);
    j.b(paramString, "Uri.parse(this)");
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\net\UriKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */