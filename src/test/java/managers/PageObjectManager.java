package managers;

import lombok.AllArgsConstructor;
import lombok.Data;
import pages.*;

@Data
@AllArgsConstructor
public class PageObjectManager {

    private ModalWindowPage modalWindow;
    private AdvertPage advertPage;
    private CreateAdvertPage createAdvertPage;
    private HomePage homePage;
    private ProfilePage profilePage;

    public PageObjectManager(){
        this.advertPage = new AdvertPage();
        this.homePage = new HomePage();
        this.createAdvertPage = new CreateAdvertPage();
        this.modalWindow = new ModalWindowPage();
        this.profilePage = new ProfilePage();
    }

}
