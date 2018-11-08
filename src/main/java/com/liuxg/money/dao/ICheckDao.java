package com.liuxg.money.dao;

public interface ICheckDao {

    /**
     * 消费
     * @param money
     */
    public void consumer(Double money);

    /**
     * 分期消费
     * @param installment
     * @param period
     */
    public void consumer(Double installment, int period);

    /**
     * 收入
     * @param money
     */
    public void income(Double money);

    /**
     * 补录
     * @param money
     */
    public void forget(Double money);

    /**
     * 增加购买愿望
     * @param money
     * @param name
     */
    public void addWish(Double money, String name);

    /**
     * 实现愿望
     * @param name
     */
    public void achieveWish(String name);

    /**
     * 放弃愿望
     * @param name
     */
    public void discardWish(String name);

}
