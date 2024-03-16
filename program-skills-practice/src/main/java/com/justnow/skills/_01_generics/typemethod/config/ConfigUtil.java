package com.justnow.skills._01_generics.typemethod.config;

public class ConfigUtil {

    private static XmlConfigService configService;

    /**
     * 泛型方法
     * @param id
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends RemoteConfigService> T getConfig(int id, Class<T> t) {

        try {
            T tt = t.newInstance();
            T config = configService.getConfigByTypeId(id, t);
            return config;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }

}
