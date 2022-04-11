package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.e;
import java.util.Collections;
import java.util.List;

public abstract class h
  implements e<h>
{
  public final String a;
  public final List<String> b;
  public final boolean c;
  
  protected h(String paramString, List<String> paramList, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = Collections.unmodifiableList(paramList);
    this.c = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\playlist\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */