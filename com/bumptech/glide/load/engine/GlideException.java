package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GlideException
  extends Exception
{
  private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
  private static final long serialVersionUID = 1L;
  private final List<Throwable> causes;
  private Class<?> dataClass;
  private DataSource dataSource;
  private String detailMessage;
  @Nullable
  private Exception exception;
  private c key;
  
  public GlideException(String paramString)
  {
    this(paramString, Collections.emptyList());
  }
  
  public GlideException(String paramString, Throwable paramThrowable)
  {
    this(paramString, Collections.singletonList(paramThrowable));
  }
  
  public GlideException(String paramString, List<Throwable> paramList)
  {
    this.detailMessage = paramString;
    setStackTrace(EMPTY_ELEMENTS);
    this.causes = paramList;
  }
  
  private void addRootCauses(Throwable paramThrowable, List<Throwable> paramList)
  {
    if ((paramThrowable instanceof GlideException))
    {
      paramThrowable = ((GlideException)paramThrowable).getCauses().iterator();
      while (paramThrowable.hasNext()) {
        addRootCauses((Throwable)paramThrowable.next(), paramList);
      }
    }
    paramList.add(paramThrowable);
  }
  
  private static void appendCauses(List<Throwable> paramList, Appendable paramAppendable)
  {
    try
    {
      appendCausesWrapped(paramList, paramAppendable);
      return;
    }
    catch (IOException paramList)
    {
      throw new RuntimeException(paramList);
    }
  }
  
  private static void appendCausesWrapped(List<Throwable> paramList, Appendable paramAppendable)
    throws IOException
  {
    int i = paramList.size();
    int k;
    for (int j = 0; j < i; j = k)
    {
      Object localObject = paramAppendable.append("Cause (");
      k = j + 1;
      ((Appendable)localObject).append(String.valueOf(k)).append(" of ").append(String.valueOf(i)).append("): ");
      localObject = (Throwable)paramList.get(j);
      if ((localObject instanceof GlideException)) {
        ((GlideException)localObject).printStackTrace(paramAppendable);
      } else {
        appendExceptionMessage((Throwable)localObject, paramAppendable);
      }
    }
  }
  
  private static void appendExceptionMessage(Throwable paramThrowable, Appendable paramAppendable)
  {
    try
    {
      paramAppendable.append(paramThrowable.getClass().toString()).append(": ").append(paramThrowable.getMessage()).append('\n');
      return;
    }
    catch (IOException paramAppendable)
    {
      throw new RuntimeException(paramThrowable);
    }
  }
  
  private void printStackTrace(Appendable paramAppendable)
  {
    appendExceptionMessage(this, paramAppendable);
    appendCauses(getCauses(), new a(paramAppendable));
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
  
  public List<Throwable> getCauses()
  {
    return this.causes;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder(71);
    localStringBuilder.append(this.detailMessage);
    Object localObject1 = this.dataClass;
    Object localObject2 = "";
    if (localObject1 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.dataClass);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    if (this.dataSource != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.dataSource);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localObject2;
    if (this.key != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.key);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = getRootCauses();
    if (((List)localObject1).isEmpty()) {
      return localStringBuilder.toString();
    }
    if (((List)localObject1).size() == 1)
    {
      localStringBuilder.append("\nThere was 1 root cause:");
    }
    else
    {
      localStringBuilder.append("\nThere were ");
      localStringBuilder.append(((List)localObject1).size());
      localStringBuilder.append(" root causes:");
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Throwable)((Iterator)localObject1).next();
      localStringBuilder.append('\n');
      localStringBuilder.append(localObject2.getClass().getName());
      localStringBuilder.append('(');
      localStringBuilder.append(((Throwable)localObject2).getMessage());
      localStringBuilder.append(')');
    }
    localStringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Exception getOrigin()
  {
    return this.exception;
  }
  
  public List<Throwable> getRootCauses()
  {
    ArrayList localArrayList = new ArrayList();
    addRootCauses(this, localArrayList);
    return localArrayList;
  }
  
  public void logRootCauses(String paramString)
  {
    List localList = getRootCauses();
    int i = localList.size();
    int k;
    for (int j = 0; j < i; j = k)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Root cause (");
      k = j + 1;
      localStringBuilder.append(k);
      localStringBuilder.append(" of ");
      localStringBuilder.append(i);
      localStringBuilder.append(")");
      Log.i(paramString, localStringBuilder.toString(), (Throwable)localList.get(j));
    }
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    printStackTrace(paramPrintStream);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    printStackTrace(paramPrintWriter);
  }
  
  void setLoggingDetails(c paramc, DataSource paramDataSource)
  {
    setLoggingDetails(paramc, paramDataSource, null);
  }
  
  void setLoggingDetails(c paramc, DataSource paramDataSource, Class<?> paramClass)
  {
    this.key = paramc;
    this.dataSource = paramDataSource;
    this.dataClass = paramClass;
  }
  
  public void setOrigin(@Nullable Exception paramException)
  {
    this.exception = paramException;
  }
  
  private static final class a
    implements Appendable
  {
    private final Appendable c;
    private boolean d = true;
    
    a(Appendable paramAppendable)
    {
      this.c = paramAppendable;
    }
    
    @NonNull
    private CharSequence a(@Nullable CharSequence paramCharSequence)
    {
      Object localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      return (CharSequence)localObject;
    }
    
    public Appendable append(char paramChar)
      throws IOException
    {
      boolean bool1 = this.d;
      boolean bool2 = false;
      if (bool1)
      {
        this.d = false;
        this.c.append("  ");
      }
      if (paramChar == '\n') {
        bool2 = true;
      }
      this.d = bool2;
      this.c.append(paramChar);
      return this;
    }
    
    public Appendable append(@Nullable CharSequence paramCharSequence)
      throws IOException
    {
      paramCharSequence = a(paramCharSequence);
      return append(paramCharSequence, 0, paramCharSequence.length());
    }
    
    public Appendable append(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2)
      throws IOException
    {
      paramCharSequence = a(paramCharSequence);
      boolean bool1 = this.d;
      boolean bool2 = false;
      if (bool1)
      {
        this.d = false;
        this.c.append("  ");
      }
      bool1 = bool2;
      if (paramCharSequence.length() > 0)
      {
        bool1 = bool2;
        if (paramCharSequence.charAt(paramInt2 - 1) == '\n') {
          bool1 = true;
        }
      }
      this.d = bool1;
      this.c.append(paramCharSequence, paramInt1, paramInt2);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\GlideException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */