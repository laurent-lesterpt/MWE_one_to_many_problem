package com.axelor.program;

import com.axelor.app.AxelorModule;
import com.axelor.program.service.HelloService;
import com.axelor.program.service.HelloServiceImpl;

public class ProgramModule extends AxelorModule{
    @Override
    protected void configure(){bind(HelloService.class).to(HelloServiceImpl.class);}
}
