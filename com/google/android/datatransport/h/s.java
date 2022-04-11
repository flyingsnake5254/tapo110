package com.google.android.datatransport.h;

import android.content.Context;
import com.google.android.datatransport.h.x.j.y;
import java.io.Closeable;
import java.io.IOException;

abstract class s
  implements Closeable
{
  abstract y a();
  
  abstract r c();
  
  public void close()
    throws IOException
  {
    a().close();
  }
  
  static abstract interface a
  {
    public abstract a a(Context paramContext);
    
    public abstract s build();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */