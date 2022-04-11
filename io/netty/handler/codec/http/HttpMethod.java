package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;

public class HttpMethod
  implements Comparable<HttpMethod>
{
  public static final HttpMethod CONNECT;
  public static final HttpMethod DELETE;
  public static final HttpMethod GET;
  public static final HttpMethod HEAD;
  public static final HttpMethod OPTIONS;
  public static final HttpMethod PATCH;
  public static final HttpMethod POST;
  public static final HttpMethod PUT;
  public static final HttpMethod TRACE;
  private static final EnumNameMap<HttpMethod> methodMap;
  private final AsciiString name;
  
  static
  {
    HttpMethod localHttpMethod1 = new HttpMethod("OPTIONS");
    OPTIONS = localHttpMethod1;
    HttpMethod localHttpMethod2 = new HttpMethod("GET");
    GET = localHttpMethod2;
    HttpMethod localHttpMethod3 = new HttpMethod("HEAD");
    HEAD = localHttpMethod3;
    HttpMethod localHttpMethod4 = new HttpMethod("POST");
    POST = localHttpMethod4;
    HttpMethod localHttpMethod5 = new HttpMethod("PUT");
    PUT = localHttpMethod5;
    HttpMethod localHttpMethod6 = new HttpMethod("PATCH");
    PATCH = localHttpMethod6;
    HttpMethod localHttpMethod7 = new HttpMethod("DELETE");
    DELETE = localHttpMethod7;
    HttpMethod localHttpMethod8 = new HttpMethod("TRACE");
    TRACE = localHttpMethod8;
    HttpMethod localHttpMethod9 = new HttpMethod("CONNECT");
    CONNECT = localHttpMethod9;
    methodMap = new EnumNameMap(new HttpMethod.EnumNameMap.Node[] { new HttpMethod.EnumNameMap.Node(localHttpMethod1.toString(), localHttpMethod1), new HttpMethod.EnumNameMap.Node(localHttpMethod2.toString(), localHttpMethod2), new HttpMethod.EnumNameMap.Node(localHttpMethod3.toString(), localHttpMethod3), new HttpMethod.EnumNameMap.Node(localHttpMethod4.toString(), localHttpMethod4), new HttpMethod.EnumNameMap.Node(localHttpMethod5.toString(), localHttpMethod5), new HttpMethod.EnumNameMap.Node(localHttpMethod6.toString(), localHttpMethod6), new HttpMethod.EnumNameMap.Node(localHttpMethod7.toString(), localHttpMethod7), new HttpMethod.EnumNameMap.Node(localHttpMethod8.toString(), localHttpMethod8), new HttpMethod.EnumNameMap.Node(localHttpMethod9.toString(), localHttpMethod9) });
  }
  
  public HttpMethod(String paramString)
  {
    paramString = ((String)ObjectUtil.checkNotNull(paramString, "name")).trim();
    if (!paramString.isEmpty())
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!Character.isISOControl(c)) && (!Character.isWhitespace(c))) {
          i++;
        } else {
          throw new IllegalArgumentException("invalid character in name");
        }
      }
      this.name = AsciiString.cached(paramString);
      return;
    }
    throw new IllegalArgumentException("empty name");
  }
  
  public static HttpMethod valueOf(String paramString)
  {
    HttpMethod localHttpMethod = (HttpMethod)methodMap.get(paramString);
    if (localHttpMethod != null) {
      paramString = localHttpMethod;
    } else {
      paramString = new HttpMethod(paramString);
    }
    return paramString;
  }
  
  public AsciiString asciiName()
  {
    return this.name;
  }
  
  public int compareTo(HttpMethod paramHttpMethod)
  {
    if (paramHttpMethod == this) {
      return 0;
    }
    return name().compareTo(paramHttpMethod.name());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof HttpMethod)) {
      return false;
    }
    paramObject = (HttpMethod)paramObject;
    return name().equals(((HttpMethod)paramObject).name());
  }
  
  public int hashCode()
  {
    return name().hashCode();
  }
  
  public String name()
  {
    return this.name.toString();
  }
  
  public String toString()
  {
    return this.name.toString();
  }
  
  private static final class EnumNameMap<T>
  {
    private final Node<T>[] values;
    private final int valuesMask;
    
    EnumNameMap(Node<T>... paramVarArgs)
    {
      Object localObject = new Node[MathUtil.findNextPositivePowerOfTwo(paramVarArgs.length)];
      this.values = ((Node[])localObject);
      this.valuesMask = (localObject.length - 1);
      int i = paramVarArgs.length;
      int j = 0;
      while (j < i)
      {
        localObject = paramVarArgs[j];
        int k = hashCode(((Node)localObject).key) & this.valuesMask;
        Node[] arrayOfNode = this.values;
        if (arrayOfNode[k] == null)
        {
          arrayOfNode[k] = localObject;
          j++;
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("index ");
          paramVarArgs.append(k);
          paramVarArgs.append(" collision between values: [");
          paramVarArgs.append(this.values[k].key);
          paramVarArgs.append(", ");
          paramVarArgs.append(((Node)localObject).key);
          paramVarArgs.append(']');
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
    }
    
    private static int hashCode(String paramString)
    {
      return paramString.hashCode() >>> 6;
    }
    
    T get(String paramString)
    {
      Node localNode = this.values[(hashCode(paramString) & this.valuesMask)];
      if ((localNode != null) && (localNode.key.equals(paramString))) {
        paramString = localNode.value;
      } else {
        paramString = null;
      }
      return paramString;
    }
    
    private static final class Node<T>
    {
      final String key;
      final T value;
      
      Node(String paramString, T paramT)
      {
        this.key = paramString;
        this.value = paramT;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */