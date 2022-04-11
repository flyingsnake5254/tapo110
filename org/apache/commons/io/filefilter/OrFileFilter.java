package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OrFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 5767770777065432721L;
  private final List<b> fileFilters;
  
  public OrFileFilter()
  {
    this.fileFilters = new ArrayList();
  }
  
  public OrFileFilter(List<b> paramList)
  {
    if (paramList == null) {
      this.fileFilters = new ArrayList();
    } else {
      this.fileFilters = new ArrayList(paramList);
    }
  }
  
  public OrFileFilter(b paramb1, b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      this.fileFilters = new ArrayList(2);
      addFileFilter(paramb1);
      addFileFilter(paramb2);
      return;
    }
    throw new IllegalArgumentException("The filters must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    Iterator localIterator = this.fileFilters.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).accept(paramFile)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    Iterator localIterator = this.fileFilters.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).accept(paramFile, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void addFileFilter(b paramb)
  {
    this.fileFilters.add(paramb);
  }
  
  public List<b> getFileFilters()
  {
    return Collections.unmodifiableList(this.fileFilters);
  }
  
  public boolean removeFileFilter(b paramb)
  {
    return this.fileFilters.remove(paramb);
  }
  
  public void setFileFilters(List<b> paramList)
  {
    this.fileFilters.clear();
    this.fileFilters.addAll(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    if (this.fileFilters != null) {
      for (int i = 0; i < this.fileFilters.size(); i++)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        Object localObject = this.fileFilters.get(i);
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = localObject.toString();
        }
        localStringBuilder.append((String)localObject);
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\OrFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */