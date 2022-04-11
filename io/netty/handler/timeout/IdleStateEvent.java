package io.netty.handler.timeout;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class IdleStateEvent
{
  public static final IdleStateEvent ALL_IDLE_STATE_EVENT;
  public static final IdleStateEvent FIRST_ALL_IDLE_STATE_EVENT;
  public static final IdleStateEvent FIRST_READER_IDLE_STATE_EVENT;
  public static final IdleStateEvent FIRST_WRITER_IDLE_STATE_EVENT;
  public static final IdleStateEvent READER_IDLE_STATE_EVENT;
  public static final IdleStateEvent WRITER_IDLE_STATE_EVENT;
  private final boolean first;
  private final IdleState state;
  
  static
  {
    IdleState localIdleState = IdleState.READER_IDLE;
    FIRST_READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(localIdleState, true);
    READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(localIdleState, false);
    localIdleState = IdleState.WRITER_IDLE;
    FIRST_WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(localIdleState, true);
    WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(localIdleState, false);
    localIdleState = IdleState.ALL_IDLE;
    FIRST_ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(localIdleState, true);
    ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(localIdleState, false);
  }
  
  protected IdleStateEvent(IdleState paramIdleState, boolean paramBoolean)
  {
    this.state = ((IdleState)ObjectUtil.checkNotNull(paramIdleState, "state"));
    this.first = paramBoolean;
  }
  
  public boolean isFirst()
  {
    return this.first;
  }
  
  public IdleState state()
  {
    return this.state;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append(this.state);
    String str;
    if (this.first) {
      str = ", first";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  private static final class DefaultIdleStateEvent
    extends IdleStateEvent
  {
    private final String representation;
    
    DefaultIdleStateEvent(IdleState paramIdleState, boolean paramBoolean)
    {
      super(paramBoolean);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IdleStateEvent(");
      localStringBuilder.append(paramIdleState);
      if (paramBoolean) {
        paramIdleState = ", first";
      } else {
        paramIdleState = "";
      }
      localStringBuilder.append(paramIdleState);
      localStringBuilder.append(')');
      this.representation = localStringBuilder.toString();
    }
    
    public String toString()
    {
      return this.representation;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\IdleStateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */