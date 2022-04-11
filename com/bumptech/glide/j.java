package com.bumptech.glide;

import com.bumptech.glide.request.l.a;
import com.bumptech.glide.request.l.c;

public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType>
  implements Cloneable
{
  private c<? super TranscodeType> c = a.b();
  
  public final CHILD a()
  {
    try
    {
      j localj = (j)super.clone();
      return localj;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  final c<? super TranscodeType> b()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */