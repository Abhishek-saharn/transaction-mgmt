package com.n26.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Statistic {
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private Long count;

    public Statistic(BigDecimal sum, BigDecimal avg, BigDecimal max, BigDecimal min, Long count) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Map<String, Object> getResponseObj()
    {
        String pattern = "#0.00";
        DecimalFormat responseFormatter = new DecimalFormat(pattern);

        Map<String,Object> responseObj = new HashMap<>();
        responseObj.put("sum",responseFormatter.format(this.getSum()));
        responseObj.put("avg", responseFormatter.format(this.getAvg()));
        responseObj.put("max", responseFormatter.format(this.getMax()));
        responseObj.put("min", responseFormatter.format(this.getMin()));
        responseObj.put("count",this.getCount());
        return  responseObj;
    }
}
