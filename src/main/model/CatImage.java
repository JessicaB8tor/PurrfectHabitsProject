package model;

import java.awt.*;

public class CatImage {
    Image catImage;

    public CatImage(Award.AwardType awardType) {
        catImage = getCatImageFromAPI(awardType);
    }

    // TODO: change return type back to Image
    private void getCatImageFromAPI(Award.AwardType awardType) {
        String url;
        if (awardType == Award.AwardType.FELINE_GOOD) {

        }


    }
}
