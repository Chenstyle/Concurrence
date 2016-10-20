package learning.effective;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 15:53
 */
public class AnimalHead {
    private final int mouth;
    private final int eye;
    private final int nose;
    private final int ear;

    public static class Builder {
        // 必要参数
        private final int mouth;

        // 可选参数
        private int eye  = 0;
        private int nose = 0;
        private int ear  = 0;

        public Builder(int mouth) {
            this.mouth = mouth;
        }

        public Builder eye(int val) {
            eye = val;
            return this;
        }

        public Builder nose(int val) {
            nose = val;
            return this;
        }

        public Builder ear(int val) {
            ear = val;
            return this;
        }

        public AnimalHead build() {
            return new AnimalHead(this);
        }
    }

    private AnimalHead(Builder builder) {
        mouth = builder.mouth;
        eye   = builder.eye;
        nose  = builder.nose;
        ear   = builder.ear;

        thisHead();
    }

    private void thisHead() {
        System.out.println(String.format("Something hava %d mouth, %d eye, %d nose, %d ear.", mouth, eye, nose, ear));
    }
}
