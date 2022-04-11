package kotlin.io;

public enum FileWalkDirection
{
  static
  {
    FileWalkDirection localFileWalkDirection1 = new FileWalkDirection("TOP_DOWN", 0);
    TOP_DOWN = localFileWalkDirection1;
    FileWalkDirection localFileWalkDirection2 = new FileWalkDirection("BOTTOM_UP", 1);
    BOTTOM_UP = localFileWalkDirection2;
    $VALUES = new FileWalkDirection[] { localFileWalkDirection1, localFileWalkDirection2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\io\FileWalkDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */