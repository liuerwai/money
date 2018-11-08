package com.liuxg.money.dao.impl;

import com.liuxg.money.constant.CheckType;
import com.liuxg.money.dao.ICheckDao;
import com.liuxg.money.po.Check;
import com.liuxg.money.utils.CheckSerializerUtills;

import java.util.Calendar;
import java.util.Date;

public class CheckDaoImpl implements ICheckDao {

    @Override
    public void consumer(Double money) {

        if(money > 0){
            money = -money;
        }
        this.save(money, CheckType.consume.name());
    }

    @Override
    public void consumer(Double installment, int period) {

        for (int i = 0; i < period; i++){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, i);
            if(installment > 0){
                installment = -installment;
            }
            this.save(installment, CheckType.consume.name(), calendar.getTime());
        }
    }

    @Override
    public void income(Double money) {

        if(money < 0){
            money = -money;
        }
        this.save(money, CheckType.income.name());
    }

    @Override
    public void forget(Double money) {

        this.save(money, CheckType.forget.name());
    }

    @Override
    public void addWish(Double money, String name) {

        Check check = new Check();
        check.setMoney(money);
        check.setType(CheckType.wish.name());
        check.setName(name);
    }

    private void save(Double money, String type){

        this.save(money, type, new Date());
    }

    private void save(Double money, String type, Date date){

        Check check = new Check();
        check.setType(type);
        check.setMoney(money);
        check.setTime(date);
        CheckSerializerUtills.saveCheck(check);
    }



}
