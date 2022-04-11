package com.bumptech.glide;

public enum Priority
{
  static
  {
    Priority localPriority1 = new Priority("IMMEDIATE", 0);
    IMMEDIATE = localPriority1;
    Priority localPriority2 = new Priority("HIGH", 1);
    HIGH = localPriority2;
    Priority localPriority3 = new Priority("NORMAL", 2);
    NORMAL = localPriority3;
    Priority localPriority4 = new Priority("LOW", 3);
    LOW = localPriority4;
    $VALUES = new Priority[] { localPriority1, localPriority2, localPriority3, localPriority4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\Priority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */