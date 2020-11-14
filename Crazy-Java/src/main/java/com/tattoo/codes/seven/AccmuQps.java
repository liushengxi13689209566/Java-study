package com.tattoo.codes.seven;

import java.util.Scanner;

public class AccmuQps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("1. com.sankuai.zeus.accumulate");
                    while (true) {
                        //1. com.sankuai.zeus.accumulate
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("北京地区需要机器数目：" + qps * 44099 / (44099 + 4450) * 2 / 260);
                        System.out.println("上海地区需要机器数目：" + qps * 4450 / (44099 + 4450) * 2 / 30);
                    }
                case 2:
                    System.out.println("2. com.sankuai.rc.zeus");
                    while (true) {
                        //2. com.sankuai.rc.zeus
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("北京地区需要机器数目：" + qps * 40869 / (40869 + 14688) * 2 / 500);
                        System.out.println("上海地区需要机器数目：" + qps * 14688 / (40869 + 14688) * 2 / 68);
                    }
                case 3:
                    System.out.println("3. com.sankuai.rc.zeus.groupa");
                    while (true) {
                        //3. com.sankuai.rc.zeus.groupa
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("没有上海区域，北京地区需要机器数目：" + qps * 2 / 400);
                    }
                case 4:
                    System.out.println("4. com.sankuai.rc.zeus.groupc");
                    System.out.println("groupc  QPS 指数几乎不变，根据 cpu.busy 移动平均配置即可");
                    break;
                case 5:
                    System.out.println("5. com.sankuai.rc.zeus.groupe");
                    while (true) {
                        //5. com.sankuai.rc.zeus.groupe
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("没有上海区域，北京地区需要机器数目：" + qps * 2 / 270);
                    }
                case 6:
                    System.out.println("6. com.sankuai.rc.zeus.groupf");
                    while (true) {
                        //6. com.sankuai.rc.zeus.groupf
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("没有上海区域，北京地区需要机器数目：" + qps * 2 / 300);
                    }
                case 7:
                    System.out.println("7. com.sankuai.zeus.ugc");
                    while (true) {
                        //7. com.sankuai.zeus.ugc
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("北京机器很少，忽略。上海地区需要机器数目：" + qps * 2 / 190);
                    }
                case 8:
                    System.out.println("8. com.sankuai.rc.zeus.latency");
                    while (true) {
                        //8. com.sankuai.rc.zeus.latency
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("北京机器很少，忽略。上海地区需要机器数目：" + qps * 2 / 7.5);
                    }
                case 9:
                    System.out.println("9. com.sankuai.rc.zeus.worker");
                    System.out.println(" Global 型 分组 ");
                    while (true) {
                        //9. com.sankuai.rc.zeus.worker
                        System.out.println("请输入此时刻 QPS：");
                        double qps = sc.nextDouble();
                        System.out.println("需要机器数目：" + qps * 2 / 230);
                        System.out.println("多出来的饿机器数目：" + (582 - (qps * 2 / 230)));
                    }
            }
        }
    }
}
