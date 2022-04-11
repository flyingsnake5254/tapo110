package kotlinx.coroutines.channels;

public enum TickerMode
{
  static
  {
    TickerMode localTickerMode1 = new TickerMode("FIXED_PERIOD", 0);
    FIXED_PERIOD = localTickerMode1;
    TickerMode localTickerMode2 = new TickerMode("FIXED_DELAY", 1);
    FIXED_DELAY = localTickerMode2;
    $VALUES = new TickerMode[] { localTickerMode1, localTickerMode2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\TickerMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */