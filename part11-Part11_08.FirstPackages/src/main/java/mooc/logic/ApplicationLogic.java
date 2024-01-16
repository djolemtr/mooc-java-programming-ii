    package mooc.logic;
    import mooc.ui.UserInterface;
    
    public class ApplicationLogic {
        private UserInterface UI;

        public ApplicationLogic(UserInterface UI){
            this.UI = UI;
        }

        public void execute(int times){
            for (int i = 0; times> i; i++){
                System.out.println("Application logic is working");
                this.UI.update();
            }
        }
    }
    