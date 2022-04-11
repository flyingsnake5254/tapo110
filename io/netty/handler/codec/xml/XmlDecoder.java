package io.netty.handler.codec.xml;

import com.fasterxml.aalto.AsyncByteArrayFeeder;
import com.fasterxml.aalto.AsyncXMLInputFactory;
import com.fasterxml.aalto.AsyncXMLStreamReader;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

public class XmlDecoder
  extends ByteToMessageDecoder
{
  private static final XmlDocumentEnd XML_DOCUMENT_END = XmlDocumentEnd.INSTANCE;
  private static final AsyncXMLInputFactory XML_INPUT_FACTORY = new InputFactoryImpl();
  private final AsyncByteArrayFeeder streamFeeder;
  private final AsyncXMLStreamReader<AsyncByteArrayFeeder> streamReader;
  
  public XmlDecoder()
  {
    AsyncXMLStreamReader localAsyncXMLStreamReader = XML_INPUT_FACTORY.createAsyncForByteArray();
    this.streamReader = localAsyncXMLStreamReader;
    this.streamFeeder = ((AsyncByteArrayFeeder)localAsyncXMLStreamReader.getInputFeeder());
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    paramChannelHandlerContext = new byte[i];
    paramByteBuf.readBytes(paramChannelHandlerContext);
    try
    {
      this.streamFeeder.feedInput(paramChannelHandlerContext, 0, i);
      while (!this.streamFeeder.needMoreInput()) {
        switch (this.streamReader.next())
        {
        case 10: 
        default: 
          break;
        case 12: 
          paramList.add(new XmlCdata(this.streamReader.getText()));
          break;
        case 11: 
          paramList.add(new XmlDTD(this.streamReader.getText()));
          break;
        case 9: 
          paramList.add(new XmlEntityReference(this.streamReader.getLocalName(), this.streamReader.getText()));
          break;
        case 8: 
          paramList.add(XML_DOCUMENT_END);
          break;
        case 7: 
          paramList.add(new XmlDocumentStart(this.streamReader.getEncoding(), this.streamReader.getVersion(), this.streamReader.isStandalone(), this.streamReader.getCharacterEncodingScheme()));
          break;
        case 6: 
          paramList.add(new XmlSpace(this.streamReader.getText()));
          break;
        case 5: 
          paramList.add(new XmlComment(this.streamReader.getText()));
          break;
        case 4: 
          paramList.add(new XmlCharacters(this.streamReader.getText()));
          break;
        case 3: 
          paramList.add(new XmlProcessingInstruction(this.streamReader.getPIData(), this.streamReader.getPITarget()));
          break;
        case 2: 
          paramChannelHandlerContext = new XmlElementEnd(this.streamReader.getLocalName(), this.streamReader.getName().getNamespaceURI(), this.streamReader.getPrefix());
          for (i = 0; i < this.streamReader.getNamespaceCount(); i++)
          {
            paramByteBuf = new XmlNamespace(this.streamReader.getNamespacePrefix(i), this.streamReader.getNamespaceURI(i));
            paramChannelHandlerContext.namespaces().add(paramByteBuf);
          }
          paramList.add(paramChannelHandlerContext);
          break;
        case 1: 
          paramChannelHandlerContext = new XmlElementStart(this.streamReader.getLocalName(), this.streamReader.getName().getNamespaceURI(), this.streamReader.getPrefix());
          for (i = 0; i < this.streamReader.getAttributeCount(); i++)
          {
            paramByteBuf = new XmlAttribute(this.streamReader.getAttributeType(i), this.streamReader.getAttributeLocalName(i), this.streamReader.getAttributePrefix(i), this.streamReader.getAttributeNamespace(i), this.streamReader.getAttributeValue(i));
            paramChannelHandlerContext.attributes().add(paramByteBuf);
          }
          for (i = 0; i < this.streamReader.getNamespaceCount(); i++)
          {
            paramByteBuf = new XmlNamespace(this.streamReader.getNamespacePrefix(i), this.streamReader.getNamespaceURI(i));
            paramChannelHandlerContext.namespaces().add(paramByteBuf);
          }
          paramList.add(paramChannelHandlerContext);
        }
      }
      return;
    }
    catch (XMLStreamException paramChannelHandlerContext)
    {
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
      throw paramChannelHandlerContext;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */