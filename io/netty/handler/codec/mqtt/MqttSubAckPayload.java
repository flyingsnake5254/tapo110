package io.netty.handler.codec.mqtt;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MqttSubAckPayload
{
  private final List<Integer> grantedQoSLevels;
  
  public MqttSubAckPayload(Iterable<Integer> paramIterable)
  {
    ObjectUtil.checkNotNull(paramIterable, "grantedQoSLevels");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (Integer)localIterator.next();
      if (paramIterable == null) {
        break;
      }
      localArrayList.add(paramIterable);
    }
    this.grantedQoSLevels = Collections.unmodifiableList(localArrayList);
  }
  
  public MqttSubAckPayload(int... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "grantedQoSLevels");
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(Integer.valueOf(paramVarArgs[j]));
    }
    this.grantedQoSLevels = Collections.unmodifiableList(localArrayList);
  }
  
  public List<Integer> grantedQoSLevels()
  {
    return this.grantedQoSLevels;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("grantedQoSLevels=");
    localStringBuilder.append(this.grantedQoSLevels);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttSubAckPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */