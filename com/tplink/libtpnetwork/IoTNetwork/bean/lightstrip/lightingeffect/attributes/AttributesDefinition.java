package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter.AttributeConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributesDefinition
{
  protected List<String> allAttributesNames = new ArrayList();
  protected Map<String, AttributeConverter<? extends Object>> attributesConverters = new HashMap();
  protected List<String> otherAttributesNames = new ArrayList();
  protected List<String> principalAttributesNames = new ArrayList();
  
  protected void addAttribute(String paramString, AttributeConverter<? extends Object> paramAttributeConverter)
  {
    addAttribute(paramString, paramAttributeConverter, true);
  }
  
  protected void addAttribute(String paramString, AttributeConverter<? extends Object> paramAttributeConverter, boolean paramBoolean)
  {
    this.allAttributesNames.add(paramString);
    this.attributesConverters.put(paramString, paramAttributeConverter);
    if (paramBoolean) {
      this.principalAttributesNames.add(paramString);
    } else {
      this.otherAttributesNames.add(paramString);
    }
  }
  
  public Object convert(String paramString, Object paramObject)
  {
    paramString = (AttributeConverter)this.attributesConverters.get(paramString);
    if ((paramString != null) && (paramObject != null)) {
      return paramString.convert(paramObject);
    }
    return paramObject;
  }
  
  public List<String> getAllAttributes()
  {
    return this.allAttributesNames;
  }
  
  public List<String> getOtherAttributes()
  {
    return this.otherAttributesNames;
  }
  
  public List<String> getPrincipalAttributes()
  {
    return this.principalAttributesNames;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\AttributesDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */