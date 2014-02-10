package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoreBoard {

    public List<ScoreData> scores = new ArrayList<ScoreData>();

    public ScoreBoard() {
        makeUpScores();
        System.err.println(displayScore());
    }

    private void makeUpScores() {
        addScore("Tiffany", 800);
        addScore("Taeyeon", 1000);
        addScore("Diago", 5000);
        addScore("KidLeader", 3000);
        addScore("lowbie",30);
        addScore("skwex",22);
    }

    public Boolean addScore(String name, int score) {

        if (scores.size() == 1) {
            if (score > scores.get(0).score) {
                scores.add(scores.get(0));
                scores.set(0, new ScoreData(name, score));
            } else {
                scores.add(new ScoreData(name, score));
            }
            return true;
        }

        if (scores.isEmpty()) {                                     //If empty just add to start
            scores.add(new ScoreData(name, score));
            return true;
        }


        int i = scores.size() - 1;                                    //index set to size of array -1

        if (score <= (scores.get(i).score)) {
            if (scores.size()>4){
                return false;
            }else{
                scores.add(new ScoreData(name, score));
                return true;
            }
        } else {



            while (i > 0 && score > (scores.get(i).score)) {                         //while the score is greater than the score at the index
                i--;
            }
            if(score>=(scores.get(i).score))
            {
                scores.add(i,new ScoreData(name,score));
            }
            else{
                scores.add(i+1,new ScoreData(name,score));
            }
        }
        if (scores.size()>5)
        {
            scores.remove(scores.size()-1);
        }
        return true;
    }





    public String displayScore() {
        String results = "";
        int position = 1;
        for (ScoreData score : scores) {
            results += "[" + position + "] " + score;
            position++;
        }
        return results;
    }

    public float showScore(int i) {
        return scores.get(i).showMeYourScore();
    }


    private class ScoreData {
        String name;
        int score;

        ScoreData(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public float showMeYourScore(){
            return score +.0f;
        }

        public String toString() {
            return name + ":  " + score + "\n";
        }
    }

}
