import java.util.*;

public class ChocolaProblem {
//1). Use all The Cuts --> imp*(Oders OF Cuts).
//2). After Each Cuts  --> Chocolate pieces increase.
//3). first --> Expensive Cuts,  then => Cheap Cuts.
//4). Total Cost = (cost of ver. Cuts + cost of hor. Cuts)
//5). Cost OF Ver. = hor. pieces * x ( | )
//5). Cost OF Hor. = ver. pieces * y (---)
                                            

    public static void main(String[] args) {
        // int n=4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h =0 , v=0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v< costVer.length) {
            
            if (costVer[v] <= costHor[h]) {//Horizontal Cuts

                cost += (costHor[h] * vp);
                hp++;
                h++;

            }else{//Vertical Cuts

                cost += (costVer[v] * hp);
                vp++;
                v++;

            }
        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Min cost of the cuts: "+ cost);
    }
    
}
