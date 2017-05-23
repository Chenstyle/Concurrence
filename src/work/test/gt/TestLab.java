package work.test.gt;

import java.util.List;

/**
 * @author Chenstyle
 *         2017-5-12
 */
public class TestLab {

    private String mName;

    private List<ChildX> mChildXes;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<ChildX> getChildXes() {
        return mChildXes;
    }

    public void setChildXes(List<ChildX> childXes) {
        mChildXes = childXes;
    }

    public static class ChildX {
        private String mName;

        private List<Child> mChildes;

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public List<Child> getChildes() {
            return mChildes;
        }

        public void setChildes(List<Child> childes) {
            mChildes = childes;
        }

        public static class Child {
            private String mName;

            public String getName() {
                return mName;
            }

            public void setName(String name) {
                mName = name;
            }
        }
    }
}
