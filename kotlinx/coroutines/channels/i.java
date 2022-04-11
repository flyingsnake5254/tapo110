package kotlinx.coroutines.channels;

public final class i
{
  public static final <E> f<E> a(int paramInt)
  {
    Object localObject;
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt != Integer.MAX_VALUE) {
            localObject = new d(paramInt);
          } else {
            localObject = new m();
          }
        }
        else {
          localObject = new t();
        }
      }
      else {
        localObject = new l();
      }
    }
    else {
      localObject = new d(f.i.a());
    }
    return (f<E>)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */