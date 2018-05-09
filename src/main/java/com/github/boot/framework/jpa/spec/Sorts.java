package com.github.boot.framework.jpa.spec;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;


/**
 * 排序构建工具
 * @author chenjianhui
 * @date 2017/05/24
 */
public class Sorts {

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<Order> orders;

        public Builder() {
            this.orders = new ArrayList<Order>();
        }

        public Builder asc(String property) {
            return asc(true, property);
        }

        public Builder desc(String property) {
            return desc(true, property);
        }

        public Builder asc(boolean condition, String property) {
            if (condition) {
                orders.add(new Order(ASC, property));
            }
            return this;
        }

        public Builder desc(boolean condition, String property) {
            if (condition) {
                orders.add(new Order(DESC, property));
            }
            return this;
        }

        public Sort build() {
            return new Sort(orders);
        }
    }
}
