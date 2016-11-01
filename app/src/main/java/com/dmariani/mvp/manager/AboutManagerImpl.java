package com.dmariani.mvp.manager;

/**
 * It implements AboutManager interface
 * 
 * @author danielle.mariani
 */

public class AboutManagerImpl implements AboutManager {

    @Override
    public String fetchProfile() {
        return "Hola Mundo!";
    }
}
