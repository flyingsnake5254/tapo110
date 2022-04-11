package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

public class EntryXComparator
  implements Comparator<Entry>
{
  public int compare(Entry paramEntry1, Entry paramEntry2)
  {
    boolean bool = paramEntry1.getX() - paramEntry2.getX() < 0.0F;
    if (!bool) {
      return 0;
    }
    if (bool) {
      return 1;
    }
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\EntryXComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */