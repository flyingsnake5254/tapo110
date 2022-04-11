package kotlin.io;

public enum OnErrorAction
{
  static
  {
    OnErrorAction localOnErrorAction1 = new OnErrorAction("SKIP", 0);
    SKIP = localOnErrorAction1;
    OnErrorAction localOnErrorAction2 = new OnErrorAction("TERMINATE", 1);
    TERMINATE = localOnErrorAction2;
    $VALUES = new OnErrorAction[] { localOnErrorAction1, localOnErrorAction2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\io\OnErrorAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */