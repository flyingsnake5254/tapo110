package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CompositeFileComparator
  extends a
  implements Serializable
{
  private static final Comparator<?>[] NO_COMPARATORS = new Comparator[0];
  private static final long serialVersionUID = -2224170307287243428L;
  private final Comparator<File>[] delegates;
  
  public CompositeFileComparator(Iterable<Comparator<File>> paramIterable)
  {
    if (paramIterable == null)
    {
      this.delegates = NO_COMPARATORS;
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add((Comparator)paramIterable.next());
      }
      this.delegates = ((Comparator[])localArrayList.toArray(new Comparator[localArrayList.size()]));
    }
  }
  
  public CompositeFileComparator(Comparator<File>... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      this.delegates = NO_COMPARATORS;
    }
    else
    {
      Comparator[] arrayOfComparator = new Comparator[paramVarArgs.length];
      this.delegates = arrayOfComparator;
      System.arraycopy(paramVarArgs, 0, arrayOfComparator, 0, paramVarArgs.length);
    }
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    Comparator[] arrayOfComparator = this.delegates;
    int i = arrayOfComparator.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k = arrayOfComparator[j].compare(paramFile1, paramFile2);
      if (k != 0) {
        break;
      }
      j++;
    }
    return k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append('{');
    for (int i = 0; i < this.delegates.length; i++)
    {
      if (i > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(this.delegates[i]);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\CompositeFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */