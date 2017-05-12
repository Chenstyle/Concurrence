/**
 * @author Chenstyle
 *         2017/2/7 0007
 *         初始 男 1 女 5
 *
 *         女人初始点 7 男人没有
 *         每人上限 10
 *         口交 2P 中出 3P
 *         男人每天最多贡献 7 男人 7 次后，每次得到 1
 *         消费 1 吃饭 （无法分食）
 *         生存点为 0 的女人会 3 小时剧痛而死
 *         无法自杀
 *         女人死亡超过 3 个，男人死亡
 *         15 天没有死亡，全员解放
 */
public class LiveGame {

    public static void Main(String[] args) {

        Man mMan = new Man();
        Woman[] mWomen = {new Woman(), new Woman(), new Woman(), new Woman(), new Woman()};
    }
}

class Person {
    private int mLivePoint = 0;

    public int getLivePoint() {
        return mLivePoint;
    }

    public void setLivePoint(int livePoint) {
        mLivePoint = livePoint;
    }

    public void addPoint(int point) {
        mLivePoint += point;
        if (mLivePoint >= 10) {
            mLivePoint = 10;
        }
    }
}

class Man extends Person {

}

class Woman extends Person {
}