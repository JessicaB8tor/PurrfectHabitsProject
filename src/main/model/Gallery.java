package model;

import java.util.ArrayList;
import java.util.List;

import static model.Award.AwardType.FELINE_GOOD;

// represents a gallery where the user can look at all their awards
public class Gallery {
    private List<Award> felineGoodAwards;
    private List<Award> pawsomeAchievementAwards;
    private List<Award> allAwards;
    private List<Award> bestStreakAwards;

    public Gallery() {
        felineGoodAwards = new ArrayList<Award>();
        pawsomeAchievementAwards = new ArrayList<Award>();
        allAwards = new ArrayList<Award>();
        bestStreakAwards = new ArrayList<Award>();
    }

    public List<Award> getFelineGoodAwards() {
        return felineGoodAwards;
    }

    public List<Award> getPawsomeAchievementAwards() {
        return pawsomeAchievementAwards;
    }

    public List<Award> getAllAwards() {
        return allAwards;
    }

    public List<Award> getBestStreakAwards() {
        return bestStreakAwards;
    }

    // TODO: handle the case where you add an award and it's now equal to your last streak
    public void addAward(Award award) {
        if (award.getAwardType() == FELINE_GOOD) {
            felineGoodAwards.add(award);
        } else {
            pawsomeAchievementAwards.add(award);
        }

        allAwards.add(award);
    }

    public void clearAwards() {
        felineGoodAwards.clear();
        pawsomeAchievementAwards.clear();
        allAwards.clear();
    }
}
