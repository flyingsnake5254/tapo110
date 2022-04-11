package com.tplink.libtpnetwork.cameranetwork.bean.listing;

import com.tplink.libtpnetwork.cameranetwork.bean.helpers.KeyValue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ListingUtils
{
  public static List<ColumnFilter> getDefaultFilters()
  {
    ArrayList localArrayList = new ArrayList();
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.add(2, -1);
    localArrayList.add(new ColumnFilter("updatedOn", localCalendar.getTime(), Operation.GE));
    localArrayList.add(new ColumnFilter("updatedOn", GregorianCalendar.getInstance().getTime(), Operation.LE));
    return localArrayList;
  }
  
  public static KeyValue<String> getSortBy(String paramString, boolean paramBoolean)
  {
    KeyValue localKeyValue = new KeyValue();
    localKeyValue.setKey(paramString);
    if (paramBoolean) {
      paramString = "asc";
    } else {
      paramString = "desc";
    }
    localKeyValue.setValue(paramString);
    return localKeyValue;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\listing\ListingUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */