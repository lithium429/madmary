package com.osdiot.gas.material.web.commons.base;

import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionChain;
import org.nutz.mvc.ActionInfo;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Processor;
import org.nutz.mvc.impl.NutActionChain;
import org.nutz.mvc.impl.NutActionChainMaker;
import org.nutz.mvc.impl.chainconfig.ActionChainMakerConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MyActionChainMaker extends NutActionChainMaker {

    private static final Log log = Logs.get();

    ActionChainMakerConfiguration co;

    public MyActionChainMaker(String... args) {
        co=new MyJsonActionChainMakerConfiguretion(args);
    }

    @Override
    public ActionChain eval(NutConfig config, ActionInfo ai){
        try {
            List<Processor> list = new ArrayList<Processor>();
            for (String name : co.getProcessors(ai.getChainName())) {
                Processor processor = getProcessorByName(config, name);
                if (processor != null) {
                    processor.init(config, ai);
                    list.add(processor);
                }
            }

            Processor errorProcessor = getProcessorByName(config, co.getErrorProcessor(ai.getChainName()));
            errorProcessor.init(config, ai);
            /*
             * 返回动作链实例
             */
            return new NutActionChain(list, errorProcessor, ai);
        } catch (Throwable e) {
            if (log.isDebugEnabled())
                log.debugf("Eval FAIL!! : %s",ai.getMethod(), e);
            throw Lang.wrapThrow(e);
        }
    }

}
