package com.darenzai.springframework.core.io;

/**
 * <p>
 * description: ResourceLoader
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/12 8:32
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}

