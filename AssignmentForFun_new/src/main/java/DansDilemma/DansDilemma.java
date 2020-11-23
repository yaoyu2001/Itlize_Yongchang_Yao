package DansDilemma;

import java.util.HashSet;
import java.util.Set;

public class DansDilemma {

    public Integer dilemmaOfTwo(Double input1, Double input2) {
        Set<Double> res = new HashSet<Double>();
        res.add(input1 + input2);
        res.add(input1 * input2);
        res.add(input1 - input2);
        res.add(input1 / input2);
        res.add(input2 - input1);
        res.add(input2 / input1);
        return res.size();
    }

    public Integer dilemmaOfThree(Double input1, Double input2, Double input3) {
        Double [] args = {input1, input2, input3};
        Set<Double> res = new HashSet<Double>();
        for (int i = 0; i < args.length ; i++) {
            for (int j = i + 1; j < args.length ; j++) {
                res.add(args[i] + args[j]);
                res.add(args[i] * args[j]);
                res.add(args[i] - args[j]);
                res.add(args[i] / args[j]);
                res.add(args[j] - args[i]);
                res.add(args[j] / args[i]);
            }
        }
        return res.size();
    }

    public Integer dilemmaOfN(Double... args){
        Set<Double> res = new HashSet<Double>();
        for (int i = 0; i < args.length ; i++) {
            for (int j = i + 1; j < args.length ; j++) {
                res.add(args[i] + args[j]);
                res.add(args[i] * args[j]);
                res.add(args[i] - args[j]);
                res.add(args[i] / args[j]);
                res.add(args[j] - args[i]);
                res.add(args[j] / args[i]);
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
        DansDilemma d = new DansDilemma();
        System.out.println(d.dilemmaOfTwo(43141351915321531d,143115.3914319413));
        System.out.println(d.dilemmaOfN(4d,5d));
        System.out.println(d.dilemmaOfThree(1d,2d,3d));
    }
}
