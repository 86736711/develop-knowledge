package com.npf.knowledge.demo.design.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.iterator
 * @ClassName: DataDisposeIterator
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/7 11:28
 * @Version: 1.0
 */
public class DataDisposeIterator implements DisposeIterator {


    public List<Dispose> disposes = new ArrayList<>();

    @Override
    public void addDispose(Dispose dispose){
        disposes.add(dispose);
    }

    @Override
    public void sort() {
        Collections.sort(disposes);
    }

    @Override
    public void disposeIterator(String data) {
        for (Dispose dispose:disposes) {
            if(!dispose.disposeDate(data)){
                return;//阻断式迭代
            }
        }
    }
}
