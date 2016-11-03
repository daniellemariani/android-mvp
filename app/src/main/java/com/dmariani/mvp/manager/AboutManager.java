package com.dmariani.mvp.manager;

import java.io.IOException;

/**
 * It defines operations to manage About data
 *
 * @author danielle.mariani
 */

public interface AboutManager {

    /**
     * It makes a request to get my Own GitHub Profile
     * @return
     */
    String fetchProfile() throws IOException;
}
