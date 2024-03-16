package com.justnow.skills._01_generics.typemethod.config;

public interface XmlConfigService {

    <T extends RemoteConfigService> T getConfigByTypeId(int configId, Class<T> t);
}
