package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.l;

@Keep
public class CctBackendFactory
  implements com.google.android.datatransport.runtime.backends.d
{
  public l create(g paramg)
  {
    return new d(paramg.b(), paramg.e(), paramg.d());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\CctBackendFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */