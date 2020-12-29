package designer.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe: 场景描述:超时购物收银
 * 购买了两双鞋，1块面包，拿了一个购物袋
 * @author:zqm
 */
public class CompositePatternDemo2 {

    public static void main(String[] args) {
        Goods shoes = new Goods(10, 2, "拖鞋");
        Goods bread = new Goods(5, 1, "面包");
        Goods bag = new Goods(1, 1, "袋子");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addGoods(shoes);
        shoppingCart.addGoods(bread);
        shoppingCart.addGoods(bag);
        shoppingCart.show();
        System.out.println("合计" + shoppingCart.calculation());

    }


    /**
     * 接口功能:计算价格和展示明细
     */
    interface Articles {
        //计算
        float calculation();

        void show();
    }

    /**
     * 产品抽象类，包含属性单价，数量以及名称
     */
    static class Goods implements Articles {

        private float price;

        private int num;

        private String name;

        public Goods() {
        }

        public Goods(float price, int num, String name) {
            this.price = price;
            this.num = num;
            this.name = name;
        }

        @Override
        public float calculation() {
            return num * price;
        }

        @Override
        public void show() {
            System.out.println(name + "（ 数量是:" + num + "单价是:" + price + ")");
        }


        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 购物车抽象类 个功能:添加物品/移除物品
     */
    static class ShoppingCart implements Articles {
        private List<Articles> list = new ArrayList<>();


        public void addGoods(Articles articles) {
            list.add(articles);
        }


        public void removeGoods(Articles articles) {
            list.remove(articles);
        }


        public List<Articles> getList() {
            return list;
        }

        public void setList(List<Articles> list) {
            this.list = list;
        }

        @Override
        public float calculation() {
            float totalPrice = 0;
            for (Articles articles : list) {
                totalPrice += articles.calculation();
            }
            return totalPrice;
        }

        @Override
        public void show() {
            for (Articles articles : list) {
                articles.show();
            }
        }
    }

}




