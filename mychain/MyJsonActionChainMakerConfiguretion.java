package com.osdiot.gas.material.web.commons.base;

import org.nutz.mvc.impl.chainconfig.JsonActionChainMakerConfiguretion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyJsonActionChainMakerConfiguretion extends JsonActionChainMakerConfiguretion {

    public MyJsonActionChainMakerConfiguretion(String... jsonPaths) {
        super(jsonPaths);
    }

    @Override
    public List<String> getProcessors(String key){
        Map<String,Object> config = map.get(key);
        if(config != null && config.containsKey("ps"))
            return (List<String>) config.get("ps");
        List<String> processors=new LinkedList<>();
        Iterator<Map.Entry<String, Map<String, Object>>> iterator =
                map.entrySet().iterator();
        while (iterator.hasNext()){
            Object ps = iterator.next().getValue().get("ps");
            processors.addAll((List<String>)ps);
        }
        return processors;
    }
}
