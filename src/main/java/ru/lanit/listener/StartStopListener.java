package ru.lanit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class StartStopListener implements ServletContextListener {
    private static Logger log = Logger.getLogger(StartStopListener.class.getName());

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("StartStopListener. Application was started!");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("StartStopListener. Application was stopped!");
    }
}
