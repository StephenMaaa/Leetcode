package Airbnb;

public class HilbertCurve {
    public int hilbertCurve(int x, int y, int iter) {
        if (iter == 0) {
            return 1;
        }

        int count = 1 << (2 * (iter - 1));
        int len = 1 << (iter - 1);
        System.out.println(count + " " + len);

        if (x >= len && y >= len) {
            // top-right
            //右上角板块，从起点板块需要跨过两个板块到达
            return 2 * count + hilbertCurve(x - len, y - len, iter - 1);
        } else if (x < len && y >= len) {
            // top-left
            //左上角板块，从起点板块需要跨过一个板块到达
            return count + hilbertCurve(x, y - len, iter - 1);
        } else if (x < len && y < len) {
            // bottom-left
            //左下角起点板块，不需要跨过板块了，只需要rotation一下
            return hilbertCurve(y, x, iter - 1);
        } else {
            // bottom-right
            //右下角板块，从起点需要跨过三个板块到达，同时还需要rotation
            //用y = -x 对称，然后移动会起点
            //做法是（x, y) => (-y, -x) => 向右移动len - 1，向上移动2* len - 1来移动回应该在的范围，其实就是rotation
            return 3 * count + hilbertCurve(len - 1 - y, 2 * len - 1 - x, iter - 1);
        }
    }

    public static void main(String[] args) {
        HilbertCurve test = new HilbertCurve();
        System.out.println(test.hilbertCurve(1, 1, 3));
    }
}
