package calculator.service;

public class SeparationService {

    private static SeparationService instance;

    private SeparationService() {
    }

    public static SeparationService getInstance() {
        if (instance == null) {
            return new SeparationService();
        }
        return instance;
    }

    public void separate(String inputStr) {
        
    }
}
