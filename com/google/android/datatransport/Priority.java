package com.google.android.datatransport;

public enum Priority
{
  static
  {
    Priority localPriority1 = new Priority("DEFAULT", 0);
    DEFAULT = localPriority1;
    Priority localPriority2 = new Priority("VERY_LOW", 1);
    VERY_LOW = localPriority2;
    Priority localPriority3 = new Priority("HIGHEST", 2);
    HIGHEST = localPriority3;
    $VALUES = new Priority[] { localPriority1, localPriority2, localPriority3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\Priority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */