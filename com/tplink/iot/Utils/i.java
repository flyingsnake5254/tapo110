package com.tplink.iot.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.j;

public final class i
{
  private static final String b(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuilder.append((String)paramArrayList.next());
      localStringBuilder.append(' ');
    }
    paramArrayList = localStringBuilder.toString();
    j.d(paramArrayList, "stringBuilder.toString()");
    return paramArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */