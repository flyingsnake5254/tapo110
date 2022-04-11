package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NestableDelegate
  implements Serializable
{
  private static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
  public static boolean matchSubclasses = true;
  private static final long serialVersionUID = 1L;
  public static boolean topDown = true;
  public static boolean trimStackFrames = true;
  private Throwable nestable = null;
  
  public NestableDelegate(b paramb)
  {
    if ((paramb instanceof Throwable))
    {
      this.nestable = ((Throwable)paramb);
      return;
    }
    throw new IllegalArgumentException("The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable");
  }
  
  public String getMessage(int paramInt)
  {
    Throwable localThrowable = getThrowable(paramInt);
    Class localClass1 = class$org$apache$commons$lang$exception$Nestable;
    Class localClass2 = localClass1;
    if (localClass1 == null)
    {
      localClass2 = class$("org.apache.commons.lang.exception.Nestable");
      class$org$apache$commons$lang$exception$Nestable = localClass2;
    }
    if (localClass2.isInstance(localThrowable)) {
      return ((b)localThrowable).getMessage(0);
    }
    return localThrowable.getMessage();
  }
  
  public String getMessage(String paramString)
  {
    Throwable localThrowable = a.b(this.nestable);
    String str;
    if (localThrowable == null) {
      str = null;
    } else {
      str = localThrowable.getMessage();
    }
    Object localObject = paramString;
    if (localThrowable != null) {
      if (str == null)
      {
        localObject = paramString;
      }
      else
      {
        if (paramString == null) {
          return str;
        }
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append(paramString);
        ((StringBuffer)localObject).append(": ");
        ((StringBuffer)localObject).append(str);
        localObject = ((StringBuffer)localObject).toString();
      }
    }
    return (String)localObject;
  }
  
  public String[] getMessages()
  {
    Throwable[] arrayOfThrowable = getThrowables();
    String[] arrayOfString = new String[arrayOfThrowable.length];
    for (int i = 0; i < arrayOfThrowable.length; i++)
    {
      Class localClass = class$org$apache$commons$lang$exception$Nestable;
      Object localObject = localClass;
      if (localClass == null)
      {
        localObject = class$("org.apache.commons.lang.exception.Nestable");
        class$org$apache$commons$lang$exception$Nestable = (Class)localObject;
      }
      if (((Class)localObject).isInstance(arrayOfThrowable[i])) {
        localObject = ((b)arrayOfThrowable[i]).getMessage(0);
      } else {
        localObject = arrayOfThrowable[i].getMessage();
      }
      arrayOfString[i] = localObject;
    }
    return arrayOfString;
  }
  
  protected String[] getStackFrames(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    if ((paramThrowable instanceof b)) {
      ((b)paramThrowable).printPartialStackTrace(localPrintWriter);
    } else {
      paramThrowable.printStackTrace(localPrintWriter);
    }
    return a.g(localStringWriter.getBuffer().toString());
  }
  
  public Throwable getThrowable(int paramInt)
  {
    if (paramInt == 0) {
      return this.nestable;
    }
    return getThrowables()[paramInt];
  }
  
  public int getThrowableCount()
  {
    return a.h(this.nestable);
  }
  
  public Throwable[] getThrowables()
  {
    return a.j(this.nestable);
  }
  
  public int indexOfThrowable(Class paramClass, int paramInt)
  {
    if (paramClass == null) {
      return -1;
    }
    if (paramInt >= 0)
    {
      Throwable[] arrayOfThrowable = a.j(this.nestable);
      if (paramInt < arrayOfThrowable.length)
      {
        int i = paramInt;
        if (matchSubclasses) {
          while (paramInt < arrayOfThrowable.length)
          {
            if (paramClass.isAssignableFrom(arrayOfThrowable[paramInt].getClass())) {
              return paramInt;
            }
            paramInt++;
          }
        }
        while (i < arrayOfThrowable.length)
        {
          if (paramClass.equals(arrayOfThrowable[i].getClass())) {
            return i;
          }
          i++;
        }
        return -1;
      }
      paramClass = new StringBuffer();
      paramClass.append("The start index was out of bounds: ");
      paramClass.append(paramInt);
      paramClass.append(" >= ");
      paramClass.append(arrayOfThrowable.length);
      throw new IndexOutOfBoundsException(paramClass.toString());
    }
    paramClass = new StringBuffer();
    paramClass.append("The start index was out of bounds: ");
    paramClass.append(paramInt);
    throw new IndexOutOfBoundsException(paramClass.toString());
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    try
    {
      PrintWriter localPrintWriter = new java/io/PrintWriter;
      localPrintWriter.<init>(paramPrintStream, false);
      printStackTrace(localPrintWriter);
      localPrintWriter.flush();
      return;
    }
    finally {}
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    Object localObject1 = this.nestable;
    if (a.k())
    {
      if ((localObject1 instanceof b)) {
        ((b)localObject1).printPartialStackTrace(paramPrintWriter);
      } else {
        ((Throwable)localObject1).printStackTrace(paramPrintWriter);
      }
      return;
    }
    Object localObject3 = new ArrayList();
    while (localObject1 != null)
    {
      ((List)localObject3).add(getStackFrames((Throwable)localObject1));
      localObject1 = a.b((Throwable)localObject1);
    }
    localObject1 = "Caused by: ";
    if (!topDown)
    {
      localObject1 = "Rethrown as: ";
      Collections.reverse((List)localObject3);
    }
    if (trimStackFrames) {
      trimStackFrames((List)localObject3);
    }
    try
    {
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (String[])localIterator.next();
        int i = 0;
        int j = localObject3.length;
        while (i < j)
        {
          paramPrintWriter.println(localObject3[i]);
          i++;
        }
        if (localIterator.hasNext()) {
          paramPrintWriter.print((String)localObject1);
        }
      }
      return;
    }
    finally {}
  }
  
  protected void trimStackFrames(List paramList)
  {
    for (int i = paramList.size() - 1; i > 0; i--)
    {
      Object localObject = (String[])paramList.get(i);
      String[] arrayOfString = (String[])paramList.get(i - 1);
      ArrayList localArrayList = new ArrayList(Arrays.asList((Object[])localObject));
      a.l(localArrayList, new ArrayList(Arrays.asList(arrayOfString)));
      int j = localObject.length - localArrayList.size();
      if (j > 0)
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("\t... ");
        ((StringBuffer)localObject).append(j);
        ((StringBuffer)localObject).append(" more");
        localArrayList.add(((StringBuffer)localObject).toString());
        paramList.set(i, localArrayList.toArray(new String[localArrayList.size()]));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\exception\NestableDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */