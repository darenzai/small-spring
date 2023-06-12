package com.darenzai.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * description: Resource
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/12 8:32
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
