package com.tplink.iot.Utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class g0
{
  public static <T> void a(List<T> paramList, Comparator<? super T> paramComparator)
  {
    try
    {
      Collections.sort(paramList, paramComparator);
    }
    catch (IllegalArgumentException paramList)
    {
      paramList.printStackTrace();
    }
    catch (UnsupportedOperationException paramList)
    {
      paramList.printStackTrace();
    }
    catch (ClassCastException paramList)
    {
      paramList.printStackTrace();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */