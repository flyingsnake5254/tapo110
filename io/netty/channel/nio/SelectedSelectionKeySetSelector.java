package io.netty.channel.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

final class SelectedSelectionKeySetSelector
  extends Selector
{
  private final Selector delegate;
  private final SelectedSelectionKeySet selectionKeys;
  
  SelectedSelectionKeySetSelector(Selector paramSelector, SelectedSelectionKeySet paramSelectedSelectionKeySet)
  {
    this.delegate = paramSelector;
    this.selectionKeys = paramSelectedSelectionKeySet;
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public boolean isOpen()
  {
    return this.delegate.isOpen();
  }
  
  public Set<SelectionKey> keys()
  {
    return this.delegate.keys();
  }
  
  public SelectorProvider provider()
  {
    return this.delegate.provider();
  }
  
  public int select()
    throws IOException
  {
    this.selectionKeys.reset();
    return this.delegate.select();
  }
  
  public int select(long paramLong)
    throws IOException
  {
    this.selectionKeys.reset();
    return this.delegate.select(paramLong);
  }
  
  public int selectNow()
    throws IOException
  {
    this.selectionKeys.reset();
    return this.delegate.selectNow();
  }
  
  public Set<SelectionKey> selectedKeys()
  {
    return this.delegate.selectedKeys();
  }
  
  public Selector wakeup()
  {
    return this.delegate.wakeup();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\SelectedSelectionKeySetSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */