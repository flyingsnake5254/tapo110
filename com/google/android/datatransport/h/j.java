package com.google.android.datatransport.h;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class j
{
  static Executor a()
  {
    return new l(Executors.newSingleThreadExecutor());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */