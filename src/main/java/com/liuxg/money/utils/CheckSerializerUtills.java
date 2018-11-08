package com.liuxg.money.utils;

import com.liuxg.money.po.Check;

import java.util.ArrayList;
import java.util.List;

public class CheckSerializerUtills {

    public final static String checkPath = CheckSerializerUtills.class.getClassLoader().getResource("").getPath() + "../../../data/checkList.ser";

    /**
     * 获取账单
     *
     * @return
     */
    public static List<Check> getCheckList() {

        List<Check> list = (List<Check>) SerializerUtills.get(checkPath);
        if (list == null) {
            return new ArrayList<Check>();
        }
        return list;
    }

    /**
     * 保存账单
     * @param check
     * @return
     */
    public synchronized static int saveCheck(Check check) {

        List<Check> list = getCheckList();
        list.add(check);
        return SerializerUtills.save(list, checkPath);
    }


}
