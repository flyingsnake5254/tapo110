package io.reactivex.internal.util;

public enum ErrorMode
{
  static
  {
    ErrorMode localErrorMode1 = new ErrorMode("IMMEDIATE", 0);
    IMMEDIATE = localErrorMode1;
    ErrorMode localErrorMode2 = new ErrorMode("BOUNDARY", 1);
    BOUNDARY = localErrorMode2;
    ErrorMode localErrorMode3 = new ErrorMode("END", 2);
    END = localErrorMode3;
    $VALUES = new ErrorMode[] { localErrorMode1, localErrorMode2, localErrorMode3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\ErrorMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */