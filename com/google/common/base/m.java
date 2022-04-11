package com.google.common.base;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class m
{
  private static final Logger a = Logger.getLogger(m.class.getName());
  private static final l b = a();
  
  private static l a()
  {
    return new b(null);
  }
  
  static boolean b(@NullableDecl String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static final class b
    implements l
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */