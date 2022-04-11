package org.apache.commons.io;

import java.io.IOException;
import java.io.Serializable;

public class TaggedIOException
  extends IOExceptionWithCause
{
  private static final long serialVersionUID = -6994123481142850163L;
  private final Serializable tag;
  
  public TaggedIOException(IOException paramIOException, Serializable paramSerializable)
  {
    super(paramIOException.getMessage(), paramIOException);
    this.tag = paramSerializable;
  }
  
  public static boolean isTaggedWith(Throwable paramThrowable, Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && ((paramThrowable instanceof TaggedIOException)) && (paramObject.equals(((TaggedIOException)paramThrowable).tag))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void throwCauseIfTaggedWith(Throwable paramThrowable, Object paramObject)
    throws IOException
  {
    if (!isTaggedWith(paramThrowable, paramObject)) {
      return;
    }
    throw ((TaggedIOException)paramThrowable).getCause();
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
  
  public Serializable getTag()
  {
    return this.tag;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\TaggedIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */