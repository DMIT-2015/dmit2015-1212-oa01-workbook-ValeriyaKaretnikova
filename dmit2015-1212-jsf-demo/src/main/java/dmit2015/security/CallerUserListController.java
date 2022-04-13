package dmit2015.security;

import dmit2015.security.CallerUser;
import dmit2015.security.CallerUserRepository;
import lombok.Getter;
import org.omnifaces.util.Messages;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("currentCallerUserListController")
@ViewScoped
public class CallerUserListController implements Serializable {

    @Inject
    private CallerUserRepository _calleruserRepository;

    @Getter
    private List<CallerUser> calleruserList;

    @PostConstruct  // After @Inject is complete
    public void init() {
        try {
            calleruserList = _calleruserRepository.list();
        } catch (Exception ex) {
            Messages.addGlobalError(ex.getMessage());
        }
    }
}