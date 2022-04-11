package androidx.core.os;

import androidx.annotation.Nullable;

public class OperationCanceledException
  extends RuntimeException
{
  public OperationCanceledException()
  {
    this(null);
  }
  
  public OperationCanceledException(@Nullable String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\OperationCanceledException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */