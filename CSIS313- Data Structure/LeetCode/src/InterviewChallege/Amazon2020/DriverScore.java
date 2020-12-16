package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class DriverScore {

    static class PairId{
        int id;
        double score;
        public PairId() {}
        public PairId(int id, double score){
            this.id = id;
            this.score = score;
        }
    }

    public DriverScore(){}

  /*  public static void calculateHighestFive(int scoreCount, ArrayList<PairId> testScores){
        Map<Integer, Double> result = new HashMap<>();
        Map<Integer, List<Double>> map = new HashMap<>();

        for(PairId drive : testScores){
            int id = drive.id;
            double score = drive.score;
            if(!map.containsKey(id)){
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(score);
        }
        for(int k : map.keySet()){
            List<Double> scores = map.get(k);
            Collections.sort(scores);
            double sum = 0;
            int n = scores.size();
            for(int i=n-1; i>n-6; i--){
                sum += scores.get(i);
            }
            result.put(k, sum/5.0);
            System.out.println(k + " " + sum/5.0);
        }
    }

   */
  public static void calculateHighestFive(int scoreCount, ArrayList<PairId> testScores){
      Map<Integer, PriorityQueue<Double>> result = new HashMap<>();
      Comparator<Double> maxQ = new Comparator<Double>() {
          @Override
          public int compare(Double o1, Double o2) {
              return (o1 > o2 ? 1 : -1);
          }
      };

      for(PairId  driver : testScores){
          int id = driver.id;
          double score = driver.score;
          if(!result.containsKey(id)){
              result.put(id, new PriorityQueue<>(maxQ));
          }
          result.get(id).add(score);
          if(result.get(id).size() > 5){
              result.get(id).poll();
          }
      }
      Map<Integer, Double> ans = new HashMap<>();
      for(int id : result.keySet()){
          double sum = 0.0;
          while(!result.get(id).isEmpty()){
              sum += result.get(id).poll();
          }
          ans.put(id, sum/5.0);
          System.out.println(id + " " + sum/5.0);
      }
  }

    public static void main(String args[]) throws IOException {
        DriverScore driverScore = new DriverScore();
        ArrayList<PairId> testScores = new ArrayList<>();
        testScores.add(new PairId(1, 4.0));
        testScores.add(new PairId(2, 9.0));
        testScores.add(new PairId(1, 5.0));
        testScores.add(new PairId(2, 8.0));
        testScores.add(new PairId(1, 6.0));
        testScores.add(new PairId(1, 7.0));
        testScores.add(new PairId(1, 8.0));
        testScores.add(new PairId(1, 9.0));

        testScores.add(new PairId(1, 10.0));
        testScores.add(new PairId(2, 9.5));
        testScores.add(new PairId(2, 10.0));
        testScores.add(new PairId(2, 5.0));


        int scoreCount = 13;
        driverScore.calculateHighestFive(scoreCount,  testScores);
    }
}
