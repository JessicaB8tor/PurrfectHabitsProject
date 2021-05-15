package model;

import javafx.scene.image.Image;
import java.time.LocalDate;

public class Award {
    public enum AwardType {
        FELINE_GOOD, PAWSOME_ACHIEVEMENT
    }

    String awardTitle;
    Image awardImage;
    LocalDate dateReceived;
    AwardType awardType;

    public Award(String awardTitle, Image awardImage, LocalDate dateReceived, AwardType awardType) {
        this.awardTitle = awardTitle;
        this.awardImage = awardImage;
        this.dateReceived = dateReceived;
        this.awardType = awardType;
    }

    public String getAwardTitle() {
        return awardTitle;
    }

    public Image getAwardImage() {
        return awardImage;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public AwardType getAwardType() {
        return awardType;
    }
}

