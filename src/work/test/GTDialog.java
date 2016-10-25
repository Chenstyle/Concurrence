package work.test;

/**
 * @author Chenstyle
 * @date 2016/10/24 0024
 * @time 9:17
 */
public class GTDialog {
    private final String mTitle; // 标题文字
    private final String mContent; // 内容文字
    private final String mOneBtn; // 一个按钮时的文字
    private final String mLeftText; // 左按钮文字
    private final String mRightText; // 右按钮文字

    public static class Builder {
        // 必要参数
        private final String mTitle;
        private final String mContent;

        // 可选参数 - 初始化为默认值
        private String mOneBtn = "确定";
        private String mLeftText = "取消";
        private String mRightText = "确定";

        public Builder(String title, String content) {
            mTitle = title;
            mContent = content;
        }

        public Builder setOneBtn(String oneBtn) {
            mOneBtn = oneBtn;
            return this;
        }

        public Builder setLeftText(String leftText) {
            mLeftText = leftText;
            return this;
        }

        public Builder setRightText(String rightText) {
            mRightText = rightText;
            return this;
        }

        public GTDialog build() {
            return new GTDialog(this);
        }
    }

    private GTDialog(Builder builder) {
        mTitle = builder.mTitle;
        mContent = builder.mContent;
        mOneBtn = builder.mOneBtn;
        mLeftText = builder.mLeftText;
        mRightText = builder.mRightText;
    }
}
