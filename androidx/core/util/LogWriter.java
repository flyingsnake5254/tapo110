package androidx.core.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.Writer;

@Deprecated
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class LogWriter
  extends Writer
{
  private StringBuilder mBuilder = new StringBuilder(128);
  private final String mTag;
  
  public LogWriter(String paramString)
  {
    this.mTag = paramString;
  }
  
  private void flushBuilder()
  {
    if (this.mBuilder.length() > 0)
    {
      Log.d(this.mTag, this.mBuilder.toString());
      StringBuilder localStringBuilder = this.mBuilder;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void close()
  {
    flushBuilder();
  }
  
  public void flush()
  {
    flushBuilder();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    for (int i = 0; i < paramInt2; i++)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
      } else {
        this.mBuilder.append(c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\LogWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */