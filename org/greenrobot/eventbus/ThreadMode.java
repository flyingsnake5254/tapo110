package org.greenrobot.eventbus;

public enum ThreadMode
{
  static
  {
    ThreadMode localThreadMode1 = new ThreadMode("POSTING", 0);
    POSTING = localThreadMode1;
    ThreadMode localThreadMode2 = new ThreadMode("MAIN", 1);
    MAIN = localThreadMode2;
    ThreadMode localThreadMode3 = new ThreadMode("BACKGROUND", 2);
    BACKGROUND = localThreadMode3;
    ThreadMode localThreadMode4 = new ThreadMode("ASYNC", 3);
    ASYNC = localThreadMode4;
    $VALUES = new ThreadMode[] { localThreadMode1, localThreadMode2, localThreadMode3, localThreadMode4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\eventbus\ThreadMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */