package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@Deprecated
public class DefaultCookie
  extends io.netty.handler.codec.http.cookie.DefaultCookie
  implements Cookie
{
  private String comment;
  private String commentUrl;
  private boolean discard;
  private Set<Integer> ports;
  private Set<Integer> unmodifiablePorts;
  private int version;
  
  public DefaultCookie(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    paramString1 = Collections.emptySet();
    this.ports = paramString1;
    this.unmodifiablePorts = paramString1;
  }
  
  @Deprecated
  public String comment()
  {
    return this.comment;
  }
  
  @Deprecated
  public String commentUrl()
  {
    return this.commentUrl;
  }
  
  @Deprecated
  public String getComment()
  {
    return comment();
  }
  
  @Deprecated
  public String getCommentUrl()
  {
    return commentUrl();
  }
  
  @Deprecated
  public String getDomain()
  {
    return domain();
  }
  
  @Deprecated
  public long getMaxAge()
  {
    return maxAge();
  }
  
  @Deprecated
  public String getName()
  {
    return name();
  }
  
  @Deprecated
  public String getPath()
  {
    return path();
  }
  
  @Deprecated
  public Set<Integer> getPorts()
  {
    return ports();
  }
  
  @Deprecated
  public String getValue()
  {
    return value();
  }
  
  @Deprecated
  public int getVersion()
  {
    return version();
  }
  
  @Deprecated
  public boolean isDiscard()
  {
    return this.discard;
  }
  
  @Deprecated
  public Set<Integer> ports()
  {
    if (this.unmodifiablePorts == null) {
      this.unmodifiablePorts = Collections.unmodifiableSet(this.ports);
    }
    return this.unmodifiablePorts;
  }
  
  @Deprecated
  public void setComment(String paramString)
  {
    this.comment = validateValue("comment", paramString);
  }
  
  @Deprecated
  public void setCommentUrl(String paramString)
  {
    this.commentUrl = validateValue("commentUrl", paramString);
  }
  
  @Deprecated
  public void setDiscard(boolean paramBoolean)
  {
    this.discard = paramBoolean;
  }
  
  @Deprecated
  public void setPorts(Iterable<Integer> paramIterable)
  {
    TreeSet localTreeSet = new TreeSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      int i = ((Integer)paramIterable.next()).intValue();
      if ((i > 0) && (i <= 65535))
      {
        localTreeSet.add(Integer.valueOf(i));
      }
      else
      {
        paramIterable = new StringBuilder();
        paramIterable.append("port out of range: ");
        paramIterable.append(i);
        throw new IllegalArgumentException(paramIterable.toString());
      }
    }
    if (localTreeSet.isEmpty())
    {
      paramIterable = Collections.emptySet();
      this.ports = paramIterable;
      this.unmodifiablePorts = paramIterable;
    }
    else
    {
      this.ports = localTreeSet;
      this.unmodifiablePorts = null;
    }
  }
  
  @Deprecated
  public void setPorts(int... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "ports");
    int[] arrayOfInt = (int[])paramVarArgs.clone();
    if (arrayOfInt.length == 0)
    {
      paramVarArgs = Collections.emptySet();
      this.ports = paramVarArgs;
      this.unmodifiablePorts = paramVarArgs;
    }
    else
    {
      paramVarArgs = new TreeSet();
      int i = arrayOfInt.length;
      int j = 0;
      while (j < i)
      {
        int k = arrayOfInt[j];
        if ((k > 0) && (k <= 65535))
        {
          paramVarArgs.add(Integer.valueOf(k));
          j++;
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("port out of range: ");
          paramVarArgs.append(k);
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
      this.ports = paramVarArgs;
      this.unmodifiablePorts = null;
    }
  }
  
  @Deprecated
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  @Deprecated
  public int version()
  {
    return this.version;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */