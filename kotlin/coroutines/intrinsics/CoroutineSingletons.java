package kotlin.coroutines.intrinsics;

public enum CoroutineSingletons
{
  static
  {
    CoroutineSingletons localCoroutineSingletons1 = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
    COROUTINE_SUSPENDED = localCoroutineSingletons1;
    CoroutineSingletons localCoroutineSingletons2 = new CoroutineSingletons("UNDECIDED", 1);
    UNDECIDED = localCoroutineSingletons2;
    CoroutineSingletons localCoroutineSingletons3 = new CoroutineSingletons("RESUMED", 2);
    RESUMED = localCoroutineSingletons3;
    $VALUES = new CoroutineSingletons[] { localCoroutineSingletons1, localCoroutineSingletons2, localCoroutineSingletons3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\intrinsics\CoroutineSingletons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */