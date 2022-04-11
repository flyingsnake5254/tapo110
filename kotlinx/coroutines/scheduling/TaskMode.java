package kotlinx.coroutines.scheduling;

public enum TaskMode
{
  static
  {
    TaskMode localTaskMode1 = new TaskMode("NON_BLOCKING", 0);
    NON_BLOCKING = localTaskMode1;
    TaskMode localTaskMode2 = new TaskMode("PROBABLY_BLOCKING", 1);
    PROBABLY_BLOCKING = localTaskMode2;
    $VALUES = new TaskMode[] { localTaskMode1, localTaskMode2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\TaskMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */