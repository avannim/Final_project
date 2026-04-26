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
    private ProfilePage profilePage;
    private HomePage homePage;

    public PageObjectManager(){
        this.advertPage = new AdvertPage();
        this.homePage = new HomePage();
        this.createAdvertPage = new CreateAdvertPage();
        this.profilePage = new ProfilePage();
        this.modalWindow = new ModalWindowPage();
    }

}
