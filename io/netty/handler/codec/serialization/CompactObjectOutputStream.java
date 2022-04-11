package io.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

class CompactObjectOutputStream
  extends ObjectOutputStream
{
  static final int TYPE_FAT_DESCRIPTOR = 0;
  static final int TYPE_THIN_DESCRIPTOR = 1;
  
  CompactObjectOutputStream(OutputStream paramOutputStream)
    throws IOException
  {
    super(paramOutputStream);
  }
  
  protected void writeClassDescriptor(ObjectStreamClass paramObjectStreamClass)
    throws IOException
  {
    Class localClass = paramObjectStreamClass.forClass();
    if ((!localClass.isPrimitive()) && (!localClass.isArray()) && (!localClass.isInterface()) && (paramObjectStreamClass.getSerialVersionUID() != 0L))
    {
      write(1);
      writeUTF(paramObjectStreamClass.getName());
    }
    else
    {
      write(0);
      super.writeClassDescriptor(paramObjectStreamClass);
    }
  }
  
  protected void writeStreamHeader()
    throws IOException
  {
    writeByte(5);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\CompactObjectOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */