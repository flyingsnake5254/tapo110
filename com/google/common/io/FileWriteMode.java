package com.google.common.io;

public enum FileWriteMode
{
  static
  {
    FileWriteMode localFileWriteMode = new FileWriteMode("APPEND", 0);
    APPEND = localFileWriteMode;
    $VALUES = new FileWriteMode[] { localFileWriteMode };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\io\FileWriteMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */