package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.a;

public final class ChannelMatchers
{
  private static final ChannelMatcher ALL_MATCHER = new ChannelMatcher()
  {
    public boolean matches(Channel paramAnonymousChannel)
    {
      return true;
    }
  };
  private static final ChannelMatcher NON_SERVER_CHANNEL_MATCHER = isNotInstanceOf(a.class);
  private static final ChannelMatcher SERVER_CHANNEL_MATCHER = isInstanceOf(a.class);
  
  public static ChannelMatcher all()
  {
    return ALL_MATCHER;
  }
  
  public static ChannelMatcher compose(ChannelMatcher... paramVarArgs)
  {
    if (paramVarArgs.length >= 1)
    {
      if (paramVarArgs.length == 1) {
        return paramVarArgs[0];
      }
      return new CompositeMatcher(paramVarArgs);
    }
    throw new IllegalArgumentException("matchers must at least contain one element");
  }
  
  public static ChannelMatcher invert(ChannelMatcher paramChannelMatcher)
  {
    return new InvertMatcher(paramChannelMatcher);
  }
  
  public static ChannelMatcher is(Channel paramChannel)
  {
    return new InstanceMatcher(paramChannel);
  }
  
  public static ChannelMatcher isInstanceOf(Class<? extends Channel> paramClass)
  {
    return new ClassMatcher(paramClass);
  }
  
  public static ChannelMatcher isNonServerChannel()
  {
    return NON_SERVER_CHANNEL_MATCHER;
  }
  
  public static ChannelMatcher isNot(Channel paramChannel)
  {
    return invert(is(paramChannel));
  }
  
  public static ChannelMatcher isNotInstanceOf(Class<? extends Channel> paramClass)
  {
    return invert(isInstanceOf(paramClass));
  }
  
  public static ChannelMatcher isServerChannel()
  {
    return SERVER_CHANNEL_MATCHER;
  }
  
  private static final class ClassMatcher
    implements ChannelMatcher
  {
    private final Class<? extends Channel> clazz;
    
    ClassMatcher(Class<? extends Channel> paramClass)
    {
      this.clazz = paramClass;
    }
    
    public boolean matches(Channel paramChannel)
    {
      return this.clazz.isInstance(paramChannel);
    }
  }
  
  private static final class CompositeMatcher
    implements ChannelMatcher
  {
    private final ChannelMatcher[] matchers;
    
    CompositeMatcher(ChannelMatcher... paramVarArgs)
    {
      this.matchers = paramVarArgs;
    }
    
    public boolean matches(Channel paramChannel)
    {
      ChannelMatcher[] arrayOfChannelMatcher = this.matchers;
      int i = arrayOfChannelMatcher.length;
      for (int j = 0; j < i; j++) {
        if (!arrayOfChannelMatcher[j].matches(paramChannel)) {
          return false;
        }
      }
      return true;
    }
  }
  
  private static final class InstanceMatcher
    implements ChannelMatcher
  {
    private final Channel channel;
    
    InstanceMatcher(Channel paramChannel)
    {
      this.channel = paramChannel;
    }
    
    public boolean matches(Channel paramChannel)
    {
      boolean bool;
      if (this.channel == paramChannel) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  private static final class InvertMatcher
    implements ChannelMatcher
  {
    private final ChannelMatcher matcher;
    
    InvertMatcher(ChannelMatcher paramChannelMatcher)
    {
      this.matcher = paramChannelMatcher;
    }
    
    public boolean matches(Channel paramChannel)
    {
      return this.matcher.matches(paramChannel) ^ true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\group\ChannelMatchers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */