package com.solace.spring_scope.spring.scope.service.impl;

import com.solace.spring_scope.spring.scope.service.AdminService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminServiceImpl implements AdminService {
    @Override
    public String codeTest() {
        return "你好";
    }
}
