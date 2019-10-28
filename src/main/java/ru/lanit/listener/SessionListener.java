package ru.lanit.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {
    private static Logger log = Logger.getLogger(SessionListener.class.getName());

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("SessionListener. Session was created. Session id: " + httpSessionEvent.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("SessionListener. Session was killed. Session id: " + httpSessionEvent.getSession().getId());
    }
}
