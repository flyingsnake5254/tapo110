package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class HiddenFileFilter
  extends a
  implements Serializable
{
  public static final b HIDDEN;
  public static final b VISIBLE;
  private static final long serialVersionUID = 8930842316112759062L;
  
  static
  {
    HiddenFileFilter localHiddenFileFilter = new HiddenFileFilter();
    HIDDEN = localHiddenFileFilter;
    VISIBLE = new NotFileFilter(localHiddenFileFilter);
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.isHidden();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\HiddenFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */