package service.audit;

import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//import org.springframework.security.web.authentication.WebAuthenticationDetails;

@Component
public class AuditEventHandler {

//    private WebAuthenticationDetails webAuthenticationDetails;

    @EventListener
    public void auditEventHappened(AuditApplicationEvent auditApplicationEvent) {
         
//        AuditEvent auditEvent = auditApplicationEvent.getAuditEvent();
//        System.out.println("Principal " + auditEvent.getPrincipal() + " - " + auditEvent.getType());
 
//        WebAuthenticationDetails details = (WebAuthenticationDetails) auditEvent.getData().get("details");
//        System.out.println("Remote IP address: " + details.getRemoteAddress());
//        System.out.println("  Session Id: " + details.getSessionId());
//
//        webAuthenticationDetails = details;
    }

//    public WebAuthenticationDetails getWebAuthenticationDetails() {
//        return webAuthenticationDetails;
//    }

//    public void setWebAuthenticationDetails(WebAuthenticationDetails webAuthenticationDetails) {
//        this.webAuthenticationDetails = webAuthenticationDetails;
//    }

}